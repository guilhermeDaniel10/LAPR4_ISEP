/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.pedidomanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.dto.PedidoDTO;
import java.util.Iterator;

/**
 *
 * @author Guilherme
 */
public class ListPedidoController {

    private ListPedidoService lstPedidoService = new ListPedidoService();

    public Iterable<PedidoDTO> tarefasDisponiveis() {
        return lstPedidoService.availablePedidosAsDTO();
    }

    public Iterable<Pedido> availablePedidosForAprovacao() {
        return lstPedidoService.availablePedidosForAprovacao();
    }

    public Iterable<PedidoDTO> pedidosFromColaboradorRealizados() {

        return lstPedidoService.pedidosFromColaboradorRealizados();
    }
    
    public Iterable<PedidoDTO> pedidosFromColaboradorEmExecucao() {

        return lstPedidoService.pedidosFromColaboradorEmExecucao();
    }
}
