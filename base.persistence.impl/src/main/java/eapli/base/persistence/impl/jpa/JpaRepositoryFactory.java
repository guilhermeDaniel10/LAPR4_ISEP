package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.bibliotecaatividades.domain.Atividade;
import eapli.base.bibliotecaatividades.repositories.BibliotecaAtividadesRepository;
import eapli.base.catalogomanagement.repositories.CatalogoRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.colaboradormanagement.repositories.ColaboradorRepository;
import eapli.base.colaboradormanagement.repositories.FuncaoRepository;
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
import eapli.base.tipoequipamanagement.repositories.TipoEquipaRepository;
import eapli.base.slamanagement.repositories.SLARepository;
import eapli.base.tarefamanagement.repositories.GrauSatisfacaoRepository;
import eapli.base.tarefamanagement.repositories.TarefaRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.JpaAutoTxUserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 *
 * Created by nuno on 21/03/16.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

    @Override
    public UserRepository users(final TransactionalContext autoTx) {
        return new JpaAutoTxUserRepository(autoTx);
    }

    @Override
    public UserRepository users() {
        return new JpaAutoTxUserRepository(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }

    @Override
    public JpaClientUserRepository clientUsers(final TransactionalContext autoTx) {
        return new JpaClientUserRepository(autoTx);
    }

    @Override
    public JpaClientUserRepository clientUsers() {
        return new JpaClientUserRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext autoTx) {
        return new JpaSignupRequestRepository(autoTx);
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return new JpaSignupRequestRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        return JpaAutoTxRepository.buildTransactionalContext(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }

    @Override
    public ColaboradorRepository colaboradores() {
        return new JpaColaboradorRepository();
    }

    @Override
    public FuncaoRepository funcoes() {
        return new JpaFuncaoRepository();
    }

    @Override
    public CatalogoRepository catalogo() {
        return new JpaCatalogoRepository();
    }

    @Override
    public CorRepository cor() {
        return new JpaCorRepository();
    }

    @Override
    public TipoEquipaRepository tipoEquipa() {
        return new JpaTipoEquipaRepository();
    }

    @Override
    public EquipaRepository equipa() {
        return new JpaEquipaRepository();
    }
    
    @Override
    public ServicoRepository servico() {
        return new JpaServicoRepository();
    }
    
    @Override
    public FormularioRepository formulario() {
        return new JpaFormularioRepository();
    }
    
    @Override
    public AtributoRepository atributo() {
        return new JpaAtributoRepository();
    }

    @Override
    public KeywordRepository keyword() {
        return new JpaKeywordRepository();
    }
    
    @Override 
    public SLARepository SLA() {
        return new JpaSLARepository();
    }

    @Override
    public ObjetivosRepository objetivos() {
        return new JpaObjetivosRepository();
    }

    @Override
    public RespostaFormularioRepository respostaFormulario() {
        return new JpaRespostaFormularioRepository();
    }

    @Override
    public PedidoRepository pedido() {
        return new JpaPedidoRepository();
    }

    @Override
    public WorkflowRepository workflow() {
        return new JpaWorkflowRepository();    
    }

    @Override
    public AtividadeAprovacaoRepository atividadeAprovacao() {
        return new JpaAtividadeAprovacaoRepository();
    }

    @Override
    public AtividadeRealizacaoRepository atividadeRealizacao() {
        return new JpaAtividadeRealizacaoRepository();
    }

    @Override
    public TarefaRepository tarefa() {
        return new JpaTarefaRepository();
    }

    @Override
    public BibliotecaAtividadesRepository atividade() {
        return new JpaAtividadeRepository();
    }

    @Override
    public ScriptRepository script() {
        return new JpaScriptRepository();
    }

    @Override
    public GrauSatisfacaoRepository grauSatisfacao() {
        return new JpaGrauSatisfacaoRepository();
    }


    
}
