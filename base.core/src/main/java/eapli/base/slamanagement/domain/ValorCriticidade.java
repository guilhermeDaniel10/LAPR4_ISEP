/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.slamanagement.domain;

import eapli.framework.domain.model.ValueObject;
import javax.persistence.Embeddable;

/**
 *
 * @author rui3m
 */
@Embeddable
public class ValorCriticidade implements ValueObject {
    
    int valor;
    
    protected ValorCriticidade(){
    
    }
    
    public ValorCriticidade(int valor){
        this.valor = valor;
    }
    
    
    @Override
    public String toString(){
        return String.valueOf(valor);
    }
}
