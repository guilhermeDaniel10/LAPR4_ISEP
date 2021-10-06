/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.servicomanagement.application;

import eapli.base.bibliotecaatividades.domain.ScriptAutomatico;
import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.EquipasComAcessoCatalogo;
import eapli.base.colaboradormanagement.application.RegistarColaboradorController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.EquipasColaborador;
import eapli.base.equipamanagement.application.ListEquipaController;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.formulariomanagement.application.CreateFormularioController;
import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.DadosBase;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.domain.NomeFormulario;
import eapli.base.formulariomanagement.repositories.FormularioRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedidomanagement.domain.DataLimite;
import eapli.base.pedidomanagement.domain.EstadoPedido;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.domain.Urgencia;
import eapli.base.pedidomanagement.repositories.PedidoRepository;
import eapli.base.respostaformularios.domain.AtributoEmResposta;
import eapli.base.respostaformularios.domain.RespostaFormulario;
import eapli.base.respostaformularios.repositories.RespostaFormularioRepository;
import eapli.base.servicomanagement.domain.AtividadeAprovacao;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.servicomanagement.repositories.WorkflowRepository;
import eapli.base.tarefamanagement.application.ConvertRespostaParaScriptController;
import eapli.base.tarefamanagement.controller.RegistarTarefaAutomaticaController;
import eapli.base.tarefamanagement.domain.EstadoTarefa;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.repositories.TarefaRepository;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guilherme
 */
public class SolicitacaoServicoController {

    private RegistarColaboradorController colabController = new RegistarColaboradorController();
    private RegistarServicoController servicoController = new RegistarServicoController();
    private RespostaFormularioRepository respostaRepo = PersistenceContext.repositories().respostaFormulario();
    private RegistarTarefaAutomaticaController autoController = new RegistarTarefaAutomaticaController();
    private PedidoRepository pedidoRepo = PersistenceContext.repositories().pedido();
    private WorkflowRepository workRepo = PersistenceContext.repositories().workflow();
    private TarefaRepository tarefaRepository = PersistenceContext.repositories().tarefa();
    private FormularioRepository formRepo = PersistenceContext.repositories().formulario();
    private CreateFormularioController formCreateController = new CreateFormularioController();
    private ConvertRespostaParaScriptController converterController = new ConvertRespostaParaScriptController();

    private Pedido newPedido;
    private boolean isAutomatico;
    private Servico servicoDoPedido;
    private ListEquipaController equipasController = new ListEquipaController();

    public Pedido addPedido(Servico servico) {
        servicoDoPedido = servico;
        Colaborador currentColab = colabController.currentColaborador();
        Pedido recemPedido = new Pedido(currentColab, servico);

        if (servico.workflowServico().atividadeAprovacaoWorkflow() != null) {
            recemPedido.addAtividadeAprovacao(servico.workflowServico().atividadeAprovacaoWorkflow());

        }
        newPedido = recemPedido;
        isAutomatico = workRepo.isWorkflowAutomatico(servico);
        return recemPedido;
    }

    public Tarefa registaTarefaAutomativa(Servico servico, Pedido pedido) {
        Tarefa newT = new Tarefa(pedido, EstadoTarefa.EM_EXECUCAO, servico.workflowServico());
        newT.setGrauSatisfeito(false);

        return tarefaRepository.save(newT);
    }

    public RespostaFormulario findRespostaByNomeForm(String nomeForm) {
        return respostaRepo.findRespostaFormularioByNomeForm(nomeForm);
    }

    public void addResposta(RespostaFormulario resposta) {
        newPedido.addRespostaFormulario(resposta);
    }

    public void addFields(Urgencia urgencia, Date dataLimite, String ficheiros) {
        DataLimite data = new DataLimite(dataLimite);
        newPedido.addFields(urgencia.getValorUrgencia(), data, ficheiros);
    }

    public void registarSolicitacaoServico(RespostaFormulario resposta, ScriptAutomatico script) {

        Workflow workAtual = servicoDoPedido.workflowServico();
        AtividadeAprovacao aprovacao = workAtual.atividadeAprovacaoWorkflow();
        Catalogo catalogoServico = servicoDoPedido.catalogoQueDisponiblizaServico();
        Set<EquipasComAcessoCatalogo> equipasCatalogo = catalogoServico.equipa();
        List<Equipa> equipas = new ArrayList<>();

        for (EquipasComAcessoCatalogo eq : equipasCatalogo) {
            equipas.add(eq.equipa());

        }

        if (aprovacao != null) {
            Formulario oldFormulario = aprovacao.formularioAprovacao();
            Set<Atributo> oldAtributos = oldFormulario.asAtributo();
            List<AtributoEmResposta> respostaSolicitacao = resposta.valoresAtributos();
            if (aprovacao.isHierarquico()) {
                Iterable<EquipasColaborador> equipasColab = equipasController.listEquipasColaborador(colabController.currentColaborador());
                Equipa commonEquipa = commonEquipas(equipasColab, equipas);

                if (commonEquipa != null) {

                    Colaborador hierarquico = responsavelHierarquico(commonEquipa);

                    Formulario newFormularioForAprovacao = mergeFormularios(respostaSolicitacao, oldAtributos);

                    AtividadeAprovacao newAprovacao = new AtividadeAprovacao(aprovacao.isHierarquico(), hierarquico, newFormularioForAprovacao);
                    newPedido.addAtividadeAprovacao(newAprovacao);
                }
            } else {
                Colaborador responsavel = catalogoServico.responsavel();
                Formulario newFormularioForAprovacao = mergeFormularios(respostaSolicitacao, oldAtributos);
                AtividadeAprovacao newAprovacao = new AtividadeAprovacao(aprovacao.isHierarquico(), responsavel, newFormularioForAprovacao);
                newPedido.addAtividadeAprovacao(newAprovacao);
            }

            newPedido.changeState(EstadoPedido.EM_APROVACAO);
        } else {
            newPedido.changeState(EstadoPedido.SUBMETIDO);
        }
        Pedido pedidoGuardado = pedidoRepo.save(newPedido);
        if (pedidoGuardado != null) {
            if (isAutomatico == true && aprovacao == null) {
                String scriptResol = converterController.converterRespostaParaScript(script, resposta);
                pedidoGuardado.addScriptParaExecucaoFutura(scriptResol);
                Pedido pedidoGuardado2 = pedidoRepo.save(pedidoGuardado);
                // No futuro é preciso alterar para apenas as que ja foram aprovadas ou que nao precisam de aprovacao (Sprint D)
                autoController.registarTarefaAutomatica(pedidoGuardado2, EstadoTarefa.EM_EXECUCAO, workRepo.workflowFromPedidoOfServico(pedidoGuardado));
            } else if(isAutomatico == true && aprovacao != null){
                String scriptResol = converterController.converterRespostaParaScript(script, resposta);
                pedidoGuardado.addScriptParaExecucaoFutura(scriptResol);
                Pedido pedidoGuardado2 = pedidoRepo.save(pedidoGuardado);
            }
        }

    }

    public Equipa commonEquipas(Iterable<EquipasColaborador> equipasColab, List<Equipa> equipasAcesso) {
        Equipa equipa = null;

        List<Equipa> equi = new ArrayList<>();
        for (EquipasColaborador eqC : equipasColab) {
            equi.add(eqC.equipaColaborador());
        }

        for (Equipa e : equi) {

            for (Equipa eq : equipasAcesso) {

                if (e.acronimoEquipa().acronimoValidoDaEquipa().equals(eq.acronimoEquipa().acronimoValidoDaEquipa())) {
                    return e;
                }
            }
        }

        return null;
    }

    public Colaborador responsavelHierarquico(Equipa equipa) {
        return equipa.ResponsaveisEquipa().iterator().next().colaboradorResposavel();
    }

    public List<String> convertRespostaListToString(List<AtributoEmResposta> respostaSolicitacao) {
        List<String> list = new ArrayList<>();
        for (AtributoEmResposta ar : respostaSolicitacao) {
            list.add(ar.nomeVariavel());
        }
        return list;
    }

    public Formulario mergeFormularios(List<AtributoEmResposta> respostaSolicitacao, Set<Atributo> oldAtributos) {
        Set<Atributo> newAtributos = new HashSet<>();
        for (Atributo a : oldAtributos) {
            for (AtributoEmResposta aR : respostaSolicitacao) {
                if (a.nomeVariavel().toStringNome().equals(aR.nomeVariavel())) {
                    try {

                        newAtributos.add(formCreateController.createAtributo(a.posicaoForContext(), a.obrigatoriedadeAtributo(), a.dependeciaAtributo(), a.nomeVariavel().toStringNome(), "Aprovar Campo.", aR.respostaForm(), DadosBase.BOOLEANO, "(true|false)", null));
                    } catch (ParseException ex) {

                    }

                }
            }

        }
        List<String> respostasVariaveis = convertRespostaListToString(respostaSolicitacao);
        for (Atributo a : oldAtributos) {
            if (!respostasVariaveis.contains(a.nomeVariavel().toStringNome())) {
                try {
                    
                    try {
                        newAtributos.add(formCreateController.createAtributo(a.posicaoForContext(), a.obrigatoriedadeAtributo(), a.dependeciaAtributo(), a.nomeVariavel().toStringNome(), a.etiquetaAtributo().etiqueta(), a.descricaoAjuda().descricao(), a.dadoBase(), a.expressaoRegular().toStringOnlyExpressao(), a.expResposta().toStringOnlyExpressao()));
                    } catch (NullPointerException e) {
                        newAtributos.add(formCreateController.createAtributo(a.posicaoForContext(), a.obrigatoriedadeAtributo(), a.dependeciaAtributo(), a.nomeVariavel().toStringNome(), a.etiquetaAtributo().etiqueta(), a.descricaoAjuda().descricao(), a.dadoBase(), a.expressaoRegular().toStringOnlyExpressao(), null));

                    }
                } catch (ParseException ex) {
                    Logger.getLogger(SolicitacaoServicoController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        try {
            return formCreateController.createFormulario("Aprov" + newPedido.dataSolicitacao().getTime(), newAtributos);
        } catch (ParseException ex) {
            Logger.getLogger(SolicitacaoServicoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
