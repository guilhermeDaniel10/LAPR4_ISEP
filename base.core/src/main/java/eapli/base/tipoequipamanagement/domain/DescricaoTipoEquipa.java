/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.tipoequipamanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

/**
 *
 * @author Guilherme
 */
@Embeddable
public class DescricaoTipoEquipa implements ValueObject{
    
    private String descricaoTipoEquipa;
    
    @Transient
    private final int limiteCaracteres = 30;
    
    public DescricaoTipoEquipa(){
        
    }
    
    public DescricaoTipoEquipa (String descricaoTipoEquipa){
        if(StringPredicates.isNullOrEmpty(descricaoTipoEquipa)){
            throw new IllegalArgumentException("Descricao do tipo de equipa nao pode ser null ou vazia.");
        }
        if(descricaoTipoEquipa.length() > limiteCaracteres){
            throw new IllegalArgumentException("A descricao apenas pode ter 30 caracteres!");
        }
        this.descricaoTipoEquipa = descricaoTipoEquipa;
    }
    
       @Override
    public int hashCode() {
        return Objects.hash(this.descricaoTipoEquipa);
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
        final DescricaoTipoEquipa other = (DescricaoTipoEquipa) obj;
        if (!Objects.equals(this.descricaoTipoEquipa, other.descricaoTipoEquipa)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return "Descricao do Tipo de Equipa: " + descricaoTipoEquipa;
    }
}
