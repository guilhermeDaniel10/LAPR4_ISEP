/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.inmemory;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.IdentificadorCatalogo;
import eapli.base.catalogomanagement.repositories.CatalogoRepository;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

/**
 *
 * @author lucas
 */
public class InMemoryCatalogoRepository extends InMemoryDomainRepository<Catalogo, Long> implements CatalogoRepository {
    
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Catalogo> findCatalogosByTeam(Equipa equipa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Catalogo> findCatalogoByFields(String field, Equipa equipa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Catalogo findCatalogoById(IdentificadorCatalogo id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
