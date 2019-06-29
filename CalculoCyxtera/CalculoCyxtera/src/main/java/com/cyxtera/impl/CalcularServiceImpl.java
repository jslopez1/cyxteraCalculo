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
import javax.ejb.Singleton;

/**
 * Clase singleton que permite administrar los ambientes.
 * @author jhon.lopez
 */
@Singleton
public class CalcularServiceImpl implements CalcularService {

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
        if (ambientes == null) {

            ambientes = new ArrayList<>();
            AuditoriaAdmin.enviar("Se instancia el listado de ambientes");
            LOG.info("Se instancia el listado de ambientes");
        }
        Ambiente nuevoAmbiente = new Ambiente(id);
        ambientes.add(nuevoAmbiente);
        LOG.info("Se agrega el el nuevo ambiente al listado de ambientes.");
        return id;
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
            AuditoriaAdmin.enviar("Se agrega el operando: "+operando);
            return "Ok";
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
                return "No se encuentra el ambiente";
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
                case MULTIPLICACION:
                    resultado = OperacionUtil.multiplicar(ambiente.getOperandos());
                    break;
                case DIVISION:
                    resultado = OperacionUtil.dividir(ambiente.getOperandos());
                    break;
                case POTENCIACION:
                    resultado = OperacionUtil.dividir(ambiente.getOperandos());
                    break;
                default:
                    return "Operacion no valida";

            }
            LOG.log(Level.INFO, "Se hace la operacion de manera exitosa resultado: {0}", resultado);
            AuditoriaAdmin.enviar("Se obtiene y se agrega al ambiente el resultado: "+resultado);
            ambiente.getOperandos().add(resultado);
            return resultado.toString();
        } catch (Exception ex) {
            LOG.log(Level.SEVERE,"Ocurrio un error al intentar hacer la operacion: "+operacion , ex);
            return "Ocurrio un error inesperado";
        }
        
    }

}
