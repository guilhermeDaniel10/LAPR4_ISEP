/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.base.app.backoffice.console.presentation.SLA.NivelCriticidadePrinter;
import eapli.base.app.backoffice.console.presentation.catalogos.CatalogoPrinter;
import eapli.base.app.backoffice.console.presentation.colaboradores.ColaboradorPrinter;
import eapli.base.app.backoffice.console.presentation.equipas.EquipaPrinter;
import eapli.base.app.backoffice.console.presentation.equipas.EquipaPrinterDTO;
import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipamanagement.DTO.EquipaDto;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.TiposFormulario;
import eapli.base.servicomanagement.application.RegistarServicoController;
import eapli.base.servicomanagement.domain.Keyword;
import eapli.base.slamanagement.domain.NivelCriticidade;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
@SuppressWarnings("java:S106")
public class RegistarServicoUI extends AbstractUI {

    private final RegistarServicoController servicoController = new RegistarServicoController();

    @Override
    protected boolean doShow() {
        //Introdução do ID serviço
        final String strIdServico = Console.readLine("Identificador Servico:");
        //Introdução do Titulo serviço
        final String strTituloServico = Console.readLine("Titulo Servico:");

        if (strIdServico.isEmpty() || strTituloServico.isEmpty()) {
            System.out.println("Servico necessita de identificador e titulo para ser registado!");
            return false;
        }
        //Introdução do Catalogo que contêm serviço
        final Iterable<Catalogo> catalogosDisponiveis = this.servicoController.allCatalogosConcluidos();
        final SelectWidget<Catalogo> selectorCatalogo = new SelectWidget<>("Catalogo que disponibiliza o servico:", catalogosDisponiveis, new CatalogoPrinter());
        selectorCatalogo.show();
        final Catalogo catalogoDisponiblizaServico = selectorCatalogo.selectedElement();

        boolean requerSatisfacao = false;
        //Introdução de um nível de criticidade costomizado
        String strNivelCriticidade;
        do {
            strNivelCriticidade = Console.readLine("Servico necessita de um nivel de criticidade distinto do Catalogo (y/n):");
        } while (!strNivelCriticidade.equalsIgnoreCase("y") && !strNivelCriticidade.equalsIgnoreCase("n"));

        NivelCriticidade nivelCriticidadeServico = null;
        if (strNivelCriticidade.equalsIgnoreCase("y")) {
            final Iterable<NivelCriticidade> SLADisponiveis = this.servicoController.SLADisponiveis();
            final SelectWidget<NivelCriticidade> selectorNivelCriticidade = new SelectWidget<>("Niveis de criticidade disponives para serem escolhidos:", SLADisponiveis,
                    new NivelCriticidadePrinter());
            selectorNivelCriticidade.show();
            nivelCriticidadeServico = selectorNivelCriticidade.selectedElement();
        }

        //Introdução da descricao breve de servico
        final String strDescBreveServico = Console.readLine("Descricao breve do Servico:");
        //Introdução da descricao completa de servico
        final String strDescCompletaServico = Console.readLine("Descricao completa do Servico:");
        //Introdução do nome de icone do servico
        final String iconeName = Console.readLine("Nome do Icone:");
        //Introdução da extensao do icone do servico
        final String extensaoIcone = Console.readLine("Extensao do Icone (png, eps, svg, jpeg):");
        //Introdução das keywords do servico
        final Set<Keyword> keywordsEmServico = new KeywordsEmServicoSettings().criarKeywordsEmServico();
        //Introdução do formulario de solicitacao do servico
        final String strNomeFormularioSolicitacao = Console.readLine("Introduza o nome do formulario de solicitacao de servico:");
        Set<Atributo> atributosFormularioSolicitacao = new HashSet<>();
        if (!strNomeFormularioSolicitacao.isEmpty()) {
            try {
                atributosFormularioSolicitacao = new AtributosEmFormularioSettings().criarAtributosEmFormulario(TiposFormulario.SOLICITACAO, null);
            } catch (ParseException ex) {
                Logger.getLogger(RegistarServicoUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        String strPreencherWorkflow;
        String strNomeFormularioAprovacao = null;
        Set<Atributo> atributosFormularioAprovacao = new HashSet<>();
        boolean responsavelHierarquicoIsAprovador = false;
        String strScriptResolucao = null;
        Colaborador colaboradorResponsavelPelaResolucao = null;
        Equipa equipaResponsavelPelaResolucao = null;
        //EquipaDto equipaResponsavelPelaResolucao = null;
        String strNomeFormularioResolucao = null;
        Set<Atributo> atributosFormularioResolucao = new HashSet<>();

        do {
            strPreencherWorkflow = Console.readLine("Deseja preencher e concluir o worflow do servico(y/n):");
        } while (!strPreencherWorkflow.equalsIgnoreCase("y") && !strPreencherWorkflow.equalsIgnoreCase("n"));

        if (strPreencherWorkflow.equalsIgnoreCase("y")) {

            //Introdução de necessidade de aprovacao de servico
            String strNecessidadeAprovacao;
            do {
                strNecessidadeAprovacao = Console.readLine("O Servico ira necessitar de uma atividade de aprovacao(y/n):");
            } while (!strNecessidadeAprovacao.equalsIgnoreCase("y") && !strNecessidadeAprovacao.equalsIgnoreCase("n"));

            if (strNecessidadeAprovacao.equalsIgnoreCase("y")) {

                strNomeFormularioAprovacao = Console.readLine("Introduza o nome do formulario de aprovacao:");
                try {
                    Set<Atributo> copySet = atributosFormularioSolicitacao;
                    atributosFormularioAprovacao = new AtributosEmFormularioSettings().criarAtributosEmFormulario(TiposFormulario.APROVACAO, copySet);
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

                boolean checker = false;
                do {
                    strScriptResolucao = Console.readLine("Conteudo do Script:");
                    checker = servicoController.validateScriptAutomatico(strScriptResolucao);
                } while (!checker);
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

                    /*Iterable<EquipaDto> equipas = this.servicoController.EquipasDisponiveisDto();
                    
                    final SelectWidget<EquipaDto> selectorDaEquipa = new SelectWidget<>("Equipa responsavel pela resolucao de servico:", equipas, new EquipaPrinterDTO());
                    selectorDaEquipa.show();        
                    equipaResponsavelPelaResolucao = selectorDaEquipa.selectedElement();*/
                    final SelectWidget<Equipa> selectorEquipa = new SelectWidget<>("Equipa responsavel pela resolucao de servico:", equipaDisponiveis, new EquipaPrinter());
                    selectorEquipa.show();
                    equipaResponsavelPelaResolucao = selectorEquipa.selectedElement();
                }

                String strNecessidadeFormularioAjuda;

                do {
                    strNecessidadeFormularioAjuda = Console.readLine("Quer introduzir um formulario de resolucao(y/n):");
                } while (!strNecessidadeFormularioAjuda.equalsIgnoreCase("y") && !strNecessidadeFormularioAjuda.equalsIgnoreCase("n"));

                if (strNecessidadeFormularioAjuda.equalsIgnoreCase("y")) {
                    strNomeFormularioResolucao = Console.readLine("Introduza o nome do formulario de resolucao:");
                    try {
                        atributosFormularioResolucao = new AtributosEmFormularioSettings().criarAtributosEmFormulario(TiposFormulario.REALIZACAO, null);
                    } catch (ParseException ex) {
                        Logger.getLogger(RegistarServicoUI.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    requerSatisfacao = Console.readBoolean("Requer Grau de Satisfacao (y/n):");
                }

            }
        }

        String strEstado;
        boolean estadoServico = false;
        if (!strDescBreveServico.isEmpty() && !strDescCompletaServico.isEmpty() && !iconeName.isEmpty() && !extensaoIcone.isEmpty() && !keywordsEmServico.isEmpty()
                && catalogoDisponiblizaServico != null) {
            do {
                strEstado = Console.readLine("Servico esta pronto para estar ativo(y/n):");
            } while (!strEstado.equalsIgnoreCase("y") && !strEstado.equalsIgnoreCase("n"));

            if (strEstado.equalsIgnoreCase("y")) {
                estadoServico = true;
            }
        }

        try {
            if (this.servicoController.registerServico(strIdServico, strTituloServico, catalogoDisponiblizaServico, strDescBreveServico, strDescCompletaServico,
                    iconeName, extensaoIcone, keywordsEmServico, estadoServico, nivelCriticidadeServico, colaboradorResponsavelPelaResolucao,
                    equipaResponsavelPelaResolucao, strNomeFormularioResolucao, atributosFormularioResolucao, strScriptResolucao, strNomeFormularioAprovacao,
                    atributosFormularioAprovacao, responsavelHierarquicoIsAprovador, strNomeFormularioSolicitacao, atributosFormularioSolicitacao, requerSatisfacao) != null) {
                System.out.println("\nSucesso no Registo do Servico!\n");
            }

        } catch (@SuppressWarnings("unused") final IntegrityViolationException e) {
            System.out.println("Tentou introduzir um servico já existente no sistema!");
        } catch (IllegalArgumentException e) {
            System.out.println("Campos inválidos!!!\nTem de introduzir um identificador e um titulo para registar um servico!\nPor favor volte a registar o servico!\n");
        }

        return false;
    }

    @Override
    public String headline() {
        return "Registar Servico";
    }

}
