/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.tarefamanagement.domain;

/**
 *
 * @author Guilherme
 */
public enum EstadoTarefa {
    EM_EXECUCAO("Em execucao"), EXECUTADA("Executada"), ATRASADA("Atrasada"), EM_ESPERA("Em_espera"), NO_EXECUTOR("No_executor");
    
    private String estado;
    
    EstadoTarefa(String estado){
        this.estado = estado;
    }
  
    public String getEstado() {
        return this.estado;
    }
}
