/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.colaboradormanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Guilherme
 */
@Entity
public class Funcao implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificadorFuncao;

    private CodigoAlfanumerico codigoAlfanumerico;

    @Column(nullable = false)
    private DesignacaoFuncao designacao;

    public Funcao() {

    }

    public Funcao(CodigoAlfanumerico codigoAlfanumerico, DesignacaoFuncao designacao) {
        if (codigoAlfanumerico == null || designacao == null) {
            throw new IllegalArgumentException("Funcao nao pode ser vazio ou nulo.");
        }
        this.codigoAlfanumerico = codigoAlfanumerico;
        this.designacao = designacao;
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {

        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Funcao)) {
            return false;
        }

        final Funcao that = (Funcao) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }

    @Override
    public Long identity() {
        return this.identificadorFuncao;
    }

    public CodigoAlfanumerico codigoFuncao() {
        return this.codigoAlfanumerico;
    }

    public DesignacaoFuncao designacaoFuncao() {
        return this.designacao;
    }

}
