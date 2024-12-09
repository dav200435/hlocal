package conversacion;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "192.168.20.203"; // Dirección del servidor
        int port = 12345; // Puerto del servidor
        Scanner sc = new Scanner(System.in);

        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Conectado al servidor");

            // Flujos de entrada y salida
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            String message;
            while (true) {
                // Leer entrada del usuario
                System.out.print("Escribe un mensaje (escribe 'fin' para terminar): ");
                message = sc.nextLine();

                // Enviar mensaje al servidor
                out.println(message);

                // Finalizar el bucle si el usuario escribe "fin"
                if ("fin".equalsIgnoreCase(message)) {
                    System.out.println("Conexión terminada por el usuario.");
                    break;
                }

                // Leer respuesta del servidor
                String serverResponse = in.readLine();
                System.out.println("Respuesta del servidor: " + serverResponse);
            }
        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}