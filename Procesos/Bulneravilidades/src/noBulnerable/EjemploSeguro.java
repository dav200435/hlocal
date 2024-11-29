package noBulnerable;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class EjemploSeguro {
    public static void main(String[] args) throws IOException {
        String userInput = args[0];

        if (containsDangerousCharacters(userInput)) {
            System.out.println("Invalid input detected. Removing dangerous characters.");
            userInput = sanitizeInput(userInput);
        }

        comand(userInput);
    }

    private static boolean containsDangerousCharacters(String input) {
        return input.contains("&") || input.contains("|") || input.contains(";") || input.contains(">");
    }

    private static String sanitizeInput(String input) {
        return input.replaceAll("&|;>", "");
    }

    private static void comand(String userInput) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "echo", userInput);
        Process process = processBuilder.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
