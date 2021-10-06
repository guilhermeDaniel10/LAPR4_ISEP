/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.tarefamanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.tarefamanagement.DTO.TarefaDTO;
import eapli.base.tarefamanagement.domain.Tarefa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public class ListTarefasController {

    public static final String ORDENAR_DATA_LIMITE = "DATA LIMITE";
    public static final String ORDENAR_CRITICIDADE = "CRITICIDADE";
    public static final String ORDENAR_PRIORIDADE = "PRIORIDADE";
    
    public static final String FILTRAR_CRITICIDADE = "CRITICIDADE";
    public static final String FILTRAR_PRIORIDADE = "PRIORIDADE";

    private static final ListTarefaService tarefaList = new ListTarefaService();

    /*
    Colaborador ao qual procurar as tarefas
     */
    private Colaborador colab;

    public boolean assignColaborador(Colaborador colab) {
        this.colab = colab;
        return true;
    }

    public Iterable<Tarefa> tarefasAutomaticasAvailableForExcecution() {
        return tarefaList.tarefasAutomaticasAvailableForExcecution();
    }

    public int qtdTarefasManuaisAvailableForExcecutionbyID(String userID) {
        return tarefaList.qtdTarefasManuaisAvailableForExcecutionbyID(userID);
    }

    public Iterable<TarefaDTO> consultarBy(String criterio, boolean ascendente) {
        Iterable<Tarefa> list;
        list = tarefaList.tarefasPor(colab, criterio, ascendente);
        List<TarefaDTO> listDTO = new ArrayList<>();
        for (Tarefa t : list) {
            listDTO.add(t.tarefaToDTO());
        }
        return listDTO;
    }

    public Iterable<TarefaDTO> consultarFiltrado(String criterio, boolean ascendente, String criterioFiltro, String limiteInferior, String limiteSuperior) {
        Iterable<Tarefa> list;
        list = tarefaList.tarefasPorFiltrado(colab, criterio, ascendente, criterioFiltro, limiteInferior, limiteSuperior);
        List<TarefaDTO> listDTO = new ArrayList<>();
        for (Tarefa t : list) {
            listDTO.add(t.tarefaToDTO());
        }
        return listDTO;
    }

    public Iterable<String> criteriosOrdenacao() {
        List<String> list = new ArrayList<>();

        list.add(ORDENAR_DATA_LIMITE);
        list.add(ORDENAR_CRITICIDADE);
        list.add(ORDENAR_PRIORIDADE);

        return list;
    }
    
    public Iterable<String> criteriosFiltragem(){
        List<String> list = new ArrayList<>();
        
        list.add(FILTRAR_CRITICIDADE);
        list.add(FILTRAR_PRIORIDADE);
        
        return list;
    }
    
    public int numeroTarefasPendentesColaborador(String colabId) {
        return tarefaList.numeroTarefasPendentesColaborador(colabId);
    }

    public int numeroTarefasNaoConcluidas(String colabId) {
        return tarefaList.numeroTarefasNaoConcluidas(colabId);
    }

    public int numeroTarefasTerminamEmBreve(String colabId) {
        return tarefaList.numeroTarefasTerminamEmBreve(colabId);
    }

    public Iterable<Tarefa> tarefasDoColaboradorPorPrioridadeECriticadade(String colabId) {
        return tarefaList.tarefasDoColaboradorPorPrioridadeECriticadade(colabId);
    }

    public int allTarefasAutomaticas() {
        return tarefaList.allTarefasAutomaticas();
    }
    
    public int allTarefasPendentes() {
        return tarefaList.allTarefasPendentes();
    }

    public int allTarefas() {
        return tarefaList.allTarefas();
    }

}
