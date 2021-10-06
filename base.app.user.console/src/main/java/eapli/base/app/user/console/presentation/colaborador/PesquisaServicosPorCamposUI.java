/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.user.console.presentation.colaborador;

import eapli.base.servicomanagement.application.ListServicoController;
import eapli.base.servicomanagement.domain.Servico;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

/**
 *
 * @author Guilherme
 */
public class PesquisaServicosPorCamposUI extends AbstractUI {

    private ListServicoController servicoController = new ListServicoController();

    @Override
    protected boolean doShow() {
        final String strInfo = Console.readLine("Pesquisar:");

        for (Servico s : servicoController.findServicoByMultipleFields(strInfo)) {
            if (s.isActive()) {
                System.out.println(s.toString());
            } else {
                System.out.println("\n      Titulo Servico:" + s.name().toString() + "\n      Serviço brevemente disponível...");
            }
        }
        return true;
    }

    @Override
    public String headline() {
        return "Pesquisa de Serviços por Campos.";
    }

}
