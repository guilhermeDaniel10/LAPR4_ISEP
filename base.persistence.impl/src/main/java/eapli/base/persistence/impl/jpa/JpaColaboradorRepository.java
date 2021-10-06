/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.DescCompletaCatalogo;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.EmailInstitucional;
import eapli.base.colaboradormanagement.domain.EquipasColaborador;
import eapli.base.colaboradormanagement.domain.NumeroMecanografico;
import eapli.base.colaboradormanagement.repositories.ColaboradorRepository;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.tarefamanagement.domain.Tarefa;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Guilherme
 */
public class JpaColaboradorRepository extends BasepaRepositoryBase<Colaborador, Long, Long> implements ColaboradorRepository {

    JpaColaboradorRepository() {
        super("idColaborador");
    }

    @Override
    public Colaborador findColaboradorByNum(NumeroMecanografico nmR) {

        final TypedQuery<Colaborador> q = createQuery("SELECT e FROM Colaborador e WHERE e.nmrMecanografico = :num",
                Colaborador.class);
        q.setParameter("num", nmR);
        return q.getSingleResult();
    }

    @Override
    public Iterable<Colaborador> findColaboradoresByEquipa(Equipa equipa) {
        EquipasColaborador eqColab = new EquipasColaborador(equipa);

        try {
            final TypedQuery<Colaborador> q = createQuery("SELECT e FROM Colaborador e WHERE :equipas member of e.equipas",
                    Colaborador.class);
            q.setParameter("equipas", eqColab);
            return q.getResultList();

        } catch (NoResultException e) {
            return null;
        }
    }

}
