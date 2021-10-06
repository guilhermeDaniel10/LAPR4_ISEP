/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.servicomanagement.domain;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.dto.FormularioDTO;
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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author lucas
 */
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"identificadorServico", "tituloServico"})})
public class Servico implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServico;

    @Column(nullable = false)
    private IdentificadorServico identificadorServico;

    @ManyToOne(optional = true)
    @JoinColumn(name = "NivelCriticidadeServico")
    private NivelCriticidade nivelCriticidadeServico;

    @ManyToOne(optional = true)
    private Catalogo catalogoDisponiblizaServico;

    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Workflow workflowServico;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Formulario formularioSolicitacaoServico;

    @Column(nullable = false)
    private TituloServico tituloServico;

    @AttributeOverride(name = "value", column = @Column(name = "Desc_Breve_Servico"))
    @Column(nullable = false)
    private DescBreveServico descBreveServico;

    @AttributeOverride(name = "value", column = @Column(name = "Desc_Completa_Servico"))
    @Column(nullable = false)
    private DescCompServico descCompletaServico;

    @AttributeOverride(name = "value", column = @Column(name = "Icone_Servico"))
    @Column(nullable = true)
    @Lob
    private IconeServico iconeServico;

    @AttributeOverride(name = "value", column = @Column(name = "Estado_Servico"))
    @Column(nullable = false)
    private boolean estadoServico;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(nullable = true)
    private final Set<KeywordsEmServico> keywordsEmServicoList = new HashSet<>();

    private boolean requerSatisfacao;

    public Servico(final IdentificadorServico identificadorServico, final TituloServico tituloServico,
            final DescBreveServico descBreveServico, final DescCompServico descCompServico, final IconeServico iconeServico, final boolean satisfacao) {
        Preconditions.noneNull(identificadorServico, tituloServico, descBreveServico, descCompServico);

        this.identificadorServico = identificadorServico;
        this.tituloServico = tituloServico;
        this.descBreveServico = descBreveServico;
        this.descCompletaServico = descCompServico;
        this.iconeServico = iconeServico;
        this.estadoServico = false;
        this.requerSatisfacao = satisfacao;
    }

    //Para testes apenas
    public Servico(final IdentificadorServico identificadorServico, final TituloServico tituloServico,
            final DescBreveServico descBreveServico, final DescCompServico descCompServico, final boolean satisfacao) {
        Preconditions.noneNull(identificadorServico, tituloServico, descBreveServico, descCompServico);

        this.identificadorServico = identificadorServico;
        this.tituloServico = tituloServico;
        this.descBreveServico = descBreveServico;
        this.descCompletaServico = descCompServico;
        this.estadoServico = false;
        this.requerSatisfacao = satisfacao;
    }

    public boolean copyKeywords(final Set<Keyword> keywordsServico) {
        for (final Keyword key : keywordsServico) {
            addKeyword(key);
        }
        if (this.keywordsEmServicoList.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean addKeyword(final Keyword key) {
        final KeywordsEmServico keywordsEmServico = new KeywordsEmServico(key);
        return keywordsEmServicoList.add(keywordsEmServico);
    }

    public Set<KeywordsEmServico> keyword() {
        return Collections.unmodifiableSet(keywordsEmServicoList);
    }

    public void adicionarCatalogoQueDisponiblizaServico(Catalogo catalogoDisponiblizaServico) {
        this.catalogoDisponiblizaServico = catalogoDisponiblizaServico;
    }

    public void adicionarFormularioDeSolicitacaoServico(Formulario formularioResolucaoServico) {
        this.formularioSolicitacaoServico = formularioResolucaoServico;
    }

    public void adicionarNivelCriticidadeServico(NivelCriticidade nivelCriticidadeServico) {
        this.nivelCriticidadeServico = nivelCriticidadeServico;
    }

    public void adicionarWorkflow(Workflow workflowServico) {
        this.workflowServico = workflowServico;
    }

    protected Servico() {
        // for ORM only.
    }

    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(final Object other) {
        if (!(other instanceof Servico)) {
            return false;
        }

        final Servico that = (Servico) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity())
                && this.descBreveServico.equals(that.descBreveServico)
                && this.descCompletaServico.equals(that.descCompletaServico)
                && this.iconeServico.equals(that.iconeServico)
                && this.tituloServico.equals(that.tituloServico)
                && this.estadoServico == that.estadoServico
                && this.keywordsEmServicoList.containsAll(that.keywordsEmServicoList)
                && this.workflowServico.sameAs(that.workflowServico);
    }

    public TituloServico name() {
        return this.tituloServico;
    }

    public boolean isActive() {
        return this.estadoServico;
    }

    public boolean activateState() {
        if (this.catalogoDisponiblizaServico != null && this.descBreveServico.descBreveServicoValido() && this.descCompletaServico.descCompServicoValido() && !this.keywordsEmServicoList.isEmpty()
                && workflowServico != null && formularioSolicitacaoServico != null) {
            this.estadoServico = true;
        }
        return isActive();
    }

    public DescBreveServico descricaoBreve() {
        return this.descBreveServico;
    }

    public Catalogo catalogoQueDisponiblizaServico() {
        return this.catalogoDisponiblizaServico;
    }

    public Formulario formularioDeSolicitacaoDeServico() {
        return this.formularioSolicitacaoServico;
    }

    public FormularioDTO formularioSolicitacaoDTO() {
        return this.formularioSolicitacaoServico.toDTO();
    }

    public DescCompServico descricaoCompleta() {
        return this.descCompletaServico;
    }

    public IconeServico iconeServico() {
        return this.iconeServico;
    }

    public NivelCriticidade nivelCriticidadeServico() {
        return this.nivelCriticidadeServico;
    }

    public Objetivos objetivosDoServico() {

        if (this.nivelCriticidadeServico != null) {
            return this.nivelCriticidadeServico.objetivos();
        }
        return this.catalogoDisponiblizaServico.objetivosDoCatalogo();
    }

    
    public Workflow workflowServico() {
        return this.workflowServico;
    }

    public boolean changeCatalogo(final Catalogo catalogoDisponiblizaServico) {
        if (catalogoDisponiblizaServico == null) {
            return false;
        }
        this.catalogoDisponiblizaServico = catalogoDisponiblizaServico;
        return true;
    }

    public Long identity() {
        return this.idServico;
    }

    public IdentificadorServico identificadorServico() {
        return this.identificadorServico;
    }

    public boolean requerSatisfacaoTarefa() {
        return this.requerSatisfacao;
    }

    @Override
    public String toString() {
        return "\n      Titulo Servico: " + tituloServico.toString() + "\n      Descricao Breve Servico: " + descBreveServico.toString() + "\n      Descricao Completa Servico:" + descCompletaServico.toString();
    }

    public String toStringWithCatalogo() {
        return "\n      Titulo Servico: " + tituloServico.toString() + "\n      Serviço do catálogo: " + this.catalogoDisponiblizaServico.identiticadorCatalogo().toString() + "\n      Descricao Breve Servico: " + descBreveServico.toString() + "\n      Descricao Completa Servico:" + descCompletaServico.toString();
    }

}
