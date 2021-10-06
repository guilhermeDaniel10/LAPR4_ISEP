/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.cor.application;

import eapli.base.cor.domain.Cor;

/**
 *
 * @author Guilherme
 */
public class ListCorController {
    
    private final ListCorService corService = new ListCorService();
    
    public Iterable<Cor> listAllCores(){
        return corService.allCores();
    }
    
}
