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
public class DescCompServicoTest {
    
        /**
     * Test of descCatalogoValido method, of class DescBreveCatalogo.
     */
    @Test
    public void testDescricaoDeServicoParaValoresNULL() {
        System.out.println("descricaoServicoInvalido");
        //Verificação de Descrição de Catálogo null
        DescCompServico instanceInvalido = new DescCompServico("");
        boolean expResultInvalido = false;
        boolean result1 = instanceInvalido.descCompServicoValido();
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
        DescCompServico instanceInvalido = new DescCompServico("erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro erro ");
        boolean result1 = instanceInvalido.descCompServicoValido();
        assertEquals(expResultInvalido, result1);
    }
    
    /**
     * Test of descCatalogoValido method, of class DescBreveCatalogo.
     */
    @Test
        public void testDescricaoServicoParaValoresValidos() {
        System.out.println("descricaoServicoValido");
        DescCompServico instanceValido = new DescCompServico("Servico mais que valido");
        boolean expResultValido = true;
        boolean result = instanceValido.descCompServicoValido();
        assertEquals(expResultValido, result);
    }
        
    
    /**
     * Test of correcaoDescCompServico method, of class DescBreveCatalogo.
     */
    @Test
    public void testCorrecaoDescricaoDeServico() {
        System.out.println("correcaoDescricaoServico");
        String stringDescComp = "valida";
        DescCompServico instance = new DescCompServico();
        boolean expResult = true;
        boolean result = instance.correcaoDescCompServico(stringDescComp);
        assertEquals(expResult, result);
    }
    
}
