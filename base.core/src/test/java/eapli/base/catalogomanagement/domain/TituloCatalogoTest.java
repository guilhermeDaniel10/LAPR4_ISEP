/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.catalogomanagement.domain;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucas
 */
public class TituloCatalogoTest {

    /**
     * Test of tituloCatalogoValido method, of class TituloCatalogo.
     */
    @Test
    public void testTituloCatalogoParaValoresNull() {
        System.out.println("tituloCatalogoValido");
        //Verificação de Descrição de Catálogo null
        TituloCatalogo instanceInvalido = new TituloCatalogo("");
        boolean expResultInvalido = false;
        boolean result1 = instanceInvalido.tituloCatalogoValido();
        assertEquals(expResultInvalido, result1);
    }
    
    /**
     * Test of tituloCatalogoValido method, of class TituloCatalogo.
     */
    @Test
    public void testTituloCatalogoParaValoresValidos(){
        TituloCatalogo instanceValido = new TituloCatalogo("catalogo valido");
        boolean expResultValido = true;
        boolean result = instanceValido.tituloCatalogoValido();
        assertEquals(expResultValido, result);
    }
    
    /**
     * Test of correcaoTituloCatalogo method, of class TituloCatalogo.
     */
    @Test
    public void testCorrecaoTituloCatalogo() {
        System.out.println("correcaoTituloCatalogo");
        String strTituloCatalogo = "Novo Título Válido";
        TituloCatalogo instance = new TituloCatalogo();
        boolean expResult = true;
        boolean result = instance.correcaoTituloCatalogo(strTituloCatalogo);
        assertEquals(expResult, result);
    }
    
}
