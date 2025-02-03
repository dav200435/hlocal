/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author joange
 */

@Entity
@Table(name="Peli")
public class Peli_Anotada implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idPeli;
    
    @Column
    private String titulo;
    
    @Column
    private int anyo;
    
    @Column(name="director")
    private String elDirector;
    
    @Embedded
    private IMDB imdb;
    
    

    public Peli_Anotada() {
    }

    public Peli_Anotada(String titulo, int anyo, String elDirector, IMDB imdb) {
        this.titulo = titulo;
        this.anyo = anyo;
        this.elDirector = elDirector;
        this.imdb = imdb;
    }
    
     public Peli_Anotada(String titulo, int anyo, String elDirector) {
        this.titulo = titulo;
        this.anyo = anyo;
        this.elDirector = elDirector;
        this.imdb = imdb;
    }

    public IMDB getImdb() {
        return imdb;
    }

    public void setImdb(IMDB imdb) {
        this.imdb = imdb;
    }

    

    
    
    public Long getIdPeli() {
        return idPeli;
    }

    public void setIdPeli(Long idPeli) {
        this.idPeli = idPeli;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public String getElDirector() {
        return elDirector;
    }

    public void setElDirector(String elDirector) {
        this.elDirector = elDirector;
    }

    @Override
    public String toString() {
        return "Peli_Anotada{" + "idPeli=" + idPeli + ", titulo=" + titulo + ", anyo=" + anyo + ", elDirector=" + elDirector + ", imdb=" + imdb + '}';
    }

   
    
    
}
