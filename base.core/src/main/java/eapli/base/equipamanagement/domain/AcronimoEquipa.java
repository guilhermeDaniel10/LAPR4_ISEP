/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.equipamanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

/**
 *
 * @author Guilherme
 */
@Embeddable
public class AcronimoEquipa implements ValueObject {
    
    private String acronimo;
    
    @Transient
    private final int limiteCaracteres = 10;

    public AcronimoEquipa() {

    }

    public AcronimoEquipa(String acronimo) {
        if (acronimo.length() > limiteCaracteres) {
            throw new IllegalArgumentException("Acronimo da equipa excede 10 caracteres.");
        }
        if (StringPredicates.isNullOrEmpty(acronimo)) {
            throw new IllegalArgumentException("Acronimo da equipa nao pode ser null ou vazio.");
        }
        if(!StringPredicates.isSingleWord(acronimo)){
            throw new IllegalArgumentException("Acronimo da equipa so pode ser uma palavra.");
        }

        this.acronimo = acronimo.toLowerCase();
    }
    
    public String acronimoValidoDaEquipa(){
        return this.acronimo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.acronimo);
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
        final AcronimoEquipa other = (AcronimoEquipa) obj;
        if (!Objects.equals(this.acronimo, other.acronimo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return acronimo;
    }

}
