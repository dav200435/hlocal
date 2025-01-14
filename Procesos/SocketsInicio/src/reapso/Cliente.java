package reapso;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
    	String ip = "192.168.8.185";
        int port = 8080;
        Scanner sc = new Scanner(System.in);
    	try (Socket socket = new Socket(ip, port)){

            System.out.println("Conectado al servidor");
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String message;
 
            while (true) {
            	System.out.println("escribe el mensaje 'fin' para salir");
            	message = sc.nextLine();
            	out.println(message);
            	if ("fin".equalsIgnoreCase(message)) {
                    System.out.println("Conexión terminada por el usuario.");
                    break;
                }
            	String serverResponse = in.readLine();
                System.out.println("Respuesta del servidor: " + serverResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
