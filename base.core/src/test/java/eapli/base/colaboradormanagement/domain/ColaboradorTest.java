/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.colaboradormanagement.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Guilherme
 */
public class ColaboradorTest {

    private static final Funcao FUNCAO_TYPE = new Funcao(new CodigoAlfanumerico("CA123"), new DesignacaoFuncao("DIRETOR"));
    private static final NomeCurto COLAB_NAME = new NomeCurto("Guilherme", "Daniel");
    private static final NomeCompleto COLAB_FULLNAME = new NomeCompleto("Guilherme Barbosa Ferreira Daniel");
    private static final LocalResidencia COLAB_MORADA = new LocalResidencia("Matosinhos", "Porto");
    private static final NumeroMecanografico COLAB_NUM_MECANOGRAFICO = new NumeroMecanografico("12312");
    private static final EmailInstitucional COLAB_EMAIL = new EmailInstitucional("1181743@isep.ipp.pt");
    private static final Contacto COLAB_CONTACTO = new Contacto("+351", "912345678");

    public Colaborador dummyColaborador() throws ParseException {
        return new Colaborador(COLAB_NUM_MECANOGRAFICO, FUNCAO_TYPE, COLAB_NAME, COLAB_FULLNAME,
                getMainDate(), COLAB_MORADA, COLAB_EMAIL, COLAB_CONTACTO, null);
    }

    private DataNascimento getMainDate() throws ParseException {
        DataNascimento data = new DataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2000"));
        return data;
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureColaboradorWithoutUltimoNome() throws ParseException {

        new Colaborador(COLAB_NUM_MECANOGRAFICO, FUNCAO_TYPE, new NomeCurto("Guilherme", null), COLAB_FULLNAME,
                getMainDate(), COLAB_MORADA, COLAB_EMAIL, COLAB_CONTACTO, dummyColaborador());

    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureColaboradorWithoutPrimeiroNome() throws ParseException {
        NomeCurto nomeCurto = new NomeCurto(null, "Daniel");
        new Colaborador(COLAB_NUM_MECANOGRAFICO, FUNCAO_TYPE, nomeCurto, COLAB_FULLNAME,
                getMainDate(), COLAB_MORADA, COLAB_EMAIL, COLAB_CONTACTO, dummyColaborador());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureColaboradorWithInvalidEmail() throws ParseException {
        new Colaborador(COLAB_NUM_MECANOGRAFICO, FUNCAO_TYPE, COLAB_NAME, COLAB_FULLNAME,
                getMainDate(), COLAB_MORADA, new EmailInstitucional("guilhermedaniel"), COLAB_CONTACTO, dummyColaborador());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureColaboradorWithoutEmail() throws ParseException {
        new Colaborador(COLAB_NUM_MECANOGRAFICO, FUNCAO_TYPE, COLAB_NAME, COLAB_FULLNAME,
                getMainDate(), COLAB_MORADA, null, COLAB_CONTACTO, dummyColaborador());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureColaboradorWithoutConcelho() throws ParseException {
        new Colaborador(COLAB_NUM_MECANOGRAFICO, FUNCAO_TYPE, COLAB_NAME, COLAB_FULLNAME,
                getMainDate(), new LocalResidencia(null, "Porto"), COLAB_EMAIL, COLAB_CONTACTO, dummyColaborador());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureColaboradorWithoutDistrito() throws ParseException {
        new Colaborador(COLAB_NUM_MECANOGRAFICO, FUNCAO_TYPE, COLAB_NAME, COLAB_FULLNAME,
                getMainDate(), new LocalResidencia("Matosinhos", null), COLAB_EMAIL, COLAB_CONTACTO, dummyColaborador());
    }

    @Test
    public void ensureColaboradorWithoutReponsavel() throws ParseException {

        DataNascimento data = new DataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2000"));
        new Colaborador(COLAB_NUM_MECANOGRAFICO, FUNCAO_TYPE, COLAB_NAME, COLAB_FULLNAME,
                data, COLAB_MORADA, COLAB_EMAIL, COLAB_CONTACTO, null);
        assertTrue(true);
    }

    @Test
    public void ensureColaboradorWithReponsavel() throws ParseException {

        DataNascimento data = new DataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2000"));
        new Colaborador(COLAB_NUM_MECANOGRAFICO, FUNCAO_TYPE, COLAB_NAME, COLAB_FULLNAME,
                data, COLAB_MORADA, COLAB_EMAIL, COLAB_CONTACTO, dummyColaborador());
        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNumeroMecanograficoNotNull() throws ParseException {
        new Colaborador(null, FUNCAO_TYPE, COLAB_NAME, COLAB_FULLNAME,
                getMainDate(), COLAB_MORADA, COLAB_EMAIL, COLAB_CONTACTO, dummyColaborador());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNumeroMecanograficoInvalidDigits() throws ParseException {
        new Colaborador(new NumeroMecanografico("123456789"), FUNCAO_TYPE, COLAB_NAME, COLAB_FULLNAME,
                getMainDate(), COLAB_MORADA, COLAB_EMAIL, COLAB_CONTACTO, dummyColaborador());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNomeCurtoNotNull() throws ParseException {
        new Colaborador(COLAB_NUM_MECANOGRAFICO, FUNCAO_TYPE, null, COLAB_FULLNAME,
                getMainDate(), COLAB_MORADA, COLAB_EMAIL, COLAB_CONTACTO, dummyColaborador());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNomeCompletoNotNull() throws ParseException {
        new Colaborador(COLAB_NUM_MECANOGRAFICO, FUNCAO_TYPE, COLAB_NAME, null,
                getMainDate(), COLAB_MORADA, COLAB_EMAIL, COLAB_CONTACTO, dummyColaborador());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDataNascimentoNotNull() throws ParseException {
        new Colaborador(COLAB_NUM_MECANOGRAFICO, FUNCAO_TYPE, COLAB_NAME, COLAB_FULLNAME,
                null, COLAB_MORADA, COLAB_EMAIL, COLAB_CONTACTO, dummyColaborador());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMoradaNotNull() throws ParseException {
        new Colaborador(COLAB_NUM_MECANOGRAFICO, FUNCAO_TYPE, COLAB_NAME, COLAB_FULLNAME,
                getMainDate(), null, COLAB_EMAIL, COLAB_CONTACTO, dummyColaborador());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureEmailNotNull() throws ParseException {
        new Colaborador(COLAB_NUM_MECANOGRAFICO, FUNCAO_TYPE, COLAB_NAME, COLAB_FULLNAME,
                getMainDate(), COLAB_MORADA, null, COLAB_CONTACTO, dummyColaborador());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureContactoNotNull() throws ParseException {
        new Colaborador(COLAB_NUM_MECANOGRAFICO, FUNCAO_TYPE, COLAB_NAME, COLAB_FULLNAME,
                getMainDate(), COLAB_MORADA, COLAB_EMAIL, null, dummyColaborador());
    }

}
