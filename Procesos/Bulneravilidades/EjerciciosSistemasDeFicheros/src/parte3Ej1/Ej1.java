package parte3Ej1;

import java.io.*;

class Ej1 implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private int edad;
    private String curso;

    public Ej1(String nombre, int edad, String curso) {
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCurso() {
        return curso;
    }
}