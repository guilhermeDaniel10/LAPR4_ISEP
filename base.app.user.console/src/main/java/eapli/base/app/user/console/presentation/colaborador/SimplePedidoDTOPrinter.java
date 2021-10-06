/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.user.console.presentation.colaborador;

import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.dto.PedidoDTO;
import eapli.framework.visitor.Visitor;

/**
 *
 * @author Guilherme
 */
public class SimplePedidoDTOPrinter implements Visitor<PedidoDTO> {

    @Override
    public void visit(PedidoDTO visitee) {
        System.out.println("Identificador Pedido: " + visitee.idForInfo + "\nTitulo Servico: " + visitee.tituloServico);
    }

}
