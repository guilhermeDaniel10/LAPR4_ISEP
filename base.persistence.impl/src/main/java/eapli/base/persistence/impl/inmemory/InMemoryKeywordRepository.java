/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.inmemory;

import eapli.base.servicomanagement.domain.Keyword;
import eapli.base.servicomanagement.repositories.KeywordRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

/**
 *
 * @author lucas
 */
public class InMemoryKeywordRepository extends InMemoryDomainRepository<Keyword, Long> implements KeywordRepository {
    static {
        InMemoryInitializer.init();
    }
}