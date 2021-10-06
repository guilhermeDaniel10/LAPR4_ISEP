/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.catalogomanagement.domain;

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
public class TituloCatalogo implements ValueObject {
    
    private String stringTituloCatalogo;
    
    @Transient
    private final String stringTituloCatalogoPorOmissao = "Por adicionar...";
    
    public TituloCatalogo(String stringTituloCatalogo){
        if (StringPredicates.isNullOrEmpty(stringTituloCatalogo)) {
            this.stringTituloCatalogo = stringTituloCatalogoPorOmissao;
        } else {
            this.stringTituloCatalogo = stringTituloCatalogo;
        }
    }
    
    public TituloCatalogo() {
        //ORM
    }
    
    
    public boolean tituloCatalogoValido(){
        return !this.stringTituloCatalogo.equals(this.stringTituloCatalogoPorOmissao);
    }
    
    public boolean correcaoTituloCatalogo(String strTituloCatalogo){
        if (StringPredicates.isNullOrEmpty(strTituloCatalogo)) {
           return false;
        }
        this.stringTituloCatalogo = strTituloCatalogo;
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
        if (!(o instanceof TituloCatalogo)) {
            return false;
        }

        final TituloCatalogo that = (TituloCatalogo) o;
        return that.stringTituloCatalogo.equals(this.stringTituloCatalogo);
    }

    @Override
    public String toString() {
        return this.stringTituloCatalogo;
    }
}
