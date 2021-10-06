/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.slamanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

/**
 *
 * @author rui3m
 */
@Embeddable
public class Designacao implements ValueObject {
    
    

    private String designacao;
    @Transient
    private final int limiteCarateres = 30;

    protected Designacao(){
    }  
   
    
    public Designacao(String designacao){
        Preconditions.nonEmpty(designacao, "A designacao nao pode ser vazia.");
        Preconditions.ensure(designacao.length()<=limiteCarateres,"A designacao não pode ter mais de "+limiteCarateres+" carateres.");
        this.designacao = designacao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if(o == null){
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        final Designacao other = (Designacao) o;
        return other.designacao.equals(this.designacao);
    }

    @Override
    public String toString() {
        return this.designacao;
    }
}
