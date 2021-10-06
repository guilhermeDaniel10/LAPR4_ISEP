/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.inmemory;

import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.servicomanagement.domain.AtividadeRealizacao;
import eapli.base.servicomanagement.repositories.AtividadeRealizacaoRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

/**
 *
 * @author lucas
 */
public class InMemoryAtividadeRealizacaoRepository extends InMemoryDomainRepository<AtividadeRealizacao, Long> implements AtividadeRealizacaoRepository {

    static {
        InMemoryInitializer.init();
    }

    public AtividadeRealizacao findAtividadeRealizacao(String designacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<AtividadeRealizacao> atividadesRealizacaoEquipas(Iterable<Equipa> equipas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
