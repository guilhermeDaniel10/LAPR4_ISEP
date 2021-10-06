/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.colaboradormanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.repositories.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

/**
 *
 * @author Guilherme
 */
public class ListColaboradorService {
    
    private final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaboradores();
    
     public Iterable<Colaborador> allColaboradores() {
        return this.colaboradorRepository.findAll();
        
    }
    
}
