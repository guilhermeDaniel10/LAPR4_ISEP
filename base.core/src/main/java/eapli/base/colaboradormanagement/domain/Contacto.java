/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.colaboradormanagement.domain;

import eapli.framework.domain.model.ValueObject;
import javax.persistence.Embeddable;
import eapli.framework.strings.util.StringPredicates;
import java.util.Objects;

@Embeddable
public class Contacto implements ValueObject {

    private String indicativo;

    private String numero;

    protected Contacto() {
    }

    public Contacto(final String indicativo, final String numero) {
        if (StringPredicates.isNullOrEmpty(numero)) {
            throw new IllegalArgumentException("Contacto telefonico tem campos null ou vazios!");
        }

        if (StringPredicates.isNullOrEmpty(indicativo)) {
            this.indicativo = "+351";
        } else {
            this.indicativo = indicativo;
        }

        
        this.numero = numero;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Contacto)) {
            return false;
        }

        final Contacto that = (Contacto) o;
        return this.indicativo.equals(that.indicativo)
                && this.numero.equals(that.numero);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.indicativo);
        hash = 97 * hash + Objects.hashCode(this.numero);
        return hash;
    }

    @Override
    public String toString() {
        return "Indicativo: " + indicativo + ";Numero: " + numero;
    }

}
