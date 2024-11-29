package monaco;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class main_alumnos {
    public static void main(String[] args) {
    	String rute = "monaco.json";

    	try (
    			FileInputStream file = new FileInputStream(new File(rute))
    	    // TODO: Crear un FileInputStream para leer el archivo JSON
    	) {
    		JSONTokener jt = new JSONTokener(file);
    	    // TODO: Crear un JSONTokener utilizando el FileInputStream

    		JSONObject jo = new JSONObject(jt);
    	    // TODO: Crear un JSONObject a partir del JSONTokener

    		JSONObject raceObject = jo.getJSONObject("race");
    	    // TODO: Obtener el objeto "race" del JSON principal
    		
    		JSONObject resultsObject = raceObject.getJSONObject("results");
    	    // TODO: Obtener el objeto "results" dentro de "race"
    		
    		JSONArray resultArray = resultsObject.getJSONArray("result");
    	    // TODO: Obtener el array "result" dentro de "results"

    	    // TODO: Iterar sobre cada elemento del array "result"
    	    for (int i = 0; i < resultArray.length(); i++) {
    	    	JSONObject result = resultArray.getJSONObject(i);
    	        // TODO: Obtener el objeto "result" en la posición actual del array

    	    	String position = result.getString("position");
    	        // TODO: Obtener el valor "position" como un String

    	    	JSONObject driver = result.getJSONObject("Driver");
    	        // TODO: Obtener el objeto "Driver" dentro de "result"

    	    	String name = driver.getString("GivenName");
    	    	String surname = driver.getString("FamilyName");
    	    	
    	    	String fullname = name + " " + surname;
    	        // TODO: Obtener el nombre y apellido del conductor y combinarlos en una cadena

    	    	String nationality = driver.getString("Nationality");
    	        // TODO: Obtener la nacionalidad del conductor

    	    	JSONObject constructor = result.getJSONObject("Constructor");
    	        // TODO: Obtener el objeto "Constructor" dentro de "result"

    	    	String teamName = constructor.getString("Name");
    	        // TODO: Obtener el nombre del equipo

    	    	String grid = result.getString("Grid");
    	        // TODO: Obtener el valor "Grid" como un String

    	    	String laps = result.getString("Laps");
    	        // TODO: Obtener el valor "Laps" como un String

    	    	String time = result.getJSONObject("Time").getString("text");
    	        // TODO: Obtener el tiempo total desde el objeto "Time" en formato de texto

    	    	String fastestLap = result.getJSONObject("FastestLap").getString("lapTime");
    	        // TODO: Obtener el tiempo de la vuelta más rápida desde "FastestLap"

    	    	System.out.println("Posicion: " + position);
                System.out.println("Piloto: " + fullname);
                System.out.println("Equipo: " + teamName);
                System.out.println("Parrilla de salida: " + grid);
                System.out.println("Vueltas: " + laps);
                System.out.println("Tiempo Vueltas: " + time);
                System.out.println("Vuelta Rapida: " + fastestLap);
                System.out.println("=======================================");
    	        // TODO: Imprimir los datos del resultado en el formato indicado
    	    }

    	} catch (IOException e) {
    	    System.out.println("Error de lectura: ");
    	    e.printStackTrace();
    	}
    }
}
