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
public class DescBreveCatalogoTest {

    /**
     * Test of descCatalogoValido method, of class DescBreveCatalogo.
     */
    @Test
    public void testDescCatalogoParaValoresNULL() {
        System.out.println("descCatalogoValido");
        //Verificação de Descrição de Catálogo null
        DescBreveCatalogo instanceInvalido = new DescBreveCatalogo("");
        boolean expResultInvalido = false;
        boolean result1 = instanceInvalido.descCatalogoValido();
        assertEquals(expResultInvalido, result1);
    }

    /**
     * Test of descCatalogoValido method, of class DescBreveCatalogo.
     */
    @Test
    public void testDescCatalogoParaDemasiadosCaracteres() {
        //Verificação de Descrição de Catálogo com demasiados caracteres
        boolean expResultInvalido = false;
        DescBreveCatalogo instanceInvalido2 = new DescBreveCatalogo("erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro ");
        boolean result2 = instanceInvalido2.descCatalogoValido();
        assertEquals(expResultInvalido, result2);
    }
     /**
     * Test of descCatalogoValido method, of class DescBreveCatalogo.
     */
    @Test
    public void testDescCatalogoParaValoresValidos() {
        DescBreveCatalogo instanceValido = new DescBreveCatalogo("Cat1");
        boolean expResultValido = true;
        boolean result = instanceValido.descCatalogoValido();
        assertEquals(expResultValido, result);
    }
        
    
    /**
     * Test of correcaoDescCatalogo method, of class DescBreveCatalogo.
     */
    @Test
    public void testCorrecaoDescCatalogo() {
        System.out.println("correcaoDescCatalogo");
        String stringDescBreve = "valida";
        DescBreveCatalogo instance = new DescBreveCatalogo();
        boolean expResult = true;
        boolean result = instance.correcaoDescCatalogo(stringDescBreve);
        assertEquals(expResult, result);
    }
    
}
