/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.colaboradormanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.EquipasColaborador;
import eapli.base.colaboradormanagement.repositories.ColaboradorRepository;
import eapli.base.equipamanagement.application.ListEquipaService;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tipoequipamanagement.domain.TipoEquipa;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author rui3m
 */
public class AssociarColaboradorController {
    private final ListColaboradorService listColaboradoresService = new ListColaboradorService();
    private final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaboradores();
    private final ListEquipaService listEquipasService = new ListEquipaService();

    private boolean associar;
    private Colaborador colaborador;
    
    public AssociarColaboradorController(){
        
    }
    
    public Iterable<Colaborador> create(boolean associar){
        this.associar = associar;
        return listColaboradoresService.allColaboradores();
    }
    
    public Iterable<Equipa> setColaborador(Colaborador colaborador){
        this.colaborador = colaborador;
        
        if(!associar){
            Set<Equipa> equipas = new HashSet<>();
            for(EquipasColaborador e : colaborador.equipas()){
                equipas.add(e.equipaColaborador());
            }
            if(equipas.isEmpty()){ return null;}
            return equipas;
        }
        
        Set<TipoEquipa> tiposEquipa = colaborador.getTiposEquipa();
        
        
        if(tiposEquipa.isEmpty())
            return listEquipasService.allEquipas();
        
        
        ArrayList<Equipa> equipasCompativeis = (ArrayList<Equipa>)listEquipasService.equipasTipoDiferente(tiposEquipa);
        if(equipasCompativeis.isEmpty()){
            return null;
        }
        return listEquipasService.equipasTipoDiferente(tiposEquipa);
    }
    
    public boolean setEquipa(Equipa equipa){
        if(!associar){
            EquipasColaborador equiC = new EquipasColaborador(equipa);
            colaborador.removerEquipa(equiC);
        }else{
            EquipasColaborador equipaColaborador = new EquipasColaborador(equipa);
            if(!colaborador.associarEquipa(equipaColaborador))
                return false;
        }
        colaboradorRepository.save(colaborador);
        return true;
    }
    
    
}
