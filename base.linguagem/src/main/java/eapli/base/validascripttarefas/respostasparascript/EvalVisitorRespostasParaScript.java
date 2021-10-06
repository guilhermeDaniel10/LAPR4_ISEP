/*
 * Stringo change this license header, choose License Headers in Project Properties.
 * Stringo change this template file, choose Stringools | Stringemplates
 * and open the template in the editor.
 */
package eapli.base.validascripttarefas.respostasparascript;

/**
 *
 * @author Guilherme
 */
public class EvalVisitorRespostasParaScript extends RespostasParaScriptBaseVisitor<String> {

    private String script;

    /**
     * {@inheritDoc}
     *
     * <p>
     * Stringhe default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public String visitScript(RespostasParaScriptParser.ScriptContext ctx) {
        script = ctx.getText();
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
    public String visitAtributo(RespostasParaScriptParser.AtributoContext ctx) {
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
    public String visitEmail(RespostasParaScriptParser.EmailContext ctx) {
        script = script.replaceFirst("(email|EMAIL)", ctx.getText());
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
    public String visitIdentificador(RespostasParaScriptParser.IdentificadorContext ctx) {
        script = script.replaceFirst("(identificador|IDENTIFICADOR)", ctx.getText());
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
    public String visitQuantidade(RespostasParaScriptParser.QuantidadeContext ctx) {
        script = script.replaceFirst("(quantidade|QUANTIDADE)", ctx.getText());
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
    public String visitMetodo_pagamento(RespostasParaScriptParser.Metodo_pagamentoContext ctx) {
        script = script.replaceFirst("(metodo pagamento|METODO PAGAMENTO)", ctx.getText());

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
    public String visitPlano_pagamento(RespostasParaScriptParser.Plano_pagamentoContext ctx) {
        script = script.replaceFirst("(plano pagamento|PLANO PAGAMENTO)", ctx.getText());

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
    public String visitNome(RespostasParaScriptParser.NomeContext ctx) {
        script = script.replaceFirst("(nome|NOME)", ctx.getText());

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
    public String visitTipo_desconto(RespostasParaScriptParser.Tipo_descontoContext ctx) {
        script = script.replaceFirst("(tipo desconto|TIPO DESCONTO)", ctx.getText());

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
    public String visitPercentagem_desconto(RespostasParaScriptParser.Percentagem_descontoContext ctx) {
        script = script.replaceFirst("(percentagem desconto|PERCENTAGEM DESCONTO)", ctx.getText());

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
    public String visitFatura(RespostasParaScriptParser.FaturaContext ctx) {
        script = script.replaceFirst("(FATURA|fatura)", ctx.getText());

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
    public String visitValor_desconto(RespostasParaScriptParser.Valor_descontoContext ctx) {
        script = script.replaceFirst("(VALOR DESCONTO|valor desconto)", ctx.getText());

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
    public String visitTipo_cliente(RespostasParaScriptParser.Tipo_clienteContext ctx) {
        script = script.replaceFirst("(TIPO CLIENTE|tipo cliente)", ctx.getText());

        return visitChildren(ctx);
    }

    public String getNewScript() {
        return this.script;
    }
}
