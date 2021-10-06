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
import javax.persistence.Transient;

/**
 *
 * @author lucas
 */
@Embeddable
public class DescBreveServico implements ValueObject {
    
    private String stringDescBreveServico;
    
    @Transient
    private final int limMaxCaracteresServico = 40;
   
    @Transient
    private final String stringDescBreveServicoPorOmissao = "Por adicionar...";
    
    public DescBreveServico(String stringDescBreveServico){
        if (StringPredicates.isNullOrEmpty(stringDescBreveServico)) {
            this.stringDescBreveServico = this.stringDescBreveServicoPorOmissao;
        } else if (stringDescBreveServico.length() > limMaxCaracteresServico) {
            this.stringDescBreveServico = this.stringDescBreveServicoPorOmissao;
        } else {
            this.stringDescBreveServico = stringDescBreveServico;
        }
    }
    
    public boolean descBreveServicoValido(){
        return !this.stringDescBreveServico.equals(this.stringDescBreveServicoPorOmissao);
    }
    
    public boolean correcaoDescBreveServico(String stringDescBreveServico){
        if (StringPredicates.isNullOrEmpty(stringDescBreveServico)) {
            return false;
        } else if (stringDescBreveServico.length() > this.limMaxCaracteresServico) {
            return false;
        }
        this.stringDescBreveServico = stringDescBreveServico;
        return true;
    }
    
    public DescBreveServico() {
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
        if (!(o instanceof DescBreveServico)) {
            return false;
        }

        final DescBreveServico that = (DescBreveServico) o;
        return that.stringDescBreveServico.equals(this.stringDescBreveServico);
    }

    @Override
    public String toString() {
        return this.stringDescBreveServico;
    }
    
}
