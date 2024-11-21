package hilosEjs;

public class Ej1 extends Thread {
    
    public Ej1() {
        super();
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hola desde un Hilo");
            try {
                // Wait for 1 second before printing the next message
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        // Create an instance of the thread
        Ej1 hilo = new Ej1();
        // Start the thread
        hilo.start();
    }
}
