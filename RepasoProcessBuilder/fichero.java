package Ejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LanzadorProcesos {
	public static void main (String args[]) throws IOException {
		ProcessBuilder proce = new ProcessBuilder("cmd.exe","/c","echo","hola mundo");

			Process p = proce.start();

		ProcessBuilder pr = new ProcessBuilder("Powershell.exe");

			pr.start();

		BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String linea;
		while ((linea = bf.readLine())!= null) {
			System.out.println(linea);
		}
	}
}
