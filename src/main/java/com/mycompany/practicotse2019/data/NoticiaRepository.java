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
package com.mycompany.practicotse2019.data;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import com.mycompany.practicotse2019.model.Noticia;

@ApplicationScoped
public class NoticiaRepository {
/*
    @Inject
    private EntityManager em;

    public Noticia findById(Long id) {
        return em.find(Noticia.class, id);
    }

    public Noticia findByTitulo(String titulo) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Noticia> criteria = cb.createQuery(Noticia.class);
        Root<Noticia> noticia = criteria.from(Noticia.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(noticia).where(cb.equal(noticia.get(Noticia_.name), titulo));
        criteria.select(noticia).where(cb.equal(noticia.get("titulo"), titulo));
        return em.createQuery(criteria).getSingleResult();
    }

    public List<Noticia> findAllOrderedByTitulo() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Noticia> criteria = cb.createQuery(Noticia.class);
        Root<Noticia> noticia = criteria.from(Noticia.class);
        criteria.select(noticia).orderBy(cb.asc(noticia.get("titulo")));
        return em.createQuery(criteria).getResultList();
    }*/
}
