/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.pedidomanagement.domain;


/**
 *
 * @author Guilherme
 */

public enum Urgencia{
    REDUZIDA(3), MODERADA(2), URGENTE(1);
    
    private int valor;
    
    Urgencia(int valor){
        this.valor = valor;
    }
  
    public int getValorUrgencia() {
        return this.valor;
    }
}
