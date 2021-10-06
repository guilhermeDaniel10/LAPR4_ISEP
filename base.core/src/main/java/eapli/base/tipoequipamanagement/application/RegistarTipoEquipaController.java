/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.tipoequipamanagement.application;

import eapli.base.cor.application.ListCorService;
import eapli.base.cor.domain.Cor;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tipoequipamanagement.domain.DescricaoTipoEquipa;
import eapli.base.tipoequipamanagement.domain.TipoEquipa;
import eapli.base.tipoequipamanagement.repositories.TipoEquipaRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Guilherme
 */
public class RegistarTipoEquipaController {
    
    @Autowired
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    
    private final TipoEquipaRepository tipoEquipaRepository = PersistenceContext.repositories().tipoEquipa();
    private final ListCorService lCor = new ListCorService();
    
    public TipoEquipa registerTipoEquipa(String descricaoTpEquipa, Cor corTipoEquipa){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.RESPONSAVEL_RECURSOS_HUMANOS, BaseRoles.POWER_USER);
        DescricaoTipoEquipa desc = new DescricaoTipoEquipa(descricaoTpEquipa);
        final TipoEquipa newTipoEquipa = new TipoEquipa(desc, corTipoEquipa);
        
        return tipoEquipaRepository.save(newTipoEquipa);
    }
    
    public Iterable<Cor> allCores(){
        return lCor.allCores();
    }
}
