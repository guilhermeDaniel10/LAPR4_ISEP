/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.IdentificadorCatalogo;
import eapli.base.catalogomanagement.repositories.CatalogoRepository;
import eapli.base.catalogomanagemente.application.RegistarCatalogoController;
import eapli.base.colaboradormanagement.application.ListColaboradorService;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.NumeroMecanografico;
import eapli.base.colaboradormanagement.repositories.ColaboradorRepository;
import eapli.base.cor.domain.Cor;
import eapli.base.cor.repositories.CorRepository;
import eapli.base.equipamanagement.application.ListEquipaService;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.equipamanagement.repositories.EquipaRepository;
import eapli.base.formulariomanagement.application.CreateFormularioController;
import eapli.base.formulariomanagement.application.ProcessarFormularioController;
import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.DadosBase;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.domain.NomeFormulario;
import eapli.base.formulariomanagement.repositories.AtributoRepository;
import eapli.base.formulariomanagement.repositories.FormularioRepository;
import eapli.base.infrastructure.bootstrapers.TestDataConstants;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedidomanagement.domain.DataLimite;
import eapli.base.pedidomanagement.domain.EstadoPedido;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.repositories.PedidoRepository;
import eapli.base.respostaformularios.domain.RespostaFormulario;
import eapli.base.servicomanagement.application.RegistarServicoController;
import eapli.base.servicomanagement.application.SolicitacaoServicoController;
import eapli.base.servicomanagement.domain.AtividadeAprovacao;
import eapli.base.servicomanagement.domain.Keyword;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repositories.ServicoRepository;
import eapli.base.slamanagement.application.DefinirNivelCriticidadeController;
import eapli.base.slamanagement.domain.NivelCriticidade;
import eapli.base.tarefamanagement.repositories.TarefaRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.hibernate.bytecode.BytecodeLogger.LOGGER;

/**
 *
 * @author Guilherme
 */
public class CatalogosEServicosBootstrapper implements Action {

    private final RegistarCatalogoController catalogoController = new RegistarCatalogoController();
    private final RegistarServicoController servicoController = new RegistarServicoController();
    private ListColaboradorService listColab = new ListColaboradorService();
    private final CorRepository corRepo = PersistenceContext.repositories().cor();
    private ListEquipaService listEquipa = new ListEquipaService();
    private EquipaRepository equipaRepo = PersistenceContext.repositories().equipa();
    private ColaboradorRepository colabRepo = PersistenceContext.repositories().colaboradores();
    private CatalogoRepository catalogoRepo = PersistenceContext.repositories().catalogo();
    private DefinirNivelCriticidadeController nivelController = new DefinirNivelCriticidadeController();
    private CreateFormularioController formularioController = new CreateFormularioController();
    private FormularioRepository formularioRepo = PersistenceContext.repositories().formulario();
    private AtributoRepository atributoRepo = PersistenceContext.repositories().atributo();
    private TarefaRepository tarefaRepo = PersistenceContext.repositories().tarefa();
    private ServicoRepository servicoRepo = PersistenceContext.repositories().servico();
    private PedidoRepository pedidoRepo = PersistenceContext.repositories().pedido();
    private SolicitacaoServicoController solicitarController = new SolicitacaoServicoController();

    Keyword k1, k2, k3, k4, k5, k6, k7, k8, k9, k10, k11, k12, k13, k14, k15, k16, k17, k18;
    Atributo a1, a2;

    Formulario formularioGenerico;

    public void registKeywords() throws ParseException {
        //Cotacao
        k1 = servicoController.registerKeyword("SoliCotacao");
        k2 = servicoController.registerKeyword("Cotacao");
        //Desconto
        k3 = servicoController.registerKeyword("SoliDesconto");
        k4 = servicoController.registerKeyword("Desconto");
        k5 = servicoController.registerKeyword("Sale");
        //NIB
        k6 = servicoController.registerKeyword("MudarNIB");
        //Residencia
        k7 = servicoController.registerKeyword("MudarResidencia");
        k8 = servicoController.registerKeyword("UpdateResidencia");
        //Estado civil
        k9 = servicoController.registerKeyword("MudarEstadoCivil");
        //Habilitacoes literarias
        k10 = servicoController.registerKeyword("UpdateHabilitacao");
        //Comunicacao
        k11 = servicoController.registerKeyword("ErroComunicacao");
        k12 = servicoController.registerKeyword("Comunicacao");
        //Equipamento
        k13 = servicoController.registerKeyword("ErroPC");
        k14 = servicoController.registerKeyword("Computador");
        //Aplicacao
        k15 = servicoController.registerKeyword("BugApp");

        k16 = servicoController.registerKeyword("Descontos");
        
        k17 = servicoController.registerKeyword("Grosso");
        k18 = servicoController.registerKeyword("Venda");
    }

    public Colaborador getColab(NumeroMecanografico num) {
        return colabRepo.findColaboradorByNum(num);
    }

    public Catalogo getCatalogo(String idCat) {
        return catalogoRepo.findCatalogoById(new IdentificadorCatalogo(idCat));
    }

    public Equipa getEquipa(Long id) {
        return equipaRepo.ofIdentity(id).get();
    }

    public Equipa getEquipaAcro(String acro) {
        return equipaRepo.equipaPorAcronimo(acro);
    }

    public Formulario getFormulario(String strFomularioServico) {
        return formularioRepo.findFormularioByNome(strFomularioServico);
    }

    public Atributo getAtributo(String strNomeVariavel) {
        return atributoRepo.findAtributoByNome(strNomeVariavel);
    }

    @Override
    public boolean execute() {
        try {
            try {
                registKeywords();
            } catch (ParseException ex) {
                Logger.getLogger(CatalogosEServicosBootstrapper.class.getName()).log(Level.SEVERE, null, ex);
            }

            Set<Equipa> eq1 = new HashSet<>();
            eq1.add(getEquipaAcro("RH1"));

            Set<Equipa> eq2 = new HashSet<>();
            eq2.add(getEquipaAcro("CHD1"));

            Set<Equipa> eq3 = new HashSet<>();
            eq3.add(getEquipaAcro("BUG1"));

            registerNivelCriticidade("baixa", "Aprovacao", 5, 7, 8, 11, 3, corRepo.ofIdentity(TestDataConstants.GREEN[0]).get());
            registerNivelCriticidade("media", "Aprovacao", 3, 4, 6, 8, 2, corRepo.ofIdentity(TestDataConstants.YELLOW[0]).get());
            registerNivelCriticidade("alta", "Aprovacao", 62, 65, 82, 86, 1, corRepo.ofIdentity(TestDataConstants.RED[0]).get());

            NivelCriticidade baixa = nivelController.findCriticidadeByEtiqueta("baixa");
            NivelCriticidade media = nivelController.findCriticidadeByEtiqueta("media");
            NivelCriticidade alta = nivelController.findCriticidadeByEtiqueta("alta");

            registerCatalogo("CAT1", getColab(new NumeroMecanografico("11817")), "Cotacoes e Descontos", "Gestao de cotacoes e descontos.", "Gestao de produtos para aplicar cotacoes ou descontos.", "dinheiro", "jpg",
                    eq2, true, baixa);
            registerCatalogo("CAT2", getColab(new NumeroMecanografico("11715")), "Pedidos aos Recursos Humanos.", "Informacao de colaboradores.", "Mudanca ou gestao de colaboradores", "byte", "png",
                    eq1, true, media);
            registerCatalogo("CAT3", getColab(new NumeroMecanografico("11817")), "Reportar erros.", "Reportar erros do sistema.", "Reportar erros para possivel solucionamento.", "byte", "png",
                    eq3, true, alta);

            Catalogo c1 = getCatalogo("CAT1");
            Catalogo c2 = getCatalogo("CAT2");
            Catalogo c3 = getCatalogo("CAT3");

            Set<Keyword> setKeysServicoContacao = new HashSet<>();
            setKeysServicoContacao.add(k1);
            setKeysServicoContacao.add(k2);

            Set<Keyword> setKeysServicoDesconto = new HashSet<>();

            setKeysServicoDesconto.add(k3);
            setKeysServicoDesconto.add(k4);
            setKeysServicoDesconto.add(k5);

            Set<Keyword> setKeysServicoNIB = new HashSet<>();
            setKeysServicoNIB.add(k6);

            Set<Keyword> setKeysResidencia = new HashSet<>();
            setKeysResidencia.add(k7);
            setKeysResidencia.add(k8);

            Set<Keyword> setKeysEstadoCivil = new HashSet<>();
            setKeysEstadoCivil.add(k9);

            Set<Keyword> setKeysHabilitacao = new HashSet<>();
            setKeysHabilitacao.add(k10);

            Set<Keyword> setKeysComunicacao = new HashSet<>();
            setKeysComunicacao.add(k11);
            setKeysComunicacao.add(k12);

            Set<Keyword> setKeysEquipamento = new HashSet<>();
            setKeysEquipamento.add(k13);
            setKeysEquipamento.add(k14);

            Set<Keyword> setKeysSer = new HashSet<>();
            setKeysSer.add(k16);

            Set<Keyword> setKeysAplicacao = new HashSet<>();
            setKeysAplicacao.add(k15);
            
            Set<Keyword> setKeysGrosso = new HashSet<>();
            setKeysGrosso.add(k17);
            setKeysGrosso.add(k18);

            createAtributo(1, "NF", 0, "Validacao dados", "true or false", "O beneficiario é o utilizador?", DadosBase.BOOLEANO, "true|false", null);
            createAtributo(1, "NF", 0, "Reportar erro", "texto", "reportar erro por escrito", DadosBase.TEXTO, "([A-Za-z]\" \")*", null);
            createAtributo(1, "NF", 0, "Mudar NIB", "Preencher Campo", "Novo NIB", DadosBase.BOOLEANO, "true|false", null);
            createAtributo(1, "NF", 0, "Reportar erro", "texto", "reportar erro por escrito", DadosBase.TEXTO, "([A-Za-z]\" \")*", null);
            createAtributo(2, "NF", 0, "Validacao dados 2", "true or false", "O beneficiario trabalha na empresa?", DadosBase.BOOLEANO, "true|false", null);
            createAtributo(1, "NF", 0, "Reportar erro 2", "Texto", "reportar erro por escrito complementar", DadosBase.TEXTO, "([A-Za-z]\" \")*", null);
            createAtributo(1, "NF", 0, "Morada", "Morada", "Morada do utilizador", DadosBase.NUMERICO, "[1-9]+[0-9]*", null);
            createAtributo(1, "NF", 0, "Numero", "Numero", "Numero da Porta", DadosBase.NUMERICO, "[1-9]+[0-9]*", null);

            createAtributo(1, "NF", 0, "Textoo", "texota", "asfda", DadosBase.TEXTO, DadosBase.TEXTO.getExpRegular(), null);
            createAtributo(2, "NF", 0, "Feicheiro", "fioadjf", "oisdfai", DadosBase.FICHEIRO, DadosBase.FICHEIRO.getExpRegular(), null);

            createAtributo(1, "NF", 0, "CodigoInterno", "Codigo interno cliente", "Codigo interno", DadosBase.TEXTO, "(Cli((1[0-1])|[1-9]))", null);
            createAtributo(2, "NF", 0, "NomeCli", "Nome cliente", "Nome Cliente", DadosBase.TEXTO, "[A-Z][a-z]* [A-Z][a-z]*", null);
            createAtributo(3, "NF", 0, "TipoDesconto", "Tipo desconto", "Tipo desconto", DadosBase.TEXTO, "(SAZONAL|sazonal|relampago|RELAMPAGO|QUANTIDADE|quantidade)", null);
            createAtributo(4, "NF", 0, "Recorrencia", "Recorrencia", "Recorrencia", DadosBase.TEXTO, DadosBase.TEXTO.getExpRegular(), null);
            createAtributo(5, "NF", 0, "PctDesconto", "Percentagem de desconto", "Percentagem de desconto", DadosBase.TEXTO, "[0-9]%", null);
            createAtributo(6, "NF", 0, "ValorDesconto", "Valor de desconto", "Valor de desconto", DadosBase.TEXTO, "[0-9]*.[0-9][0-9]", null);
            createAtributo(7, "NF", 0, "IdFatura", "Id fatura", "Id fatura", DadosBase.TEXTO, "[A-Z][A-Z][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]", null);
            createAtributo(8, "NF", 0, "DataLimite", "Data limite pedido", "Data limite pedido", DadosBase.DATA, DadosBase.DATA.getExpRegular(), null);
            createAtributo(9, "NF", 0, "FundamentacaoPedido", "Fundamentacao do pedido", "Fundamentacao do pedido", DadosBase.TEXTO, DadosBase.TEXTO.getExpRegular(), null);

            createAtributo(1, "NF", 0, "CodigoProduto", "Codigo interno do produto", "Codigo interno", DadosBase.TEXTO, "(Prod((1[0-8])|[1-9]))", null);
            createAtributo(2, "NF", 0, "QuantPret", "Quantidade pretendida", "Quantidade pretendida", DadosBase.NUMERICO, DadosBase.NUMERICO.getExpRegular(), null);
            createAtributo(3, "NF", 0, "TipoCli", "Tipo Cliente", "Tipo Cliente", DadosBase.TEXTO, "(nacional|europeu|resto do mundo|NACIONAL|EUROPEU|RESTO DO MUNDO)", null);

            
            
             createAtributo(1, "NF", 0, "idCliente", "Codigo interno do cliente", "Codigo interno", DadosBase.TEXTO, "(Cli((1[0-1])|[1-9]))", null);
             createAtributo(2, "NF", 0, "NomeCliente", "Nome cliente", "Nome Cliente", DadosBase.TEXTO, "[A-Z][a-z]* [A-Z][a-z]*", null);
             createAtributo(3, "NF", 0, "idProduto", "Codigo interno do produto", "Codigo interno produto", DadosBase.TEXTO, "(Prod((1[0-8])|[1-9]))", null);
             createAtributo(4, "NF", 0, "quantidade", "Quantidade de produtos", "quantidade de produtos", DadosBase.NUMERICO, DadosBase.NUMERICO.getExpRegular(), null);
             createAtributo(5, "NF", 0, "fatura", "Iban do cliente", "iban do cliente", DadosBase.TEXTO, "[A-Z][A-Z][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]", null);
             createAtributo(6, "NF", 0, "planoPaga", "Plano pagamento", "Plano de pagamento", DadosBase.TEXTO, "(PRONTO PAGAMENTO|pronto pagamento|PAGAMENTO A 30 DIAS|pagamento a 30 dias|PAGAMENTO ANUAL|pagamento anual)", null);
             
//            createAtributo(1, "NF", 0, "CodigoInterno", "Codigo interno cliente", "Codigo interno", DadosBase.TEXTO, "Cli[0-9]*", null);
//            createAtributo(2, "NF", 0, "NomeCli", "Nome cliente", "Nome Cliente", DadosBase.TEXTO, "[A-Z][a-z]* [A-Z][a-z]*", null);
//            createAtributo(3, "NF", 0, "TipoDesconto", "Tipo desconto", "Tipo desconto", DadosBase.TEXTO, DadosBase.TEXTO.getExpRegular(), null);
//            createAtributo(4, "NF", 0, "Recorrencia", "Recorrencia", "Recorrencia", DadosBase.TEXTO, DadosBase.TEXTO.getExpRegular(), null);
//            createAtributo(5, "NF", 0, "PctDesconto", "Percentagem de desconto", "Percentagem de desconto", DadosBase.TEXTO, "[0-9]%", null);
//            createAtributo(6, "NF", 0, "ValorDesconto", "Valor de desconto", "Valor de desconto", DadosBase.TEXTO, "[0-9]*.[0-9][0-9]", null);
//            createAtributo(7, "NF", 0, "IdFatura", "Id fatura", "Id fatura", DadosBase.TEXTO, DadosBase.TEXTO.getExpRegular(), null);
//            createAtributo(8, "NF", 0, "DataLimite", "Data limite pedido", "Data limite pedido", DadosBase.DATA, DadosBase.DATA.getExpRegular(), null);
//            createAtributo(9, "NF", 0, "FundamentacaoPedido", "Fundamentacao do pedido", "Fundamentacao do pedido", DadosBase.TEXTO, DadosBase.TEXTO.getExpRegular(), null);

            Set<Atributo> atributosEmFormularios1 = new HashSet<>();
            atributosEmFormularios1.add(getAtributo("Validacao dados"));
            atributosEmFormularios1.add(getAtributo("Validacao dados 2"));

            Set<Atributo> atributosEmFormularios2 = new HashSet<>();
            atributosEmFormularios2.add(getAtributo("Validacao dados"));

            Set<Atributo> atributosEmFormularios3 = new HashSet<>();
            atributosEmFormularios3.add(getAtributo("Morada"));
            atributosEmFormularios3.add(getAtributo("Numero"));

            Set<Atributo> atributosEmFormularios4 = new HashSet<>();
            atributosEmFormularios4.add(getAtributo("Mudar NIB"));

            Set<Atributo> atributosEmFormularios5 = new HashSet<>();
            atributosEmFormularios5.add(getAtributo("Textoo"));
            atributosEmFormularios5.add(getAtributo("Feicheiro"));

            Set<Atributo> atributosEmFormulario6 = new HashSet<>();
            atributosEmFormulario6.add(getAtributo("CodigoInterno"));
            atributosEmFormulario6.add(getAtributo("NomeCli"));
            atributosEmFormulario6.add(getAtributo("TipoDesconto"));
            atributosEmFormulario6.add(getAtributo("Recorrencia"));
            atributosEmFormulario6.add(getAtributo("PctDesconto"));
            atributosEmFormulario6.add(getAtributo("ValorDesconto"));
            atributosEmFormulario6.add(getAtributo("IdFatura"));
            atributosEmFormulario6.add(getAtributo("DataLimite"));
            atributosEmFormulario6.add(getAtributo("FundamentacaoPedido"));
            
            Set<Atributo> atributosEmFormulario7 = new HashSet<>();
            atributosEmFormulario7.add(getAtributo("CodigoProduto"));
            atributosEmFormulario7.add(getAtributo("QuantPret"));
            atributosEmFormulario7.add(getAtributo("TipoCli"));
            
            Set<Atributo> atributosEmFormulario8 = new HashSet<>();
            atributosEmFormulario8.add(getAtributo("idCliente"));
            atributosEmFormulario8.add(getAtributo("NomeCliente"));
            atributosEmFormulario8.add(getAtributo("idProduto"));
            atributosEmFormulario8.add(getAtributo("quantidade"));
            atributosEmFormulario8.add(getAtributo("fatura"));
            atributosEmFormulario8.add(getAtributo("planoPaga"));
            

            registerServico("Ser33", "Cosas 33.", c2, "33 novo", "ihsdfa 33", "image1", "png", setKeysServicoNIB, true, alta, null,
                    getEquipaAcro("RH1"), "ScriptReso1Auto887", atributosEmFormularios5, null, null, null, true, "SoliaaiCia", atributosEmFormularios5, false);

            registerServico("Ser1", "Requerer cotacao para vender por grosso1.", c1, "auto1", "autom1", "image1", "png",
                    setKeysEquipamento, true, alta,
                    null, null, null,
                    null, "identificador identificador quantidade", null,
                    null, true, "RequererCotacao1", atributosEmFormularios1, true); //AUTOMATICA

            registerServico("Ser199", "Requerer cotacao para vender por grosso2.", c1, "auto2", "autom2", "image1", "png",
                    setKeysEquipamento, true, alta,
                    null, null, null,
                    null, "email identificador identificador quantidade metodo pagamento plano pagamento", null,
                    null, true, "RequererCotacao2", atributosEmFormularios1, false); //AUTOMATICA

            registerServico("Ser198", "Requerer cotacao para vender por grosso3.", c1, "auto3", "autom3", "image1", "png",
                    setKeysEquipamento, true, alta,
                    null, null, null,
                    null, "email identificador identificador quantidade", null,
                    null, true, "RequererCotacao3", atributosEmFormularios1, true); //AUTOMATICA

            registerServico("Ser197", "Requerer cotacao para vender por grosso4.", c1, "auto4", "autom4", "image1", "png",
                    setKeysEquipamento, true, alta,
                    null, null, null,
                    null, "IDENTIFICADOR IDENTIFICADOR QUANTIDADE", null,
                    null, true, "RequererCotacao4", atributosEmFormularios1, false); //AUTOMATICA
            registerServico("Ser196", "Requerer cotacao para vender por grosso5.", c1, "auto5", "autom5", "image1", "png",
                    setKeysEquipamento, true, alta,
                    null, null, null,
                    null, "identificador identificador quantidade metodo pagamento plano pagamento", null,
                    null, true, "RequererCotacao5", atributosEmFormularios1, true); //AUTOMATICA

            registerServico("Ser195", "Requerer cotacao para vender por grosso6.", c1, "auto6", "autom6", "image1", "png",
                    setKeysEquipamento, true, alta,
                    null, null, null,
                    null, "identificador identificador metodo pagamento plano pagamento", null,
                    null, true, "RequererCotacao6", atributosEmFormularios1, false); //AUTOMATICA

            registerServico("Ser194", "Requerer cotacao para vender por grosso7.", c1, "auto7", "autom7", "image1", "png",
                    setKeysEquipamento, true, alta,
                    null, null, null,
                    null, "email identificador identificador quantidade metodo pagamento plano pagamento", null,
                    null, true, "RequererCotacao7", atributosEmFormularios1, true); //AUTOMATICA

            registerServico("Ser2", "Solicitar autorizacao para aplicacao de desconto financeiro.", c1, "asdfads", "csfadsf", "image1", "png", setKeysEquipamento, true, alta, getColab(new NumeroMecanografico("11817")),
                    null, "ResolverFormBem", atributosEmFormularios1, null, "strNomeFormularioAprovacao", atributosEmFormularios1, true, "SolicitarDesconto", atributosEmFormularios1, false); //AUTOMATICA

            registerServico("Ser27", "Solicitar autorizacao para aplicacao de desconto financeiro 2.", c1, "asdfads", "csfadsf", "image1", "png", setKeysEquipamento, true, alta, getColab(new NumeroMecanografico("11817")),
                    null, "ResolverFormBem445", atributosEmFormularios1, null, "strNomeFormularioAprovacao22", atributosEmFormularios1, true, "SolicitarDesconto4321", atributosEmFormularios1, false); //AUTOMATICA

            registerServico("Ser3", "Alteracao de NIB 3.", c2, "Mudar NIB utilizador  1", "Mudar NIB utilizador para mante informacao atualizada 1", "image1", "png", setKeysServicoNIB, true, alta, null,
                    getEquipaAcro("RH1"), "Validacao1", atributosEmFormularios4, null, null, null, true, "SolicitarMudarNIB1", atributosEmFormularios2, true);
            registerServico("Ser15", "Alteracao de NIB 15.", c2, "Mudar NIB utilizador 2", "Mudar NIB utilizador para mante informacao atualizada 2", "image1", "png", setKeysServicoNIB, true, media, null,
                    getEquipaAcro("RH1"), "Validacao1", atributosEmFormularios4, null, null, null, true, "SolicitarMudarNIB2", atributosEmFormularios2, false);
            registerServico("Ser16", "Alteracao de NIB 16.", c2, "Mudar NIB utilizador 3", "Mudar NIB utilizador para mante informacao atualizada 3", "image1", "png", setKeysServicoNIB, true, baixa, null,
                    getEquipaAcro("RH1"), "Validacao1", atributosEmFormularios4, null, null, null, true, "SolicitarMudarNIB3", atributosEmFormularios2, true);
            registerServico("Ser17", "Alteracao de NIB 17.", c2, "Mudar NIB utilizador 4", "Mudar NIB utilizador para mante informacao atualizada 4", "image1", "png", setKeysServicoNIB, true, media, null,
                    getEquipaAcro("RH1"), "Validacao1", atributosEmFormularios4, null, null, null, true, "SolicitarMudarNIB4", atributosEmFormularios2, false);
            registerServico("Ser18", "Alteracao de NIB 18.", c2, "Mudar NIB utilizador 5", "Mudar NIB utilizador para mante informacao atualizada 5", "image1", "png", setKeysServicoNIB, true, baixa, null,
                    getEquipaAcro("RH1"), "Validacao1", atributosEmFormularios4, null, null, null, true, "SolicitarMudarNIB5", atributosEmFormularios2, true);
            registerServico("Ser19", "Alteracao de NIB 19.", c2, "Mudar NIB utilizador 6", "Mudar NIB utilizador para mante informacao atualizada 6", "image1", "png", setKeysServicoNIB, true, alta, null,
                    getEquipaAcro("RH1"), "Validacao1", atributosEmFormularios4, null, null, null, true, "SolicitarMudarNIB6", atributosEmFormularios2, false);

            registerServico("Ser4", "Alteracao de Residencia.", c2, "auto", "autom", "image1", "png",
                    setKeysResidencia, true, alta,
                    null, null, null,
                    null, "email identificador identificador quantidade metodo pagamento plano pagamento", null,
                    null, true, "AlterarResidencia", atributosEmFormularios1, true); //AUTOMATICA

            registerServico("Ser5", "Alteracao de estado civil para efeitos de IRS.", c2, "Mudar estado civil", "Mudar estado civil para manter informacao atualizada", "image1", "png", setKeysEquipamento, true, alta, getColab(new NumeroMecanografico("11817")),
                    null, "email identificador identificador quantidade metodo pagamento plano pagamento", atributosEmFormularios2, null, "AprovacaoEstadoCivil", atributosEmFormularios1, true, "SocilicarMudarCivil", atributosEmFormularios1, false);

            registerServico("Ser6", "Atualização de habilitacoes literarias.", c2, "Atualizar habilitacoes", "Atualizar habilitacoes para manter o sistema atualizado", "image1", "png", setKeysEquipamento, true, alta, null,
                    getEquipaAcro("RH1"), "Validacao1", atributosEmFormularios1, null, null, null, true, "MudarHabilitacoes", atributosEmFormularios2, true); //AUTOMATICA

            registerServico("Ser7", "Reportar anomalia de comunicacao.", c3, "Problema na comunicacao", "Problema na comunicacao entre colaboradores", "image1", "png",
                    setKeysEquipamento, true, alta,
                    null, null, null,
                    null, "email identificador identificador quantidade metodo pagamento plano pagamento", null,
                    null, true, "SoliAuto1", atributosEmFormularios1, false); //AUTOMATICA

            registerServico("Ser8", "Reportar anomalia de equipamento.", c3, "Problema em equipamento", "Problema nos computadores", "image1", "png",
                    setKeysEquipamento, true, media,
                    null, null, null,
                    null, "email identificador identificador quantidade metodo pagamento plano pagamento", null,
                    null, true, "SoliAuto2", atributosEmFormularios1, true); //AUTOMATICA

            registerServico("Ser9", "Reportar anomalia em aplicacao.", c3, "Problema em aplicacao", "Problemas no arraque da aplicacao", "image1", "png", setKeysEquipamento, true, baixa,
                    null, null, null,
                    null, "email identificador identificador quantidade metodo pagamento plano pagamento", null,
                    null, true, "SoliAuto3", atributosEmFormularios1, false); //AUTOMATICA

            registerServico("Ser61", "Autorizacao para a aplicacao de descontos.", c1, "Aplicacao Descontos", "Autorizar descontos", "image1", "png", setKeysSer, true, alta,
                    null, null, null,
                    null, "email identificador fatura tipo desconto nome percentagem desconto valor desconto", null,
                    null, true, "SoliAutoApres", atributosEmFormulario6, false); //AUTOMATICA
            
            registerServico("Ser71", "Requerer cotacao para venda por grosso.", c1, "Requerer cotacao para venda", "Requerer cotacao para venda", "image1", "png", setKeysGrosso, true, alta,
                    null, null, null,
                    null, "email identificador quantidade tipo cliente", null,
                    null, true, "SoliAutoApres2", atributosEmFormulario7, false); //AUTOMATICA
            
             registerServico("Ser81", "Requerer cotacao para venda por grosso com respetivo desconto.", c1, "Requerer cotacao para venda com desconto", "Requerer cotacao para venda com desconto", "image1", "png", setKeysGrosso, true, alta,
                    null, null, null,
                    null, "email identificador identificador quantidade nome", null,
                    null, true, "SoliAutoApres3", atributosEmFormulario8, false); //AUTOMATICA

//             public void registerServico(String strIdServico, String strTituloServico, Catalogo catalogoDisponiblizaServico,
//            String strDescBreveServico, String strDescCompletaServico, String iconeName, String extensaoIcone,
//            final Set<Keyword> keywordsEmServico, boolean estadoServico, NivelCriticidade nivelCriticidadeServico,
//            Colaborador colaboradorResponsavelPelaResolucao, Equipa equipaResponsavelPelaResolucao, String strNomeFormularioResolucao,
//            Set<Atributo> atributosFormularioResolucao, String strScriptResolucao, String strNomeFormularioAprovacao,
//            Set<Atributo> atributosFormularioAprovacao, boolean responsavelHierarquicoIsAprovador, String strNomeFormularioSolicitacao, Set<Atributo> atributosFormularioSolicitacao,
//            boolean satisfacao) {
            Servico s1 = servicoRepo.findServicoByIdentificador("Ser1");
            Servico s2 = servicoRepo.findServicoByIdentificador("Ser199");
            Servico s3 = servicoRepo.findServicoByIdentificador("Ser198");
            Servico s4 = servicoRepo.findServicoByIdentificador("Ser197");
            Servico s5 = servicoRepo.findServicoByIdentificador("Ser196");
            Servico s6 = servicoRepo.findServicoByIdentificador("Ser195");
            Servico s7 = servicoRepo.findServicoByIdentificador("Ser194");
            Servico s8 = servicoRepo.findServicoByIdentificador("Ser27");
            Servico s9 = servicoRepo.findServicoByIdentificador("Ser61");
            Servico s10 = servicoRepo.findServicoByIdentificador("Ser81");
            Servico s11 = servicoRepo.findServicoByIdentificador("Ser71");
            Servico s12 = servicoRepo.findServicoByIdentificador("Ser61");

            Pedido p1 = new Pedido(getColab(new NumeroMecanografico("11817")), s1
            );
            p1.changeState(EstadoPedido.SUBMETIDO);
            p1.addFields(1, new DataLimite(new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2021")), "asd");
            Pedido p2 = new Pedido(getColab(new NumeroMecanografico("11817")), s2
            );
            p2.changeState(EstadoPedido.SUBMETIDO);
            p2.addFields(1, new DataLimite(new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2021")), "asd");
            Pedido p3 = new Pedido(getColab(new NumeroMecanografico("11817")), s3
            );
            p3.changeState(EstadoPedido.SUBMETIDO);
            p3.addFields(1, new DataLimite(new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2021")), "asd");
            Pedido p4 = new Pedido(getColab(new NumeroMecanografico("11817")), s4
            );
            p4.changeState(EstadoPedido.SUBMETIDO);
            p4.addFields(1, new DataLimite(new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2021")), "asd");
            Pedido p5 = new Pedido(getColab(new NumeroMecanografico("11817")), s5
            );
            p5.changeState(EstadoPedido.SUBMETIDO);
            p5.addFields(1, new DataLimite(new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2021")), "asd");
            Pedido p6 = new Pedido(getColab(new NumeroMecanografico("11817")), s6
            );
            p6.changeState(EstadoPedido.SUBMETIDO);
            p6.addFields(1, new DataLimite(new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2021")), "asd");
            Pedido p7 = new Pedido(getColab(new NumeroMecanografico("11817")), s7
            );
            p7.changeState(EstadoPedido.SUBMETIDO);
            p7.addFields(1, new DataLimite(new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2021")), "asd");
            Pedido p8 = new Pedido(getColab(new NumeroMecanografico("11817")), s8);
            p8.changeState(EstadoPedido.EM_APROVACAO);
            p8.addFields(1, new DataLimite(new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2021")), "asd");
            p8.addAtividadeAprovacao(s8.workflowServico().atividadeAprovacaoWorkflow());

            ProcessarFormularioController pForm = new ProcessarFormularioController();
            Formulario f = s10.formularioDeSolicitacaoDeServico();
            pForm.processarRespostaFormulario(f.nomeFormulario().nomeFormulario(), f);
            
            List<Atributo> l = new ArrayList<>();
            for(Atributo a : f.asAtributo()){
                l.add(a);
            }
            int index = 0;
            for(Atributo hh : l){
                
                index++;
            }
            pForm.addAtributoEmResposta(l.get(0), l.get(0).nomeVariavel().toStringNome(), l.get(0).dadoBase(), "Cli3", 0);
            pForm.addAtributoEmResposta(l.get(1), l.get(1).nomeVariavel().toStringNome(), l.get(1).dadoBase(), "Marco Paulo", 0);
            pForm.addAtributoEmResposta(l.get(2), l.get(2).nomeVariavel().toStringNome(), l.get(2).dadoBase(), "Prod5", 0);
            pForm.addAtributoEmResposta(l.get(3), l.get(3).nomeVariavel().toStringNome(), l.get(3).dadoBase(), 15, 0);
            pForm.addAtributoEmResposta(l.get(4), l.get(4).nomeVariavel().toStringNome(), l.get(4).dadoBase(), "PT50192837483726172837261", 0);
            pForm.addAtributoEmResposta(l.get(5), l.get(5).nomeVariavel().toStringNome(), l.get(5).dadoBase(), "PAGAMENTO A 30 DIAS", 0);
            
            Pedido p9 = new Pedido(getColab(new NumeroMecanografico("11817")), s10);
            p9.changeState(EstadoPedido.SUBMETIDO);
            p9.addFields(1, new DataLimite(new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2021")), "asd");
            
             Pedido p66 = new Pedido(getColab(new NumeroMecanografico("11817")), s11);
            p66.changeState(EstadoPedido.SUBMETIDO);
            p66.addFields(1, new DataLimite(new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2021")), "asd");
            
             Pedido p55 = new Pedido(getColab(new NumeroMecanografico("11817")), s12);
            p55.changeState(EstadoPedido.SUBMETIDO);
            p55.addFields(1, new DataLimite(new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2021")), "asd");
            
            
            RespostaFormulario rFor = pForm.registarRespostaFormulario();
            
            for (int i = 0; i < 3; i++) {
                Pedido p11 = pedidoRepo.save(p9);
                p11.addScriptParaExecucaoFutura("Cli5 Marco Paulo Prod5 15 PT50192837483726172837261 PAGAMENTO A 30 DIAS guilhermedaniel70@gmail.com");
                solicitarController.registaTarefaAutomativa(s10, p11);
                pedidoRepo.save(p11);
            }
            for (int i = 0; i < 5; i++) {
                Pedido p11 = pedidoRepo.save(p66);
                p11.addScriptParaExecucaoFutura("Cli5 Marco Paulo sazonal 3% 14.14 PT50192837483726172837261 guilhermedaniel70@gmail.com");
                solicitarController.registaTarefaAutomativa(s11, p11);
                pedidoRepo.save(p11);
            }
            
            for (int i = 0; i < 4; i++) {
                Pedido p11 = pedidoRepo.save(p9);
                p11.addScriptParaExecucaoFutura("Cli5 Marco Paulo Prod5 15 PT50192837483726172837261 PAGAMENTO A 30 DIAS guilhermedaniel70@gmail.com");
                solicitarController.registaTarefaAutomativa(s10, p11);
                pedidoRepo.save(p11);
            }
            for (int i = 0; i < 5; i++) {
                Pedido p11 = pedidoRepo.save(p55);
                p11.addScriptParaExecucaoFutura("Prod5 15 nacional guilhermedaniel70@gmail.com");
                solicitarController.registaTarefaAutomativa(s12, p11);
                pedidoRepo.save(p11);
            }
            
            for (int i = 0; i < 2; i++) {
                Pedido p11 = pedidoRepo.save(p66);
                p11.addScriptParaExecucaoFutura("Cli5 Marco Paulo sazonal 3% 14.14 PT50192837483726172837261 guilhermedaniel70@gmail.com");
                solicitarController.registaTarefaAutomativa(s11, p11);
                pedidoRepo.save(p11);
            }
            
            
            
            
//            RespostaFormulario rf = new RespostaFormulario()
//            Pedido p11 = pedidoRepo.save(p1);
//            Pedido p12 = pedidoRepo.save(p2);
//            Pedido p13 = pedidoRepo.save(p3);
//            Pedido p14 = pedidoRepo.save(p4);
//            Pedido p15 = pedidoRepo.save(p5);
//            Pedido p16 = pedidoRepo.save(p6);
//            Pedido p17 = pedidoRepo.save(p7);
//            Pedido p18 = pedidoRepo.save(p8);
//
//            solicitarController.registaTarefaAutomativa(s1, p11);
//            solicitarController.registaTarefaAutomativa(s2, p12);
//            solicitarController.registaTarefaAutomativa(s3, p13);
//            solicitarController.registaTarefaAutomativa(s4, p14);
//            solicitarController.registaTarefaAutomativa(s5, p15);
//            solicitarController.registaTarefaAutomativa(s6, p16);
//            solicitarController.registaTarefaAutomativa(s7, p17);
//        registerServico("SER1", "Requerer cotacao para vender por grosso.", c1, "Pedir cotacao para venda.", "Pedir cotacao para venda por grosso.", "image1", "png", setKeysServicoContacao, false, true, "Formulario Ajuda 1", atributosEmFormularios1, baixa);
//        registerServico("SER2", "Solicitar autorizacaoo para aplicacao de desconto financeiro.", c1, "Solicitar desconto de produtos.", "Solicitar desconto de produtos para futuras vendas.", "image1", "png", setKeysServicoDesconto, false, true, "Formulario Ajuda", atributosEmFormularios1, null);
//        registerServico("SER3", "Alteracao de NIB.", c2, "Alterar NIB", "Alterar NIB de Colaborador", "image1", "png", setKeysServicoNIB, false, true, "Formulario Ajuda 2", atributosEmFormularios1, null);
//        registerServico("SER4", "Alteracao de Residencia.", c2, "Alterar Residencia", "Alterar Residencia de Colaborador", "image1", "png", setKeysResidencia, false, true, null , null, null);
//        registerServico("SER5", "Alteracao de estado civil para efeitos de IRS.", c2, "Alterar estado civil", "Alterar estado civil de colaborador", "image1", "png", setKeysEstadoCivil, false, true, "Formulario Ajuda 4", atributosEmFormularios1, null);
//        registerServico("SER6", "Atualização de habilitacoes literarias.", c2, "Alterar habilitacoes", "Alterar habilitacoes de colaborador", "image1", "png", setKeysHabilitacao, false, true, null, null, null);
//        registerServico("SER7", "Reportar anomalia de comunicacao.", c3, "Problema na comunicacao", "Problema na comunicacao entre colaboradores", "image1", "png", setKeysComunicacao, false, true,"Formulario Ajuda 6", atributosEmFormularios2, alta);
//        registerServico("SER8", "Reportar anomalia de equipamento.", c3, "Problema em equipamento", "Problema nos computadores", "image1", "png", setKeysEquipamento, false, true, null, null, null);
//        registerServico("SER9", "Reportar anomalia em aplicacao.", c3, "Problema em aplicacao", "Problemas no arraque da aplicacao", "image1", "png", setKeysAplicacao, false, true, "Formulario Ajuda 8", atributosEmFormularios2, null);
//
//
            return true;

        } catch (ParseException ex) {
            Logger.getLogger(CatalogosEServicosBootstrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;

    }

    public void registerCatalogo(final String idCatalogo, final Colaborador responsavel, final String tituloCatalogo, final String descBreveCatalogo, final String descCompletaCatalogo,
            final String iconeNome, final String extensaoIcone, final Set<Equipa> equipas, final boolean estado, final NivelCriticidade nivelCriticidadeCatalogo) {
        try {
            catalogoController.registerCatalogo(idCatalogo, responsavel, tituloCatalogo, descBreveCatalogo, descCompletaCatalogo, iconeNome,
                    extensaoIcone, equipas, estado, nivelCriticidadeCatalogo);
        } catch (final IntegrityViolationException | ConcurrencyException | ParseException ex) {

            LOGGER.trace("Assuming existing record", ex);
        }
    }

    public void registerServico(String strIdServico, String strTituloServico, Catalogo catalogoDisponiblizaServico,
            String strDescBreveServico, String strDescCompletaServico, String iconeName, String extensaoIcone,
            final Set<Keyword> keywordsEmServico, boolean estadoServico, NivelCriticidade nivelCriticidadeServico,
            Colaborador colaboradorResponsavelPelaResolucao, Equipa equipaResponsavelPelaResolucao, String strNomeFormularioResolucao,
            Set<Atributo> atributosFormularioResolucao, String strScriptResolucao, String strNomeFormularioAprovacao,
            Set<Atributo> atributosFormularioAprovacao, boolean responsavelHierarquicoIsAprovador, String strNomeFormularioSolicitacao, Set<Atributo> atributosFormularioSolicitacao,
            boolean satisfacao) {
        try {
            servicoController.registerServico(strIdServico, strTituloServico, catalogoDisponiblizaServico,
                    strDescBreveServico, strDescCompletaServico, iconeName, extensaoIcone,
                    keywordsEmServico, estadoServico, nivelCriticidadeServico,
                    colaboradorResponsavelPelaResolucao, equipaResponsavelPelaResolucao, strNomeFormularioResolucao,
                    atributosFormularioResolucao, strScriptResolucao, strNomeFormularioAprovacao,
                    atributosFormularioAprovacao, responsavelHierarquicoIsAprovador, strNomeFormularioSolicitacao, atributosFormularioSolicitacao, satisfacao);
        } catch (final IntegrityViolationException | ConcurrencyException ex) {

            LOGGER.trace("Assuming existing record", ex);
        }
    }

    public void registerNivelCriticidade(String etiqueta, String designacao, int tempoMedioAprovacao, int tempoMaxAprovacao, int tempoMedioResolucao, int tempoMaxResolucao, int valorCriticidade, Cor cor) {
        try {
            nivelController.createObjetivos(tempoMedioAprovacao, tempoMaxAprovacao, tempoMedioResolucao, tempoMaxResolucao);
            nivelController.createNivelCriticidade(etiqueta, designacao, valorCriticidade, cor);
            nivelController.save();
        } catch (final IntegrityViolationException | ConcurrencyException ex) {

            LOGGER.trace("Assuming existing record", ex);
        }
    }

    public void registerFormulario(String etiqueta, String designacao, int tempoMedioAprovacao, int tempoMaxAprovacao, int tempoMedioResolucao, int tempoMaxResolucao, int valorCriticidade, Cor cor) {
        try {
            nivelController.createObjetivos(tempoMedioAprovacao, tempoMaxAprovacao, tempoMedioResolucao, tempoMaxResolucao);
            nivelController.createNivelCriticidade(etiqueta, designacao, valorCriticidade, cor);
            nivelController.save();
        } catch (final IntegrityViolationException | ConcurrencyException ex) {

            LOGGER.trace("Assuming existing record", ex);
        }
    }

    public void createAtributo(int posicao, String obrigatoriedade, int dependencia, String strNomeVariavel, String strEtiquetaAtributo, String strDescricaoAjuda, DadosBase dadosBase, String strExpressaoRegular, String esperado) {
        try {
            formularioController.createAtributo(posicao, obrigatoriedade, dependencia, strNomeVariavel, strEtiquetaAtributo, strDescricaoAjuda, dadosBase, strExpressaoRegular, esperado);

        } catch (final IntegrityViolationException | ConcurrencyException ex) {

            LOGGER.trace("Assuming existing record", ex);
        } catch (ParseException ex) {

            Logger.getLogger(CatalogosEServicosBootstrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createFormulario(String strFomularioServico, Set<Atributo> atributosFormulario) {
        try {
            formularioController.createFormulario(strFomularioServico, atributosFormulario);

        } catch (final IntegrityViolationException | ConcurrencyException ex) {

            LOGGER.trace("Assuming existing record", ex);
        } catch (ParseException ex) {

            Logger.getLogger(CatalogosEServicosBootstrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
