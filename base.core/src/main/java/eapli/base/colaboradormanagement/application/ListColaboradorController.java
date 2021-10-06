/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.colaboradormanagement.application;

import eapli.base.colaboradormanagement.domain.Colaborador;

/**
 *
 * @author Guilherme
 */
public class ListColaboradorController {
    private final ListColaboradorService colaboradorService = new ListColaboradorService();
    
    public Iterable<Colaborador> listAllColaboradores() {
        return colaboradorService.allColaboradores();
    }
}
