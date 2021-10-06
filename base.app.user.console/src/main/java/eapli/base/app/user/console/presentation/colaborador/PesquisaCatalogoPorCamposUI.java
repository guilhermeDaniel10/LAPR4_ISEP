/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.user.console.presentation.colaborador;

import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagemente.application.ListCatalogoController;
import eapli.base.catalogomanagemente.application.ListCatalogoService;
import eapli.base.equipamanagement.application.ListEquipaService;
import eapli.base.servicomanagement.application.ListServicoController;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthenticationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;

/**
 *
 * @author Guilherme
 */
public class PesquisaCatalogoPorCamposUI extends AbstractUI {

    private ListCatalogoController listCatalogoController = new ListCatalogoController();
    private ListCatalogoController serv = new ListCatalogoController();
    private ListServicoController servicController = new ListServicoController();

    @Override
    protected boolean doShow() {
        final String strInfo = Console.readLine("Pesquisar:");

        for (Catalogo c : serv.findCatalogoByMultipleFields(strInfo)) {

            System.out.println(c.toString());
            for (Servico s : servicController.allServicosFromCatalogo(c)) {
                if (s.isActive()) {
                    System.out.println(s.toStringWithCatalogo());
                } else {
                    System.out.println("\n      Titulo Servico:" + s.name().toString() + "\n      Serviço brevemente disponível...");
                }
            }
        }

        return true;
    }

    @Override
    public String headline() {
        return "Pesquisa de Catálogos por Campos.";
    }

}
