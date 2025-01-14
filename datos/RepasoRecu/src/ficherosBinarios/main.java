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

		Scanner sc = new Scanner(System.in);
		// Pedir la edad mínima
		System.out.print("Introduce la edad mínima para filtrar: ");
		int edadMinima = sc.nextInt();

		// Filtrar y guardar alumnos mayores en un nuevo archivo
		filtrarYGuardarAlumnosMayores("Alumnos.dat", "AlumnosMayores.dat", edadMinima);

		// Mostrar los alumnos filtrados
		mostrarAlumnos("AlumnosMayores.dat");
	}

	public static void filtrarYGuardarAlumnosMayores(String inputFile, String outputFile, int edadMinima) {
		// TODO: Crear una lista para almacenar los alumnos filtrados que cumplen con la
		// edad mínima
		List<Alumno> alumnosLst = new ArrayList<Alumno>();
		// TODO: Iniciar un bloque try-with-resources para abrir el archivo de entrada
		// con un ObjectInputStream
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile))) {
			// TODO: Declarar una variable de tipo Alumno para leer objetos del archivo
			// binario

			Alumno alumno;

			// TODO: Leer objetos Alumno del archivo hasta que se alcance el final
			while ((alumno = (Alumno) ois.readObject()) != null) {

				// TODO: Verificar si el alumno cumple con la condición de edad mínima
				if (alumno.getEdad() >= edadMinima) {
					// TODO: Si cumple, añadir el alumno a la lista de alumnos filtrados
					alumnosLst.add(alumno);
				}
			}
			// TODO: Capturar la excepción EOFException para identificar el fin del archivo
			// y continuar sin errores
		} catch (EOFException e) {
			// TODO: No hay que hacer nada
			// TODO: Capturar IOException y ClassNotFoundException en caso de errores de
			// entrada/salida o de clase no encontrada
		} catch (IOException | ClassNotFoundException e) {
			// TODO: Imprimir la traza de la excepción en caso de error
			e.printStackTrace();
		}

		// TODO: Iniciar un nuevo bloque try-with-resources para abrir el archivo de
		// salida con un ObjectOutputStream
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {

			// TODO: Recorrer la lista de alumnos filtrados para escribir cada uno en el
			// archivo de salida
			for (Alumno alumno : alumnosLst) {
				// TODO: Escribir el objeto Alumno en el archivo binario de salida
				oos.writeObject(alumno);
			}

			// TODO: Imprimir un mensaje para confirmar que los alumnos filtrados se han
			// guardado correctamente
			System.out.println("Se han añadido con exito los alumnos");
			// TODO: Capturar IOException en caso de error al escribir en el archivo de
			// salida
		} catch (IOException e) {
			e.printStackTrace();
			// TODO: Imprimir la traza de la excepción en caso de error
		}

	}

	public static void mostrarAlumnos(String inputFile) {
		// TODO: Imprimir el nombre del archivo cuyo contenido se va a mostrar
		System.out.println(inputFile);
		// TODO: Iniciar un bloque try-with-resources para abrir el archivo de entrada
		// con un ObjectInputStream
		try (ObjectInputStream oit = new ObjectInputStream(new FileInputStream(inputFile))) {
			// TODO: Declarar una variable de tipo Alumno para leer objetos del archivo
			// binario
			Alumno alumno;
			// TODO: Leer objetos Alumno del archivo hasta que se alcance el final
			while ((alumno = (Alumno) oit.readObject()) != null) {
				// TODO: Imprimir cada objeto Alumno que se lee del archivo
				System.out.println(alumno.toString());
			}
			// TODO: Capturar la excepción EOFException para identificar el fin del archivo
			// y continuar sin errores
		} catch (

		EOFException e) {
			// TODO: Manejar el final del archivo sin realizar ninguna acción adicional
			
			// TODO: Capturar IOException y ClassNotFoundException en caso de errores de
			// entrada/salida o de clase no encontrada
		} catch (IOException | ClassNotFoundException e) {
			// TODO: Imprimir la traza de la excepción en caso de error
			e.printStackTrace();
		}
	}

}
