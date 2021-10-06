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
public class KeywordTest {
   
    
   /**
     * Test of equals method, of class IdentificadorCatalogo.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCreationOfAKeywordEmpltyOrNull() {
        System.out.println("Keyword empty creation");
        Keyword instance1 = new Keyword("");
        assertTrue(true);
    }
    
    /**
     * Test of equals method, of class IdentificadorCatalogo.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCreationOfAKeywordWithNumbers() {
        System.out.println("Keyword with numbers creation");
        Keyword instance1 = new Keyword("11");
        assertTrue(true);
    }
    
    /**
     * Test of equals method, of class IdentificadorCatalogo.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCreationOfAKeywordWithSpecialCharacters() {
        System.out.println("Keyword with special characters creation");
        Keyword instance1 = new Keyword("@/!");
        assertTrue(true);
    }
    
    /**
     * Test of equals method, of class IdentificadorCatalogo.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCreationOfAKeywordWithtwoCharacters() {
        System.out.println("Keyword with two characters creation");
        Keyword instance1 = new Keyword("duas palavras");
        assertTrue(true);
    }
    

    /**
     * Test of equals method, of class IdentificadorCatalogo.
     */
    @Test
    public void testCorrectCreationOfKeyword() {
        System.out.println("Keyword correct creation");
        Keyword instance = new Keyword("key");
        assertTrue(true);
    }
    
}
