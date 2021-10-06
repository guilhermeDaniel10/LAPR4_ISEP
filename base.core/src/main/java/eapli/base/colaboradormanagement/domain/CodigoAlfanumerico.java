/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.colaboradormanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author Guilherme
 */
@Embeddable
public class CodigoAlfanumerico implements ValueObject,Comparable<CodigoAlfanumerico> {
    
    private String codigo;
    

    public CodigoAlfanumerico() {
    }
    
    public CodigoAlfanumerico(String codigo){
        if(StringPredicates.isNullOrEmpty(codigo)){
            throw new IllegalArgumentException("Codigo alfanumerico nao pode ser null ou vazio");
        }
        
        this.codigo = codigo;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.codigo);
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
        final CodigoAlfanumerico other = (CodigoAlfanumerico) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return "Codigo alfanumérico: " + codigo;
    }

    @Override
    public int compareTo(CodigoAlfanumerico arg0) {
        return this.compareTo(arg0);
    }
    
}
