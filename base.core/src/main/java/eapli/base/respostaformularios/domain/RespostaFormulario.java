/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.respostaformularios.domain;

import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.DadosBase;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Guilherme
 */
@Entity
public class RespostaFormulario implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRespostaForm;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Formulario formularioDaResposta;

    @Column(nullable = false)
    private String identificadorRespostaPorFormulario;

    @ElementCollection
    private List<AtributoEmResposta> valoresAtributos = new ArrayList<>();

    public RespostaFormulario() {

    }

    public RespostaFormulario(String identificadorForm, Formulario formularioResposta) {
        this.identificadorRespostaPorFormulario = "REP_" + identificadorForm;
        this.formularioDaResposta = formularioResposta;
    }

    public RespostaFormulario(String identificadorForm, Formulario formularioResposta, List<AtributoEmResposta> atributos) {
        this.identificadorRespostaPorFormulario = "REP_" + identificadorForm;
        this.valoresAtributos = atributos;
        this.formularioDaResposta = formularioResposta;
    }

    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof RespostaFormulario)) {
            return false;
        }

        final RespostaFormulario that = (RespostaFormulario) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity())
                && this.valoresAtributos.equals(that.valoresAtributos);
    }

    @Override
    public Long identity() {
        return this.idRespostaForm;
    }

    public List<AtributoEmResposta> valoresAtributos() {
        return this.valoresAtributos;
    }
    
    public void addAtributoEmResposta(String nomeVariavel, DadosBase dadoBase, Object obj, int position) {
        AtributoEmResposta atr = new AtributoEmResposta(nomeVariavel, dadoBase, obj, position);
        this.valoresAtributos.add(atr);
    }
    
    public void addAtributoEmResposta(AtributoEmResposta atributo){
        this.valoresAtributos.add(atributo);
    }
    
    

    public String idRespostaDeFormulario() {
        return this.identificadorRespostaPorFormulario;
    }
    
    public Formulario formularioDaResposta(){
        return this.formularioDaResposta;
    }

}
