/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.catalogomanagemente.application;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipamanagement.domain.Equipa;

/**
 *
 * @author lucas
 */
public class ListCatalogoController {

    private final ListCatalogoService catalogoService = new ListCatalogoService();

    public Iterable<Catalogo> listAllCatalogos() {
        return catalogoService.allCatalogos();
    }

    public Iterable<Catalogo> listAllCatalogosDisponiveis() {
        return catalogoService.catalogosConcluidos();
    }

    public Iterable<Catalogo> listAllCatalogosIndisponiveis() {
        return catalogoService.catalogosPorConcluir();
    }

    public Iterable<Catalogo> findCatalogoDeColaborador() {
        return catalogoService.findCatalogosDeColaborador();
    }

    public Iterable<Catalogo> findCatalogoByMultipleFields(String obj) {
        return catalogoService.findCatalogoByMultipleFields(obj);
    }
}
