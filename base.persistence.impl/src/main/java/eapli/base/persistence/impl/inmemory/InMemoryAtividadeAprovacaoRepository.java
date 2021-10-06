/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.inmemory;

import eapli.base.servicomanagement.domain.AtividadeAprovacao;
import eapli.base.servicomanagement.repositories.AtividadeAprovacaoRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

/**
 *
 * @author lucas
 */
public class InMemoryAtividadeAprovacaoRepository extends InMemoryDomainRepository<AtividadeAprovacao, Long> implements AtividadeAprovacaoRepository {

    static {
        InMemoryInitializer.init();
    }

    public AtividadeAprovacao findAtividadeAprovacao(String designacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
