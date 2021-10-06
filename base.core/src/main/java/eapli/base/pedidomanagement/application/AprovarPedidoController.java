/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.pedidomanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedidomanagement.domain.EstadoPedido;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.repositories.PedidoRepository;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.tarefamanagement.controller.RegistarTarefaAutomaticaController;
import eapli.base.tarefamanagement.domain.EstadoTarefa;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.repositories.TarefaRepository;

/**
 *
 * @author Guilherme
 */
public class AprovarPedidoController {

    private PedidoRepository pedidoRepo = PersistenceContext.repositories().pedido();
    private TarefaRepository tarefaRepo = PersistenceContext.repositories().tarefa();
    private RegistarTarefaAutomaticaController autoController = new RegistarTarefaAutomaticaController();

    public void aprovarPedidoParaExecucao(Pedido pedido) {
        Servico servicoDoPedido = pedido.servicoDoPedido();
        pedido.changeState(EstadoPedido.APROVADO);
        Pedido pedidoAtualizado = pedidoRepo.save(pedido);
        if (servicoDoPedido.workflowServico().atividadeRealizacaoWorkflow().atividadeManual() != null) {
            Tarefa tarefa = new Tarefa(pedido, EstadoTarefa.EM_ESPERA, servicoDoPedido.workflowServico());
            tarefa.setGrauSatisfeito(false);
            tarefaRepo.save(tarefa);
        }
        if (servicoDoPedido.workflowServico().atividadeRealizacaoWorkflow().atividade() != null) {
            autoController.registarTarefaAutomatica(pedido, EstadoTarefa.EM_EXECUCAO, servicoDoPedido.workflowServico());
        }
    }

    public void rejeitarPedidoParaExecucao(Pedido pedido) {
        pedido.changeState(EstadoPedido.REJEITADO);
        pedidoRepo.save(pedido);
    }

}
