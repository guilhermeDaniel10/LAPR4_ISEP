/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.servicomanagement.application;

import eapli.base.servicomanagement.domain.AtividadeRealizacao;
import eapli.base.servicomanagement.domain.Servico;

/**
 *
 * @author Guilherme
 */
public class ListWorkflowController {
    
    private ListWorkflowService workService = new ListWorkflowService();
    
    public Iterable<Servico> servicesFromActivities(Iterable<AtividadeRealizacao> atividades){
        return workService.servicesFromActivities(atividades);
    }
}
