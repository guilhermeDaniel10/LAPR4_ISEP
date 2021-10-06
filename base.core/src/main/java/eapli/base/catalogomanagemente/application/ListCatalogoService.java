/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.catalogomanagemente.application;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.IdentificadorCatalogo;
import eapli.base.catalogomanagement.repositories.CatalogoRepository;
import eapli.base.colaboradormanagement.application.RegistarColaboradorController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.EquipasColaborador;
import eapli.base.equipamanagement.application.ListEquipaController;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthenticationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Username;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author lucas
 */
public class ListCatalogoService {

    private final RegistarColaboradorController colaboradorController = new RegistarColaboradorController();
    private final CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogo();
    private final ListEquipaController listEquipas = new ListEquipaController();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final AuthenticationService authenticationService = AuthzRegistry.authenticationService();
    
    

    public Iterable<Catalogo> allCatalogos() {

        return this.catalogoRepository.findAll();

    }

    public Iterable<Catalogo> catalogosPorConcluir() {

        Iterable<Catalogo> allCatalogos = allCatalogos();
        List<Catalogo> lstCatalogos = new ArrayList<>();
        Iterable<Catalogo> itCatalogos;

        if (allCatalogos.iterator().hasNext() == false) {
            return allCatalogos();
        }

        for (Catalogo elem : allCatalogos) {
            if (elem.isActive() == false) {
                lstCatalogos.add(elem);
            }
        }

        itCatalogos = lstCatalogos;

        return itCatalogos;
    }

    public Iterable<Catalogo> catalogosConcluidos() {

        Iterable<Catalogo> allCatalogos = allCatalogos();
        List<Catalogo> lstCatalogos = new ArrayList<>();
        Iterable<Catalogo> itCatalogos;

        if (allCatalogos.iterator().hasNext() == false) {
            return allCatalogos();
        }

        for (Catalogo elem : allCatalogos) {
            if (elem.isActive() == true) {
                lstCatalogos.add(elem);
            }
        }

        itCatalogos = lstCatalogos;

        return itCatalogos;
    }

    public Iterable<Catalogo> findCatalogoByTeam(Equipa equipa) {
        return catalogoRepository.findCatalogosByTeam(equipa);
    }

    public Iterable<Catalogo> findCatalogoByMultipleFields(String obj) {
        Iterable<EquipasColaborador> equipasColab = listEquipas.listEquipasColaborador(colaboradorController.currentColaborador());
        List<Catalogo> possibleCatalogos = new ArrayList<>();
        for(EquipasColaborador e : equipasColab){

            catalogoRepository.findCatalogoByFields(obj, e.equipaColaborador()).forEach(possibleCatalogos::add);

        }
        return possibleCatalogos;
    }

    public Catalogo findCatalogoById(IdentificadorCatalogo id) {
        return catalogoRepository.findCatalogoById(id);
    }

    public Iterable<Catalogo> findCatalogosDeColaborador() {
 
        Iterable<EquipasColaborador> equipasColab = listEquipas.listEquipasColaborador(colaboradorController.currentColaborador());
        List<Catalogo> catalogosColab = new ArrayList<>();

        for (EquipasColaborador equipa : equipasColab) {
            Iterable<Catalogo> catalogosTeam = findCatalogoByTeam(equipa.equipaColaborador());
            catalogosTeam.forEach(catalogosColab::add);
        }
        return catalogosColab;
    }

}
