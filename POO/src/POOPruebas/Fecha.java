package POOPruebas;

 public class Fecha {
    private int dia;
    private int mes;
    private int anio;

//Por defecto
public Fecha() {
    this.dia = 1;
    this.mes = 1;
    this.anio = 2000;
}

//Sobrecargado1
public Fecha(int dia, int mes) {
  this.dia = dia;
  this.mes = mes;
  this.anio = 2023;
}

//Sobrecargado2
public Fecha(int dia, int mes, int anio) {
    this.dia = dia;
    this.mes = mes;
    this.anio = anio;
}

public static void main(String[] args) {
    Fecha f = new Fecha();
    Fecha f1 = new Fecha(5,3,2020);
    Fecha f2 = new Fecha(13,11);
    System.out.println(f.dia + "/" + f.mes + "/" + f.anio);
    System.out.println(f1.dia + "/" + f1.mes + "/" + f1.anio);
    System.out.println(f2.dia + "/" + f2.mes + "/" + f2.anio);
    }
}