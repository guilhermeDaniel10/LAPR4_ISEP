/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.base.servicomanagement.domain.Servico;
import eapli.framework.visitor.Visitor;

/**
 *
 * @author lucas
 */
public class ServicoPrinter implements Visitor<Servico> {

    @Override
    public void visit(final Servico visitee) {
        System.out.printf("ID Servico: %-10s Titulo Servico: %-30s", visitee.identificadorServico().toString(), visitee.name().toString());
    }

}
