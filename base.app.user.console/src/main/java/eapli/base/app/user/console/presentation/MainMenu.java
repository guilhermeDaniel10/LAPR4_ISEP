/*
 * Copyright (c) 2013-2019 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.app.user.console.presentation;

import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.app.spd.communicationprotocol.AplicacaoPortalUtilizadores;
import eapli.base.app.spd.communicationprotocol.booter.AplicacaoPortalController;
import eapli.base.app.user.console.presentation.colaborador.AprovarPedidoAction;
import eapli.base.app.user.console.presentation.colaborador.AvaliacaoResolucaoAction;
import eapli.base.app.user.console.presentation.colaborador.ConsultarCatalogoAction;
import eapli.base.app.user.console.presentation.colaborador.ConsultarPedidosAction;
import eapli.base.app.user.console.presentation.colaborador.ConsultarServicosAction;
import eapli.base.app.user.console.presentation.colaborador.PesquisaServicosPorCamposAction;
import eapli.base.app.user.console.presentation.colaborador.PesquisarCatalogoPorCamposAction;
import eapli.base.app.user.console.presentation.colaborador.ReivindicarTarefaAction;
import eapli.base.app.user.console.presentation.colaborador.SolicitarServicoAction;
import eapli.base.app.user.console.presentation.colaborador.TarefasPendentesAction;
import eapli.base.app.user.console.presentation.colaborador.ConsultarTarefaAction;
import eapli.base.app.user.console.presentation.colaborador.RealizarTarefaAction;
import eapli.base.colaboradormanagement.application.RegistarColaboradorController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;
import java.net.URI;

/**
 * @author Paulo Gandra Sousa
 */
class MainMenu extends ClientUserBaseUI {

    private AplicacaoPortalController aplicacaoController = new AplicacaoPortalController();

    private static final String SEPARATOR_LABEL = "--------------";

    private static final String RETURN_LABEL = "Return ";

    private static final String RETURN = "Return ";

    private static final String NOT_IMPLEMENTED_YET = "Not implemented yet";

    private static final int EXIT_OPTION = 0;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int BOOKINGS_OPTION = 2;
    private static final int ACCOUNT_OPTION = 3;
    private static final int SETTINGS_OPTION = 4;

    // BOOKINGS MENU
    private static final int BOOK_A_MEAL_OPTION = 2;
    private static final int LIST_MY_BOOKINGS_OPTION = 3;

    // ACCOUNT MENU
    private static final int LIST_MOVEMENTS_OPTION = 1;

    // SETTINGS
    private static final int SET_USER_ALERT_LIMIT_OPTION = 1;

    // QTD LOGIN
    private static int QTD_USER_LOGINS = 0;

    // PORT FOR LOGIN
    private static final int port = 32507;

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private void dashboardLoader() {

        aplicacaoController.startConnection();

        try {
            String localhost = "http://localhost:" + port;
            URI uri = new URI(localhost);
            java.awt.Desktop.getDesktop().browse(uri);
            System.out.println("Web page opened in browser");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    /**
     * @return true if the user selected the exit option
     */
    @Override
    public boolean doShow() {
        final Menu menu = buildMainMenu();
        final MenuRenderer renderer
                = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);

        return renderer.render();
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.COLABORADOR)) {
            if (QTD_USER_LOGINS == 0) {
                dashboardLoader();
                QTD_USER_LOGINS++;
            }
            mainMenu.addSubMenu(2, buildConsultaCatalogo());
            mainMenu.addSubMenu(3, buildConsultaServico());
            mainMenu.addSubMenu(4, buildSolicitacaoServico());
            mainMenu.addSubMenu(5, buildTarefasDoColaborador());
            mainMenu.addSubMenu(6, buildAprovarPedido());
            mainMenu.addSubMenu(7, buildPedidos());
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildConsultaCatalogo() {
        final Menu menu = new Menu("Consulta Catálogos >");

        menu.addItem(1, "Listar Catálogos Disponiveis", new ConsultarCatalogoAction());
        menu.addItem(2, "Pesquisar Catálogos por Campos", new PesquisarCatalogoPorCamposAction());

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }

    private Menu buildConsultaServico() {
        final Menu menu = new Menu("Consulta Serviços >");

        menu.addItem(1, "Listar Serviços Disponiveis", new ConsultarServicosAction());
        menu.addItem(2, "Pesquisar Serviços por Campos", new PesquisaServicosPorCamposAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }

    private Menu buildSolicitacaoServico() {
        final Menu menu = new Menu("Solicitar Serviço >");

        menu.addItem(1, "Solicitar Serviço", new SolicitarServicoAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }

    private Menu buildTarefasDoColaborador() {
        final Menu menu = new Menu("Tarefas >");

        menu.addItem(1, "Reivindicar Tarefa", new ReivindicarTarefaAction());
        menu.addItem(2, "Tarefas Pendentes do Colaborador", new TarefasPendentesAction());
        menu.addItem(3, "Consultar tarefas", new ConsultarTarefaAction());
        menu.addItem(4, "Realizar Tarefa Pendente", new RealizarTarefaAction());
        menu.addItem(5, "Indicar Grau de Satisfacao de um Pedido Resolvido", new AvaliacaoResolucaoAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }

    private Menu buildAprovarPedido() {
        final Menu menu = new Menu("Aprovar Pedido >");

        menu.addItem(1, "Aprovar Pedido", new AprovarPedidoAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }
    
    private Menu buildPedidos(){
        final Menu menu = new Menu("Consultar Pedidos >");

        menu.addItem(1, "Consultar Pedidos", new ConsultarPedidosAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }

}
