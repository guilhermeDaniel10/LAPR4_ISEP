/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.servicomanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author lucas
 */
@Entity
public class Workflow implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long identificadorWorkflow;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private AtividadeAprovacao atividadeAprovacaoServico;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private AtividadeRealizacao atividadeRealizacaoServico;

    public Workflow() {
        //ORM
    }

    public Workflow(AtividadeAprovacao atividadeAprovacaoServico, AtividadeRealizacao atividadeRealizacaoServico) {
        this.atividadeAprovacaoServico = atividadeAprovacaoServico;
        this.atividadeRealizacaoServico = atividadeRealizacaoServico;
    }

    public Workflow(AtividadeRealizacao atividadeRealizacaoServico) {
        this.atividadeRealizacaoServico = atividadeRealizacaoServico;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Keyword)) {
            return false;
        }

        final Workflow that = (Workflow) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity())
                && this.atividadeAprovacaoServico.equals(that.atividadeAprovacaoServico)
                && this.atividadeRealizacaoServico.equals(that.atividadeRealizacaoServico);
    }

    @Override
    public Long identity() {
        return this.identificadorWorkflow;
    }

    public AtividadeRealizacao atividadeRealizacaoWorkflow() {
        return this.atividadeRealizacaoServico;
    }

    public AtividadeAprovacao atividadeAprovacaoWorkflow() {
        return this.atividadeAprovacaoServico;
    }

}
