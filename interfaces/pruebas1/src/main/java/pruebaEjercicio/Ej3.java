package pruebaEjercicio;

import java.util.ArrayList;
import java.util.List;

public class Ej3 {
	
	private static List<Integer> edades = new ArrayList<Integer>();
	
	public static int obtenerPromedioEdades(List<Integer> edades) {
		int num = 0;
		
		for(int edad : edades) {
			num += edad;
		}
		
		return num / edades.size();
	}
	
	
}
