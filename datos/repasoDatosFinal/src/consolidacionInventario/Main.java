package consolidacionInventario;

import java.io.File;
import java.util.Scanner;

import org.json.JSONArray;

/**
 * Clase que contiene el método principal para la ejecución del programa.
 */
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			// TODO: Solicitar al usuario la ruta de la carpeta que contiene los archivos
			// JSON
			String ruta = sc.nextLine();

			// TODO: Crear un objeto File para representar la carpeta especificada
			File file = new File(ruta);

			// TODO: Validar que la carpeta existe y que es válida
			if (!file.exists() || !file.isDirectory()) {
				System.out.println("Ruta no valida");
				return;
			}

			// Obtener los archivos JSON de la carpeta
			File[] archivosJSON = file.listFiles((dir, name) -> name.toLowerCase().endsWith(".json"));

			// TODO: Comprueba si el archivo es nulo o su tamano es igual a 0, en ese caso
			// imprimir error y salir
			if (archivosJSON == null || archivosJSON.length == 0) {
				System.out.println("No se encontraron archivos JSON en la carpeta especificada.");
				return;
			}

			// TODO: Crear un JSONArray para almacenar el inventario consolidado
			
			// TODO: Crear una instancia de ConsolidacionInventarios para procesar los
			// archivos

			// TODO: Iterar sobre los archivos JSON y procesarlos uno por uno

			// TODO: Guardar el inventario consolidado en un nuevo archivo JSON

		} catch (Exception e) {
			// TODO: Manejar cualquier error inesperado y mostrar un mensaje al usuario
			System.out.println("Ocurrió un error inesperado: " + e.getMessage());
		} finally {
			// TODO: Cerrar el scanner al finalizar el programa
			sc.close();
		}
	}
}
