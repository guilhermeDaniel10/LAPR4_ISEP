/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.formulariomanagement.application;

import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.DadosBase;
import eapli.base.formulariomanagement.domain.ExpressaoRegular;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.repositories.AtributoRepository;
import eapli.base.formulariomanagement.repositories.FormularioRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.linguagem.Expressions;
import eapli.base.respostaformularios.domain.AtributoEmResposta;
import eapli.base.respostaformularios.domain.RespostaFormulario;
import eapli.base.respostaformularios.repositories.RespostaFormularioRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Guilherme
 */
public class ProcessarFormularioController {

    @Autowired
    private final FormularioRepository formularioRepository = PersistenceContext.repositories().formulario();
    @Autowired
    private final AtributoRepository atributoRepository = PersistenceContext.repositories().atributo();

    private BuildFormularioValidationController validationController = new BuildFormularioValidationController();

    private final RespostaFormularioRepository respostaRepository = PersistenceContext.repositories().respostaFormulario();

    private RespostaFormulario respostaForm;

    private List<String> listResposta = new ArrayList<>();

    public List<AtributoEmResposta> atributosEmResposta = new ArrayList<>();

    public void processarRespostaFormulario(String identificadorForm, Formulario formulario) {

        respostaForm = new RespostaFormulario(identificadorForm, formulario);
    }

    public boolean addAtributoEmResposta(Atributo atributoForm, String nomeVariavel, DadosBase dadoBase, Object obj, int posicao) {
        AtributoEmResposta atributoEmResposta = new AtributoEmResposta(nomeVariavel, dadoBase, obj, posicao);

        String atributoAtualEmResposta = validationController.convertAtributoToReadableString(atributoForm, atributoEmResposta);
        atributosEmResposta.add(atributoEmResposta);
        listResposta.add(atributoAtualEmResposta);
        String checker = Expressions.parseWithVisitor(listResposta);

        if (checker.equals("NOT OK")) {
           
            listResposta.remove(atributoAtualEmResposta);
            atributosEmResposta.remove(atributoEmResposta);
            return false;
        }
   
        respostaForm.addAtributoEmResposta(nomeVariavel, dadoBase, obj, posicao);
        return true;
    }

    public List<AtributoEmResposta> atributosDaResposta() {
        return this.atributosEmResposta;
    }

    public boolean validateRespostaFromRelativePosition(String respostaEsperada, int position) {

        for (AtributoEmResposta atri : atributosEmResposta) {
            if (atri.positionFromAtributoEmResposta() == position) {
                return atri.respostaForm().matches(respostaEsperada);
            }
        }
        return false;
    }
    
    public RespostaFormulario registarRespostaFormulario(){
        return respostaRepository.save(respostaForm);
    }

}
