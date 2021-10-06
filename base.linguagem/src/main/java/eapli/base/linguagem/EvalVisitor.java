/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.linguagem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Guilherme
 */
class EvalVisitor extends ValidateFormularioBaseVisitor<String> {

    static Map<String, List<String>> respostaExpressao = new HashMap<>();
    static String expReg;
    static String obrigatoriedade;
    String currentPosition;

    int numRespostas = 0;
    static int erros = 0;


    @Override
    public String visitTipoDado(ValidateFormularioParser.TipoDadoContext ctx) {

        numRespostas++;

        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * Stringhe default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public String visitObrigatoriedade(ValidateFormularioParser.ObrigatoriedadeContext ctx) {
        numRespostas++;
        obrigatoriedade = ctx.getText();
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * Stringhe default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public String visitPosicao(ValidateFormularioParser.PosicaoContext ctx) {
        numRespostas++;
        respostaExpressao.put(ctx.getText(), new LinkedList<>());
        this.currentPosition = ctx.getText();
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * Stringhe default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public String visitDependencia(ValidateFormularioParser.DependenciaContext ctx) {
        numRespostas++;
        respostaExpressao.get(this.currentPosition).add(ctx.getText());
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * Stringhe default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public String visitExpressaoRegular(ValidateFormularioParser.ExpressaoRegularContext ctx) {

        numRespostas++;
        expReg = ctx.getText().replaceAll("\"", "");
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * Stringhe default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public String visitResposta(ValidateFormularioParser.RespostaContext ctx) {
        numRespostas++;

        String currentResposta = ctx.getText().replaceAll("\"", "");


        boolean bool = currentResposta.matches(expReg);
        
        if(bool == false){
          
            throw new IllegalArgumentException("Campo nao obdece aos criterios do atributo. Tente novamente.");
        }

        if (currentPosition.equals("1")) {
            if (obrigatoriedade.equals("NF")) {
                if (currentResposta.equals(" ")) {

                    throw new IllegalArgumentException("Erro no formulario. Nao pode deixar um campo obrigatorio em branco.");
                }
            }
            respostaExpressao.get(this.currentPosition).add(ctx.getText());
        } else {
            // dependecias de outros campos
            String depen = respostaExpressao.get(this.currentPosition).get(0);
            if (!depen.equals("0")) {
                String respostaDepen = respostaExpressao.get(depen).get(1);
            }

            if (obrigatoriedade.equals("NF")) {
                if (currentResposta.equals(" ")) {
                    throw new IllegalArgumentException("Erro no formulario. Nao pode deixar um campo obrigatorio em branco.");
                }
            }
            respostaExpressao.get(this.currentPosition).add(ctx.getText());
        }

        return visitChildren(ctx);
    }

}
