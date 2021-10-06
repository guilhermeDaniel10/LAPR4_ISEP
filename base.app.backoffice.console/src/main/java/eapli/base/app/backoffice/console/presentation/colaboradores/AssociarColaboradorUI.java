/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.colaboradores;

import eapli.base.colaboradormanagement.application.AssociarColaboradorController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

/**
 *
 * @author rui3m
 */
public class AssociarColaboradorUI extends AbstractUI {

    private final AssociarColaboradorController controller = new AssociarColaboradorController();
    private boolean associar;
    @Override
    protected boolean doShow() {
        
        final Iterable<Colaborador> colaboradores = this.controller.create(associar);
        final SelectWidget<Colaborador> selectorColaborador = new SelectWidget<>("Colaboradores:", colaboradores,new ColaboradorPrinter());
        selectorColaborador.show();

        final Colaborador colaborador = selectorColaborador.selectedElement();

    
        final Iterable<Equipa> equipas = this.controller.setColaborador(colaborador);
        if(equipas == null){
            if(!associar){
                System.out.println("O colaborador selecionado nao pertence a nenhuma equipa.");
            }else{
                System.out.println("Nao existem equipas compativeis. (Um colaborador nao pode pertencer a duas equipas do mesmo tipo.)");
            }
            return false;
        }
        final SelectWidget<Equipa> selectorEquipa = new SelectWidget<>("Equipa:", equipas);
        selectorEquipa.show();
        
        final Equipa equipa = selectorEquipa.selectedElement();
        
        
  
        return controller.setEquipa(equipa);
    }

    @Override
    public String headline() {
        return "Associar/remover colaborador a uma equipa";
    }

    boolean associar() {
        associar = true;
        return doShow();
    }

    boolean remover() {
        associar = false;
        return doShow();
    }
}