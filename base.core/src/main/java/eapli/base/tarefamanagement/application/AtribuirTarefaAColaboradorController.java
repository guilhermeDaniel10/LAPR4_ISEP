/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.tarefamanagement.application;

import eapli.base.bibliotecaatividades.domain.AtividadeManual;
import eapli.base.bibliotecaatividades.domain.AtividadesExistentes;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.repositories.ColaboradorRepository;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.equipamanagement.repositories.EquipaRepository;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.objetivosmanagement.domain.Objetivos;
import eapli.base.pedidomanagement.domain.EstadoPedido;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.repositories.PedidoRepository;
import eapli.base.servicomanagement.domain.AtividadeAprovacao;
import eapli.base.servicomanagement.domain.AtividadeRealizacao;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.servicomanagement.repositories.WorkflowRepository;
import eapli.base.slamanagement.domain.NivelCriticidade;
import eapli.base.tarefamanagement.domain.EstadoTarefa;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.repositories.TarefaRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author Guilherme
 */
public class AtribuirTarefaAColaboradorController {

    private PedidoRepository pedidoRepo = PersistenceContext.repositories().pedido();
    private TarefaRepository tarefaRepo = PersistenceContext.repositories().tarefa();
    private ColaboradorRepository colabRepo = PersistenceContext.repositories().colaboradores();
    private EquipaRepository equipaRepo = PersistenceContext.repositories().equipa();
    private WorkflowRepository workRepo = PersistenceContext.repositories().workflow();

    public void atribuirPedidoAColaborador(Pedido pedido, Colaborador colaborador) {

        Formulario formAntigo = pedido.servicoDoPedido().workflowServico().atividadeRealizacaoWorkflow().atividadeManual().formularioRealizacaoManual();
        Formulario formRealizacao = new Formulario(formAntigo);

        AtividadeRealizacao real = new AtividadeRealizacao(formRealizacao, colaborador);
        Workflow newWork = new Workflow(real);
        Workflow saved = workRepo.save(newWork);
        if (pedido.servicoDoPedido().workflowServico().atividadeAprovacaoWorkflow() == null) {
            pedido.changeState(EstadoPedido.EM_RESOLUCAO);
            Pedido currentPedido = pedidoRepo.save(pedido);
            Tarefa newTarefa = new Tarefa(currentPedido, EstadoTarefa.EM_EXECUCAO, saved);
            tarefaRepo.save(newTarefa);
        } else {
            try {
                pedido.changeState(EstadoPedido.EM_RESOLUCAO);
                Pedido currentPedido = pedidoRepo.save(pedido);
                Tarefa updatedTarefa = tarefaRepo.findTarefaByPedido(currentPedido);
                updatedTarefa.changeWorkflowTarefa(saved);
                updatedTarefa.changeEstadoTarefa(EstadoTarefa.EM_EXECUCAO);
                tarefaRepo.save(updatedTarefa);
            } catch (NullPointerException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public Iterable<Colaborador> colaboradoresFromEquipaDePedido(Pedido pedido) {
        Servico servicoAtual = pedido.servicoDoPedido();
        Workflow workflowDoServico = servicoAtual.workflowServico();
        Equipa equipaResponsavelRealizacao = workflowDoServico.atividadeRealizacaoWorkflow().responsaveis();
        return colabRepo.findColaboradoresByEquipa(equipaResponsavelRealizacao);
    }
    
    public Iterable<Colaborador> colaboradoresDeEquipa(Equipa equipa){
        return colabRepo.findColaboradoresByEquipa(equipa);
    }

    public void allEquipasColab(ConcurrentHashMap<Equipa, ConcurrentLinkedQueue<Colaborador>> safeMap) {

        Iterable<Equipa> equipas = equipaRepo.findAll();

        for (Equipa e : equipas) {

            ConcurrentLinkedQueue<Colaborador> cConc = new ConcurrentLinkedQueue<>();

            List<Colaborador> list = new ArrayList<>((Collection<? extends Colaborador>) colabRepo.findColaboradoresByEquipa(e));
            cConc.addAll(list);
            safeMap.put(e, cConc);

        }

    }
    
    public void addUncommonColaborador(ConcurrentLinkedQueue<Colaborador> safeQueue, Iterable<Colaborador> colaboradores){
        for(Colaborador colab : colaboradores){
            if(!safeQueue.contains(colab)){
                safeQueue.add(colab);
            }
        }
        
    }
    
    
    public void addEquipaToMap(ConcurrentHashMap<Equipa, ConcurrentLinkedQueue<Colaborador>> safeMap, Equipa equipa){
        Iterable<Colaborador> colaboradoresDeEquipa = colaboradoresDeEquipa(equipa);
        ConcurrentLinkedQueue<Colaborador> toMap = new ConcurrentLinkedQueue<>();
        
        for(Colaborador colab : colaboradoresDeEquipa){
            toMap.add(colab);
        }
        safeMap.put(equipa, toMap);
        
    }

    public Colaborador colaboradorComMenorTempoTotalExecucaoDeEquipa(Pedido pedido) {
        Iterable<Colaborador> legiveis = colaboradoresFromEquipaDePedido(pedido);
        int menor = Integer.MAX_VALUE;
        Colaborador currentColab = null;

        for (Colaborador colab : legiveis) {
            Iterable<Tarefa> tarefasColab = tarefasDeUmColaborador(colab);
            int currentTime = sumAllTimeFromColaborador(tarefasColab);
            if (currentTime < menor) {
                menor = currentTime;
                currentColab = colab;
            }
        }
        return currentColab;
    }

    private int sumAllTimeFromColaborador(Iterable<Tarefa> tarefas) {
        int totalTime = 0;

        for (Tarefa t : tarefas) {
            Pedido pedidoT = t.pedido();
            Objetivos objPedido = pedidoT.servicoDoPedido().objetivosDoServico();
            totalTime += objPedido.tempoMedioResolucao().getTempo();
        }

        return totalTime;
    }

    private Iterable<Tarefa> tarefasDeUmColaborador(Colaborador colaborador) {
        return tarefaRepo.availableTarefasExecucaoColaborador(colaborador);
    }

}
