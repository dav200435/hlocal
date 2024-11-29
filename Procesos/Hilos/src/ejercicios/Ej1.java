package ejercicios;

import java.util.Random;

public class Ej1 extends Thread {
    private Random random;

    public Ej1(String name) {
        super(name);
        this.random = new Random();
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("mensaje " + i+" "+this.getName());
            try {
                Thread.sleep(random.nextInt(1000));  
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Ej1 h1 = new Ej1("hilo 1");
        Ej1 h2 = new Ej1("hilo 2");
        h1.start();
        h2.start();
    }
}
