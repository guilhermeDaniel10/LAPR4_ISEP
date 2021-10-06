/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.inmemory;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.NumeroMecanografico;
import eapli.base.colaboradormanagement.repositories.ColaboradorRepository;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

/**
 *
 * @author Guilherme
 */
public class InMemoryColaboradorRepository extends InMemoryDomainRepository<Colaborador, Long> implements ColaboradorRepository{
    
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Colaborador findColaboradorByNum(NumeroMecanografico nmR) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Colaborador> findColaboradoresByEquipa(Equipa equipa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
