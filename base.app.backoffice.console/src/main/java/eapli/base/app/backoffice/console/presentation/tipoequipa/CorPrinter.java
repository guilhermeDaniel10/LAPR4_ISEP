/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.tipoequipa;

import eapli.base.cor.domain.Cor;
import eapli.framework.visitor.Visitor;

/**
 *
 * @author Guilherme
 */
public class CorPrinter implements Visitor<Cor>{

    @Override
    public void visit(Cor visitee) {
        System.out.printf("%-10s", visitee.identity());
    }
    
}
