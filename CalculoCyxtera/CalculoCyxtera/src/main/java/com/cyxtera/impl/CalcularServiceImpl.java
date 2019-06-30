package com.cyxtera.impl;

import com.cyxtera.CalcularService;
import com.cyxtera.auditoria.AuditoriaAdmin;
import com.cyxtera.dto.Ambiente;
import com.cyxtera.enums.EnumOperacion;
import com.cyxtera.util.OperacionUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Singleton;

/**
 * Clase singleton que permite administrar los ambientes.
 * @author jhon.lopez
 */
@Singleton
public class CalcularServiceImpl implements CalcularService {
    @EJB
    private AuditoriaAdmin auditoria;
    
    private List<Ambiente> ambientes;
    private int id = 0;
    private final static Logger LOG = Logger.getLogger(CalcularServiceImpl.class.getName());

    /**
     * Permite crear un nuevo ambiente.
     * @return 
     */
    @Override
    public Integer nuevoAmbiente() {
        id = id + 1;
        try {
            if (ambientes == null) {

                ambientes = new ArrayList<>();
                
                LOG.info("Se instancia el listado de ambientes");
            }
            Ambiente nuevoAmbiente = new Ambiente(id);
            auditoria.enviar("Se agrega el nuevo ambiente al listado de ambientes con id: "+id);
            ambientes.add(nuevoAmbiente);
            LOG.info("Se agrega el el nuevo ambiente al listado de ambientes.");
            return id;
        } catch (Exception e) {
                return 0;
        }
    }
    /**
     * Permite agregar un operando a un ambiente especifico segun su id.
     * @param id
     * @param operando
     * @return 
     */
    @Override
    public String agregarOperando(int id, Double operando) {
        LOG.log(Level.INFO, "Se busca el ambiente con id={0}", id);
        Ambiente ambiente = buscarAmbiente(id);
        if (ambiente != null) {
            LOG.log(Level.INFO, "Se agrega el operando={0}", operando);
            ambiente.getOperandos().add(operando);
            auditoria.enviar("Se agrega el operando: "+operando);
            return "Se agrega el valor "+operando+"al ambiente con id"+id;
        } else {
            LOG.log(Level.WARNING, "No se encuentra el ambiente con id={0}", operando);
            return "No se encuentra el ambiente ";
        }
    }

    /**
     * Permite buscar un ambiente en el listado de ambientes.
     *
     * @param idAmbiente
     * @return
     */

    private Ambiente buscarAmbiente(int idAmbiente) {
        if (ambientes == null) {
            return null;
        }
        for (int i = 0; i < ambientes.size(); i++) {
            Ambiente ambiente = ambientes.get(i);
            if (ambiente.getId() == idAmbiente) {
                return ambiente;
            }
        }
        return null;
    }
    /**
     * Permite obtener el resultado de ejecutar la operacion dada con los 
     * operandos agregados
     * @param id
     * @param operacion
     * @return 
     */
    @Override
    public String obtenerResultado(int id, String operacion) {
        Ambiente ambiente = buscarAmbiente(id);
        Double resultado;
        try {
            if (ambiente == null) {
                LOG.log(Level.WARNING, "No se encuentra el ambiente con id={0}", id);
                return "No se encuentra el ambiente con id="+id;
            }
            if (operacion == null || operacion.isEmpty()) {
                LOG.log(Level.WARNING, "La operacion no es valida con id={0}", id);
                return "Operacion no valida";
            }
            EnumOperacion operacionEnum = EnumOperacion.valueOf(operacion.toUpperCase());
            switch (operacionEnum) {
                case SUMA:
                    resultado = OperacionUtil.sumar(ambiente.getOperandos());
                    break;
                case RESTA:
                    resultado = OperacionUtil.restar(ambiente.getOperandos());
                    break;
                case MULT:
                    resultado = OperacionUtil.multiplicar(ambiente.getOperandos());
                    break;
                case DIV:
                    resultado = OperacionUtil.dividir(ambiente.getOperandos());
                    break;
                case POT:
                    resultado = OperacionUtil.potenciacion(ambiente.getOperandos());
                    break;
                default:
                    return "Operacion no valida";

            }
            LOG.log(Level.INFO, "Se hace la operacion de manera exitosa resultado: {0}", resultado);
            auditoria.enviar("Se obtiene y se agrega al ambiente el resultado: "+resultado);
            ambiente.getOperandos().add(resultado);
            return resultado.toString();
        } catch (Exception ex) {
            LOG.log(Level.SEVERE,"Ocurrio un error al intentar hacer la operacion: "+operacion , ex);
            return "Ocurrio un error al intentar hacer la operacion: "+operacion;
        }
        
    }
    /**
     * Permite obtenera la informacion de auditoria almacenada.
     * @return 
     */
    @Override
    public String obtenerAuditoria(){
       return auditoria.obtenerAuditoria();
    }

}
