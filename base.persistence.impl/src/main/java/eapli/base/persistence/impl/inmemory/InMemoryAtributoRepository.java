/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.inmemory;

import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.repositories.AtributoRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

/**
 *
 * @author lucas
 */
public class InMemoryAtributoRepository extends InMemoryDomainRepository<Atributo, Long> implements AtributoRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Atributo findAtributoByNome(String strNomeVariavel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
