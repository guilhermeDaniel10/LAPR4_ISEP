/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.servicomanagement.application;

import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.servicomanagement.domain.AtividadeRealizacao;

/**
 *
 * @author Guilherme
 */
public class ListAtividadeRealizacaoController {

    private ListAtividadeRealizacaoService atividadesService = new ListAtividadeRealizacaoService();

    public Iterable<AtividadeRealizacao> atividadesRealizacaoEquipas(Iterable<Equipa> equipas) {
        return atividadesService.atividadesRealizacaoEquipas(equipas);
    }
}
