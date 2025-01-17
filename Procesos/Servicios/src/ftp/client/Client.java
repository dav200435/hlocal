package ftp.client;

import java.io.*;
import java.net.*;
 
public class Client {
    public static void main(String[] args) {
        String servidor = "localhost";
        int puerto = 12345;
        String rutaDestino = "archivo_recibido.txt";
 
        try (Socket socket = new Socket(servidor, puerto)) {
            System.out.println("Conectado al servidor");
 
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
 
            String respuesta = entrada.readUTF();
            if ("OK".equals(respuesta)) {
                long tamanoArchivo = entrada.readLong();
                System.out.println("Recibiendo archivo de tamaño: " + tamanoArchivo + " bytes");
 
                FileOutputStream fileOutput = new FileOutputStream(rutaDestino);
                byte[] buffer = new byte[4096];
                int bytesLeidos;
                long bytesRecibidos = 0;
 
                while (bytesRecibidos < tamanoArchivo && (bytesLeidos = entrada.read(buffer)) != -1) {
                    fileOutput.write(buffer, 0, bytesLeidos);
                    bytesRecibidos += bytesLeidos;
                }
 
                fileOutput.close();
                System.out.println("Archivo recibido y guardado como: " + rutaDestino);
            } else {
                System.out.println("Error desde el servidor: " + respuesta);
            }
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
