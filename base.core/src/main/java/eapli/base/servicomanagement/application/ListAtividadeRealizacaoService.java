/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.servicomanagement.application;

import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.AtividadeRealizacao;
import eapli.base.servicomanagement.repositories.AtividadeRealizacaoRepository;

/**
 *
 * @author Guilherme
 */
public class ListAtividadeRealizacaoService {

    private final AtividadeRealizacaoRepository atividadeRepository = PersistenceContext.repositories().atividadeRealizacao();

    public Iterable<AtividadeRealizacao> atividadesRealizacaoEquipas(Iterable<Equipa> equipas) {
        return atividadeRepository.atividadesRealizacaoEquipas(equipas);
    }

}
