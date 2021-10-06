/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.NomeVariavel;
import eapli.base.formulariomanagement.repositories.AtributoRepository;
import javax.persistence.TypedQuery;

/**
 *
 * @author lucas
 */
public class JpaAtributoRepository extends BasepaRepositoryBase<Atributo, Long, Long> implements AtributoRepository {
    JpaAtributoRepository(){
        super("identificador");
    }

    @Override
    public Atributo findAtributoByNome(String strNomeVariavel) {
        NomeVariavel nomeVariavel = new NomeVariavel(strNomeVariavel);
        final TypedQuery<Atributo> q = createQuery("SELECT e FROM Atributo e WHERE e.nomeVariavel = :strNomeVariavel",
                Atributo.class);
        q.setParameter("strNomeVariavel", nomeVariavel);
        return q.getSingleResult();
    }
}
