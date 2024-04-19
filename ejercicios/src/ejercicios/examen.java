package ejercicios;

import java.util.Scanner;

	public class examen {
	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	boolean reset = true;
    	int negativos = 0;
    	int suma = 0;
    	int promedios = 0;
    	int contador = 0;
    	do{
    		System.out.print("inserta un numero: ");
    		int numero = sc.nextInt();
    		promedios = promedios + numero;
    		contador++;
    		if (numero < 0) {
    			negativos++;
    		}else if(1<numero && 10>numero) {
    			suma = suma + numero;
    		}
    		System.out.print("¿Insertar nuevo numero? (s/n) ");
    		String textreset = sc.next();
    		if (textreset.equalsIgnoreCase("n")) {
    			reset = false;
    		}
    	}
    	while(reset == true);
    	System.out.print("Hay "+negativos+" numeros negativos, la suma de todos los que van entre 2 y 9 es: " +suma+ " El promedio de todos los numeros es: "+(promedios/contador));
	}	
}
