/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicotse2019.controller;

import java.util.List;
import javax.ejb.Local;
import com.mycompany.practicotse2019.model.Noticia;
import com.mycompany.practicotse2019.model.Publicacion;

/**
 *
 * @author Carlox
 */
@Local
public interface PorotoLocal {
    
    List<Noticia> getAllNoticias();
    
    void addNoticia(Noticia noticia);
    
    List<Publicacion> getAllPublicaciones(int id);
    
    void addPublicacionNoticia(Publicacion publicacion,int id);
    
   // List<Publicacion> getAllPublicaciones(int idNoticia);
    
}
