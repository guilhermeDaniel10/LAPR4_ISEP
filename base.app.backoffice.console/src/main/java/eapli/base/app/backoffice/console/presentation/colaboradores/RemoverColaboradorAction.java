/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.colaboradores;

import eapli.framework.actions.Action;

/**
 *
 * @author rui3m
 */
public class RemoverColaboradorAction implements Action{

    @Override
    public boolean execute() {
        return new AssociarColaboradorUI().remover();
    }

}
