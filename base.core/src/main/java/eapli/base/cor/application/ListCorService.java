/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.cor.application;

import eapli.base.cor.domain.Cor;
import eapli.base.cor.repositories.CorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

/**
 *
 * @author Guilherme
 */
public class ListCorService {
    
    private final CorRepository corRepository = PersistenceContext.repositories().cor();
    
    public Iterable<Cor> allCores(){
        return this.corRepository.findAll();
    }
    
}
