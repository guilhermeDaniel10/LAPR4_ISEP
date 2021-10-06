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
public class EtiquetaCriticidade implements ValueObject {

    private String etiquetaCriticidade;
    @Transient
    private final int limiteCarateres = 30;

    
    protected EtiquetaCriticidade(){
    }  
   
    
    public EtiquetaCriticidade(String etiquetaCriticidade){
        Preconditions.nonNull(etiquetaCriticidade, "A etiqueta de criticidade nao pode ser nula.");
        Preconditions.nonEmpty(etiquetaCriticidade, "A etiqueta de criticidade nao pode ser vazia.");
        Preconditions.ensure(etiquetaCriticidade.length()<=limiteCarateres,"A etiqueta de criticidade nao pode ter mais de "+limiteCarateres+" carateres.");
        this.etiquetaCriticidade = etiquetaCriticidade;
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
        final EtiquetaCriticidade other = (EtiquetaCriticidade) o;
        return other.etiquetaCriticidade.equals(this.etiquetaCriticidade);
    }

    @Override
    public String toString() {
        return this.etiquetaCriticidade;
    }
}
