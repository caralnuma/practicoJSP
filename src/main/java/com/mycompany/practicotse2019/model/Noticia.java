/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicotse2019.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import com.mycompany.practicotse2019.model.Publicacion;
import java.util.List;
/**
 *
 * @author Carlox
 */
@XmlRootElement
@Named("Noticia")
@SessionScoped

public class Noticia implements Serializable {
    private Integer id;
    private String titulo;
    private String Descripcion;
    private Integer NroPublicaciones;

    private List<Publicacion> publicaciones;
    public Noticia() {
        this.id=0;
        this.titulo="";
        this.Descripcion="";
        this.NroPublicaciones=0;
        this.publicaciones=new ArrayList<Publicacion>();
    }

    public Noticia(Integer id, String titulo, String Descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.Descripcion = Descripcion;
        this.NroPublicaciones = 0;
        this.publicaciones = new ArrayList<Publicacion>();
    }
    

    public String getDescripcion() {
        return Descripcion;
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Integer getNroPublicaciones() {
        return NroPublicaciones;
    }

    public void setNroPublicaciones(Integer NroPublicaciones) {
        this.NroPublicaciones = NroPublicaciones;
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(List<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }
    
    public void addPublicacion(Publicacion publicacion){
            this.publicaciones.add(publicacion);
    }
    
}
