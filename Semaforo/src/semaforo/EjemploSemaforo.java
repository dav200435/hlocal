package semaforo;
import java.util.concurrent.Semaphore;

public class EjemploSemaforo {
    private static final Semaphore semaforo = new Semaphore(2);

    static class Tarea implements Runnable {
        private final String nombre;
        private int contador = 0;

        public Tarea(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public void run() {
            while (contador <= 10) { 
                try {
                    semaforo.acquire();
                    
                    System.out.println(this.nombre + " contador: " + contador);
                    
                    contador ++;

                    Thread.sleep((long) (Math.random() * 1000));
                    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaforo.release();
                }
            }
            System.out.println(this.nombre + " ha terminado");
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 7; i++) {
            new Thread(new Tarea("Hilo " + i)).start();
        }
    }
}
