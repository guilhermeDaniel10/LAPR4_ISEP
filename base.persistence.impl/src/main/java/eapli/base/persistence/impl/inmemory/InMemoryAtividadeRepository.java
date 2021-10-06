/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.inmemory;

import eapli.base.bibliotecaatividades.domain.Atividade;
import eapli.base.bibliotecaatividades.repositories.BibliotecaAtividadesRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

/**
 *
 * @author Guilherme
 */
public class InMemoryAtividadeRepository  extends InMemoryDomainRepository<Atividade, Long> implements BibliotecaAtividadesRepository {
    static {
        InMemoryInitializer.init();
    }


}
