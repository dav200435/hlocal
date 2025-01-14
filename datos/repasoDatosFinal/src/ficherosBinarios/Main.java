package ficherosBinarios;

import java.util.Scanner;

/**
 * Clase principal para interactuar con el Gestor de Binarios.
 */
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // TODO: Solicitar al usuario la ruta del archivo binario
        System.out.println("Introduce la ruta");
        // TODO: Crear una instancia de GestorBinarios con la ruta proporcionada
        GestorBinarios gestor = new GestorBinarios(in.nextLine());
        // TODO: Completa el bucle para que salga en la opcion 3
        while (true) {
            // TODO: Mostrar un menú de opciones al usuario
            System.out.println("\nGestor de Binarios:");
            System.out.println("1. Calcular estadísticas");
            System.out.println("2. Generar reporte");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");

            // TODO: Leer la opción seleccionada por el usuario
            int opcion = in.nextInt();
            in.nextLine(); // Consumir salto de línea

            // TODO: Completa el switch
            switch (opcion) {
                case 1:
                    // TODO: Calcular y mostrar estadísticas del archivo binario
                    gestor.calcularEstadisticas();
                    break;

                case 2:
                    // TODO: Solicitar la ruta donde se guardará el reporte
                    System.out.println("Introduce la ruta donde se guardará e registro");
                	String ruta  = in.nextLine();

                    // TODO: Generar el reporte con las estadísticas
                    gestor.generarReporte(ruta);
                    break;

                case 3:
                    // TODO: Salir del programa mostrando un mensaje de despedida
                	System.out.println("Saliendo...");
                	// TODO: cierra el flujo de entrada salida
                	in.close();
                    return;

                default:
                    // TODO: Mensaje de error de una opción inválida
                	System.out.println("Opcion " + opcion + " invalida");                	
            }
        }
    }
}
