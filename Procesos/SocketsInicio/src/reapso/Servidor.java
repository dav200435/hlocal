package reapso;


import java.io.*;   // Importar clases para la entrada y salida de datos
import java.net.*;  // Importar clases para trabajar con sockets y redes

public class Servidor {
    public static void main(String[] args) {
    	int port = 12345;
        boolean running = true;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor escuchando en el puerto 5000...");
            while (running) {
            	Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado");

                try (
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
                    ) {
                        String mensaje;
                        while ((mensaje = in.readLine()) != null) {
                            System.out.println("Cliente dice: " + mensaje);

                            if (mensaje.equalsIgnoreCase("fin")) {
                                out.println("Conexión terminada. Adiós.");
                                running = false;
                            }

                            out.println("Echo: " + mensaje);
                        }
                    } catch (IOException e) {
                        System.err.println("Error al manejar cliente: " + e.getMessage());
                    } finally {
                        clientSocket.close();
                        System.out.println("Conexión cerrada con el cliente.");
                    }
                System.out.println("El servidor ha finalizado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
