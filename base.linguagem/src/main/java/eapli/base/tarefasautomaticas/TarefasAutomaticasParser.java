package eapli.base.tarefasautomaticas;

// Generated from TarefasAutomaticas.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TarefasAutomaticasParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FATURA=1, CLI=2, PROD=3, EMAIL=4, INTEIRO_QUANTIDADE=5, INTEIRO=6, NUMERARIO=7, 
		PLANO_PAGAMENTO=8, MB=9, CHEQUE=10, NOME=11, TIPO_DESCONTO=12, RECORRENCIA=13, 
		PERCENTAGEM_DESCONTO=14, COUNTRY_CODE=15, TWO_DIGITS=16, BANK=17, AGENCY=18, 
		ACOUNT_NUMBER=19, VALOR_DESCONTO=20, TIPO_CLIENTE=21, NEWLINE=22, WS=23, 
		NL=24;
	public static final int
		RULE_inicio = 0, RULE_comandos = 1, RULE_email = 2, RULE_identificador = 3, 
		RULE_quantidade = 4, RULE_metodo_pagamento = 5, RULE_plano_pagamento = 6, 
		RULE_nome = 7, RULE_tipo_desconto = 8, RULE_recorrencia = 9, RULE_percentagem_desconto = 10, 
		RULE_fatura = 11, RULE_valor_desconto = 12, RULE_tipo_cliente = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"inicio", "comandos", "email", "identificador", "quantidade", "metodo_pagamento", 
			"plano_pagamento", "nome", "tipo_desconto", "recorrencia", "percentagem_desconto", 
			"fatura", "valor_desconto", "tipo_cliente"
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
			null, "FATURA", "CLI", "PROD", "EMAIL", "INTEIRO_QUANTIDADE", "INTEIRO", 
			"NUMERARIO", "PLANO_PAGAMENTO", "MB", "CHEQUE", "NOME", "TIPO_DESCONTO", 
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
	public String getGrammarFileName() { return "TarefasAutomaticas.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TarefasAutomaticasParser(TokenStream input) {
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
		public List<TerminalNode> NEWLINE() { return getTokens(TarefasAutomaticasParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(TarefasAutomaticasParser.NEWLINE, i);
		}
		public InicioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicio; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TarefasAutomaticasListener ) ((TarefasAutomaticasListener)listener).enterInicio(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TarefasAutomaticasListener ) ((TarefasAutomaticasListener)listener).exitInicio(this);
		}
	}

	public final InicioContext inicio() throws RecognitionException {
		InicioContext _localctx = new InicioContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_inicio);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FATURA) | (1L << CLI) | (1L << PROD) | (1L << EMAIL) | (1L << INTEIRO_QUANTIDADE) | (1L << NUMERARIO) | (1L << PLANO_PAGAMENTO) | (1L << MB) | (1L << CHEQUE) | (1L << NOME) | (1L << TIPO_DESCONTO) | (1L << RECORRENCIA) | (1L << PERCENTAGEM_DESCONTO) | (1L << VALOR_DESCONTO) | (1L << TIPO_CLIENTE))) != 0)) {
				{
				setState(32);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(28);
					comandos();
					setState(29);
					match(NEWLINE);
					}
					break;
				case 2:
					{
					setState(31);
					comandos();
					}
					break;
				}
				}
				setState(36);
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
		public Tipo_clienteContext tipo_cliente() {
			return getRuleContext(Tipo_clienteContext.class,0);
		}
		public ComandosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TarefasAutomaticasListener ) ((TarefasAutomaticasListener)listener).enterComandos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TarefasAutomaticasListener ) ((TarefasAutomaticasListener)listener).exitComandos(this);
		}
	}

	public final ComandosContext comandos() throws RecognitionException {
		ComandosContext _localctx = new ComandosContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_comandos);
		try {
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EMAIL:
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				email();
				}
				break;
			case CLI:
			case PROD:
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
				identificador();
				}
				break;
			case INTEIRO_QUANTIDADE:
				enterOuterAlt(_localctx, 3);
				{
				setState(39);
				quantidade();
				}
				break;
			case NUMERARIO:
			case MB:
			case CHEQUE:
				enterOuterAlt(_localctx, 4);
				{
				setState(40);
				metodo_pagamento();
				}
				break;
			case PLANO_PAGAMENTO:
				enterOuterAlt(_localctx, 5);
				{
				setState(41);
				plano_pagamento();
				}
				break;
			case NOME:
				enterOuterAlt(_localctx, 6);
				{
				setState(42);
				nome();
				}
				break;
			case TIPO_DESCONTO:
				enterOuterAlt(_localctx, 7);
				{
				setState(43);
				tipo_desconto();
				}
				break;
			case RECORRENCIA:
				enterOuterAlt(_localctx, 8);
				{
				setState(44);
				recorrencia();
				}
				break;
			case PERCENTAGEM_DESCONTO:
				enterOuterAlt(_localctx, 9);
				{
				setState(45);
				percentagem_desconto();
				}
				break;
			case FATURA:
				enterOuterAlt(_localctx, 10);
				{
				setState(46);
				fatura();
				}
				break;
			case VALOR_DESCONTO:
				enterOuterAlt(_localctx, 11);
				{
				setState(47);
				valor_desconto();
				}
				break;
			case TIPO_CLIENTE:
				enterOuterAlt(_localctx, 12);
				{
				setState(48);
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
		public TerminalNode EMAIL() { return getToken(TarefasAutomaticasParser.EMAIL, 0); }
		public EmailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_email; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TarefasAutomaticasListener ) ((TarefasAutomaticasListener)listener).enterEmail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TarefasAutomaticasListener ) ((TarefasAutomaticasListener)listener).exitEmail(this);
		}
	}

	public final EmailContext email() throws RecognitionException {
		EmailContext _localctx = new EmailContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_email);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
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
		public TerminalNode CLI() { return getToken(TarefasAutomaticasParser.CLI, 0); }
		public TerminalNode PROD() { return getToken(TarefasAutomaticasParser.PROD, 0); }
		public IdentificadorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identificador; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TarefasAutomaticasListener ) ((TarefasAutomaticasListener)listener).enterIdentificador(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TarefasAutomaticasListener ) ((TarefasAutomaticasListener)listener).exitIdentificador(this);
		}
	}

	public final IdentificadorContext identificador() throws RecognitionException {
		IdentificadorContext _localctx = new IdentificadorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_identificador);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
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
		public TerminalNode INTEIRO_QUANTIDADE() { return getToken(TarefasAutomaticasParser.INTEIRO_QUANTIDADE, 0); }
		public QuantidadeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantidade; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TarefasAutomaticasListener ) ((TarefasAutomaticasListener)listener).enterQuantidade(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TarefasAutomaticasListener ) ((TarefasAutomaticasListener)listener).exitQuantidade(this);
		}
	}

	public final QuantidadeContext quantidade() throws RecognitionException {
		QuantidadeContext _localctx = new QuantidadeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_quantidade);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
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
		public TerminalNode NUMERARIO() { return getToken(TarefasAutomaticasParser.NUMERARIO, 0); }
		public TerminalNode MB() { return getToken(TarefasAutomaticasParser.MB, 0); }
		public TerminalNode CHEQUE() { return getToken(TarefasAutomaticasParser.CHEQUE, 0); }
		public Metodo_pagamentoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metodo_pagamento; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TarefasAutomaticasListener ) ((TarefasAutomaticasListener)listener).enterMetodo_pagamento(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TarefasAutomaticasListener ) ((TarefasAutomaticasListener)listener).exitMetodo_pagamento(this);
		}
	}

	public final Metodo_pagamentoContext metodo_pagamento() throws RecognitionException {
		Metodo_pagamentoContext _localctx = new Metodo_pagamentoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_metodo_pagamento);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
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
		public TerminalNode PLANO_PAGAMENTO() { return getToken(TarefasAutomaticasParser.PLANO_PAGAMENTO, 0); }
		public Plano_pagamentoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plano_pagamento; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TarefasAutomaticasListener ) ((TarefasAutomaticasListener)listener).enterPlano_pagamento(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TarefasAutomaticasListener ) ((TarefasAutomaticasListener)listener).exitPlano_pagamento(this);
		}
	}

	public final Plano_pagamentoContext plano_pagamento() throws RecognitionException {
		Plano_pagamentoContext _localctx = new Plano_pagamentoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_plano_pagamento);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
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
		public TerminalNode NOME() { return getToken(TarefasAutomaticasParser.NOME, 0); }
		public NomeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nome; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TarefasAutomaticasListener ) ((TarefasAutomaticasListener)listener).enterNome(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TarefasAutomaticasListener ) ((TarefasAutomaticasListener)listener).exitNome(this);
		}
	}

	public final NomeContext nome() throws RecognitionException {
		NomeContext _localctx = new NomeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_nome);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
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
		public TerminalNode TIPO_DESCONTO() { return getToken(TarefasAutomaticasParser.TIPO_DESCONTO, 0); }
		public Tipo_descontoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_desconto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TarefasAutomaticasListener ) ((TarefasAutomaticasListener)listener).enterTipo_desconto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TarefasAutomaticasListener ) ((TarefasAutomaticasListener)listener).exitTipo_desconto(this);
		}
	}

	public final Tipo_descontoContext tipo_desconto() throws RecognitionException {
		Tipo_descontoContext _localctx = new Tipo_descontoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tipo_desconto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
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
		public TerminalNode RECORRENCIA() { return getToken(TarefasAutomaticasParser.RECORRENCIA, 0); }
		public RecorrenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recorrencia; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TarefasAutomaticasListener ) ((TarefasAutomaticasListener)listener).enterRecorrencia(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TarefasAutomaticasListener ) ((TarefasAutomaticasListener)listener).exitRecorrencia(this);
		}
	}

	public final RecorrenciaContext recorrencia() throws RecognitionException {
		RecorrenciaContext _localctx = new RecorrenciaContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_recorrencia);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
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
		public TerminalNode PERCENTAGEM_DESCONTO() { return getToken(TarefasAutomaticasParser.PERCENTAGEM_DESCONTO, 0); }
		public Percentagem_descontoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_percentagem_desconto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TarefasAutomaticasListener ) ((TarefasAutomaticasListener)listener).enterPercentagem_desconto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TarefasAutomaticasListener ) ((TarefasAutomaticasListener)listener).exitPercentagem_desconto(this);
		}
	}

	public final Percentagem_descontoContext percentagem_desconto() throws RecognitionException {
		Percentagem_descontoContext _localctx = new Percentagem_descontoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_percentagem_desconto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
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
		public TerminalNode FATURA() { return getToken(TarefasAutomaticasParser.FATURA, 0); }
		public FaturaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fatura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TarefasAutomaticasListener ) ((TarefasAutomaticasListener)listener).enterFatura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TarefasAutomaticasListener ) ((TarefasAutomaticasListener)listener).exitFatura(this);
		}
	}

	public final FaturaContext fatura() throws RecognitionException {
		FaturaContext _localctx = new FaturaContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_fatura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
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
		public TerminalNode VALOR_DESCONTO() { return getToken(TarefasAutomaticasParser.VALOR_DESCONTO, 0); }
		public Valor_descontoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valor_desconto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TarefasAutomaticasListener ) ((TarefasAutomaticasListener)listener).enterValor_desconto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TarefasAutomaticasListener ) ((TarefasAutomaticasListener)listener).exitValor_desconto(this);
		}
	}

	public final Valor_descontoContext valor_desconto() throws RecognitionException {
		Valor_descontoContext _localctx = new Valor_descontoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_valor_desconto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
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
		public TerminalNode TIPO_CLIENTE() { return getToken(TarefasAutomaticasParser.TIPO_CLIENTE, 0); }
		public Tipo_clienteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_cliente; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TarefasAutomaticasListener ) ((TarefasAutomaticasListener)listener).enterTipo_cliente(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TarefasAutomaticasListener ) ((TarefasAutomaticasListener)listener).exitTipo_cliente(this);
		}
	}

	public final Tipo_clienteContext tipo_cliente() throws RecognitionException {
		Tipo_clienteContext _localctx = new Tipo_clienteContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_tipo_cliente);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\32N\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\7\2#\n\2\f\2\16\2&"+
		"\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\64\n\3\3\4\3"+
		"\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3"+
		"\r\3\r\3\16\3\16\3\17\3\17\3\17\2\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\2\4\3\2\4\5\4\2\t\t\13\f\2L\2$\3\2\2\2\4\63\3\2\2\2\6\65\3\2\2\2\b"+
		"\67\3\2\2\2\n9\3\2\2\2\f;\3\2\2\2\16=\3\2\2\2\20?\3\2\2\2\22A\3\2\2\2"+
		"\24C\3\2\2\2\26E\3\2\2\2\30G\3\2\2\2\32I\3\2\2\2\34K\3\2\2\2\36\37\5\4"+
		"\3\2\37 \7\30\2\2 #\3\2\2\2!#\5\4\3\2\"\36\3\2\2\2\"!\3\2\2\2#&\3\2\2"+
		"\2$\"\3\2\2\2$%\3\2\2\2%\3\3\2\2\2&$\3\2\2\2\'\64\5\6\4\2(\64\5\b\5\2"+
		")\64\5\n\6\2*\64\5\f\7\2+\64\5\16\b\2,\64\5\20\t\2-\64\5\22\n\2.\64\5"+
		"\24\13\2/\64\5\26\f\2\60\64\5\30\r\2\61\64\5\32\16\2\62\64\5\34\17\2\63"+
		"\'\3\2\2\2\63(\3\2\2\2\63)\3\2\2\2\63*\3\2\2\2\63+\3\2\2\2\63,\3\2\2\2"+
		"\63-\3\2\2\2\63.\3\2\2\2\63/\3\2\2\2\63\60\3\2\2\2\63\61\3\2\2\2\63\62"+
		"\3\2\2\2\64\5\3\2\2\2\65\66\7\6\2\2\66\7\3\2\2\2\678\t\2\2\28\t\3\2\2"+
		"\29:\7\7\2\2:\13\3\2\2\2;<\t\3\2\2<\r\3\2\2\2=>\7\n\2\2>\17\3\2\2\2?@"+
		"\7\r\2\2@\21\3\2\2\2AB\7\16\2\2B\23\3\2\2\2CD\7\17\2\2D\25\3\2\2\2EF\7"+
		"\20\2\2F\27\3\2\2\2GH\7\3\2\2H\31\3\2\2\2IJ\7\26\2\2J\33\3\2\2\2KL\7\27"+
		"\2\2L\35\3\2\2\2\5\"$\63";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}