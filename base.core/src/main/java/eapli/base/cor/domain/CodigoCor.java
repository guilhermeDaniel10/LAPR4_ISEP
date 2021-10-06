/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.cor.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author Guilherme
 */
@Embeddable
public class CodigoCor implements ValueObject {

    private String codigoCor;

    public CodigoCor() {
    }

    public CodigoCor(String codigoCor) {
        if (codigoCor.charAt(0) != '#' && StringPredicates.isNullOrEmpty(codigoCor)) {
            throw new IllegalArgumentException();
        }
        this.codigoCor = codigoCor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.codigoCor);
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
        final CodigoCor other = (CodigoCor) obj;
        if (!Objects.equals(this.codigoCor, other.codigoCor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Codigo cor: " + codigoCor;
    }
}
