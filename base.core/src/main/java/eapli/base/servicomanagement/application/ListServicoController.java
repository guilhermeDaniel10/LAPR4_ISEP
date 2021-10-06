/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.servicomanagement.application;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.servicomanagement.domain.Servico;

/**
 *
 * @author lucas
 */
public class ListServicoController {
    
    private final ListServicoService servicoService = new ListServicoService();
    
    public Iterable<Servico> listAllServicos() {
        return servicoService.allServicos();
    }
    
    public Iterable<Servico> listAllServicosIndisponiveis() {
        return servicoService.servicosPorConcluir();
    }
    
    public Iterable<Servico> allServicosFromCatalogo(Catalogo catalogo){
        return servicoService.allServicosFromCatalogo(catalogo);
    }
    
    public Iterable<Servico> allServicosAvailableColaborador(){
        return servicoService.allServicosAvailableColaborador();
    }
    
    public Iterable<Servico> findServicoByMultipleFields(String obj){
        return servicoService.findServicoByMultipleFields(obj);
    }
    
    public int allNumeroServicos(){
        return servicoService.allNumeroServicos();
    }
}
