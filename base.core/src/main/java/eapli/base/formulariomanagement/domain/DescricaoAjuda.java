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
public class DescricaoAjuda implements ValueObject{
    
    private String descricaoAjuda;
    
    protected DescricaoAjuda(){
        
    }
    
    public DescricaoAjuda(String descricaoAjuda){
        if(StringPredicates.isNullOrEmpty(descricaoAjuda)){
            throw new IllegalArgumentException("Descricao ajuda nao pode ser null ou vazia");
        }
        
        this.descricaoAjuda = descricaoAjuda;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.descricaoAjuda);
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
        final DescricaoAjuda other = (DescricaoAjuda) obj;
        if (!Objects.equals(this.descricaoAjuda, other.descricaoAjuda)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Descricao de ajuda: " + descricaoAjuda;
    }
    
    public String descricao(){
        return this.descricaoAjuda;
    }
    
}
