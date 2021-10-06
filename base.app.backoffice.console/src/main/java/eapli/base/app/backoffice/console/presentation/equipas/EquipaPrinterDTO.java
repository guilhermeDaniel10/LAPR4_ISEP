/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.equipas;

import eapli.base.equipamanagement.DTO.EquipaDto;
import eapli.framework.visitor.Visitor;

/**
 *
 * @author lucas
 */
public class EquipaPrinterDTO implements Visitor<EquipaDto> {

    @Override
    public void visit(EquipaDto visitee) {
        System.out.printf("Equipa: %-10s Designacao: %-30s", visitee.acrEquipa, visitee.designacaoEquipa);
    }
    
}
