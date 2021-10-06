/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.inmemory;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.servicomanagement.domain.IdentificadorServico;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repositories.ServicoRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

/**
 *
 * @author lucas
 */
public class InMemoryServicoRepository extends InMemoryDomainRepository<Servico, Long> implements ServicoRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Servico> allServicosFromCatalogo(Catalogo catalogo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Servico> findServicoByFields(String obj, Catalogo catalogo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int allServicos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Servico findServicoByIdentificador(String idSer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
