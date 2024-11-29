package Ejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythonLauncher {

    public static void main(String[] args) throws IOException, InterruptedException {

        ProcessBuilder processBuilder = new ProcessBuilder("python", "file.py");
        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();

        BufferedReader bf = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = bf.readLine()) != null) {
            System.out.println(line);
        }
    }
}
