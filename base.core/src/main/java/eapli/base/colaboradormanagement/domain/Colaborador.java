/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.colaboradormanagement.domain;

import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.tipoequipamanagement.domain.TipoEquipa;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.strings.util.StringPredicates;
import eapli.framework.validations.Preconditions;
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.*;

/**
 *
 * @author Guilherme
 */
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nmrMecanografico"})})
public class Colaborador implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idColaborador;

    @Column(nullable = false)
    private NumeroMecanografico nmrMecanografico;

    private boolean active;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Funcao funcao;

    @Column(nullable = false)
    private NomeCurto nomeCurto;

    @Column(nullable = false)
    private NomeCompleto nomeCompleto;

    @Column(nullable = false)
    private DataNascimento dataNascimento;

    @Column(nullable = false)
    private LocalResidencia localResidencia;

    @Column(nullable = false, unique = true)
    private EmailInstitucional emailInstitucional;

    @Column(nullable = false)
    private Contacto contacto;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Colaborador responsavel;

    @ElementCollection
    @CollectionTable(name = "equipas")
    @Column(nullable = false)
    private final Set<EquipasColaborador> equipas = new HashSet<>();

    public Colaborador() {
    }

    public Colaborador(NumeroMecanografico nM, Funcao funcao, NomeCurto nomeCurto, NomeCompleto nomeCompleto, DataNascimento dataNascimento, LocalResidencia localResidencia,
            EmailInstitucional email, Contacto contacto, Colaborador responsavel) throws ParseException {
        Preconditions.noneNull(nM, funcao, nomeCurto, nomeCompleto, email, dataNascimento, localResidencia, contacto);
        this.nmrMecanografico = nM;
        this.active = true;
        this.funcao = funcao;
        this.nomeCurto = nomeCurto;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.localResidencia = localResidencia;
        this.emailInstitucional = email;
        this.contacto = contacto;
        this.responsavel = responsavel;

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
    public boolean sameAs(Object other) {
        if (!(other instanceof Colaborador)) {
            return false;
        }

        final Colaborador that = (Colaborador) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }

    @Override
    public Long identity() {
        return this.idColaborador;
    }

    public Funcao funcao() {
        return this.funcao;
    }

    public NomeCurto nomeCurto() {
        return this.nomeCurto;
    }

    public NomeCompleto nomeCompleto() {
        return this.nomeCompleto;
    }

    public DataNascimento dataNascimento() {
        return this.dataNascimento;
    }

    public LocalResidencia localResidencia() {
        return this.localResidencia;
    }

    public EmailInstitucional emailInstitucional() {
        return this.emailInstitucional;
    }

    public NumeroMecanografico numeroMecanografico() {
        return this.nmrMecanografico;
    }

    public Contacto contacto() {
        return this.contacto;
    }

    public Colaborador responsavel() {
        return this.responsavel;
    }

    public Set<EquipasColaborador> equipas() {
        return equipas;
    }

    public Set<Equipa> equipasColaborador() {
        Set<Equipa> equipas = new HashSet<>();

        for (EquipasColaborador e : this.equipas) {
            equipas.add(e.equipaColaborador());
        }

        return equipas;
    }

    public Set<TipoEquipa> getTiposEquipa() {
        Set<TipoEquipa> tiposEquipa = new HashSet();
        for (EquipasColaborador e : this.equipas) {

            tiposEquipa.add(e.equipaColaborador().tipoEquipa());
        }
        return tiposEquipa;
    }

    public boolean associarEquipa(EquipasColaborador equipa) {
        if (equipas == null) {
            throw new IllegalArgumentException("Equipas nao podem ser null ou vazio.");
        }
        return equipas.add(equipa);
    }

    public boolean removerEquipa(EquipasColaborador equipa) {
        if (equipas == null) {
            return false;
        }
        return equipas.remove(equipa);
    }

}
