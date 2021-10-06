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
public class DescBreveServicoTest {
    
    /**
     * Test of descCatalogoValido method, of class DescBreveCatalogo.
     */
    @Test
    public void testDescricaoDeServicoParaValoresNULL() {
        System.out.println("descricaoServicoInvalido");
        //Verificação de Descrição de Catálogo null
        DescBreveServico instanceInvalido = new DescBreveServico("");
        boolean expResultInvalido = false;
        boolean result1 = instanceInvalido.descBreveServicoValido();
        assertEquals(expResultInvalido, result1);
    }

    /**
     * Test of descCatalogoValido method, of class DescBreveCatalogo.
     */
    @Test
    public void testDescricaoServicoParaDemasiadosCaracteres() {
        System.out.println("descricaoServicoInvalido");
        //Verificação de Descrição de Catálogo com demasiados caracteres
        boolean expResultInvalido = false;
        DescBreveServico instanceInvalido = new DescBreveServico("erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro ");
        boolean result1 = instanceInvalido.descBreveServicoValido();
        assertEquals(expResultInvalido, result1);
    }
    
    /**
     * Test of descCatalogoValido method, of class DescBreveCatalogo.
     */
    @Test
        public void testDescricaoServicoParaValoresValidos() {
             System.out.println("descricaoServicoValido");
        DescBreveServico instanceValido = new DescBreveServico("Ser1");
        boolean expResultValido = true;
        boolean result = instanceValido.descBreveServicoValido();
        assertEquals(expResultValido, result);
    }
        
    
    /**
     * Test of correcaoDescCatalogo method, of class DescBreveCatalogo.
     */
    @Test
    public void testCorrecaoDescricaoDeServico() {
        System.out.println("correcaoDescricaoServico");
        String stringDescBreve = "valida";
        DescBreveServico instance = new DescBreveServico();
        boolean expResult = true;
        boolean result = instance.correcaoDescBreveServico(stringDescBreve);
        assertEquals(expResult, result);
    }
    
}
