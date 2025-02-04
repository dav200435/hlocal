/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author joange
 */
public class Peli implements Serializable{
    
    
    private Long idPeli;
    private String titulo;
    private int anyo;
    private String elDirector;

    public Peli() {
    }

    public Peli(String titulo, int anyo, String elDirector) {
        this.titulo = titulo;
        this.anyo = anyo;
        this.elDirector = elDirector;
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
        return "Peli{" + "idPeli=" + idPeli + ", titulo=" + titulo + ", anyo=" + anyo + ", elDirector=" + elDirector + '}';
    }
    
    
    
}
