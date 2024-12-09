package cifradoArchivos;

import java.io.*;
import java.util.Scanner;

public class CifradoArchivos {

    public static void main(String[] args) {
        // TODO: Crea el objeto Scanner para capturar la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // TODO: Solicitar la ruta del archivo al usuario y guardarla en la variable rutaArchivo
        System.out.print("Introduce la ruta del archivo: ");
        String rutaArchivo = scanner.nextLine();

        // TODO: Solicitar la clave numérica para cifrado o descifrado y guardarla en la variable clave
        System.out.print("Introduce la clave numérica para el cifrado/descifrado: ");
        int clave = scanner.nextInt();

        // TODO: Solicitar al usuario que elija entre cifrar o descifrar y guardarla en la variable opcion
        System.out.print("¿Deseas cifrar (C) o descifrar (D)? ");
        scanner.nextLine(); // Consumir el salto de línea
        String opcion = scanner.nextLine().trim().toUpperCase();

        // TODO: Validar la opción ingresada
        if (!opcion.equals("C") && !opcion.equals("D")) {
            System.err.println("Opción inválida. Usa 'C' para cifrar o 'D' para descifrar.");
            return;
        }

        // TODO: Crear un objeto File para representar el archivo
        File archivo = new File(rutaArchivo);

        // TODO: Verificar si el archivo existe y es un archivo válido
        if (!archivo.exists() || !archivo.isFile()) {
            System.err.println("El archivo no existe o no es válido.");
            return;
        }

        // TODO: Determinar el sufijo del fichero resultante basado en la opción seleccionada
        String sufijo = opcion.equals("C") ? "_cifrado" : "_descifrado";

        // TODO: Crear un archivo de salida con el sufijo correspondiente
        File archivoSalida = new File(archivo.getParent(),
                archivo.getName().replaceFirst("\\.[^.]+$", sufijo + "$0"));

        // TODO: Realizar la operación de cifrado/descifrado
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo));
             BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoSalida))) {

            // TODO: Leer el archivo carácter por carácter
            int caracter;
            while ((caracter = lector.read()) != -1) {
                // TODO: Realizar la operación de cifrado o descifrado según la opción
                if (opcion.equals("C")) {
                    caracter += clave;
                } else {
                    caracter -= clave;
                }
                // TODO: Escribir el carácter procesado en el archivo de salida
                escritor.write(caracter);
            }

            // TODO: Confirmar que la operación se ha completado
            System.out.println("Operación completada. Archivo generado: " + archivoSalida.getAbsolutePath());

        } catch (IOException e) {
            // TODO: Manejar errores de lectura/escritura e informar al usuario
            System.err.println("Error al procesar el archivo: " + e.getMessage());
        }
    }
}