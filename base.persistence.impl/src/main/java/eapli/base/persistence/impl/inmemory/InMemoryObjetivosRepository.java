/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.inmemory;

import eapli.base.objetivosmanagement.domain.Objetivos;
import eapli.base.objetivosmanagement.repositories.ObjetivosRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

/**
 *
 * @author rui3m
 */
public class InMemoryObjetivosRepository extends InMemoryDomainRepository<Objetivos, Long> implements ObjetivosRepository {

    static {
        InMemoryInitializer.init();
    }
}
