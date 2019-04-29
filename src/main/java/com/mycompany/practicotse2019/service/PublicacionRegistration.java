/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mycompany.practicotse2019.service;

import com.mycompany.practicotse2019.controller.PorotoLocal;
import com.mycompany.practicotse2019.model.Publicacion;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

// The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateful
@Model
public class PublicacionRegistration {

    @Inject
    private Logger log;

    @Inject
    private PorotoLocal em;

    @Inject
    private Event<Publicacion> publicacionEventSrc;

    private Publicacion newPublicacion;

    @Produces
    public Publicacion getNewPublicacion() {

        log.info("getNewPublicacion: called" + newPublicacion);
        return newPublicacion;
        

    }

    public void register(int id) throws Exception {

        try {

            log.info("Registering " + newPublicacion.getTipo());
            em.addPublicacionNoticia(newPublicacion, id);
            publicacionEventSrc.fire(newPublicacion);
            initNewPublicacion();
        } catch (Exception e) {
            Throwable t = e;
            while ((t.getCause()) != null) {
                t = t.getCause();
            }
            log.info("Exception:" + t.getMessage());
            throw ((Exception) t);
        }

    }

    @PostConstruct
    @TransactionAttribute
    public void initNewPublicacion() {
        newPublicacion = new Publicacion();
        log.info("@PostConstruct:initNewPublicacion called");
    }
}
