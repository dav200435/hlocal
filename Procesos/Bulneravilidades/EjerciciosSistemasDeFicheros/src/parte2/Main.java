package parte2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String ruta;
		
		System.out.println("introduce la ruta");
		ruta = sc.nextLine();		
		
		Ej1P2 ej1 = new Ej1P2(ruta);
		
		ej1.data();
		

	}

}
