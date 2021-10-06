package eapli.base.validascripttarefas.respostasparascript;

// Generated from RespostasParaScript.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RespostasParaScriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RespostasParaScriptVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RespostasParaScriptParser#inicio}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicio(RespostasParaScriptParser.InicioContext ctx);
	/**
	 * Visit a parse tree produced by {@link RespostasParaScriptParser#comandos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandos(RespostasParaScriptParser.ComandosContext ctx);
	/**
	 * Visit a parse tree produced by {@link RespostasParaScriptParser#script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScript(RespostasParaScriptParser.ScriptContext ctx);
	/**
	 * Visit a parse tree produced by {@link RespostasParaScriptParser#atributo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtributo(RespostasParaScriptParser.AtributoContext ctx);
	/**
	 * Visit a parse tree produced by {@link RespostasParaScriptParser#email}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmail(RespostasParaScriptParser.EmailContext ctx);
	/**
	 * Visit a parse tree produced by {@link RespostasParaScriptParser#identificador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentificador(RespostasParaScriptParser.IdentificadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link RespostasParaScriptParser#quantidade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantidade(RespostasParaScriptParser.QuantidadeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RespostasParaScriptParser#metodo_pagamento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetodo_pagamento(RespostasParaScriptParser.Metodo_pagamentoContext ctx);
	/**
	 * Visit a parse tree produced by {@link RespostasParaScriptParser#plano_pagamento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlano_pagamento(RespostasParaScriptParser.Plano_pagamentoContext ctx);
	/**
	 * Visit a parse tree produced by {@link RespostasParaScriptParser#nome}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNome(RespostasParaScriptParser.NomeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RespostasParaScriptParser#tipo_desconto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_desconto(RespostasParaScriptParser.Tipo_descontoContext ctx);
	/**
	 * Visit a parse tree produced by {@link RespostasParaScriptParser#percentagem_desconto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPercentagem_desconto(RespostasParaScriptParser.Percentagem_descontoContext ctx);
	/**
	 * Visit a parse tree produced by {@link RespostasParaScriptParser#fatura}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFatura(RespostasParaScriptParser.FaturaContext ctx);
	/**
	 * Visit a parse tree produced by {@link RespostasParaScriptParser#valor_desconto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValor_desconto(RespostasParaScriptParser.Valor_descontoContext ctx);
	/**
	 * Visit a parse tree produced by {@link RespostasParaScriptParser#tipo_cliente}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_cliente(RespostasParaScriptParser.Tipo_clienteContext ctx);
}