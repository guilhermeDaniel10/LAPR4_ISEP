/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.servicomanagement.application;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagemente.application.ListCatalogoController;
import eapli.base.colaboradormanagement.application.ListColaboradorController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipamanagement.DTO.EquipaDto;
import eapli.base.equipamanagement.application.ListEquipaController;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.formulariomanagement.application.CreateFormularioController;
import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.domain.NomeFormulario;
import eapli.base.formulariomanagement.dto.FormularioDTO;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.scriptmanagement.application.RegistarScriptController;
import eapli.base.scriptmanagement.domain.Script;
import eapli.base.servicomanagement.domain.AtividadeAprovacao;
import eapli.base.servicomanagement.domain.AtividadeRealizacao;
import eapli.base.servicomanagement.domain.DescBreveServico;
import eapli.base.servicomanagement.domain.DescCompServico;
import eapli.base.servicomanagement.domain.IconeServico;
import eapli.base.servicomanagement.domain.IdentificadorServico;
import eapli.base.servicomanagement.domain.Keyword;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.domain.TituloServico;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.servicomanagement.repositories.AtividadeAprovacaoRepository;
import eapli.base.servicomanagement.repositories.AtividadeRealizacaoRepository;
import eapli.base.servicomanagement.repositories.KeywordRepository;
import eapli.base.servicomanagement.repositories.ServicoRepository;
import eapli.base.servicomanagement.repositories.WorkflowRepository;
import eapli.base.slamanagement.application.ListSLAController;
import eapli.base.slamanagement.domain.NivelCriticidade;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.validascripttarefas.ValidarScriptsTarefas;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import java.io.IOException;
import java.text.ParseException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lucas
 */
@Component
@UseCaseController
public class RegistarServicoController {

    @Autowired
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    @Autowired
    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servico();
    @Autowired
    private final KeywordRepository keywordRepository = PersistenceContext.repositories().keyword();
    @Autowired
    private final ListCatalogoController lCAS = new ListCatalogoController();
    @Autowired
    private final ListServicoController lSS = new ListServicoController();
    @Autowired
    private final CreateFormularioController formularioInServico = new CreateFormularioController();
    @Autowired
    private final ListSLAController lSLA = new ListSLAController();
    @Autowired
    private final ListColaboradorController lCC = new ListColaboradorController();
    @Autowired
    private final ListEquipaController lEC = new ListEquipaController();
    @Autowired
    private final WorkflowRepository workRepo = PersistenceContext.repositories().workflow();
    @Autowired
    private final AtividadeRealizacaoRepository realizacaoRepo = PersistenceContext.repositories().atividadeRealizacao();
    @Autowired
    private final AtividadeAprovacaoRepository aprovaRepo = PersistenceContext.repositories().atividadeAprovacao();
    @Autowired
    private final CreateWorkflowController workflowInServico = new CreateWorkflowController();
    @Autowired
    private final RegistarScriptController scriptController = new RegistarScriptController();

    private ValidarScriptsTarefas validar = new ValidarScriptsTarefas();

    @Transactional
    public Servico registerServico(String strIdServico, String strTituloServico, Catalogo catalogoDisponiblizaServico,
            String strDescBreveServico, String strDescCompletaServico, String iconeName, String extensaoIcone,
            final Set<Keyword> keywordsEmServico, boolean estadoServico, NivelCriticidade nivelCriticidadeServico,
            Colaborador colaboradorResponsavelPelaResolucao, Equipa equipaResponsavelPelaResolucao, String strNomeFormularioResolucao,
            Set<Atributo> atributosFormularioResolucao, String strScriptResolucao, String strNomeFormularioAprovacao,
            Set<Atributo> atributosFormularioAprovacao, boolean responsavelHierarquicoIsAprovador, String strNomeFormularioSolicitacao, Set<Atributo> atributosFormularioSolicitacao,
            boolean satisfacao) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.GESTOR_SERVICO_HELP_DESK, BaseRoles.POWER_USER);

        IdentificadorServico idServico = new IdentificadorServico(strIdServico);
        TituloServico tituloServico = new TituloServico(strTituloServico);
        DescBreveServico descBreveServico = new DescBreveServico(strDescBreveServico);
        DescCompServico descCompServico = new DescCompServico(strDescCompletaServico);

        IconeServico iconeServico = null;
        try {
            iconeServico = new IconeServico(iconeName, extensaoIcone);
        } catch (IOException ex) {
            Logger.getLogger(RegistarServicoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Formulario formularioSolicitacao = null;

        if (!strNomeFormularioSolicitacao.isEmpty() && !atributosFormularioSolicitacao.isEmpty()) {
            try {

                formularioSolicitacao = formularioInServico.createFormulario(strNomeFormularioSolicitacao, atributosFormularioSolicitacao);

            } catch (ParseException ex) {
                Logger.getLogger(RegistarServicoController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

//        Script scriptValidacaoFormulario = scriptController.registarScript(scriptName, scriptExtension);
        Servico newServico = new Servico(idServico, tituloServico, descBreveServico, descCompServico, iconeServico, satisfacao);

        if (catalogoDisponiblizaServico != null) {
            newServico.adicionarCatalogoQueDisponiblizaServico(catalogoDisponiblizaServico);
        }

        Workflow workflowServico = this.workflowInServico.createWorkflow(newServico, colaboradorResponsavelPelaResolucao, equipaResponsavelPelaResolucao, strNomeFormularioResolucao, atributosFormularioResolucao, strScriptResolucao, strNomeFormularioAprovacao, atributosFormularioAprovacao, responsavelHierarquicoIsAprovador);

        if (!keywordsEmServico.isEmpty()) {
            newServico.copyKeywords(keywordsEmServico);
        }
        if (nivelCriticidadeServico != null) {
            newServico.adicionarNivelCriticidadeServico(nivelCriticidadeServico);
        }
        if (workflowServico != null) {
            newServico.adicionarWorkflow(workflowServico);
        }
        if (formularioSolicitacao != null) {
            newServico.adicionarFormularioDeSolicitacaoServico(formularioSolicitacao);
        }
        if (estadoServico == true) {
            newServico.activateState();
        }

        return servicoRepository.save(newServico);
    }

    public boolean validateScriptAutomatico(String s) {
        return validar.parseWithVisitor(s);
    }

    @Transactional
    public Servico registerServico(Servico saveServico) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.GESTOR_SERVICO_HELP_DESK, BaseRoles.POWER_USER);

        return servicoRepository.save(saveServico);
    }

    @Transactional
    public Keyword registerKeyword(String strKeyword) throws ParseException {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.GESTOR_SERVICO_HELP_DESK, BaseRoles.POWER_USER);

        Keyword newKeyword = new Keyword(strKeyword);

        return keywordRepository.save(newKeyword);
    }

    public Workflow registerWorkflow(Workflow workflow) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.GESTOR_SERVICO_HELP_DESK, BaseRoles.POWER_USER);

        return workRepo.save(workflow);
    }

    public AtividadeRealizacao registerAtividadeRealizacao(AtividadeRealizacao atividade) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.GESTOR_SERVICO_HELP_DESK, BaseRoles.POWER_USER);

        return this.realizacaoRepo.save(atividade);
    }

    public AtividadeAprovacao registerAtividadeAprovacao(AtividadeAprovacao atividade) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.GESTOR_SERVICO_HELP_DESK, BaseRoles.POWER_USER);

        return this.aprovaRepo.save(atividade);
    }

    public Iterable<Catalogo> allCatalogosConcluidos() {
        return lCAS.listAllCatalogosDisponiveis();
    }

    public Iterable<Servico> allServicosIndisponiveis() {
        return lSS.listAllServicosIndisponiveis();
    }

    public Iterable<NivelCriticidade> SLADisponiveis() {
        return lSLA.listAllSLA();
    }

    public Iterable<Colaborador> ColaboradoresDisponiveis() {
        return lCC.listAllColaboradores();
    }

    public Iterable<Equipa> EquipasDisponiveis() {
        return lEC.listAllEquipas();
    }

    public FormularioDTO formularioFromServico(Servico servico) {
        return servico.formularioSolicitacaoDTO();
    }

    /*public FormularioDTO formularioFromServico(Servico servico) {
        return servico.formularioSolicitacaoDTO();
    }*/
    public Iterable<EquipaDto> EquipasDisponiveisDto() {
        return lEC.equipasAsDTO();
    }
}
