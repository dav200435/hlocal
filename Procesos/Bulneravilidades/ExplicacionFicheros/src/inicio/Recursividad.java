package inicio;

import java.io.File;

public class Recursividad {
	
	private static void listarContenido(File string, String recursivo, int nivel) {
        File[] archivos = string.listFiles();

        if (archivos != null) {
            for (File archivo : archivos) {
                    System.out.print("\t".repeat(nivel));

                if (archivo.isDirectory()) {
                    System.out.println("[DIRECTORIO] " + archivo.getName());

                    if (recursivo.equals("-r")) {
                        listarContenido(archivo, recursivo, nivel + 1);
                    }
                } else {
                    long tamanioEnKB = archivo.length() / 1024;
                    System.out.println("[FICHERO] " + archivo.getName() + " - Tamanio: " + tamanioEnKB + " KB");
                }
            }
        }
    }		
	public static void main(String[] args) {
		listarContenido(new File("./file"), args[0] ,0);
	}
}
