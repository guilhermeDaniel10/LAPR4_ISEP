/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.equipamanagement.application;

import eapli.base.colaboradormanagement.application.ListColaboradorService;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipamanagement.domain.AcronimoEquipa;
import eapli.base.equipamanagement.domain.DesignacaoEquipa;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.equipamanagement.repositories.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tipoequipamanagement.application.ListTipoEquipaService;
import eapli.base.tipoequipamanagement.domain.TipoEquipa;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Guilherme
 */
public class CriarEquipaController {
    
    @Autowired
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    
    private final EquipaRepository equipaRepo = PersistenceContext.repositories().equipa();
    
    @Autowired
    private final ListColaboradorService lCS = new ListColaboradorService();
    
    private final ListTipoEquipaService lTES = new ListTipoEquipaService();
    
    public Equipa registerEquipa(String acronimo, String designacao, TipoEquipa tpEquipa,
            final Set<Colaborador> responsaveis){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.RESPONSAVEL_RECURSOS_HUMANOS, BaseRoles.POWER_USER);
        
        Equipa equipa = new Equipa(new AcronimoEquipa(acronimo), new DesignacaoEquipa(designacao));
        
        equipa.adicionarTipoEquipa(tpEquipa);
        equipa.copyColaboradores(responsaveis);
        
        
        return equipaRepo.save(equipa);
        
    }
    
    public Iterable<Colaborador> allColaboradores(){
        return lCS.allColaboradores();
    }
    
    public Iterable<TipoEquipa> allTiposEquipa(){
        return lTES.allTipoEquipas();
    }
    
    public Equipa findEquipaByAcronimo(String acronimo){
        return equipaRepo.equipaPorAcronimo(acronimo);
    }
}
