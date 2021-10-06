/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.servicomanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.repositories.ServicoRepository;

/**
 *
 * @author Guilherme
 */
public class ListServicosRH {
    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servico();
    
    public int allNumeroServicos(){
        return servicoRepository.allServicos();
    }
}
