/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.cor.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.strings.util.StringPredicates;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Guilherme
 */
@Entity
public class Cor implements AggregateRoot<String>{
    
    @Id
    @Column(name = "designacaoCor")
    private String designacaoCor;
    
    @Column(nullable = false, name = "codigoCor")
    private CodigoCor codigoCor;
    
    public Cor(){
        
    }
    
    public Cor(String designacaoCor, CodigoCor codigoCor){
        if(StringPredicates.isNullOrEmpty(designacaoCor) && codigoCor == null){
            throw new IllegalArgumentException();
        }
        this.designacaoCor = designacaoCor;
        this.codigoCor = codigoCor;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Cor)) {
            return false;
        }

        final Cor that = (Cor) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity()) 
                && this.codigoCor.equals(that.codigoCor);
    }

    @Override
    public String identity() {
        return this.designacaoCor;
    }

    public CodigoCor codigoCor(){
        return this.codigoCor;
    }

    @Override
    public String toString() {
        return "Cor{" + "designacaoCor=" + designacaoCor + '}';
    }   
    
}
