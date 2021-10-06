/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.colaboradormanagement.application;

import eapli.base.colaboradormanagement.domain.Funcao;
import eapli.base.colaboradormanagement.repositories.FuncaoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

/**
 *
 * @author Guilherme
 */
public class ListFuncaoService {
    
    private final FuncaoRepository funcaoRepository = PersistenceContext.repositories().funcoes();
    
    public Iterable<Funcao> allFuncoes() {
        return this.funcaoRepository.findAll();
        
    }
    
}
