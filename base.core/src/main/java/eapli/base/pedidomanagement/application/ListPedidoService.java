/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.pedidomanagement.application;

import eapli.base.colaboradormanagement.application.RegistarColaboradorController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.EquipasColaborador;
import eapli.base.equipamanagement.application.ListEquipaController;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedidomanagement.domain.EstadoPedido;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.dto.PedidoDTO;
import eapli.base.pedidomanagement.repositories.PedidoRepository;
import eapli.base.servicomanagement.application.ListAtividadeRealizacaoController;
import eapli.base.servicomanagement.application.ListWorkflowController;
import eapli.base.servicomanagement.domain.AtividadeRealizacao;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repositories.ServicoRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guilherme
 */
public class ListPedidoService {

    private RegistarColaboradorController colabController = new RegistarColaboradorController();
    private ListEquipaController equipasController = new ListEquipaController();
    private ListAtividadeRealizacaoController atividadesController = new ListAtividadeRealizacaoController();
    private ListWorkflowController workController = new ListWorkflowController();
    private PedidoRepository pedidoRepo = PersistenceContext.repositories().pedido();
    private ServicoRepository servicoRepo = PersistenceContext.repositories().servico();

    public Iterable<Pedido> tarefasDisponiveis() {
        Colaborador colabAtual = colabController.currentColaborador();
        List<Equipa> equipas = new ArrayList<>();
        Iterable<EquipasColaborador> equipasC = equipasController.listEquipasColaborador(colabAtual);
        equipasC.forEach((element) -> equipas.add(element.equipaColaborador()));

        Iterable<AtividadeRealizacao> atividades = atividadesController.atividadesRealizacaoEquipas(equipas);
        Iterable<Servico> servicos = workController.servicesFromActivities(atividades);

        //ALTERAR AQUI AFINAL
        return pedidoRepo.availablePedidosSemAprovacao(servicos, EstadoPedido.SUBMETIDO);
    }

    public Iterable<Pedido> tarefasDisponiveisJaAprovadas() {
        Colaborador colabAtual = colabController.currentColaborador();
        List<Equipa> equipas = new ArrayList<>();
        Iterable<EquipasColaborador> equipasC = equipasController.listEquipasColaborador(colabAtual);
        equipasC.forEach((element) -> equipas.add(element.equipaColaborador()));

        Iterable<AtividadeRealizacao> atividades = atividadesController.atividadesRealizacaoEquipas(equipas);
        Iterable<Servico> servicos = workController.servicesFromActivities(atividades);

        //ALTERAR AQUI AFINAL
        return pedidoRepo.availablePedidosJaAprovados(servicos);
    }

    public Iterable<PedidoDTO> availablePedidosAsDTO() {
        List<PedidoDTO> pedidosDTO = new ArrayList<>();
        for (Pedido p : tarefasDisponiveis()) {
            pedidosDTO.add(p.toDTO());
        }

        for (Pedido p : tarefasDisponiveisJaAprovadas()) {
            pedidosDTO.add(p.toDTO());
        }

        return pedidosDTO;
    }

    public Iterable<Pedido> availablePedidosForAprovacao() {
        Colaborador currentColaborador = colabController.currentColaborador();
        return pedidoRepo.availablePedidosForAprovacao(currentColaborador);
    }

    public Iterable<PedidoDTO> pedidosFromColaboradorRealizados() {
        Colaborador currentColaborador = colabController.currentColaborador();
        Iterable<Pedido> pedidos = pedidoRepo.pedidosFromColaboradorRealizados(currentColaborador);
        List<PedidoDTO> pedidosDTO = new ArrayList<>();

        if (pedidos == null) {
            return null;
        }

        for (Pedido p : pedidos) {
            pedidosDTO.add(p.toDTO());
        }
        return pedidosDTO;
    }

    public Iterable<PedidoDTO> pedidosFromColaboradorEmExecucao() {
        Colaborador currentColaborador = colabController.currentColaborador();
        Iterable<Pedido> pedidos = pedidoRepo.pedidosFromColaboradorEmExecucao(currentColaborador);
        List<PedidoDTO> pedidosDTO = new ArrayList<>();

        if (pedidos == null) {
            return null;
        }

        for (Pedido p : pedidos) {
            pedidosDTO.add(p.toDTO());
        }
        return pedidosDTO;
    }
    
    public Map<String, List<Pedido>> listarInfomacaoCumprimentoSLA(Date limiteInferior,Date limiteSuperior){
        Map<String, List<Pedido>> map = new HashMap<>();
    
        map.put("Pedidos Concluidos Fora do Prazo", (List<Pedido>) pedidoRepo.pedidosConcluidosForaPrazo(limiteInferior,limiteSuperior));
        map.put("Pedidos Concluidos Dentro do Prazo", (List<Pedido>) pedidoRepo.pedidosConcluidosDentroPrazo(limiteInferior,limiteSuperior));
        map.put("Pedidos Por Concluir Dentro do Prazo", (List<Pedido>) pedidoRepo.pedidosPorConcluirDentroDoPrazo(limiteInferior,limiteSuperior));
        map.put("Pedidos Por Concluir Fora do Prazo", (List<Pedido>) pedidoRepo.pedidosPorConcluirForaPrazo(limiteInferior,limiteSuperior));
        map.put("Pedidos Aprovados Dentro do Prazo", (List<Pedido>) pedidoRepo.pedidosPorAprovarDentroPrazo(limiteInferior,limiteSuperior));
        map.put("Pedidos Aprovados Fora do Prazo", (List<Pedido>) pedidoRepo.pedidosPorAprovarForaPrazo(limiteInferior,limiteSuperior));
        
        return map;
    }
    
    public Map<String, List<Servico>> listarInformacaoCumprimentosMediasSLA(Date limiteInferior,Date limiteSuperior){
        Map<String, List<Servico>> map = new HashMap<>();
        Iterable<Servico> listServico = servicoRepo.findAll();
         
        List<Servico> listServicosDentroTempoMedioAprovacao = new ArrayList<>();
        List<Servico> listServicosDentroTempoMedioResolucao = new ArrayList<>();
        List<Servico> listServicosForaTempoMedioAprovacao = new ArrayList<>();
        List<Servico> listServicosForaTempoMedioResolucao = new ArrayList<>();
        for(Servico s : listServico){
            Double tempoMedioAprovacao = (double) s.objetivosDoServico().tempoMedioAprovacao().getTempo();
            Double tempoMedioResolucao = (double) s.objetivosDoServico().tempoMaxAprovacao().getTempo();
            if(pedidoRepo.tempoMedioAprovacaoServico(limiteInferior, limiteSuperior, s) > tempoMedioAprovacao){
                listServicosDentroTempoMedioAprovacao.add(s);
            }else{
                listServicosForaTempoMedioAprovacao.add(s);
            }
            if(pedidoRepo.tempoMedioResolucaoServico(limiteInferior, limiteSuperior, s) > tempoMedioResolucao){
                listServicosDentroTempoMedioResolucao.add(s);
            }else{
                listServicosForaTempoMedioResolucao.add(s);
            }
        }
        
        map.put("Servicos Dentro Tempo Medio Aprovacao", listServicosDentroTempoMedioAprovacao);
        map.put("Servicos Fora Tempo Medio Aprovacao", listServicosForaTempoMedioAprovacao);
        map.put("Servicos Dentro Tempo Medio Resolucao", listServicosDentroTempoMedioResolucao);
        map.put("Servicos Fora Tempo Medio Resolucao", listServicosForaTempoMedioResolucao);
        
        
        return map;
    }
    

}
