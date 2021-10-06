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
public class DescBreveCatalogo implements ValueObject {
    
    @Transient
    private final int limMaxCaracteres = 40;
    
    private String stringDescBreve;
    
    @Transient
    private final String stringDescBreveCatalogoPorOmissao = "Por adicionar...";
    
    public DescBreveCatalogo(String stringDescBreve){
        if (StringPredicates.isNullOrEmpty(stringDescBreve)) {
            this.stringDescBreve = this.stringDescBreveCatalogoPorOmissao;
        } else if (stringDescBreve.length()>limMaxCaracteres) {
            this.stringDescBreve = this.stringDescBreveCatalogoPorOmissao;
        } else {
            this.stringDescBreve = stringDescBreve;
        }
    }
    
    public boolean descCatalogoValido(){
        return !this.stringDescBreve.equals(this.stringDescBreveCatalogoPorOmissao);
    }
    
    public boolean correcaoDescCatalogo(String stringDescBreve){
        if (StringPredicates.isNullOrEmpty(stringDescBreve)) {
            return false;
        } else if (stringDescBreve.length()>limMaxCaracteres) {
            return false;
        }
        this.stringDescBreve = stringDescBreve;
        return true;
    }
    
    public DescBreveCatalogo() {
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
        if (!(o instanceof DescBreveCatalogo)) {
            return false;
        }

        final DescBreveCatalogo that = (DescBreveCatalogo) o;
        return that.stringDescBreve.equals(this.stringDescBreve);
    }

    @Override
    public String toString() {
        return this.stringDescBreve;
    }
    
}
