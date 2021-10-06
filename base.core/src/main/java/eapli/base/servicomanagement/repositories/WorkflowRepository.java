/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.servicomanagement.repositories;

import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.servicomanagement.domain.AtividadeRealizacao;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.framework.domain.repositories.DomainRepository;

/**
 *
 * @author lucas
 */
public interface WorkflowRepository extends DomainRepository<Long,Workflow> {
    
    public Iterable<Servico> servicesFromActivities(Iterable<AtividadeRealizacao> atividades);
    
    public Workflow workflowFromPedidoOfServico(Pedido pedido);
    
    public boolean isWorkflowAutomatico(Servico servico);
    
}
