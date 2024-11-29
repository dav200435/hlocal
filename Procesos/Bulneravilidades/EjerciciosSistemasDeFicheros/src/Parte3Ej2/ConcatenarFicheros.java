package Parte3Ej2;

import java.io.*;

public class ConcatenarFicheros {

    public static void main(String[] args) {
        concatenarFicheros("Alumno.dat", "AlumnosConcatenados.dat");

    }

    public static void concatenarFicheros(String archivoOrigen, String archivoDestino) {
        try (FileInputStream f1 = new FileInputStream(archivoOrigen);
             FileOutputStream f2 = new FileOutputStream(archivoDestino, true)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = f1.read(buffer)) != -1) {
                f2.write(buffer, 0, bytesRead);
            }

            System.out.println("Fichero " + archivoOrigen + " concatenado al final de " + archivoDestino);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
