/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.objetivosmanagement.domain.Objetivos;
import eapli.base.objetivosmanagement.repositories.ObjetivosRepository;


/**
 *
 * @author rui3m
 */
public class JpaObjetivosRepository extends BasepaRepositoryBase<Objetivos, Long, Long> implements ObjetivosRepository{
    JpaObjetivosRepository(){
        super("idObjetivos");
    }
}
