/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.catalogomanagement.domain;

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
public class IdentificadorCatalogoTest {
    
    /**
     * Test of equals method, of class IdentificadorCatalogo.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCreationErrorNullId() {
        System.out.println("Id creation");
        IdentificadorCatalogo instance1 = new IdentificadorCatalogo("");
        assertTrue(true);
    }
    
    /**
     * Test of equals method, of class IdentificadorCatalogo.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCreationErrorTwoWordsId() {
        System.out.println("Id creation");
        IdentificadorCatalogo instance2 = new IdentificadorCatalogo("Duas Palavras");
        assertTrue(true);
    }
    
    /**
     * Test of equals method, of class IdentificadorCatalogo.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCreationMaxLeghtId() {
        System.out.println("Id creation");
        IdentificadorCatalogo instance3 = new IdentificadorCatalogo("1234567");
        assertTrue(true);
    }

    /**
     * Test of equals method, of class IdentificadorCatalogo.
     */
    @Test
    public void testCreationId() {
        System.out.println("Id creation");
        IdentificadorCatalogo instance = new IdentificadorCatalogo("Cat1");
        assertTrue(true);
    }
    
}
