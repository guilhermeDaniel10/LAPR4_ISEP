/**
 *
 */
package eapli.base.infrastructure.persistence;

import eapli.base.bibliotecaatividades.domain.Atividade;
import eapli.base.bibliotecaatividades.repositories.BibliotecaAtividadesRepository;
import eapli.base.slamanagement.repositories.SLARepository;
import eapli.base.catalogomanagement.repositories.CatalogoRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;

import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.colaboradormanagement.repositories.ColaboradorRepository;
import eapli.base.colaboradormanagement.repositories.FuncaoRepository;
import eapli.base.cor.repositories.CorRepository;
import eapli.base.equipamanagement.repositories.EquipaRepository;
import eapli.base.formulariomanagement.repositories.AtributoRepository;
import eapli.base.formulariomanagement.repositories.FormularioRepository;
import eapli.base.servicomanagement.repositories.KeywordRepository;
import eapli.base.servicomanagement.repositories.ServicoRepository;
import eapli.base.tipoequipamanagement.repositories.TipoEquipaRepository;
import eapli.base.objetivosmanagement.repositories.ObjetivosRepository;
import eapli.base.pedidomanagement.repositories.PedidoRepository;
import eapli.base.respostaformularios.repositories.RespostaFormularioRepository;
import eapli.base.scriptmanagement.domain.Script;
import eapli.base.scriptmanagement.repositories.ScriptRepository;
import eapli.base.servicomanagement.repositories.AtividadeAprovacaoRepository;
import eapli.base.servicomanagement.repositories.AtividadeRealizacaoRepository;
import eapli.base.servicomanagement.repositories.WorkflowRepository;
import eapli.base.tarefamanagement.repositories.GrauSatisfacaoRepository;
import eapli.base.tarefamanagement.repositories.TarefaRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

/**
 * @author Paulo Gandra Sousa
 *
 */
public interface RepositoryFactory {

    /**
     * factory method to create a transactional context to use in the
     * repositories
     *
     * @return
     */
    TransactionalContext newTransactionalContext();

    /**
     *
     * @param autoTx the transactional context to enrol
     * @return
     */
    UserRepository users(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    UserRepository users();

    /**
     *
     * @param autoTx the transactional context to enroll
     * @return
     */
    ClientUserRepository clientUsers(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    ClientUserRepository clientUsers();

    /**
     *
     * @param autoTx the transactional context to enroll
     * @return
     */
    SignupRequestRepository signupRequests(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    SignupRequestRepository signupRequests();

    public ColaboradorRepository colaboradores();

    public FuncaoRepository funcoes();

    public CatalogoRepository catalogo();
    
    public CorRepository cor();
    
    public TipoEquipaRepository tipoEquipa();
    
    public EquipaRepository equipa();
    
    public ServicoRepository servico();
    
    public FormularioRepository formulario();
    
    public AtributoRepository atributo();
    
    public KeywordRepository keyword();
    
    public SLARepository SLA();

    public ObjetivosRepository objetivos();
    
    public RespostaFormularioRepository respostaFormulario();
    
    public PedidoRepository pedido();
    
    public WorkflowRepository workflow();
    
    public AtividadeAprovacaoRepository atividadeAprovacao();
    
    public AtividadeRealizacaoRepository atividadeRealizacao();
    
    public TarefaRepository tarefa();
    
    public BibliotecaAtividadesRepository atividade();
    
    public ScriptRepository script();
    
    public GrauSatisfacaoRepository grauSatisfacao();
    
}
