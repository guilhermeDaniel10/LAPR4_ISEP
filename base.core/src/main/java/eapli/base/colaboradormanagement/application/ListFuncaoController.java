/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.colaboradormanagement.application;

import eapli.base.colaboradormanagement.domain.Funcao;

/**
 *
 * @author Guilherme
 */
public class ListFuncaoController {
    
    private final ListFuncaoService funcaoService = new ListFuncaoService();
    
    public Iterable<Funcao> listAllFuncoes() {
        return funcaoService.allFuncoes();
    }
    
}
