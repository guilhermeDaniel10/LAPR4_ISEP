/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.servicomanagement.domain.Keyword;
import eapli.base.servicomanagement.repositories.KeywordRepository;

/**
 *
 * @author lucas
 */
public class JpaKeywordRepository  extends BasepaRepositoryBase<Keyword, Long, Long> implements KeywordRepository {
    
    JpaKeywordRepository() {
       super("identificadorUnico");
    }
    
}
