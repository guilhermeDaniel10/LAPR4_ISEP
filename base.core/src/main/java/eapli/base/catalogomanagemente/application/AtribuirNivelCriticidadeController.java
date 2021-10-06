/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.catalogomanagemente.application;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.repositories.CatalogoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.objetivosmanagement.domain.Objetivos;
import eapli.base.slamanagement.application.ListSLAController;
import eapli.base.slamanagement.domain.NivelCriticidade;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rui3m
 */
@Component
@UseCaseController
public class AtribuirNivelCriticidadeController {
        
    @Autowired
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    @Autowired
    private final CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogo();
    @Autowired
    private final ListCatalogoController listCalalogoService = new ListCatalogoController();    
    @Autowired
    private final ListSLAController listSLAService = new ListSLAController();

    private Objetivos objetivos;
    

    public boolean createObjetivos(int tempoMedioAprovacao, int tempoMaximoAprovacao, int tempoMedioResolucao, int tempoMaximoResolucao){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.GESTOR_SERVICO_HELP_DESK, BaseRoles.POWER_USER);
        this.objetivos = new Objetivos(tempoMaximoAprovacao,tempoMaximoResolucao,tempoMedioAprovacao,tempoMedioResolucao);
        
        return true;
    }
    
    @Transactional
    public boolean save(Catalogo catalogo, NivelCriticidade nivelCriticidade){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.GESTOR_SERVICO_HELP_DESK, BaseRoles.POWER_USER);
        if(objetivos == null){
            catalogo.setNivelCriticidade(nivelCriticidade);
            this.catalogoRepository.save(catalogo);
            return true;
        }
        catalogo.setNivelCriticidade(nivelCriticidade);
        catalogo.setObjetivos(objetivos);
        this.catalogoRepository.save(catalogo);
        return true;
    }
    
    public Iterable<NivelCriticidade> allNiveisCriticidade(){
        ArrayList<NivelCriticidade> list = (ArrayList)listSLAService.listAllSLA();
        if(list.isEmpty())
            return null;
        
        return list;
    }
    
    public Iterable<Catalogo> allCatalogos(){
        ArrayList<Catalogo> list = (ArrayList)listCalalogoService.listAllCatalogos();
        if(list.isEmpty())
            return null;
        
        return list;
    }
}
