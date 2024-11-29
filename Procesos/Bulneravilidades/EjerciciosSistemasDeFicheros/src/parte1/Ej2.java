package parte1;

import java.io.File;
import java.util.Scanner;

public class Ej2 {

    private void listarContenido(File directorio, int nivel, boolean esRecursivo) {
        File[] archivos = directorio.listFiles();

        if (archivos != null) {
            for (File archivo : archivos) {
                for (int i = 0; i < nivel; i++) {
                    System.out.print("\t");
                }

                if (archivo.isDirectory()) {
                    System.out.println("[DIRECTORIO] " + archivo.getName());

                    if (esRecursivo) {
                        listarContenido(archivo, nivel + 1, true);
                    }
                } else {
                    long tamañoEnKB = archivo.length() / 1024;
                    System.out.println("[FICHERO] " + archivo.getName() + " - Tamaño: " + tamañoEnKB + " KB");
                }
            }
        }
    }

    public void ejecutar() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la ruta del directorio:");
        String ruta = sc.nextLine();

        System.out.println("¿Quieres listar recursivamente los directorios? (si/no):");
        String opcionRecursiva = sc.nextLine();

        boolean esRecursivo = opcionRecursiva.equalsIgnoreCase("si");

        File directorio = new File(ruta);

        if (!directorio.exists()) {
            System.out.println("El directorio especificado no existe.");
            sc.close();
            return;
        }

        if (!directorio.isDirectory()) {
            System.out.println("La ruta especificada no es un directorio.");
            sc.close();
            return;
        }

        listarContenido(directorio, 0, esRecursivo);

        sc.close();
    }
}
