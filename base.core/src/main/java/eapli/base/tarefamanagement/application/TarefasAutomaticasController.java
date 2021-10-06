/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.tarefamanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedidomanagement.domain.EstadoPedido;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.repositories.PedidoRepository;
import eapli.base.tarefamanagement.domain.EstadoTarefa;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.repositories.TarefaRepository;

/**
 *
 * @author Guilherme
 */
public class TarefasAutomaticasController {

    private PedidoRepository pedidoRepo = PersistenceContext.repositories().pedido();
    private TarefaRepository tarefaRepo = PersistenceContext.repositories().tarefa();

    public Iterable<Tarefa> tarefasAutomaticasAvailableForExcecution() {
        return tarefaRepo.tarefasAutomaticasAvailableForExcecution();
    }

    public boolean changeEstadoTarefaAutomatica(String tarefa, String idTarefa) {
        Tarefa tarefaAtual = tarefaRepo.tarefaFromId(idTarefa);

        if (EstadoTarefa.NO_EXECUTOR.getEstado().equals(tarefa)) {
            Pedido pedidoDaTarefa = tarefaAtual.pedido();
            pedidoDaTarefa.changeState(EstadoPedido.RESOLVIDO);
            pedidoRepo.save(pedidoDaTarefa);
            tarefaAtual.changeEstadoTarefa(EstadoTarefa.EXECUTADA);
            tarefaRepo.save(tarefaAtual);
            return true;
        }
        return tarefaRepo.alterarEstadoTarefa(EstadoTarefa.NO_EXECUTOR, idTarefa);

    }

}
