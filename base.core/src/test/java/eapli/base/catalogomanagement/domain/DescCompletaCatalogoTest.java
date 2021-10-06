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
public class DescCompletaCatalogoTest {

    /**
     * Test of descCatalogoValido method, of class DescCompletaCatalogo.
     */
    @Test
    public void testDescCatalogoParaValoresNULL() {
        System.out.println("descCatalogoInvalido");
        //Verificação de Descrição de Catálogo null
        DescCompletaCatalogo instanceInvalido = new DescCompletaCatalogo("");
        boolean expResultInvalido = false;
        boolean result1 = instanceInvalido.descCatalogoValido();
        assertEquals(expResultInvalido, result1);
        
        //Verificação de Descrição de Catálogo com demasiados caracteres
        DescCompletaCatalogo instanceInvalido2 = new DescCompletaCatalogo("erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro ");
        boolean result2 = instanceInvalido2.descCatalogoValido();
        assertEquals(expResultInvalido, result2);
        
        DescCompletaCatalogo instanceValido = new DescCompletaCatalogo("Cat1 que é mais que válido");
        boolean expResultValido = true;
        boolean result = instanceValido.descCatalogoValido();
        assertEquals(expResultValido, result);
    }
    
    /**
     * Test of descCatalogoValido method, of class DescCompletaCatalogo.
     */
    @Test
    public void testDescCatalogoParaDemasiadosCaracteres() {
        System.out.println("descCatalogoInvalido");
        //Verificação de Descrição de Catálogo com demasiados caracteres
        boolean expResultInvalido = false;
        DescCompletaCatalogo instanceInvalido2 = new DescCompletaCatalogo("erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro ");
        boolean result2 = instanceInvalido2.descCatalogoValido();
        assertEquals(expResultInvalido, result2);
        
        DescCompletaCatalogo instanceValido = new DescCompletaCatalogo("Cat1 que é mais que válido");
        boolean expResultValido = true;
        boolean result = instanceValido.descCatalogoValido();
        assertEquals(expResultValido, result);
    }
    
        /**
     * Test of descCatalogoValido method, of class DescCompletaCatalogo.
     */
    @Test
    public void testDescCatalogoParaValoresPermitidos() {
        System.out.println("descCatalogoValido");
        DescCompletaCatalogo instanceValido = new DescCompletaCatalogo("Cat1 que é mais que válido");
        boolean expResultValido = true;
        boolean result = instanceValido.descCatalogoValido();
        assertEquals(expResultValido, result);
    }
  
    /**
     * Test of correcaoDescCatalogo method, of class DescCompletaCatalogo.
     */
    @Test
    public void testCorrecaoDescCatalogo() {
        System.out.println("correcaoDescCatalogo");
        String stringDescCompleta = "Cat1 que é mais que válido";
        DescCompletaCatalogo instance = new DescCompletaCatalogo();
        boolean expResult = true;
        boolean result = instance.correcaoDescCatalogo(stringDescCompleta);
        assertEquals(expResult, result);
    }
    
}
