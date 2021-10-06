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
public class LocalResidencia implements ValueObject{
    
    private String distrito;
    
    private String concelho;

    public LocalResidencia() {
    }
    
    public LocalResidencia(String distrito, String concelho){
        if(StringPredicates.isNullOrEmpty(distrito) || StringPredicates.isNullOrEmpty(concelho)){
            throw new IllegalArgumentException("Local de residência nao pode ser vazio ou nulo.");
        }
        this.distrito = distrito;
        this.concelho = concelho;
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
        final LocalResidencia other = (LocalResidencia) obj;
        if (!Objects.equals(this.distrito, other.distrito)) {
            return false;
        }
        if (!Objects.equals(this.concelho, other.concelho)) {
            return false;
        }
        return true;
    }
    
    public String toString(){
        return "Distrito: " + this.distrito + "; Concelho: " + this.concelho;
    }
    
    
    
}
