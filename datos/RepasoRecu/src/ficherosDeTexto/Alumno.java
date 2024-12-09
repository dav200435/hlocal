package ficherosDeTexto;

import javax.print.attribute.standard.JobName;

import org.json.JSONObject;

public class Alumno {
	private String nombre;
    private int edad;
    private String ciclo;
    private double notaMedia;

    // Constructor
    public Alumno(String nombre, int edad, String ciclo, double notaMedia) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciclo = ciclo;
        this.notaMedia = notaMedia;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCiclo() {
        return ciclo;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    // Método para convertir el objeto Alumno a JSONObject
    public JSONObject toJson() {
    	// TODO: Crear una nueva instancia de JSONObject para almacenar los datos del alumno en formato JSON
    	JSONObject alumnoJson= new JSONObject();

    	// TODO: Agregar el atributo "nombre" al JSONObject, con el valor del nombre del alumno
    	alumnoJson.put("Nombre", getNombre());
    	
    	// TODO: Agregar el atributo "edad" al JSONObject, con el valor de la edad del alumno
    	alumnoJson.put("Edad", getEdad());
    	
    	// TODO: Agregar el atributo "ciclo" al JSONObject, con el valor del ciclo en el que está el alumno
    	alumnoJson.put("Ciclo", getCiclo());
    	
    	// TODO: Agregar el atributo "notaMedia" al JSONObject, con el valor de la nota media del alumno
    	alumnoJson.put("NotaMedia", getNotaMedia());
    	
    	// TODO: Devolver el JSONObject creado, que contiene todos los datos del alumno
    	return alumnoJson;
    }
}
