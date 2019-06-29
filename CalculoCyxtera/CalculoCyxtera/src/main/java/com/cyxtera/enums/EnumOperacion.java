/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cyxtera.enums;

/**
 *
 * @author jhon.lopez
 */
public enum EnumOperacion {
    SUMA("suma"),RESTA("resta"),MULTIPLICACION("mult"),DIVISION("div"),POTENCIACION("pot");
    
    private final  String operacion;
    
    EnumOperacion(String operacion){
        this.operacion=operacion;
    }

    public String operacion() {
        return operacion;
    }
    
    
}
