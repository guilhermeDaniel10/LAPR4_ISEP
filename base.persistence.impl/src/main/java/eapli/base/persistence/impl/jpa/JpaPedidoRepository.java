/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.pedidomanagement.domain.EstadoPedido;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.dto.PedidoDTO;
import eapli.base.pedidomanagement.repositories.PedidoRepository;
import eapli.base.servicomanagement.domain.AtividadeRealizacao;
import eapli.base.servicomanagement.domain.IdentificadorServico;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.tarefamanagement.domain.Tarefa;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.NoResultException;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

/**
 *
 * @author Guilherme
 */
public class JpaPedidoRepository extends BasepaRepositoryBase<Pedido, Long, Long> implements PedidoRepository {

    JpaPedidoRepository() {
        super("idPedido");
    }

    @Override
    public Iterable<Pedido> availablePedidosSemAprovacao(Iterable<Servico> servicos, EstadoPedido estado) {
        List<Pedido> pedidos = new ArrayList<>();

        for (Servico ser : servicos) {
            try {

                final TypedQuery<Pedido> q = createQuery("SELECT e FROM Pedido e inner join e.servico ser inner join ser.workflowServico wor WHERE ser = :serv AND e.estadoPedido = :esta AND wor.atividadeAprovacaoServico IS NULL",
                        Pedido.class);
                q.setParameter("serv", ser);
                q.setParameter("esta", estado);
                pedidos.addAll(q.getResultList());
            } catch (NoResultException nre) {

            }
        }

        return pedidos;
    }

    @Override
    public Pedido pedidoFromDTO(PedidoDTO pedido) {
        try {
            final TypedQuery<Pedido> q = createQuery("SELECT e FROM Pedido e WHERE e.idPedido = :ped",
                    Pedido.class);
            q.setParameter("ped", pedido.idForInfo);

            return q.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public Pedido findPedidoById(Long id) {
        try {
            final TypedQuery<Pedido> q = createQuery("SELECT e FROM Pedido e WHERE e.idPedido = :idPed",
                    Pedido.class);
            q.setParameter("idPed", id);

            return q.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public Iterable<Pedido> pedidosFromColaboradorRealizados(Colaborador colab) {
        Set<Pedido> pedidos = new HashSet<>();
        try {
            final TypedQuery<Pedido> q = createQuery("SELECT e FROM Pedido e WHERE e.estadoPedido = :est AND e.solicitador = :currentC ORDER BY e.dataSolicitacao",
                    Pedido.class);
            q.setParameter("est", EstadoPedido.RESOLVIDO);
            q.setParameter("currentC", colab);

            final TypedQuery<Pedido> q2 = createQuery("SELECT e FROM Pedido e WHERE e.estadoPedido = :est AND e.solicitador = :currentC ORDER BY e.dataSolicitacao",
                    Pedido.class);
            q2.setParameter("est", EstadoPedido.REJEITADO);
            q2.setParameter("currentC", colab);
            if (q.getResultList().size() == 0 && q2.getResultList().size() == 0) {
                return null;
            }
            pedidos.addAll(q.getResultList());
            pedidos.addAll(q2.getResultList());
            return pedidos;

        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public Iterable<Pedido> pedidosFromColaboradorEmExecucao(Colaborador colab) {
        Set<Pedido> pedidos = new HashSet<>();
        try {
            final TypedQuery<Pedido> q = createQuery("SELECT e FROM Pedido e WHERE e.solicitador = :currentC AND e.estadoPedido = :est ORDER BY e.dataSolicitacao",
                    Pedido.class);
            q.setParameter("est", EstadoPedido.APROVADO);
            q.setParameter("currentC", colab);
            pedidos.addAll(q.getResultList());

            final TypedQuery<Pedido> q2 = createQuery("SELECT e FROM Pedido e WHERE e.solicitador = :currentC AND e.estadoPedido = :est2 ORDER BY e.dataSolicitacao",
                    Pedido.class);
            q2.setParameter("est2", EstadoPedido.EM_APROVACAO);
            q2.setParameter("currentC", colab);
            pedidos.addAll(q2.getResultList());

            final TypedQuery<Pedido> q3 = createQuery("SELECT e FROM Pedido e WHERE e.solicitador = :currentC AND e.estadoPedido = :est3 ORDER BY e.dataSolicitacao",
                    Pedido.class);
            q3.setParameter("est3", EstadoPedido.SUBMETIDO);
            q3.setParameter("currentC", colab);
            pedidos.addAll(q3.getResultList());

            final TypedQuery<Pedido> q4 = createQuery("SELECT e FROM Pedido e WHERE e.solicitador = :currentC AND e.estadoPedido = :est4 ORDER BY e.dataSolicitacao",
                    Pedido.class);
            q4.setParameter("est4", EstadoPedido.EM_RESOLUCAO);
            q4.setParameter("currentC", colab);
            pedidos.addAll(q4.getResultList());

            if (pedidos.isEmpty()) {
                return null;
            }
            return pedidos;
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public Iterable<Pedido> availablePedidosForAprovacao(Colaborador colab) {
        try {
            final TypedQuery<Pedido> q = createQuery("SELECT e FROM Pedido e inner join e.aprovacaoPedido aprov WHERE e.estadoPedido = :est AND aprov.responsavelAprovacao = :currentC",
                    Pedido.class);
            q.setParameter("est", EstadoPedido.EM_APROVACAO);
            q.setParameter("currentC", colab);
            if (q.getResultList().isEmpty()) {
                return null;
            }
            return q.getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public Iterable<Pedido> availablePedidosJaAprovados(Iterable<Servico> servicos) {
        List<Pedido> pedidos = new ArrayList<>();

        for (Servico ser : servicos) {
            try {

                final TypedQuery<Pedido> q = createQuery("SELECT e FROM Pedido e inner join e.servico ser inner join ser.workflowServico wor WHERE ser = :serv AND e.estadoPedido = :esta",
                        Pedido.class);
                q.setParameter("serv", ser);
                q.setParameter("esta", EstadoPedido.APROVADO);
                pedidos.addAll(q.getResultList());
            } catch (NoResultException nre) {

            }
        }

        return pedidos;
    }

    @Override
    public Iterable<Pedido> pedidosParaExecucaoManual() {
        List<Pedido> pedidos = new ArrayList<>();

        try {

            final TypedQuery<Pedido> q = createQuery("SELECT e FROM Pedido e inner join e.servico ser inner join ser.workflowServico wor inner join wor.atividadeRealizacaoServico ars WHERE e.estadoPedido = :esta AND wor.atividadeRealizacaoServico IS NOT NULL AND ars.atividadeAutomatica IS NULL",
                    Pedido.class);
            q.setParameter("esta", EstadoPedido.APROVADO);
            pedidos.addAll(q.getResultList());
        } catch (NoResultException nre) {
            return null;
        }
        
        try {

            final TypedQuery<Pedido> q2 = createQuery("SELECT e FROM Pedido e inner join e.servico ser inner join ser.workflowServico wor inner join wor.atividadeRealizacaoServico ars WHERE e.estadoPedido = :esta AND wor.atividadeRealizacaoServico IS NOT NULL AND ars.atividadeAutomatica IS NULL",
                    Pedido.class);
            q2.setParameter("esta", EstadoPedido.SUBMETIDO);
            pedidos.addAll(q2.getResultList());
        } catch (NoResultException nre) {
            return null;
        }

        return pedidos;
    }
    @Override
    public Iterable<Pedido> pedidosConcluidosForaPrazo(Date limiteInferior, Date LimiteSuperior ){
       List<Pedido> list = new ArrayList<>();
       final TypedQuery<Pedido> q2 = createQuery("SELECT e FROM Pedido e WHERE e.estadoPedido = :est AND e.dataSolicitacao BETWEEN :startDate AND :endDate",
                    Pedido.class);
        q2.setParameter("est", EstadoPedido.CONCLUIDO);
        q2.setParameter("startDate", limiteInferior, TemporalType.DATE);
        q2.setParameter("endDate", LimiteSuperior, TemporalType.DATE);
        if (q2.getResultList().isEmpty()) {
            return null;
        }
        for (Pedido p : q2.getResultList()) {
            long limit = p.servicoDoPedido().objetivosDoServico().tempoMaxResolucao().getTempoMilissegundo();
            long dataSolicitacao = p.dataSolicitacao().getTime();
            if(limit + dataSolicitacao < p.dataConclusao().getTime()){
                list.add(p);
            }
        }
        return list;
    }
    @Override
    public Iterable<Pedido> pedidosConcluidosDentroPrazo(Date limiteInferior, Date LimiteSuperior){
        List<Pedido> list = new ArrayList<>();
        final TypedQuery<Pedido> q2 = createQuery("SELECT e FROM Pedido e WHERE (e.estadoPedido = :est OR e.estadoPedido = :estad) AND e.dataSolicitacao BETWEEN :startDate AND :endDate",
                    Pedido.class);
        q2.setParameter("est", EstadoPedido.CONCLUIDO);
        q2.setParameter("estad", EstadoPedido.RESOLVIDO);
        q2.setParameter("startDate", limiteInferior, TemporalType.DATE);
        q2.setParameter("endDate", LimiteSuperior, TemporalType.DATE);
        if (q2.getResultList().isEmpty()) {
            return null;
        }
        for (Pedido p : q2.getResultList()) {
            long limit = p.servicoDoPedido().objetivosDoServico().tempoMaxResolucao().getTempoMilissegundo();
            long dataSolicitacao = p.dataSolicitacao().getTime();
            if(limit + dataSolicitacao > p.dataConclusao().getTime()){
                list.add(p);
            }
        }
        return list;
    }
    
    @Override
    public Iterable<Pedido> pedidosPorConcluirDentroDoPrazo(Date limiteInferior, Date LimiteSuperior){
       List<Pedido> list = new ArrayList<>();
       final TypedQuery<Pedido> q2 = createQuery("SELECT e FROM Pedido e WHERE (e.estadoPedido = :estAprov OR e.estadoPedido = :estSubm OR e.estadoPedido = :estEmRes)"
               + " AND e.dataSolicitacao BETWEEN :startDate AND :endDate",
                    Pedido.class);
        q2.setParameter("estAprov", EstadoPedido.APROVADO);
        q2.setParameter("estSubm", EstadoPedido.SUBMETIDO);
        q2.setParameter("estEmRes", EstadoPedido.EM_RESOLUCAO);
        q2.setParameter("startDate", limiteInferior, TemporalType.DATE);
        q2.setParameter("endDate", LimiteSuperior, TemporalType.DATE);
        if (q2.getResultList().isEmpty()) {
            return null;
        }
        for (Pedido p : q2.getResultList()) {
            long limit = p.servicoDoPedido().objetivosDoServico().tempoMaxResolucao().getTempoMilissegundo();
            long dataSolicitacao = p.dataSolicitacao().getTime();
            long currentTime = new Date().getTime();
            if(limit + dataSolicitacao > currentTime){
                list.add(p);
            }
        }
        return list;
    }
    @Override
    public Iterable<Pedido> pedidosPorConcluirForaPrazo(Date limiteInferior, Date LimiteSuperior){
     List<Pedido> list = new ArrayList<>();
       final TypedQuery<Pedido> q2 = createQuery("SELECT e FROM Pedido e WHERE (e.estadoPedido = :estAprov OR e.estadoPedido = :estSubm OR e.estadoPedido = :estEmRes) "
               + " AND e.dataSolicitacao BETWEEN :startDate AND :endDate",
                    Pedido.class);
        q2.setParameter("estAprov", EstadoPedido.APROVADO);
        q2.setParameter("estSubm", EstadoPedido.SUBMETIDO);
        q2.setParameter("estEmRes", EstadoPedido.EM_RESOLUCAO);
        q2.setParameter("startDate", limiteInferior, TemporalType.DATE);
        q2.setParameter("endDate", LimiteSuperior, TemporalType.DATE);
        if (q2.getResultList().isEmpty()) {
            return null;
        }
        for (Pedido p : q2.getResultList()) {
            long limit = p.servicoDoPedido().objetivosDoServico().tempoMaxResolucao().getTempoMilissegundo();
            long dataSolicitacao = p.dataSolicitacao().getTime();
            long currentTime = new Date().getTime();
            if(limit + dataSolicitacao < currentTime){
                list.add(p);
            }
        }
        return list;
    }
    @Override
    public Iterable<Pedido> pedidosPorAprovarDentroPrazo(Date limiteInferior, Date LimiteSuperior){
        List<Pedido> list = new ArrayList<>();
        final TypedQuery<Pedido> q2 = createQuery("SELECT e FROM Pedido e INNER JOIN e.aprovacaoPedido ap WHERE ap IS NOT NULL AND e.estadoPedido = :est AND e.dataSolicitacao BETWEEN :startDate AND :endDate",
                    Pedido.class);
        q2.setParameter("est", EstadoPedido.EM_APROVACAO);
        q2.setParameter("startDate", limiteInferior, TemporalType.DATE);
        q2.setParameter("endDate", LimiteSuperior, TemporalType.DATE);
        if (q2.getResultList().isEmpty()) {
            return null;
        }
        for (Pedido p : q2.getResultList()) {
            long limit = p.servicoDoPedido().objetivosDoServico().tempoMaxAprovacao().getTempoMilissegundo();
            long dataSolicitacao = p.dataSolicitacao().getTime();
            if(limit + dataSolicitacao > p.dataConclusao().getTime()){
                list.add(p);
            }
        }
        return list;
    }
    @Override
    public Iterable<Pedido> pedidosPorAprovarForaPrazo(Date limiteInferior, Date LimiteSuperior){
        List<Pedido> list = new ArrayList<>();
        final TypedQuery<Pedido> q2 = createQuery("SELECT e FROM Pedido e INNER JOIN e.aprovacaoPedido ap WHERE ap IS NOT NULL AND e.estadoPedido = :est AND e.dataSolicitacao BETWEEN :startDate AND :endDate",
                    Pedido.class);
        q2.setParameter("est", EstadoPedido.EM_APROVACAO);
        q2.setParameter("startDate", limiteInferior, TemporalType.DATE);
        q2.setParameter("endDate", LimiteSuperior, TemporalType.DATE);
        if (q2.getResultList().isEmpty()) {
            return null;
        }
        for (Pedido p : q2.getResultList()) {
            long limit = p.servicoDoPedido().objetivosDoServico().tempoMaxAprovacao().getTempoMilissegundo();
            long dataSolicitacao = p.dataSolicitacao().getTime();
            if(limit + dataSolicitacao > p.dataConclusao().getTime()){
                list.add(p);
            }
        }
        return list;
    }
    @Override
    public Double tempoMedioResolucaoServico(Date limiteInferior, Date LimiteSuperior, Servico servico){
        final TypedQuery<Pedido> q2 = createQuery("SELECT e FROM Pedido e WHERE e.servico = :serv AND e.dataSolicitacao BETWEEN :startDate AND :endDate",
                    Pedido.class);
        q2.setParameter("serv", servico);
        q2.setParameter("startDate", limiteInferior, TemporalType.DATE);
        q2.setParameter("endDate", LimiteSuperior, TemporalType.DATE);
        double sum = 0d;
        for(Pedido p : q2.getResultList()){
            long data;
            if(p.estadoDoPedido().equals(EstadoPedido.CONCLUIDO)){
                data = p.dataConclusao().getTime();
            }else{
                data = new Date().getTime();
            }
            long tempoConclusao = data - p.dataSolicitacao().getTime();
            sum += tempoConclusao;          
        }
        
        return sum/q2.getResultList().size();
    }
    @Override
    public Double tempoMedioAprovacaoServico(Date limiteInferior, Date LimiteSuperior, Servico servico){
        final TypedQuery<Pedido> q2 = createQuery("SELECT e FROM Pedido e INNER JOIN e.aprovacaoPedido ap WHERE ap IS NOT NULL AND e.servico = :serv AND e.dataSolicitacao BETWEEN :startDate AND :endDate",
                    Pedido.class);
        q2.setParameter("serv", servico);
        q2.setParameter("startDate", limiteInferior, TemporalType.DATE);
        q2.setParameter("endDate", LimiteSuperior, TemporalType.DATE);
        double sum = 0d;
        for(Pedido p : q2.getResultList()){
            if(p.atividadeAprovacaoPedido() != null){ 
                sum += p.atividadeAprovacaoPedido().dataAprovacao().getTime();   
            }     
        }
        
        return sum/q2.getResultList().size();
    }
}
