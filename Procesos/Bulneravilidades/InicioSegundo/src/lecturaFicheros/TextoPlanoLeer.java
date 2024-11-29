package lecturaFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextoPlanoLeer {

    public void leerArchivo() {
        BufferedReader buffer = null;

        try {
            buffer = new BufferedReader(new FileReader(new File("archivo.txt")));
            String linea;

            while ((linea = buffer.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (FileNotFoundException fnfe) {
            System.err.println("El archivo no se encontró: " + fnfe.getMessage());
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            System.err.println("Error al leer el archivo: " + ioe.getMessage());
            ioe.printStackTrace();
        } finally {
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (IOException ioe) {
                    System.err.println("Error al cerrar el archivo: " + ioe.getMessage());
                    ioe.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        TextoPlanoLeer lector = new TextoPlanoLeer();
        lector.leerArchivo();
    }
}