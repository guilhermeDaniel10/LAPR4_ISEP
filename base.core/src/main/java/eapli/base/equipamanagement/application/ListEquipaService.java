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
import eapli.base.equipamanagement.repositories.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tipoequipamanagement.domain.TipoEquipa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class ListEquipaService {
    
    private final EquipaRepository equipaRepository = PersistenceContext.repositories().equipa();
    
    public Iterable<Equipa> allEquipas() {
        return this.equipaRepository.findAll();       
    }
    
    public Iterable<Equipa> equipasTipoDiferente(Iterable<TipoEquipa> tiposEquipa){
        return this.equipaRepository.equipasTipoDiferente(tiposEquipa);
    }
    
    public Iterable<EquipasColaborador> equipasDeColaborador(Colaborador colaborador){
        return colaborador.equipas();
    }
    
    public Iterable<EquipaDto> equipasAsDTO() {
        List<EquipaDto> equipaDto = new ArrayList<>();
        for (Equipa equipa : allEquipas()) {            
            equipaDto.add(equipa.toDTO());
        }

        return equipaDto;
    }
       
}
