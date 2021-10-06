package eapli.base.validascripttarefas;

// Generated from ValidaScriptTarefas.g4 by ANTLR 4.7.2
import eapli.base.validascripttarefas.ValidaScriptTarefasParser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ValidaScriptTarefasParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ValidaScriptTarefasVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ValidaScriptTarefasParser#inicio}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicio(ValidaScriptTarefasParser.InicioContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptTarefasParser#comandos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandos(ValidaScriptTarefasParser.ComandosContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptTarefasParser#email}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmail(ValidaScriptTarefasParser.EmailContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptTarefasParser#identificador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentificador(ValidaScriptTarefasParser.IdentificadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptTarefasParser#quantidade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantidade(ValidaScriptTarefasParser.QuantidadeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptTarefasParser#metodo_pagamento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetodo_pagamento(ValidaScriptTarefasParser.Metodo_pagamentoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptTarefasParser#plano_pagamento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlano_pagamento(ValidaScriptTarefasParser.Plano_pagamentoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptTarefasParser#nome}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNome(ValidaScriptTarefasParser.NomeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptTarefasParser#tipo_desconto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_desconto(ValidaScriptTarefasParser.Tipo_descontoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptTarefasParser#recorrencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecorrencia(ValidaScriptTarefasParser.RecorrenciaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptTarefasParser#percentagem_desconto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPercentagem_desconto(ValidaScriptTarefasParser.Percentagem_descontoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptTarefasParser#fatura}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFatura(ValidaScriptTarefasParser.FaturaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptTarefasParser#valor_desconto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValor_desconto(ValidaScriptTarefasParser.Valor_descontoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptTarefasParser#data_limite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData_limite(ValidaScriptTarefasParser.Data_limiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidaScriptTarefasParser#tipo_cliente}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_cliente(ValidaScriptTarefasParser.Tipo_clienteContext ctx);
}