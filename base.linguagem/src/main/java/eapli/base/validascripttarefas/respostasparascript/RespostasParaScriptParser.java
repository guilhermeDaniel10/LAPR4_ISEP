package eapli.base.validascripttarefas.respostasparascript;

// Generated from RespostasParaScript.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RespostasParaScriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SCRIPT=1, FATURA=2, CLI=3, PROD=4, EMAIL=5, INTEIRO_QUANTIDADE=6, INTEIRO=7, 
		NUMERARIO=8, PLANO_PAGAMENTO=9, MB=10, CHEQUE=11, NOME=12, TIPO_DESCONTO=13, 
		RECORRENCIA=14, PERCENTAGEM_DESCONTO=15, COUNTRY_CODE=16, TWO_DIGITS=17, 
		BANK=18, AGENCY=19, ACOUNT_NUMBER=20, VALOR_DESCONTO=21, TIPO_CLIENTE=22, 
		NEWLINE=23, WS=24, NL=25;
	public static final int
		RULE_inicio = 0, RULE_comandos = 1, RULE_script = 2, RULE_atributo = 3, 
		RULE_email = 4, RULE_identificador = 5, RULE_quantidade = 6, RULE_metodo_pagamento = 7, 
		RULE_plano_pagamento = 8, RULE_nome = 9, RULE_tipo_desconto = 10, RULE_percentagem_desconto = 11, 
		RULE_fatura = 12, RULE_valor_desconto = 13, RULE_tipo_cliente = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"inicio", "comandos", "script", "atributo", "email", "identificador", 
			"quantidade", "metodo_pagamento", "plano_pagamento", "nome", "tipo_desconto", 
			"percentagem_desconto", "fatura", "valor_desconto", "tipo_cliente"
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
			null, "SCRIPT", "FATURA", "CLI", "PROD", "EMAIL", "INTEIRO_QUANTIDADE", 
			"INTEIRO", "NUMERARIO", "PLANO_PAGAMENTO", "MB", "CHEQUE", "NOME", "TIPO_DESCONTO", 
			"RECORRENCIA", "PERCENTAGEM_DESCONTO", "COUNTRY_CODE", "TWO_DIGITS", 
			"BANK", "AGENCY", "ACOUNT_NUMBER", "VALOR_DESCONTO", "TIPO_CLIENTE", 
			"NEWLINE", "WS", "NL"
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
	public String getGrammarFileName() { return "RespostasParaScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RespostasParaScriptParser(TokenStream input) {
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
		public List<TerminalNode> NEWLINE() { return getTokens(RespostasParaScriptParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(RespostasParaScriptParser.NEWLINE, i);
		}
		public InicioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicio; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RespostasParaScriptVisitor ) return ((RespostasParaScriptVisitor<? extends T>)visitor).visitInicio(this);
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
			while (_la==SCRIPT) {
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
		public ScriptContext script() {
			return getRuleContext(ScriptContext.class,0);
		}
		public AtributoContext atributo() {
			return getRuleContext(AtributoContext.class,0);
		}
		public ComandosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandos; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RespostasParaScriptVisitor ) return ((RespostasParaScriptVisitor<? extends T>)visitor).visitComandos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandosContext comandos() throws RecognitionException {
		ComandosContext _localctx = new ComandosContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_comandos);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			script();
			setState(40);
			atributo();
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

	public static class ScriptContext extends ParserRuleContext {
		public TerminalNode SCRIPT() { return getToken(RespostasParaScriptParser.SCRIPT, 0); }
		public ScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_script; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RespostasParaScriptVisitor ) return ((RespostasParaScriptVisitor<? extends T>)visitor).visitScript(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScriptContext script() throws RecognitionException {
		ScriptContext _localctx = new ScriptContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_script);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(SCRIPT);
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

	public static class AtributoContext extends ParserRuleContext {
		public EmailContext email() {
			return getRuleContext(EmailContext.class,0);
		}
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
		public NomeContext nome() {
			return getRuleContext(NomeContext.class,0);
		}
		public Tipo_descontoContext tipo_desconto() {
			return getRuleContext(Tipo_descontoContext.class,0);
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
		public Tipo_clienteContext tipo_cliente() {
			return getRuleContext(Tipo_clienteContext.class,0);
		}
		public AtributoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atributo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RespostasParaScriptVisitor ) return ((RespostasParaScriptVisitor<? extends T>)visitor).visitAtributo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtributoContext atributo() throws RecognitionException {
		AtributoContext _localctx = new AtributoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_atributo);
		try {
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EMAIL:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				email();
				}
				break;
			case CLI:
			case PROD:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				identificador();
				}
				break;
			case INTEIRO_QUANTIDADE:
				enterOuterAlt(_localctx, 3);
				{
				setState(46);
				quantidade();
				}
				break;
			case NUMERARIO:
			case MB:
			case CHEQUE:
				enterOuterAlt(_localctx, 4);
				{
				setState(47);
				metodo_pagamento();
				}
				break;
			case PLANO_PAGAMENTO:
				enterOuterAlt(_localctx, 5);
				{
				setState(48);
				plano_pagamento();
				}
				break;
			case NOME:
				enterOuterAlt(_localctx, 6);
				{
				setState(49);
				nome();
				}
				break;
			case TIPO_DESCONTO:
				enterOuterAlt(_localctx, 7);
				{
				setState(50);
				tipo_desconto();
				}
				break;
			case PERCENTAGEM_DESCONTO:
				enterOuterAlt(_localctx, 8);
				{
				setState(51);
				percentagem_desconto();
				}
				break;
			case FATURA:
				enterOuterAlt(_localctx, 9);
				{
				setState(52);
				fatura();
				}
				break;
			case VALOR_DESCONTO:
				enterOuterAlt(_localctx, 10);
				{
				setState(53);
				valor_desconto();
				}
				break;
			case TIPO_CLIENTE:
				enterOuterAlt(_localctx, 11);
				{
				setState(54);
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
		public TerminalNode EMAIL() { return getToken(RespostasParaScriptParser.EMAIL, 0); }
		public EmailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_email; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RespostasParaScriptVisitor ) return ((RespostasParaScriptVisitor<? extends T>)visitor).visitEmail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmailContext email() throws RecognitionException {
		EmailContext _localctx = new EmailContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_email);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
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
		public TerminalNode CLI() { return getToken(RespostasParaScriptParser.CLI, 0); }
		public TerminalNode PROD() { return getToken(RespostasParaScriptParser.PROD, 0); }
		public IdentificadorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identificador; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RespostasParaScriptVisitor ) return ((RespostasParaScriptVisitor<? extends T>)visitor).visitIdentificador(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentificadorContext identificador() throws RecognitionException {
		IdentificadorContext _localctx = new IdentificadorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_identificador);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_la = _input.LA(1);
			if ( !(_la==CLI || _la==PROD) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class QuantidadeContext extends ParserRuleContext {
		public TerminalNode INTEIRO_QUANTIDADE() { return getToken(RespostasParaScriptParser.INTEIRO_QUANTIDADE, 0); }
		public QuantidadeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantidade; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RespostasParaScriptVisitor ) return ((RespostasParaScriptVisitor<? extends T>)visitor).visitQuantidade(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantidadeContext quantidade() throws RecognitionException {
		QuantidadeContext _localctx = new QuantidadeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_quantidade);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(INTEIRO_QUANTIDADE);
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
		public TerminalNode NUMERARIO() { return getToken(RespostasParaScriptParser.NUMERARIO, 0); }
		public TerminalNode MB() { return getToken(RespostasParaScriptParser.MB, 0); }
		public TerminalNode CHEQUE() { return getToken(RespostasParaScriptParser.CHEQUE, 0); }
		public Metodo_pagamentoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metodo_pagamento; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RespostasParaScriptVisitor ) return ((RespostasParaScriptVisitor<? extends T>)visitor).visitMetodo_pagamento(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Metodo_pagamentoContext metodo_pagamento() throws RecognitionException {
		Metodo_pagamentoContext _localctx = new Metodo_pagamentoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_metodo_pagamento);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMERARIO) | (1L << MB) | (1L << CHEQUE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Plano_pagamentoContext extends ParserRuleContext {
		public TerminalNode PLANO_PAGAMENTO() { return getToken(RespostasParaScriptParser.PLANO_PAGAMENTO, 0); }
		public Plano_pagamentoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plano_pagamento; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RespostasParaScriptVisitor ) return ((RespostasParaScriptVisitor<? extends T>)visitor).visitPlano_pagamento(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Plano_pagamentoContext plano_pagamento() throws RecognitionException {
		Plano_pagamentoContext _localctx = new Plano_pagamentoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_plano_pagamento);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
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
		public TerminalNode NOME() { return getToken(RespostasParaScriptParser.NOME, 0); }
		public NomeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nome; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RespostasParaScriptVisitor ) return ((RespostasParaScriptVisitor<? extends T>)visitor).visitNome(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NomeContext nome() throws RecognitionException {
		NomeContext _localctx = new NomeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_nome);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
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
		public TerminalNode TIPO_DESCONTO() { return getToken(RespostasParaScriptParser.TIPO_DESCONTO, 0); }
		public Tipo_descontoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_desconto; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RespostasParaScriptVisitor ) return ((RespostasParaScriptVisitor<? extends T>)visitor).visitTipo_desconto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_descontoContext tipo_desconto() throws RecognitionException {
		Tipo_descontoContext _localctx = new Tipo_descontoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tipo_desconto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
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

	public static class Percentagem_descontoContext extends ParserRuleContext {
		public TerminalNode PERCENTAGEM_DESCONTO() { return getToken(RespostasParaScriptParser.PERCENTAGEM_DESCONTO, 0); }
		public Percentagem_descontoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_percentagem_desconto; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RespostasParaScriptVisitor ) return ((RespostasParaScriptVisitor<? extends T>)visitor).visitPercentagem_desconto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Percentagem_descontoContext percentagem_desconto() throws RecognitionException {
		Percentagem_descontoContext _localctx = new Percentagem_descontoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_percentagem_desconto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
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
		public TerminalNode FATURA() { return getToken(RespostasParaScriptParser.FATURA, 0); }
		public FaturaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fatura; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RespostasParaScriptVisitor ) return ((RespostasParaScriptVisitor<? extends T>)visitor).visitFatura(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FaturaContext fatura() throws RecognitionException {
		FaturaContext _localctx = new FaturaContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_fatura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
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
		public TerminalNode VALOR_DESCONTO() { return getToken(RespostasParaScriptParser.VALOR_DESCONTO, 0); }
		public Valor_descontoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valor_desconto; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RespostasParaScriptVisitor ) return ((RespostasParaScriptVisitor<? extends T>)visitor).visitValor_desconto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Valor_descontoContext valor_desconto() throws RecognitionException {
		Valor_descontoContext _localctx = new Valor_descontoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_valor_desconto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
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

	public static class Tipo_clienteContext extends ParserRuleContext {
		public TerminalNode TIPO_CLIENTE() { return getToken(RespostasParaScriptParser.TIPO_CLIENTE, 0); }
		public Tipo_clienteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_cliente; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RespostasParaScriptVisitor ) return ((RespostasParaScriptVisitor<? extends T>)visitor).visitTipo_cliente(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_clienteContext tipo_cliente() throws RecognitionException {
		Tipo_clienteContext _localctx = new Tipo_clienteContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_tipo_cliente);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\33R\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\7\2%\n\2"+
		"\f\2\16\2(\13\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\5\5:\n\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13"+
		"\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\2\2\21\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36\2\4\3\2\5\6\4\2\n\n\f\r\2N\2&\3\2\2\2\4)\3"+
		"\2\2\2\6,\3\2\2\2\b9\3\2\2\2\n;\3\2\2\2\f=\3\2\2\2\16?\3\2\2\2\20A\3\2"+
		"\2\2\22C\3\2\2\2\24E\3\2\2\2\26G\3\2\2\2\30I\3\2\2\2\32K\3\2\2\2\34M\3"+
		"\2\2\2\36O\3\2\2\2 !\5\4\3\2!\"\7\31\2\2\"%\3\2\2\2#%\5\4\3\2$ \3\2\2"+
		"\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'\3\3\2\2\2(&\3\2\2\2)*\5"+
		"\6\4\2*+\5\b\5\2+\5\3\2\2\2,-\7\3\2\2-\7\3\2\2\2.:\5\n\6\2/:\5\f\7\2\60"+
		":\5\16\b\2\61:\5\20\t\2\62:\5\22\n\2\63:\5\24\13\2\64:\5\26\f\2\65:\5"+
		"\30\r\2\66:\5\32\16\2\67:\5\34\17\28:\5\36\20\29.\3\2\2\29/\3\2\2\29\60"+
		"\3\2\2\29\61\3\2\2\29\62\3\2\2\29\63\3\2\2\29\64\3\2\2\29\65\3\2\2\29"+
		"\66\3\2\2\29\67\3\2\2\298\3\2\2\2:\t\3\2\2\2;<\7\7\2\2<\13\3\2\2\2=>\t"+
		"\2\2\2>\r\3\2\2\2?@\7\b\2\2@\17\3\2\2\2AB\t\3\2\2B\21\3\2\2\2CD\7\13\2"+
		"\2D\23\3\2\2\2EF\7\16\2\2F\25\3\2\2\2GH\7\17\2\2H\27\3\2\2\2IJ\7\21\2"+
		"\2J\31\3\2\2\2KL\7\4\2\2L\33\3\2\2\2MN\7\27\2\2N\35\3\2\2\2OP\7\30\2\2"+
		"P\37\3\2\2\2\5$&9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}