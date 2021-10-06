/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.validascripttarefas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public class EvalValidarScriptsVisitor extends  ValidaScriptTarefasBaseVisitor<String> {

        private List<String> stack = new ArrayList<>();
        private int quantidadeIDs = 0;
        
        public List<String> getStack(){
             return this.stack; 
        }
        
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
        public String visitComandos(ValidaScriptTarefasParser.ComandosContext ctx) {
            if (!stack.isEmpty() && !ctx.getText().matches("IDENTIFICADOR|identificador")) {
                if (stack.contains(ctx.getText())) {
                     throw new IllegalArgumentException("Os scripts nao suportam mais do que um atributo do tipo "+ ctx.getText());
                }
            }
            stack.add(ctx.getText());
            return visitChildren(ctx); 
        }
	
        /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
        public String visitEmail(ValidaScriptTarefasParser.EmailContext ctx) { 
            return visitChildren(ctx); 
        }
        
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
        public String visitIdentificador(ValidaScriptTarefasParser.IdentificadorContext ctx) { 
            quantidadeIDs++;
            if (quantidadeIDs>2) {
               throw new IllegalArgumentException("Os scripts só suportam até 2 "+ ctx.getText());
            }
            return visitChildren(ctx); 
        }
	
        /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
        public String visitQuantidade(ValidaScriptTarefasParser.QuantidadeContext ctx) {
            return visitChildren(ctx); 
        }
	
        /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
        public String visitMetodo_pagamento(ValidaScriptTarefasParser.Metodo_pagamentoContext ctx) { 
            return visitChildren(ctx); 
        }
	
        /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
        public String visitPlano_pagamento(ValidaScriptTarefasParser.Plano_pagamentoContext ctx) { 
            return visitChildren(ctx); 
        }
	
        /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
        public String visitNome(ValidaScriptTarefasParser.NomeContext ctx) { 
            return visitChildren(ctx); 
        }
	
        /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
        public String visitTipo_desconto(ValidaScriptTarefasParser.Tipo_descontoContext ctx) { 
            return visitChildren(ctx); 
        }
	
        /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
        public String visitRecorrencia(ValidaScriptTarefasParser.RecorrenciaContext ctx) { 
            return visitChildren(ctx); 
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
        public String visitPercentagem_desconto(ValidaScriptTarefasParser.Percentagem_descontoContext ctx) { 
            return visitChildren(ctx); 
        }
	
        /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
        public String visitFatura(ValidaScriptTarefasParser.FaturaContext ctx) { 
            return visitChildren(ctx); 
        }
	
        /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
        public String visitValor_desconto(ValidaScriptTarefasParser.Valor_descontoContext ctx) {
            return visitChildren(ctx); 
        }
	
        /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
        public String visitData_limite(ValidaScriptTarefasParser.Data_limiteContext ctx) { 
            return visitChildren(ctx); 
        }
	
        /**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
        public String visitTipo_cliente(ValidaScriptTarefasParser.Tipo_clienteContext ctx) {
            return visitChildren(ctx); 
        }
        
}
