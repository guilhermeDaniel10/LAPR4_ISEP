/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.user.console.presentation.colaborador;

import eapli.base.servicomanagement.application.ListServicoController;
import eapli.base.servicomanagement.domain.Servico;
import eapli.framework.presentation.console.AbstractUI;

/**
 *
 * @author Guilherme
 */
public class ConsultarServicosUI extends AbstractUI {

    private ListServicoController servicController = new ListServicoController();

    @Override
    protected boolean doShow() {
        System.out.println("    -> Servicos disponiveis:");
        for (Servico servico : servicController.allServicosAvailableColaborador()) {
            if (servico.isActive()) {
                System.out.println(servico.toStringWithCatalogo());
            } else {
                System.out.println("\n      Titulo Servico:" + servico.name().toString() + "\n      Serviço brevemente disponível...");
            }
        }
        return true;
    }

    @Override
    public String headline() {
        return "Consultar Serviços";
    }

}
