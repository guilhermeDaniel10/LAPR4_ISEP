/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.formulariomanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.domain.model.ValueObject;
import java.io.Serializable;
import java.util.Comparator;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

/**
 *
 * @author Guilherme
 */
@Entity
public class Atributo implements AggregateRoot<Long>, Comparator<Atributo>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificadorAtributo;

    @Column(nullable = false)
    private Integer posicaoForContext;

    private NomeVariavel nomeVariavel;

    private EtiquetaAtributo etiqueta;

    private DescricaoAjuda descricaoAjuda;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DadosBase dadosbase;

    @AttributeOverrides({
        @AttributeOverride(name = "expressao", column = @Column(name = "expressaoRegularCampo"))})
    private ExpressaoRegular expressaoRegular;

    @AttributeOverrides({
        @AttributeOverride(name = "expressao", column = @Column(name = "expressaoResposta", nullable = true))})
    private ExpressaoRegular expressaoResposta;

    private String obrigatoriedade;

    private int dependencia;

    public Atributo() {

    }

    public Atributo(int posicao, String obrigatoriedade, int dependencia, NomeVariavel nomeVariavel, EtiquetaAtributo etiqueta, DescricaoAjuda descricaoAjuda,
            DadosBase dadosBase, ExpressaoRegular expressaoRegular) {
        this.nomeVariavel = nomeVariavel;
        this.etiqueta = etiqueta;
        this.descricaoAjuda = descricaoAjuda;
        this.dadosbase = dadosBase;
        this.expressaoRegular = expressaoRegular;
        this.posicaoForContext = posicao;
        this.obrigatoriedade = obrigatoriedade;
        this.dependencia = dependencia;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Atributo)) {
            return false;
        }

        final Atributo that = (Atributo) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }

    @Override
    public Long identity() {
        return this.identificadorAtributo;
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    public NomeVariavel nomeVariavel() {
        return this.nomeVariavel;
    }

    public EtiquetaAtributo etiquetaAtributo() {
        return this.etiqueta;
    }

    public DescricaoAjuda descricaoAjuda() {
        return this.descricaoAjuda;
    }

    public DadosBase dadoBase() {
        return this.dadosbase;
    }

    public void fillRespostaEsperadaDependencia(ExpressaoRegular exp) {
        if (exp == null) {
            return;
        }
        this.expressaoResposta = exp;
    }

    public ExpressaoRegular expressaoRegular() {
        return this.expressaoRegular;
    }

    public String obrigatoriedadeAtributo() {
        return this.obrigatoriedade;
    }

    public int dependeciaAtributo() {
        return this.dependencia;
    }

    public int posicaoForContext() {
        return this.posicaoForContext;
    }

    public ExpressaoRegular expResposta() {
        return this.expressaoResposta;
    }

    @Override
    public String toString() {
        return "Atributo{" + "identificadorAtributo=" + identificadorAtributo + ", posicaoForContext=" + posicaoForContext + ", nomeVariavel=" + nomeVariavel + ", etiqueta=" + etiqueta + ", descricaoAjuda=" + descricaoAjuda + ", dadosbase=" + dadosbase + ", expressaoRegular=" + expressaoRegular + ", expressaoResposta=" + expressaoResposta + ", obrigatoriedade=" + obrigatoriedade + ", dependencia=" + dependencia + '}';
    }

    @Override
    public int compare(Atributo arg0, Atributo arg1) {
        return Integer.compare(arg0.posicaoForContext(), arg1.posicaoForContext);
    }
    
    

}
