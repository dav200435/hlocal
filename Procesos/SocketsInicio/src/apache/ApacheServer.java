package apache;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ApacheServer {
	private int port=5555;

	public void connect() {
		try (ServerSocket socket = new ServerSocket(this.port)) {
			System.out.println("Servidor iniciado en el puerto 5555");
			while(true) {
				Socket socketClient = socket.accept();
				
				System.out.println("cliente conectado al puerto "+ socketClient.getInetAddress());
				new Thread(() -> handleClient(socketClient)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void handleClient(Socket socket) {
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream(),true)){
				String message ="";
				while ((message = reader.readLine()) != null) {
					System.out.println(message);
				}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ApacheServer server = new ApacheServer();
		server.connect();
	}
}
