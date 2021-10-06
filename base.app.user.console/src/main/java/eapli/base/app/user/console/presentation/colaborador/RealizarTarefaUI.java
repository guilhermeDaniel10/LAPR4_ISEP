/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.user.console.presentation.colaborador;

import eapli.base.pedidomanagement.dto.PedidoDTO;
import eapli.base.tarefamanagement.DTO.TarefaDTO;
import eapli.base.tarefamanagement.application.ExecutarTarefaController;
import eapli.base.tarefamanagement.application.ListTarefasExecucaoController;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

/**
 *
 * @author Guilherme
 */
public class RealizarTarefaUI extends AbstractUI {
    
    private ListTarefasExecucaoController tarefasController = new ListTarefasExecucaoController();
    private ExecutarTarefaController executar = new ExecutarTarefaController();
    
    @Override
    protected boolean doShow() {
        Iterable<TarefaDTO> tarefasDTO = null;
        try {
            tarefasDTO = tarefasController.availableTarefasExecucaoColaborador();
        } catch (NullPointerException e) {
            System.out.println("Não há tarefas disponíveis!\n");
            return false;
        }
        
        if (tarefasDTO == null) {
            System.out.println("Não há tarefas disponíveis!\n");
            return false;
        }
        
        final SelectWidget<TarefaDTO> selector = new SelectWidget<>("Tarefas Disponiveis:", tarefasDTO,
                new TarefasDTOPrinter());
        selector.show();
        
        if(selector.selectedOption() == 0){
            return false;
        }
        
        Tarefa currentTarefa = executar.tarefaFromDTO(selector.selectedElement());
        
        try {
            ProcessarPreencherFormularioUI processar = new ProcessarPreencherFormularioUI(executar.formularioDTOFromTarefa(currentTarefa));
            processar.doShow();
        } catch (Exception e) {
            
        }
        
        executar.registarExecucaoTarefa(currentTarefa);
        return true;
    }
    
    @Override
    public String headline() {
        return "Realizar Tarefa";
    }
    
}
