/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.catalogomanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

/**
 *
 * @author lucas
 */
@Embeddable
public class IdentificadorCatalogo implements ValueObject {

    private String identificadorCatalogo;

    @Transient
    private final int maxSizeId = 6;

    public IdentificadorCatalogo() {
        this.identificadorCatalogo = new String();
    }

    public IdentificadorCatalogo(final String idCatalogo) {
        if (StringPredicates.isNullOrEmpty(idCatalogo)) {
            throw new IllegalArgumentException("O id do Catálogo nao pode ser vazio/nulo");
        }
        if (StringPredicates.isNullOrWhiteSpace(idCatalogo)) {
            throw new IllegalArgumentException("O id do Catálogo tem de ser uma palavra");
        }
        if (idCatalogo.length() > maxSizeId) {
            throw new IllegalArgumentException("O id do Catálogo não pode ser maior que 6 caracteres");
        }
        this.identificadorCatalogo = idCatalogo.toLowerCase();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        IdentificadorCatalogo idCatalogo = (IdentificadorCatalogo) obj;
        if (this.identificadorCatalogo.equalsIgnoreCase(idCatalogo.identificadorCatalogo)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.identificadorCatalogo);
    }

    @Override
    public String toString() {
        return this.identificadorCatalogo;
    }

}
