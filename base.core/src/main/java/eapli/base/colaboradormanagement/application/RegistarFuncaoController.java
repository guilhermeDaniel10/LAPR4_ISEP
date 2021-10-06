/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.colaboradormanagement.application;

import eapli.base.colaboradormanagement.domain.CodigoAlfanumerico;
import eapli.base.colaboradormanagement.domain.DesignacaoFuncao;
import eapli.base.colaboradormanagement.domain.Funcao;
import eapli.base.colaboradormanagement.repositories.FuncaoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

/**
 *
 * @author Guilherme
 */
public class RegistarFuncaoController {
    
    private final FuncaoRepository funcaoRepository = PersistenceContext.repositories().funcoes();
    private final ListFuncaoService lFS = new ListFuncaoService();
    
    public Funcao registarFuncao(CodigoAlfanumerico codigo, DesignacaoFuncao designacao){
        final Funcao newFuncao = new Funcao(codigo, designacao);
        
        return funcaoRepository.save(newFuncao);
    }
    
    public Iterable<Funcao> allFuncoes(){
        return lFS.allFuncoes();
    }
    
}
