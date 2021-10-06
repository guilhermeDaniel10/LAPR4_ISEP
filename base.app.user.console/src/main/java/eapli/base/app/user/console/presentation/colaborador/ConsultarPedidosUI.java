/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.user.console.presentation.colaborador;

import eapli.base.pedidomanagement.application.ListPedidoController;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.dto.PedidoDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ListWidget;
import eapli.framework.presentation.console.SelectWidget;

/**
 *
 * @author Guilherme
 */
public class ConsultarPedidosUI extends AbstractUI {

    private ListPedidoController pedidoController = new ListPedidoController();

    @Override
    protected boolean doShow() {

        boolean stop = false;
        while (!stop) {
            System.out.println("1. Consultar Histórico de Pedidos.");
            System.out.println("2. Consultar Pedidos em Curso.");
            System.out.println("0. Sair");
            int option = Console.readInteger("Opcao:");

            switch (option) {
                case 1:
                    Iterable<PedidoDTO> pedidos = pedidoController.pedidosFromColaboradorRealizados();
                    if(pedidos == null){
                        System.out.println("Nenhum Pedido do Utilizador foi executado.");
                        break;
                    }
                    
                    final SelectWidget<PedidoDTO> selector = new SelectWidget<>("Tarefas Disponiveis:", pedidos,
                new SimplePedidoDTOPrinter());
                    selector.show();
                    
                    if(selector.selectedOption() == 0){
                        break;
                    }
                    new PedidosDTOPrinter().visit(selector.selectedElement());
                    
//                    final ListWidget<PedidoDTO> list = new ListWidget<>("Pedidos Finalizados:", pedidos, new SimplePedidoDTOPrinter());
//                    list.show();
                    
                    break;
                case 2:
                    Iterable<PedidoDTO> pedidos2 = pedidoController.pedidosFromColaboradorEmExecucao();
                    if(pedidos2 == null){
                        System.out.println("O Utilizador nao realizou nenhum pedido.");
                        break;
                    }
                    
                    final SelectWidget<PedidoDTO> selector2 = new SelectWidget<>("Pedidos Em Execucao:", pedidos2,
                new SimplePedidoDTOPrinter());
                    selector2.show();
                    
                    if(selector2.selectedOption() == 0){
                        break;
                    }
                    new PedidosDTOPrinter().visit(selector2.selectedElement());
                    
//                    final ListWidget<PedidoDTO> list2 = new ListWidget<>("Pedidos Em Execucao:", pedidos2, new PedidosDTOPrinter());
//                    list2.show();
                    break;
                case 0:
                    stop = true;
                    break;
                default:
                    System.out.println("Opcao invalida.");
                    break;
            }

            
        }
        return true;
    }

    @Override
    public String headline() {
        return "Consultar Pedidos";
    }

}
