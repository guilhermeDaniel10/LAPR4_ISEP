/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.servicomanagement.application;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagemente.application.ListCatalogoController;
import eapli.base.colaboradormanagement.application.RegistarColaboradorController;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipamanagement.application.ListEquipaController;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repositories.ServicoRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author lucas
 */
public class ListServicoService {

    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servico();
    private final ListCatalogoController catalogoController = new ListCatalogoController();
    private final ListEquipaController listEquipaController = new ListEquipaController();

    public Iterable<Servico> allServicos() {
        return this.servicoRepository.findAll();
    }

    public Iterable<Servico> servicosPorConcluir() {

        Iterable<Servico> allServicos = allServicos();
        List<Servico> lstServicos = new ArrayList<>();
        Iterable<Servico> itServico;

        if (allServicos.iterator().hasNext() == false) {
            return allServicos();
        }

        for (Servico elem : allServicos) {
            if (elem.isActive() == false) {
                lstServicos.add(elem);
            }
        }

        itServico = lstServicos;

        return itServico;
    }

    public Iterable<Servico> allServicosFromCatalogo(Catalogo catalogo) {
        return servicoRepository.allServicosFromCatalogo(catalogo);
    }

    public Iterable<Servico> allServicosAvailableColaborador() {
        LinkedHashSet<Servico> listServico = new LinkedHashSet<>();
        for (Catalogo c : catalogoController.findCatalogoDeColaborador()) {
            allServicosFromCatalogo(c).forEach(listServico::add);
        }

        return listServico;
    }

    public Iterable<Servico> findServicoByMultipleFields(String obj) {
        LinkedHashSet<Servico> possibleServicos = new LinkedHashSet<>();
        for (Catalogo c : catalogoController.findCatalogoDeColaborador()) {
            servicoRepository.findServicoByFields(obj, c).forEach(possibleServicos::add);
        }
        return possibleServicos;
    }
    
    public int allNumeroServicos(){
        return servicoRepository.allServicos();
    }

}
