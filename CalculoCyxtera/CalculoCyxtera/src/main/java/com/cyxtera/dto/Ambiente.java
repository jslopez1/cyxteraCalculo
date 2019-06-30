package com.cyxtera.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Se crea clase que define los atributos de los ambientes que cree el usuario.
 * @author jhon.lopez  
 */
public class Ambiente implements Serializable{
     private static final long serialVersionUID = 35432L;
    private int id;
    private List<Double> operandos;

    public Ambiente(int id) {
        this.id = id;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Double> getOperandos() {
        if(operandos==null){
            operandos=new ArrayList<>();
        }
        return operandos;
    }

    

    
    
    
}
