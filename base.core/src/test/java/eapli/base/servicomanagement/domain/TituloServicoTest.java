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
public class TituloServicoTest {
    
    /**
     * Test of equals method, of class IdentificadorCatalogo.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCreationTituloNullOrEmpty() {
        System.out.println("Titulo null creation");
        TituloServico instance = new TituloServico("");
        assertTrue(true);
    }

    /**
     * Test of equals method, of class IdentificadorCatalogo.
     */
    @Test
    public void testCorrectTituloCreation() {
        System.out.println("Titulo correct creation");
        TituloServico instance = new TituloServico("Titulo21");
        assertTrue(true);
    }
    
}
