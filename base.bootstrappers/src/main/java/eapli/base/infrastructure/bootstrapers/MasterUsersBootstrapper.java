/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.base.infrastructure.bootstrapers;

import java.util.HashSet;
import java.util.Set;

import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.Role;

/**
 * @author Paulo Gandra Sousa
 */
public class MasterUsersBootstrapper extends UsersBootstrapperBase implements Action {

    @Override
    public boolean execute() {
        registerAdmin("admin", TestDataConstants.PASSWORD1, "Jane", "Doe Admin",
                "miguelCosta@email.local");
        registerGRH("grh", TestDataConstants.PASSWORD1, "Guilherme", "Gestor", "gui@email.org");
        registerGSHD("gshd", TestDataConstants.PASSWORD1, "Lucas", "Gestor Help Desk", "1171589@isep.ipp.pt");
        return true;
    }

    /**
     *
     */
    private void registerAdmin(final String username, final String password, final String firstName,
            final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.ADMIN);

        registerUser(username, password, firstName, lastName, email, roles);
    }
    
    private void registerGRH(final String username, final String password, final String firstName,
            final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.RESPONSAVEL_RECURSOS_HUMANOS);

        registerUser(username, password, firstName, lastName, email, roles);
    }
    
    private void registerGSHD(final String username, final String password, final String firstName,
            final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.GESTOR_SERVICO_HELP_DESK);

        registerUser(username, password, firstName, lastName, email, roles);
    }

}
