/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.colaboradormanagement.domain;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author Guilherme
 */
@Embeddable
public class NomeCompleto implements ValueObject{
    
    private String nomeCompleto;

    public NomeCompleto() {
    }
    
    public NomeCompleto(String nomeCompleto){
        if(StringPredicates.isNullOrEmpty(nomeCompleto)){
            throw new IllegalArgumentException();
        }
        
        this.nomeCompleto = nomeCompleto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        NomeCompleto other = (NomeCompleto) obj;
        if (!Objects.equals(this.nomeCompleto, other.nomeCompleto)) {
            return false;
        }
        return true;
    }
    
    public String toString(){
        return this.nomeCompleto;
    }
    
    
    
    
    
    
}
