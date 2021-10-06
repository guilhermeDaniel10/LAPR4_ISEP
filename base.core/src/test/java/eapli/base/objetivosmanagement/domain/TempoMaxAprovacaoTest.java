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
public class TempoMaxAprovacaoTest {
    
    public TempoMaxAprovacaoTest() {
    }

  
    @Test(expected = IllegalArgumentException.class)
    public void testEnsureTempoMaxAprovacaoIsNotNegative() {
        System.out.println("TempoMaxAprovacao not negative");
        TempoMaxAprovacao instance = new TempoMaxAprovacao(-1);
        assertTrue(true);
    }
    
    @Test
    public void testValidTempoMaxAprovacao(){
        System.out.println("Valid TempoMaxAprovacao");
        TempoMaxAprovacao instance = new TempoMaxAprovacao(1);
        assertTrue(true);
    }
}
