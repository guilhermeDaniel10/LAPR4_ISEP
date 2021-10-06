/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.SLA;

import eapli.base.slamanagement.application.DefinirNivelCriticidadeController;
import eapli.base.cor.domain.Cor;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

/**
 *
 * @author rui3m
 */
public class DefinirNivelCriticidadeUI extends AbstractUI{
    private final DefinirNivelCriticidadeController controller = new DefinirNivelCriticidadeController();
    
    @Override
    protected boolean doShow() {
        final Iterable<Cor> cores = controller.create();
        if(cores == null){
            System.out.println("Não existem cores no sistema. Nao e possivel definir um nivel de criticidade.");
            return false;
        }
        final SelectWidget<Cor> selector = new SelectWidget<>("Cores:", cores);
        selector.show();
        
        final int tempoMedioAprovacao = Console.readInteger("Tempo Medio Aprovacao:");
        final int tempoMaxAprovacao = Console.readInteger("Tempo Maximo Aprovacao:");
        final int tempoMedioResolucao = Console.readInteger("Tempo Medio Resolucao:");
        final int tempoMaxResolucao = Console.readInteger("Tempo Maximo Resolucao:");

         try {
            this.controller.createObjetivos(tempoMedioAprovacao, tempoMaxAprovacao, tempoMedioResolucao, tempoMaxResolucao);            
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        
         
        final Cor cor = selector.selectedElement();
        final String etiqueta = Console.readLine("Etiqueta:");
        final String designacao = Console.readLine("Designacao:");
        final int valor = Console.readInteger("Valor:");
  
        try {
            String info = controller.createNivelCriticidade(etiqueta,designacao,valor,cor);
            System.out.println(info);
            final boolean confirm = Console.readBoolean("Confirma? (y/n)");
            if(confirm)
                controller.save();
            
            return true;
        } catch (@SuppressWarnings("unused") final IntegrityViolationException e) {
            System.out.println("O nivel de criticidade ja existe na base de dados.");
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        
        
        return false;
    }

    @Override
    public String headline() {
        return "Definir nivel criticidade";
    }
}
