package eapli.base.persistence.impl.inmemory;

import eapli.base.bibliotecaatividades.domain.Atividade;
import eapli.base.bibliotecaatividades.repositories.BibliotecaAtividadesRepository;
import eapli.base.catalogomanagement.repositories.CatalogoRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.colaboradormanagement.repositories.ColaboradorRepository;
import eapli.base.colaboradormanagement.repositories.FuncaoRepository;
import eapli.base.infrastructure.bootstrapers.BaseBootstrapper;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.cor.repositories.CorRepository;
import eapli.base.equipamanagement.repositories.EquipaRepository;
import eapli.base.formulariomanagement.repositories.AtributoRepository;
import eapli.base.formulariomanagement.repositories.FormularioRepository;
import eapli.base.objetivosmanagement.repositories.ObjetivosRepository;
import eapli.base.pedidomanagement.repositories.PedidoRepository;
import eapli.base.respostaformularios.repositories.RespostaFormularioRepository;
import eapli.base.scriptmanagement.domain.Script;
import eapli.base.scriptmanagement.repositories.ScriptRepository;
import eapli.base.servicomanagement.repositories.AtividadeAprovacaoRepository;
import eapli.base.servicomanagement.repositories.AtividadeRealizacaoRepository;
import eapli.base.servicomanagement.repositories.KeywordRepository;
import eapli.base.servicomanagement.repositories.ServicoRepository;
import eapli.base.servicomanagement.repositories.WorkflowRepository;
import eapli.base.slamanagement.repositories.SLARepository;
import eapli.base.tarefamanagement.repositories.GrauSatisfacaoRepository;
import eapli.base.tarefamanagement.repositories.TarefaRepository;
import eapli.base.tipoequipamanagement.repositories.TipoEquipaRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.InMemoryUserRepository;

/**
 *
 * Created by nuno on 20/03/16.
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

    static {
        // only needed because of the in memory persistence
        new BaseBootstrapper().execute();
    }

    @Override
    public UserRepository users(final TransactionalContext tx) {
        return new InMemoryUserRepository();
    }

    @Override
    public UserRepository users() {
        return users(null);
    }

    @Override
    public ClientUserRepository clientUsers(final TransactionalContext tx) {

        return new InMemoryClientUserRepository();
    }

    @Override
    public ClientUserRepository clientUsers() {
        return clientUsers(null);
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return signupRequests(null);
    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext tx) {
        return new InMemorySignupRequestRepository();
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        // in memory does not support transactions...
        return null;
    }

    @Override
    public ColaboradorRepository colaboradores() {
        return new InMemoryColaboradorRepository();
    }

    @Override
    public FuncaoRepository funcoes() {
        return new InMemoryFuncaoRepository();
    }

    @Override
    public CatalogoRepository catalogo() {
        return new InMemoryCatalogoRepository();
    }

    @Override
    public CorRepository cor() {
        return new InMemoryCorRepository();
    }

    @Override
    public TipoEquipaRepository tipoEquipa() {
        return new InMemoryTipoEquipaRepository();
    }

    @Override
    public EquipaRepository equipa() {
        return new InMemoryEquipaRepository();
    }
    
    @Override
    public ServicoRepository servico() {
        return new InMemoryServicoRepository();
    }
    
    @Override
    public FormularioRepository formulario() {
        return new InMemoryFormularioRepository();
    }

    @Override
    public AtributoRepository atributo() {
        return new InMemoryAtributoRepository();
    }

    @Override
    public KeywordRepository keyword() {
        return new InMemoryKeywordRepository();
    }
    
    @Override
    public SLARepository SLA(){
        return new InMemorySLARepository();
    }

    @Override
    public ObjetivosRepository objetivos() {
        return new InMemoryObjetivosRepository();
    }

    @Override
    public RespostaFormularioRepository respostaFormulario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PedidoRepository pedido() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WorkflowRepository workflow() {
        return new InMemoryWorkflowRepository();
    }

    @Override
    public AtividadeAprovacaoRepository atividadeAprovacao() {
        return new InMemoryAtividadeAprovacaoRepository();
    }
    
    @Override
    public AtividadeRealizacaoRepository atividadeRealizacao() {
        return new InMemoryAtividadeRealizacaoRepository();
    }

    @Override
    public TarefaRepository tarefa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BibliotecaAtividadesRepository atividade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ScriptRepository script() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GrauSatisfacaoRepository grauSatisfacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }





}
