/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.bibliotecaatividades.domain.AtividadeAutomatica;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.servicomanagement.domain.AtividadeRealizacao;
import eapli.base.servicomanagement.domain.IdentificadorServico;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.servicomanagement.repositories.WorkflowRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author lucas
 */
public class JpaWorkflowRepository extends BasepaRepositoryBase<Workflow, Long, Long> implements WorkflowRepository {

    JpaWorkflowRepository() {
        super("identificadorWorkflow");
    }

    @Override
    public Iterable<Servico> servicesFromActivities(Iterable<AtividadeRealizacao> atividades) {
        List<Workflow> possibleWorkflows = new ArrayList<>();
        for (AtividadeRealizacao ati : atividades) {
            try {
                final TypedQuery<Workflow> q = createQuery("SELECT e FROM Workflow e WHERE e.atividadeRealizacaoServico = :ativ",
                        Workflow.class);
                q.setParameter("ativ", ati);

                possibleWorkflows.add(q.getSingleResult());
            } catch (NoResultException nre) {

            }
        }

        List<Servico> possibleServico = new ArrayList<>();
        for (Workflow ww : possibleWorkflows) {
            try {
                final TypedQuery<Servico> q2 = createQuery("SELECT e FROM Servico e WHERE e.workflowServico = :serv",
                        Servico.class);
                q2.setParameter("serv", ww);

                possibleServico.add(q2.getSingleResult());
            } catch (NoResultException nre) {

            }
        }

        return possibleServico;
    }

    @Override
    public Workflow workflowFromPedidoOfServico(Pedido pedido) {
        try {
            final TypedQuery<Workflow> q2 = createQuery("SELECT l.workflowServico FROM Pedido e inner join e.servico l WHERE e.idPedido = :idPed",
                    Workflow.class);
            q2.setParameter("idPed", pedido.identity());
            return q2.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public boolean isWorkflowAutomatico(Servico servico) {
        IdentificadorServico idSer = servico.identificadorServico();
        try {
            final TypedQuery<AtividadeAutomatica> q2 = createQuery("SELECT atr.atividadeAutomatica FROM Servico e inner join e.workflowServico w inner join w.atividadeRealizacaoServico atr WHERE e.identificadorServico = :ser",
                    AtividadeAutomatica.class);
            q2.setParameter("ser", idSer);

            if (q2.getSingleResult() != null) {
                return true;
            }
            return false;

        } catch (NoResultException nre) {
            return false;
        }
    }

}
