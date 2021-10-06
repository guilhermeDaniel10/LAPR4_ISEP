/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.colaboradormanagement.application.AssociarColaboradorController;
import eapli.base.colaboradormanagement.application.RegistarColaboradorController;
import eapli.base.colaboradormanagement.domain.CodigoAlfanumerico;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Contacto;
import eapli.base.colaboradormanagement.domain.DataNascimento;
import eapli.base.colaboradormanagement.domain.DesignacaoFuncao;
import eapli.base.colaboradormanagement.domain.EmailInstitucional;
import eapli.base.colaboradormanagement.domain.Funcao;
import eapli.base.colaboradormanagement.domain.LocalResidencia;
import eapli.base.colaboradormanagement.domain.NomeCompleto;
import eapli.base.colaboradormanagement.domain.NomeCurto;
import eapli.base.colaboradormanagement.domain.NumeroMecanografico;
import eapli.base.colaboradormanagement.repositories.ColaboradorRepository;
import eapli.base.colaboradormanagement.repositories.FuncaoRepository;
import eapli.base.cor.domain.CodigoCor;
import eapli.base.cor.domain.Cor;
import eapli.base.cor.repositories.CorRepository;
import eapli.base.equipamanagement.application.CriarEquipaController;
import eapli.base.equipamanagement.domain.AcronimoEquipa;
import eapli.base.equipamanagement.domain.DesignacaoEquipa;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.equipamanagement.domain.ResponsavelEquipa;
import eapli.base.equipamanagement.repositories.EquipaRepository;
import eapli.base.infrastructure.bootstrapers.TestDataConstants;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefamanagement.repositories.TarefaRepository;
import eapli.base.tipoequipamanagement.application.RegistarTipoEquipaController;
import eapli.base.tipoequipamanagement.domain.DescricaoTipoEquipa;
import eapli.base.tipoequipamanagement.domain.TipoEquipa;
import eapli.base.tipoequipamanagement.repositories.TipoEquipaRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.usermanagement.domain.UserBuilderHelper;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.hibernate.bytecode.BytecodeLogger.LOGGER;

/**
 *
 * @author Guilherme
 */
public class EstruturaOrganizacaoBootstraper implements Action {

    private final CorRepository corRepo = PersistenceContext.repositories().cor();
    private final TipoEquipaRepository tpEquipaRepo = PersistenceContext.repositories().tipoEquipa();
    private final FuncaoRepository funcaoRepo = PersistenceContext.repositories().funcoes();
    private final ColaboradorRepository colabRepo = PersistenceContext.repositories().colaboradores();
    private final AssociarColaboradorController associarController = new AssociarColaboradorController();

    private final RegistarColaboradorController colabController = new RegistarColaboradorController();
    private final CriarEquipaController equipaController = new CriarEquipaController();
    private final RegistarTipoEquipaController tipoEquipaController = new RegistarTipoEquipaController();

    public Colaborador getColaborador(NumeroMecanografico nm) {
        return colabRepo.findColaboradorByNum(nm);
    }

    public TipoEquipa getTipoEquipa(Long id) {
        return tpEquipaRepo.ofIdentity(id).get();
    }

    @Override
    public boolean execute() {
        Cor c1 = registerCor(TestDataConstants.BLACK[0], new CodigoCor(TestDataConstants.BLACK[1]));
        Cor c2 = registerCor(TestDataConstants.BLUE[0], new CodigoCor(TestDataConstants.BLUE[1]));
        Cor c3 = registerCor(TestDataConstants.CYAN[0], new CodigoCor(TestDataConstants.CYAN[1]));
        registerCor(TestDataConstants.GREEN[0], new CodigoCor(TestDataConstants.GREEN[1]));
        registerCor(TestDataConstants.PURPLE[0], new CodigoCor(TestDataConstants.PURPLE[1]));
        registerCor(TestDataConstants.RED[0], new CodigoCor(TestDataConstants.RED[1]));
        registerCor(TestDataConstants.WHITE[0], new CodigoCor(TestDataConstants.WHITE[1]));
        registerCor(TestDataConstants.YELLOW[0], new CodigoCor(TestDataConstants.YELLOW[1]));

        Funcao f1 = registerFuncao(new CodigoAlfanumerico("D-331"), new DesignacaoFuncao("COLABORADOR_RECURSOS"));
        Funcao f2 = registerFuncao(new CodigoAlfanumerico("D-332"), new DesignacaoFuncao("COLABORADOR_HD"));
        Funcao f3 = registerFuncao(new CodigoAlfanumerico("D-333"), new DesignacaoFuncao("DIRETOR")); 
        
        Funcao f4 = registerFuncao(new CodigoAlfanumerico("D-334"), new DesignacaoFuncao("BACKEND_DEV"));
        Funcao f5 = registerFuncao(new CodigoAlfanumerico("D-335"), new DesignacaoFuncao("FRONT_DEV"));
        Funcao f6 = registerFuncao(new CodigoAlfanumerico("D-336"), new DesignacaoFuncao("ESTAGIARIO"));
        
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        DataNascimento dataNascimento;
        DataNascimento dataNascimento2;

        try {
            dataNascimento = new DataNascimento(df.parse("12/07/2000"));
            dataNascimento2 = new DataNascimento(df.parse("10/05/1996"));
            registerColaborador("11817", f3, "Guilherme", "Daniel", "Guilherme Barbosa Ferreira Daniel", df.parse("12/07/2000"), "Matosinhos", "Porto", "guilhermedaniel70@gmail.com",
                    "+351", "91111111", null);

            registerColaborador("11715", f3, "Lucas", "Sousa", "Lucas de Jesus Sa Sousa", df.parse("10/05/1996"), "Gondomar", "Porto", "lucasdejesussasousa@gmail.com",
                    "+351", "912343212", null);
            
            registerColaborador("11913", f3, "Rui", "Franco", "Rui Franco", df.parse("10/07/2000"), "Matosinhos", "Porto", "1181743@isep.ipp.pt", "+351", "918278726", null);
            
            registerColaborador("11865", f4, "Joao", "Daniel", "Joao Daniel", df.parse("21/08/1966"), "Porto", "Porto", "1171589@isep.ipp.pt", "+351", "918227162", null);
            
            registerColaborador("99878", f5, "Isabel", "Ferreira", "Isabel Cristina Ferreira", df.parse("31/11/1966"), "Matosinhos", "Porto", "guilhermedaniel@netcabo.pt", "+351", "911827362", null);
            
            registerColaborador("33212", f6, "Ines", "Martins", "Ines Nogueira Martins", df.parse("13/06/2000"), "Matosinhos", "Porto", "guilhermedaniel70@gmail.com", "+351", "912152635", null);
            
            registerColaborador("44321", f4, "Jorge", "Costa", "Jorge Nuno Pinto da Costa", df.parse("10/07/1900"), "Porto", "Porto", "lucasdejesussasousa@gmail.com", "+351", "98271625", null);
            
            registerColaborador("66231", f5, "Miguel", "Martins", "Miguel Rodrigues Martins", df.parse("14/07/1998"), "Leca", "Porto", "guilhermedaniel70@gmail.com", "+351", "987283716", null);
            
            registerColaborador("55231", f6, "Carla", "Silva", "Carla Santos Silva", df.parse("18/01/2000"), "Leca", "Porto", "guilhermedaniel70@gmail.com", "+351", "918273625", null);

            
            
        } catch (ParseException ex) {
            Logger.getLogger(EstruturaOrganizacaoBootstraper.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        Colaborador colab = getColaborador(new NumeroMecanografico("11817"));
        Colaborador colab2 = getColaborador(new NumeroMecanografico("11715"));
        Colaborador colab3 = getColaborador(new NumeroMecanografico("11913"));

        Set<Colaborador> listColab1 = new HashSet<>();
        listColab1.add(colab);
        listColab1.add(colab2);
        
        Set<Colaborador> listColab2 = new HashSet<>();
        listColab2.add(colab);
        listColab2.add(colab3);
        
        Set<Colaborador> listColab3 = new HashSet<>();
        listColab3.add(colab2);

        registerTipoEquipa("RHUM", c1);
        registerTipoEquipa("SERHD", c2);
        registerTipoEquipa("BUG", c3);

        TipoEquipa tp1 = getTipoEquipa(1L);
        TipoEquipa tp2 = getTipoEquipa(2L);
        TipoEquipa tp3 = getTipoEquipa(3L);

        registerEquipa("RH1", "GestaoEquipas1", tp1, listColab1);
        registerEquipa("CHD1", "GestaoServ1", tp2, listColab2);
        registerEquipa("BUG1", "Correcao1", tp3, listColab3);
        registerEquipa("CHD2", "GestaoServ2", tp2, listColab2);
        registerEquipa("RH2", "GestaoEquipas2", tp1, listColab1);
        

        registerColaboradorEmEquipa(new NumeroMecanografico("44321"), equipaController.findEquipaByAcronimo("RH1"));
        registerColaboradorEmEquipa(new NumeroMecanografico("66231"), equipaController.findEquipaByAcronimo("RH1"));
        registerColaboradorEmEquipa(new NumeroMecanografico("55231"), equipaController.findEquipaByAcronimo("BUG1"));
        
        registerColaboradorEmEquipa(new NumeroMecanografico("11865"), equipaController.findEquipaByAcronimo("CHD1"));
        
        registerColaboradorEmEquipa(new NumeroMecanografico("66231"), equipaController.findEquipaByAcronimo("CHD1"));
        registerColaboradorEmEquipa(new NumeroMecanografico("33212"), equipaController.findEquipaByAcronimo("BUG1"));
        
        registerColaboradorEmEquipa(new NumeroMecanografico("11865"), equipaController.findEquipaByAcronimo("BUG1"));
        
        
        return true;
    }

    private Cor registerCor(final String designacaoCor, final CodigoCor codigoCor) {

        Cor cor = new Cor(designacaoCor, codigoCor);

        Cor cor1;
        try {
            cor1 = corRepo.save(cor);

        } catch (ConcurrencyException | IntegrityViolationException e) {
            LOGGER.trace("Assuming existing record", e);
            return null;
        }
        return cor1;
    }

    private void registerTipoEquipa(final String descricaoTpEquipa,
            final Cor corEquipa) {
        tipoEquipaController.registerTipoEquipa(descricaoTpEquipa, corEquipa);
    }

    private void registerEquipa(final String acronimo, final String designacao, final TipoEquipa tipoEquipa,
            final Set<Colaborador> responsaveis) {

        equipaController.registerEquipa(acronimo, designacao, tipoEquipa, responsaveis);
    }

    private Funcao registerFuncao(final CodigoAlfanumerico codigo, final DesignacaoFuncao desigFuncao) {

        Funcao f1 = new Funcao(codigo, desigFuncao);

        Funcao fn1;
        try {
            fn1 = funcaoRepo.save(f1);

        } catch (ConcurrencyException | IntegrityViolationException e) {
            LOGGER.trace("Assuming existing record", e);
            return null;
        }
        return fn1;
    }

    private void registerColaborador(final String nM, final Funcao funcao, final String primeiroNome, final String ultimoNome,
            final String nomeCompleto, final Date dataNascimento, final String concelho, final String distrito,
            final String email, final String indicativo, final String contacto, final Colaborador responsavel) throws ParseException {

        colabController.registerColaborador(nM, funcao, primeiroNome, ultimoNome, nomeCompleto, dataNascimento, distrito, concelho, email, indicativo, contacto, responsavel);

    }
    
    private void registerColaboradorEmEquipa(NumeroMecanografico num, Equipa eq){
        Colaborador colab = getColaborador(num);
        boolean associar = true;
        associarController.create(associar);
        associarController.setColaborador(colab);
        associarController.setEquipa(eq);
        
        
    }

}
