/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.slamanagement.application;

import eapli.base.slamanagement.domain.NivelCriticidade;

/**
 *
 * @author lucas
 */
public class ListSLAController {
    
    private final ListSLAService slaService = new ListSLAService();
    
    public Iterable<NivelCriticidade> listAllSLA() {
        return slaService.allSLA();
    }
 
}
