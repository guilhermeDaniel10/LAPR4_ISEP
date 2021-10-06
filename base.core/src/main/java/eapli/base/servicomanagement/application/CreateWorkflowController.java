/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.servicomanagement.application;

import eapli.base.bibliotecaatividades.domain.AtividadeAutomatica;
import eapli.base.bibliotecaatividades.domain.AtividadesExistentes;
import eapli.base.bibliotecaatividades.domain.ScriptAutomatico;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.formulariomanagement.application.CreateFormularioController;
import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.AtividadeAprovacao;
import eapli.base.servicomanagement.domain.AtividadeRealizacao;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.servicomanagement.repositories.AtividadeAprovacaoRepository;
import eapli.base.servicomanagement.repositories.AtividadeRealizacaoRepository;
import eapli.base.servicomanagement.repositories.WorkflowRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import java.text.ParseException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author lucas
 */
public class CreateWorkflowController {
    
    @Autowired
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    @Autowired
    private final WorkflowRepository workRepo = PersistenceContext.repositories().workflow();
    @Autowired
    private final AtividadeRealizacaoRepository realizacaoRepo = PersistenceContext.repositories().atividadeRealizacao();
    @Autowired
    private final AtividadeAprovacaoRepository aprovaRepo = PersistenceContext.repositories().atividadeAprovacao();
    @Autowired
    private final CreateFormularioController formularioInWorkflow = new CreateFormularioController();
    
    public Workflow createWorkflow(Servico servico, Colaborador colaboradorResponsavelPelaResolucao, Equipa equipaResponsavelPelaResolucao, String strNomeFormularioResolucao,
            Set<Atributo> atributosFormularioResolucao, String strScriptResolucao, String strNomeFormularioAprovacao,
            Set<Atributo> atributosFormularioAprovacao, boolean responsavelHierarquicoIsAprovador) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.GESTOR_SERVICO_HELP_DESK, BaseRoles.POWER_USER);

        Formulario formularioAprovacao = validateFormulario(strNomeFormularioAprovacao, atributosFormularioAprovacao);

        AtividadeAprovacao atividadeAprovacao = null;
        if (formularioAprovacao != null) {
            if(!responsavelHierarquicoIsAprovador){
                Colaborador responsavel = servico.catalogoQueDisponiblizaServico().responsavel();
                atividadeAprovacao = new AtividadeAprovacao(responsavelHierarquicoIsAprovador, responsavel, formularioAprovacao);
            } else {
                atividadeAprovacao = new AtividadeAprovacao(responsavelHierarquicoIsAprovador, null, formularioAprovacao);
            }
            
        }
        
        Formulario formularioResolucao = validateFormulario(strNomeFormularioResolucao, atributosFormularioResolucao);

        AtividadeRealizacao atividadeRealizacao = null;
        if (formularioResolucao != null) {
            if (equipaResponsavelPelaResolucao != null) {
                atividadeRealizacao = new AtividadeRealizacao(formularioResolucao, equipaResponsavelPelaResolucao);

            } else if (colaboradorResponsavelPelaResolucao != null) {
                atividadeRealizacao = new AtividadeRealizacao(formularioResolucao, colaboradorResponsavelPelaResolucao);

            }
        } else {
            if (equipaResponsavelPelaResolucao != null) {
                atividadeRealizacao = new AtividadeRealizacao(equipaResponsavelPelaResolucao);

            } else if (colaboradorResponsavelPelaResolucao != null) {
                atividadeRealizacao = new AtividadeRealizacao(colaboradorResponsavelPelaResolucao);
            } else if (strScriptResolucao != null) {
                ScriptAutomatico scriptRealizacao = new ScriptAutomatico(strScriptResolucao);
                atividadeRealizacao = new AtividadeRealizacao(new AtividadeAutomatica(AtividadesExistentes.AUTOMATICA_SCRIPT, scriptRealizacao));
            }
        }

        Workflow workflowServico = null;
        if (atividadeRealizacao != null && atividadeAprovacao != null) {
            workflowServico = new Workflow(atividadeAprovacao, atividadeRealizacao);

        } else if (atividadeRealizacao != null && atividadeAprovacao == null) {
            workflowServico = new Workflow(atividadeRealizacao);
        }

        return workflowServico;
    }
    
    public Formulario validateFormulario( String strNomeFormulario, Set<Atributo> atributosFormulario) {
        Formulario formulario = null;
        if (strNomeFormulario != null && !atributosFormulario.isEmpty()) {
            try {
                formulario = formularioInWorkflow.createFormulario(strNomeFormulario, atributosFormulario);
            } catch (ParseException ex) {
                Logger.getLogger(CreateWorkflowController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return formulario;
    }
    
}
