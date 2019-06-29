/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cyxtera;

import javax.ejb.Local;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author usuario
 */

@Local
@Path("/calcular")
public interface CalcularService {
    
    @GET
    @Path("/nuevoAmbiente")
    public Integer nuevoAmbiente();
    @GET
    @Path("/agregarOperando")
    public String agregarOperando(@QueryParam("id") int id,@QueryParam("operando") Double operando);
    @GET
    @Path("/obtenerResultado")
    public String obtenerResultado(@QueryParam("id") int id,@QueryParam("operacion") String operacion);
    
}
