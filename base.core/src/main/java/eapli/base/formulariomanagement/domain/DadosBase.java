/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.formulariomanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author Guilherme
 */
public enum DadosBase {

    NUMERICO("[1-9]+[0-9]*"),
    TEXTO("([0-9]+|[a-zA-Z]+|\\(|\\)|\\[|\\]|\\+|\\*|\\-| )+"),
    DATA("((0[1-9])|([1-2][0-9])|(3[0-1]))/((0[1-9])|(1[0-2]))/(20[2-3][0-9])"),
    BOOLEANO("(true|false)"),
    FICHEIRO("([A-Za-z]|_|-|[0-9])+((\\.csv)|(\\.pdf)|(\\.txt))");

    private String expRegular;

    DadosBase(String expRegular) {
        this.expRegular = expRegular;
    }

    public String getExpRegular() {
        return this.expRegular;
    }

    public void setExprRegular(String exp) {
        this.expRegular = exp;
    }
}
