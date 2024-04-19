package Electrodomesticos;

import java.io.UnsupportedEncodingException;

public class Main {
	private static String toUTF8(String s) {

	    if (s != null) {

	        String ss;

	        try {

	            ss = new String(s.getBytes("ISO-8859-1"), "UTF-8");

	        } catch (UnsupportedEncodingException ex) {

	            ex.printStackTrace(System.out);

	            ss = null;

	        }

	        return ss;

	    } else {

	        return "";

	    }

	}
    public static void main(String[] args) {
    	
        Electrodomestico[] electrodomesticos = new Electrodomestico[10];

        electrodomesticos[0] = new Television(42, true, 800, 20, "Negro", 'A');
        electrodomesticos[1] = new Lavadora(8, 500, 60, "Rojo", 'B');
        electrodomesticos[2] = new Lavadora(10, 400, 0, "Azul", 'C');
        electrodomesticos[3] = new Television(32, false, 600, 15, "Blanco", 'D');
        electrodomesticos[4] = new Electrodomestico(150, 30, "Gris", 'E');
        electrodomesticos[5] = new Television(42, true, 800, 20, "Negro", 'A');
        electrodomesticos[6] = new Lavadora(8, 500, 60, "Rojo", 'B');
        electrodomesticos[7] = new Lavadora(10, 400, 0, "Azul", 'C');
        electrodomesticos[8] = new Television(32, false, 600, 15, "Blanco", 'D');
        electrodomesticos[9] = new Electrodomestico(150, 30, "Gris", 'E');

        double totalElectrodomesticos = 0;
        double totalTelevisiones = 0;
        double totalLavadoras = 0;
        double total = 0;
        

        for (int i=0;i< electrodomesticos.length;i++) {
            double precioFinal = electrodomesticos[i].precioFinal();
            total += precioFinal;

            if (electrodomesticos[i] instanceof Television) {
                totalTelevisiones += precioFinal;
            } else if (electrodomesticos[i] instanceof Lavadora) {
                totalLavadoras += precioFinal;
            }else {
            	totalElectrodomesticos += precioFinal;
            }

            System.out.println(toUTF8("Precio final: ") + precioFinal + " €");
        }
        System.out.println("\n "+toUTF8("Precio total de electrodomésticos: ") + totalElectrodomesticos + " €");
        System.out.println(toUTF8("Precio total de televisiones: ") + totalTelevisiones + " €");
        System.out.println(toUTF8("Precio total de lavadoras: ") + totalLavadoras + " €");
        System.out.println(toUTF8("Precio total de electrodomésticos: ") + total + " €");
    }
}