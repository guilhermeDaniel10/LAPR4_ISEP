/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.inmemory;

import eapli.base.tipoequipamanagement.domain.TipoEquipa;
import eapli.base.tipoequipamanagement.repositories.TipoEquipaRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

/**
 *
 * @author Guilherme
 */
public class InMemoryTipoEquipaRepository extends InMemoryDomainRepository<TipoEquipa, Long> implements TipoEquipaRepository {

    static {
        InMemoryInitializer.init();
    }
}
