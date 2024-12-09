package ficherosBinarios;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
        Scanner sc  = new Scanner(System.in);
        // Pedir la edad mínima
        System.out.print("Introduce la edad mínima para filtrar: ");
        int edadMinima = sc.nextInt();

        // Filtrar y guardar alumnos mayores en un nuevo archivo
        filtrarYGuardarAlumnosMayores("Alumnos.dat", "AlumnosMayores.dat", edadMinima);

        // Mostrar los alumnos filtrados
        mostrarAlumnos("AlumnosMayores.dat");
    }

  
    
    public static void filtrarYGuardarAlumnosMayores(String inputFile, String outputFile, int edadMinima) {
    	// TODO: Crear una lista para almacenar los alumnos filtrados que cumplen con la edad mínima

    	// TODO: Iniciar un bloque try-with-resources para abrir el archivo de entrada con un ObjectInputStream
    	    
    	    // TODO: Declarar una variable de tipo Alumno para leer objetos del archivo binario

    	    // TODO: Leer objetos Alumno del archivo hasta que se alcance el final
    	        
    	        // TODO: Verificar si el alumno cumple con la condición de edad mínima
    	            
    	            // TODO: Si cumple, añadir el alumno a la lista de alumnos filtrados

    	// TODO: Capturar la excepción EOFException para identificar el fin del archivo y continuar sin errores
    	} catch (EOFException e) {
    	    // TODO: No hay que hacer nada
    	// TODO: Capturar IOException y ClassNotFoundException en caso de errores de entrada/salida o de clase no encontrada
    	} catch (IOException | ClassNotFoundException e) {
    	    // TODO: Imprimir la traza de la excepción en caso de error
    	    e.printStackTrace();
    	}

    	// TODO: Iniciar un nuevo bloque try-with-resources para abrir el archivo de salida con un ObjectOutputStream
    	    
    	    // TODO: Recorrer la lista de alumnos filtrados para escribir cada uno en el archivo de salida
    	        
    	        // TODO: Escribir el objeto Alumno en el archivo binario de salida

    	    // TODO: Imprimir un mensaje para confirmar que los alumnos filtrados se han guardado correctamente

    	// TODO: Capturar IOException en caso de error al escribir en el archivo de salida
    	    // TODO: Imprimir la traza de la excepción en caso de error

    }

    public static void mostrarAlumnos(String inputFile) {
    	// TODO: Imprimir el nombre del archivo cuyo contenido se va a mostrar

    	// TODO: Iniciar un bloque try-with-resources para abrir el archivo de entrada con un ObjectInputStream
    	    
    	    // TODO: Declarar una variable de tipo Alumno para leer objetos del archivo binario

    	    // TODO: Leer objetos Alumno del archivo hasta que se alcance el final
    	        
    	        // TODO: Imprimir cada objeto Alumno que se lee del archivo
    	    }

    	// TODO: Capturar la excepción EOFException para identificar el fin del archivo y continuar sin errores
    	} catch (EOFException e) {
    	    // TODO: Manejar el final del archivo sin realizar ninguna acción adicional

    	// TODO: Capturar IOException y ClassNotFoundException en caso de errores de entrada/salida o de clase no encontrada
    	} catch (IOException | ClassNotFoundException e) {
    	    // TODO: Imprimir la traza de la excepción en caso de error
    	    e.printStackTrace();
    	}
    }

}
