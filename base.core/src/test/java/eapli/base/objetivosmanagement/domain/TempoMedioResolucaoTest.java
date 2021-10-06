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
public class TempoMedioResolucaoTest {
    
    public TempoMedioResolucaoTest() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEnsureTempoMedioResolucaoIsNotNegative() {
        System.out.println("TempoMedioResolucao not negative");
        TempoMedioResolucao instance = new TempoMedioResolucao(-1);
        assertTrue(true);
    }
    
    @Test
    public void testValidTempoMedioResolucao(){
        System.out.println("Valid TempoMedioResolucao");
        TempoMedioResolucao instance = new TempoMedioResolucao(1);
        assertTrue(true);
    }
}
