package Parte2Ej2;

public class Alumno {
    private String nombre;
    private int edad;
    private String ciclo;
    private double notaMedia;

    public Alumno(String nombre, int edad, String ciclo, double notaMedia) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciclo = ciclo;
        this.notaMedia = notaMedia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", ciclo='" + ciclo + '\'' +
                ", notaMedia=" + notaMedia +
                '}';
    }

    public String toCSV() {
        return nombre + "," + edad + "," + ciclo + "," + notaMedia;
    }
}
