package AD_U3_A3;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainMenu {

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
          sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//        Session laSesion=HibernateUtil.getSessionFactory().getCurrentSession();
//        laSesion.getTransaction().begin();
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n--- Menú de Consultas HQL ---");
            System.out.println("1. Mostrar todas las películas");
            System.out.println("2. Buscar película por título");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea
            
            switch (opcion) {
                case 1:
                    mostrarPeliculas();
                    break;
                case 2:
                    System.out.print("Ingrese el título de la película: ");
                    String titulo = scanner.nextLine();
                    buscarPeliculaPorTitulo(titulo);
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    sessionFactory.close();
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void mostrarPeliculas() {
        try (Session session = sessionFactory.openSession()) {
            List<?> peliculas = session.createQuery("FROM Peli_Anotada").list();
            peliculas.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error al recuperar películas: " + e.getMessage());
        }
    }

    private static void buscarPeliculaPorTitulo(String titulo) {
        try (Session session = sessionFactory.openSession()) {
            List<?> peliculas = session.createQuery("FROM Peli p WHERE p.titulo = :titulo")
                                      .setParameter("titulo", titulo)
                                      .list();
            if (peliculas.isEmpty()) {
                System.out.println("No se encontraron películas con ese título.");
            } else {
                peliculas.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error en la búsqueda: " + e.getMessage());
        }
    }
}
