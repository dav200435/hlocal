package Parte2Ej2;


import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GestionarAlumnos {
    private List<Alumno> alumnos;

    public GestionarAlumnos() {
        alumnos = new ArrayList<>();
    }

    public void importarAlumnos(String rutaFichero) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaFichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    String nombre = datos[0].trim();
                    int edad = Integer.parseInt(datos[1].trim());
                    String ciclo = datos[2].trim();
                    double notaMedia = Double.parseDouble(datos[3].trim());

                    Alumno alumno = new Alumno(nombre, edad, ciclo, notaMedia);
                    alumnos.add(alumno);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
    }

    public void imprimirAlumnos() {
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }

    public Alumno obtenerAlumnoConMayorNota() {
        return alumnos.stream().max(Comparator.comparingDouble(Alumno::getNotaMedia)).orElse(null);
    }

    public void generarFicheroAprobados(String rutaFicheroAprobados) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaFicheroAprobados))) {
            for (Alumno alumno : alumnos) {
                if (alumno.getNotaMedia() >= 5) {
                    bw.write(alumno.toCSV());
                    bw.newLine();
                }
            }
            System.out.println("Fichero de aprobados generado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir el fichero: " + e.getMessage());
        }
    }
    
    public void generarFicheroSuspendidos(String rutaFicheroSuspensos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaFicheroSuspensos))) {
            for (Alumno alumno : alumnos) {
                if (alumno.getNotaMedia() < 5) {
                    bw.write(alumno.toCSV());
                    bw.newLine();
                }
            }
            System.out.println("Fichero de suspendidos generado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir el fichero: " + e.getMessage());
        }
    }
}

