/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.equipas;

import eapli.base.app.backoffice.console.presentation.catalogos.EquipasEmCatalogoSettings;
import eapli.base.app.backoffice.console.presentation.tipoequipa.TipoEquipaPrinter;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipamanagement.application.CriarEquipaController;
import eapli.base.tipoequipamanagement.domain.TipoEquipa;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import java.text.ParseException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guilherme
 */
public class CriarEquipaUI extends AbstractUI{

    private CriarEquipaController equipaController = new CriarEquipaController();
    @Override
    protected boolean doShow() {
        
        final String acronimoEquipa = Console.readLine("Acronimo da Equipa:");
        
        final Iterable<TipoEquipa> tipoEquipas = this.equipaController.allTiposEquipa();
        final SelectWidget<TipoEquipa> selectorTpEquipa = new SelectWidget<>("Tipos de equipas disponiveis: ", tipoEquipas,
                new TipoEquipaPrinter());
        selectorTpEquipa.show();
        TipoEquipa tpEquipa = selectorTpEquipa.selectedElement();
        
        final String designacaoEquipa = Console.readLine("Designação da Equipa:");
        
        final Iterable<Colaborador> todosColab = equipaController.allColaboradores();
        final Set<Colaborador> responsaveis = new ResponsaveisEquipaSettings(todosColab).setColaboradoresEmCatalogo();

        try {
            
            if (equipaController.registerEquipa(acronimoEquipa, designacaoEquipa, tpEquipa, responsaveis) != null) {
                System.out.println("\nSucesso no Registo das Equipas!\n");
                return true;
            }
        } catch (@SuppressWarnings("unused") final IntegrityViolationException e) {
            System.out.println("You tried to enter a equipa which already exists in the database.");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
       return false;
    }

    @Override
    public String headline() {
        return "Criar Equipa";
    }
    
}
