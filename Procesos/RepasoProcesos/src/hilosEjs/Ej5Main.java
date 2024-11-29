package hilosEjs;

public class Ej5Main {
    public static void main(String[] args) {
        Cola cola = new Cola(5);
        Thread productorThread = new Thread(new Ej5Productor(cola));
        Thread consumidorThread = new Thread(new Ej5Consumidor(cola));

        productorThread.start();
        consumidorThread.start();
    }
}
