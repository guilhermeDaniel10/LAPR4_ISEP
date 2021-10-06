/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.inmemory;

import eapli.base.cor.domain.Cor;
import eapli.base.cor.repositories.CorRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

/**
 *
 * @author Guilherme
 */
public class InMemoryCorRepository extends InMemoryDomainRepository<Cor, String> implements CorRepository{
    static{
        InMemoryInitializer.init();
    }
}
