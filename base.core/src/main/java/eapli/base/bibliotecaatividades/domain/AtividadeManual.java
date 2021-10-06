/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.bibliotecaatividades.domain;

import eapli.base.formulariomanagement.domain.Formulario;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
/**
 *
 * @author rui3m
 */
@Entity
public class AtividadeManual extends Atividade{
    
    @OneToOne(optional = false, cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
    private Formulario formulario;
    
     public AtividadeManual() {

    }

    public AtividadeManual(AtividadesExistentes tipoAtividade, Formulario formulario) {
        super(tipoAtividade);
        this.formulario = formulario;
    }
    
    public AtividadeManual(AtividadeManual atividade){
        this.formulario = atividade.formulario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.formulario);
        return hash;
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
        final AtividadeManual other = (AtividadeManual) obj;
        if (!Objects.equals(this.formulario, other.formulario)) {
            return false;
        }
        return true;
    }
    
    public Formulario formularioRealizacaoManual(){
        return this.formulario;
    }

    @Override
    public String toString() {
        return "AtividadeManual{" + "formulario=" + formulario + '}';
    }

}
