package Electrodomesticos;
public class Electrodomestico {
    protected double precioBase;
    protected String color;
    protected char consumoEnergetico;
    protected double peso;

    private static final String[] colores = {"blanco", "negro", "rojo", "azul", "gris"};
    
    public Electrodomestico() {
    	this.precioBase=100.00;
        this.peso=5;
        this.color="Blanco";
        this.consumoEnergetico='F';
    }

    public Electrodomestico(double precioBase, double peso) {
        this.precioBase=precioBase;
        this.peso=peso;
        this.color="Blanco";
        this.consumoEnergetico='F';
    }

    public Electrodomestico(double precioBase, double peso, String color, char consumoEnergetico) {
    	this.precioBase=precioBase;
        this.peso=peso;
        this.color=color;
        this.consumoEnergetico=consumoEnergetico;
    }

    public Electrodomestico(Electrodomestico electrodomestico) {
        this.precioBase = electrodomestico.precioBase;
        this.color = electrodomestico.color;
        this.consumoEnergetico = electrodomestico.consumoEnergetico;
        this.peso = electrodomestico.peso;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public String getColor() {
        return color;
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public double getPeso() {
        return peso;
    }

    public void comprobarConsumoEnergetico(char letra) {
    	
        letra = Character.toUpperCase(letra);
        if (letra >= 'A' && letra <= 'F') {
            this.consumoEnergetico = letra;
        } else {
            this.consumoEnergetico = 'F';
        }
    }

    public void comprobarColor(String color) {
        
    	color = color.toLowerCase();
        if (ColorValido(color)) {
            this.color = color;
        } else {
            this.color = "Blanco";
        }
    }

    private boolean ColorValido(String color) {
        for (int i = 0;i<colores.length;i++) {
            if (colores[i].equals(color)) {
                return true;
            }
        }
        return false;
    }

    public double precioFinal() {
        double precioFinal = precioBase;

        switch (consumoEnergetico) {
            case 'A':
                precioFinal += 100;
                break;
            case 'B':
                precioFinal += 80;
                break;
            case 'C':
                precioFinal += 60;
                break;
            case 'D':
                precioFinal += 50;
                break;
            case 'E':
                precioFinal += 30;
                break;
            case 'F':
                precioFinal += 10;
                break;
        }

        if (peso >= 0 && peso < 19) {
            precioFinal += 10;
        } else if (peso >= 20 && peso < 49) {
            precioFinal += 50;
        } else if (peso >= 50 && peso < 79) {
            precioFinal += 80;
        } else if (peso >= 80) {
            precioFinal += 100;
        }

        return precioFinal;
    }
}
