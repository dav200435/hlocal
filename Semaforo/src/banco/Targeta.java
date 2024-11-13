package banco;

import java.util.concurrent.Semaphore;

public class Targeta extends Thread {
    private final CuentaBancaria cuenta;
    private static final Semaphore semaforo = new Semaphore(1);

    public Targeta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                semaforo.acquire();

                boolean esDeposito = Math.random() < 0.5;
                double cantidad = Math.random() * 200;

                if (esDeposito) {
                    cuenta.ingresar(cantidad);
                } else {
                    cuenta.retirar(cantidad);
                }

                Thread.sleep((long) (Math.random() * 1000));
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaforo.release();
            }
        }
    }
}
