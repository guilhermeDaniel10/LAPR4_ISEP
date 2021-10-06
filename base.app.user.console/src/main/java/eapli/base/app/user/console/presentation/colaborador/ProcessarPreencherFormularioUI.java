/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.user.console.presentation.colaborador;

import eapli.base.formulariomanagement.application.ProcessarFormularioController;
import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.DadosBase;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.dto.FormularioDTO;
import eapli.base.formulariomanagement.repositories.FormularioRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.respostaformularios.domain.AtributoEmResposta;
import eapli.base.respostaformularios.domain.RespostaFormulario;
import eapli.base.servicomanagement.application.RegistarServicoController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Guilherme
 */
public class ProcessarPreencherFormularioUI extends AbstractUI {

    private FormularioDTO formulario;
    private FormularioRepository formularioRepo = PersistenceContext.repositories().formulario();

    public ProcessarPreencherFormularioUI(FormularioDTO formulario) {
        this.formulario = formulario;
    }

    private RegistarServicoController servicoController = new RegistarServicoController();
    private ProcessarFormularioController precessarForm = new ProcessarFormularioController();
    private RespostaFormulario respostaFormularioProcessada;

    @Override
    protected boolean doShow() {
        Formulario formularioAtual = formularioRepo.findFormularioByNome(formulario.nomeFormulario);
        precessarForm.processarRespostaFormulario(formulario.nomeFormulario, formularioAtual);

        Set<Atributo> atributosFormulario = formulario.atributos;
        List<Atributo> atributosAsList = new ArrayList<>(atributosFormulario);
        Collections.sort(atributosAsList, new Atributo());

        if (atributosFormulario == null) {
            
        }
        System.out.println("\n::::::::: FORMULARIO :::::::::");
        for (Atributo atributo : atributosAsList) {

            Object obj = null;
            boolean register = true;
            do {
                int dependencia = atributo.dependeciaAtributo();
                boolean continuar = true;

                if (dependencia != 0) {
                    String expEsperada = atributo.expResposta().toStringOnlyExpressao();
                    
                    continuar = precessarForm.validateRespostaFromRelativePosition(expEsperada, dependencia);
                   
                }

                if (continuar) {

                    System.out.println(atributo.etiquetaAtributo().toString() + "\n");
                    System.out.println(atributo.descricaoAjuda().toString() + "\n");
                    String nomeVariavel = atributo.nomeVariavel().toString();
                    if (atributo.dadoBase() == DadosBase.NUMERICO) {
                        obj = Console.readInteger(nomeVariavel);
                    }
                    if (atributo.dadoBase() == DadosBase.TEXTO) {
                        obj = Console.readLine(nomeVariavel);
                        if (obj.equals("")) {
                            obj = " ";
                        }
                    }
                    if (atributo.dadoBase() == DadosBase.DATA) {
                        obj = Console.readDate(nomeVariavel + " (dd/MM/yyyy):", "dd/MM/yyyy");
                    }
                    if (atributo.dadoBase() == DadosBase.BOOLEANO) {
                        obj = Console.readBoolean(nomeVariavel + " true/false: ");
                    }

                    if (atributo.dadoBase() == DadosBase.FICHEIRO) {
                        obj = Console.readLine(nomeVariavel + ":");
                    }

                    register = precessarForm.addAtributoEmResposta(atributo, atributo.nomeVariavel().toStringNome(), atributo.dadoBase(), obj, atributo.posicaoForContext());
                } else {
                    break;
                }
            } while (!register);
            System.out.println("\n:::::::::::::::::::::::::::::::");
        }
        this.respostaFormularioProcessada = precessarForm.registarRespostaFormulario();
        return true;
    }

    public RespostaFormulario respostaObtida() {
        return this.respostaFormularioProcessada;
    }

    @Override
    public String headline() {
        return "Formulario";
    }

}
