package pruebas1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class prueba1 {
	
	@Test
	public void probarSuma() {
		assertEquals(5,Main.suma(2, 3));
	}
}