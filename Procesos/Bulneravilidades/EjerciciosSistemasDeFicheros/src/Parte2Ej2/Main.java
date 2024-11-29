package Parte2Ej2;

public class Main {
    public static void main(String[] args) {
        GestionarAlumnos gestion = new GestionarAlumnos();

        gestion.importarAlumnos("alumnos.csv");

        System.out.println("Todos los alumnos:");
        gestion.imprimirAlumnos();

        Alumno alumnoConMayorNota = gestion.obtenerAlumnoConMayorNota();
        if (alumnoConMayorNota != null) {
            System.out.println("Alumno con la mayor nota:");
            System.out.println(alumnoConMayorNota);
        } else {
            System.out.println("No hay alumnos en la lista.");
        }

        gestion.generarFicheroAprobados("AlumnosAprobados.csv");
        gestion.generarFicheroSuspendidos("AlumnosSuspensos.csv");
    }
}

