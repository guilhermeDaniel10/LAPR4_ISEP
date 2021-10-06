/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.servicomanagement.domain;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
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
public class AtividadeAprovacao implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long identificadorAtividadeAprovacao;

    private boolean responsavelAprovacaoIsHierarquico;

    @ManyToOne(optional = true)
    private Colaborador responsavelAprovacao;
    
    @Column(nullable = true)
    private Date dataAprovacao;

    @ManyToOne(optional = true)
    private Formulario formularioAprovacaoServico;

    public AtividadeAprovacao() {
        //ORM
    }

    public AtividadeAprovacao(boolean responsavelAprovacaoIsHierarquico, Colaborador responsavel, Formulario formularioAprovacaoServico) {
        Preconditions.noneNull(responsavelAprovacaoIsHierarquico, formularioAprovacaoServico);
        this.formularioAprovacaoServico = formularioAprovacaoServico;
        this.responsavelAprovacao = responsavel;
        this.responsavelAprovacaoIsHierarquico = responsavelAprovacaoIsHierarquico;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Keyword)) {
            return false;
        }

        final AtividadeAprovacao that = (AtividadeAprovacao) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }

    @Override
    public Long identity() {
        return this.identificadorAtividadeAprovacao;
    }

    public Colaborador resposavelAprovacao() {
        return this.responsavelAprovacao;
    }
    
    public void changeResponsavelAprovacao(Colaborador newResponsavel){
        this.responsavelAprovacao = newResponsavel;
    }
    
    public boolean isHierarquico(){
        return this.responsavelAprovacaoIsHierarquico;
    }
    
    public Colaborador respostavelAprovacao(){
        return this.responsavelAprovacao;
    }
    
    public Formulario formularioAprovacao(){
        return this.formularioAprovacaoServico;
    }

    public void setDataAprovacao(Date data){
        this.dataAprovacao = data;
    }
    
    public Date dataAprovacao(){
        return this.dataAprovacao;
    }
    
    @Override
    public String toString() {
        return "AtividadeAprovacao{" + "identificadorAtividadeAprovacao=" + identificadorAtividadeAprovacao + ", responsavelAprovacaoIsHierarquico=" + responsavelAprovacaoIsHierarquico + ", formularioAprovacaoServico=" + formularioAprovacaoServico + '}';
    }

}
