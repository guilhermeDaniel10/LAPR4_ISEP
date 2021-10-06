/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.tarefamanagement.application;

import eapli.base.tarefamanagement.DTO.TarefaDTO;

/**
 *
 * @author Guilherme
 */
public class ListTarefasExecucaoController {
    private ListTarefasExecucaoService tarefasService = new ListTarefasExecucaoService();
    
    public Iterable<TarefaDTO> availableTarefasExecucaoColaborador(){
        return tarefasService.availableTarefasExecucaoColaborador();
    }
    
    public Iterable<TarefaDTO> tarefasExecutadasPeloColaborador(){
        return tarefasService.tarefasExecutadasPeloColaborador();
    }
}
