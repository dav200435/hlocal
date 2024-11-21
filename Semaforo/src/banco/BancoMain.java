package banco;

public class BancoMain {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("Alfonso", 1000);
        
        Tarjeta[] operaciones = new Tarjeta[3];
        for (int i = 0; i < operaciones.length; i++) {
            operaciones[i] = new Tarjeta(cuenta);
            operaciones[i].setName("Tarjeta " + (i + 1));
            operaciones[i].start();
        }

        for (Tarjeta operacion : operaciones) {
            try {
                operacion.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Saldo final en la cuenta: " + cuenta.getDinero());
    }
}
