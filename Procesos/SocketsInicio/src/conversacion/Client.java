package conversacion;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "192.168.20.203";
        int port = 12345; 
        Scanner sc = new Scanner(System.in);

        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Conectado al servidor");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            String message;
            while (true) {
                System.out.print("Escribe un mensaje 'fin' para terminar): ");
                message = sc.nextLine();

                out.println(message);

                if ("fin".equalsIgnoreCase(message)) {
                    System.out.println("Conexion terminada por el usuario.");
                    break;
                }

                String serverResponse = in.readLine();
                System.out.println("Respuesta del servidor: " + serverResponse);
            }
        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
} 