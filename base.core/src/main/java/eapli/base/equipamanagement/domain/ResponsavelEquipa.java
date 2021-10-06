/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.equipamanagement.domain;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.framework.domain.model.ValueObject;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 *
 * @author Guilherme
 */
@Embeddable
public class ResponsavelEquipa implements ValueObject{
    
    @ManyToOne( fetch = FetchType.LAZY)
    private Colaborador responsavel;
    
    public ResponsavelEquipa(){
        
    }
    
    public ResponsavelEquipa(Colaborador responsavel){
        this.responsavel = responsavel;
    }
    
    public Colaborador colaboradorResposavel(){
        return this.responsavel;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.responsavel);
        return hash;
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
        final ResponsavelEquipa other = (ResponsavelEquipa) obj;
        if (!other.responsavel.equals(this.responsavel)) {
            return false;
        }
        return true;
    }
    
    
    
}
