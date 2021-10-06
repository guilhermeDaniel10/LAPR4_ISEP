/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.tarefamanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefamanagement.DTO.TarefaDTO;
import eapli.base.tarefamanagement.domain.GrauSatisfacao;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.repositories.GrauSatisfacaoRepository;
import eapli.base.tarefamanagement.repositories.TarefaRepository;

/**
 *
 * @author Guilherme
 */
public class AvaliarTarefaController {

    private ExecutarTarefaController executarController = new ExecutarTarefaController();
    private static final GrauSatisfacaoRepository grauRepository = PersistenceContext.repositories().grauSatisfacao();
    private TarefaRepository tarefaRepo = PersistenceContext.repositories().tarefa();
    
    public GrauSatisfacao avaliarTarefaExecutada(TarefaDTO tarefaDTO, boolean avaliacao, String comentario){
        Tarefa tarefa = executarController.tarefaFromDTO(tarefaDTO);
        tarefa.setGrauSatisfeito(true);
        Tarefa newT = tarefaRepo.save(tarefa);
        GrauSatisfacao grauSatis = new GrauSatisfacao(newT, avaliacao, comentario);
        return grauRepository.save(grauSatis);
    }
}
