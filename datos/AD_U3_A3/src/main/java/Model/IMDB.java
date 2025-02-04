/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author joange
 */
@Embeddable
public class IMDB implements Serializable {

    @Column
    private String url;

    @Column
    private double nota;

    @Column
    private long votos;

    public IMDB() {
    }

    public IMDB(String url, double nota, long votos) {
        this.url = url;
        this.nota = nota;
        this.votos = votos;
    }

    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public long getVotos() {
        return votos;
    }

    public void setVotos(long votos) {
        this.votos = votos;
    }

    @Override
    public String toString() {
        return "IMDB{" + "url=" + url + ", nota=" + nota + ", votos=" + votos + '}';
    }

    
}
