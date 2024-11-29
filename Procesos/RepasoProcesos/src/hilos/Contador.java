package hilos;

public class Contador extends Thread {
    private static int contador = 0;

    public Contador() {
        super();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            incrementar();
        }
    }

    public synchronized void incrementar() {
        contador++;
        System.out.println(contador);
    }

    public static void main(String[] args) {
        Contador hilo1 = new Contador();
        Contador hilo2 = new Contador();
        Contador hilo3 = new Contador();

        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}
