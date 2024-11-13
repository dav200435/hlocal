package banco;

public class BancoMain {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("Alfonso", 1000);
        
        Targeta[] operaciones = new Targeta[3];
        for (int i = 0; i < operaciones.length; i++) {
            operaciones[i] = new Targeta(cuenta);
            operaciones[i].setName("Targeta " + (i + 1));
            operaciones[i].start();
        }

        for (Targeta operacion : operaciones) {
            try {
                operacion.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Saldo final en la cuenta: " + cuenta.getDinero());
    }
}
