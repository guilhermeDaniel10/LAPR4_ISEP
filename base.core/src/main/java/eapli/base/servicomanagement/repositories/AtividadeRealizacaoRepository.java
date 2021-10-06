/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.servicomanagement.repositories;

import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.servicomanagement.domain.AtividadeRealizacao;
import eapli.framework.domain.repositories.DomainRepository;

/**
 *
 * @author lucas
 */
public interface AtividadeRealizacaoRepository extends DomainRepository<Long,AtividadeRealizacao> {
    
    public Iterable<AtividadeRealizacao> atividadesRealizacaoEquipas(Iterable<Equipa> equipas);
}
