/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.tipoequipamanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tipoequipamanagement.domain.TipoEquipa;
import eapli.base.tipoequipamanagement.repositories.TipoEquipaRepository;

/**
 *
 * @author Guilherme
 */
public class ListTipoEquipaService {

    private final TipoEquipaRepository tpEquipaRepo = PersistenceContext.repositories().tipoEquipa();

    public Iterable<TipoEquipa> allTipoEquipas() {
        return this.tpEquipaRepo.findAll();

    }

}
