/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.domain.NomeFormulario;
import eapli.base.formulariomanagement.repositories.FormularioRepository;
import javax.persistence.TypedQuery;

/**
 *
 * @author lucas
 */
public class JpaFormularioRepository extends BasepaRepositoryBase<Formulario, Long, Long> implements FormularioRepository {

    JpaFormularioRepository() {
       super("identificadorUnico");
    }
    
    @Override
    public Formulario findFormularioByNome(String strFomularioServico) {
        NomeFormulario nomeFormulario = new  NomeFormulario(strFomularioServico);
        final TypedQuery<Formulario> q = createQuery("SELECT e FROM Formulario e WHERE e.nomeFormulario = :strFomularioServico",
                Formulario.class);
        q.setParameter("strFomularioServico", nomeFormulario);
        return q.getSingleResult();
    }
}

