/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.colaboradormanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author Guilherme
 */
@Embeddable
public class NomeCurto implements ValueObject {

    private String primeiroNome;

    private String ultimoNome;

    public NomeCurto() {
    }

    public NomeCurto(String primeiroNome, String ultimoNome) {
        if (StringPredicates.isNullOrEmpty(primeiroNome) || StringPredicates.isNullOrEmpty(ultimoNome)) {
            throw new IllegalArgumentException("Nome Curto nao pode ser null nem vazio.");
        }

        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this);
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
        final NomeCurto other = (NomeCurto) obj;
        if (!Objects.equals(this.primeiroNome, other.primeiroNome)) {
            return false;
        }
        if (!Objects.equals(this.ultimoNome, other.ultimoNome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Primeiro Nome: " + primeiroNome + "; Ultimo nome: " + ultimoNome + ";";
    }

    public String primeiroNome() {
        return this.primeiroNome;
    }

    public String ultimoNome() {
        return this.ultimoNome;
    }

}
