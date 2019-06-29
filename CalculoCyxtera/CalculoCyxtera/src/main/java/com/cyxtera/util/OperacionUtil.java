
package com.cyxtera.util;

import java.util.List;

/**
 *  Contiene las clases utilitarias para la ejecucion de operaciones.
 * @author jhon.lopez
 */
public class OperacionUtil {
    
    public static Double sumar(List<Double> operandos){
        Double resultado=0d;
        if(operandos==null){
            return null;
        }
        for (int i = 0; i < operandos.size()-1; i++) {
            if(i==0){
                resultado=operandos.get(i)+operandos.get(i+1);
            }else{
                resultado=resultado+operandos.get(i+1);
            }
        }
        return resultado;
    }
    
    public static Double multiplicar(List<Double> operandos){
        Double resultado=0d;
        if(operandos==null){
            return null;
        }
        for (int i = 0; i < operandos.size()-1; i++) {
            if(i==0){
                resultado=operandos.get(i)*operandos.get(i+1);
            }else{
                resultado=resultado*operandos.get(i+1);
            }
        }
        return resultado;
    }
    public static  Double dividir(List<Double> operandos){
        Double resultado=0d;
        if(operandos==null){
            return null;
        }
        for (int i = 0; i < operandos.size()-1; i++) {
            if(operandos.get(i+1)>=0d){
                if(i==0){

                        resultado=operandos.get(i)/operandos.get(i+1);

                }else{
                    resultado=resultado/operandos.get(i+1);
                }
            }
        }
        return resultado;
    }
    public static  Double restar(List<Double> operandos){
        Double resultado=0d;
        if(operandos==null){
            return null;
        }
        for (int i = 0; i < operandos.size()-1; i++) {
            if(i==0){
                resultado=operandos.get(i)-operandos.get(i+1);
            }else{
                resultado=resultado-operandos.get(i+1);
            }
        }
        return resultado;
    }
    public static  Double potenciacion(List<Double> operandos){
        Double resultado=0d;
        if(operandos==null){
            return null;
        }
        for (int i = 0; i < operandos.size()-1; i++) {
            if(i==0){
                resultado=Math.pow(operandos.get(i),operandos.get(i+1));
            }else{
                resultado=Math.pow(resultado,operandos.get(i+1));
            }
        }
        return resultado;
    }
}
