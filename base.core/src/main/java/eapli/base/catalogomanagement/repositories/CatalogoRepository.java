/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.catalogomanagement.repositories;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.IdentificadorCatalogo;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.framework.domain.repositories.DomainRepository;

/**
 *
 * @author lucas
 */
public interface CatalogoRepository extends DomainRepository<Long, Catalogo> {

    Iterable<Catalogo> findCatalogosByTeam(Equipa equipa);

    Iterable<Catalogo> findCatalogoByFields(String field, Equipa equipa);
    
    Catalogo findCatalogoById(IdentificadorCatalogo id);
}
