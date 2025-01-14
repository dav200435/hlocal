package consolidacionInventario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

import org.json.JSONArray;

/**
 * Clase para consolidar inventarios a partir de múltiples archivos JSON.
 */
public class ConsolidacionInventarios {

	/**
     * Procesa un archivo JSON y agrega su contenido al inventario consolidado.
     * 
     * @param archivo Archivo JSON a procesar.
     * @param inventarioConsolidado JSONArray donde se consolidan los datos.
     */
    public void procesarArchivo(File archivo, JSONArray inventarioConsolidado) {
        try {
        	// TODO: Leer el contenido del archivo especificado y guardalo en un String

        	
            // TODO: crea un JSONArray con el contenido JSON y agregar cada elemento al inventario consolidado

        	
            // TODO: Mostrar un mensaje indicando que el archivo "nombre" fue procesado con éxito

        	
        } catch (IOException e) {
            // TODO: Manejar errores de lectura del archivo y mostrar un mensaje al usuario
            System.out.println("Error al leer el archivo: " + archivo.getName() + " - " + e.getMessage());
        } catch (Exception e) {
            // TODO: Manejar errores en el procesamiento del archivo JSON y mostrar un mensaje
            System.out.println("Error al procesar el archivo: " + archivo.getName() + " - " + e.getMessage());
        }
    }

    /**
     * Guarda el inventario consolidado en un archivo JSON.
     * 
     * @param carpeta Carpeta donde se guardará el archivo.
     * @param inventarioConsolidado JSONArray con los datos consolidados.
     */
    public void guardarInventarioConsolidado(File carpeta, JSONArray inventarioConsolidado) {
        // TODO: Crear un archivo para guardar el inventario consolidado

    	// TODO: Crea un archivo de escritura pasandole el archivo consolidado
    	try () {
            // TODO: Escribir los datos consolidados en el archivo JSON de salida con formato legible

    		
            // TODO: Mostrar un mensaje indicando que el archivo fue generado exitosamente, muestra la ruta absoluta del archivo 
        } catch (IOException e) {
            // TODO: Manejar errores al escribir en el archivo y mostrar un mensaje al usuario
            System.out.println("Error al guardar el archivo consolidado: " + e.getMessage());
        }
    }
}




