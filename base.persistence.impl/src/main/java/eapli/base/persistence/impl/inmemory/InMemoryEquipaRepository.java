/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.inmemory;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.equipamanagement.repositories.EquipaRepository;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.tipoequipamanagement.domain.TipoEquipa;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public class InMemoryEquipaRepository extends InMemoryDomainRepository<Equipa, Long> implements EquipaRepository{

    @Override
    public Iterable<Equipa> equipasTipoDiferente(Iterable<TipoEquipa> tiposEquipa) {
        List<TipoEquipa> list = new ArrayList<>((Collection<? extends TipoEquipa>) tiposEquipa);
        return match(e -> !list.contains(e.tipoEquipa()));
    }

    @Override
    public Equipa equipaPorAcronimo(String acronimo) {
        return matchOne(e -> e.acronimoEquipa().acronimoValidoDaEquipa().equals(acronimo)).get();
    }

}
