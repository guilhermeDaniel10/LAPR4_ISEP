/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.formulariomanagement.domain;

import eapli.base.formulariomanagement.dto.FormularioDTO;
import eapli.base.scriptmanagement.domain.Script;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Guilherme
 */
@Entity
public class Formulario implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificadorUnico;

    @Column(nullable = false)
    private NomeFormulario nomeFormulario;

    @ElementCollection(fetch = FetchType.LAZY)
    @Column(nullable = true)
    private Set<AtributosEmFormulario> atributosEmFormularioLst = new HashSet<>();

//    @ElementCollection(fetch = FetchType.LAZY)
//    @OneToOne(cascade = CascadeType.ALL)
//    private Script scriptValidacaoFormulario;

    public Formulario() {

    }

    public Formulario(Formulario formulario){
        this.nomeFormulario = formulario.nomeFormulario;
        this.atributosEmFormularioLst = formulario.atributosEmFormularioLst;
     }
    public Formulario(NomeFormulario nomeFormulario) {
        this.nomeFormulario = nomeFormulario;
        //this.scriptValidacaoFormulario = scriptValidacao;
    }

    public NomeFormulario nomeFormulario() {
        return this.nomeFormulario;
    }

    public boolean copyAtributo(final Set<Atributo> atributolst) {
        for (final Atributo atributo : atributolst) {
            addAtributo(atributo);
        }
        if (this.atributosEmFormularioLst.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean addAtributo(final Atributo atributo) {
        final AtributosEmFormulario atributoEmFormulario = new AtributosEmFormulario(atributo);
        return this.atributosEmFormularioLst.add(atributoEmFormulario);
    }

    public Set<AtributosEmFormulario> atributo() {
        return Collections.unmodifiableSet(this.atributosEmFormularioLst);
    }

    public Set<Atributo> asAtributo() {
        Set<Atributo> atributosForm = new HashSet<>();
        for (AtributosEmFormulario atri : atributosEmFormularioLst) {
            atributosForm.add(atri.atributo());
        }

        return atributosForm;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Formulario)) {
            return false;
        }

        final Formulario that = (Formulario) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity())
                && this.nomeFormulario.equals(that.nomeFormulario)
                && this.atributosEmFormularioLst.containsAll(that.atributosEmFormularioLst);
    }

    @Override
    public Long identity() {
        return this.identificadorUnico;
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    public FormularioDTO toDTO() {
        Set<Atributo> atributosSet = asAtributo();
        return new FormularioDTO(this.nomeFormulario.nomeFormulario(), atributosSet);
    }

    @Override
    public String toString() {
        return "Formulario{" + "identificadorUnico=" + identificadorUnico + ", nomeFormulario=" + nomeFormulario + ", atributosEmFormularioLst=" + atributosEmFormularioLst + '}';
    }

}
