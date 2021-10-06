/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.user.console.presentation.colaborador;

import eapli.base.bibliotecaatividades.domain.ScriptAutomatico;
import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagemente.application.ListCatalogoController;
import eapli.base.formulariomanagement.dto.FormularioDTO;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedidomanagement.domain.Urgencia;
import eapli.base.respostaformularios.domain.AtributoEmResposta;
import eapli.base.respostaformularios.domain.RespostaFormulario;
import eapli.base.respostaformularios.repositories.RespostaFormularioRepository;
import eapli.base.servicomanagement.application.ListServicoController;
import eapli.base.servicomanagement.application.SolicitacaoServicoController;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.tarefamanagement.application.ConvertRespostaParaScriptController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public class SolicitarServicoUI extends AbstractUI {

    private ListServicoController lServicoController = new ListServicoController();
    private ListCatalogoController lCatalogoController = new ListCatalogoController();
    private SolicitacaoServicoController solicitarController = new SolicitacaoServicoController();
    private ConvertRespostaParaScriptController converterController = new ConvertRespostaParaScriptController();

    @Override
    protected boolean doShow() {

        final Iterable<Catalogo> catalogosColaborador = lCatalogoController.findCatalogoDeColaborador();

        if (catalogosColaborador == null) {
            System.out.println("O Colaborador nao tem catalogos disponiveis.\n");
            return false;
        }
        final SelectWidget<Catalogo> selector = new SelectWidget<>("Catalogos Disponiveis:", catalogosColaborador,
                new CatalogoPrinter());
        selector.show();

        if (selector.selectedOption() == 0) {
            return false;
        }

        final Catalogo selectedCatalogo = selector.selectedElement();

        final Iterable<Servico> servicosColaborador = lServicoController.allServicosFromCatalogo(selectedCatalogo);

        if (servicosColaborador == null) {
            System.out.println("O Catalogo nao tem servicos disponiveis.");
            return false;
        }

        final SelectWidget<Servico> selector2 = new SelectWidget<>("Servicos Disponiveis:", servicosColaborador,
                new ServicoPrinter());
        selector2.show();

        if (selector2.selectedOption() == 0) {
            return false;
        }

        final Servico selectedServico = selector2.selectedElement();

        solicitarController.addPedido(selectedServico);

        FormularioDTO formDTO = selectedServico.formularioSolicitacaoDTO();

        ProcessarPreencherFormularioUI processar = new ProcessarPreencherFormularioUI(formDTO);
        processar.doShow();

        RespostaFormulario respostaObtida = processar.respostaObtida();

        ScriptAutomatico script = null;
        try {
            script = selectedServico.workflowServico().atividadeRealizacaoWorkflow().atividade().scriptAutomatico();
           
        } catch (NullPointerException ex) {

        }

        List<Urgencia> urgencias = new ArrayList<>();
        urgencias.add(Urgencia.URGENTE);
        urgencias.add(Urgencia.MODERADA);
        urgencias.add(Urgencia.REDUZIDA);

        final SelectWidget<Urgencia> selector3 = new SelectWidget<>("Urgencia:", urgencias);
        selector3.show();

        final Urgencia urgencia = selector3.selectedElement();

        final Date dataLimite = Console.readDate("Data Limite (dd/MM/yyyy HH:mm:ss):", "dd/MM/yyyy HH:mm:ss");

        final String ficheiros = Console.readLine("Ficheiros:");

        try {
            solicitarController.addResposta(processar.respostaObtida());

            solicitarController.addFields(urgencia, dataLimite, ficheiros);

            solicitarController.registarSolicitacaoServico(respostaObtida, script);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return true;

    }

    @Override
    public String headline() {
        return "Solicitar Servico";
    }

}
