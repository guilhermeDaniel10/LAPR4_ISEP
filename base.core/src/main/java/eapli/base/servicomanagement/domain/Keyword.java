/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.servicomanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.strings.util.StringPredicates;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author lucas
 */
@Entity
public class Keyword implements AggregateRoot<Long> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long identificadorKeyword;

    private String stringKeywordServico;
    
    @Transient
    private final String illegallChars = "{@-+,\'/*!#$%&()=?»«:_;><|}";
    
    public Keyword(String stringKeywordServico){
        if (StringPredicates.isNullOrEmpty(stringKeywordServico)) {
            throw new IllegalArgumentException("A keyword do Servico nao pode ser vazio/nulo");
        } else if (StringPredicates.containsDigit(stringKeywordServico)) {
            throw new IllegalArgumentException("Uma keyword não é alfanumérica");
        } else if (StringPredicates.containsAny(stringKeywordServico,illegallChars)) {
            throw new IllegalArgumentException("Caracteres especiais nao entram em Keywords");
        } else if (!StringPredicates.isSingleWord(stringKeywordServico)) {
            throw new IllegalArgumentException("Uma keyword é só uma palavra");
        }
        this.stringKeywordServico = stringKeywordServico;
    }
    
    public boolean correcaoKeywordServico(String stringKeywordServico){
        if (StringPredicates.isNullOrEmpty(stringKeywordServico)) {
            return false;
        }
        this.stringKeywordServico = stringKeywordServico;
        return true;
    }
    
    public Keyword() {
        //ORM
    }

    @Override
    public String toString() {
        return this.stringKeywordServico;
    }

    @Override
    public Long identity() {
        return this.identificadorKeyword;
    }
    
    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Keyword)) {
            return false;
        }

        final Keyword that = (Keyword) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity())
               && this.stringKeywordServico.equals(that.stringKeywordServico);
    }

    
}
