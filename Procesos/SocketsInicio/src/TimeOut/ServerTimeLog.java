package TimeOut;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.time.LocalDateTime;

public class ServerTimeLog {
    private static final String LOG_PATH = "./src/TimeOut/log/server.log";
    private static final int SOCKET_TIMEOUT = 10000; // Timeout de 10 segundos para aceptar conexiones

    private static void log(String message) {
        try (FileWriter logWriter = new FileWriter(LOG_PATH, true)) {
            logWriter.write(LocalDateTime.now() + " - " + message + "\n");
        } catch (IOException e) {
            System.err.println("Error al escribir en el log del servidor: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            serverSocket.setSoTimeout(SOCKET_TIMEOUT); // Configurar timeout
            log("Servidor iniciado y esperando conexiones en el puerto 12345 con un timeout de " + SOCKET_TIMEOUT / 1000 + " segundos.");

            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept(); // Esperar conexión
                    log("Conexión aceptada desde: " + clientSocket.getInetAddress());

                    try (
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
                    ) {
                        String clientMessage = in.readLine();
                        log("Mensaje recibido del cliente: " + clientMessage);

                        out.println("Hola, cliente!");
                        log("Respuesta enviada al cliente: Hola, cliente!");
                    } catch (IOException e) {
                        log("Error al manejar la comunicación con el cliente: " + e.getMessage());
                    }

                } catch (SocketTimeoutException e) {
                    log("Timeout: No se recibieron conexiones dentro del tiempo esperado.");
                }
            }
        } catch (IOException e) {
            log("Error al iniciar el servidor: " + e.getMessage());
        }
    }
}
