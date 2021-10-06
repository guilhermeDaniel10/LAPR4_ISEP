/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.slamanagement.application;

import eapli.base.slamanagement.domain.NivelCriticidade;
import eapli.base.slamanagement.repositories.SLARepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

/**
 *
 * @author lucas
 */
public class ListSLAService {
    
    private final SLARepository slaRepository = PersistenceContext.repositories().SLA();
    
    public Iterable<NivelCriticidade> allSLA() {
        return this.slaRepository.findAll();     
    }
    
}
