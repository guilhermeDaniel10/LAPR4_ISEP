/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.slamanagement.domain;


import eapli.base.objetivosmanagement.domain.Objetivos;
import eapli.framework.domain.model.AggregateRoot;
import eapli.base.cor.domain.Cor;
import eapli.framework.validations.Preconditions;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author rui3m
 */
@Entity
public class NivelCriticidade implements AggregateRoot<Long>{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNivelCriticidade;

    @OneToOne(cascade = CascadeType.ALL)
    private Objetivos objetivos;

    @Column(name = "designacao", nullable = false)
    private Designacao designacao;

    @Column(name = "etiquetaCriticidade", nullable = false)
    private EtiquetaCriticidade etiquetaCriticidade;

    @Column(name = "valorCriticidade", nullable = false)
    private ValorCriticidade valorCriticidade;

    @OneToOne
    private Cor cor;
    
    protected NivelCriticidade(){
    }

    public NivelCriticidade(Objetivos objetivos, Designacao designacao, EtiquetaCriticidade etiquetaCriticidade, ValorCriticidade valorCriticidade, Cor cor) {
        Preconditions.nonNull(cor);
        Preconditions.nonNull(objetivos);
        Preconditions.nonNull(etiquetaCriticidade);
        Preconditions.nonNull(valorCriticidade);
        Preconditions.nonNull(designacao);
        this.objetivos = objetivos;
        this.designacao = designacao;
        this.etiquetaCriticidade = etiquetaCriticidade;
        this.valorCriticidade = valorCriticidade;
        this.cor = cor;
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
        final NivelCriticidade otherNivelCriticidade = (NivelCriticidade) other;
        if (!Objects.equals(this.idNivelCriticidade, otherNivelCriticidade.idNivelCriticidade)) {
            return false;
        }
        return true;    
    }

    @Override
    public int compareTo(Long other) {
        return AggregateRoot.super.compareTo(other); 
    }

    @Override
    public Long identity() {
        return this.idNivelCriticidade;
    }
    
    public Objetivos objetivos(){
        return this.objetivos;
    }

    @Override
    public String toString() {
        return "Nivel de Criticidade " + "\nEtiqueta Criticidade : " + etiquetaCriticidade + "\nValor Criticidade : " + valorCriticidade + objetivos.toString() + "\n" + cor.toString() + "\n";
    }
    
    public int simpleCriticidadeInt(){
        return this.valorCriticidade.valor;
    }
    
    public String toStringExcerto(){
        return "Nivel de Criticidade: " + this.valorCriticidade;
    }


   
   
}
