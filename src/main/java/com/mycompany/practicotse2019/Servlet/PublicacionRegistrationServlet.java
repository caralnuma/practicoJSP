/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
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
package com.mycompany.practicotse2019.Servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.practicotse2019.service.PublicacionRegistration;
import com.mycompany.practicotse2019.data.PublicacionListProducer;
import com.mycompany.practicotse2019.data.PublicacionListProducer;
import com.mycompany.practicotse2019.model.Publicacion;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;

/**
 * Servlet implementation class PublicacionRegistrationServlet
 */
@WebServlet("/publicacionRegister.do")
public class PublicacionRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private Logger log;
    
    @EJB
    PublicacionRegistration publicacionRegistrationService;

    @Inject
    PublicacionListProducer publicacionListService;
    /**
     * Default constructor.
     */
    public PublicacionRegistrationServlet() {
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StringBuilder errorMessage = new StringBuilder();

        try {

            System.out.println("Descripcion='" + request.getParameter("descripcion") + "'");
            Publicacion publicacion;

            while ((publicacion = publicacionRegistrationService.getNewPublicacion()) == null) {
                publicacionRegistrationService.initNewPublicacion();
            }

            String value;
            int aux;
            if((aux = Integer.parseInt(request.getParameter("id"))) < 1)
                errorMessage.append("Id can not be null\n");
            else{
                publicacion.setId(aux);
            if ((value = request.getParameter("tipo")).length() < 1) {
                errorMessage.append("Tipoo can not be null\n");
            } else {
                publicacion.setTipo(value);

                if ((value = request.getParameter("URL")).length() < 1) {
                    errorMessage.append("URL required!\n");
                } else {
                    publicacion.setURL(value);
                    log("\n*****************Try Registration of Publicacion=" + publicacion);
                    int idNoticia = Integer.parseInt(request.getParameter("idNoticia"));
                    publicacionRegistrationService.register(idNoticia);
                    request.setAttribute("infoMessage", publicacion.getTipo() + " Registered!");
                    }
                }
                List<Publicacion> publicaciones= publicacionListService.getPublicaciones(aux);
                request.setAttribute("publicaciones", publicaciones);
            }
        } catch (Exception e) {

            Throwable t = e;
            while ((t.getCause()) != null) {
                t = t.getCause();
            }

            errorMessage.append("Error========>" + t.getMessage());
            request.setAttribute("infoMessage", "");
            e.printStackTrace();
        } finally {
            request.setAttribute("errorMessage", errorMessage.toString());
            RequestDispatcher resultView = request.getRequestDispatcher("index.jsp");
            resultView.forward(request, response);
        }
    }

}
