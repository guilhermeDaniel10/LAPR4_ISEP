/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.formulariomanagement.repositories;

import eapli.base.formulariomanagement.domain.Atributo;
import eapli.framework.domain.repositories.DomainRepository;

/**
 *
 * @author lucas
 */
public interface AtributoRepository  extends DomainRepository<Long,Atributo> {
    
    Atributo findAtributoByNome(String strNomeVariavel);
    
}
