package eapli.base.tarefasautomaticas;

// Generated from TarefasAutomaticas.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TarefasAutomaticasParser}.
 */
public interface TarefasAutomaticasListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TarefasAutomaticasParser#inicio}.
	 * @param ctx the parse tree
	 */
	void enterInicio(TarefasAutomaticasParser.InicioContext ctx);
	/**
	 * Exit a parse tree produced by {@link TarefasAutomaticasParser#inicio}.
	 * @param ctx the parse tree
	 */
	void exitInicio(TarefasAutomaticasParser.InicioContext ctx);
	/**
	 * Enter a parse tree produced by {@link TarefasAutomaticasParser#comandos}.
	 * @param ctx the parse tree
	 */
	void enterComandos(TarefasAutomaticasParser.ComandosContext ctx);
	/**
	 * Exit a parse tree produced by {@link TarefasAutomaticasParser#comandos}.
	 * @param ctx the parse tree
	 */
	void exitComandos(TarefasAutomaticasParser.ComandosContext ctx);
	/**
	 * Enter a parse tree produced by {@link TarefasAutomaticasParser#email}.
	 * @param ctx the parse tree
	 */
	void enterEmail(TarefasAutomaticasParser.EmailContext ctx);
	/**
	 * Exit a parse tree produced by {@link TarefasAutomaticasParser#email}.
	 * @param ctx the parse tree
	 */
	void exitEmail(TarefasAutomaticasParser.EmailContext ctx);
	/**
	 * Enter a parse tree produced by {@link TarefasAutomaticasParser#identificador}.
	 * @param ctx the parse tree
	 */
	void enterIdentificador(TarefasAutomaticasParser.IdentificadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link TarefasAutomaticasParser#identificador}.
	 * @param ctx the parse tree
	 */
	void exitIdentificador(TarefasAutomaticasParser.IdentificadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link TarefasAutomaticasParser#quantidade}.
	 * @param ctx the parse tree
	 */
	void enterQuantidade(TarefasAutomaticasParser.QuantidadeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TarefasAutomaticasParser#quantidade}.
	 * @param ctx the parse tree
	 */
	void exitQuantidade(TarefasAutomaticasParser.QuantidadeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TarefasAutomaticasParser#metodo_pagamento}.
	 * @param ctx the parse tree
	 */
	void enterMetodo_pagamento(TarefasAutomaticasParser.Metodo_pagamentoContext ctx);
	/**
	 * Exit a parse tree produced by {@link TarefasAutomaticasParser#metodo_pagamento}.
	 * @param ctx the parse tree
	 */
	void exitMetodo_pagamento(TarefasAutomaticasParser.Metodo_pagamentoContext ctx);
	/**
	 * Enter a parse tree produced by {@link TarefasAutomaticasParser#plano_pagamento}.
	 * @param ctx the parse tree
	 */
	void enterPlano_pagamento(TarefasAutomaticasParser.Plano_pagamentoContext ctx);
	/**
	 * Exit a parse tree produced by {@link TarefasAutomaticasParser#plano_pagamento}.
	 * @param ctx the parse tree
	 */
	void exitPlano_pagamento(TarefasAutomaticasParser.Plano_pagamentoContext ctx);
	/**
	 * Enter a parse tree produced by {@link TarefasAutomaticasParser#nome}.
	 * @param ctx the parse tree
	 */
	void enterNome(TarefasAutomaticasParser.NomeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TarefasAutomaticasParser#nome}.
	 * @param ctx the parse tree
	 */
	void exitNome(TarefasAutomaticasParser.NomeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TarefasAutomaticasParser#tipo_desconto}.
	 * @param ctx the parse tree
	 */
	void enterTipo_desconto(TarefasAutomaticasParser.Tipo_descontoContext ctx);
	/**
	 * Exit a parse tree produced by {@link TarefasAutomaticasParser#tipo_desconto}.
	 * @param ctx the parse tree
	 */
	void exitTipo_desconto(TarefasAutomaticasParser.Tipo_descontoContext ctx);
	/**
	 * Enter a parse tree produced by {@link TarefasAutomaticasParser#recorrencia}.
	 * @param ctx the parse tree
	 */
	void enterRecorrencia(TarefasAutomaticasParser.RecorrenciaContext ctx);
	/**
	 * Exit a parse tree produced by {@link TarefasAutomaticasParser#recorrencia}.
	 * @param ctx the parse tree
	 */
	void exitRecorrencia(TarefasAutomaticasParser.RecorrenciaContext ctx);
	/**
	 * Enter a parse tree produced by {@link TarefasAutomaticasParser#percentagem_desconto}.
	 * @param ctx the parse tree
	 */
	void enterPercentagem_desconto(TarefasAutomaticasParser.Percentagem_descontoContext ctx);
	/**
	 * Exit a parse tree produced by {@link TarefasAutomaticasParser#percentagem_desconto}.
	 * @param ctx the parse tree
	 */
	void exitPercentagem_desconto(TarefasAutomaticasParser.Percentagem_descontoContext ctx);
	/**
	 * Enter a parse tree produced by {@link TarefasAutomaticasParser#fatura}.
	 * @param ctx the parse tree
	 */
	void enterFatura(TarefasAutomaticasParser.FaturaContext ctx);
	/**
	 * Exit a parse tree produced by {@link TarefasAutomaticasParser#fatura}.
	 * @param ctx the parse tree
	 */
	void exitFatura(TarefasAutomaticasParser.FaturaContext ctx);
	/**
	 * Enter a parse tree produced by {@link TarefasAutomaticasParser#valor_desconto}.
	 * @param ctx the parse tree
	 */
	void enterValor_desconto(TarefasAutomaticasParser.Valor_descontoContext ctx);
	/**
	 * Exit a parse tree produced by {@link TarefasAutomaticasParser#valor_desconto}.
	 * @param ctx the parse tree
	 */
	void exitValor_desconto(TarefasAutomaticasParser.Valor_descontoContext ctx);
	/**
	 * Enter a parse tree produced by {@link TarefasAutomaticasParser#tipo_cliente}.
	 * @param ctx the parse tree
	 */
	void enterTipo_cliente(TarefasAutomaticasParser.Tipo_clienteContext ctx);
	/**
	 * Exit a parse tree produced by {@link TarefasAutomaticasParser#tipo_cliente}.
	 * @param ctx the parse tree
	 */
	void exitTipo_cliente(TarefasAutomaticasParser.Tipo_clienteContext ctx);
}