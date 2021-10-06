/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.catalogos;

import eapli.base.slamanagement.domain.NivelCriticidade;
import eapli.base.app.backoffice.console.presentation.SLA.NivelCriticidadePrinter;
import eapli.base.app.backoffice.console.presentation.colaboradores.ColaboradorPrinter;
import eapli.base.catalogomanagemente.application.RegistarCatalogoController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import java.io.IOException;
import java.text.ParseException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
@SuppressWarnings("java:S106")
public class RegistarCatalogoUI extends AbstractUI {

    private final RegistarCatalogoController catalogoController = new RegistarCatalogoController();

    @Override
    protected boolean doShow() {
        
        final String strIdCatalogo = Console.readLine("Identificador Catalogo:");
        
        if (strIdCatalogo.isEmpty()) {
            System.out.println("Tem de introduzir um identificador de catalogo para o poder registar!");
            return false;
        }
        
        final Iterable<Colaborador> colaboradoresDisponiveis = this.catalogoController.allColaboradores();
        final SelectWidget<Colaborador> selectorColaborador = new SelectWidget<>("Colaboradores disponives para serem responsaveis de catalogo:", colaboradoresDisponiveis,
                new ColaboradorPrinter());
        selectorColaborador.show();
        final Colaborador responsavelCatalogo = selectorColaborador.selectedElement();
        
        final Iterable<Equipa> todasEquipas = catalogoController.allEquipas();
        final Set<Equipa> equipasComAcessoCatalogo = new EquipasEmCatalogoSettings(todasEquipas).setEquipasEmCatalogo();

        final Iterable<NivelCriticidade> SLADisponiveis = this.catalogoController.SLADisponiveis();
        final SelectWidget<NivelCriticidade> selectorNivelCriticidade = new SelectWidget<>("Niveis de criticidade disponives para serem escolhidos:", SLADisponiveis,
                new NivelCriticidadePrinter());
        selectorNivelCriticidade.show();
        final NivelCriticidade nivelCriticidadeCatalogo = selectorNivelCriticidade.selectedElement();
        
        final String strTituloCatalogo = Console.readLine("Titulo Catalogo:");
        final String strDescBreveCatalogo = Console.readLine("Descricao breve do Catalogo:");
        final String strDescCompletaCatalogo = Console.readLine("Descricao completa do Catalogo:");
        final String iconeName = Console.readLine("Nome do Icone:");
        final String extensaoIcone = Console.readLine("Extensao do Icone (png, eps, svg, jpeg):");
             
        String strEstado;
        boolean estadoCatalogo = false;
        if (!strTituloCatalogo.isEmpty() && !strDescBreveCatalogo.isEmpty() && !strDescCompletaCatalogo.isEmpty() && !iconeName.isEmpty() && !extensaoIcone.isEmpty() && !equipasComAcessoCatalogo.isEmpty() && responsavelCatalogo != null) {
            do {
                strEstado = Console.readLine("Catalogo esta pronto para estar ativo(y/n):");
            } while (strEstado.equalsIgnoreCase("y") && strEstado.equalsIgnoreCase("n"));
            
            if (strEstado.equalsIgnoreCase("y")) {
                estadoCatalogo = true;
            }
        } 

        try {
            
            if (this.catalogoController.registerCatalogo(strIdCatalogo, responsavelCatalogo, strTituloCatalogo, strDescBreveCatalogo, strDescCompletaCatalogo, iconeName, extensaoIcone,equipasComAcessoCatalogo, estadoCatalogo, nivelCriticidadeCatalogo) != null) {
                System.out.println("\nSucesso no Registo do Catalogo!\n");
            }
        } catch (@SuppressWarnings("unused") final IntegrityViolationException e) {
            System.out.println("You tried to enter a catalogo which already exists in the database.");
        } catch (ParseException ex) {
            Logger.getLogger(RegistarCatalogoUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException e){
            System.out.println("Campos inválidos!!!\nTem de introduzir um identificador de catalogo!\nPor favor volte a registar o catalogo!");
        }

        return false;
    }

    @Override
    public String headline() {
        return "Registar Catalogo";
    }

}
