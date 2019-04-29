/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicotse2019.data;

import javax.ejb.Singleton;
import com.mycompany.practicotse2019.model.Noticia;
import com.mycompany.practicotse2019.model.Publicacion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 *
 * @author Carlox
 */

@Singleton
public class PorotoSingleton {
    
    
    private List<Noticia> noticias=new ArrayList<>();
    
    

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(Noticia noticia) {
        this.noticias.add(noticia);
    }
    
    public Noticia getNoticiaById(int aux){
        Iterator<Noticia> i=noticias.iterator();
        Noticia auxNoticia=new Noticia();
        boolean control=false;
        while( i.hasNext() && !control){
            auxNoticia=i.next();
            if(auxNoticia.getId()==aux){
                control=true;
                return auxNoticia;
            }
        }
        return null;
    }
    
    public void addPubblicacionNoticia(int id,Publicacion publicacion){
        Iterator<Noticia> i=noticias.iterator();
        boolean control=false;
        int publicaciones=0;
        Noticia auxNoticia=new Noticia();
        while( i.hasNext() && !control){
            auxNoticia=i.next();
            if(auxNoticia.getId()==id){
                control=true;
               auxNoticia.addPublicacion(publicacion);
                publicaciones=auxNoticia.getNroPublicaciones()+1;
                auxNoticia.setNroPublicaciones(publicaciones);
            }
        }
    }
}
    
    
    

