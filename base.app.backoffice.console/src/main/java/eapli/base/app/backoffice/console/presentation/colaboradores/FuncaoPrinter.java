/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.colaboradores;

import eapli.base.colaboradormanagement.domain.Funcao;
import eapli.framework.visitor.Visitor;

/**
 *
 * @author Guilherme
 */
public class FuncaoPrinter implements Visitor<Funcao> {

    @Override
    public void visit(final Funcao visitee) {
        System.out.printf("%-10s %-30s", visitee.identity(), visitee.designacaoFuncao());
    }

}
