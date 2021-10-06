/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.colaboradormanagement.domain;

import eapli.base.equipamanagement.domain.Equipa;
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
public class EquipasColaborador implements ValueObject {

    @ManyToOne( fetch = FetchType.LAZY)
    private Equipa equipa;
    
    public EquipasColaborador(){
        
    }
    
    public EquipasColaborador(Equipa equipa){
        this.equipa = equipa;
    }
    
    public Equipa equipaColaborador(){
        return this.equipa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.equipa);
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
        final EquipasColaborador other = (EquipasColaborador) obj;
        if (!Objects.equals(this.equipa, other.equipa)) {
            return false;
        }
        return true;
    }
    
    

   

}
