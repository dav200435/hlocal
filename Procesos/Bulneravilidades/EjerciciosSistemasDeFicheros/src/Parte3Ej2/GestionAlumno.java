package Parte3Ej2;

import java.io.*;
import java.util.Scanner;

public class GestionAlumno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el nombre del alumno: ");
        String nombre = scanner.nextLine();
        System.out.println("Introduce la edad del alumno: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introduce el curso del alumno: ");
        String curso = scanner.nextLine();

        Alumno alumno = new Alumno(nombre, edad, curso);

        guardarAlumno(alumno, "Alumno.dat");

        leerAlumno("Alumno.dat");
    }

    public static void guardarAlumno(Alumno alumno, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(alumno);
            System.out.println("Datos guardados en " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leerAlumno(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Alumno alumno = (Alumno) ois.readObject();
            System.out.println("Datos leídos del archivo: " + alumno);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
