/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.tarefamanagement.DTO;

import eapli.framework.representations.dto.DTO;
import java.util.Date;

/**
 *
 * @author Guilherme
 */
@SuppressWarnings("squid:ClassVariableVisibilityCheck")
@DTO
public class TarefaDTO {

    public TarefaDTO(final String idTarefa, final String servicoDaTarefa, final Date dataLimitePedido, String nivelCriticidadePedido, Integer urgenciaPedido, String solicitadorServico) {
        this.idTarefa = idTarefa;
        this.servicoDaTarefa = servicoDaTarefa;
        this.dataLimitePedido = dataLimitePedido;
        this.nivelCriticidadePedido = nivelCriticidadePedido;
        this.urgenciaPedido = urgenciaPedido;
        this.solicitadorServico = solicitadorServico;
    }

    public TarefaDTO() {

    }
    
    public String idTarefa;
    public String servicoDaTarefa;
    public Date dataLimitePedido;
    public String nivelCriticidadePedido;
    public Integer urgenciaPedido;
    public String solicitadorServico;

}
