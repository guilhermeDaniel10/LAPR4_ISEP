/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.slamanagement.domain.Designacao;
import eapli.base.slamanagement.domain.EtiquetaCriticidade;
import eapli.base.slamanagement.repositories.SLARepository;
import eapli.base.slamanagement.domain.NivelCriticidade;
import javax.persistence.TypedQuery;

/**
 *
 * @author rui3m
 */
public class JpaSLARepository extends BasepaRepositoryBase<NivelCriticidade, Long, Long> implements SLARepository{
    
    JpaSLARepository(){
        super("idNivelCriticidade");
    }

    @Override
    public NivelCriticidade findCriticidadeByEtiqueta(String etiqueta) {
        EtiquetaCriticidade etiquetaCriticidade = new EtiquetaCriticidade(etiqueta);
        final TypedQuery<NivelCriticidade> q = createQuery("SELECT e FROM NivelCriticidade e WHERE e.etiquetaCriticidade = :etiqueta",
                NivelCriticidade.class);
        q.setParameter("etiqueta", etiquetaCriticidade);
        return q.getSingleResult();
    }
}
