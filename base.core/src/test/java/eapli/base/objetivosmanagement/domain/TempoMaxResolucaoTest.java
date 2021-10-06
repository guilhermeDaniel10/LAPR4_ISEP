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
public class TempoMaxResolucaoTest {
    
    public TempoMaxResolucaoTest() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEnsureTempoMaxResolucaoIsNotNegative() {
        System.out.println("TempoMaxResolucao not negative");
        TempoMaxResolucao instance = new TempoMaxResolucao(-1);
        assertTrue(true);
    }
    
    @Test
    public void testValidTempoMaxResolucao(){
        System.out.println("Valid TempoMaxResolucao");
        TempoMaxResolucao instance = new TempoMaxResolucao(1);
        assertTrue(true);
    }
}
