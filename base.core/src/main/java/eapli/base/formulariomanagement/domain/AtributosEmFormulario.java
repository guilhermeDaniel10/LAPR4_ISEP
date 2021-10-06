/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.formulariomanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 *
 * @author lucas
 */
@Embeddable
public class AtributosEmFormulario implements ValueObject {
    
    @ManyToOne(optional = true)
    private final Atributo atributosEmFormulario;

    protected AtributosEmFormulario() {
        // for ORM only
        atributosEmFormulario = null;
    }
    
    public AtributosEmFormulario(final Atributo atributosEmFormulario) {
        Preconditions.nonNull(atributosEmFormulario);
        this.atributosEmFormulario = atributosEmFormulario;
    }

    public Atributo atributo() {
        return atributosEmFormulario;
    }
}
