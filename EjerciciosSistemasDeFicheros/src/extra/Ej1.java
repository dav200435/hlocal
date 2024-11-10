package extra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ej1 {
    private File file;

    public Ej1(String ruta) {
        this.file = new File(ruta);
    }

    public void analyze() throws IOException {
    	Scanner sc = new Scanner(System.in);
    	String choice;
    	
        if (this.file.exists()) {
            if (this.file.isFile()) {
                System.out.println(this.file.toString() + " es un archivo.");
                
                System.out.println("Desea ver el contenido? s/n");
                choice = sc.nextLine();
                
                if (choice.toLowerCase().equalsIgnoreCase("s")) {
                	FileReader fr = new FileReader(this.file);
                    BufferedReader br = new BufferedReader(fr);
                    String text;
                    while ((text = br.readLine()) != null) {
                    	System.out.println(text.toString());
                    }	
                    br.close();
                }
                
                
            }
            else if (this.file.isDirectory()) {
                System.out.println(this.file.toString() + " es un directorio.");
                System.out.println("Desea ver el contenido? s/n");
                choice = sc.nextLine();
                if (choice.toLowerCase().equalsIgnoreCase("s")) {
                	ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "dir", this.file.toString());

					Process process = processBuilder.start();
					BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
					String line;
			        while ((line = reader.readLine()) != null) {
			            System.out.println(line);
			        }
                }
                
            }
        }else {
        	System.out.println(this.file.toString() + " no existe en el equipo.");
        }
    }
}
