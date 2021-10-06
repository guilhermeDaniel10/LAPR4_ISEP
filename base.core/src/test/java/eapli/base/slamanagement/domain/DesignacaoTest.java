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
public class DesignacaoTest {
    
    @Test(expected = IllegalArgumentException.class)
    public void testEnsureDesignacaoNotNull() {
        System.out.println("test Ensure Designacao Not Null");
        Designacao instance = new Designacao(null);
        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEnsureDesignacaoNotEmpty() {
        System.out.println("test Ensure Designacao Not Empty");
        Designacao instance = new Designacao("");
        assertTrue(true);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testEnsureDesignacaoNotOverCharLimit() {
        System.out.println("test Ensure Designacao over character limit");
        Designacao instance = new Designacao("This string has 31 characters..");
        assertTrue(true);
    }
    
    @Test
    public void testValidDesignacao() {
        Designacao instance = new Designacao("designacao");
        assertTrue(true);
    }
    
}
