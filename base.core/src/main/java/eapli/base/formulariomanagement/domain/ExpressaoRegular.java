/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.formulariomanagement.domain;

import eapli.framework.strings.util.StringPredicates;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author Guilherme
 */
@Embeddable
public class ExpressaoRegular {

    private String expressao;

    public ExpressaoRegular() {
        //ORM
    }

    public ExpressaoRegular(String expressao) {
        if (StringPredicates.isNullOrEmpty(expressao)) {
            throw new IllegalArgumentException("Expressao Regular nao pode ser null ou vazia");
        }
        this.expressao = expressao;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.expressao);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExpressaoRegular other = (ExpressaoRegular) obj;
        if (!Objects.equals(this.expressao, other.expressao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Expressao Regular: " + expressao;
    }
    

    public String toStringOnlyExpressao() {
        return expressao;
    }

}
