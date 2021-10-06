/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.equipamanagement.repositories;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.tipoequipamanagement.domain.TipoEquipa;
import eapli.framework.domain.repositories.DomainRepository;

/**
 *
 * @author Guilherme
 */
public interface EquipaRepository extends DomainRepository<Long, Equipa>{

    public Iterable<Equipa> equipasTipoDiferente(Iterable<TipoEquipa> tiposEquipa);
    
    public Equipa equipaPorAcronimo(String acronimo);
           
}
