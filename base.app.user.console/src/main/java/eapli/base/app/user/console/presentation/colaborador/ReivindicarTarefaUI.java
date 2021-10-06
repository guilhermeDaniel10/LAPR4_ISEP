/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.user.console.presentation.colaborador;

import eapli.base.pedidomanagement.dto.PedidoDTO;
import eapli.base.tarefamanagement.controller.ReivindicarTarefaController;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

/**
 *
 * @author Guilherme
 */
public class ReivindicarTarefaUI extends AbstractUI {
    
    private ReivindicarTarefaController reivindicarController = new ReivindicarTarefaController();
    
    @Override
    protected boolean doShow() {
        Iterable<PedidoDTO> pedidos = reivindicarController.tarefasDisponiveis();
        
        if (pedidos == null) {
            System.out.println("Não há tarefas disponíveis!\n");
        }
        
        final SelectWidget<PedidoDTO> selector = new SelectWidget<>("Tarefas Disponiveis:", pedidos,
                new PedidosDTOPrinter());
        selector.show();
        
        if (selector.selectedOption() == 0) {
            return false;
        }
        
        reivindicarController.reivindicarPedido(selector.selectedElement());
        
        return true;
    }
    
    @Override
    public String headline() {
        return "Reivindicar uma Tarefa";
    }
    
}
