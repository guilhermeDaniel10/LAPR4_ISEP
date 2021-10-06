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
public class TempoMedioAprovacaoTest {
    
    public TempoMedioAprovacaoTest() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEnsureTempoMedioAprovacaoIsNotNegative() {
        System.out.println("TempoMedioAprovacao not negative");
        TempoMedioAprovacao instance = new TempoMedioAprovacao(-1);
        assertTrue(true);
    }
    
    @Test
    public void testValidTempoMedioAprovacao(){
        System.out.println("Valid TempoMedioAprovacao");
        TempoMedioAprovacao instance = new TempoMedioAprovacao(1);
        assertTrue(true);
    }
    
}
