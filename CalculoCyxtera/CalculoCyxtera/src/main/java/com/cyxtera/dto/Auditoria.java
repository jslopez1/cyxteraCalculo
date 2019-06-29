/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cyxtera.dto;


import java.util.Date;

/**
 *
 * @author usuario
 */

public class Auditoria {
    
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
