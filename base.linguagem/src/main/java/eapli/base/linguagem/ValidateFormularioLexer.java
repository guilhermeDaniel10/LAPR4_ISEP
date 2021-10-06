package eapli.base.linguagem;

// Generated from ValidateFormulario.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ValidateFormularioLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, NEWLINE=13, INTEIRO=14, INTEIRO_NULO=15, 
		ANYCHAR=16, WS=17, NL=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "NEWLINE", "INTEIRO", "INTEIRO_NULO", "ANYCHAR", 
			"WS", "NL"
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


	public ValidateFormularioLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ValidateFormulario.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24\u00aa\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r"+
		"\3\16\6\16z\n\16\r\16\16\16{\3\17\6\17\177\n\17\r\17\16\17\u0080\3\17"+
		"\7\17\u0084\n\17\f\17\16\17\u0087\13\17\3\20\3\20\3\21\3\21\6\21\u008d"+
		"\n\21\r\21\16\21\u008e\3\21\6\21\u0092\n\21\r\21\16\21\u0093\3\21\6\21"+
		"\u0097\n\21\r\21\16\21\u0098\3\21\3\21\3\22\6\22\u009e\n\22\r\22\16\22"+
		"\u009f\3\22\3\22\3\23\5\23\u00a5\n\23\3\23\3\23\3\23\3\23\2\2\24\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\3\2\b\4\2\f\f\17\17\3\2\63;\3\2\62;\4\2C\\c|\t\2\"\"\'\'"+
		")-/\61]_aa~~\4\2\13\13\"\"\2\u00b3\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5\60\3\2"+
		"\2\2\79\3\2\2\2\t?\3\2\2\2\13E\3\2\2\2\rJ\3\2\2\2\17O\3\2\2\2\21X\3\2"+
		"\2\2\23a\3\2\2\2\25j\3\2\2\2\27s\3\2\2\2\31v\3\2\2\2\33y\3\2\2\2\35~\3"+
		"\2\2\2\37\u0088\3\2\2\2!\u008a\3\2\2\2#\u009d\3\2\2\2%\u00a4\3\2\2\2\'"+
		"(\7p\2\2()\7w\2\2)*\7o\2\2*+\7g\2\2+,\7t\2\2,-\7k\2\2-.\7e\2\2./\7q\2"+
		"\2/\4\3\2\2\2\60\61\7P\2\2\61\62\7W\2\2\62\63\7O\2\2\63\64\7G\2\2\64\65"+
		"\7T\2\2\65\66\7K\2\2\66\67\7E\2\2\678\7Q\2\28\6\3\2\2\29:\7v\2\2:;\7g"+
		"\2\2;<\7z\2\2<=\7v\2\2=>\7q\2\2>\b\3\2\2\2?@\7V\2\2@A\7G\2\2AB\7Z\2\2"+
		"BC\7V\2\2CD\7Q\2\2D\n\3\2\2\2EF\7F\2\2FG\7C\2\2GH\7V\2\2HI\7C\2\2I\f\3"+
		"\2\2\2JK\7f\2\2KL\7c\2\2LM\7v\2\2MN\7c\2\2N\16\3\2\2\2OP\7H\2\2PQ\7K\2"+
		"\2QR\7E\2\2RS\7J\2\2ST\7G\2\2TU\7K\2\2UV\7T\2\2VW\7Q\2\2W\20\3\2\2\2X"+
		"Y\7h\2\2YZ\7k\2\2Z[\7e\2\2[\\\7j\2\2\\]\7g\2\2]^\7k\2\2^_\7t\2\2_`\7q"+
		"\2\2`\22\3\2\2\2ab\7D\2\2bc\7Q\2\2cd\7Q\2\2de\7N\2\2ef\7G\2\2fg\7C\2\2"+
		"gh\7P\2\2hi\7Q\2\2i\24\3\2\2\2jk\7d\2\2kl\7q\2\2lm\7q\2\2mn\7n\2\2no\7"+
		"g\2\2op\7c\2\2pq\7p\2\2qr\7q\2\2r\26\3\2\2\2st\7P\2\2tu\7H\2\2u\30\3\2"+
		"\2\2vw\7H\2\2w\32\3\2\2\2xz\t\2\2\2yx\3\2\2\2z{\3\2\2\2{y\3\2\2\2{|\3"+
		"\2\2\2|\34\3\2\2\2}\177\t\3\2\2~}\3\2\2\2\177\u0080\3\2\2\2\u0080~\3\2"+
		"\2\2\u0080\u0081\3\2\2\2\u0081\u0085\3\2\2\2\u0082\u0084\t\4\2\2\u0083"+
		"\u0082\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2"+
		"\2\2\u0086\36\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u0089\7\62\2\2\u0089 "+
		"\3\2\2\2\u008a\u0096\7$\2\2\u008b\u008d\t\4\2\2\u008c\u008b\3\2\2\2\u008d"+
		"\u008e\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0097\3\2"+
		"\2\2\u0090\u0092\t\5\2\2\u0091\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0097\t\6"+
		"\2\2\u0096\u008c\3\2\2\2\u0096\u0091\3\2\2\2\u0096\u0095\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\3\2"+
		"\2\2\u009a\u009b\7$\2\2\u009b\"\3\2\2\2\u009c\u009e\t\7\2\2\u009d\u009c"+
		"\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u00a2\b\22\2\2\u00a2$\3\2\2\2\u00a3\u00a5\7\17\2"+
		"\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7"+
		"\7\f\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\b\23\2\2\u00a9&\3\2\2\2\f\2{"+
		"\u0080\u0085\u008e\u0093\u0096\u0098\u009f\u00a4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}