/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.tipoequipamanagement.domain;

import eapli.base.cor.domain.CodigoCor;
import eapli.base.cor.domain.Cor;
import org.junit.Test;

/**
 *
 * @author Guilherme
 */
public class TipoEquipaTest {

    private static final DescricaoTipoEquipa DESCRICAO_TIPO_EQUIPA = new DescricaoTipoEquipa("DesignacaoTPEquipa");
    private static final Cor COR_TIPO_EQUIPA = new Cor("BLACK", new CodigoCor("#FFFFFF"));

    public TipoEquipa dummyTipoEquipa() {
        return new TipoEquipa(DESCRICAO_TIPO_EQUIPA, COR_TIPO_EQUIPA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescricaoTipoEquipaNotNull() {
        new TipoEquipa(null, COR_TIPO_EQUIPA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCorTipoEquipaNotNull() {
        new TipoEquipa(DESCRICAO_TIPO_EQUIPA, null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void ensureCorDescricaoTipoEquipaExcede30Caracteres() {
        new TipoEquipa(new DescricaoTipoEquipa("descricaoexcedeostrintacaracteresdisponiveis"), COR_TIPO_EQUIPA);
    }
    
    @Test
    public void ensureCorDescricaoTipoEquipaValido30Caracteres() {
        new TipoEquipa(new DescricaoTipoEquipa("descricao valida"), COR_TIPO_EQUIPA);
    }
    
}
