/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.EquipasComAcessoCatalogo;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipamanagement.domain.AcronimoEquipa;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.equipamanagement.repositories.EquipaRepository;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.tipoequipamanagement.domain.TipoEquipa;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.TypedQuery;

/**
 *
 * @author Guilherme
 */
public class JpaEquipaRepository extends BasepaRepositoryBase<Equipa, Long, Long> implements EquipaRepository {

    JpaEquipaRepository() {
        super("codigoUnico");
    }

    @Override
    public Iterable<Equipa> equipasTipoDiferente(Iterable<TipoEquipa> tiposEquipa) {
        final Map<String, Object> params = new HashMap<>();
        params.put("tipoequipa", tiposEquipa);
        return match("e.tipoEquipa NOT IN (:tipoequipa)", params);
    }

    @Override
    public Equipa equipaPorAcronimo(String acronimo) {
        AcronimoEquipa ae = new AcronimoEquipa(acronimo);
        final TypedQuery<Equipa> q = createQuery("SELECT e FROM Equipa e WHERE e.acronimo = :acr",
                Equipa.class);
        q.setParameter("acr", ae);

        return q.getSingleResult();
    }
}
