package processBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejemploFind {
    public ejemploFind() {
    }

    public void contador() {
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "find /c /v \"\" ejemplo.txt");
        
        try {
            Process p = pb.start();
            
            BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = bf.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ejemploFind ej = new ejemploFind();
        ej.contador();
    }
}

