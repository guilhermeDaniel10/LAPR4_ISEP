/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.bibliotecaatividades.domain;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;

/**
 *
 * @author Guilherme
 */
@Entity
public class AtividadeAutomatica extends Atividade {

    //private Integer prioridade;
    private ScriptAutomatico script;

    public AtividadeAutomatica() {

    }

    public AtividadeAutomatica(AtividadesExistentes tipoAtividade, ScriptAutomatico script) {
        super(tipoAtividade);
        //this.prioridade = prioridade;
        this.script = script;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.script);
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
        final AtividadeAutomatica other = (AtividadeAutomatica) obj;
        if (!Objects.equals(this.script, other.script)) {
            return false;
        }
        return true;
    }

    public ScriptAutomatico scriptAutomatico() {
        return this.script;
    }

    @Override
    public String toString() {
        return "AtividadeAutomatica{" + "script=" + script + '}';
    }

}
