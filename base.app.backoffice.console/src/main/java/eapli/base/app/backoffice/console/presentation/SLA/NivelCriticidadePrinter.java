/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.SLA;

import eapli.base.slamanagement.domain.NivelCriticidade;
import eapli.framework.visitor.Visitor;

/**
 *
 * @author lucas
 */
public class NivelCriticidadePrinter implements Visitor<NivelCriticidade> {
    
    @Override
    public void visit(final NivelCriticidade visitee) {
         System.out.printf("%s", visitee.toString());
    }
    
}
