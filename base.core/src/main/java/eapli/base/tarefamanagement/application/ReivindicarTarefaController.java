/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.tarefamanagement.controller;

import eapli.base.colaboradormanagement.application.RegistarColaboradorController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedidomanagement.application.ListPedidoController;
import eapli.base.pedidomanagement.domain.EstadoPedido;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.dto.PedidoDTO;
import eapli.base.pedidomanagement.repositories.PedidoRepository;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.servicomanagement.repositories.WorkflowRepository;
import eapli.base.tarefamanagement.domain.EstadoTarefa;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.repositories.TarefaRepository;

/**
 *
 * @author Guilherme
 */
public class ReivindicarTarefaController {

    private ListPedidoController lstPedidoController = new ListPedidoController();
    private PedidoRepository pedidoRepo = PersistenceContext.repositories().pedido();
    private TarefaRepository tarefaRepo = PersistenceContext.repositories().tarefa();
    private WorkflowRepository workRepo = PersistenceContext.repositories().workflow();
    private RegistarColaboradorController colabController = new RegistarColaboradorController();

    public Iterable<PedidoDTO> tarefasDisponiveis() {

        return lstPedidoController.tarefasDisponiveis();
    }

    public void reivindicarPedido(PedidoDTO pedido) {
        Pedido actualPedido = pedidoRepo.pedidoFromDTO(pedido);
        if (actualPedido.servicoDoPedido().workflowServico().atividadeAprovacaoWorkflow() == null) {
            actualPedido.changeState(EstadoPedido.EM_RESOLUCAO);
            registarTarefa(actualPedido, EstadoTarefa.EM_EXECUCAO, colabController.currentColaborador());
        } else {
            actualPedido.changeState(EstadoPedido.EM_RESOLUCAO);
            Pedido saved = pedidoRepo.save(actualPedido);
            Workflow work = workRepo.workflowFromPedidoOfServico(saved);
            work.atividadeRealizacaoWorkflow().changeResponsavel(colabController.currentColaborador());
            workRepo.save(work);
            Tarefa updatedTarefa = tarefaRepo.findTarefaByPedido(saved);
            updatedTarefa.changeEstadoTarefa(EstadoTarefa.EM_EXECUCAO);
            tarefaRepo.save(updatedTarefa);
        }

    }

    public Tarefa registarTarefa(Pedido pedido, EstadoTarefa estado, Colaborador colab) {
        Workflow work = workRepo.workflowFromPedidoOfServico(pedido);
        work.atividadeRealizacaoWorkflow().changeResponsavel(colab);
        workRepo.save(work);
        pedidoRepo.save(pedido);
        Tarefa newT = new Tarefa(pedido, estado, work);
        newT.setGrauSatisfeito(false);
        return tarefaRepo.save(newT);
    }

}
