/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.servicomanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 *
 * @author lucas
 */
@Embeddable
public class KeywordsEmServico implements ValueObject {
    
    @ManyToOne(optional = true)
    private final Keyword keywordsEmServico;

    protected KeywordsEmServico() {
        // for ORM only
        keywordsEmServico = null;
    }
    
    public KeywordsEmServico(final Keyword keywordEmServico) {
        Preconditions.nonNull(keywordEmServico);
        this.keywordsEmServico = keywordEmServico;
    }

    public Keyword keyword() {
        return keywordsEmServico;
    }
    
}
