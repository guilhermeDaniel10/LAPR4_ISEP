/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.base.formulariomanagement.domain.Atributo;
import eapli.framework.visitor.Visitor;

/**
 *
 * @author Guilherme
 */
public class AtributoPrinter implements Visitor<Atributo>  {

    @Override
    public void visit(Atributo visitee) {
        System.out.printf("%s", visitee.nomeVariavel().toStringNome());
    }
    
}
