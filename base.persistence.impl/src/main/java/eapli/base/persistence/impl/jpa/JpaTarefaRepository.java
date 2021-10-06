/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.NumeroMecanografico;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.tarefamanagement.DTO.TarefaDTO;
import eapli.base.tarefamanagement.application.ListTarefasController;
import eapli.base.tarefamanagement.domain.EstadoTarefa;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.repositories.TarefaRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Guilherme
 */
public class JpaTarefaRepository extends BasepaRepositoryBase<Tarefa, Long, Long> implements TarefaRepository {

    JpaTarefaRepository() {
        super("idTarefa");
    }

    @Override
    public Iterable<Tarefa> tarefasAutomaticasAvailableForExcecution() {
        List<Tarefa> ret = new ArrayList<>();
        final TypedQuery<Tarefa> q = createQuery("SELECT e FROM Tarefa e inner join e.workflowFromTarefa w inner join w.atividadeRealizacaoServico ar inner join e.pedidoTarefa ped WHERE ar.atividadeAutomatica IS NOT NULL and e.estadoTarefa = :state ORDER BY ped.dataSolicitacao",
                Tarefa.class);
        q.setParameter("state", EstadoTarefa.EM_EXECUCAO);
        ret.addAll(q.getResultList());
        
        //System.out.println(Arrays.toString( ret.toArray()));
        return ret;
    }

    @Override
    public int qtdTarefasManuaisAvailableForExcecutionbyID(String idColaborador) {
        Long idLong = Long.parseLong(idColaborador);
        EstadoTarefa estadoEmExecucao = EstadoTarefa.EM_EXECUCAO;
        final TypedQuery<Tarefa> q = createQuery("SELECT e FROM Tarefa e inner join e.workflowFromTarefa w inner join w.atividadeRealizacaoServico ar inner join ar.responsavelRealizacao rr WHERE rr IS NOT NULL and rr.idColaborador = :id AND e.EstadoTarefa = :estado",
                Tarefa.class);
        q.setParameter("id", idLong);
        q.setParameter("estado", estadoEmExecucao);
        return q.getResultList().size();
    }

    public boolean alterarEstadoTarefa(EstadoTarefa estado, String idTarefa) {
        Long id = Long.parseLong(idTarefa);

        try {
            final TypedQuery<Tarefa> q = createQuery("SELECT e FROM Tarefa e WHERE idTarefa = :idT",
                    Tarefa.class);
            q.setParameter("idT", id);
            Tarefa t = q.getSingleResult();
            t.changeEstadoTarefa(estado);

            this.save(t);
            return true;
        } catch (NoResultException nre) {
            return false;
        }

    }

    @Override
    public Iterable<Tarefa> tarefasPorExecutar() {
        final TypedQuery<Tarefa> q = createQuery("SELECT e FROM Tarefa e WHERE e.estadoTarefa = :state",
                Tarefa.class);
        q.setParameter("state", EstadoTarefa.EM_EXECUCAO);
        return q.getResultList();
    }

    @Override
    public Iterable<Tarefa> tarefasPorPrioridadeColaboradorAscendente(Colaborador colab) {
        System.out.println(colab.nomeCurto());
        final TypedQuery<Tarefa> q = createQuery("SELECT e FROM Tarefa e inner join e.workflowFromTarefa w inner join e.pedidoTarefa ped inner join w.atividadeRealizacaoServico ar WHERE e.estadoTarefa = :est AND ar.responsavelRealizacao = :sol ORDER BY ped.urgenciaPedido",
                Tarefa.class);
        q.setParameter("est", EstadoTarefa.EM_EXECUCAO);
        q.setParameter("sol", colab);
        return q.getResultList();
    }

    @Override
    public Iterable<Tarefa> tarefasPorPrioridadeColaboradorDescendente(Colaborador colab) {
        final TypedQuery<Tarefa> q = createQuery("SELECT e FROM Tarefa e inner join e.workflowFromTarefa w inner join w.atividadeRealizacaoServico ar inner join e.pedidoTarefa ped WHERE e.estadoTarefa = :est AND ar.responsavelRealizacao = :sol ORDER BY ped.urgenciaPedido DESC",
                Tarefa.class);
        q.setParameter("est", EstadoTarefa.EM_EXECUCAO);
        q.setParameter("sol", colab);
        return q.getResultList();
    }

    @Override
    public Iterable<Tarefa> tarefasPorCriticidadeColaboradorAscendente(Colaborador colab) {
        final TypedQuery<Tarefa> q = createQuery("SELECT e FROM Tarefa e inner join e.workflowFromTarefa w inner join w.atividadeRealizacaoServico ar inner join e.pedidoTarefa ped inner join ped.nivelCriticidade niv WHERE e.estadoTarefa = :est AND ar.responsavelRealizacao = :sol ORDER BY niv.valorCriticidade",
                Tarefa.class);
        q.setParameter("est", EstadoTarefa.EM_EXECUCAO);
        q.setParameter("sol", colab);
        return q.getResultList();
    }

    @Override
    public Iterable<Tarefa> tarefasPorCriticidadeColaboradorDescendente(Colaborador colab) {
        final TypedQuery<Tarefa> q = createQuery("SELECT e FROM Tarefa e inner join e.workflowFromTarefa w inner join w.atividadeRealizacaoServico ar inner join e.pedidoTarefa ped inner join ped.nivelCriticidade niv WHERE e.estadoTarefa = :est AND ar.responsavelRealizacao = :sol ORDER BY niv.valorCriticidade DESC",
                Tarefa.class);
        q.setParameter("est", EstadoTarefa.EM_EXECUCAO);
        q.setParameter("sol", colab);
        return q.getResultList();
    }

    @Override
    public Iterable<Tarefa> tarefasPorDataLimiteColaboradorAscendente(Colaborador colab) {
        final TypedQuery<Tarefa> q = createQuery("SELECT e FROM Tarefa e inner join e.workflowFromTarefa w inner join w.atividadeRealizacaoServico ar inner join e.pedidoTarefa ped WHERE e.estadoTarefa = :est AND ar.responsavelRealizacao = :sol ORDER BY ped.dataLimite DESC",
                Tarefa.class);
        q.setParameter("est", EstadoTarefa.EM_EXECUCAO);
        q.setParameter("sol", colab);
        return q.getResultList();
    }

    @Override
    public Iterable<Tarefa> tarefasPorDataLimiteColaboradorDescendente(Colaborador colab) {
        final TypedQuery<Tarefa> q = createQuery("SELECT e FROM Tarefa e inner join e.workflowFromTarefa w inner join w.atividadeRealizacaoServico ar inner join e.pedidoTarefa ped WHERE e.estadoTarefa = :est AND ar.responsavelRealizacao = :sol ORDER BY ped.dataLimite",
                Tarefa.class);
        q.setParameter("est", EstadoTarefa.EM_EXECUCAO);
        q.setParameter("sol", colab);
        return q.getResultList();
    }
    
    @Override
    public Iterable<Tarefa> tarefasPor(Colaborador colab, String criterio,boolean ascendente){
        String base = "SELECT e FROM Tarefa e inner join e.workflowFromTarefa w inner join w.atividadeRealizacaoServico  "
                + "ar inner join e.pedidoTarefa ped inner join ped.nivelCriticidade niv WHERE e.estadoTarefa = :est AND ar.responsavelRealizacao = :sol ";
        switch(criterio){
            case ListTarefasController.ORDENAR_DATA_LIMITE:
                base += "ORDER BY ped.dataLimite ";
                if(!ascendente)
                    base+= "DESC";
                break;
            case ListTarefasController.ORDENAR_CRITICIDADE:
                base += "ORDER BY niv.valorCriticidade ";
                if(!ascendente)
                    base+= "DESC";
                break;
            case ListTarefasController.ORDENAR_PRIORIDADE:
                base += "ORDER BY ped.urgenciaPedido ";
                if(!ascendente)
                    base+= "DESC";
                break;
            default:
                return null;
        }
        
        final TypedQuery<Tarefa> q = createQuery(base,Tarefa.class);
        q.setParameter("est", EstadoTarefa.EM_EXECUCAO);
        q.setParameter("sol", colab);
        return q.getResultList();
    }
    
    @Override
    public Iterable<Tarefa> tarefasPorFiltrado(Colaborador colab, String criterio,boolean ascendente,String criterioFiltro,String limiteInferior, String limiteSuperior){
        String base = "SELECT e FROM Tarefa e inner join e.workflowFromTarefa w inner join w.atividadeRealizacaoServico  "
                + "ar inner join e.pedidoTarefa ped inner join ped.nivelCriticidade niv WHERE e.estadoTarefa = :est AND ar.responsavelRealizacao = :sol ";
        switch(criterioFiltro){
            case ListTarefasController.FILTRAR_CRITICIDADE:
                if(!limiteInferior.isEmpty()){
                    base += "AND niv.valorCriticidade >=" + limiteInferior + " ";
                }
                if(!limiteSuperior.isEmpty()){
                    base += "AND niv.valorCriticidade <=" + limiteSuperior + " ";
                }
                break;
            case ListTarefasController.FILTRAR_PRIORIDADE:
                if(!limiteInferior.isEmpty()){
                    base += "AND ped.urgenciaPedido >=" + limiteInferior + " ";
                }
                if(!limiteSuperior.isEmpty()){
                    base += "AND ped.urgenciaPedido <=" + limiteSuperior + " ";
                }
                break;
            default:
                return null;
        }
        switch(criterio){
            case ListTarefasController.ORDENAR_DATA_LIMITE:
                base += "ORDER BY ped.dataLimite ";
                if(!ascendente)
                    base+= "DESC";
                break;
            case ListTarefasController.ORDENAR_CRITICIDADE:
                base += "ORDER BY niv.valorCriticidade ";
                if(!ascendente)
                    base+= "DESC";
                break;
            case ListTarefasController.ORDENAR_PRIORIDADE:
                base += "ORDER BY ped.urgenciaPedido ";
                if(!ascendente)
                    base+= "DESC";
                break;
            default:
                return null;
        }
        final TypedQuery<Tarefa> q = createQuery(base,Tarefa.class);
        q.setParameter("est", EstadoTarefa.EM_EXECUCAO);
        q.setParameter("sol", colab);
        return q.getResultList();
    }

    @Override
    public int numeroTarefasPendentesColaborador(String colabId) {

        NumeroMecanografico num = new NumeroMecanografico(colabId);
        
        try {
            final TypedQuery<Tarefa> q = createQuery("SELECT e FROM Tarefa e inner join e.workflowFromTarefa w inner join w.atividadeRealizacaoServico ar inner join e.pedidoTarefa ped inner join ar.responsavelRealizacao rr WHERE rr.nmrMecanografico = :colNum AND e.estadoTarefa = :est",
                    Tarefa.class);
            q.setParameter("est", EstadoTarefa.EM_EXECUCAO);
            q.setParameter("colNum", num);
            return q.getResultList().size();
        } catch (NoResultException nre) {
            return 0;
        }

    }

    @Override
    public int numeroTarefasNaoConcluidas(String colabId) {
        List<Tarefa> tarefas = new ArrayList<>();
        NumeroMecanografico num = new NumeroMecanografico(colabId);
        final TypedQuery<Tarefa> q = createQuery("SELECT e FROM Tarefa e inner join e.workflowFromTarefa w inner join w.atividadeRealizacaoServico ar inner join e.pedidoTarefa ped inner join ar.responsavelRealizacao rr WHERE e.estadoTarefa = :est AND rr.nmrMecanografico = :colNum",
                Tarefa.class);
        q.setParameter("est", EstadoTarefa.EM_EXECUCAO);
        q.setParameter("colNum", num);
        Date now = new Date();

        for (Tarefa t : q.getResultList()) {
            Pedido pedidoT = t.pedido();

            if (pedidoT.dataLimitePedido().dataLimiteAsData().before(now)) {
                tarefas.add(t);
            }

        }

        return tarefas.size();
    }

    @Override
    public int numeroTarefasTerminamEmBreve(String colabId) {
        List<Tarefa> tarefas = new ArrayList<>();
        NumeroMecanografico num = new NumeroMecanografico(colabId);
        final TypedQuery<Tarefa> q = createQuery("SELECT e FROM Tarefa e inner join e.workflowFromTarefa w inner join w.atividadeRealizacaoServico ar inner join e.pedidoTarefa ped inner join ar.responsavelRealizacao rr WHERE e.estadoTarefa = :est AND rr.nmrMecanografico = :colNum",
                Tarefa.class);
        q.setParameter("est", EstadoTarefa.EM_EXECUCAO);
        q.setParameter("colNum", num);
        Date now = new Date();

        for (Tarefa t : q.getResultList()) {
            Pedido pedidoT = t.pedido();
            long subTime = pedidoT.dataLimitePedido().dataLimiteAsData().getTime() - now.getTime();
            long subHours = (subTime / (1000));
            if (subHours <= 3600 && subHours > 0) {
                tarefas.add(t);
            }

        }

        return tarefas.size();
    }

    @Override
    public Iterable<Tarefa> tarefasDoColaboradorPorPrioridadeECriticadade(String colabId) {
         NumeroMecanografico num = new NumeroMecanografico(colabId);
        final TypedQuery<Tarefa> q = createQuery("SELECT e FROM Tarefa e inner join e.workflowFromTarefa w inner join w.atividadeRealizacaoServico ar inner join e.pedidoTarefa ped inner join ar.responsavelRealizacao rr inner join ped.nivelCriticidade niv WHERE e.estadoTarefa = :est AND rr.nmrMecanografico = :colNum ORDER BY ped.urgenciaPedido DESC, niv.valorCriticidade DESC",
                Tarefa.class);
        q.setParameter("est", EstadoTarefa.EM_EXECUCAO);
        q.setParameter("colNum", num);
        
        return q.getResultList();
    }
    
            @Override
    public int allTarefasAutomaticas() {

        final TypedQuery<Tarefa> q = createQuery("SELECT e FROM Tarefa e inner join e.workflowFromTarefa w inner join w.atividadeRealizacaoServico ar WHERE ar.atividadeAutomatica IS NOT NULL and e.estadoTarefa = :state",
                Tarefa.class);
        q.setParameter("state", EstadoTarefa.EM_EXECUCAO);
        
        return q.getResultList().size();
    }

    @Override
    public int allTarefasPendentes() {
        final TypedQuery<Tarefa> q = createQuery("SELECT e FROM Tarefa e WHERE e.estadoTarefa = :state",
                Tarefa.class);
        q.setParameter("state", EstadoTarefa.EM_EXECUCAO);
        
        return q.getResultList().size();
    }

    @Override
    public int allTarefas() {
        final TypedQuery<Tarefa> q = createQuery("SELECT e FROM Tarefa e",
                Tarefa.class);

        
        return q.getResultList().size();
    }

    @Override
    public Tarefa findTarefaByPedido(Pedido pedido) {
        try{
         final TypedQuery<Tarefa> q = createQuery("SELECT e FROM Tarefa e WHERE e.pedidoTarefa = :ped",
                Tarefa.class);
 
        q.setParameter("ped", pedido);
        return q.getSingleResult();
        }catch(NoResultException ex){
            return null;
        }
    }
    
    @Override
    public Iterable<Tarefa> availableTarefasExecucaoColaborador(Colaborador colaborador) {

        final TypedQuery<Tarefa> q = createQuery("SELECT e FROM Tarefa e inner join e.workflowFromTarefa w inner join w.atividadeRealizacaoServico ar WHERE ar.responsavelRealizacao = :colab AND e.estadoTarefa = :state",
                Tarefa.class);
        q.setParameter("state", EstadoTarefa.EM_EXECUCAO);
        q.setParameter("colab", colaborador);
        return q.getResultList();
    }

    @Override
    public Tarefa tarefaFromDTO(TarefaDTO tarefa) {
        final TypedQuery<Tarefa> q = createQuery("SELECT e FROM Tarefa e WHERE e.idTarefa = :idT",
                Tarefa.class);
        q.setParameter("idT", Long.parseLong(tarefa.idTarefa));
  
        return q.getSingleResult();
    }

    @Override
    public Iterable<Tarefa> tarefasExecutadasPeloColaborador(Colaborador colaborador) {
        try{
        final TypedQuery<Tarefa> q = createQuery("SELECT e FROM Tarefa e inner join e.pedidoTarefa ped inner join ped.servico ser inner join e.workflowFromTarefa w inner join w.atividadeRealizacaoServico ar WHERE ar.responsavelRealizacao = :colab AND e.estadoTarefa = :state AND ser.requerSatisfacao = :requer AND e.grauSatisfeito = :grau",
                Tarefa.class);
        q.setParameter("state", EstadoTarefa.EXECUTADA);
        q.setParameter("colab", colaborador);
        q.setParameter("requer", true);
        q.setParameter("grau", false);
        
        if(q.getResultList().isEmpty()){
            return null;
        }
        return q.getResultList(); 
        } catch(NoResultException ex){
            return null;
        }
           
    }
    
    @Override
    public Tarefa tarefaFromId(String idTarefa) {
        Long id = Long.parseLong(idTarefa);

        try {
            final TypedQuery<Tarefa> q = createQuery("SELECT e FROM Tarefa e WHERE idTarefa = :idT",
                    Tarefa.class);
            q.setParameter("idT", id);
            return q.getSingleResult();
            
        } catch (NoResultException nre) {
            return null;
        }
    }

}
