/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.equipas;

import eapli.base.equipamanagement.domain.Equipa;
import eapli.framework.visitor.Visitor;

/**
 *
 * @author lucas
 */
public class EquipaPrinter implements Visitor<Equipa>{
    
    @Override
    public void visit(final Equipa visitee) {
        System.out.printf("Equipa: %-10s Designacao: %-30s", visitee.acronimoEquipa().toString(), visitee.designacaoEquipa().toString());
    }
    
}