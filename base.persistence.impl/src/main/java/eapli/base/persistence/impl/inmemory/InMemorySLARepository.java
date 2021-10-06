/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.inmemory;

import eapli.base.slamanagement.domain.NivelCriticidade;
import eapli.base.slamanagement.repositories.SLARepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

/**
 *
 * @author rui3m
 */
public class InMemorySLARepository extends InMemoryDomainRepository<NivelCriticidade, Long> implements SLARepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public NivelCriticidade findCriticidadeByEtiqueta(String designacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
