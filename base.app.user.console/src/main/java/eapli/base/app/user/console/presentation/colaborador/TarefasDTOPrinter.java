/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.user.console.presentation.colaborador;

import eapli.base.tarefamanagement.DTO.TarefaDTO;
import eapli.framework.visitor.Visitor;

/**
 *
 * @author Guilherme
 */
public class TarefasDTOPrinter implements Visitor<TarefaDTO>  {

    @Override
    public void visit(TarefaDTO visitee) {
        System.out.println("\nServico da tarefa: " + visitee.servicoDaTarefa + "\nData Limite da Tarefa: " + visitee.dataLimitePedido + "\nNivel de criticidade do servico: " + visitee.nivelCriticidadePedido
        + "\nUrgencia da tarefa: " + visitee.urgenciaPedido + "\nSolicitador do servico: " + visitee.solicitadorServico);
    }
    
}
