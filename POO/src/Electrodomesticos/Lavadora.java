package Electrodomesticos;

public class Lavadora extends Electrodomestico {

    private double carga;

    public Lavadora() {
        super();
        this.carga = 5;
    }

    public Lavadora(double precioBase, double peso) {
        super(precioBase, peso);
        this.carga = 5;
    }

    public Lavadora(double carga, double precioBase, double peso, String color, char consumoEnergetico) {
        super(precioBase, peso, color, consumoEnergetico);
        this.carga = carga;
    }

    public Lavadora(Lavadora lavadora) {
        super(lavadora);
        this.carga = lavadora.carga;
    }

    public double getCarga() {
        return carga;
    }

    @Override
    public double precioFinal() {
        double precioFinal = super.precioFinal();

        if (carga > 30) {
            precioFinal += 50;
        }

        return precioFinal;
    }
}