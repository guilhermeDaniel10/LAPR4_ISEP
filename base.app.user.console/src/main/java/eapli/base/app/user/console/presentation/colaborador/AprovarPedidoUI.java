/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.user.console.presentation.colaborador;

import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.dto.FormularioDTO;
import eapli.base.pedidomanagement.application.AprovarPedidoController;
import eapli.base.pedidomanagement.application.ListPedidoController;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.servicomanagement.domain.Servico;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

/**
 *
 * @author Guilherme
 */
public class AprovarPedidoUI extends AbstractUI {

    private ListPedidoController pedidosController = new ListPedidoController();
    private AprovarPedidoController aprovarController = new AprovarPedidoController();

    @Override
    protected boolean doShow() {
        Iterable<Pedido> pedidos = null;
        try {
            pedidos = pedidosController.availablePedidosForAprovacao();

            if (pedidos == null) {
                System.out.println("Não há pedidos disponíveis!\n");
                return false;
            }

        } catch (NullPointerException e) {
            System.out.println("Não há pedidos disponíveis!\n");
            return false;
        }

        if (pedidos == null) {
            System.out.println("Não há pedidos disponíveis!\n");
            return false;
        }

        final SelectWidget<Pedido> selector = new SelectWidget<>("Tarefas Disponiveis:", pedidos,
                new PedidosPrinter());
        selector.show();

        Formulario form = selector.selectedElement().aprovacaoPedido().formularioAprovacao();

        // RESPOSTA DO FORMULARIO DE SOLICITACAO A SER ADICIONADA AQUI AO FORMULARIO DE APROVACAO
        if (form != null) {
            FormularioDTO formAprovDtoFromSer = form.toDTO();
            ProcessarPreencherFormularioUI processar = new ProcessarPreencherFormularioUI(formAprovDtoFromSer);
            processar.doShow();
        }
        boolean isReadyForAprov = Console.readBoolean("Aprovar (y/n):");
        if (isReadyForAprov) {
            aprovarController.aprovarPedidoParaExecucao(selector.selectedElement());
            System.out.println("Pedido Aprovado");
            return true;
        } else {
            aprovarController.rejeitarPedidoParaExecucao(selector.selectedElement());
            System.out.println("Pedido Rejeitado.");
        }

        if (selector.selectedOption() == 0) {
            return false;
        }
        return true;
    }

    @Override
    public String headline() {
        return "Aprovar Pedidos";
    }

}
