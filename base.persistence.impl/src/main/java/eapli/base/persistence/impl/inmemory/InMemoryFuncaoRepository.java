/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.inmemory;

import eapli.base.colaboradormanagement.domain.CodigoAlfanumerico;
import eapli.base.colaboradormanagement.domain.Funcao;
import eapli.base.colaboradormanagement.repositories.FuncaoRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

/**
 *
 * @author Guilherme
 */
public class InMemoryFuncaoRepository extends InMemoryDomainRepository<Funcao, Long> implements FuncaoRepository{
    static{
        InMemoryInitializer.init();
    }
}
