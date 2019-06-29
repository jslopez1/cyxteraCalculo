/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cyxtera;

import com.cyxtera.impl.CalcularServiceImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 *
 * @author usuario
 */
public class CalcularServiceTest {
    
    public CalcularServiceTest() {
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
     * Test of nuevoAmbiente method, of class CalcularService.
     */
    @Test
    public void testNuevoAmbiente() {
        System.out.println("nuevoAmbiente");
        
        CalcularService instance =Mockito.mock(CalcularServiceImpl.class);
        Integer expResult = null;
        Integer result = instance.nuevoAmbiente();
        assertNotEquals(expResult, result);
        assertTrue("No se logro generar id", result>0);
    }

    /**
     * Test of agregarOperando method, of class CalcularService.
     */
    @Test
    public void testAgregarOperando() {
        System.out.println("agregarOperando");
        int id = 0;
        Double operando = 3d;
        CalcularService instance  =Mockito.mock(CalcularServiceImpl.class);
        String expResult = "";
        String result = instance.agregarOperando(id, operando);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerResultado method, of class CalcularService.
     */
    @Test
    public void testObtenerResultado() {
        System.out.println("obtenerResultado");
        int id = 0;
        String operacion = "suma";
        CalcularService instance = new CalcularServiceImpl();
        String expResult = "";
        String result = instance.obtenerResultado(id, operacion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
}
