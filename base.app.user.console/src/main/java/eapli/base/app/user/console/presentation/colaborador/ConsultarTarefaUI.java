/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.user.console.presentation.colaborador;

import eapli.base.tarefamanagement.DTO.TarefaDTO;
import eapli.base.tarefamanagement.application.ConsultarTarefaController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ListWidget;
import eapli.framework.presentation.console.SelectWidget;

/**
 *
 * @author rui3m
 */
public class ConsultarTarefaUI extends AbstractUI {

    private final ConsultarTarefaController consultarController = new ConsultarTarefaController();

    @Override
    protected boolean doShow() {
        this.consultarController.assignColaborador();
        final Iterable<String> criterios = this.consultarController.criteriosOrdenacao();
        final Iterable<String> criteriosFiltragem = this.consultarController.criteriosFiltragem();
        boolean stop = false;
        while (!stop) {
            final SelectWidget<String> selectorOrdenacao = new SelectWidget<>("Criterios ordenacao: 0 Para terminar", criterios);
            selectorOrdenacao.show();
            
            
            if(selectorOrdenacao.selectedElement() == null){
                return true;
            }
            
            final boolean ascendente = Console.readBoolean("Organizar por ordem ascendente? (y/n)");
            
            final boolean filtrar = Console.readBoolean("Pretende filtrar os dados?(y/n)");

            if (filtrar) {
                final SelectWidget<String> selectorFiltro = new SelectWidget<>("Criterios filtragem: 0 para terminar", criteriosFiltragem);
                selectorFiltro.show();
                if(selectorFiltro.selectedElement() == null){
                    return true;
                }
                int limiteInferior = Console.readInteger("Limite Inferior?");
                int limiteSuperior = Console.readInteger("Limte superior?");

                

                final ListWidget<TarefaDTO> list = new ListWidget<>("Tarefas:", consultarController.consultarFiltrado(selectorOrdenacao.selectedElement(), ascendente, selectorFiltro.selectedElement(), limiteInferior, limiteSuperior), new TarefasDTOPrinter());
                list.show();
            }else{
                

                final ListWidget<TarefaDTO> list = new ListWidget<>("Tarefas:", consultarController.consultar(selectorOrdenacao.selectedElement(), ascendente), new TarefasDTOPrinter());
                list.show();
            }
        }
        stop = Console.readBoolean("Terminar?(y/n)");

        return true;
    }

    @Override
    public String headline() {
        return "Registar Colaborador";
    }

}
