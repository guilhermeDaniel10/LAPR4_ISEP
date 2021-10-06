/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.respostaformularios.domain.RespostaFormulario;
import eapli.base.respostaformularios.repositories.RespostaFormularioRepository;
import javax.persistence.TypedQuery;

/**
 *
 * @author Guilherme
 */
public class JpaRespostaFormularioRepository extends BasepaRepositoryBase<RespostaFormulario, Long, Long> implements RespostaFormularioRepository {

    JpaRespostaFormularioRepository() {
        super("idRespostaForm");
    }

    @Override
    public RespostaFormulario findRespostaFormularioById(Long id) {

        final TypedQuery<RespostaFormulario> q = createQuery("SELECT e FROM RespostaFormulario e WHERE e.idRespostaForm = :idR",
                RespostaFormulario.class);
        q.setParameter("idR", id);

        return q.getSingleResult();
    }

    @Override
    public RespostaFormulario findRespostaFormularioByNomeForm(String nome) {
        String nomeEmResp = "REP_" + nome;
        
        final TypedQuery<RespostaFormulario> q = createQuery("SELECT e FROM RespostaFormulario e WHERE e.identificadorRespostaPorFormulario = :idR",
                RespostaFormulario.class);
        q.setParameter("idR", nomeEmResp);

        return q.getSingleResult();
    }
}
