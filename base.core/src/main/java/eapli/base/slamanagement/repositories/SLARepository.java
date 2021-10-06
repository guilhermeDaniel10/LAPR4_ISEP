/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.slamanagement.repositories;

import eapli.base.slamanagement.domain.NivelCriticidade;
import eapli.framework.domain.repositories.DomainRepository;

/**
 *
 * @author rui3m
 */
public interface SLARepository extends DomainRepository<Long, NivelCriticidade>  {
    
    NivelCriticidade findCriticidadeByEtiqueta(String etiqueta);
}
