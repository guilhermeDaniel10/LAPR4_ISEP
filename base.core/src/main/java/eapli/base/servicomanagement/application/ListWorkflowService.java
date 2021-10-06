/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.servicomanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.servicomanagement.domain.AtividadeRealizacao;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repositories.WorkflowRepository;

/**
 *
 * @author Guilherme
 */
public class ListWorkflowService {
    
    private WorkflowRepository workflowRepo = PersistenceContext.repositories().workflow();
    
    
    public Iterable<Servico> servicesFromActivities(Iterable<AtividadeRealizacao> atividades){
        return workflowRepo.servicesFromActivities(atividades);
    }
}
