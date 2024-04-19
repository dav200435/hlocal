package Calculadora;

import java.util.Scanner;

public class Main {
	static private int Operacion(Fraccion item) {
		if (item.operacion.equals("+")) {
			return 1;
		}
		if (item.operacion.equals("-")) {
			return 2;
		}
		if (item.operacion.equals("*")) {
			return 3;
		}
		if (item.operacion.equals("/")) {
			return 4;
		}
		return 5;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Fraccion suma = new Fraccion(4,3,5,4,"+");
		Fraccion resta = new Fraccion(4,3,5,4,"-");
		Fraccion multiplicacion = new Fraccion(4,3,5,4,"*");
		Fraccion division = new Fraccion(4,3,5,4,"/");
		Fraccion invalido = new Fraccion();
		System.out.println("Introduce operacion a resolver");
		Fraccion operation= invalido;
		switch(Operacion(operation)) {
			case 1:
				operation.suma();
				break;
			case 2:
				operation.resta();
				break;
			case 3:
				operation.multiplicacion();
				break;
			case 4:
				operation.division();
				break;
			case 5:
				System.out.println("Operacion invalida");
				break;
		}
	}
}