/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.catalogos;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagemente.application.AtribuirNivelCriticidadeController;
import eapli.base.slamanagement.domain.NivelCriticidade;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

/**
 *
 * @author rui3m
 */
@SuppressWarnings("java:S106")
public class AtribuirNivelCriticidadeUI extends AbstractUI{
    private final AtribuirNivelCriticidadeController controller = new AtribuirNivelCriticidadeController();
    
    @Override
    protected boolean doShow() {
        final Iterable<Catalogo> catalogos = controller.allCatalogos();
        if(catalogos == null){
            System.out.println("Não existem catalogos no sistema. Não é possivel atribuir um nivel de criticidade.");
            return false;
        }
        
        final Iterable<NivelCriticidade> niveisCriticidade = controller.allNiveisCriticidade();
        if(niveisCriticidade == null){
            System.out.println("Não existem niveis de criticidade no sistema. Não é possivel atribuir um nivel de criticidade.");
            return false;
        }
        
        final SelectWidget<Catalogo> selectorCatalogos = new SelectWidget<>("Catalogos:", catalogos);
        selectorCatalogos.show();
        
        
        final SelectWidget<NivelCriticidade> selectorNivelCriticidade = new SelectWidget<>("Niveis Criticidade:", niveisCriticidade);
        selectorNivelCriticidade.show();
        
        final boolean confirm = Console.readBoolean("Pretende definir objetivos costumizados para este catalogo? (y/n)");
            if(confirm){
                boolean done = false;
                while(!done){
                    try {
                           final int tempoMedioAprovacao = Console.readInteger("Tempo Medio Aprovacao:");
                           final int tempoMaxAprovacao = Console.readInteger("Tempo Maximo Aprovacao:");
                           final int tempoMedioResolucao = Console.readInteger("Tempo Medio Resolucao:");
                           final int tempoMaxResolucao = Console.readInteger("Tempo Maximo Resolucao:");
                           this.controller.createObjetivos(tempoMedioAprovacao, tempoMaxAprovacao, tempoMedioResolucao, tempoMaxResolucao);
                           done = true;
                       } catch(IllegalArgumentException e){
                           System.out.println(e.getMessage());
                       }
                }
            }
            
            return this.controller.save(selectorCatalogos.selectedElement(),selectorNivelCriticidade.selectedElement());
            
    }

    @Override
    public String headline() {
        return "Atribuir Nivel de Criticidade.";
    }
}
