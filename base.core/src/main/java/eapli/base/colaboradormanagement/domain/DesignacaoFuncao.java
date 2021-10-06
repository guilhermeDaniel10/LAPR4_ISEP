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
public class DesignacaoFuncao implements ValueObject {

    private String designacao;

    public DesignacaoFuncao() {

    }

    public DesignacaoFuncao(String designacao) {
        if (StringPredicates.isNullOrEmpty(designacao)) {
            throw new IllegalArgumentException("Designacao da Funcao nao pode ser null ou vazio.");
        }
        if (designacao.length() > 20) {
            throw new IllegalArgumentException("Designacao da Funcao nao pode ter mais que 20 caracteres.");

        }
        this.designacao = designacao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.designacao);
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
        final DesignacaoFuncao other = (DesignacaoFuncao) obj;
        if (!Objects.equals(this.designacao, other.designacao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Designacao Funcao: " + designacao;
    }
}
