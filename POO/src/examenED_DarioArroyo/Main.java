package examenED_DarioArroyo;

import java.util.Scanner;

public class Main {
    static int asignacion;
    //se crea funcion auxiliar privada para asignar un numero a una asignatura ya que solo se usa en el main
    private static int consultor(String nombre) {
        if (nombre.equalsIgnoreCase("matematicas")) {
            return asignacion = 1;
        } else if (nombre.equalsIgnoreCase("Entornos")) {
            return asignacion = 2;
        } else if (nombre.equalsIgnoreCase("Programacion")) {
            return asignacion = 3;
        }
        return 0;
    }

    public static void main(String[] args) {
        Asignatura matematicas = new Asignatura("Matematicas", 21, "jose");
        Asignatura entornos = new Asignatura("Entornos", 5, "Davinia");
        Asignatura programacion = new Asignatura("Programacion",5,"alfonso");
        Asignatura copiaProgramacion = new Asignatura(programacion);
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        do {
            System.out.println("Que desea hacer?");
            System.out.println("1. Alta de alumno");
            System.out.println("2. Baja de alumno");
            System.out.println("3. Ver cuantos alumnos hay");
            System.out.println("4. Salir");
            int opcion = sc.nextInt();

			switch (opcion) {
                case 1:
                	System.out.println("Nombre de la asignatura");
                    String nombre = sc.next();
                    switch (consultor(nombre)) {
                        case 1:
                        	matematicas.alta();
                            break;
                        case 2:
                        	entornos.alta();
                            break;
                        case 3:
                        	programacion.alta();
                            break;
                        default:
                            System.out.println("Asignatura no válida");
                            break;
                    }
                    break;
                case 2:
                	System.out.println("Nombre de la asignatura");
                    nombre = sc.next();
                    switch (consultor(nombre)) {
                        case 1:
                        	if (matematicas.getNumAlumnos()>=1) {
                        	matematicas.baja();
                            }
                        	break;
                        case 2:
                        	if (entornos.getNumAlumnos()>=1) {
                            	entornos.baja();
                                }
                            	break;
                        case 3:
                        	if (programacion.getNumAlumnos()>=1) {
                            	programacion.baja();
                                }
                            	break;
                        default:
                            System.out.println("Asignatura no válida");
                            break;
                    }
                    break;
                case 3:
                	System.out.println("Nombre de la asignatura");
                    nombre = sc.next();
                    switch (consultor(nombre)) {
                        case 1:
                        	System.out.println(matematicas.getNumAlumnos());
                            break;
                        case 2:
                        	System.out.println(entornos.getNumAlumnos());
                            break;
                        case 3:
                        	System.out.println(programacion.getNumAlumnos());
                            break;
                        default:
                            System.out.println("Asignatura no válida");
                            break;
                    }
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (salir==false);
        System.out.println("Hasta la proxima");

        sc.close();
    }
}