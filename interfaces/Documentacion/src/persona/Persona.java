/**
 * @author DAV_2004_35
 * Paquete contenedor de Persona
 */
package persona;

/**
 * Clase Persona de ejemplo
 */
public class Persona {

	/**
	 * @author DAV_2004_35
	 * @date
	 * @version 1.0.0
	 */
	private String nombre;
	private String apellido;
	
	
	/**
	 * 
	 * @param nombre Texto nombre del objeto
	 * @param apellido Texto apellido del objeto
	 * Constructor
	 */
	public Persona(String nombre, String apellido) {
		this.nombre=nombre;
		this.apellido=apellido;
	}
	
	
	/**
	 * @author DAV_2004_35
	 * 
	 * Metodo para imprimir por consola nombre y apellido
	 */
	public void hablar() {
		System.out.println("Hola soy " + nombre + " " + apellido);
	}
	
	/**
	 * @author DAV_2004_35
	 * 
	 * @param escucha Texto a imprimir con consola
	 * 
	 * Metodo para imprimir por consola un texto introducido por el parametro
	 */
	public void escuchar(String escucha) {
		System.out.println("has dicho: " + escucha);
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
}
