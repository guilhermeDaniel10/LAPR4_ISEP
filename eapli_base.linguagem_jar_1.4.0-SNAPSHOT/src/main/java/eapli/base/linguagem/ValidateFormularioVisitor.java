// Generated from ValidateFormulario.g4 by ANTLR 4.7.2
package eapli.base.linguagem;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ValidateFormularioParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ValidateFormularioVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ValidateFormularioParser#inicio}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicio(ValidateFormularioParser.InicioContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidateFormularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(ValidateFormularioParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidateFormularioParser#valida}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValida(ValidateFormularioParser.ValidaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidateFormularioParser#tipoDado}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoDado(ValidateFormularioParser.TipoDadoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidateFormularioParser#obrigatoriedade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObrigatoriedade(ValidateFormularioParser.ObrigatoriedadeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidateFormularioParser#posicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPosicao(ValidateFormularioParser.PosicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidateFormularioParser#dependencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDependencia(ValidateFormularioParser.DependenciaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidateFormularioParser#expressaoRegular}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressaoRegular(ValidateFormularioParser.ExpressaoRegularContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidateFormularioParser#resposta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResposta(ValidateFormularioParser.RespostaContext ctx);
}