/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.pedidomanagement.dto;

import eapli.framework.representations.dto.DTO;

/**
 *
 * @author Guilherme
 */
@SuppressWarnings("squid:ClassVariableVisibilityCheck")
@DTO
public class PedidoDTO {

    public PedidoDTO(final Long idForInfo, final String identificadorServico, final String tituloServico, final String descBreveServico, final String descComp, final String urgencia,
            final String dataSolicitacao, final String dataLimite, final String solicitador) {

        this.idForInfo = idForInfo;
        this.identificadorServico = identificadorServico;
        this.tituloServico = tituloServico;
        this.descBreveServico = descBreveServico;
        this.descCompServico = descComp;
        this.urgencia = urgencia;
        this.dataSolicitacao = dataSolicitacao;
        this.dataLimite = dataLimite;
        this.solicitador = solicitador;

    }

    public PedidoDTO() {

    }

    public Long idForInfo;
    public String identificadorServico;
    public String tituloServico;
    public String descBreveServico;
    public String descCompServico;
    public String urgencia;
    public String dataSolicitacao;
    public String dataLimite;
    public String solicitador;

}
