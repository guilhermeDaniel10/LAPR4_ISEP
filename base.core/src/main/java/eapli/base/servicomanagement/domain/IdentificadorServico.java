/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.servicomanagement.domain;

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
public class IdentificadorServico implements ValueObject, Comparable<IdentificadorServico> {

    private String identificadorServico;

    @Transient
    private final int maxSizeIdServico = 6;

    public IdentificadorServico() {
        this.identificadorServico = new String();
    }

    public IdentificadorServico(final String idServico) {
        if (StringPredicates.isNullOrEmpty(idServico)) {
            throw new IllegalArgumentException("O id do Servico nao pode ser vazio/nulo");
        }
        if (StringPredicates.isNullOrWhiteSpace(idServico)) {
            throw new IllegalArgumentException("O id do Servico tem de ser uma palavra");
        }
        if (idServico.length() > maxSizeIdServico) {
            throw new IllegalArgumentException("O id do Servico não pode ser maior que 6 caracteres");
        }
        this.identificadorServico = idServico.toLowerCase();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        IdentificadorServico id = (IdentificadorServico) obj;
        if (!Objects.equals(this.identificadorServico, id.identificadorServico)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.identificadorServico);
    }

    @Override
    public int compareTo(IdentificadorServico o) {
        return this.identificadorServico.compareTo(o.identificadorServico);
    }

    @Override
    public String toString() {
        return this.identificadorServico;
    }
}
