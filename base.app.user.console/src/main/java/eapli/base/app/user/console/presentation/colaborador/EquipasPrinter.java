/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.user.console.presentation.colaborador;

import eapli.base.equipamanagement.domain.Equipa;
import eapli.framework.visitor.Visitor;

/**
 *
 * @author Guilherme
 */
public class EquipasPrinter implements Visitor<Equipa>{
    public void visit(final Equipa visitee) {
        System.out.printf("%-10s %-30s", visitee.identity().toString(), visitee.acronimoEquipa());
    }
}
