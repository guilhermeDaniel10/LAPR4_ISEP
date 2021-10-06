/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.servicomanagement.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucas
 */
public class IdentificadorServicoTest {
    
    /**
     * Test of equals method, of class IdentificadorCatalogo.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCreationErrorNullOrEmptyId() {
        System.out.println("Id creation");
        IdentificadorServico instance1 = new IdentificadorServico("");
        assertTrue(true);
    }
    
    /**
     * Test of equals method, of class IdentificadorCatalogo.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCreationErrorTwoWordsInId() {
        System.out.println("Id creation");
        IdentificadorServico instance2 = new IdentificadorServico("Duas Palavras");
        assertTrue(true);
    }
    
    /**
     * Test of equals method, of class IdentificadorCatalogo.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCreationMaxLeghtId() {
        System.out.println("Id creation");
        IdentificadorServico instance3 = new IdentificadorServico("1234567");
        assertTrue(true);
    }

    /**
     * Test of equals method, of class IdentificadorCatalogo.
     */
    @Test
    public void testCreationIdValido() {
        System.out.println("Id creation");
        IdentificadorServico instance = new IdentificadorServico("Ser1");
        assertTrue(true);
    }
}
