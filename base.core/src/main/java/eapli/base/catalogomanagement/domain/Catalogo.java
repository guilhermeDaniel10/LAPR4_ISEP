/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.catalogomanagement.domain;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.objetivosmanagement.domain.Objetivos;
import eapli.base.slamanagement.domain.NivelCriticidade;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author lucas
 */
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"identificadorCatalogo"})})
public class Catalogo implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificadorUnico;

    @Column(nullable = false)
    private IdentificadorCatalogo identificadorCatalogo;

    @ManyToOne(optional = true)
    @AttributeOverride(name = "value", column = @Column(name = "ResponsavelCatalogo"))
    private Colaborador responsavelCatalogo;

    @ManyToOne(optional = true)
    @AttributeOverride(name = "value", column = @Column(name = "NivelCriticidadeCatalogo"))
    private NivelCriticidade nivelCriticidadeCatalogo;

    @AttributeOverride(name = "value", column = @Column(name = "TituloCatalogo"))
    @Column(nullable = false)
    private TituloCatalogo tituloCatalogo;

    @AttributeOverride(name = "value", column = @Column(name = "DescBreveCatalogo"))
    @Column(nullable = false)
    private DescBreveCatalogo descBreveCatalogo;

    @AttributeOverride(name = "value", column = @Column(name = "DescCompletaCatalogo"))
    @Column(nullable = false)
    private DescCompletaCatalogo descCompletaCatalogo;

    @AttributeOverride(name = "value", column = @Column(name = "Icone"))
    @Column(nullable = false)
    @Lob
    private IconeCatalogo icone;

    @AttributeOverride(name = "value", column = @Column(name = "Estado_Catalogo"))
    @Column(nullable = false)
    private boolean estadoCatalogo;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(nullable = true)
    private final Set<EquipasComAcessoCatalogo> equipasComAcessoCatalogo = new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @OneToOne(cascade = CascadeType.ALL)
    private Objetivos objetivos;

    public Catalogo(final IdentificadorCatalogo identificadorCatalogo, final TituloCatalogo tituloCatalogo,
            final DescBreveCatalogo descBreveCatalogo, final DescCompletaCatalogo descCompletaCatalogo, final IconeCatalogo iconeCatalogo) {
        Preconditions.noneNull(identificadorCatalogo, tituloCatalogo, descBreveCatalogo, descCompletaCatalogo, iconeCatalogo);

        this.identificadorCatalogo = identificadorCatalogo;
        this.tituloCatalogo = tituloCatalogo;
        this.descBreveCatalogo = descBreveCatalogo;
        this.descCompletaCatalogo = descCompletaCatalogo;
        this.icone = iconeCatalogo;
        this.estadoCatalogo = false;
    }

    public boolean copyEquipas(final Set<Equipa> equipasComAcesso) {
        for (final Equipa equipa : equipasComAcesso) {
            addEquipa(equipa);
        }
        if (this.equipasComAcessoCatalogo.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean addEquipa(final Equipa equipa) {
        final EquipasComAcessoCatalogo equipasEmCatalogo = new EquipasComAcessoCatalogo(equipa);
        return equipasComAcessoCatalogo.add(equipasEmCatalogo);
    }

    public Set<EquipasComAcessoCatalogo> equipa() {
        return Collections.unmodifiableSet(equipasComAcessoCatalogo);
    }

    public void adicionarColaboradorResponsavel(Colaborador responsavelCatalogo) {
        this.responsavelCatalogo = responsavelCatalogo;
    }

    public void adicionarNivelCriticidadeCatalogo(NivelCriticidade nivelCriticidadeCatalogo) {
        this.nivelCriticidadeCatalogo = nivelCriticidadeCatalogo;
    }

    protected Catalogo() {
        // for ORM only.
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(final Object other) {
        if (!(other instanceof Catalogo)) {
            return false;
        }

        final Catalogo that = (Catalogo) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity())
                && this.identificadorCatalogo.equals(that.identificadorCatalogo)
                && this.descBreveCatalogo.equals(that.descBreveCatalogo)
                && this.descCompletaCatalogo.equals(that.descCompletaCatalogo)
                && this.icone.equals(that.icone)
                && this.tituloCatalogo.equals(that.tituloCatalogo)
                && this.estadoCatalogo == that.estadoCatalogo
                && this.equipasComAcessoCatalogo.containsAll(that.equipasComAcessoCatalogo)
                && this.responsavelCatalogo.equals(that.responsavelCatalogo)
                && this.nivelCriticidadeCatalogo.equals(that.nivelCriticidadeCatalogo);
    }

    public boolean changeColaboradorResponsavel(final Colaborador responsavelCatalogo) {
        if (responsavelCatalogo == null) {
            return false;
        }
        this.responsavelCatalogo = responsavelCatalogo;
        return true;
    }

    public Long identity() {
        return this.identificadorUnico;
    }

    public IdentificadorCatalogo identiticadorCatalogo() {
        return this.identificadorCatalogo;
    }

    public NivelCriticidade nivelCriticidadeCatalogo() {
        return this.nivelCriticidadeCatalogo;
    }

    public TituloCatalogo name() {
        return this.tituloCatalogo;
    }

    public boolean isActive() {
        return this.estadoCatalogo;
    }

    public boolean activateState() {
        if (this.nivelCriticidadeCatalogo != null && this.responsavelCatalogo != null && !this.equipasComAcessoCatalogo.isEmpty() && this.tituloCatalogo.tituloCatalogoValido() && this.descBreveCatalogo.descCatalogoValido() && this.descCompletaCatalogo.descCatalogoValido() && !this.icone.iconeValido()) {
            this.estadoCatalogo = true;
        }

        return this.estadoCatalogo;
    }

    public Objetivos objetivosDoCatalogo() {
        if (objetivos == null) {
            return this.nivelCriticidadeCatalogo.objetivos();
        }
        return this.objetivos;
    }

    public DescBreveCatalogo descricaoBreve() {
        return this.descBreveCatalogo;
    }

    public DescCompletaCatalogo descricaoCompleta() {
        return this.descCompletaCatalogo;
    }

    public IconeCatalogo icone() {
        return this.icone;
    }

    public Colaborador responsavel() {
        return this.responsavelCatalogo;
    }

    public void setNivelCriticidade(NivelCriticidade nivelCriticidade) {
        this.nivelCriticidadeCatalogo = nivelCriticidade;
    }

    public void setObjetivos(Objetivos objetivos) {
        this.objetivos = objetivos;
    }

    @Override
    public String toString() {
        return "\nCatalogo " + tituloCatalogo + "\nResponsável do catálogo-> " + responsavelCatalogo.nomeCurto() + "\nDescricao Breve Catalogo: " + descBreveCatalogo + "\nDescricao Completa Catalogo: " + descCompletaCatalogo;
    }

}
