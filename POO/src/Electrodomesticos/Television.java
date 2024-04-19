package Electrodomesticos;

public class Television extends Electrodomestico {

    private double resolucion;
    private boolean sintonizadorTDT;

    public Television() {
        super();
        this.resolucion = 20;
        this.sintonizadorTDT = false;
    }

    public Television(double precioBase, double peso) {
        super(precioBase, peso);
        this.resolucion = 20;
        this.sintonizadorTDT = false;
    }

    public Television(double resolucion, boolean sintonizadorTDT, double precioBase, double peso, String color, char consumoEnergetico){
        super(precioBase, peso, color, consumoEnergetico);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    public double getResolucion() {
        return resolucion;
    }

    public boolean getSintenizadorTDT() {
        return sintonizadorTDT;
    }

    @Override
    public double precioFinal() {
        double precioFinal = super.precioFinal();

        if (resolucion > 40) {
            precioFinal += precioFinal * 1.3;
        }

        if (sintonizadorTDT) {
            precioFinal += 50;
        }

        return precioFinal;
    }
}
