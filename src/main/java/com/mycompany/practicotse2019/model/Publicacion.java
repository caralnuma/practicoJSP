/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicotse2019.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlox
 */
@XmlRootElement
public class Publicacion implements Serializable{
  
    @GeneratedValue(strategy=GenerationType.IDENTITY)  
    private Integer id;
    private String tipo;
    private String URL;
    private Noticia noticia;

    public Publicacion(Integer id, String tipo, String URL) {
        this.id = id;
        this.tipo = tipo;
        this.URL = URL;
    }

    public Publicacion() {
    }

    public Integer getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getURL() {
        return URL;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    

}
