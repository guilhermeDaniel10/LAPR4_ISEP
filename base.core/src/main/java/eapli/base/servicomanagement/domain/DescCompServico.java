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
public class DescCompServico implements ValueObject {
    
    private String stringDescCompServico;
    
    @Transient
    private final int limMaxCaracteresDescCompletaServico = 100;
    
    @Transient
    private final String stringDescCompServicoPorOmissao = "Por adicionar...";

    public DescCompServico(String stringDescCompServico) {
        if (StringPredicates.isNullOrEmpty(stringDescCompServico)) {
            this.stringDescCompServico = this.stringDescCompServicoPorOmissao;
        } else if (stringDescCompServico.length() > this.limMaxCaracteresDescCompletaServico) {
            this.stringDescCompServico = this.stringDescCompServicoPorOmissao;
        } else {
            this.stringDescCompServico = stringDescCompServico;
        }
    }

    public DescCompServico() {
        //ORM
    }
    
    
    public boolean descCompServicoValido(){
        return !this.stringDescCompServico.equals(this.stringDescCompServicoPorOmissao);
    }
    
    public boolean correcaoDescCompServico(String stringDescCompServico){
        if (StringPredicates.isNullOrEmpty(stringDescCompServico)) {
            return false;
        } else if (stringDescCompServico.length() > this.limMaxCaracteresDescCompletaServico) {
            return false;
        }
        this.stringDescCompServico = stringDescCompServico;
        return true;
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
        if (!(o instanceof DescCompServico)) {
            return false;
        }

        final DescCompServico that = (DescCompServico) o;
        return that.stringDescCompServico.equals(this.stringDescCompServico);
    }

    @Override
    public String toString() {
        return this.stringDescCompServico;
    }
}
