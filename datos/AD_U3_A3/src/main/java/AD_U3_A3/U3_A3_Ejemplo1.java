/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package AD_U3_A3;

import Model.Peli;
import org.hibernate.Session;

/**
 *
 * @author joange
 */
public class U3_A3_Ejemplo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Session laSesion=HibernateUtil.getSessionFactory().getCurrentSession();
       laSesion.getTransaction().begin();
       
       // creamos nueva pelicula
       Peli p=new Peli("Despertares", 1990, "Penny Marshall");
       
        System.out.println(p);
  
       // Guardamos y recuperamos su id
       Long idNueva=(Long)laSesion.save(p);
       
       // Obtenemos de la BBDD la que hemos almacenado
       Peli q=laSesion.get(Peli.class, idNueva);
       
        System.out.println(q);
        laSesion.getTransaction().commit();
        laSesion.close();
       
    }
    
}
