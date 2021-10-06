/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.tarefamanagement.application;

import eapli.base.colaboradormanagement.application.RegistarColaboradorController;
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
public class OrdernarTarefasPendentesController {

    private RegistarColaboradorController colabController = new RegistarColaboradorController();
    private static final TarefaRepository tarefaRepository = PersistenceContext.repositories().tarefa();

    public Iterable<TarefaDTO> tarefasPorPrioridadeColaboradorAscendente() {
        return tarefasAsDTO(tarefaRepository.tarefasPorPrioridadeColaboradorAscendente(colabController.currentColaborador()));
    }

    public Iterable<TarefaDTO> tarefasPorPrioridadeColaboradorDescendente() {
        return tarefasAsDTO(tarefaRepository.tarefasPorPrioridadeColaboradorDescendente(colabController.currentColaborador()));
    }

    public Iterable<TarefaDTO> tarefasPorCriticidadeColaboradorAscendente() {
        return tarefasAsDTO(tarefaRepository.tarefasPorCriticidadeColaboradorAscendente(colabController.currentColaborador()));
    }

    public Iterable<TarefaDTO> tarefasPorCriticidadeColaboradorDescendente() {
        return tarefasAsDTO(tarefaRepository.tarefasPorCriticidadeColaboradorDescendente(colabController.currentColaborador()));
    }

    public Iterable<TarefaDTO> tarefasPorDataLimiteColaboradorAscendente() {
        return tarefasAsDTO(tarefaRepository.tarefasPorCriticidadeColaboradorAscendente(colabController.currentColaborador()));
    }

    public Iterable<TarefaDTO> tarefasPorDataLimiteColaboradorDescendente() {
        return tarefasAsDTO(tarefaRepository.tarefasPorCriticidadeColaboradorDescendente(colabController.currentColaborador()));
    }

    public Iterable<TarefaDTO> tarefasAsDTO(Iterable<Tarefa> tarefas) {
        List<TarefaDTO> tarefasDTO = new ArrayList<>();

        for (Tarefa t : tarefas) {
            tarefasDTO.add(t.tarefaToDTO());
        }
        return tarefasDTO;
    }
}
