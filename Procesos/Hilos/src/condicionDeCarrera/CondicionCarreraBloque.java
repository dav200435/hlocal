package condicionDeCarrera;

public class CondicionCarreraBloque implements Runnable{
	private int contador = 0;

    public void incrementar() {
    	synchronized (this) {
    		contador++;
    	}
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            incrementar();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CondicionCarreraBloque cc = new CondicionCarreraBloque();
        Thread hilo1 = new Thread(cc);
        Thread hilo2 = new Thread(cc);

        hilo1.start();
        hilo2.start();

        hilo1.join();
        hilo2.join();

        System.out.println("Valor final del contador: " + cc.contador);
    }
}

