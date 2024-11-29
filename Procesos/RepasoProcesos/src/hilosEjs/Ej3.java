package hilosEjs;

public class Ej3 extends Thread {
    private int pasos;
    private String name;
    private int LIMITE = 50;

    public Ej3(String name) {
        super();
        this.pasos = 0;
        this.name = name;
    }

    @Override
    public void run() {
        while (pasos < LIMITE) {
            pasos++;
            System.out.println(this.name + " Va por el paso: " + this.pasos);
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.name + " Termino");
    }

    public static void main(String[] args) {
        Ej3 hilo1 = new Ej3("Hilo 1");
        Ej3 hilo2 = new Ej3("Hilo 2");
        Ej3 hilo3 = new Ej3("Hilo 3");

        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}
