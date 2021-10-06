/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.servicomanagement.domain.AtividadeAprovacao;
import eapli.base.servicomanagement.repositories.AtividadeAprovacaoRepository;

/**
 *
 * @author lucas
 */
public class JpaAtividadeAprovacaoRepository extends BasepaRepositoryBase<AtividadeAprovacao, Long, Long> implements AtividadeAprovacaoRepository{
    
    JpaAtividadeAprovacaoRepository(){
        super("idAtividadeAprovacao");
    }
    
}
