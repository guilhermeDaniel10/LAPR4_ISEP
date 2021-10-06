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
public class DescCompletaCatalogo implements ValueObject {

    @Transient
    private final int limMaxCaracteresCompleta = 100;

    private String stringDescComp;
    
    @Transient
    private final String stringDescCompCatalogoPorOmissao = "Por adicionar...";

    public DescCompletaCatalogo(String stringDescComp) {
        if (StringPredicates.isNullOrEmpty(stringDescComp)) {
            this.stringDescComp = this.stringDescCompCatalogoPorOmissao;
        } else if (stringDescComp.length() > limMaxCaracteresCompleta) {
            this.stringDescComp = this.stringDescCompCatalogoPorOmissao;
        } else {
            this.stringDescComp = stringDescComp;
        }
    }

    public DescCompletaCatalogo() {
        //ORM
    }
    
    
    public boolean descCatalogoValido(){
        return !this.stringDescComp.equals(this.stringDescCompCatalogoPorOmissao);
    }
    
    public boolean correcaoDescCatalogo(String stringDescCompleta){
        if (StringPredicates.isNullOrEmpty(stringDescCompleta)) {
            return false;
        } else if (stringDescCompleta.length()>limMaxCaracteresCompleta) {
            return false;
        }
        this.stringDescComp = stringDescCompleta;
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
        if (!(o instanceof DescCompletaCatalogo)) {
            return false;
        }

        final DescCompletaCatalogo that = (DescCompletaCatalogo) o;
        return that.stringDescComp.equals(this.stringDescComp);
    }

    @Override
    public String toString() {
        return this.stringDescComp;
    }
}
