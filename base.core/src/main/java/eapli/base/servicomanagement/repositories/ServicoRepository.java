/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.servicomanagement.repositories;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.servicomanagement.domain.IdentificadorServico;
import eapli.base.servicomanagement.domain.Servico;
import eapli.framework.domain.repositories.DomainRepository;

/**
 *
 * @author lucas
 */
public interface ServicoRepository extends DomainRepository<Long, Servico> {

    Iterable<Servico> allServicosFromCatalogo(Catalogo catalogo);

    Iterable<Servico> findServicoByFields(String obj, Catalogo catalogo);

    public int allServicos();

    public Servico findServicoByIdentificador(String idSer);
}
