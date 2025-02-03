package persona;

/**
 * 
 * Clase para devolver el nombre y apellido de una persona cuando tiene turno
 * 
 * @version 1.0.0
 */
public class Turno {
	
	/**
	 * Constructor vacio
	 */
	public Turno() {}
	
	/**
	 * Dicta turno segun persona que le pases
	 * @param persona Se pasa objeto persona para pasar turno
	 */
	public static void dictar(Persona persona) {
		System.out.println("Turno de  " + persona.getNombre() + " " + persona.getApellido());
	}
	
	public static void main(String[] args) {
		Persona persona = new Persona("Pedro","Garcia");
		Turno.dictar(persona);
	}

}
