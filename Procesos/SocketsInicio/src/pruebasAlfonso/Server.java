package pruebasAlfonso;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int puerto = 12345;

        try (ServerSocket servidorSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor escuchando en el puerto " + puerto + "...");

            while (true) {
                Socket clienteSocket = servidorSocket.accept();
                System.out.println("Conexión establecida con " + clienteSocket.getInetAddress());

                // Flujos de entrada y salida
                BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
                PrintWriter salida = new PrintWriter(clienteSocket.getOutputStream(), true);

                // Recibir el directorio del cliente
                String directorio = entrada.readLine();
                System.out.println("Recibida solicitud para listar: " + directorio);

                // Listar el directorio
                File archivoDirectorio = new File(directorio);
                String[] archivos = archivoDirectorio.list();
                String resultado;

                if (archivos != null) {
                    resultado = String.join("\n", archivos);
                } else {
                    resultado = "El directorio no existe o no es un directorio válido.";
                }

                // Enviar el resultado al cliente
                salida.println(resultado);
                clienteSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
