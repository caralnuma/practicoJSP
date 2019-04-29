/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicotse2019.controller;

import com.mycompany.practicotse2019.data.PorotoSingleton;
import com.mycompany.practicotse2019.model.Noticia;
import com.mycompany.practicotse2019.model.Publicacion;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Carlox
 */
public class PorotoImplementador implements PorotoLocal , PorotoRemoto{

    @Inject
    PorotoSingleton porotoSingleton;
    
    @Override
    public List<Noticia> getAllNoticias() {
        return porotoSingleton.getNoticias();
    }

    @Override
    public void addNoticia(Noticia noticia) {
        porotoSingleton.setNoticias(noticia);
    }

    @Override
    public List<Publicacion> getAllPublicaciones(int id){
        return porotoSingleton.getNoticiaById(id).getPublicaciones();
    }
    
    @Override
    public void addPublicacionNoticia(Publicacion publicacion,int id){
        porotoSingleton.addPubblicacionNoticia(id, publicacion);
    }
    
    
}
