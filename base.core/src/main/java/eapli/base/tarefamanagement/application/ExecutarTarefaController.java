/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.tarefamanagement.application;

import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.dto.FormularioDTO;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedidomanagement.domain.EstadoPedido;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.repositories.PedidoRepository;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.tarefamanagement.DTO.TarefaDTO;
import eapli.base.tarefamanagement.domain.EstadoTarefa;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.repositories.TarefaRepository;

/**
 *
 * @author Guilherme
 */
public class ExecutarTarefaController {
    
    private static final TarefaRepository tarefaRepository = PersistenceContext.repositories().tarefa();
    private static final PedidoRepository pedidoRepo = PersistenceContext.repositories().pedido();
    
    public FormularioDTO formularioDTOFromTarefa(Tarefa tarefa) {
        Servico servicoAtual = tarefa.pedido().servicoDoPedido();
        Formulario formRealizacao = servicoAtual.workflowServico().atividadeRealizacaoWorkflow().atividadeManual().formularioRealizacaoManual();
        
        return formRealizacao.toDTO();
    }
    
    public Tarefa tarefaFromDTO(TarefaDTO dto) {
        return tarefaRepository.tarefaFromDTO(dto);
    }
    
    public void registarExecucaoTarefa(Tarefa tarefa) {
        tarefa.changeEstadoTarefa(EstadoTarefa.EXECUTADA);
        
        Tarefa tarefaAtual = tarefaRepository.save(tarefa);
        Pedido pedidoDaTarefa = tarefaAtual.pedido();
        pedidoDaTarefa.changeState(EstadoPedido.RESOLVIDO);
        pedidoRepo.save(pedidoDaTarefa);
    }
}
