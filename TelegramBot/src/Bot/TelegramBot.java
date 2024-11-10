package Bot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class TelegramBot {

    private static final String TOKEN = "7796032247:AAGbLupiH9gSGkHbg2PNu6TLaqdKx44Os4c";
    private static final String CHAT_ID = "5482275054";

    public static void main(String[] args) {
        String procesos = obtenerProcesosActivos();
        enviarMensajeTelegram(procesos);
    }

    private static String obtenerProcesosActivos() {
        StringBuilder result = new StringBuilder();
        try {
            ProcessBuilder builder = new ProcessBuilder("powershell.exe", "-Command", "Get-Process");
            builder.redirectErrorStream(true);
            
            Process process = builder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }

            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al obtener los procesos.";
        }
        return result.toString();
    }

    private static void enviarMensajeTelegram(String mensaje) {
        try {
            int maxLength = 4096;
            for (int i = 0; i < mensaje.length(); i += maxLength) {
                String parte = mensaje.substring(i, Math.min(mensaje.length(), i + maxLength));
                enviarParteTelegram(parte);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void enviarParteTelegram(String mensaje) {
        try {
            URL url = new URL("https://api.telegram.org/bot" + TOKEN + "/sendMessage");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            String jsonInputString = "{\"chat_id\":\"" + CHAT_ID + "\", \"text\":\"" + mensaje + "\"}";

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                    StringBuilder response = new StringBuilder();
                    String responseLine;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                    System.out.println("Respuesta de Telegram: " + response.toString());
                }
            } else {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getErrorStream(), "utf-8"))) {
                    StringBuilder errorResponse = new StringBuilder();
                    String errorLine;
                    while ((errorLine = br.readLine()) != null) {
                        errorResponse.append(errorLine.trim());
                    }
                    System.out.println("Error en la respuesta de Telegram: " + errorResponse.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}