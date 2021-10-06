/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.tipoequipamanagement.domain;

import eapli.base.cor.domain.Cor;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Guilherme
 */
@Entity
public class TipoEquipa implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoUnico;

    @AttributeOverride(name = "value", column = @Column(name = "descricaoTipoEquipa"))
    @Column(nullable = false)
    private DescricaoTipoEquipa descricaoTpEquipa;

    @AttributeOverride(name = "value", column = @Column(name = "corTipoEquipa"))
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cor corTipoEquipa;

    public TipoEquipa() {

    }

    public TipoEquipa(DescricaoTipoEquipa descricaoTpEquipa, Cor corTipoEquipa) {
        if (descricaoTpEquipa == null) {
            throw new IllegalArgumentException("A descricao do tipo de equipa nao pode ser null ou vazia.");
        }
        if (corTipoEquipa == null) {
            throw new IllegalArgumentException("A cor do tipo de equipa nao pode ser null ou vazia.");
        }

        this.descricaoTpEquipa = descricaoTpEquipa;
        this.corTipoEquipa = corTipoEquipa;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof TipoEquipa)) {
            return false;
        }

        final TipoEquipa that = (TipoEquipa) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity())
                && this.descricaoTpEquipa.equals(that.descricaoTpEquipa)
                && this.corTipoEquipa.sameAs(that.corTipoEquipa);

    }

    @Override
    public Long identity() {
        return this.codigoUnico;
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
        final TipoEquipa other = (TipoEquipa) obj;
        if (!Objects.equals(this.codigoUnico, other.codigoUnico)) {
            return false;
        }
        if (!Objects.equals(this.descricaoTpEquipa, other.descricaoTpEquipa)) {
            return false;
        }
        if (!Objects.equals(this.corTipoEquipa, other.corTipoEquipa)) {
            return false;
        }
        return true;
    }

    

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    public DescricaoTipoEquipa descricaoTpEquipa() {
        return this.descricaoTpEquipa;
    }

    public Cor corTipoEquipa() {
        return this.corTipoEquipa;
    }

    @Override
    public String toString() {
        return "TipoEquipa:" + "\n" + descricaoTpEquipa + "\nCor Tipo Equipa=" + corTipoEquipa + '}';
    }

}
