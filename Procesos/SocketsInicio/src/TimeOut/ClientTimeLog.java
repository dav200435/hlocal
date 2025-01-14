package TimeOut;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.time.LocalDateTime;

public class ClientTimeLog {
    private static final String LOG_PATH = "./src/TimeOut/log/client.log";
    private static final int CONNECTION_TIMEOUT = 5000; // Timeout de 5 segundos para conectarse al servidor

    private static void log(String message) {
        try (FileWriter logWriter = new FileWriter(LOG_PATH, true)) {
            logWriter.write(LocalDateTime.now() + " - " + message + "\n");
        } catch (IOException e) {
            System.err.println("Error al escribir en el log del cliente: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try (Socket socket = new Socket()) {
            log("Intentando conectarse al servidor en localhost:12345 con un timeout de " + CONNECTION_TIMEOUT / 1000 + " segundos.");

            // Intentar conexión con timeout
            socket.connect(new InetSocketAddress("localhost", 12345), CONNECTION_TIMEOUT);
            log("Conexión establecida con el servidor.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Hola, servidor!");
            log("Mensaje enviado al servidor: Hola, servidor!");

            System.out.println("Esperando respuesta del servidor...");
            String response = in.readLine();
            System.out.println("Respuesta del servidor: " + response);
            log("Respuesta recibida del servidor: " + response);

        } catch (SocketTimeoutException e) {
            log("Timeout: No se pudo establecer conexión con el servidor dentro del tiempo esperado.");
            System.out.println("Timeout: No se pudo establecer conexión con el servidor dentro del tiempo esperado.");
        } catch (IOException e) {
            log("Error en el cliente: " + e.getMessage());
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}
