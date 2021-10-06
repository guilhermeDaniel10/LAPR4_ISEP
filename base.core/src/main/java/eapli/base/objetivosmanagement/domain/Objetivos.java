/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.objetivosmanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;
import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author rui3m
 */
@Entity
public class Objetivos implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idObjetivos;

    @AttributeOverrides({
        @AttributeOverride(name = "tempo", column = @Column(name = "tempoMaxAprovacao_tempo"))})
    private TempoMaxAprovacao tempoMaxAprovacao;
    @AttributeOverrides({
        @AttributeOverride(name = "tempo", column = @Column(name = "tempoMaxResolucao_tempo"))})
    private TempoMaxResolucao tempoMaxResolucao;
    @AttributeOverrides({
        @AttributeOverride(name = "tempo", column = @Column(name = "tempoMedioAprovacao_tempo"))})
    private TempoMedioAprovacao tempoMedioAprovacao;
    @AttributeOverrides({
        @AttributeOverride(name = "tempo", column = @Column(name = "tempoMedioResolucao_tempo"))})
    private TempoMedioResolucao tempoMedioResolucao;

    protected Objetivos() {

    }

    public Objetivos(int tempoMaxAprovacao_tempo, int tempoMaxResolucao_tempo, int tempoMedioAprovacao_tempo, int tempoMedioResolucao_tempo) {
        Preconditions.ensure(tempoMaxAprovacao_tempo >= tempoMedioAprovacao_tempo, "O tempo maximo de aprovacao tem de ser maior que o tempo medio de aprovacao.");
        Preconditions.ensure(tempoMaxResolucao_tempo >= tempoMedioResolucao_tempo, "O tempo maximo de resolucao tem de ser maior que o tempo medio de resolucao.");
        tempoMaxAprovacao = new TempoMaxAprovacao(tempoMaxAprovacao_tempo);
        tempoMaxResolucao = new TempoMaxResolucao(tempoMaxResolucao_tempo);
        tempoMedioAprovacao = new TempoMedioAprovacao(tempoMedioAprovacao_tempo);
        tempoMedioResolucao = new TempoMedioResolucao(tempoMedioResolucao_tempo);
    }

    @Override
    public String toString() {
        return "\nTempo Maximo de Aprovacao = " + tempoMaxAprovacao + "\nTempo Maximo de Resolucao = " + tempoMaxResolucao + "\nTempo Medio de Aprovacao = " + tempoMedioAprovacao + "\nTempo Medio de Resolucao = " + tempoMedioResolucao;
    }

    @Override
    public boolean sameAs(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (getClass() != other.getClass()) {
            return false;
        }
        final Objetivos otherObjetivos = (Objetivos) other;
        if (!Objects.equals(this.tempoMaxAprovacao.getTempo(), otherObjetivos.tempoMaxAprovacao.getTempo())) {
            return false;
        }
        if (!Objects.equals(this.tempoMaxResolucao.getTempo(), otherObjetivos.tempoMaxResolucao.getTempo())) {
            return false;
        }
        if (!Objects.equals(this.tempoMedioResolucao.getTempo(), otherObjetivos.tempoMedioResolucao.getTempo())) {
            return false;
        }
        if (!Objects.equals(this.tempoMedioAprovacao.getTempo(), otherObjetivos.tempoMedioAprovacao.getTempo())) {
            return false;
        }
        return true;
    }

    @Override
    public Long identity() {
        return this.idObjetivos;
    }

    public TempoMedioResolucao tempoMedioResolucao() {
        return this.tempoMedioResolucao;
    }

    public TempoMaxAprovacao tempoMaxAprovacao(){
        return this.tempoMaxAprovacao;
    }
    
    public TempoMaxResolucao tempoMaxResolucao(){
        return this.tempoMaxResolucao;
    }
                
    public  TempoMedioAprovacao tempoMedioAprovacao(){
        return this.tempoMedioAprovacao;
    }
         
}
