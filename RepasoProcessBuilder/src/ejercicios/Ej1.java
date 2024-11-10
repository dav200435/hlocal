package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej1 {

    public static void main(String[] args) throws IOException {
        
        ProcessBuilder pro = new ProcessBuilder("cmd.exe", "/c", "find /c /v \"\" fichero.java");
        Process p = pro.start();
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        
        while ((line = bf.readLine()) != null) {
            System.out.println(line);
        }
    }
}
