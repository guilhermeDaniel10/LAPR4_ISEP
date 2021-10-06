/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.servicomanagement.domain;

import eapli.base.bibliotecaatividades.domain.Atividade;
import eapli.base.bibliotecaatividades.domain.AtividadeAutomatica;
import eapli.base.bibliotecaatividades.domain.AtividadeManual;
import eapli.base.bibliotecaatividades.domain.AtividadesExistentes;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author lucas
 */
@Entity
public class AtividadeRealizacao implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long identificadorAtividadeRealizacao;

    @ManyToOne(optional = true)
    @AttributeOverride(name = "value", column = @Column(name = "responsavelRealizacao"))
    private Colaborador responsavelRealizacao;

    @ManyToOne(optional = true)
    @AttributeOverride(name = "value", column = @Column(name = "responsaveisRealizacao"))
    private Equipa responsaveisRealizacao;

//    @ManyToOne(optional = true)
//    private Formulario formularioAjuda;
//    @Column(nullable = true)
//    private Script scriptRealizacao;
    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AtividadeAutomatica atividadeAutomatica;

    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AtividadeManual atividadeManual;

    public AtividadeRealizacao() {
        //ORM
    }

    public AtividadeRealizacao(AtividadeAutomatica atividadeAutomatica) {
        Preconditions.noneNull(atividadeAutomatica);
        this.atividadeAutomatica = atividadeAutomatica;
    }

    public AtividadeRealizacao(Formulario formularioAjuda, Equipa responsaveisRealizacao) {
        Preconditions.noneNull(formularioAjuda, responsaveisRealizacao);
        this.atividadeManual = new AtividadeManual(AtividadesExistentes.MANUAL, formularioAjuda);
        this.responsaveisRealizacao = responsaveisRealizacao;
    }

    public AtividadeRealizacao(Formulario formularioAjuda, Colaborador responsavelRealizacao) {
        Preconditions.noneNull(formularioAjuda, responsavelRealizacao);
        this.atividadeManual = new AtividadeManual(AtividadesExistentes.MANUAL, formularioAjuda);
        this.responsavelRealizacao = responsavelRealizacao;
    }

    public AtividadeRealizacao(Colaborador responsavelRealizacao) {
        Preconditions.noneNull(responsavelRealizacao);
        this.responsavelRealizacao = responsavelRealizacao;
    }

    public AtividadeRealizacao(Equipa responsaveisRealizacao) {
        Preconditions.noneNull(responsaveisRealizacao);
        this.responsaveisRealizacao = responsaveisRealizacao;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Keyword)) {
            return false;
        }

        final AtividadeRealizacao that = (AtividadeRealizacao) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }

    @Override
    public Long identity() {
        return this.identificadorAtividadeRealizacao;
    }

    public AtividadeAutomatica atividade() {
        return this.atividadeAutomatica;
    }

    public AtividadeManual atividadeManual() {
        return this.atividadeManual;
    }

    public Equipa responsaveis() {
        return this.responsaveisRealizacao;
    }

    public void changeResponsavel(Colaborador colab) {
        this.responsavelRealizacao = colab;
    }

}
