/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.pedidomanagement.repositories;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.pedidomanagement.domain.EstadoPedido;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.dto.PedidoDTO;
import eapli.base.servicomanagement.domain.AtividadeRealizacao;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.framework.domain.repositories.DomainRepository;
import java.util.Date;

/**
 *
 * @author Guilherme
 */
public interface PedidoRepository extends DomainRepository<Long, Pedido>{
    
    public Iterable<Pedido> availablePedidosSemAprovacao(Iterable<Servico> servicos, EstadoPedido estado);
    
    public Pedido pedidoFromDTO(PedidoDTO pedido);
    
    public Iterable<Pedido> availablePedidosForAprovacao(Colaborador colab);
    
    public Iterable<Pedido> pedidosFromColaboradorRealizados(Colaborador colab);
    
    public Iterable<Pedido> pedidosFromColaboradorEmExecucao(Colaborador colab);
    
    public Iterable<Pedido> availablePedidosJaAprovados(Iterable<Servico> servicos);
    
    public Iterable<Pedido> pedidosParaExecucaoManual();
    
    public Iterable<Pedido> pedidosConcluidosForaPrazo(Date limiteInferior, Date LimiteSuperior );
    
    public Iterable<Pedido> pedidosConcluidosDentroPrazo(Date limiteInferior, Date LimiteSuperior);
        
    public Iterable<Pedido> pedidosPorConcluirDentroDoPrazo(Date limiteInferior, Date LimiteSuperior);
            
    public Iterable<Pedido> pedidosPorConcluirForaPrazo(Date limiteInferior, Date LimiteSuperior);
    
    public Iterable<Pedido> pedidosPorAprovarDentroPrazo(Date limiteInferior, Date LimiteSuperior);
    
    public Iterable<Pedido> pedidosPorAprovarForaPrazo(Date limiteInferior, Date LimiteSuperior);
    
    public Double tempoMedioResolucaoServico(Date limiteInferior, Date LimiteSuperior, Servico servico);

    public Double tempoMedioAprovacaoServico(Date limiteInferior, Date LimiteSuperior, Servico servico);

}
