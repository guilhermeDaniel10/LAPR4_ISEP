/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.inmemory;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.pedidomanagement.domain.EstadoPedido;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.dto.PedidoDTO;
import eapli.base.pedidomanagement.repositories.PedidoRepository;
import eapli.base.servicomanagement.domain.AtividadeRealizacao;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import java.util.Date;

/**
 *
 * @author Guilherme
 */
public class InMemoryPedidoRepository  extends InMemoryDomainRepository<Pedido, Long> implements PedidoRepository{
    static {
        InMemoryInitializer.init();
    }

  

    @Override
    public Pedido pedidoFromDTO(PedidoDTO pedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Pedido> availablePedidosSemAprovacao(Iterable<Servico> servicos, EstadoPedido estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Pedido> availablePedidosForAprovacao(Colaborador colab) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Pedido> pedidosFromColaboradorRealizados(Colaborador colab) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Pedido> pedidosFromColaboradorEmExecucao(Colaborador colab) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Pedido> availablePedidosJaAprovados(Iterable<Servico> servicos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Pedido> pedidosParaExecucaoManual() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Pedido> pedidosConcluidosForaPrazo(Date limiteInferior, Date LimiteSuperior) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Pedido> pedidosConcluidosDentroPrazo(Date limiteInferior, Date LimiteSuperior) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Pedido> pedidosPorConcluirDentroDoPrazo(Date limiteInferior, Date LimiteSuperior) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Pedido> pedidosPorConcluirForaPrazo(Date limiteInferior, Date LimiteSuperior) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Pedido> pedidosPorAprovarDentroPrazo(Date limiteInferior, Date LimiteSuperior) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Pedido> pedidosPorAprovarForaPrazo(Date limiteInferior, Date LimiteSuperior) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double tempoMedioResolucaoServico(Date limiteInferior, Date LimiteSuperior, Servico servico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double tempoMedioAprovacaoServico(Date limiteInferior, Date LimiteSuperior, Servico servico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
