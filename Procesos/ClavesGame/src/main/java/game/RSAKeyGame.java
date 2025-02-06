package game;

import java.security.*;
import javax.crypto.Cipher;
import java.util.Base64;
import java.util.Scanner;

public class RSAKeyGame {
    private KeyPair keyPair;

    public RSAKeyGame() throws Exception {
        this.keyPair = generateKeyPair();
    }

    private KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        return keyGen.generateKeyPair();
    }

    public String encrypt(String message) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public String decrypt(String encryptedMessage) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
        return new String(decryptedBytes);
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            RSAKeyGame game = new RSAKeyGame();
            
            System.out.println("Bienvenido al juego de claves RSA!");
            
            System.out.println("Ingresa un mensaje para cifrar:");
            String message = scanner.nextLine();
            
            System.out.println("¿Qué clave quieres usar para cifrar? (1: Pública, 2: Privada)");
            int encryptChoice = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            String encryptedMessage = "";
            if (encryptChoice == 1) {
                encryptedMessage = game.encrypt(message);
            } else {
                System.out.println("Solo puedes cifrar con la clave pública en RSA!");
                return;
            }
            
            System.out.println("Mensaje cifrado: " + encryptedMessage);
            
            System.out.println("¿Qué clave quieres usar para descifrar? (1: Pública, 2: Privada)");
            int decryptChoice = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            String decryptedMessage = "";
            if (decryptChoice == 2) {
                decryptedMessage = game.decrypt(encryptedMessage);
                System.out.println("Mensaje descifrado: " + decryptedMessage);
            } else {
                System.out.println("Solo puedes descifrar con la clave privada en RSA!");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
