/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.catalogomanagemente.application;

import eapli.base.slamanagement.application.ListSLAController;
import eapli.base.slamanagement.application.ListSLAService;
import eapli.base.slamanagement.domain.NivelCriticidade;
import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.DescBreveCatalogo;
import eapli.base.catalogomanagement.domain.DescCompletaCatalogo;
import eapli.base.catalogomanagement.domain.IconeCatalogo;
import eapli.base.catalogomanagement.domain.IdentificadorCatalogo;
import eapli.base.catalogomanagement.domain.TituloCatalogo;
import eapli.base.catalogomanagement.repositories.CatalogoRepository;
import eapli.base.colaboradormanagement.application.ListColaboradorController;
import eapli.base.colaboradormanagement.application.ListColaboradorService;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipamanagement.application.ListEquipaController;
import eapli.base.equipamanagement.application.ListEquipaService;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import java.io.IOException;
import java.text.ParseException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lucas
 */
@Component
@UseCaseController
public class RegistarCatalogoController {
    
    @Autowired
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    @Autowired
    private final CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogo();
    @Autowired
    private final ListColaboradorController lCC = new ListColaboradorController();
    @Autowired
    private final ListCatalogoController lCAC = new ListCatalogoController();    
    @Autowired
    private final ListEquipaController lEC = new ListEquipaController();
    @Autowired
    private final ListSLAController lSLA = new ListSLAController();

    
    @Transactional
    public Catalogo registerCatalogo(String strIdCatalogo,Colaborador responsavelCatalogo, String strTituloCatalogo, 
            String strDescBreveCatalogo, String strDescCompletaCatalogo,String iconeName, String extensaoIcone, final Set<Equipa> equipasComAcesso, boolean estadoCatalogo, NivelCriticidade nivelCriticidadeCatalogo) throws ParseException {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.GESTOR_SERVICO_HELP_DESK, BaseRoles.POWER_USER);
        
            IdentificadorCatalogo idCatalogo = new IdentificadorCatalogo(strIdCatalogo);
            TituloCatalogo tituloCat = new TituloCatalogo(strTituloCatalogo);
            DescBreveCatalogo descBreveCat = new DescBreveCatalogo(strDescBreveCatalogo);
            DescCompletaCatalogo descCompCat = new DescCompletaCatalogo(strDescCompletaCatalogo);
            
        IconeCatalogo iconeCat = null;
        try {
            iconeCat = new IconeCatalogo(iconeName,extensaoIcone);
        } catch (IOException ex) {
            Logger.getLogger(RegistarCatalogoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Catalogo newCatalogo = new Catalogo(idCatalogo,tituloCat,descBreveCat,descCompCat,iconeCat);
        if (!equipasComAcesso.isEmpty()) {
            newCatalogo.copyEquipas(equipasComAcesso);
        }
        if (responsavelCatalogo != null) {
            newCatalogo.adicionarColaboradorResponsavel(responsavelCatalogo);
        }
        if (nivelCriticidadeCatalogo != null) {
            newCatalogo.adicionarNivelCriticidadeCatalogo(nivelCriticidadeCatalogo);
        }
        if (estadoCatalogo == true) {
            newCatalogo.activateState();
        }
        return catalogoRepository.save(newCatalogo);
    }
    
    @Transactional
    public Catalogo registerCatalogo(Catalogo catalogoConcluido) throws ParseException {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.GESTOR_SERVICO_HELP_DESK);     
        return catalogoRepository.save(catalogoConcluido);
    }

    public Iterable<Colaborador> allColaboradores() {
        return lCC.listAllColaboradores();
    }
    
    public Iterable<Equipa> allEquipas() {
        return lEC.listAllEquipas();
    }
    
    public Iterable<Catalogo> catalogosPorConcluir() {
        return lCAC.listAllCatalogosIndisponiveis();
    }
    
    public Iterable<NivelCriticidade> SLADisponiveis() {
        return lSLA.listAllSLA();
    }
    
}
