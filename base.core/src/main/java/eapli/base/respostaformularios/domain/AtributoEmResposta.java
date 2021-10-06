/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.respostaformularios.domain;

import eapli.base.formulariomanagement.domain.DadosBase;
import eapli.framework.domain.model.ValueObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Guilherme
 */
@Embeddable
public class AtributoEmResposta implements ValueObject {

    @Column(nullable = true)
    private Integer numerico;

    @Column(nullable = true)
    private String texto;

    @Column(nullable = true)
    private Date data;

    @Column(nullable = true)
    private Boolean booleano;

    @Column(nullable = false)
    private String nomeVariavel;

    private int posicao;

    protected AtributoEmResposta() {

    }

    public AtributoEmResposta(String nomeVariavel, DadosBase dados, Object resposta, int posicao) {
        this.nomeVariavel = nomeVariavel;
        if (dados == DadosBase.NUMERICO) {
            numerico = (Integer) resposta;
        }
        if (dados == DadosBase.TEXTO) {
            texto = (String) resposta;
        }
        if (dados == DadosBase.DATA) {
            data = (Date) resposta;
        }
        if (dados == DadosBase.BOOLEANO) {
            booleano = (boolean) resposta;
        }

        if (dados == DadosBase.FICHEIRO) {
            texto = (String) resposta;
        }

        this.posicao = posicao;
    }

    public String respostaForm() {
        if (numerico != null) {
            return String.valueOf(this.numerico);
        }
        if (texto != null) {
            return texto;
        }
        if (data != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            return formatter.format(data);
        }
        if (booleano != null) {
            return String.valueOf(booleano);
        }
        return null;
    }

    public int positionFromAtributoEmResposta() {
        return this.posicao;
    }
    
    public String nomeVariavel(){
        return this.nomeVariavel;
    }
}
