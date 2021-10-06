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
package eapli.base.app.backoffice.console.presentation;

import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.Application;
import eapli.base.app.backoffice.console.presentation.authz.AddUserUI;
import eapli.base.app.backoffice.console.presentation.authz.DeactivateUserAction;
import eapli.base.app.backoffice.console.presentation.authz.ListUsersAction;
import eapli.base.app.backoffice.console.presentation.catalogos.ConcluirCatalogoAction;
import eapli.base.app.backoffice.console.presentation.clientuser.AcceptRefuseSignupRequestAction;
import eapli.base.app.backoffice.console.presentation.colaboradores.RegistarColaboradorAction;
import eapli.base.app.backoffice.console.presentation.SLA.DefinirNivelCriticidadeAction;
import eapli.base.app.backoffice.console.presentation.SLA.ListarCumprimentoSlaAction;
import eapli.base.app.backoffice.console.presentation.catalogos.AtribuirNivelCriticidadeAction;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.ShowMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;
import eapli.base.app.backoffice.console.presentation.catalogos.RegistarCatalogoAction;
import eapli.base.app.backoffice.console.presentation.colaboradores.AssociarColaboradorAction;
import eapli.base.app.backoffice.console.presentation.colaboradores.RemoverColaboradorAction;
import eapli.base.app.backoffice.console.presentation.equipas.CriarEquipaAction;
import eapli.base.app.backoffice.console.presentation.servicos.AplicacaoServicoRHAction;
import eapli.base.app.backoffice.console.presentation.servicos.ConcluirServicoAction;
import eapli.base.app.backoffice.console.presentation.servicos.RegistarServicoAction;
import eapli.base.app.backoffice.console.presentation.tipoequipa.RegistarTipoEquipaAction;

/**
 * TODO split this class in more specialized classes for each menu
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu extends AbstractUI {

    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;

    // USERS
    private static final int ADD_USER_OPTION = 1;
    private static final int LIST_USERS_OPTION = 2;
    private static final int DEACTIVATE_USER_OPTION = 3;
    private static final int ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION = 4;

    // COLABORADOR
    private static final int COLABORADOR_REGISTER_OPTION = 1;
    private static final int COLABORADOR_ASSOCIAR_OPTION = 2;
    private static final int COLABORADOR_REMOVER_OPTION = 3;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int USERS_OPTION = 2;
    private static final int SETTINGS_OPTION = 4;

    // RESPONSAVEL RECURSOS HUMANOS
    private static final int REGISTAR_COLABORADORES_OPTION = 2;
    private static final int REGISTAR_TIPO_EQUIPA_OPTION = 3;
    private static final int REGISTAR_EQUIPA_OPTION = 4;

    // GESTOR SERVIÇOS HELP DESK
    private static final int CATALOGOS_OPTION = 2;
    private static final int CATALOGO_REGISTER_OPTION = 1;
    private static final int CATALOGO_CONCLUSION_OPTION = 2;
    private static final int CATALOGO_ATRIBUIR_CRITICIDADE_OPTION = 3;
    private static final int SERVICOS_OPTION = 3;
    private static final int SERVICO_REGISTER_OPTION = 1;
    private static final int SERVICO_CONCLUSION_OPTION = 2;
    private static final int SLA_OPTION = 4;
    private static final int SLA_REGISTAR_OPTION = 1;
    private static final int SLA_CONSULTAR_OPTION = 2;
    private static final int WEB_OPTION = 5;

    private static final String SEPARATOR_LABEL = "--------------";

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

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
        final MenuRenderer renderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return renderer.render();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "Base [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Base [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.ADMIN)) {
            final Menu usersMenu = buildUsersMenu();
            mainMenu.addSubMenu(USERS_OPTION, usersMenu);
            final Menu testeGRH = buildResponsavelRHColaboradoresMenu();
            mainMenu.addSubMenu(3, testeGRH);
            final Menu settingsMenu = buildAdminSettingsMenu();
            mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);

        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.RESPONSAVEL_RECURSOS_HUMANOS)) {
            final Menu colaboradoresRRH = buildResponsavelRHColaboradoresMenu();
            final Menu equipasRRH = buildEquipaMenu();
            mainMenu.addSubMenu(REGISTAR_COLABORADORES_OPTION, colaboradoresRRH);
            mainMenu.addSubMenu(REGISTAR_TIPO_EQUIPA_OPTION, equipasRRH);
            
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.GESTOR_SERVICO_HELP_DESK)) {
            final Menu testeGRH = buildGestorSHDCatalogosMenu();
            final Menu testeGRH2 = buildGestorSHDServicosMenu();
            final Menu testeGRH3 = buildGestorSHDSLAMenu();
            mainMenu.addSubMenu(CATALOGOS_OPTION, testeGRH);
            mainMenu.addSubMenu(SERVICOS_OPTION, testeGRH2);
            mainMenu.addSubMenu(SLA_OPTION, testeGRH3);
            mainMenu.addSubMenu(WEB_OPTION, buildMostrarInformacaoTarefasWeb());
            
                    
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildAdminSettingsMenu() {
        final Menu menu = new Menu("Settings >");

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildUsersMenu() {
        final Menu menu = new Menu("Users >");

        menu.addItem(ADD_USER_OPTION, "Add User", new AddUserUI()::show);
        menu.addItem(LIST_USERS_OPTION, "List all Users", new ListUsersAction());
        menu.addItem(DEACTIVATE_USER_OPTION, "Deactivate User", new DeactivateUserAction());
        menu.addItem(ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION, "Accept/Refuse Signup Request",
                new AcceptRefuseSignupRequestAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildResponsavelRHColaboradoresMenu() {
        final Menu menu = new Menu("Colaboradores >");

        menu.addItem(COLABORADOR_REGISTER_OPTION, "Registar Colaborador", new RegistarColaboradorAction());
        
        menu.addItem(COLABORADOR_ASSOCIAR_OPTION, "Associar colaborador de uma equipa.", new AssociarColaboradorAction());

        menu.addItem(COLABORADOR_REMOVER_OPTION, "Remover colaborador de uma equipa.", new RemoverColaboradorAction());
        
        
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildEquipaMenu() {
        final Menu menu = new Menu("Equipas >");
        menu.addItem(1, "Registar Tipo de Equipa", new RegistarTipoEquipaAction());
        menu.addItem(2, "Registar Equipa", new CriarEquipaAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }

    private Menu buildGestorSHDCatalogosMenu(){
        final Menu menu = new Menu("Gerir Catalogos >");

        menu.addItem(CATALOGO_REGISTER_OPTION, "Registar Catalogo", new RegistarCatalogoAction());
        
        menu.addItem(CATALOGO_CONCLUSION_OPTION, "Concluir Catalogo", new ConcluirCatalogoAction());
        
        menu.addItem(CATALOGO_ATRIBUIR_CRITICIDADE_OPTION,"Atribuir nivel criticidade a catalogo", new AtribuirNivelCriticidadeAction());

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
      
        return menu;
    }
    
    private Menu buildGestorSHDServicosMenu(){
        final Menu menu = new Menu("Gerir Servicos >");

        menu.addItem(SERVICO_REGISTER_OPTION, "Registar Servico", new RegistarServicoAction());
        
         menu.addItem(SERVICO_CONCLUSION_OPTION, "Concluir Servico", new ConcluirServicoAction());

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
      
        return menu;
    }
    
    private Menu buildGestorSHDSLAMenu(){
        final Menu menu = new Menu("Gerir SLAs >");
        
        menu.addItem(SLA_REGISTAR_OPTION, "Definir Nivel Criticidade", new DefinirNivelCriticidadeAction());
        
        menu.addItem(SLA_CONSULTAR_OPTION, "Consultar cumprimento SLA", new ListarCumprimentoSlaAction());
        
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        
        return menu;
    }
    
     private Menu buildMostrarInformacaoTarefasWeb(){
        final Menu menu = new Menu("Mostrar Info Tarefas (browser) >");
        
        menu.addItem(1, "Mostrar Info Tarefas (browser)", new AplicacaoServicoRHAction());
        
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        
        return menu;
    }
    
           
    

}
