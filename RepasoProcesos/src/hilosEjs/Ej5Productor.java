package hilosEjs;

public class Ej5Productor implements Runnable {
    private Cola cola;

    public Ej5Productor(Cola cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        int valor = 0;
        try {
            while (true) {
                Thread.sleep(500);
                cola.put(valor);
                System.out.println("Productor produjo: " + valor);
                valor++;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}