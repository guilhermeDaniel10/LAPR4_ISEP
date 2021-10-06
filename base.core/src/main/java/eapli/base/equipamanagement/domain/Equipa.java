/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.equipamanagement.domain;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipamanagement.DTO.EquipaDto;
import eapli.base.tipoequipamanagement.domain.TipoEquipa;
import eapli.framework.domain.model.AggregateRoot;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
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
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"acronimo"})})
public class Equipa implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoUnico;

    @Column(name = "acronimo", unique = true, nullable = false)
    private AcronimoEquipa acronimo;

    @Column(name = "designacaoEquipa", nullable = false)
    private DesignacaoEquipa designacao;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoEquipa tipoEquipa;

    @ElementCollection
    @CollectionTable(name = "ResponsaveisEquipa")
    @Column(nullable = false)
    private final Set<ResponsavelEquipa> resposaveisEquipa = new HashSet<>();

    public Equipa() {

    }

    public Equipa(AcronimoEquipa acronimo, DesignacaoEquipa designacao) {
        if (acronimo == null || designacao == null) {
            throw new IllegalArgumentException();
        }
        this.acronimo = acronimo;
        this.designacao = designacao;
    }

    private boolean addResponsavel(final Colaborador responsavel) {
        if (responsavel == null) {
            throw new IllegalArgumentException("Responsavel nao pode ser null ou vazio.");
        }
        final ResponsavelEquipa responsavelEqu = new ResponsavelEquipa(responsavel);
        return resposaveisEquipa.add(responsavelEqu);
    }

    public void copyColaboradores(final Set<Colaborador> responsaveis) {
        if (responsaveis == null) {
            throw new IllegalArgumentException("Responsaveis nao podem ser null ou vazio.");
        }
        for (final Colaborador colab : responsaveis) {
            addResponsavel(colab);
        }
    }

    public Set<ResponsavelEquipa> ResponsaveisEquipa() {
        return Collections.unmodifiableSet(resposaveisEquipa);
    }

    public void adicionarTipoEquipa(TipoEquipa tpEquipa) {
        if (tpEquipa == null) {
            throw new IllegalArgumentException("Tipo de equipa nao pode ser null ou vazio.");
        }
        this.tipoEquipa = tpEquipa;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Equipa)) {
            return false;
        }

        final Equipa that = (Equipa) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity())
                && this.acronimo.equals(that.acronimo)
                && this.designacao.equals(that.designacao)
                && this.resposaveisEquipa.equals(that.resposaveisEquipa)
                && this.tipoEquipa.equals(that.tipoEquipa);
    }

    @Override
    public Long identity() {
        return this.codigoUnico;
    }

    public AcronimoEquipa acronimoEquipa() {
        return this.acronimo;
    }

    public DesignacaoEquipa designacaoEquipa() {
        return this.designacao;
    }

    public TipoEquipa tipoEquipa() {
        return this.tipoEquipa;
    }
    
    public EquipaDto toDTO() {
        return new EquipaDto(this.acronimo.acronimoValidoDaEquipa(), this.designacao.designacaValidaDaEquipa());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.codigoUnico);
        hash = 37 * hash + Objects.hashCode(this.acronimo);
        hash = 37 * hash + Objects.hashCode(this.designacao);
        hash = 37 * hash + Objects.hashCode(this.tipoEquipa);
        hash = 37 * hash + Objects.hashCode(this.resposaveisEquipa);
        return hash;
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
        final Equipa other = (Equipa) obj;
        
        if(other.codigoUnico.equals(this.codigoUnico)){
            return true;
        }
        if (!other.codigoUnico.equals(this.codigoUnico)) {
            return false;
        }
        if (!other.acronimo.equals(this.acronimo)) {
            return false;
        }
        if (!other.designacao.equals(this.designacao)) {
            return false;
        }
        if (!other.tipoEquipa.equals(this.tipoEquipa)) {
            return false;
        }
        if (!other.resposaveisEquipa.equals(this.resposaveisEquipa)) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "Equipa{" + "\nacronimo=" + acronimo + "\ndesignacao=" + designacao + "\n" + tipoEquipa + " }";
    }

}
