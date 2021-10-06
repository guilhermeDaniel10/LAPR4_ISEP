/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.bibliotecaatividades.domain;

import eapli.framework.domain.model.AggregateRoot;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Guilherme
 */
@MappedSuperclass
public class Atividade implements AggregateRoot<Long> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificadorAtividade;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AtividadesExistentes tipoAtividade;
    
//    @Column(nullable = false)
//    private Date dataLimite;
    
    public Atividade(){
        
    }
    
    public Atividade(AtividadesExistentes tipoAtividade){
        this.tipoAtividade = tipoAtividade;
 
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Atividade)) {
            return false;
        }

        final Atividade that = (Atividade) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity()) 
                && this.tipoAtividade.equals(that.tipoAtividade);
    }

    @Override
    public Long identity() {
        return this.identificadorAtividade;
    }
    
    
}
