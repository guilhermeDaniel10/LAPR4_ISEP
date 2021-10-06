/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.equipamanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.EquipasColaborador;
import eapli.base.equipamanagement.DTO.EquipaDto;
import eapli.base.equipamanagement.domain.Equipa;

/**
 *
 * @author lucas
 */
public class ListEquipaController {
    
    private final ListEquipaService equipaService = new ListEquipaService();
    
    public Iterable<Equipa> listAllEquipas() {
        return equipaService.allEquipas();
    }
    
    public Iterable<EquipasColaborador> listEquipasColaborador(Colaborador colaborador){
        return equipaService.equipasDeColaborador(colaborador);
    }
    
    public Iterable<EquipaDto> equipasAsDTO(){
        return equipaService.equipasAsDTO();
    }
     
}
