package ficherosBinarios;

import java.io.*;
import java.util.*;

/**
 * Clase para gestionar estadísticas sobre archivos binarios.
 */
public class GestorBinarios {

    private final File archivoBinario;

    /**
     * Constructor que inicializa el archivo binario.
     * 
     * @param rutaArchivo Ruta del archivo binario.
     */
    public GestorBinarios(String rutaArchivo) {
        // TODO: Crear un objeto File para el archivo binario usando la ruta proporcionada
        this.archivoBinario = new File(rutaArchivo);

        // TODO: Comprobar si el archivo existe, y si no, mostrar un mensaje de error
        if (!archivoBinario.exists()) {
            System.out.println("El archivo especificado no existe: " + rutaArchivo);
        }
    }

    /**
     * Calcula y muestra estadísticas del archivo binario.
     */
    public void calcularEstadisticas() {
        // TODO: Crear un mapa para almacenar la frecuencia de cada byte de tipo Byte e Integer
        
        long totalBytes = 0;

        // TODO: Abrir un InputStream para leer el archivo binario
        try (InputStreamReader input = new InputStreamReader(new inputStream(archivoBinario))) {
            int byteLeido;
            // TODO: Completa el bucle para leer byte a byte
            while () {
                byte b = (byte) byteLeido;
                frecuenciaBytes.put(b, frecuenciaBytes.getOrDefault(b, 0) + 1);
                totalBytes++;
            }

            // TODO: Mostrar el total de bytes leídos del archivo
            System.out.println(totalBytes);

            // TODO: Recorrer el mapa de frecuencias.entrySet y mostrar la frecuencia de cada byte
            System.out.println("Frecuencia de bytes:");
            for () {
                System.out.printf("Byte: %02X, Frecuencia: %d\n", entry.getKey(), entry.getValue());
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo binario: " + e.getMessage());
        }
    }

    /**
     * Genera un archivo de reporte con las estadísticas del archivo binario.
     * 
     * @param rutaReporte Ruta donde se generará el archivo de reporte.
     */
    public void generarReporte(String rutaReporte) {
        // TODO: Crear un BufferedWriter para escribir el reporte
        try () {
            escritor.write("Reporte de estadísticas del archivo binario:\n");

            Map<Byte, Integer> frecuenciaBytes = new HashMap<>();
            long totalBytes = 0;

            // TODO: Leer las estadísticas del archivo binario
            try () {
                int byteLeido;
                while ((byteLeido = inputStream.read()) != -1) {
                    byte b = (byte) byteLeido;
                    frecuenciaBytes.put(b, frecuenciaBytes.getOrDefault(b, 0) + 1);
                    totalBytes++;
                }
            }

            // TODO: Escribir el total de bytes en el archivo de reporte Total de bytes: " + totalBytes + "\n"
            

            // TODO: Recorrer el mapa de frecuencias y escribir cada entrada en el reporte
            escritor.write("Frecuencia de bytes:\n");
            for () {
                escritor.write(String.format("Byte: %02X, Frecuencia: %d\n", entry.getKey(), entry.getValue()));
            }

            System.out.println("Reporte generado en: " + rutaReporte);
        } catch (IOException e) {
            System.out.println("Error al generar el reporte: " + e.getMessage());
        }
    }
}
