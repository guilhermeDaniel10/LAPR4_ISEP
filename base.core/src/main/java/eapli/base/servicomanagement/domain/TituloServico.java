/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.servicomanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author lucas
 */
@Embeddable
public class TituloServico implements ValueObject {
    
    private String tituloServico;
    
    public TituloServico(String stringTituloServico){
        if (StringPredicates.isNullOrEmpty(stringTituloServico)) {
            throw new IllegalArgumentException("O titulo do Servico nao pode ser vazio/nulo");
        }
        this.tituloServico = stringTituloServico.toLowerCase();
    }
    
    public TituloServico() {
        //ORM
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TituloServico)) {
            return false;
        }

        final TituloServico that = (TituloServico) o;
        return that.tituloServico.equals(this.tituloServico);
    }

    @Override
    public String toString() {
        return this.tituloServico;
    }
    
}
