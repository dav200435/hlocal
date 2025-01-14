package almacenamientoJSONSegundaParte;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class GestorTareas {
    // Ruta del archivo JSON
    private final static String FILE_PATH = "tareas.json";
    private List<Tarea> tareasLst;

    public GestorTareas() {
        // Inicializar la lista de tareas y cargar desde JSON
        this.tareasLst = new ArrayList<>();
        cargarTareas();
    }

    // Método para agregar una nueva tarea
    public void agregarTarea(Tarea tarea) {
        // 1. Asegúrate de que la tarea no sea nula.
    	if(tarea != null) {
        // 2. Añade la tarea a la lista de tareas.
    		tareasLst.add(tarea);
        // 3. Llama al método guardarTareas() para actualizar el archivo JSON.
    		guardarTareas();
    	}
    }

    // Método para eliminar una tarea dado su índice
    public void eliminarTarea(int index) {
        // 1. Verifica que el índice esté dentro de los límites de la lista.
    	if (index < tareasLst.size()) {
        // 2. Elimina la tarea correspondiente de la lista.
    		tareasLst.remove(index);
        // 3. Llama al método guardarTareas() para reflejar los cambios en el archivo JSON.
    		guardarTareas();
    	}
    }

    // Método para listar todas las tareas
    public void listarTareas() {
        // 1. Itera sobre la lista de tareas.
    	for (Tarea tarea : tareasLst) {
    		// 2. Imprime cada tarea con un formato claro (puedes incluir el índice).
    		System.out.println(tarea.toString());
		}
    }

    // Método para marcar una tarea como completada
    public void completarTarea(int index) {
        // 1. Verifica que el índice esté dentro de los límites de la lista.
    	if (index < tareasLst.size()) {
        // 2. Cambia el estado de la tarea a "completada".
    		Tarea tarea = tareasLst.get(index);
    		tarea.setCompletada(true);
    	// 3. Llama al método guardarTareas() para actualizar el archivo JSON.
    		guardarTareas();
    	}
    }

    // Método para guardar las tareas en el archivo JSON
    private void guardarTareas() {
        // 1. Crea un JSONArray para representar todas las tareas.
    	JSONArray jTareaLst = new JSONArray();
        // 2. Por cada tarea en la lista, conviértela a un JSONObject y añádela al JSONArray.
    	for (Tarea tarea : tareasLst) {
    		// 3. Escribe el JSONArray en el archivo JSON usando clases de java.io.
    		jTareaLst.put(tarea.toJSON());
    	}
    }

    // Método para cargar las tareas desde el archivo JSON
    private void cargarTareas() {
        // 1. Verifica si el archivo JSON existe; si no, inicializa una lista vacía.
    	File file  = new File(FILE_PATH);
    	if (file.exists()) {
            StringBuilder jsonContent = new StringBuilder();
    		try(BufferedReader bf = new BufferedReader(new FileReader(FILE_PATH))){
    			// 2. Lee el contenido del archivo JSON.
	    		String line;
	    		while((line = bf.readLine()) != null) {
	    			// 3. Convierte el contenido en un JSONArray.
	    			jsonContent.append(line);
	    			// 4. Por cada elemento en el JSONArray, crea un objeto Tarea y añádelo a la lista.
	    			JSONArray tareasArray = new JSONArray(jsonContent.toString());
	                for (int i = 0; i < tareasArray.length(); i++) {
	                    JSONObject tareaJson = tareasArray.getJSONObject(i);
	                    String titulo = tareaJson.getString("titulo");
	                    int prioridad = tareaJson.getInt("prioridad");
	                    boolean completada = tareaJson.getBoolean("completada");
	                    // Crear un objeto Tarea a partir del JSONObject
	                    Tarea tarea = new Tarea(titulo,prioridad,completada);
	                    // Agregar la tarea a la lista
	                    tareasLst.add(tarea);
	                }
	    		}
    		}catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    }
}