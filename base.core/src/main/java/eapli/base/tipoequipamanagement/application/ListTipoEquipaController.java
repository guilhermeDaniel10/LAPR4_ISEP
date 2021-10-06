/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.tipoequipamanagement.application;

import eapli.base.tipoequipamanagement.domain.TipoEquipa;

/**
 *
 * @author Guilherme
 */
public class ListTipoEquipaController {
    
    private ListTipoEquipaService tipoEquipaService = new ListTipoEquipaService();
    
    public Iterable<TipoEquipa> listAllTipoEquipa(){
        return tipoEquipaService.allTipoEquipas();
    }
    
}
