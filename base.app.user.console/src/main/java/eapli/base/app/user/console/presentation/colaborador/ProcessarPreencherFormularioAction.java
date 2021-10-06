/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.user.console.presentation.colaborador;

import eapli.base.formulariomanagement.dto.FormularioDTO;
import eapli.framework.actions.Action;

/**
 *
 * @author Guilherme
 */
public class ProcessarPreencherFormularioAction implements Action {

    private FormularioDTO form;
    
    public ProcessarPreencherFormularioAction(FormularioDTO form){
        this.form = form;
    }
    
    @Override
    public boolean execute() {
        return new ProcessarPreencherFormularioUI(form).show();
    }
    
}
