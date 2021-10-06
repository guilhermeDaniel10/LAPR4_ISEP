/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.tarefamanagement.domain.GrauSatisfacao;
import eapli.base.tarefamanagement.repositories.GrauSatisfacaoRepository;

/**
 *
 * @author Guilherme
 */
public class JpaGrauSatisfacaoRepository extends BasepaRepositoryBase<GrauSatisfacao, Long, Long> implements GrauSatisfacaoRepository {
    JpaGrauSatisfacaoRepository(){
        super("idSatisfacao");
    }
}
