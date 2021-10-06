/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.formulariomanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author Guilherme
 */
@Embeddable
public class NomeVariavel implements ValueObject{
    
    private String nomeVariavel;
    
    protected NomeVariavel(){
        
    }
    
    public NomeVariavel(String nomeVariavel){
        if(StringPredicates.isNullOrEmpty(nomeVariavel)){
            throw new IllegalArgumentException("Nome da variável do formulário nao pode ser null ou vazio.");
        }
        
        this.nomeVariavel = nomeVariavel;
    }
    
     @Override
    public int hashCode() {
        return Objects.hash(this.nomeVariavel);
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
        final NomeVariavel other = (NomeVariavel) obj;
        if (!Objects.equals(this.nomeVariavel, other.nomeVariavel)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nome variável: " + nomeVariavel;
    }
    
    public String toStringNome(){
        return nomeVariavel;
    }
    
}
