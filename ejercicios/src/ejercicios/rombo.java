package ejercicios;

import java.util.Scanner;

public class rombo {
public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int var1 = 4;
	int var2 = 6;
	boolean booleano = false;
	int contador = 0;
	for (int y=0;y<=6;y++) {
		if (contador == 4) {
			booleano = true;
			var1++;
			var2--;
		}else {
		contador++;
		var1--;
		var2++;}
		for (int x=0;x<=9;x++) {
			if (booleano == false) {
				if (x < var1 || x >= var2) {
					System.out.print(" ");
				}else {
					System.out.print("+");
				}
			}else {
				if (x < var1 || x >= var2) {
					System.out.print(" ");
				}else {
					System.out.print("+");
				}
			
				}
			}
		System.out.println();}
	}
}