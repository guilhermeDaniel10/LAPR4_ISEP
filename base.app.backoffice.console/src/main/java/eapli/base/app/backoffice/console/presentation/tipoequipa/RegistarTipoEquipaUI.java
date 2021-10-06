/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.tipoequipa;

import eapli.base.cor.domain.Cor;
import eapli.base.tipoequipamanagement.application.RegistarTipoEquipaController;
import eapli.base.tipoequipamanagement.domain.DescricaoTipoEquipa;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

/**
 *
 * @author Guilherme
 */
@SuppressWarnings("java:S106")
public class RegistarTipoEquipaUI extends AbstractUI {

    private final RegistarTipoEquipaController tpEquipaController = new RegistarTipoEquipaController();

    @Override
    protected boolean doShow() {
        final String descricaTipoEquipa = Console.readLine("Descricao:");

        final Iterable<Cor> cores = this.tpEquipaController.allCores();
        final SelectWidget<Cor> selector = new SelectWidget<>("Cores:", cores,
                new CorPrinter());
        selector.show();

        final Cor corTipoEquipa = selector.selectedElement();

        try {
            tpEquipaController.registerTipoEquipa(descricaTipoEquipa, corTipoEquipa);
            return true;
        } catch (@SuppressWarnings("unused") final IntegrityViolationException e) {
            System.out.println("You tried to enter a tipo equipa which already exists in the database.");
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public String headline() {
        return "Registar Tipo de Equipa";
    }

}
