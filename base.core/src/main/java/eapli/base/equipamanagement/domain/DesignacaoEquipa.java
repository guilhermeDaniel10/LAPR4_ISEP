/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.equipamanagement.domain;

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
public class DesignacaoEquipa implements ValueObject {

    @Transient
    private final int limMaxCaracteres = 30;

    private String designacaoEquipa;

    public DesignacaoEquipa() {

    }

    public DesignacaoEquipa(String designacaoEquipa) {
        if (StringPredicates.isNullOrEmpty(designacaoEquipa)) {
            throw new IllegalArgumentException("Designacao da equipa nao pode ser null ou vazia.");
        }
        
        if(designacaoEquipa.length() > limMaxCaracteres){
            throw new IllegalArgumentException("Limite de 30 caracteres excedido.");
        }

        this.designacaoEquipa = designacaoEquipa;
    }
    
    public String designacaValidaDaEquipa(){
        return this.designacaoEquipa;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.designacaoEquipa);
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
        final DesignacaoEquipa other = (DesignacaoEquipa) obj;
        if (!Objects.equals(this.designacaoEquipa, other.designacaoEquipa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.designacaoEquipa;
    }

}
