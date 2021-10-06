/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.tarefamanagement.application;

import eapli.base.colaboradormanagement.application.RegistarColaboradorController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefamanagement.DTO.TarefaDTO;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.repositories.TarefaRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public class ListTarefasExecucaoService {

    private RegistarColaboradorController colabController = new RegistarColaboradorController();
    private static final TarefaRepository tarefaRepository = PersistenceContext.repositories().tarefa();

    public Iterable<TarefaDTO> availableTarefasExecucaoColaborador() {
        Colaborador colaborador = colabController.currentColaborador();
        Iterable<Tarefa> tarefas = tarefaRepository.availableTarefasExecucaoColaborador(colaborador);
        List<TarefaDTO> tarefasDTO = new ArrayList<>();

        for (Tarefa t : tarefas) {
            tarefasDTO.add(t.tarefaToDTO());
        }
        return tarefasDTO;

    }

    public Iterable<TarefaDTO> tarefasExecutadasPeloColaborador() {
        Colaborador colaborador = colabController.currentColaborador();
        Iterable<Tarefa> tarefas = tarefaRepository.tarefasExecutadasPeloColaborador(colaborador);
        List<TarefaDTO> tarefasDTO = new ArrayList<>();

        for (Tarefa t : tarefas) {
            tarefasDTO.add(t.tarefaToDTO());
        }
        return tarefasDTO;
    }
}
