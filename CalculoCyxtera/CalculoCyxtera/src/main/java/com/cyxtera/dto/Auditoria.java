package com.cyxtera.dto;


import java.io.Serializable;
import java.util.Date;

/**
 * Clase que permite transportar la informacion de auditoria.
 * @author jhon.lopez
 */

public class Auditoria implements Serializable{
     private static final long serialVersionUID = 7895L;
    
    private Date fechaAuditoria;
    
    private String mensaje;

    public Auditoria(Date fechaAuditoria, String mensaje) {
        this.fechaAuditoria = fechaAuditoria;
        this.mensaje = mensaje;
    }

    
    public Date getFechaAuditoria() {
        return fechaAuditoria;
    }

    public void setFechaAuditoria(Date fechaAuditoria) {
        this.fechaAuditoria = fechaAuditoria;
    }
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
