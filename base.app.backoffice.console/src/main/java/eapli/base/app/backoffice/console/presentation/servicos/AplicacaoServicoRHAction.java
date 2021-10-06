/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.base.app.spd.communicationprotocol.booter.AplicacaoServicosController;
import eapli.framework.actions.Action;
import java.net.URI;

/**
 *
 * @author Guilherme
 */
public class AplicacaoServicoRHAction implements Action {

    private AplicacaoServicosController appController = new AplicacaoServicosController();

    @Override
    public boolean execute() {
        appController.startConnection();
        try {
            int port = 32507;
            String localhost = "http://localhost:" + port;
            URI uri = new URI(localhost);
            java.awt.Desktop.getDesktop().browse(uri);
            System.out.println("Web page opened in browser");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
