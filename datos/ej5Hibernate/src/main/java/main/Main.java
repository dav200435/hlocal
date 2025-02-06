package main;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import model.Alumno;
import model.Examen;
import model.Modulo;
import model.Profesor;
import utils.HibernateUtils;

public class Main {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
    	 Session laSesion=HibernateUtils.getSessionFactory().getCurrentSession();
         laSesion.getTransaction().begin();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menú de Consultas HQL ---");
            System.out.println("1. Insertar 5 datos en todas las tablas y mostrar alumnos");
            System.out.println("2. Mostrar todos los Profesores");
            System.out.println("3. Mostrar todos los modulos");
            System.out.println("4. Mostrar todos los examenes");
            System.out.println("5. Mostrar alumno por nombre");
            System.out.println("6. Mostrar profesor por nombre");
            System.out.println("7. Mostrar modulo por codigo");
            System.out.println("8. Mostrar examen por modulo");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            try (Session session = sessionFactory.openSession()) {
                switch (opcion) {
                    case 1:
                        insertarDatos(session);
                        selectAlumnos(session);
                        break;
                    case 2:
                        selectProfesores(session);
                        break;
                    case 3:
                        selectModulos(session);
                        break;
                    case 4:
                        selectExamenes(session);
                        break;
                    case 5:
                        System.out.print("Ingrese el nombre del alumno: ");
                        String alumno = scanner.nextLine();
                        System.out.print("¿Desea ver solo el primer resultado? (s/n): ");
                        boolean soloUno = scanner.nextLine().equalsIgnoreCase("s");
                        selectAlumnoPorNombre(alumno, session, soloUno);
                        break;
                    case 6:
                        System.out.print("Ingrese el nombre del profesor: ");
                        String profesor = scanner.nextLine();
                        System.out.print("¿Desea ver solo el primer resultado? (s/n): ");
                        boolean soloUnProfesor = scanner.nextLine().equalsIgnoreCase("s");
                        selectProfesorPorNombre(profesor, session, soloUnProfesor);
                        break;
                    case 7:
                        System.out.print("Ingrese el ID del módulo: ");
                        Long idModulo = scanner.nextLong();
                        selectModuloPorId(idModulo, session);
                        break;
                    case 8:
                        System.out.print("Ingrese el ID del módulo: ");
                        Long idMod = scanner.nextLong();
                        selectExamenPorModulo(idMod, session);
                        break;
                    case 9:
                        System.out.println("Saliendo...");
                        scanner.close();
                        sessionFactory.close();
                        return;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            }
        }
    }

    private static void insertarDatos(Session session) {
        Transaction transaction = session.beginTransaction();

        for (int i = 1; i <= 5; i++) {
            Alumno alumno = new Alumno();
            alumno.setNombre("Alumno" + i);
            alumno.setApellidos("Apellido" + i);
            alumno.setEdad(20 + i);
            alumno.setRepetidor(i % 2 == 0);
            session.persist(alumno);

            Profesor profesor = new Profesor();
            profesor.setNombre("Profesor" + i);
            session.persist(profesor);

            Modulo modulo = new Modulo();
            modulo.setNombre("Modulo" + i);
            session.persist(modulo);

            Examen examen = new Examen();
            examen.setNota(5.0 + i);
            examen.setFecha("2025-02-" + (10 + i));
            examen.setAlumno(alumno);
            examen.setModulo(modulo);
            session.persist(examen);
        }

        transaction.commit();
        System.out.println("5 registros insertados en todas las tablas.");
    }

    private static void selectAlumnoPorNombre(String nombre, Session session, boolean soloUno) {
        if (soloUno) {
            Alumno alumno = session.createQuery("FROM Alumno WHERE nombre = :nombre", Alumno.class)
                    .setParameter("nombre", nombre)
                    .uniqueResultOptional()
                    .orElse(null);
            if (alumno != null) {
                System.out.println(alumno.getNombre() + " " + alumno.getApellidos());
            } else {
                System.out.println("No se encontró un alumno con ese nombre.");
            }
        } else {
            List<Alumno> alumnos = session.createQuery("FROM Alumno WHERE nombre = :nombre", Alumno.class)
                    .setParameter("nombre", nombre).list();
            alumnos.forEach(a -> System.out.println(a.getNombre() + " " + a.getApellidos()));
        }
    }

    private static void selectProfesorPorNombre(String nombre, Session session, boolean soloUno) {
        if (soloUno) {
            Profesor profesor = session.createQuery("FROM Profesor WHERE nombre = :nombre", Profesor.class)
                    .setParameter("nombre", nombre)
                    .uniqueResultOptional()
                    .orElse(null);
            if (profesor != null) {
                System.out.println(profesor.getNombre());
            } else {
                System.out.println("No se encontró un profesor con ese nombre.");
            }
        } else {
            List<Profesor> profesores = session.createQuery("FROM Profesor WHERE nombre = :nombre", Profesor.class)
                    .setParameter("nombre", nombre).list();
            profesores.forEach(p -> System.out.println(p.getNombre()));
        }
    }

    private static void selectModuloPorId(Long id, Session session) {
        Modulo modulo = session.get(Modulo.class, id);
        if (modulo != null) {
            System.out.println("Módulo: " + modulo.getNombre());
        } else {
            System.out.println("No se encontró el módulo con ID " + id);
        }
    }

    private static void selectExamenPorModulo(Long id, Session session) {
        List<Examen> examenes = session.createQuery("FROM Examen WHERE modulo.idModulo = :id", Examen.class)
                .setParameter("id", id).list();
        if (!examenes.isEmpty()) {
            examenes.forEach(e -> System.out.println("Examen ID: " + e.getIdExamen() + ", Nota: " + e.getNota()));
        } else {
            System.out.println("No se encontraron exámenes para el módulo con ID " + id);
        }
    }

    private static void selectAlumnos(Session session) {
        List<Alumno> alumnos = session.createQuery("FROM Alumno", Alumno.class).list();
        alumnos.forEach(a -> System.out.println(a.getNombre() + " " + a.getApellidos()));
    }

    private static void selectProfesores(Session session) {
        List<Profesor> profesores = session.createQuery("FROM Profesor", Profesor.class).list();
        profesores.forEach(p -> System.out.println(p.getNombre()));
    }

    private static void selectModulos(Session session) {
        List<Modulo> modulos = session.createQuery("FROM Modulo", Modulo.class).list();
        modulos.forEach(m -> System.out.println(m.getNombre()));
    }

    private static void selectExamenes(Session session) {
        List<Examen> examenes = session.createQuery("FROM Examen", Examen.class).list();
        examenes.forEach(e -> System.out.println("Nota: " + e.getNota() + " Fecha: " + e.getFecha()));
    }
}
