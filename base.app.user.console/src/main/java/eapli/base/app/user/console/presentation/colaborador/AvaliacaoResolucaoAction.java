/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.user.console.presentation.colaborador;

import eapli.framework.actions.Action;

/**
 *
 * @author Guilherme
 */
public class AvaliacaoResolucaoAction implements Action  {

    @Override
    public boolean execute() {
        return new AvaliacaoResolucaoUI().show();
    }
    
}
