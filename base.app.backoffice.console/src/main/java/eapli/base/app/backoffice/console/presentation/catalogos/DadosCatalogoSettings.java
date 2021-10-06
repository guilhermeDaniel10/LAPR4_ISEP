/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.catalogos;

import eapli.base.app.backoffice.console.presentation.SLA.NivelCriticidadePrinter;
import eapli.base.app.backoffice.console.presentation.colaboradores.ColaboradorPrinter;
import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagemente.application.RegistarCatalogoController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.slamanagement.domain.NivelCriticidade;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.SelectWidget;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author lucas
 */

public class DadosCatalogoSettings {
    
    private final RegistarCatalogoController catalogoController = new RegistarCatalogoController();
    private final Catalogo catalogoPorConcluir;
    private final List<String> list;
    private int option = -1;

    public  DadosCatalogoSettings(final Catalogo catalogoPorConcluir) throws IOException {
        this.catalogoPorConcluir = catalogoPorConcluir;
        list = makeList();
    }

    private List<String> makeList() throws IOException {
        final List<String> result = new ArrayList<>();
        if (catalogoPorConcluir.name().toString().equals("Por adicionar...")) {
            result.add("Adicionar titulo");
        }
        if (catalogoPorConcluir.descricaoBreve().toString().equals("Por adicionar...")) {
            result.add("Adiconar descricao breve");
        }
        if (catalogoPorConcluir.descricaoCompleta().toString().equals("Por adicionar...")) {
            result.add("Adicionar descricao detalhada");
        }
        if (catalogoPorConcluir.responsavel() == null) {
            result.add("Adicionar colaborador responsavel");
        }
        if (catalogoPorConcluir.equipa().isEmpty() == true) {
            result.add("Adicionar equipas com acesso");
        }
        if (!catalogoPorConcluir.icone().iconeValido()) {
           result.add("Adicionar icone");
        }
        if (catalogoPorConcluir.nivelCriticidadeCatalogo() == null) {
           result.add("Adicionar Nivel Criticidade");
        }
        if (catalogoPorConcluir.isActive() == false) {
            result.add("Ativar estado");
        } 
        return result;
    }

    private void showDadosEmFalta() {
        int cont = 0;
        System.out.println(" Escolha o dado que quer introduzir");
        System.out.println("0.  Sem mais dados em falta");
        for (final String dados : list) {
            cont++;
            System.out.println(cont + ".  " + dados);
        }
    }

    public Catalogo concluirCatalogo() throws IOException {
        while (option != 0 && list.size() > 0) { 
            showDadosEmFalta();
            option = Console.readOption(1, list.size(), 0);
            if (option != 0) {
                final String elem = list.get(option - 1);
                gestorDeOpcoes(elem);
            }
        }
        return this.catalogoPorConcluir;
    }
    
    public void gestorDeOpcoes(String opcao) throws IOException{
        switch(opcao) {
                
            case "Adiconar descricao breve":
                retificaoDescBreve();
            break;
            case "Adicionar titulo":
                retificaotitulo();
            break;
            case "Adicionar descricao detalhada":
                retificaoDescComp();
            break;
            case "Adicionar colaborador responsavel":
                retificaoResponsavel();
            break;
            case "Adicionar equipas com acesso":
                retificaoEquipasComAcesso();
            break;
            case "Adicionar icone":
                retificaoIcone();
            break;
            case "Adicionar Nivel Criticidade":
                retificaoNivelCriticidade();
            break;
            case "Ativar estado":
                retificaoEstado();
            break;
            
            default:
                  
        }
        
    }
    
    public void retificaoDescBreve(){
        String stringDescBreve = Console.readLine("Descricao Breve:");
        boolean retificacao = this.catalogoPorConcluir.descricaoBreve().correcaoDescCatalogo(stringDescBreve);
        if (retificacao == false) {
            System.out.println("\nDescricao inalterada!");
        } else {
            list.remove("Adiconar descricao breve");
        }
    }
    
    public void retificaoDescComp(){
        String stringDescDetalhada = Console.readLine("Descricao Completa:");
        boolean retificacao = this.catalogoPorConcluir.descricaoCompleta().correcaoDescCatalogo(stringDescDetalhada);
        if (retificacao == false) {
            System.out.println("\nDescricao inalterada!");
        } else {
            list.remove("Adicionar descricao detalhada");
        }
    }
    
    public void retificaotitulo(){
        String stringTitulo = Console.readLine("Titulo Catalogo:");
        boolean retificacao = this.catalogoPorConcluir.name().correcaoTituloCatalogo(stringTitulo);
        if (retificacao == false) {
            System.out.println("\nDescricao inalterada!");
        } else {
            list.remove("Adicionar titulo");
        }
    }
    
    public void retificaoResponsavel(){
        final Iterable<Colaborador> colaboradoresDisponiveis = this.catalogoController.allColaboradores();
        final SelectWidget<Colaborador> selectorColaborador = new SelectWidget<>("Colaboradores disponives para serem responsaveis de catalogo:", colaboradoresDisponiveis,
                new ColaboradorPrinter());
        selectorColaborador.show();
        final Colaborador responsavelCatalogo = selectorColaborador.selectedElement();
        boolean retificacao = this.catalogoPorConcluir.changeColaboradorResponsavel(responsavelCatalogo);
        if (retificacao == false) {
            System.out.println("\nColaborador inalterado!");
        } else {
            list.remove("Adicionar colaborador responsavel");
        }
    }
    
    public void retificaoEquipasComAcesso(){   
        final Iterable<Equipa> todasEquipas = catalogoController.allEquipas();
        final Set<Equipa> equipasComAcessoCatalogo = new EquipasEmCatalogoSettings(todasEquipas).setEquipasEmCatalogo();
        boolean retificacao = this.catalogoPorConcluir.copyEquipas(equipasComAcessoCatalogo);
        if (retificacao == false) {
            System.out.println("\nEquipas com acesso inalteradas!");
        } else {
            list.remove("Adicionar equipas com acesso");
        }
    }
    
    public void retificaoEstado(){
        boolean estadoCatalogo = this.catalogoPorConcluir.activateState();
        if (estadoCatalogo == false) {
            System.out.println("\nEstado inalterado!");
        } else {
            list.remove("Ativar estado");
        }     
    }

    private void retificaoIcone() throws IOException {
        final String iconeName = Console.readLine("Nome do Icone:");
        
        final String extensaoIcone = Console.readLine("Extensao do Icone (png, eps, svg, jpeg):");
        
        this.catalogoPorConcluir.icone().correcaoIcone(iconeName,extensaoIcone);
        
        if (this.catalogoPorConcluir.icone().iconeValido()) {
            System.out.println("\nImagem inalterada!");
            this.catalogoPorConcluir.icone().resetIconeEstado();
        } else {
            list.remove("Adicionar icone");
        }
    }

    private void retificaoNivelCriticidade() {
        final Iterable<NivelCriticidade> SLADisponiveis = this.catalogoController.SLADisponiveis();
        final SelectWidget<NivelCriticidade> selectorNivelCriticidade = new SelectWidget<>("Niveis de criticidade disponives para serem escolhidos:", SLADisponiveis,
                new NivelCriticidadePrinter());
        selectorNivelCriticidade.show();
        final NivelCriticidade nivelCriticidadeCatalogo = selectorNivelCriticidade.selectedElement();
        if (nivelCriticidadeCatalogo != null) {
            this.catalogoPorConcluir.adicionarNivelCriticidadeCatalogo(nivelCriticidadeCatalogo);
            list.remove("Adicionar Nivel Criticidade");
        } else {
            System.out.println("\nNivel criticidade inalterado!");
        }
    }
    
}
