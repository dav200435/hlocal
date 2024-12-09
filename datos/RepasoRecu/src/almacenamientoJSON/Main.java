package almacenamientoJSON;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorNotificaciones gestor = new GestorNotificaciones();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar configuración de notificación");
            System.out.println("2. Eliminar configuración de notificación");
            System.out.println("3. Listar configuraciones de notificación");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el tipo de notificación (email, SMS, push): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Ingrese la frecuencia de notificación (diaria, semanal, instantánea): ");
                    String frecuencia = scanner.nextLine();
                    System.out.print("Ingrese las preferencias de contenido separadas por coma: ");
                    String preferenciasInput = scanner.nextLine();
                    List<String> preferencias = List.of(preferenciasInput.split(","));
                    NotificacionConfig config = new NotificacionConfig(tipo, frecuencia, preferencias);
                    gestor.agregarNotificacion(config);
                    System.out.println("Configuración agregada.");
                    break;
                case 2:
                    gestor.listarNotificaciones();
                    System.out.print("Ingrese el número de configuración a eliminar: ");
                    int index = scanner.nextInt();
                    gestor.eliminarNotificacion(index - 1);
                    System.out.println("Configuración eliminada.");
                    break;
                case 3:
                    gestor.listarNotificaciones();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}