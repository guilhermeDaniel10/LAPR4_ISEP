/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.pedidomanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.repositories.PedidoRepository;

/**
 *
 * @author Guilherme
 */
public class ListPedidoManualService {

    private PedidoRepository pedidoRepo = PersistenceContext.repositories().pedido();

    public Iterable<Pedido> pedidosParaExecucaoManual() {
        return pedidoRepo.pedidosParaExecucaoManual();
    }
    

}
