/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.user.console.presentation.colaborador;

import eapli.base.pedidomanagement.domain.Urgencia;
import eapli.base.tarefamanagement.DTO.TarefaDTO;
import eapli.base.tarefamanagement.application.ListTarefasController;
import eapli.base.tarefamanagement.application.OrdernarTarefasPendentesController;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public class TarefasPendentesColaboradorUI extends AbstractUI {

    private static List<String> options = new ArrayList<>();

    private OrdernarTarefasPendentesController tarefasController = new OrdernarTarefasPendentesController();

    @Override
    protected boolean doShow() {
        options.add("Ver tarefas pendentes por ordem decrescente de prioridade:");
        options.add("Ver tarefas pendentes por ordem crescente de prioridade:");
        options.add("Ver tarefas pendentes por ordem decrescente de nivel de criticidade:");
        options.add("Ver tarefas pendentes por ordem crescente de nivel de criticidade:");
        options.add("Ver tarefas pendentes por ordem decrescente da data limite:");
        options.add("Ver tarefas pendentes por ordem crescente da data limite:");
        //int option = -1;

        //while (option != 0) {
        TarefasDTOPrinter printerT = new TarefasDTOPrinter();
        final SelectWidget<String> selector3 = new SelectWidget<>("Consulta de tarefas pendentes:\n:", options);
        selector3.show();

        if (selector3.selectedOption() == 1) {
            for (TarefaDTO tarefa : tarefasController.tarefasPorPrioridadeColaboradorDescendente()) {
                printerT.visit(tarefa);
            }
        }
        if (selector3.selectedOption() == 2) {
            for (TarefaDTO tarefa : tarefasController.tarefasPorPrioridadeColaboradorAscendente()) {
                printerT.visit(tarefa);
            }
        }
        if (selector3.selectedOption() == 3) {
            for (TarefaDTO tarefa : tarefasController.tarefasPorCriticidadeColaboradorDescendente()) {
                printerT.visit(tarefa);
            }
        }
        if (selector3.selectedOption() == 4) {
            for (TarefaDTO tarefa : tarefasController.tarefasPorCriticidadeColaboradorAscendente()) {
                printerT.visit(tarefa);
            }
        }
        if (selector3.selectedOption() == 5) {
            for (TarefaDTO tarefa : tarefasController.tarefasPorDataLimiteColaboradorDescendente()) {
                printerT.visit(tarefa);
            }
        }
        if (selector3.selectedOption() == 6) {
            for (TarefaDTO tarefa : tarefasController.tarefasPorDataLimiteColaboradorAscendente()) {
                printerT.visit(tarefa);
            }
        }

        options = new ArrayList<>();

        //}
        return true;
    }

    @Override
    public String headline() {
        return "Consulta de tarefas pendentes do utilizador";
    }

}
