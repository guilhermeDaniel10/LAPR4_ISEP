/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.tarefamanagement.controller;

import eapli.base.infrastructure.persistence.PersistenceContext;

import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.tarefamanagement.domain.EstadoTarefa;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.repositories.TarefaRepository;

/**
 *
 * @author Guilherme
 */
public class RegistarTarefaAutomaticaController {

    private TarefaRepository tarefaRepo = PersistenceContext.repositories().tarefa();

    public Tarefa registarTarefaAutomatica(Pedido pedido, EstadoTarefa estado, Workflow workflow) {
        return tarefaRepo.save(new Tarefa(pedido, estado, workflow));
    }
}
