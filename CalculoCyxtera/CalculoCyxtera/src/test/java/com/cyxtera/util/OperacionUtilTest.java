package com.cyxtera.util;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Permite probar el correcto funcionamiento de la clase utilitaria OperacionUtil.
 * @author jhon.lopez
 */
public class OperacionUtilTest {
    
    public OperacionUtilTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of sumar method, of class OperacionUtil.
     */
    @Test
    public void testSumar() {
        System.out.println("sumar");
        List<Double> operandos = new ArrayList<>() ;
        operandos.add(5d);
        operandos.add(4d);
        operandos.add(3d);
        Double expResult = 12d;
        Double result = OperacionUtil.sumar(operandos);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of multiplicar method, of class OperacionUtil.
     */
    @Test
    public void testMultiplicar() {
        System.out.println("multiplicar");
        List<Double> operandos = new ArrayList<>() ;
        operandos.add(5d);
        operandos.add(4d);
        operandos.add(3d);
        Double expResult = 60d;
        Double result = OperacionUtil.multiplicar(operandos);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of dividir method, of class OperacionUtil.
     */
    @Test
    public void testDividir() {
        System.out.println("dividir");
        List<Double> operandos = new ArrayList<>() ;
        operandos.add(5d);
        operandos.add(4d);
        operandos.add(3d);
        Double expResult = 0.4166666666666667;
        Double result = OperacionUtil.dividir(operandos);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of restar method, of class OperacionUtil.
     */
    @Test
    public void testRestar() {
        System.out.println("restar");
        List<Double> operandos = new ArrayList<>() ;
        operandos.add(5d);
        operandos.add(4d);
        operandos.add(3d);
        Double expResult = -2d;
        Double result = OperacionUtil.restar(operandos);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of potenciacion method, of class OperacionUtil.
     */
    @Test
    public void testPotenciacion() {
        System.out.println("potenciacion");
        List<Double> operandos = new ArrayList<>() ;
        operandos.add(5d);
        operandos.add(4d);
        operandos.add(3d);
        Double expResult = 244140625d;
        Double result = OperacionUtil.potenciacion(operandos);
        assertEquals(expResult, result);
    }
    
}
