/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.pedidomanagement.domain;

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
import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.AtributosEmFormulario;
import eapli.base.formulariomanagement.domain.DadosBase;
import eapli.base.formulariomanagement.domain.DescricaoAjuda;
import eapli.base.formulariomanagement.domain.EtiquetaAtributo;
import eapli.base.formulariomanagement.domain.ExpressaoRegular;
import eapli.base.formulariomanagement.domain.NomeVariavel;
import eapli.base.servicomanagement.domain.DescBreveServico;
import eapli.base.servicomanagement.domain.DescCompServico;
import eapli.base.servicomanagement.domain.IconeServico;
import eapli.base.servicomanagement.domain.IdentificadorServico;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.domain.TituloServico;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Guilherme
 */
public class PedidoTest {

    private DataNascimento getMainDate() throws ParseException {
        DataNascimento data = new DataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2000"));
        return data;
    }

    public Colaborador dummyColaborador() throws ParseException {
        Funcao FUNCAO_TYPE = new Funcao(new CodigoAlfanumerico("CA123"), new DesignacaoFuncao("DIRETOR"));
        NomeCurto COLAB_NAME = new NomeCurto("Guilherme", "Daniel");
        NomeCompleto COLAB_FULLNAME = new NomeCompleto("Guilherme Barbosa Ferreira Daniel");
        LocalResidencia COLAB_MORADA = new LocalResidencia("Matosinhos", "Porto");
        NumeroMecanografico COLAB_NUM_MECANOGRAFICO = new NumeroMecanografico("12312");
        EmailInstitucional COLAB_EMAIL = new EmailInstitucional("1181743@isep.ipp.pt");
        Contacto COLAB_CONTACTO = new Contacto("+351", "912345678");

        return new Colaborador(COLAB_NUM_MECANOGRAFICO, FUNCAO_TYPE, COLAB_NAME, COLAB_FULLNAME,
                getMainDate(), COLAB_MORADA, COLAB_EMAIL, COLAB_CONTACTO, null);
    }

    public Servico tipicalServico() throws IOException {

        IdentificadorServico idServico = new IdentificadorServico("Ser1");
        TituloServico titulo = new TituloServico("Titulo21");
        DescBreveServico descBreve = new DescBreveServico("valida");
        DescCompServico descComp = new DescCompServico("Servico mais que valido");
        AtributosEmFormulario af = new AtributosEmFormulario(new Atributo(1, "Teste", 2, new NomeVariavel("Validacao dados"), new EtiquetaAtributo("true or false"),
                 new DescricaoAjuda("O beneficiario é o utilizador?"), DadosBase.BOOLEANO, new ExpressaoRegular("true|false")));

        return new Servico(new IdentificadorServico("SER554"), new TituloServico("titulo"), new DescBreveServico("descBreve"), new DescCompServico("descComp"), false);

    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCriarPedidoWithoutSolicitador() throws ParseException, IOException {

        Pedido pedido = new Pedido(null, tipicalServico());

        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCriarPedidoWithoutServico() throws ParseException {

        Pedido pedido = new Pedido(dummyColaborador(), null);

        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addFieldsToPedidoWithoutUrgencia() throws ParseException, IOException {

        Pedido pedido = new Pedido(dummyColaborador(), tipicalServico());

        pedido.addFields(null, new DataLimite(new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2023")), "ficheiros");

        assertTrue(true);
    }
    @Test(expected = IllegalArgumentException.class)
    public void addFieldsToPedidoWithoutDataLimite() throws ParseException, IOException {

        Pedido pedido = new Pedido(dummyColaborador(), tipicalServico());
        
        

        pedido.addFields(Urgencia.REDUZIDA.getValorUrgencia(), null, "ficheiros");

        assertTrue(true);
    }
    @Test
    public void ensureCriarServicoWithCorrectValues() throws ParseException, IOException {
       
        Pedido pedido = new Pedido(dummyColaborador(), tipicalServico());

        assertTrue(true);
    }
    @Test
    public void addFieldsWithCorrectValues() throws ParseException, IOException {
        Pedido pedido = new Pedido(dummyColaborador(), tipicalServico());
        pedido.addFields(Urgencia.URGENTE.getValorUrgencia(), new DataLimite(new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2023")), "ficheiros");
        assertTrue(true);
    }
}
