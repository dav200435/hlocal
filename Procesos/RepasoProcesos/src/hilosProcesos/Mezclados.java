package hilosProcesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mezclados implements Runnable {

    @Override
    public void run() {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "echo hola mundo");
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
        // Create Runnable instances
        Mezclados hilo1 = new Mezclados();
        Mezclados hilo2 = new Mezclados();
        Mezclados hilo3 = new Mezclados();

        // Create Thread objects and pass the Runnable instances
        Thread thread1 = new Thread(hilo1);
        Thread thread2 = new Thread(hilo2);
        Thread thread3 = new Thread(hilo3);

        // Start each thread
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
