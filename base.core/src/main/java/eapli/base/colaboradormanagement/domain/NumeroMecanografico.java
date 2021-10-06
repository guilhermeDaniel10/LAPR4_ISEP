/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.colaboradormanagement.domain;

import eapli.framework.domain.model.ValueObject;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class NumeroMecanografico implements ValueObject, Comparable<NumeroMecanografico>{
    
    private String nmrMecanografico;
    
    @Transient
    private final int LIMITE_DIGITOS = 6;

    public NumeroMecanografico() {
        this.nmrMecanografico = new String();
    }
    
    /**
     * Construtor do número mecanográfico de um colaborador
     * @param nmrMecanografico número que identifica um colaborador e posterior username
     */
    public NumeroMecanografico(final String nmrMecanografico){
        if(nmrMecanografico.isEmpty()){
            throw new IllegalArgumentException("O numero mecanografico nao pode ser vazio/nulo");
        }
        
        if(nmrMecanografico.length() > LIMITE_DIGITOS){
            throw new IllegalArgumentException("Excedeu o limite de digitos do numero mecanografico!");
        }
        this.nmrMecanografico = nmrMecanografico;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        
        NumeroMecanografico nmr = (NumeroMecanografico) obj;
        return this.nmrMecanografico.equals(nmr.nmrMecanografico);
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(this.nmrMecanografico);
    }
    
    @Override
    public int compareTo(NumeroMecanografico o) {
        return this.nmrMecanografico.compareTo(o.nmrMecanografico);
    }
        
    @Override
    public String toString(){
        return this.nmrMecanografico;
    }
    
    public String numeroAsUsername(){
        return this.nmrMecanografico;
    }

    
}
