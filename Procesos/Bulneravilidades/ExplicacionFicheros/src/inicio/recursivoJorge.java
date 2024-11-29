package inicio;

import java.io.File;

public class recursivoJorge {
	public static void listarContenido(File dir, boolean esRecursivo, int nivel) {
		int contadorDirectorios = 0;
		int contadorFicheros = 0;
		File[] archivosList = dir.listFiles();
		if (archivosList != null) {
			for (File archivo : archivosList) {
				String indentacion = "\t".repeat(nivel);

				if (archivo.isFile()) {
					System.out.println(
							indentacion + "fichero: " + archivo.getName() + " " + (archivo.length() / 1024.0) + " KB");
					contadorFicheros++;
				} else if (archivo.isDirectory()) {
					System.out.println(indentacion + "directorio: " + archivo.getName() + " "
							+ (archivo.length() / 1024.0) + " KB");
					contadorDirectorios++;
					if (esRecursivo) {
						listarContenido(archivo, true, nivel + 1);
					}
				}
			}
		}
	}
}
