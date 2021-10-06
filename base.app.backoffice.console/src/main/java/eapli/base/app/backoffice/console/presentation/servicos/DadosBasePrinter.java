/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.base.formulariomanagement.domain.DadosBase;
import eapli.framework.visitor.Visitor;

/**
 *
 * @author Guilherme
 */
public class DadosBasePrinter implements Visitor<DadosBase> {

    @Override
    public void visit(DadosBase visitee) {
        System.out.printf("Dado Base: %-10s", visitee.name());
    }
    
}
