/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.tarefamanagement.domain;

import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.tarefamanagement.DTO.TarefaDTO;
import eapli.framework.domain.model.AggregateRoot;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Guilherme
 */
@Entity
public class Tarefa implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarefa;

    @OneToOne(fetch = FetchType.LAZY)
    private Pedido pedidoTarefa;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoTarefa estadoTarefa;
    
 
    @ManyToOne(fetch = FetchType.LAZY)
    private Workflow workflowFromTarefa;
    
    @Column(nullable = true)
    private boolean grauSatisfeito;

    protected Tarefa() {

    }

    public Tarefa(Pedido pedido, EstadoTarefa estadoTarefa, Workflow workflow) {
        this.pedidoTarefa = pedido;
        this.estadoTarefa = estadoTarefa;
        this.workflowFromTarefa = workflow;
    }
    
    public EstadoTarefa estadoEmQueSeEncontraTarefa(){
        return this.estadoTarefa;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Tarefa)) {
            return false;
        }

        final Tarefa that = (Tarefa) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idTarefa);
        hash = 53 * hash + Objects.hashCode(this.pedidoTarefa);
        hash = 53 * hash + Objects.hashCode(this.estadoTarefa);
        hash = 53 * hash + Objects.hashCode(this.workflowFromTarefa);
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
        final Tarefa other = (Tarefa) obj;
        if (!Objects.equals(this.idTarefa, other.idTarefa)) {
            return false;
        }
        if (!Objects.equals(this.pedidoTarefa, other.pedidoTarefa)) {
            return false;
        }
        if (this.estadoTarefa != other.estadoTarefa) {
            return false;
        }
        if (!Objects.equals(this.workflowFromTarefa, other.workflowFromTarefa)) {
            return false;
        }
        return true;
    }
    
    
    public void changeWorkflowTarefa(Workflow wTarefa){
        this.workflowFromTarefa = wTarefa;
    }
    
    @Override
    public Long identity() {
        return this.idTarefa;
    }

    public Pedido pedido() {
        return this.pedidoTarefa;
    }
    
    public EstadoTarefa estadoTarefa(){
        return this.estadoTarefa;
    }

    public void changeEstadoTarefa(EstadoTarefa estado) {
        this.estadoTarefa = estado;
    }
    
    public Workflow workflowTarefa(){
        return this.workflowFromTarefa;
    }
    
    public TarefaDTO tarefaToDTO(){
        return new TarefaDTO(String.valueOf(this.idTarefa), this.pedidoTarefa.servicoDoPedido().name().toString(), this.pedidoTarefa.dataLimitePedido().dataLimiteAsData(), this.pedidoTarefa.criticidadePedido().toStringExcerto(), this.pedidoTarefa.urgenciaDoPedido(), this.pedidoTarefa.solicitadorServico().nomeCurto().toString());
    }
    
    public void setGrauSatisfeito(boolean grauSatis){
        this.grauSatisfeito = grauSatis;
    }

    @Override
    public String toString() {
        return "Tarefa{" + "idTarefa=" + idTarefa + ", pedidoTarefa=" + pedidoTarefa + ", estadoTarefa=" + estadoTarefa + ", workflowFromTarefa=" + workflowFromTarefa + '}';
    }
    
    

}
