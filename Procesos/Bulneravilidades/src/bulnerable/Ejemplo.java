package bulnerable;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Ejemplo {
    public static void main(String[] args) throws IOException {
        String userInput = args[0];

        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "echo", userInput);
        Process process = processBuilder.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
