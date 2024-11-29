package parte3Ej1;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Alumno {

    public static void guardarAlumno(Ej1 alumno) {
        try (FileOutputStream fos = new FileOutputStream("Alumno.dat", true);
             ObjectOutputStream oos = fos.getChannel().position() == 0 ? new ObjectOutputStream(fos) : new AppendableObjectOutputStream(fos)) {
            oos.writeObject(alumno);
            System.out.println("Datos del alumno guardados en Alumno.dat");
        } catch (IOException e) {
            System.err.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public static void leerAlumnos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Alumno.dat"))) {
            while (true) {
                Ej1 alumno = (Ej1) ois.readObject();
                System.out.println("Datos del Alumno leidos del fichero:");
                System.out.println("Nombre: " + alumno.getNombre());
                System.out.println("Edad: " + alumno.getEdad());
                System.out.println("Curso: " + alumno.getCurso());
            }
        } catch (EOFException e) {
            System.out.println("Fin de la lectura del archivo.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer los datos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Introduce los datos del Alumno:");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Edad: ");
            int edad = sc.nextInt();
            sc.nextLine(); 
            System.out.print("Curso: ");
            String curso = sc.nextLine();

            Ej1 alumno = new Ej1(nombre, edad, curso);

            guardarAlumno(alumno);
            for (int i = 0; i < 5; i++) {
                System.out.println("");
            }
            leerAlumnos();

            System.out.println("¿Desea salir? s/n");
            String exit = sc.nextLine();
            if (exit.equalsIgnoreCase("s")) {
                salir = true;
            }
        }

        sc.close();
    }
}

class AppendableObjectOutputStream extends ObjectOutputStream {
    public AppendableObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        reset();
    }
}