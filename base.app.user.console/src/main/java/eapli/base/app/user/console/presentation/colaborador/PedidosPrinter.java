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
public class PedidosPrinter  implements Visitor<Pedido> {

    @Override
    public void visit(Pedido visitee) {
        PedidoDTO asDto = visitee.toDTO();
        System.out.println("Identificador Pedido: " + asDto.idForInfo + "\nIdentificador Servico: " + asDto.identificadorServico + "\nTitulo Servico: " + asDto.tituloServico
                + "\nDescricao Breve: " + asDto.descBreveServico + "\nDescricao Completa: " + asDto.descCompServico
                + "\nUrgencia: " + asDto.urgencia + "\nData Limite: " + asDto.dataLimite + "\nSolicitador: " + asDto.solicitador);
    }
    
}
