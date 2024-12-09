package almacenamientoJSON;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

public class GestorNotificaciones {
	// TODO: Declarar la constante FILE_PATH que almacena la ruta del archivo JSON de configuraciones
	// TODO: Declarar la lista de configuraciones de notificaciones

	// TODO: Constructor de la clase GestorNotificaciones
	public GestorNotificaciones() {
	    // TODO: Inicializar la lista de configuraciones como un ArrayList vacío
	    // TODO: Llama al metodo cargar las configuraciones existentes desde el archivo JSON
	}

	// TODO: Método para agregar una nueva configuración de notificación
	public void agregarNotificacion(NotificacionConfig config) {
	    // TODO: Añadir la configuración a la lista de configuraciones
	    // TODO: Llama al metodo Guardar las configuraciones actualizadas en el archivo JSON
	}

	// TODO: Método para eliminar una configuración de notificación dado su índice
	public void eliminarNotificacion(int index) {
	    // TODO: Comprobar si el índice está dentro de los límites de la lista
	        // TODO: Eliminar la configuración en el índice especificado con el metodo remove(i)
	        // TODO: Llama al metodo Guardar las configuraciones actualizadas en el archivo JSON
	    // TODO: Si no, Imprimir un mensaje de error si el índice es inválido
	}

	// TODO: Método para listar todas las configuraciones de notificación
	public void listarNotificaciones() {
	    // TODO: Recorrer cada configuración en la lista y mostrarla en la consola
	}

	// TODO: Método privado para guardar las configuraciones en el archivo JSON
	private void guardarConfiguraciones() {
	    // TODO: Crear un JSONArray para almacenar las configuraciones en formato JSON
	    // TODO: Recorreo un bucle forEach para convertir cada configuración en JSON y añadirla al JSONArray. Utiliza toJSON() de la clase NotificacionConfig
	   
	    // TODO: Guardar el JSONArray en un archivo con un FileWriter
	    
	        // TODO: Manejar excepciones de entrada/salida si ocurre un error al guardar el archivo
	    
	}

	// TODO: Método privado para cargar las configuraciones desde el archivo JSON
	private void cargarConfiguraciones() {
	    // TODO: Crear un BufferedReader para leer el archivo JSON
		
	        // TODO: Crear un StringBuilder para almacenar el contenido JSON leido
	    
			// TODO: Crear un String line
	        
			// TODO: Leer cada línea del archivo JSON y agregarla al StringBuilder

	        // TODO: Convertir el contenido del StringBuilder en un JSONArray
	        
	        // TODO: Limpiar la lista de configuraciones antes de cargar nuevas con el método .clear()
	        
	        // TODO: Recorre el bucle para convertir cada objeto JSON en una NotificacionConfig y añadirla a la lista
	        
	        // TODO: catch Imprimir mensaje en caso de que el archivo no exista o haya un error de lectura
			
	}
}
