/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.tarefamanagement.repositories;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.tarefamanagement.DTO.TarefaDTO;
import eapli.base.tarefamanagement.domain.EstadoTarefa;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.framework.domain.repositories.DomainRepository;

/**
 *
 * @author Guilherme
 */
public interface TarefaRepository extends DomainRepository<Long, Tarefa> {
    
    public Iterable<Tarefa> tarefasAutomaticasAvailableForExcecution();
   
    public int qtdTarefasManuaisAvailableForExcecutionbyID(String idColaborador);

    public boolean alterarEstadoTarefa(EstadoTarefa estado, String idTarefa);
     
    public Iterable<Tarefa> tarefasPorExecutar();

    public Iterable<Tarefa> tarefasPorPrioridadeColaboradorAscendente(Colaborador colab);

    public Iterable<Tarefa> tarefasPorPrioridadeColaboradorDescendente(Colaborador colab);

    public Iterable<Tarefa> tarefasPorCriticidadeColaboradorAscendente(Colaborador colab);

    public Iterable<Tarefa> tarefasPorCriticidadeColaboradorDescendente(Colaborador colab);

    public Iterable<Tarefa> tarefasPorDataLimiteColaboradorAscendente(Colaborador colab);

    public Iterable<Tarefa> tarefasPorDataLimiteColaboradorDescendente(Colaborador colab);
    
    public int numeroTarefasPendentesColaborador(String colabId);
    
    public int numeroTarefasNaoConcluidas(String colabId);
    
    public int numeroTarefasTerminamEmBreve(String colabId);
    
    public Iterable<Tarefa> tarefasDoColaboradorPorPrioridadeECriticadade(String colabId);
    

    public Iterable<Tarefa> tarefasPorFiltrado(Colaborador colab, String criterio,boolean ascendente,String criterioFiltro,String limiteInferior, String limiteSuperior);
    
    public Iterable<Tarefa> tarefasPor(Colaborador colab, String criterio,boolean ascendente);
    
    public int allTarefasAutomaticas();
    
    public int allTarefasPendentes();
    
    public int allTarefas();
    
    public Tarefa findTarefaByPedido(Pedido pedido);
    
    public Iterable<Tarefa> availableTarefasExecucaoColaborador(Colaborador colaborador);
    
    public Tarefa tarefaFromDTO(TarefaDTO tarefa);
    
    public Iterable<Tarefa> tarefasExecutadasPeloColaborador(Colaborador colaborador);
    
    public Tarefa tarefaFromId(String idTarefa);
   
}
