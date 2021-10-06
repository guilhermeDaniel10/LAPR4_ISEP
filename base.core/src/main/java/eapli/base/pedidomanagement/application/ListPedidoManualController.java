/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.pedidomanagement.application;

import eapli.base.pedidomanagement.domain.Pedido;

/**
 *
 * @author Guilherme
 */
public class ListPedidoManualController {

    private ListPedidoManualService pedidosService = new ListPedidoManualService();

    public Iterable<Pedido> pedidosParaExecucaoManual() {

        return pedidosService.pedidosParaExecucaoManual();
    }
}
