/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.formulariomanagement.application;

import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.AtributosEmFormulario;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.respostaformularios.domain.AtributoEmResposta;
import eapli.base.respostaformularios.domain.RespostaFormulario;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guilherme
 */
public class BuildFormularioValidationController {

    private int currentCounter = 1;

    public String convertToTextFile(RespostaFormulario resposta) {
        Formulario formularioDaResposta = resposta.formularioDaResposta();
        List<AtributoEmResposta> atributosFromFormulario = resposta.valoresAtributos();
        String allAtributos = "";
        int cnt = 1;
        Set<Atributo> atributosForm = formularioDaResposta.asAtributo();

        for (AtributoEmResposta atr : atributosFromFormulario) {
            Atributo atributoAtual = atributoFromCurrentPosition(atributosForm, cnt);
            String tipoDado = atributoAtual.dadoBase().name();
            String obrigatoriedade = atributoAtual.obrigatoriedadeAtributo();
            String dependencia = String.valueOf(atributoAtual.dependeciaAtributo());
            String expressaoRegular = "\"" + atributoAtual.expressaoRegular().toStringOnlyExpressao() + "\"";
            String respostaFormulario = "\"" + atr.respostaForm() + "\"";
            allAtributos += cnt + " " + tipoDado + " " + obrigatoriedade + " " + dependencia + " " + expressaoRegular + " " + respostaFormulario;
        }
        String path = "LAPR4_GIT\\lei20_21_s4_2dm_02\\base.linguagem\\src\\main\\java\\eapli\\base\\linguagem";
        try {
            Files.write(Paths.get("./fileName.txt"), allAtributos.getBytes());
            return allAtributos;
        } catch (IOException ex) {
            Logger.getLogger(BuildFormularioValidationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String convertAtributoToReadableString(Atributo atributoAtual, AtributoEmResposta atr) {
        String allAtributos = "";
        String tipoDado = atributoAtual.dadoBase().name();
        String obrigatoriedade = atributoAtual.obrigatoriedadeAtributo();
        String dependencia = String.valueOf(atributoAtual.dependeciaAtributo());
        String expressaoRegular = "\"" + atributoAtual.expressaoRegular().toStringOnlyExpressao() + "\"";
        String respostaFormulario = "\"" + atr.respostaForm() + "\"";
        allAtributos += currentCounter + " " + tipoDado + " " + obrigatoriedade + " " + dependencia + " " + expressaoRegular + " " + respostaFormulario;
        return allAtributos;
    }

    public Atributo atributoFromCurrentPosition(Set<Atributo> listAtributos, int posi) {

        for (Atributo atri : listAtributos) {
            if (atri.posicaoForContext() == posi) {
                return atri;
            }
        }
        return null;
    }

}
