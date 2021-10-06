/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.slamanagement.domain;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rui3m
 */
public class EtiquetaCriticidadeTest {
    
    public EtiquetaCriticidadeTest() {
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testEnsureEtiquetaCriticidadeNotNull() {
        System.out.println("test Ensure Etiqueta Criticidade Not Null");
        EtiquetaCriticidade instance = new EtiquetaCriticidade(null);
        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEnsureEtiquetaCriticidadeNotEmpty() {
        System.out.println("test Ensure Etiqueta Criticidade Not Empty");
        EtiquetaCriticidade instance = new EtiquetaCriticidade("");
        assertTrue(true);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testEnsureEtiquetaCriticidadeNotOverCharLimit() {
        System.out.println("test Ensure Etiqueta Criticidade over character limit");
        EtiquetaCriticidade instance = new EtiquetaCriticidade("This string has 31 characters..");
        assertTrue(true);
    }
    
    @Test
    public void testValidEtiquetaCriticidade() {
        EtiquetaCriticidade instance = new EtiquetaCriticidade("etiqueta");
        assertTrue(true);
    }
}
