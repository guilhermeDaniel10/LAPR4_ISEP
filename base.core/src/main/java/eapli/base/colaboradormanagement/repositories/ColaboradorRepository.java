/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.colaboradormanagement.repositories;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.EmailInstitucional;
import eapli.base.colaboradormanagement.domain.NumeroMecanografico;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.framework.domain.repositories.DomainRepository;
import java.util.Optional;

/**
 *
 * @author Guilherme
 */
public interface ColaboradorRepository extends DomainRepository<Long,Colaborador>{
    
    Colaborador findColaboradorByNum(NumeroMecanografico nmR);
    
//    default Optional<Colaborador> findByNumeroMecanografico(final NumeroMecanografico nmr){
//        return ofIdentity(nmr);
//    }
//    
//    Optional<Colaborador> findByEmail(final EmailInstitucional email);
//    
//    Iterable<Colaborador> findAllActiveColaboradores();
    
    Iterable<Colaborador> findColaboradoresByEquipa(Equipa equipa);
}
