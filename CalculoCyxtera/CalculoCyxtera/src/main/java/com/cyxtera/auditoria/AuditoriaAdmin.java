/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cyxtera.auditoria;

import com.cyxtera.dto.Ambiente;
import com.cyxtera.dto.Auditoria;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Singleton;

import javax.ws.rs.client.Client;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;

/**
 * Clase que permite guardar auditoria en base de datos NonSql
 *
 * @author jhon.lopez
 */
@Singleton
public  class AuditoriaAdmin {
    private final static String URL = "https://cyxteraprueba.firebaseio.com/.json";
    private final static Logger LOG= Logger.getLogger(AuditoriaAdmin.class.getName());
   
    
    /**
     * Permite enviar mensajes de auditoria a la base de datos
     * @param texto
     * @return 
     */
    public  Boolean enviar(String texto) {
        try {
            Client cliente = ClientBuilder.newClient(new ClientConfig().register(JacksonJsonProvider.class));
            Response auditoriaResult = cliente.target(URL)
                    .request().post(Entity.entity(new Auditoria(new Date(), texto), MediaType.APPLICATION_JSON));
            if (auditoriaResult != null && auditoriaResult.hasEntity()) {
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE,"Ocurrio un error al guardar la auditoria",e);
             return Boolean.FALSE;
        }
    }
    /**
     * Permite consultar la auditoria almacenada.
     * @return 
     */
    public String obtenerAuditoria() {
       Client cliente = ClientBuilder.newClient(new ClientConfig().register(JacksonJsonProvider.class));
       WebTarget webtarget = cliente.target("https://cyxteraprueba.firebaseio.com/.json");
       String resultado= webtarget.request().get(String.class);
       return resultado!=null?resultado:"";
    }
}
