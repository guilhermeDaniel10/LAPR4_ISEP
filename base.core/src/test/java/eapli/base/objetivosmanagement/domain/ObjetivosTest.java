/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.objetivosmanagement.domain;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rui3m
 */
public class ObjetivosTest {
    
    public ObjetivosTest() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEnsureTempoMedioAprovacaoNotGreaterThanTempoMaxAprovacao() {
        System.out.println("test EnsureTempoMedioAprovacao is Not Greater Than TempoMaxAprovacao");
        Objetivos instance = new Objetivos(1,1,2,1);
        assertTrue(true);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testEnsureTempoMedioResolucaoNotGreaterThanTempoMaxResolucao() {
        System.out.println("test EnsureTempoMedioResolucao is Not Greater Than TempoMaxResolucao");
        Objetivos instance = new Objetivos(1,1,1,2);
        assertTrue(true);
    }
    
    @Test
    public void testValidObjetivos(){
        System.out.println("Test valid objetivos creation");
        Objetivos instance = new Objetivos(1,1,1,1);
        assertTrue(true);
    }
}
