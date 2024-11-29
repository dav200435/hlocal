package banco;

public class CuentaBancaria {
    private String nombre;
    private double dinero;

    public CuentaBancaria(String nombre, double dinero) {
        this.nombre = nombre;
        this.dinero = dinero;
    }

    public synchronized void retirar(double cantidad) {
        if (cantidad <= this.dinero) {
            this.dinero -= cantidad;
            System.out.println(Thread.currentThread().getName() + " Retiró: " + cantidad + ". Saldo actual: " + this.dinero);
        } else {
            System.out.println(Thread.currentThread().getName() + " Saldo insuficiente para retirar " + cantidad);
        }
    }

    public synchronized void ingresar(double cantidad) {
        this.dinero += cantidad;
        System.out.println(Thread.currentThread().getName() + " Ingresó: " + cantidad + ". Saldo actual: " + this.dinero);
    }

    public synchronized double getDinero() {
        return dinero;
    }
}
