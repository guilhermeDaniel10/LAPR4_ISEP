/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.colaboradores;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.framework.visitor.Visitor;

/**
 *
 * @author Guilherme
 */
public class ColaboradorPrinter implements Visitor<Colaborador>{
    
    @Override
    public void visit(final Colaborador visitee) {
        System.out.printf("Numero Mecanografico: %-10s Nome Colaborador: %-30s", visitee.numeroMecanografico().toString(), visitee.nomeCompleto());
    }
    
}
