/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.pedidomanagement.domain;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.pedidomanagement.dto.PedidoDTO;
import eapli.base.respostaformularios.domain.RespostaFormulario;
import eapli.base.servicomanagement.domain.AtividadeAprovacao;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.slamanagement.domain.NivelCriticidade;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;
import static org.hibernate.annotations.OnDeleteAction.CASCADE;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author Guilherme
 */
@Entity
public class Pedido implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido_seq")
//    @GenericGenerator(
//            name = "pedido_seq",
//            strategy = "eapli.base.pedidomanagement.domain.IdentificadorPedidoGenerator",
//            parameters = {
//                @Parameter(name = IdentificadorPedidoGenerator.INCREMENT_PARAM, value = "50")})
//    private String idPedido;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Colaborador solicitador;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Servico servico;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private NivelCriticidade nivelCriticidade;

    //@Enumerated(EnumType.STRING)
    private Integer urgenciaPedido;

    @Column(nullable = false)
    private Date dataSolicitacao;

    @Column(nullable = false)
    private DataLimite dataLimite;
    
    @Column(nullable = true)
    private Date dataConclusao;

    @Column(nullable = true)
    private String ficheiros;

    @OneToOne(cascade = CascadeType.ALL)
    private RespostaFormulario respostaFormulario;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoPedido estadoPedido;

    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private AtividadeAprovacao aprovacaoPedido;

    @Column(nullable = true)
    private String scriptDeExecucaoFuturo;

    protected Pedido() {

    }

    public Pedido(Colaborador solicitador, Servico servico) {
        Preconditions.noneNull(solicitador, servico);

        this.solicitador = solicitador;
        this.dataSolicitacao = new Date();
        this.servico = servico;
        this.nivelCriticidade = servico.nivelCriticidadeServico();
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Pedido)) {
            return false;
        }

        final Pedido that = (Pedido) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    public void addAtividadeAprovacao(AtividadeAprovacao atividade) {
        AtividadeAprovacao copy = new AtividadeAprovacao(atividade.isHierarquico(), atividade.resposavelAprovacao(), atividade.formularioAprovacao());
        this.aprovacaoPedido = copy;
    }

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof Pedido)) {
            return false;
        }

        final Pedido that = (Pedido) other;
        if (this == that) {
            return true;
        }
        return identity().equals(that.identity())
                && this.dataLimite.equals(that.dataLimite)
                && this.nivelCriticidade.equals(that.nivelCriticidade)
                && this.servico.equals(that.servico)
                && this.solicitador.equals(that.solicitador)
                && this.urgenciaPedido.equals(that.urgenciaPedido);
    }

    @Override
    public Long identity() {
        return this.idPedido;
    }

    public Colaborador solicitadorServico() {
        return this.solicitador;
    }

    public Servico servicoDoPedido() {
        return this.servico;
    }

    public NivelCriticidade criticidadePedido() {
        return this.nivelCriticidade;
    }

    public Integer urgenciaDoPedido() {
        return this.urgenciaPedido;
    }

    public DataLimite dataLimitePedido() {
        return this.dataLimite;
    }

    public Date dataSolicitacao() {
        return this.dataSolicitacao;
    }

    public AtividadeAprovacao aprovacaoPedido() {
        return this.aprovacaoPedido;
    }

    public void changeState(EstadoPedido estado) {
        if(estado.equals(EstadoPedido.APROVADO)){
            this.atividadeAprovacaoPedido().setDataAprovacao(new Date());
        }
        if(estado.equals(EstadoPedido.CONCLUIDO) || estado.equals(EstadoPedido.RESOLVIDO)){
            this.dataConclusao = new Date();
        }
        this.estadoPedido = estado;
    }

    public String scriptResolucao() {
        return this.scriptDeExecucaoFuturo;
    }

    public void addFields(Integer urgencia, DataLimite dataLimite, String ficheiros) {
        if (urgencia == null) {
            throw new IllegalArgumentException("Urgencia nao pode ser null ou vazia");
        }
        if (dataLimite == null) {
            throw new IllegalArgumentException("Data limite nao pode ser null ou vazia");
        }

        this.urgenciaPedido = urgencia;
        this.dataLimite = dataLimite;
        this.ficheiros = ficheiros;

    }

    public AtividadeAprovacao atividadeAprovacaoPedido() {
        return this.aprovacaoPedido;
    }

    public EstadoPedido estadoDoPedido() {
        return this.estadoPedido;
    }
    
    public Date dataConclusao(){
        return this.dataConclusao;
    }

    public void addRespostaFormulario(RespostaFormulario resposta) {
        this.respostaFormulario = resposta;
    }

    public void addScriptParaExecucaoFutura(String script) {
        String newScript = script.replaceAll("\"", "");
        this.scriptDeExecucaoFuturo = newScript;

    }

    public PedidoDTO toDTO() {
        Servico currentServ = this.servico;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return new PedidoDTO(this.identity(), currentServ.identificadorServico().toString(), currentServ.name().toString(),
                currentServ.descricaoBreve().toString(), currentServ.descricaoCompleta().toString(), Urgencia.values()[this.urgenciaPedido - 1].name(),
                df.format(dataSolicitacao), df.format(dataLimitePedido().dataLimiteAsData()), solicitadorServico().nomeCurto().toString());
    }

    @Override
    public String toString() {
        return "Colaborador solicitador: " + this.solicitador.nomeCurto().toString() + "\nServico do pedido: " + this.servico.identificadorServico()
                + "\nData Solicitacao: " + this.dataSolicitacao.toString() + "\nUrgencia: " + Urgencia.values()[this.urgenciaPedido - 1].name() + "Data Limite: " + this.dataLimite.toString()
                + "\nFicheiros: " + this.ficheiros;
    }

}
