/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.slamanagement.domain;

import eapli.base.objetivosmanagement.domain.Objetivos;
import eapli.base.cor.domain.Cor;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rui3m
 */
public class NivelCriticidadeTest {
    
    public NivelCriticidadeTest() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEnsureObjetivosNotNull() {
        System.out.println("test Ensure Objetivos Not Null");
        //(Objetivos objetivos, Designacao designacao, EtiquetaCriticidade etiquetaCriticidade, ValorCriticidade valorCriticidade, Cor cor) {
        NivelCriticidade instance = new NivelCriticidade(null, new Designacao(), new EtiquetaCriticidade(), new ValorCriticidade(), new Cor());
  
        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEnsureDesignacaoNotNull() {
        System.out.println("test Ensure Designacao Not Null");
        //(Objetivos objetivos, Designacao designacao, EtiquetaCriticidade etiquetaCriticidade, ValorCriticidade valorCriticidade, Cor cor) {
        NivelCriticidade instance = new NivelCriticidade(new Objetivos(1,1,2,2), null, new EtiquetaCriticidade(), new ValorCriticidade(), new Cor());
  
        assertTrue(true);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testEnsureEtiquetaCriticidadeNotNull() {
        System.out.println("test Ensure EtiquetaCriticidade Not Null");
        //(Objetivos objetivos, Designacao designacao, EtiquetaCriticidade etiquetaCriticidade, ValorCriticidade valorCriticidade, Cor cor) {
        NivelCriticidade instance = new NivelCriticidade(new Objetivos(1,1,2,2), new Designacao(), null, new ValorCriticidade(), new Cor());
  
        assertTrue(true);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testEnsureValorCriticidadeNotNull() {
        System.out.println("test Ensure ValorCriticidade Not Null");
        //(Objetivos objetivos, Designacao designacao, EtiquetaCriticidade etiquetaCriticidade, ValorCriticidade valorCriticidade, Cor cor) {
        NivelCriticidade instance = new NivelCriticidade(new Objetivos(1,1,2,2), new Designacao(), new EtiquetaCriticidade(), null, new Cor());
  
        assertTrue(true);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testEnsureCorNotNull() {
        System.out.println("test Ensure Cor Not Null");
        //(Objetivos objetivos, Designacao designacao, EtiquetaCriticidade etiquetaCriticidade, ValorCriticidade valorCriticidade, Cor cor) {
        NivelCriticidade instance = new NivelCriticidade(new Objetivos(1,1,2,2), new Designacao(), new EtiquetaCriticidade(), new ValorCriticidade(), null);
  
        assertTrue(true);
    }
    
}
