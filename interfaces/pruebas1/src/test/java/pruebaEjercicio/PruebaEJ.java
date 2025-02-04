package pruebaEjercicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class PruebaEJ {

	
	@Test
	public void UnitTest1() {
		Random random = new Random();
		List<Integer> numeros = new ArrayList<Integer>();
		int sumaPares = 0;
		for (int i = 0; i<7;i++) {
			int numero= random.nextInt(0,9);
			if (numero % 2 == 0) {
				sumaPares += numero;
			}
			numeros.add(numero);
		}
		assertEquals(sumaPares,SumarValoresPares.sumarValoresPares(numeros));
	}
	
	@Test
	public void testObtenerNombresEnMayusculas() {
		List<String> nombres = new ArrayList<String>();
		nombres.add("DARIO");
		nombres.add("DAVID");
		
		Ej2.obtenerNombresEnMayuscula(nombres);
		
		List<String> nombresMayus = new ArrayList<String>();
		nombresMayus.add("dario".toUpperCase());
		nombresMayus.add("david".toUpperCase());
		
		assertEquals(nombres, nombresMayus);
	}
	
	
	@Test
	public void  testObtenerPromedioEdades() {
		Random random = new Random();
		List<Integer> edades = new ArrayList<Integer>();
		int cont=0;
		double sumaEdades = 0;
		int veces = random.nextInt(1,50);
		for (int i = 0; i<veces;i++) {
			int numero= random.nextInt(0,99);
			cont++;
			sumaEdades += numero;
			edades.add(numero);
		}
		sumaEdades = sumaEdades / cont;
		assertEquals(sumaEdades,Ej3.obtenerPromedioEdades(edades));
	}
}
