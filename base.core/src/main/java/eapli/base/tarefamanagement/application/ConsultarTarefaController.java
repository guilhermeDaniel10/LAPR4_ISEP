/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.tarefamanagement.application;

import eapli.base.colaboradormanagement.application.RegistarColaboradorController;
import eapli.base.tarefamanagement.DTO.TarefaDTO;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author rui3m
 */
@Component
@UseCaseController
public class ConsultarTarefaController {
    
    @Autowired
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
        
    @Autowired
    private final RegistarColaboradorController colabController = new RegistarColaboradorController();
    
    @Autowired
    private final ListTarefasController listController = new ListTarefasController();
    
    public boolean assignColaborador(){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.COLABORADOR, BaseRoles.POWER_USER);
        return listController.assignColaborador(colabController.currentColaborador());
    }
    
    public Iterable<String> criteriosOrdenacao(){
        return listController.criteriosOrdenacao();
    }
    
    public Iterable<String> criteriosFiltragem(){
        return listController.criteriosFiltragem();
    }
    
    public Iterable<TarefaDTO> consultar(String criterio, boolean ascendente){
        return listController.consultarBy(criterio, ascendente);
    }
    
    
    public Iterable<TarefaDTO> consultarFiltrado(String criterio, boolean ascendente,String criterioFiltro, int limiteInferior,int limiteSuperior){
        return listController.consultarFiltrado(criterio, ascendente,criterioFiltro,String.valueOf(limiteInferior),String.valueOf(limiteSuperior));
    }
}
