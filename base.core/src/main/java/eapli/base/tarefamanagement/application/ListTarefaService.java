/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.tarefamanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.repositories.TarefaRepository;

/**
 *
 * @author rui3m
 */
public class ListTarefaService {

    private static final TarefaRepository tarefaRepository = PersistenceContext.repositories().tarefa();

    public Iterable<Tarefa> tarefasAutomaticasAvailableForExcecution() {
        return tarefaRepository.tarefasAutomaticasAvailableForExcecution();
    }

    public int qtdTarefasManuaisAvailableForExcecutionbyID(String userID) {
        return tarefaRepository.qtdTarefasManuaisAvailableForExcecutionbyID(userID);
    }

    public Iterable<Tarefa> tarefasPorPrioridadeColaboradorAscendente(Colaborador colab) {
        return tarefaRepository.tarefasPorPrioridadeColaboradorAscendente(colab);
    }

    public Iterable<Tarefa> tarefasPorPrioridadeColaboradorDescendente(Colaborador colab) {
        return tarefaRepository.tarefasPorPrioridadeColaboradorDescendente(colab);
    }

    public Iterable<Tarefa> tarefasPorCriticidadeColaboradorAscendente(Colaborador colab) {
        return tarefaRepository.tarefasPorCriticidadeColaboradorAscendente(colab);
    }

    public Iterable<Tarefa> tarefasPorCriticidadeColaboradorDescendente(Colaborador colab) {
        return tarefaRepository.tarefasPorCriticidadeColaboradorDescendente(colab);
    }

    public Iterable<Tarefa> tarefasPorDataLimiteColaboradorAscendente(Colaborador colab) {
        return tarefaRepository.tarefasPorDataLimiteColaboradorAscendente(colab);
    }

    public Iterable<Tarefa> tarefasPorDataLimiteColaboradorDescendente(Colaborador colab) {
        return tarefaRepository.tarefasPorDataLimiteColaboradorDescendente(colab);

    }

    public Iterable<Tarefa> tarefasPor(Colaborador colab, String criterio, boolean ascendente) {
        return tarefaRepository.tarefasPor(colab, criterio, ascendente);

    }

    public Iterable<Tarefa> tarefasPorFiltrado(Colaborador colab, String criterio, boolean ascendente, String criterioFiltro, String limiteInferior, String limiteSuperior) {
        return tarefaRepository.tarefasPorFiltrado(colab, criterio, ascendente, criterioFiltro, limiteInferior, limiteSuperior);
    }

    Iterable<Tarefa> tarefasDoColaboradorPorPrioridadeECriticadade(String colabId) {
        return tarefaRepository.tarefasDoColaboradorPorPrioridadeECriticadade(colabId);
    }

    int numeroTarefasTerminamEmBreve(String colabId) {
        return tarefaRepository.numeroTarefasTerminamEmBreve(colabId);
    }

    int numeroTarefasNaoConcluidas(String colabId) {
        return tarefaRepository.numeroTarefasNaoConcluidas(colabId);
    }

    int numeroTarefasPendentesColaborador(String colabId) {
        return tarefaRepository.numeroTarefasPendentesColaborador(colabId);
    }

    public int allTarefasAutomaticas() {
        return tarefaRepository.allTarefasAutomaticas();
    }

    public int allTarefasPendentes() {
        return tarefaRepository.allTarefasPendentes();
    }

    public int allTarefas() {
        return tarefaRepository.allTarefas();
    }
    
}
