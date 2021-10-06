/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.SLA;

import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.dto.PedidoDTO;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.slamanagement.application.ListarCumprimentoSlaController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rui3m
 */
public class ListarCumprimentoSlaUI extends AbstractUI {

    final ListarCumprimentoSlaController listarCumprimentoSlaController = new ListarCumprimentoSlaController();

    @Override
    protected boolean doShow() {
        boolean continuar = true;
        Map<String, List<Pedido>> infoPedidos = null;
        Map<String, List<Servico>> infoServicos = null;
        while (continuar) {
            final Date dataLimiteInferior = Console.readDate("Data limite inferior (dd/MM/yyyy):", "dd/MM/yyyy");
            final Date dataLimiteSuperior = Console.readDate("Data limite superior (dd/MM/yyyy):", "dd/MM/yyyy");
            infoPedidos = listarCumprimentoSlaController.listarInfomacaoCumprimentoSLA(dataLimiteInferior, dataLimiteSuperior);
            infoServicos = listarCumprimentoSlaController.listarInformacaoCumprimentosMediasSLA(dataLimiteInferior, dataLimiteSuperior);

            if (infoPedidos != null) {
                for (String s : infoPedidos.keySet()) {

                    System.out.println(s);
                    try {
                        for (Pedido p : infoPedidos.get(s)) {

                            System.out.println(p.toString() + "\n");

                        }
                    } catch (NullPointerException ee) {
                        System.out.println("Sem pedidos.");
                    } 

                }
            }
            if (infoServicos != null) {
                for (String s : infoServicos.keySet()) {
                    System.out.println(s);
                    try {
                        for (Servico ss : infoServicos.get(s)) {

                            System.out.println(ss.toString() + "\n");

                        }
                    } catch (NullPointerException ee) {
                        System.out.println("Sem servicos.");
                    }

                }
            }

            continuar = Console.readBoolean("Pretende realizar outra consulta com novas datas? (y/n)");
        }

        return true;

    }

    @Override
    public String headline() {
        return "Listagem cumprimento SLA";
    }

}
