/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.base.app.backoffice.console.presentation.catalogos.*;
import eapli.base.app.backoffice.console.presentation.colaboradores.ColaboradorPrinter;
import eapli.base.app.backoffice.console.presentation.equipas.EquipaPrinter;
import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.formulariomanagement.application.CreateFormularioController;
import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.domain.TiposFormulario;
import eapli.base.servicomanagement.application.CreateWorkflowController;
import eapli.base.servicomanagement.application.RegistarServicoController;
import eapli.base.servicomanagement.domain.Keyword;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.SelectWidget;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author lucas
 */

public class DadosServicoSettings {
    
    private final RegistarServicoController servicoController = new RegistarServicoController();
    private final Servico servicoPorConcluir;
    private final List<String> list;
    private int option = -1;
    private final CreateFormularioController formularioInServico = new CreateFormularioController();   
    private final CreateWorkflowController workflowInServico = new CreateWorkflowController();

    public  DadosServicoSettings(final Servico servicoPorConcluir) throws IOException {
        this.servicoPorConcluir = servicoPorConcluir;
        list = makeList();
    }

    private List<String> makeList() throws IOException {
        final List<String> result = new ArrayList<>();
        if (servicoPorConcluir.descricaoBreve().toString().equals("Por adicionar...")) {
            result.add("Adiconar descricao breve");
        }
        if (servicoPorConcluir.descricaoCompleta().toString().equals("Por adicionar...")) {
            result.add("Adicionar descricao detalhada");
        }
        if (servicoPorConcluir.keyword().isEmpty()) {
            result.add("Adicionar keywords");
        }
        if (servicoPorConcluir.catalogoQueDisponiblizaServico() == null) {
            result.add("Adicionar catalogo que disponibliza o servico");
        }
        if (!servicoPorConcluir.iconeServico().iconeValido()) {
           result.add("Adicionar icone");
        }
        if (servicoPorConcluir.formularioDeSolicitacaoDeServico() == null) {
            result.add("Adicionar formulario");
        } 
        if (servicoPorConcluir.workflowServico() == null) {
            result.add("Adicionar fluxo de atividade");
        }
        if (servicoPorConcluir.isActive() == false) {
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

    public Servico concluirServico() throws IOException {
        while (option != 0 && list.size() > 0) { 
            showDadosEmFalta();
            option = Console.readOption(1, list.size(), 0);
            if (option != 0) {
                final String elem = list.get(option - 1);
                gestorDeOpcoes(elem);
            }
        }
        return this.servicoPorConcluir;
    }
    
    public void gestorDeOpcoes(String opcao) throws IOException{
        switch(opcao) {
   
            case "Adiconar descricao breve":
                retificaoDescBreve();
            break;
            case "Adicionar descricao detalhada":
                retificaoDescComp();
            break;
            case "Adicionar catalogo que disponibliza o servico":
                retificaoCatalogo();
            break;
            case "Adicionar keywords":
                retificaoKeywords();
            break;
            case "Adicionar icone":
                retificaoIcone();           
            break;
            case "Ativar estado":
                retificaoEstado();
            break;
            case "Adicionar formulario":
                retificaoFormulario();
            break;
            case "Adicionar fluxo de atividade":
                retificaoWorkflow();
            break;
            default:
                  
        }
        
    }
    
    public void retificaoDescBreve(){
        String stringDescBreve = Console.readLine("Descricao Breve:");
        boolean retificacao = this.servicoPorConcluir.descricaoBreve().correcaoDescBreveServico(stringDescBreve);
        if (retificacao == false) {
            System.out.println("\nDescricao inalterada!");
        } else {
            list.remove("Adiconar descricao breve");
        }
    }
    
    public void retificaoDescComp(){
        String stringDescDetalhada = Console.readLine("Descricao Completa:");
        boolean retificacao = this.servicoPorConcluir.descricaoCompleta().correcaoDescCompServico(stringDescDetalhada);
        if (retificacao == false) {
            System.out.println("\nDescricao inalterada!");
        } else {
            list.remove("Adicionar descricao detalhada");
        }
    }
    
    public void retificaoCatalogo(){
        final Iterable<Catalogo> catalogosDisponiveis = this.servicoController.allCatalogosConcluidos();
        final SelectWidget<Catalogo> selectorCatalogo = new SelectWidget<>("Catalogos disponives disponibilizarem servico:", catalogosDisponiveis,
                new CatalogoPrinter());
        selectorCatalogo.show();
        final Catalogo catalogoDisponiblizaServico = selectorCatalogo.selectedElement();
        boolean retificacao = this.servicoPorConcluir.changeCatalogo(catalogoDisponiblizaServico);
        if (retificacao == false) {
            System.out.println("\nCatalogo inalterado!");
        } else {
            list.remove("Adicionar catalogo que disponibliza o servico");
        }
    }
    
    public void retificaoKeywords(){   
        final Set<Keyword> keywordsEmServico = new KeywordsEmServicoSettings().criarKeywordsEmServico();
        if (keywordsEmServico.isEmpty()) {
            System.out.println("\nEquipas com acesso inalteradas!");
        } else {
            this.servicoPorConcluir.copyKeywords(keywordsEmServico);
            list.remove("Adicionar keywords");
        }
    }
    
    public void retificaoEstado(){
        boolean estadoCatalogo = this.servicoPorConcluir.activateState();
        if (estadoCatalogo == false) {
            System.out.println("\nEstado inalterado!");
        } else {
            list.remove("Ativar estado");
        }     
    }

    private void retificaoIcone() throws IOException {
        final String iconeName = Console.readLine("Nome do Icone:");
        
        final String extensaoIcone = Console.readLine("Extensao do Icone (png, eps, svg, jpeg):");
        
        this.servicoPorConcluir.iconeServico().correcaoIcone(iconeName,extensaoIcone);
        
        if (this.servicoPorConcluir.iconeServico().iconeValido()) {
            System.out.println("\nImagem inalterada!");
            this.servicoPorConcluir.iconeServico().resetIconeEstado();
        } else {
            list.remove("Adicionar icone");
        }
    }

    private void retificaoFormulario() {
        final String strNomeFormulario = Console.readLine("Introduza o nome do formulario:");
        Set<Atributo> atributosFormulario = new HashSet<>();
        boolean status = true;
        if (!strNomeFormulario.isEmpty()) {
            try {
                //ALTERAR AQUI O TIPO DE FORMULARIO
                atributosFormulario = new AtributosEmFormularioSettings().criarAtributosEmFormulario(TiposFormulario.SOLICITACAO, null);
            } catch (ParseException ex) {
                status = false;
                Logger.getLogger(RegistarServicoUI.class.getName()).log(Level.SEVERE, null, ex);
            }     
        }
        
        Formulario formularioServico = null;
        try {
            formularioServico = formularioInServico.createFormulario(strNomeFormulario, atributosFormulario);
        } catch (IllegalArgumentException e) {
            status = false;
        } catch (ParseException ex) {
            status = false;
            Logger.getLogger(DadosServicoSettings.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (status == false) {
            System.out.println("\nFormulario inalterado!");
        } else {
            this.servicoPorConcluir.adicionarFormularioDeSolicitacaoServico(formularioServico);
            list.remove("Adicionar formulario");
        }
    }

    private void retificaoWorkflow() {
        String strNomeFormularioAprovacao = null;
        Set<Atributo> atributosFormularioAprovacao = new HashSet<>();
        boolean responsavelHierarquicoIsAprovador = false;
        String strScriptResolucao = null;
        Colaborador colaboradorResponsavelPelaResolucao = null;
        Equipa equipaResponsavelPelaResolucao = null;
        String strNomeFormularioResolucao = null;
        Set<Atributo> atributosFormularioResolucao = new HashSet<>();
        
        //Introdução de necessidade de aprovacao de servico
        String strNecessidadeAprovacao;
        do {
            strNecessidadeAprovacao = Console.readLine("O Servico ira necessitar de uma atividade de aprovacao(y/n):");          
        } while (!strNecessidadeAprovacao.equalsIgnoreCase("y") && !strNecessidadeAprovacao.equalsIgnoreCase("n"));

        if (strNecessidadeAprovacao.equalsIgnoreCase("y")) {

            strNomeFormularioAprovacao = Console.readLine("Introduza o nome do formulario de aprovacao:");
            try {
                atributosFormularioAprovacao = new AtributosEmFormularioSettings().criarAtributosEmFormulario(TiposFormulario.APROVACAO, null);
            } catch (ParseException ex) {
                Logger.getLogger(RegistarServicoUI.class.getName()).log(Level.SEVERE, null, ex);
            }

            String responsavelHierarquicoAprovador;
            do {
                responsavelHierarquicoAprovador = Console.readLine("Sera o responsavel hierarquico de quem solicita o servico que ira fazer a aprovacao(y/n):");
            } while (!responsavelHierarquicoAprovador.equalsIgnoreCase("y") && !responsavelHierarquicoAprovador.equalsIgnoreCase("n"));
            if (responsavelHierarquicoAprovador.equalsIgnoreCase("y")) {
                responsavelHierarquicoIsAprovador = true;
            }
        }

        //Introdução de necessidade de resolucao de servico
        String strResolucaoAutomatica;
        do {
            strResolucaoAutomatica = Console.readLine("O Servico ira ser resolvido automaticamente(y/n):");          
        } while (!strResolucaoAutomatica.equalsIgnoreCase("y") && !strResolucaoAutomatica.equalsIgnoreCase("n"));

        String strColaboradorResponsavelPelaResolucao;
        if (strResolucaoAutomatica.equalsIgnoreCase("y")) {
            strScriptResolucao = Console.readLine("Script de Resolucao:");
        } else {
            do {
            strColaboradorResponsavelPelaResolucao = Console.readLine("Quer escolher um colaborador responsavel pela resolucao deste tipo de servicos(y/n):");          
            } while (!strColaboradorResponsavelPelaResolucao.equalsIgnoreCase("y") && !strColaboradorResponsavelPelaResolucao.equalsIgnoreCase("n"));

            if (strColaboradorResponsavelPelaResolucao.equalsIgnoreCase("y")) {
                final Iterable<Colaborador> colaboradoresDisponiveis = this.servicoController.ColaboradoresDisponiveis();
                final SelectWidget<Colaborador> selectorColaborador = new SelectWidget<>("Colaborador responsavel pela resolucao de servico:", colaboradoresDisponiveis, new ColaboradorPrinter());
                selectorColaborador.show();        
                colaboradorResponsavelPelaResolucao = selectorColaborador.selectedElement();
            } else {
                final Iterable<Equipa> equipaDisponiveis = this.servicoController.EquipasDisponiveis();
                final SelectWidget<Equipa> selectorEquipa = new SelectWidget<>("Equipa responsavel pela resolucao de servico:", equipaDisponiveis, new EquipaPrinter());
                selectorEquipa.show();        
                equipaResponsavelPelaResolucao = selectorEquipa.selectedElement();
            }

            String strNecessidadeFormularioAjuda;
            do {
                strNecessidadeFormularioAjuda = Console.readLine("Quer introduzir um formulario de ajuda(y/n):");          
            } while (!strNecessidadeFormularioAjuda.equalsIgnoreCase("y") && !strNecessidadeFormularioAjuda.equalsIgnoreCase("n"));

            if (strNecessidadeFormularioAjuda.equalsIgnoreCase("y")) {
                strNomeFormularioResolucao = Console.readLine("Introduza o nome do formulario de ajuda na resolucao:");
                try {
                    atributosFormularioResolucao = new AtributosEmFormularioSettings().criarAtributosEmFormulario(TiposFormulario.REALIZACAO, null);
                } catch (ParseException ex) {
                    Logger.getLogger(RegistarServicoUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        Workflow workflowServico = this.workflowInServico.createWorkflow(servicoPorConcluir, colaboradorResponsavelPelaResolucao, equipaResponsavelPelaResolucao, strNomeFormularioResolucao, atributosFormularioResolucao, strScriptResolucao, strNomeFormularioAprovacao, atributosFormularioAprovacao, responsavelHierarquicoIsAprovador);
        if (workflowServico != null) {
            this.servicoPorConcluir.adicionarWorkflow(workflowServico);
            list.remove("Adicionar fluxo de atividade");
        } else {
            System.out.println("\nFluxo de atividade!");
        }
    }
    
}
