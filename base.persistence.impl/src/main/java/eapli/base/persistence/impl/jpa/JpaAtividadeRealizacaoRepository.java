/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.servicomanagement.domain.AtividadeRealizacao;
import eapli.base.servicomanagement.repositories.AtividadeRealizacaoRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author lucas
 */
public class JpaAtividadeRealizacaoRepository extends BasepaRepositoryBase<AtividadeRealizacao, Long, Long> implements AtividadeRealizacaoRepository {

    JpaAtividadeRealizacaoRepository() {
        super("idAtividadeRealizacao");
    }

    @Override
    public Iterable<AtividadeRealizacao> atividadesRealizacaoEquipas(Iterable<Equipa> equipas) {
        List<AtividadeRealizacao> listAtividades = new ArrayList<>();

        for (Equipa eq : equipas) {
            try {
                final TypedQuery<AtividadeRealizacao> q = createQuery("SELECT e FROM AtividadeRealizacao e WHERE e.responsaveisRealizacao = :eqr",
                        AtividadeRealizacao.class);
                q.setParameter("eqr", eq);

                listAtividades.addAll(q.getResultList());
            } catch (NoResultException nre) {
                System.out.println("NO RESULT");
            }
        }
        return listAtividades;
    }

}
