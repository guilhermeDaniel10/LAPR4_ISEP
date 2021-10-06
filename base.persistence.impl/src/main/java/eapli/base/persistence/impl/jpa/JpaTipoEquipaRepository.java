/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.tipoequipamanagement.domain.TipoEquipa;
import eapli.base.tipoequipamanagement.repositories.TipoEquipaRepository;

/**
 *
 * @author Guilherme
 */
public class JpaTipoEquipaRepository extends BasepaRepositoryBase<TipoEquipa, Long, Long> implements TipoEquipaRepository{
    JpaTipoEquipaRepository(){
        super("codigoUnico");
    }
}
