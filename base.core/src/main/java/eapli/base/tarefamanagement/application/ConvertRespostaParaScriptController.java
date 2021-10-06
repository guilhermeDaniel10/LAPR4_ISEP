/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.tarefamanagement.application;

import eapli.base.bibliotecaatividades.domain.ScriptAutomatico;
import eapli.base.colaboradormanagement.application.RegistarColaboradorController;
import eapli.base.respostaformularios.domain.AtributoEmResposta;
import eapli.base.respostaformularios.domain.RespostaFormulario;
import eapli.base.validascripttarefas.respostasparascript.RespostasParaScript;

/**
 *
 * @author Guilherme
 */
public class ConvertRespostaParaScriptController {

    private RegistarColaboradorController registarController = new RegistarColaboradorController();

    public String converterRespostaParaScript(ScriptAutomatico script, RespostaFormulario resposta) {
        RespostasParaScript respostaScript = new RespostasParaScript();
        String scriptAntigo = "\"" + script.conteudoFicheiro() + "\"";
        String novoScript = scriptAntigo;
        String cpyString = "";

        for (AtributoEmResposta ar : resposta.valoresAtributos()) {


            novoScript += " " + ar.respostaForm();
           

            novoScript = respostaScript.parseToScriptComResposta(novoScript);

            if (novoScript == null) {
                novoScript = cpyString;
            }

            cpyString = novoScript;

        }

        if (novoScript.contains("email") || novoScript.contains("EMAIL")) {
            novoScript += " " + registarController.currentColaborador().emailInstitucional().emailAsUserEmail();
            novoScript = respostaScript.parseToScriptComResposta(novoScript);
            cpyString = novoScript;
        }

        return novoScript;

    }
}
