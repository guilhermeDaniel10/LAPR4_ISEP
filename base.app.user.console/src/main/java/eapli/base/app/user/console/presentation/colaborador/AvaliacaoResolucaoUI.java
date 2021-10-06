/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.user.console.presentation.colaborador;

import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.tarefamanagement.DTO.TarefaDTO;
import eapli.base.tarefamanagement.application.AvaliarTarefaController;
import eapli.base.tarefamanagement.application.ListTarefasExecucaoController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

/**
 *
 * @author Guilherme
 */
public class AvaliacaoResolucaoUI extends AbstractUI {

    private ListTarefasExecucaoController execucaoController = new ListTarefasExecucaoController();
    private AvaliarTarefaController avaliarController = new AvaliarTarefaController();

    @Override
    protected boolean doShow() {
        Iterable<TarefaDTO> tarefas = null;
        boolean avaliacao = false;
        String comentario = null;
        try {
            tarefas = execucaoController.tarefasExecutadasPeloColaborador();

            if (tarefas == null) {
                System.out.println("Não há pedidos a avaliar disponíveis!\n");
                return false;
            }

        } catch (NullPointerException e) {
            System.out.println("Não há pedidos a avaliar disponíveis!\n");
            return false;
        }

        if (tarefas == null) {
            System.out.println("Não há pedidos a avaliar disponíveis!\n");
            return false;
        }

        final SelectWidget<TarefaDTO> selector = new SelectWidget<>("Tarefas Disponiveis:", tarefas,
                new TarefasDTOPrinter());
        selector.show();

        if (selector.selectedOption() == 0) {
            return false;
        } else {
            avaliacao = Console.readBoolean("A tarefa foi bem executada (y/n):");
            comentario = Console.readLine("Comentario (opcional):");
        }

        try {
            avaliarController.avaliarTarefaExecutada(selector.selectedElement(), avaliacao, comentario);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    @Override
    public String headline() {
        return "Grau de Satisfacao de um Pedido";
    }

}
