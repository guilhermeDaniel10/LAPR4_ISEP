/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.colaboradormanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Contacto;
import eapli.base.colaboradormanagement.domain.DataNascimento;
import eapli.base.colaboradormanagement.domain.EmailInstitucional;
import eapli.base.colaboradormanagement.domain.Funcao;
import eapli.base.colaboradormanagement.domain.LocalResidencia;
import eapli.base.colaboradormanagement.domain.NomeCompleto;
import eapli.base.colaboradormanagement.domain.NomeCurto;
import eapli.base.colaboradormanagement.domain.NumeroMecanografico;
import eapli.base.colaboradormanagement.repositories.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.AddUserController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.Username;
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Guilherme
 */
public class RegistarColaboradorController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaboradores();
    private final ListColaboradorService lCS = new ListColaboradorService();
    private final ListFuncaoService lFC = new ListFuncaoService();
    final AddUserController userController = new AddUserController();

    public Colaborador registerColaborador(String nM, Funcao funcao, String fstName, String lstName,
            String nomeCompleto, Date dataNascimento, String distrito, String concelho,
            String email, String indicativo, String contacto, Colaborador responsavel) throws ParseException {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.RESPONSAVEL_RECURSOS_HUMANOS, BaseRoles.POWER_USER);

        NumeroMecanografico nm = new NumeroMecanografico(nM);
        NomeCurto nc = new NomeCurto(fstName, lstName);
        NomeCompleto nCom = new NomeCompleto(nomeCompleto);
        DataNascimento dataNasci = new DataNascimento(dataNascimento);
        LocalResidencia localResidencia = new LocalResidencia(distrito, concelho);
        EmailInstitucional emailInstitucional = new EmailInstitucional(email);
        Contacto numero = new Contacto(indicativo, contacto);

        final Colaborador newColaborador = new Colaborador(nm, funcao, nc, nCom, dataNasci, localResidencia, emailInstitucional, numero, responsavel);

        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.COLABORADOR);
        userController.addUser(nM, "Password1", nc.primeiroNome(), nc.ultimoNome(), email, roles);
        return colaboradorRepository.save(newColaborador);

    }

    public Iterable<Colaborador> allColaboradores() {
        return lCS.allColaboradores();
    }

    public Iterable<Funcao> availableFuncoes() {
        return lFC.allFuncoes();
    }

    public Colaborador currentColaborador() {
        Username currentUser = authz.session().get().authenticatedUser().identity();
        Colaborador colab = colaboradorRepository.findColaboradorByNum(new NumeroMecanografico(currentUser.toString()));
        return colab;
    }

}
