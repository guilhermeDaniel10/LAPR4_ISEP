/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.colaboradormanagement.repositories.ColaboradorRepository;
import eapli.base.cor.domain.Cor;
import eapli.base.cor.repositories.CorRepository;

/**
 *
 * @author Guilherme
 */
public class JpaCorRepository extends BasepaRepositoryBase<Cor, String, String> implements CorRepository{
    JpaCorRepository(){
        super("designacaoCor");
    }
}
