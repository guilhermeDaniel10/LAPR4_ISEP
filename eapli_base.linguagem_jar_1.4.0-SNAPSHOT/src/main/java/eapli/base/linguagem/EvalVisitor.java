/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.linguagem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Guilherme
 */
class EvalVisitor extends ValidateFormularioBaseVisitor<String> {

    static Map<String, List<String>> respostaExpressao = new HashMap<>();
    static String expReg;

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


        return visitChildren(ctx);
    }
}
