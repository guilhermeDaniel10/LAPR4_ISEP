/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.colaboradormanagement.domain.CodigoAlfanumerico;
import eapli.base.colaboradormanagement.domain.Funcao;
import eapli.base.colaboradormanagement.repositories.FuncaoRepository;

/**
 *
 * @author Guilherme
 */
public class JpaFuncaoRepository extends BasepaRepositoryBase<Funcao, Long, Long> implements FuncaoRepository{
    JpaFuncaoRepository(){
        super("identificadorFuncao");
    }
}
