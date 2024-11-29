package Parte3Ej2;

import java.io.Serializable;

public class Alumno implements Serializable {
    private String nombre;
    private int edad;
    private String curso;

    public Alumno(String nombre, int edad, String curso) {
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", Curso: " + curso;
    }
}
