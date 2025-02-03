/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package AD_U3_A3;

import Model.IMDB;
import Model.Peli;
import Model.Peli_Anotada;
import org.hibernate.Session;

/**
 *
 * @author joange
 */
public class U3_A3_Ejemplo3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Session laSesion=HibernateUtil.getSessionFactory().getCurrentSession();
       laSesion.getTransaction().begin();
       
       // creamos nueva pelicula
       Peli_Anotada p=new Peli_Anotada("La terminal", 2004, "Steven Spielberg",
                new IMDB("https://www.imdb.com/title/tt0362227/",7.4,438348));
  
       // Guardamos y recuperamos su id
       Long idNueva=(Long)laSesion.save(p);
       
       // Obtenemos de la BBDD la que hemos almacenado
       Peli_Anotada q=laSesion.get(Peli_Anotada.class, idNueva);
       
        System.out.println(q);
        laSesion.getTransaction().commit();
        laSesion.close();
       
    }
    
}
