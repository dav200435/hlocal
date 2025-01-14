package almacenamientoJSON;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GestorNotificaciones {
	// TODO: Declarar la constante FILE_PATH que almacena la ruta del archivo JSON de configuraciones
	private final static String FILE_PATH = "config.json";
	// TODO: Declarar la lista de configuraciones de notificaciones
	List<NotificacionConfig> configLst;

	// TODO: Constructor de la clase GestorNotificaciones
	public GestorNotificaciones() {
	    // TODO: Inicializar la lista de configuraciones como un ArrayList vacío
		this.configLst  = new ArrayList<NotificacionConfig>();
	    // TODO: Llama al metodo cargar las configuraciones existentes desde el archivo JSON
		cargarConfiguraciones();
	}

	// TODO: Método para agregar una nueva configuración de notificación
	public void agregarNotificacion(NotificacionConfig config) {
	    // TODO: Añadir la configuración a la lista de configuraciones
		configLst.add(config);
	    // TODO: Llama al metodo Guardar las configuraciones actualizadas en el archivo JSON
		guardarConfiguraciones();
	}

	// TODO: Método para eliminar una configuración de notificación dado su índice
	public void eliminarNotificacion(int index) {
	    // TODO: Comprobar si el índice está dentro de los límites de la lista
		if (configLst.size() > index) {
			// TODO: Eliminar la configuración en el índice especificado con el metodo remove(i)
			configLst.remove(index);
			// TODO: Llama al metodo Guardar las configuraciones actualizadas en el archivo JSON
			guardarConfiguraciones();
		// TODO: Si no, Imprimir un mensaje de error si el índice es inválido
		} else {
			System.out.println("indice invalido");
		}
	}

	// TODO: Método para listar todas las configuraciones de notificación
	public void listarNotificaciones() {
	    // TODO: Recorrer cada configuración en la lista y mostrarla en la consola
		for (NotificacionConfig config : configLst) {
			System.out.println(config.toString());
		}
	}

	// TODO: Método privado para guardar las configuraciones en el archivo JSON
	private void guardarConfiguraciones() {
	    // TODO: Crear un JSONArray para almacenar las configuraciones en formato JSON
		JSONArray arrayJson = new JSONArray();
	   for (NotificacionConfig object : configLst) {
		   // TODO: Recorreo un bucle forEach para convertir cada configuración en JSON y añadirla al JSONArray. Utiliza toJSON() de la clase NotificacionConfig
		   arrayJson.put(object.toJSON());
	   }
	    // TODO: Guardar el JSONArray en un archivo con un FileWriter
	    try {
			arrayJson.write(new FileWriter(FILE_PATH));
		} catch (JSONException | IOException e) {
			// TODO: Manejar excepciones de entrada/salida si ocurre un error al guardar el archivo
			e.printStackTrace();
		}
	}

	// TODO: Método privado para cargar las configuraciones desde el archivo JSON
	private void cargarConfiguraciones() {
		try (BufferedReader bf = new BufferedReader(new FileReader(FILE_PATH))) {
            // TODO: Crear un StringBuilder para almacenar el contenido JSON leído
            StringBuilder string = new StringBuilder();
            String line;

            // TODO: Leer cada línea del archivo JSON y agregarla al StringBuilder
            while ((line = bf.readLine()) != null) {
                string.append(line);
            }

            // TODO: Convertir el contenido del StringBuilder en un JSONArray
            JSONArray jsonArray = new JSONArray(string.toString());

            // TODO: Limpiar la lista de configuraciones antes de cargar nuevas
            configLst.clear();

            // TODO: Recorrer el JSONArray para convertir cada objeto JSON en una NotificacionConfig y añadirla a la lista
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                NotificacionConfig config = NotificacionConfig.fromJSON(jsonObject);
                configLst.add(config);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
	}
}
