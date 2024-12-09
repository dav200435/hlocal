package sistemaFicheros;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class FileAnalyzer {

    public static void main(String[] args) {
    	
    	// TODO: Crear un objeto Scanner para leer la entrada del usuario desde la consola
    	        
    	// TODO: Solicitar al usuario que introduzca la ruta del fichero o directorio

    	// TODO: Leer la ruta ingresada por el usuario y guardarla en la variable 'path'
    	        
    	// TODO: Crear un objeto File usando la ruta proporcionada por el usuario

    	// TODO: Verificar si el directorio proporcionado es válido (existe y es un directorio)
    	// TODO: Si el directorio no es válido, mostrar un mensaje de error y terminar el programa

    	// TODO: Comprobar si la lista de argumentos contiene la opción "-o" para ordenar por fecha de modificación

    	// TODO: Comprobar si la lista de argumentos contiene la opción "-m" para filtrar archivos recientes

    	// TODO: Obtener los archivos del directorio, con la opción de ordenarlos si 'orderByDate' es verdadero

    	// TODO: Mostrar la información de los archivos, aplicando el filtro de archivos recientes si 'filterByRecent' es verdadero

    }

    /**
     * Verifica si el directorio es válido.
     *
     * @param directory Directorio a verificar
     * @return true si es un directorio válido; false en caso contrario
     */
    private static boolean isValidDirectory(File directory) {
    	// TODO: Comprobar si el directorio existe y es efectivamente un directorio, devolviendo true si ambas condiciones se cumplen
    	return true;
    }

    /**
     * Obtiene los archivos del directorio, con opción de ordenarlos por fecha de modificación.
     *
     * @param directory Directorio del cual se obtendrán los archivos
     * @param orderByDate Si es true, los archivos se ordenarán por fecha de modificación
     * @return Array de archivos del directorio
     */
    private static File[] getFiles(File directory, boolean orderByDate) {
        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No se pudo leer el contenido del directorio.");
            return new File[0];
        }

        if (orderByDate) {
            Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        }
        return files;
    }

    /**
     * Muestra los archivos en la consola, aplicando el filtro de modificación reciente si se solicita.
     *
     * @param files Array de archivos a mostrar
     * @param filterByRecent Si es true, se mostrarán solo los archivos modificados en la última semana
     */
    private static void displayFiles(File[] files, boolean filterByRecent) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        long currentTime = System.currentTimeMillis();
        long weekInMillis = 7L * 24 * 60 * 60 * 1000; // Una semana en milisegundos

        for (File file : files) {
            if (filterByRecent && !isModifiedWithinLastWeek(file, currentTime, weekInMillis)) {
                continue;
            }
            printFileInfo(file, dateFormat);
        }
    }

    /**
     * Verifica si el archivo fue modificado en la última semana.
     *
     * @param file Archivo a verificar
     * @param currentTime Tiempo actual en milisegundos
     * @param weekInMillis Milisegundos en una semana
     * @return true si el archivo fue modificado en la última semana; false en caso contrario
     */
    private static boolean isModifiedWithinLastWeek(File file, long currentTime, long weekInMillis) {
        return currentTime - file.lastModified() <= weekInMillis;
    }

    /**
     * Imprime la información de un archivo en formato legible.
     *
     * @param file Archivo del cual se mostrará la información
     * @param dateFormat Formato de fecha para la última modificación
     */
    private static void printFileInfo(File file, SimpleDateFormat dateFormat) {
    	// TODO: Determinar el tipo del archivo; si es un directorio, asignar "Directorio", de lo contrario, asignar "Fichero"

    	// TODO: Calcular el tamaño del archivo en kilobytes dividiendo su longitud en bytes entre 1024

    	// TODO: Obtener la fecha de última modificación del archivo y formatearla según el formato especificado en 'dateFormat'

    	// TODO: Imprimir la información del archivo: tipo, nombre, tamaño en KB y fecha de última modificación en formato legible
    }
}