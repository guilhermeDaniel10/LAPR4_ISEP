/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.base.servicomanagement.application.RegistarServicoController;
import eapli.base.servicomanagement.domain.Servico;
import eapli.framework.presentation.console.SelectWidget;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class ConcluirServicoUI {
      
    private final RegistarServicoController servicoController = new RegistarServicoController();
   
    protected boolean doShow() {

        final Iterable<Servico> servicosPorConcluir = this.servicoController.allServicosIndisponiveis();
        
        if (servicosPorConcluir.iterator().hasNext() == false) {
            System.out.println("Nao existem mais servicos por concluir!");
            return true;
        }
        
        final SelectWidget<Servico> selectorServico = new SelectWidget<>("Escolha que servico deseja finalizar:", servicosPorConcluir,
                new ServicoPrinter());
        selectorServico.show();
        
        Servico servicoPorConcluir = selectorServico.selectedElement();
        
        if (servicoPorConcluir == null) {
            return true;
        }
        
        Servico servicoConcluido = null;
        try {
            servicoConcluido = new DadosServicoSettings(servicoPorConcluir).concluirServico();
        } catch (IOException ex) {
            Logger.getLogger(ConcluirServicoUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        servicoController.registerServico(servicoConcluido);
        
        return true;
    }

    public String headline() {
        return "Concluir Servico";
    }
    
}
