/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.colaboradormanagement.domain;

import eapli.framework.strings.util.StringPredicates;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;


@Embeddable
public class EmailInstitucional implements Serializable {

    private String endereco;

    public EmailInstitucional(String endereco) {
        if(StringPredicates.isNullOrEmpty(endereco)){
            throw new IllegalArgumentException("Endereco de email nao pode ser null ou vazio");
        }
        if(!StringPredicates.isEmail(endereco)){
            throw new IllegalArgumentException("Email inválido.");
        }
        this.endereco = endereco;
    }

    
    protected EmailInstitucional(){
        
    }
    
    @Override
    public boolean equals(final Object o){
        if(this == o){
            return true;
        }
        if(!(o instanceof EmailInstitucional)){
            return false;
        }
        
        final EmailInstitucional that = (EmailInstitucional) o;
        return this.endereco.equals(that.endereco);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.endereco);
        return hash;
    }

    @Override
    public String toString() {
        return "Email Institucional: " + endereco;
    }
    
    public String emailAsUserEmail(){
        return this.endereco;
    }
    
    
}
