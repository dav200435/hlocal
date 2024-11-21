package hilosEjs;

public class Ej5Consumidor implements Runnable {
    private Cola cola;

    public Ej5Consumidor(Cola cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                int valor = cola.take();
                System.out.println("Consumidor consumió: " + valor);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}