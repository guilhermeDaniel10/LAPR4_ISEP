package eapli.base.linguagem;

// Generated from ValidateFormulario.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ValidateFormularioParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, NEWLINE=13, INTEIRO=14, INTEIRO_NULO=15, 
		ANYCHAR=16, WS=17, NL=18;
	public static final int
		RULE_inicio = 0, RULE_expr = 1, RULE_valida = 2, RULE_tipoDado = 3, RULE_obrigatoriedade = 4, 
		RULE_posicao = 5, RULE_dependencia = 6, RULE_expressaoRegular = 7, RULE_resposta = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"inicio", "expr", "valida", "tipoDado", "obrigatoriedade", "posicao", 
			"dependencia", "expressaoRegular", "resposta"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'numerico'", "'NUMERICO'", "'texto'", "'TEXTO'", "'DATA'", "'data'", 
			"'FICHEIRO'", "'ficheiro'", "'BOOLEANO'", "'booleano'", "'NF'", "'F'", 
			null, null, "'0'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "NEWLINE", "INTEIRO", "INTEIRO_NULO", "ANYCHAR", "WS", "NL"
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
	public String getGrammarFileName() { return "ValidateFormulario.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ValidateFormularioParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class InicioContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ValidateFormularioParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ValidateFormularioParser.NEWLINE, i);
		}
		public InicioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicio; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidateFormularioVisitor ) return ((ValidateFormularioVisitor<? extends T>)visitor).visitInicio(this);
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
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INTEIRO) {
				{
				setState(22);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(18);
					expr(0);
					setState(19);
					match(NEWLINE);
					}
					break;
				case 2:
					{
					setState(21);
					expr(0);
					}
					break;
				}
				}
				setState(26);
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

	public static class ExprContext extends ParserRuleContext {
		public ValidaContext valida() {
			return getRuleContext(ValidaContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(ValidateFormularioParser.NEWLINE, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidateFormularioVisitor ) return ((ValidateFormularioVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(28);
			valida();
			}
			_ctx.stop = _input.LT(-1);
			setState(36);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(30);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(31);
					valida();
					setState(32);
					match(NEWLINE);
					}
					} 
				}
				setState(38);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ValidaContext extends ParserRuleContext {
		public PosicaoContext posicao() {
			return getRuleContext(PosicaoContext.class,0);
		}
		public TipoDadoContext tipoDado() {
			return getRuleContext(TipoDadoContext.class,0);
		}
		public ObrigatoriedadeContext obrigatoriedade() {
			return getRuleContext(ObrigatoriedadeContext.class,0);
		}
		public DependenciaContext dependencia() {
			return getRuleContext(DependenciaContext.class,0);
		}
		public ExpressaoRegularContext expressaoRegular() {
			return getRuleContext(ExpressaoRegularContext.class,0);
		}
		public RespostaContext resposta() {
			return getRuleContext(RespostaContext.class,0);
		}
		public ValidaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valida; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidateFormularioVisitor ) return ((ValidateFormularioVisitor<? extends T>)visitor).visitValida(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValidaContext valida() throws RecognitionException {
		ValidaContext _localctx = new ValidaContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_valida);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			posicao();
			setState(40);
			tipoDado();
			setState(41);
			obrigatoriedade();
			setState(42);
			dependencia();
			setState(43);
			expressaoRegular();
			setState(44);
			resposta();
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

	public static class TipoDadoContext extends ParserRuleContext {
		public TipoDadoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipoDado; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidateFormularioVisitor ) return ((ValidateFormularioVisitor<? extends T>)visitor).visitTipoDado(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoDadoContext tipoDado() throws RecognitionException {
		TipoDadoContext _localctx = new TipoDadoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipoDado);
		int _la;
		try {
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				_la = _input.LA(1);
				if ( !(_la==T__0 || _la==T__1) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case T__2:
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				_la = _input.LA(1);
				if ( !(_la==T__2 || _la==T__3) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case T__4:
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				_la = _input.LA(1);
				if ( !(_la==T__4 || _la==T__5) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case T__6:
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(49);
				_la = _input.LA(1);
				if ( !(_la==T__6 || _la==T__7) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case T__8:
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(50);
				_la = _input.LA(1);
				if ( !(_la==T__8 || _la==T__9) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
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

	public static class ObrigatoriedadeContext extends ParserRuleContext {
		public ObrigatoriedadeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_obrigatoriedade; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidateFormularioVisitor ) return ((ValidateFormularioVisitor<? extends T>)visitor).visitObrigatoriedade(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObrigatoriedadeContext obrigatoriedade() throws RecognitionException {
		ObrigatoriedadeContext _localctx = new ObrigatoriedadeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_obrigatoriedade);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_la = _input.LA(1);
			if ( !(_la==T__10 || _la==T__11) ) {
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

	public static class PosicaoContext extends ParserRuleContext {
		public TerminalNode INTEIRO() { return getToken(ValidateFormularioParser.INTEIRO, 0); }
		public PosicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_posicao; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidateFormularioVisitor ) return ((ValidateFormularioVisitor<? extends T>)visitor).visitPosicao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PosicaoContext posicao() throws RecognitionException {
		PosicaoContext _localctx = new PosicaoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_posicao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(INTEIRO);
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

	public static class DependenciaContext extends ParserRuleContext {
		public TerminalNode INTEIRO_NULO() { return getToken(ValidateFormularioParser.INTEIRO_NULO, 0); }
		public TerminalNode INTEIRO() { return getToken(ValidateFormularioParser.INTEIRO, 0); }
		public DependenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dependencia; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidateFormularioVisitor ) return ((ValidateFormularioVisitor<? extends T>)visitor).visitDependencia(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DependenciaContext dependencia() throws RecognitionException {
		DependenciaContext _localctx = new DependenciaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_dependencia);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_la = _input.LA(1);
			if ( !(_la==INTEIRO || _la==INTEIRO_NULO) ) {
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

	public static class ExpressaoRegularContext extends ParserRuleContext {
		public TerminalNode ANYCHAR() { return getToken(ValidateFormularioParser.ANYCHAR, 0); }
		public ExpressaoRegularContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoRegular; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidateFormularioVisitor ) return ((ValidateFormularioVisitor<? extends T>)visitor).visitExpressaoRegular(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressaoRegularContext expressaoRegular() throws RecognitionException {
		ExpressaoRegularContext _localctx = new ExpressaoRegularContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expressaoRegular);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(ANYCHAR);
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

	public static class RespostaContext extends ParserRuleContext {
		public TerminalNode INTEIRO_NULO() { return getToken(ValidateFormularioParser.INTEIRO_NULO, 0); }
		public TerminalNode INTEIRO() { return getToken(ValidateFormularioParser.INTEIRO, 0); }
		public TerminalNode ANYCHAR() { return getToken(ValidateFormularioParser.ANYCHAR, 0); }
		public RespostaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resposta; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidateFormularioVisitor ) return ((ValidateFormularioVisitor<? extends T>)visitor).visitResposta(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RespostaContext resposta() throws RecognitionException {
		RespostaContext _localctx = new RespostaContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_resposta);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEIRO) | (1L << INTEIRO_NULO) | (1L << ANYCHAR))) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24B\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\2"+
		"\3\2\7\2\31\n\2\f\2\16\2\34\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3%\n\3"+
		"\f\3\16\3(\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\5\5\66"+
		"\n\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\2\3\4\13\2\4\6\b\n\f"+
		"\16\20\22\2\n\3\2\3\4\3\2\5\6\3\2\7\b\3\2\t\n\3\2\13\f\3\2\r\16\3\2\20"+
		"\21\3\2\20\22\2?\2\32\3\2\2\2\4\35\3\2\2\2\6)\3\2\2\2\b\65\3\2\2\2\n\67"+
		"\3\2\2\2\f9\3\2\2\2\16;\3\2\2\2\20=\3\2\2\2\22?\3\2\2\2\24\25\5\4\3\2"+
		"\25\26\7\17\2\2\26\31\3\2\2\2\27\31\5\4\3\2\30\24\3\2\2\2\30\27\3\2\2"+
		"\2\31\34\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\3\3\2\2\2\34\32\3\2\2"+
		"\2\35\36\b\3\1\2\36\37\5\6\4\2\37&\3\2\2\2 !\f\4\2\2!\"\5\6\4\2\"#\7\17"+
		"\2\2#%\3\2\2\2$ \3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'\5\3\2\2\2(&"+
		"\3\2\2\2)*\5\f\7\2*+\5\b\5\2+,\5\n\6\2,-\5\16\b\2-.\5\20\t\2./\5\22\n"+
		"\2/\7\3\2\2\2\60\66\t\2\2\2\61\66\t\3\2\2\62\66\t\4\2\2\63\66\t\5\2\2"+
		"\64\66\t\6\2\2\65\60\3\2\2\2\65\61\3\2\2\2\65\62\3\2\2\2\65\63\3\2\2\2"+
		"\65\64\3\2\2\2\66\t\3\2\2\2\678\t\7\2\28\13\3\2\2\29:\7\20\2\2:\r\3\2"+
		"\2\2;<\t\b\2\2<\17\3\2\2\2=>\7\22\2\2>\21\3\2\2\2?@\t\t\2\2@\23\3\2\2"+
		"\2\6\30\32&\65";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}