package eapli.base.validascripttarefas;

// Generated from ValidaScriptTarefas.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ValidaScriptTarefasParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TIPO_CLIENTE=1, DATA_LIMITE=2, VALOR_DESCONTO=3, FATURA=4, PERCENTAGEM_DESCONTO=5, 
		RECORRENCIA=6, TIPO_DESCONTO=7, NOME=8, IDENTIFICADOR=9, EMAIL=10, QUANTIDADE=11, 
		PLANO_PAGAMENTO=12, METODO_PAGAMENTO=13, NEWLINE=14, WS=15, NL=16;
	public static final int
		RULE_inicio = 0, RULE_comandos = 1, RULE_email = 2, RULE_identificador = 3, 
		RULE_quantidade = 4, RULE_metodo_pagamento = 5, RULE_plano_pagamento = 6, 
		RULE_nome = 7, RULE_tipo_desconto = 8, RULE_recorrencia = 9, RULE_percentagem_desconto = 10, 
		RULE_fatura = 11, RULE_valor_desconto = 12, RULE_data_limite = 13, RULE_tipo_cliente = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"inicio", "comandos", "email", "identificador", "quantidade", "metodo_pagamento", 
			"plano_pagamento", "nome", "tipo_desconto", "recorrencia", "percentagem_desconto", 
			"fatura", "valor_desconto", "data_limite", "tipo_cliente"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TIPO_CLIENTE", "DATA_LIMITE", "VALOR_DESCONTO", "FATURA", "PERCENTAGEM_DESCONTO", 
			"RECORRENCIA", "TIPO_DESCONTO", "NOME", "IDENTIFICADOR", "EMAIL", "QUANTIDADE", 
			"PLANO_PAGAMENTO", "METODO_PAGAMENTO", "NEWLINE", "WS", "NL"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ValidaScriptTarefas.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ValidaScriptTarefasParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class InicioContext extends ParserRuleContext {
		public List<ComandosContext> comandos() {
			return getRuleContexts(ComandosContext.class);
		}
		public ComandosContext comandos(int i) {
			return getRuleContext(ComandosContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ValidaScriptTarefasParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ValidaScriptTarefasParser.NEWLINE, i);
		}
		public InicioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicio; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptTarefasVisitor ) return ((ValidaScriptTarefasVisitor<? extends T>)visitor).visitInicio(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InicioContext inicio() throws RecognitionException {
		InicioContext _localctx = new InicioContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_inicio);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TIPO_CLIENTE) | (1L << DATA_LIMITE) | (1L << VALOR_DESCONTO) | (1L << FATURA) | (1L << PERCENTAGEM_DESCONTO) | (1L << RECORRENCIA) | (1L << TIPO_DESCONTO) | (1L << NOME) | (1L << IDENTIFICADOR) | (1L << EMAIL) | (1L << QUANTIDADE) | (1L << PLANO_PAGAMENTO) | (1L << METODO_PAGAMENTO))) != 0)) {
				{
				setState(34);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(30);
					comandos();
					setState(31);
					match(NEWLINE);
					}
					break;
				case 2:
					{
					setState(33);
					comandos();
					}
					break;
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandosContext extends ParserRuleContext {
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public QuantidadeContext quantidade() {
			return getRuleContext(QuantidadeContext.class,0);
		}
		public Metodo_pagamentoContext metodo_pagamento() {
			return getRuleContext(Metodo_pagamentoContext.class,0);
		}
		public Plano_pagamentoContext plano_pagamento() {
			return getRuleContext(Plano_pagamentoContext.class,0);
		}
		public EmailContext email() {
			return getRuleContext(EmailContext.class,0);
		}
		public NomeContext nome() {
			return getRuleContext(NomeContext.class,0);
		}
		public Tipo_descontoContext tipo_desconto() {
			return getRuleContext(Tipo_descontoContext.class,0);
		}
		public RecorrenciaContext recorrencia() {
			return getRuleContext(RecorrenciaContext.class,0);
		}
		public Percentagem_descontoContext percentagem_desconto() {
			return getRuleContext(Percentagem_descontoContext.class,0);
		}
		public FaturaContext fatura() {
			return getRuleContext(FaturaContext.class,0);
		}
		public Valor_descontoContext valor_desconto() {
			return getRuleContext(Valor_descontoContext.class,0);
		}
		public Data_limiteContext data_limite() {
			return getRuleContext(Data_limiteContext.class,0);
		}
		public Tipo_clienteContext tipo_cliente() {
			return getRuleContext(Tipo_clienteContext.class,0);
		}
		public ComandosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandos; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptTarefasVisitor ) return ((ValidaScriptTarefasVisitor<? extends T>)visitor).visitComandos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandosContext comandos() throws RecognitionException {
		ComandosContext _localctx = new ComandosContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_comandos);
		try {
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFICADOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				identificador();
				}
				break;
			case QUANTIDADE:
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				quantidade();
				}
				break;
			case METODO_PAGAMENTO:
				enterOuterAlt(_localctx, 3);
				{
				setState(41);
				metodo_pagamento();
				}
				break;
			case PLANO_PAGAMENTO:
				enterOuterAlt(_localctx, 4);
				{
				setState(42);
				plano_pagamento();
				}
				break;
			case EMAIL:
				enterOuterAlt(_localctx, 5);
				{
				setState(43);
				email();
				}
				break;
			case NOME:
				enterOuterAlt(_localctx, 6);
				{
				setState(44);
				nome();
				}
				break;
			case TIPO_DESCONTO:
				enterOuterAlt(_localctx, 7);
				{
				setState(45);
				tipo_desconto();
				}
				break;
			case RECORRENCIA:
				enterOuterAlt(_localctx, 8);
				{
				setState(46);
				recorrencia();
				}
				break;
			case PERCENTAGEM_DESCONTO:
				enterOuterAlt(_localctx, 9);
				{
				setState(47);
				percentagem_desconto();
				}
				break;
			case FATURA:
				enterOuterAlt(_localctx, 10);
				{
				setState(48);
				fatura();
				}
				break;
			case VALOR_DESCONTO:
				enterOuterAlt(_localctx, 11);
				{
				setState(49);
				valor_desconto();
				}
				break;
			case DATA_LIMITE:
				enterOuterAlt(_localctx, 12);
				{
				setState(50);
				data_limite();
				}
				break;
			case TIPO_CLIENTE:
				enterOuterAlt(_localctx, 13);
				{
				setState(51);
				tipo_cliente();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EmailContext extends ParserRuleContext {
		public TerminalNode EMAIL() { return getToken(ValidaScriptTarefasParser.EMAIL, 0); }
		public EmailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_email; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptTarefasVisitor ) return ((ValidaScriptTarefasVisitor<? extends T>)visitor).visitEmail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmailContext email() throws RecognitionException {
		EmailContext _localctx = new EmailContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_email);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(EMAIL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentificadorContext extends ParserRuleContext {
		public TerminalNode IDENTIFICADOR() { return getToken(ValidaScriptTarefasParser.IDENTIFICADOR, 0); }
		public IdentificadorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identificador; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptTarefasVisitor ) return ((ValidaScriptTarefasVisitor<? extends T>)visitor).visitIdentificador(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentificadorContext identificador() throws RecognitionException {
		IdentificadorContext _localctx = new IdentificadorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_identificador);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(IDENTIFICADOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantidadeContext extends ParserRuleContext {
		public TerminalNode QUANTIDADE() { return getToken(ValidaScriptTarefasParser.QUANTIDADE, 0); }
		public QuantidadeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantidade; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptTarefasVisitor ) return ((ValidaScriptTarefasVisitor<? extends T>)visitor).visitQuantidade(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantidadeContext quantidade() throws RecognitionException {
		QuantidadeContext _localctx = new QuantidadeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_quantidade);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(QUANTIDADE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Metodo_pagamentoContext extends ParserRuleContext {
		public TerminalNode METODO_PAGAMENTO() { return getToken(ValidaScriptTarefasParser.METODO_PAGAMENTO, 0); }
		public Metodo_pagamentoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metodo_pagamento; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptTarefasVisitor ) return ((ValidaScriptTarefasVisitor<? extends T>)visitor).visitMetodo_pagamento(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Metodo_pagamentoContext metodo_pagamento() throws RecognitionException {
		Metodo_pagamentoContext _localctx = new Metodo_pagamentoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_metodo_pagamento);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(METODO_PAGAMENTO);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Plano_pagamentoContext extends ParserRuleContext {
		public TerminalNode PLANO_PAGAMENTO() { return getToken(ValidaScriptTarefasParser.PLANO_PAGAMENTO, 0); }
		public Plano_pagamentoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plano_pagamento; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptTarefasVisitor ) return ((ValidaScriptTarefasVisitor<? extends T>)visitor).visitPlano_pagamento(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Plano_pagamentoContext plano_pagamento() throws RecognitionException {
		Plano_pagamentoContext _localctx = new Plano_pagamentoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_plano_pagamento);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(PLANO_PAGAMENTO);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NomeContext extends ParserRuleContext {
		public TerminalNode NOME() { return getToken(ValidaScriptTarefasParser.NOME, 0); }
		public NomeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nome; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptTarefasVisitor ) return ((ValidaScriptTarefasVisitor<? extends T>)visitor).visitNome(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NomeContext nome() throws RecognitionException {
		NomeContext _localctx = new NomeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_nome);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(NOME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Tipo_descontoContext extends ParserRuleContext {
		public TerminalNode TIPO_DESCONTO() { return getToken(ValidaScriptTarefasParser.TIPO_DESCONTO, 0); }
		public Tipo_descontoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_desconto; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptTarefasVisitor ) return ((ValidaScriptTarefasVisitor<? extends T>)visitor).visitTipo_desconto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_descontoContext tipo_desconto() throws RecognitionException {
		Tipo_descontoContext _localctx = new Tipo_descontoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tipo_desconto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(TIPO_DESCONTO);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RecorrenciaContext extends ParserRuleContext {
		public TerminalNode RECORRENCIA() { return getToken(ValidaScriptTarefasParser.RECORRENCIA, 0); }
		public RecorrenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recorrencia; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptTarefasVisitor ) return ((ValidaScriptTarefasVisitor<? extends T>)visitor).visitRecorrencia(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecorrenciaContext recorrencia() throws RecognitionException {
		RecorrenciaContext _localctx = new RecorrenciaContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_recorrencia);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(RECORRENCIA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Percentagem_descontoContext extends ParserRuleContext {
		public TerminalNode PERCENTAGEM_DESCONTO() { return getToken(ValidaScriptTarefasParser.PERCENTAGEM_DESCONTO, 0); }
		public Percentagem_descontoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_percentagem_desconto; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptTarefasVisitor ) return ((ValidaScriptTarefasVisitor<? extends T>)visitor).visitPercentagem_desconto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Percentagem_descontoContext percentagem_desconto() throws RecognitionException {
		Percentagem_descontoContext _localctx = new Percentagem_descontoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_percentagem_desconto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(PERCENTAGEM_DESCONTO);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FaturaContext extends ParserRuleContext {
		public TerminalNode FATURA() { return getToken(ValidaScriptTarefasParser.FATURA, 0); }
		public FaturaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fatura; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptTarefasVisitor ) return ((ValidaScriptTarefasVisitor<? extends T>)visitor).visitFatura(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FaturaContext fatura() throws RecognitionException {
		FaturaContext _localctx = new FaturaContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_fatura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(FATURA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Valor_descontoContext extends ParserRuleContext {
		public TerminalNode VALOR_DESCONTO() { return getToken(ValidaScriptTarefasParser.VALOR_DESCONTO, 0); }
		public Valor_descontoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valor_desconto; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptTarefasVisitor ) return ((ValidaScriptTarefasVisitor<? extends T>)visitor).visitValor_desconto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Valor_descontoContext valor_desconto() throws RecognitionException {
		Valor_descontoContext _localctx = new Valor_descontoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_valor_desconto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(VALOR_DESCONTO);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Data_limiteContext extends ParserRuleContext {
		public TerminalNode DATA_LIMITE() { return getToken(ValidaScriptTarefasParser.DATA_LIMITE, 0); }
		public Data_limiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_limite; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptTarefasVisitor ) return ((ValidaScriptTarefasVisitor<? extends T>)visitor).visitData_limite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Data_limiteContext data_limite() throws RecognitionException {
		Data_limiteContext _localctx = new Data_limiteContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_data_limite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(DATA_LIMITE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Tipo_clienteContext extends ParserRuleContext {
		public TerminalNode TIPO_CLIENTE() { return getToken(ValidaScriptTarefasParser.TIPO_CLIENTE, 0); }
		public Tipo_clienteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_cliente; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptTarefasVisitor ) return ((ValidaScriptTarefasVisitor<? extends T>)visitor).visitTipo_cliente(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_clienteContext tipo_cliente() throws RecognitionException {
		Tipo_clienteContext _localctx = new Tipo_clienteContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_tipo_cliente);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(TIPO_CLIENTE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\22S\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\7\2%\n\2"+
		"\f\2\16\2(\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5"+
		"\3\67\n\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\2\2\21\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36\2\2\2Q\2&\3\2\2\2\4\66\3\2\2\2\68\3"+
		"\2\2\2\b:\3\2\2\2\n<\3\2\2\2\f>\3\2\2\2\16@\3\2\2\2\20B\3\2\2\2\22D\3"+
		"\2\2\2\24F\3\2\2\2\26H\3\2\2\2\30J\3\2\2\2\32L\3\2\2\2\34N\3\2\2\2\36"+
		"P\3\2\2\2 !\5\4\3\2!\"\7\20\2\2\"%\3\2\2\2#%\5\4\3\2$ \3\2\2\2$#\3\2\2"+
		"\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'\3\3\2\2\2(&\3\2\2\2)\67\5\b\5\2*\67"+
		"\5\n\6\2+\67\5\f\7\2,\67\5\16\b\2-\67\5\6\4\2.\67\5\20\t\2/\67\5\22\n"+
		"\2\60\67\5\24\13\2\61\67\5\26\f\2\62\67\5\30\r\2\63\67\5\32\16\2\64\67"+
		"\5\34\17\2\65\67\5\36\20\2\66)\3\2\2\2\66*\3\2\2\2\66+\3\2\2\2\66,\3\2"+
		"\2\2\66-\3\2\2\2\66.\3\2\2\2\66/\3\2\2\2\66\60\3\2\2\2\66\61\3\2\2\2\66"+
		"\62\3\2\2\2\66\63\3\2\2\2\66\64\3\2\2\2\66\65\3\2\2\2\67\5\3\2\2\289\7"+
		"\f\2\29\7\3\2\2\2:;\7\13\2\2;\t\3\2\2\2<=\7\r\2\2=\13\3\2\2\2>?\7\17\2"+
		"\2?\r\3\2\2\2@A\7\16\2\2A\17\3\2\2\2BC\7\n\2\2C\21\3\2\2\2DE\7\t\2\2E"+
		"\23\3\2\2\2FG\7\b\2\2G\25\3\2\2\2HI\7\7\2\2I\27\3\2\2\2JK\7\6\2\2K\31"+
		"\3\2\2\2LM\7\5\2\2M\33\3\2\2\2NO\7\4\2\2O\35\3\2\2\2PQ\7\3\2\2Q\37\3\2"+
		"\2\2\5$&\66";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}