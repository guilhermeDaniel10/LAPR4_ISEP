/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.objetivosmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import javax.persistence.Embeddable;

/**
 *
 * @author rui3m
 */
@Embeddable
public class TempoMaxResolucao implements ValueObject{
    
    
    int tempo;
    
    protected TempoMaxResolucao(){
        
        
    }
    
    
    protected TempoMaxResolucao(int tempo){
        Preconditions.ensure(tempo>0, "O tempo maximo de resolucao tem de ser maior que 1.");
        this.tempo = tempo;
    }
    
    public int getTempo(){
        return tempo;
    }
    
    public long getTempoMilissegundo(){
        return tempo * 3600000;
    }
        
    @Override
    public String toString(){
        return String.valueOf(tempo);
    }
}
