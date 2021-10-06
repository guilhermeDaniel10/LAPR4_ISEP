/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.bibliotecaatividades.domain.Atividade;
import eapli.base.bibliotecaatividades.repositories.BibliotecaAtividadesRepository;

/**
 *
 * @author Guilherme
 */
public class JpaAtividadeRepository extends BasepaRepositoryBase<Atividade, Long, Long> implements BibliotecaAtividadesRepository  {
    JpaAtividadeRepository(){
        super("identificadorAtividade");
    }
}
