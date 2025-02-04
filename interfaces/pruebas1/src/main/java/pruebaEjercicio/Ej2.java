package pruebaEjercicio;

import java.util.ArrayList;
import java.util.List;

public class Ej2 {

	
	public static List<String> obtenerNombresEnMayuscula(List<String> nombres){
		List<String> mayusculas = new ArrayList<String>();
		for (String nombre : nombres) {
			if (!nombre.matches(".*\\d.*") || !nombre.matches(".*¿?=/&%$·\"!-_:;.,*ç´Ç¨}{][+`.*")) {
                mayusculas.add(nombre.toUpperCase());
            }
		}
		return mayusculas;
	}
}
