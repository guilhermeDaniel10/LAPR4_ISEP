/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.catalogos;

import eapli.framework.actions.Action;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class ConcluirCatalogoAction implements Action {
    
    @Override
    public boolean execute() {
        try {
            return new ConcluirCatalogoUI().doShow();
        } catch (IOException ex) {
            return false;
        }
    }
    
}
