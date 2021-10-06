/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.user.console.presentation.colaborador;

import eapli.base.servicomanagement.domain.Servico;
import eapli.framework.visitor.Visitor;

/**
 *
 * @author Guilherme
 */
public class ServicoPrinter implements Visitor<Servico> {

    @Override
    public void visit(Servico visitee) {
        System.out.printf("%-10s %-30s", visitee.identificadorServico().toString(), visitee.name().toString());
    }
    
}
