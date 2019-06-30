package com.cyxtera;


import javax.ejb.Local;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Interface que expone las operaciones del servicio Restful.
 * @author jhon.lopez
 */

@Local
@Path("/calcular")
public interface CalcularService {
    /**
     * Permite generar un nuevo ambiente para realizar las operaciones.
     * @return 
     */
    @GET
    @Path("/nuevoAmbiente")
    public Integer nuevoAmbiente();
     /**
     * Permite generar un operando asociado a un ambiente previamente creado.
     * @param id
     * @param operando
     * @return 
     */
    @GET
    @Path("/agregarOperando")
    public String agregarOperando(@QueryParam("id") int id,@QueryParam("operando") Double operando);
    /**
     * Permite obtener el resultado de ejecutar una opracion dada.
     * @param id
     * @param operacion
     * @return 
     */
    @GET
    @Path("/obtenerResultado")
    public String obtenerResultado(@QueryParam("id") int id,@QueryParam("operacion") String operacion);
    /**
     * Permite obtenera la informacion de auditoria almacenada.
     * @return 
     */
    @GET
    @Path("/obtenerAuditoria")
    @Produces(MediaType.APPLICATION_JSON)
    public String obtenerAuditoria();
}
