/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.colaboradores;

import eapli.base.colaboradormanagement.application.RegistarColaboradorController;
import eapli.base.colaboradormanagement.application.RegistarFuncaoController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Contacto;
import eapli.base.colaboradormanagement.domain.DataNascimento;
import eapli.base.colaboradormanagement.domain.EmailInstitucional;
import eapli.base.colaboradormanagement.domain.Funcao;
import eapli.base.colaboradormanagement.domain.LocalResidencia;
import eapli.base.colaboradormanagement.domain.NomeCompleto;
import eapli.base.colaboradormanagement.domain.NomeCurto;
import eapli.base.colaboradormanagement.domain.NumeroMecanografico;
import eapli.base.usermanagement.application.AddUserController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guilherme
 */
@SuppressWarnings("java:S106")
public class RegistarColaboradorUI extends AbstractUI {

    private final RegistarColaboradorController colaboradorController = new RegistarColaboradorController();
    final AddUserController userController = new AddUserController();

    @Override
    protected boolean doShow() {

        final String nmrMecanografico = Console.readLine("Numero Mecanografico:");

        final Iterable<Funcao> funcoes = this.colaboradorController.availableFuncoes();
        final SelectWidget<Funcao> selector = new SelectWidget<>("Funcoes:", funcoes,
                new FuncaoPrinter());
        selector.show();

        final Funcao funcao = selector.selectedElement();

        final String primeiroNome = Console.readLine("Primeiro Nome:");

        final String ultimoNome = Console.readLine("Ultimo Nome:");

        final String nomeCompleto = Console.readLine("Nome Completo:");

        final Date dataNascimento = Console.readDate("Data de Nascimento (dd/MM/yyyy):", "dd/MM/yyyy");

        final String distrito = Console.readLine("Concelho:");

        final String concelho = Console.readLine("Distrito:");

        final String email = Console.readLine("Email:");

        final String indicativo = Console.readLine("Indicativo:");

        final String contacto = Console.readLine("Numero:");
        
        final Iterable<Colaborador> colaboradores = this.colaboradorController.allColaboradores();
        final SelectWidget<Colaborador> selector2 = new SelectWidget<>("Colaboradores:", colaboradores,
                new ColaboradorPrinter());
        selector2.show();
        
        final Colaborador responsavel = selector2.selectedElement();
        

        try {
            
            if (this.colaboradorController.registerColaborador(nmrMecanografico, funcao, 
                    primeiroNome, ultimoNome, nomeCompleto, dataNascimento,
                    distrito, concelho, email, indicativo, contacto, responsavel) != null) {
                
            }
        } catch (@SuppressWarnings("unused") final IntegrityViolationException e) {
            System.out.println("You tried to enter a colaborator which already exists in the database.");
        } catch (ParseException ex) {
            Logger.getLogger(RegistarColaboradorUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        return false;
    }

    @Override
    public String headline() {
        return "Registar Colaborador";
    }

}
