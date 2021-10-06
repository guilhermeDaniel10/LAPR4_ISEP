/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.equipamanagement.domain;

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
import eapli.base.cor.domain.CodigoCor;
import eapli.base.cor.domain.Cor;
import eapli.base.tipoequipamanagement.domain.DescricaoTipoEquipa;
import eapli.base.tipoequipamanagement.domain.TipoEquipa;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Guilherme
 */
public class EquipaTest {

    private static final AcronimoEquipa ACRONIMO_EQUIPA = new AcronimoEquipa("ACR1");
    private static final DesignacaoEquipa DESIGNACAO_EQUIPA = new DesignacaoEquipa("Equipa Desenvolvimento");

    private static final DescricaoTipoEquipa DESCRICAO_TIPO_EQUIPA = new DescricaoTipoEquipa("DesignacaoTPEquipa");
    private static final Cor COR_TIPO_EQUIPA = new Cor("BLACK", new CodigoCor("#FFFFFF"));

    private static final Set<ResponsavelEquipa> responsaveis = new HashSet<>();

    public TipoEquipa dummyTipoEquipa() {
        return new TipoEquipa(DESCRICAO_TIPO_EQUIPA, COR_TIPO_EQUIPA);
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

    public Colaborador dummyColaborador2() throws ParseException {
        Funcao FUNCAO_TYPE = new Funcao(new CodigoAlfanumerico("CA144"), new DesignacaoFuncao("DIRETOR"));
        NomeCurto COLAB_NAME = new NomeCurto("Lucas", "Sousa");
        NomeCompleto COLAB_FULLNAME = new NomeCompleto("Lucas Sousa");
        LocalResidencia COLAB_MORADA = new LocalResidencia("Gondomar", "Porto");
        NumeroMecanografico COLAB_NUM_MECANOGRAFICO = new NumeroMecanografico("11617");
        EmailInstitucional COLAB_EMAIL = new EmailInstitucional("1171589@isep.ipp.pt");
        Contacto COLAB_CONTACTO = new Contacto("+351", "912343212");

        return new Colaborador(COLAB_NUM_MECANOGRAFICO, FUNCAO_TYPE, COLAB_NAME, COLAB_FULLNAME,
                getMainDate(), COLAB_MORADA, COLAB_EMAIL, COLAB_CONTACTO, null);
    }

    private void fillResponsaveis() throws ParseException {
        responsaveis.add(new ResponsavelEquipa(dummyColaborador()));
        responsaveis.add(new ResponsavelEquipa(dummyColaborador2()));
    }

    private DataNascimento getMainDate() throws ParseException {
        DataNascimento data = new DataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2000"));
        return data;
    }

    public Equipa dummyEquipa = new Equipa(ACRONIMO_EQUIPA, DESIGNACAO_EQUIPA);

    @Test
    public void ensureAdicionarTipoEquipaNaEquipa() {
        dummyEquipa.adicionarTipoEquipa(dummyTipoEquipa());

        assertEquals(dummyEquipa.tipoEquipa(), dummyTipoEquipa());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCriarEquipaWithoutTipoEquipa() {
        dummyEquipa.adicionarTipoEquipa(null);
    }

    @Test
    public void addCorrectResponsavelTest() throws ParseException {

        Set<Colaborador> colaboradores = new HashSet<>();
        colaboradores.add(dummyColaborador());
        colaboradores.add(dummyColaborador2());

        dummyEquipa.copyColaboradores(colaboradores);

        assertNotEquals(dummyEquipa.ResponsaveisEquipa(), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addIncorrectResponsavelTest() {
        dummyEquipa.copyColaboradores(null);

        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCriarEquipaWithoutDesignacaoEquipa() throws ParseException {
        fillResponsaveis();
        new Equipa(ACRONIMO_EQUIPA, null);

        assertTrue(true);
    }

    @Test
    public void ensureCriarEquipaWithDesignacaoEquipa() throws ParseException {
        fillResponsaveis();
        new Equipa(new AcronimoEquipa("ACR12"), DESIGNACAO_EQUIPA);

        assertTrue(true);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void ensureCriarEquipaWithoutAcronimoEquipa() throws ParseException {
        fillResponsaveis();
        new Equipa(null, DESIGNACAO_EQUIPA);

        assertTrue(true);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void ensureCriarEquipaWithMoreThan10CharsAcronimo() throws ParseException {
        fillResponsaveis();
        new Equipa(new AcronimoEquipa("ACR12341231"), DESIGNACAO_EQUIPA);

        assertTrue(true);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void ensureCriarEquipaWithMoreThan1WordAcronimo() throws ParseException {
        fillResponsaveis();
        new Equipa(new AcronimoEquipa("AC 123"), DESIGNACAO_EQUIPA);

        assertTrue(true);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void ensureCriarEquipaWithMoreThan30CharsDesignacao() throws ParseException {
        fillResponsaveis();
        new Equipa(ACRONIMO_EQUIPA, new DesignacaoEquipa("abcdfasdasdasdasdasdasdasdasdasdasd"));

        assertTrue(true);
    }
}
