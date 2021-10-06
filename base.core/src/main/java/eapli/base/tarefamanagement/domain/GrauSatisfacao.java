/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.tarefamanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Guilherme
 */
@Entity
public class GrauSatisfacao implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSatisfacao;

    @OneToOne(fetch = FetchType.LAZY)
    private Tarefa tarefaDeSatisfacao;

    private boolean satisfacao;

    private String comentario;

    public GrauSatisfacao() {

    }

    public GrauSatisfacao(Tarefa tarefa, boolean satis, String comentario) {
        if (tarefa == null) {
            throw new IllegalArgumentException("Tarefa do grau de satisfacao nao pode ser null ou vazia");
        }
        this.tarefaDeSatisfacao = tarefa;
        this.satisfacao = satis;
        this.comentario = comentario;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof GrauSatisfacao)) {
            return false;
        }

        final GrauSatisfacao that = (GrauSatisfacao) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }

    @Override
    public Long identity() {
        return this.idSatisfacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.idSatisfacao);
        hash = 41 * hash + Objects.hashCode(this.tarefaDeSatisfacao);
        hash = 41 * hash + (this.satisfacao ? 1 : 0);
        hash = 41 * hash + Objects.hashCode(this.comentario);
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
        final GrauSatisfacao other = (GrauSatisfacao) obj;
        if (this.satisfacao != other.satisfacao) {
            return false;
        }
        if (!Objects.equals(this.comentario, other.comentario)) {
            return false;
        }
        if (!Objects.equals(this.idSatisfacao, other.idSatisfacao)) {
            return false;
        }
        if (!Objects.equals(this.tarefaDeSatisfacao, other.tarefaDeSatisfacao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GrauSatisfacao{" + "idSatisfacao=" + idSatisfacao + ", tarefaDeSatisfacao=" + tarefaDeSatisfacao + ", satisfacao=" + satisfacao + ", comentario=" + comentario + '}';
    }

}
