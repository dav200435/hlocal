package ftp.server;

//Servidor.java
import java.io.*;
import java.net.*;

public class Server {
 public static void main(String[] args) {
     int puerto = 12345;
     try (ServerSocket servidorSocket = new ServerSocket(puerto)) {
         System.out.println("Servidor iniciado en el puerto " + puerto);

         while (true) {
             System.out.println("Esperando conexión de cliente...");
             Socket clienteSocket = servidorSocket.accept();
             System.out.println("Cliente conectado desde " + clienteSocket.getInetAddress().getHostAddress());

             DataOutputStream salida = new DataOutputStream(clienteSocket.getOutputStream());

             String rutaArchivo = "./resources/fichero.txt";
             File archivo = new File(rutaArchivo);

             if (archivo.exists()) {
                 salida.writeUTF("OK");

                 long tamanoArchivo = archivo.length();
                 salida.writeLong(tamanoArchivo);
                 
                 FileInputStream fileInput = new FileInputStream(archivo);
                 byte[] buffer = new byte[4096];
                 int bytesLeidos;

                 while ((bytesLeidos = fileInput.read(buffer)) != -1) {
                     salida.write(buffer, 0, bytesLeidos);
                 }

                 fileInput.close();
                 System.out.println("Archivo enviado: " + rutaArchivo);
             } else {
                 salida.writeUTF("ERROR: Archivo no encontrado");
                 System.out.println("El archivo no existe: " + rutaArchivo);
             }

             clienteSocket.close();
             System.out.println("Cliente desconectado");
         }
     } catch (IOException e) {
         e.printStackTrace();
     }
 }
}