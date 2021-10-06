package eapli.base.tarefasautomaticas;

// Generated from TarefasAutomaticas.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TarefasAutomaticasLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"FATURA", "CLI", "PROD", "EMAIL", "INTEIRO_QUANTIDADE", "INTEIRO", "NUMERARIO", 
			"PLANO_PAGAMENTO", "MB", "CHEQUE", "NOME", "TIPO_DESCONTO", "RECORRENCIA", 
			"PERCENTAGEM_DESCONTO", "COUNTRY_CODE", "TWO_DIGITS", "BANK", "AGENCY", 
			"ACOUNT_NUMBER", "VALOR_DESCONTO", "TIPO_CLIENTE", "NEWLINE", "WS", "NL"
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


	public TarefasAutomaticasLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TarefasAutomaticas.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\32\u01f5\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\5\6\5H\n\5\r\5\16\5I\3\5\7\5M\n\5\f\5\16\5P\13\5\6\5R\n"+
		"\5\r\5\16\5S\3\5\3\5\6\5X\n\5\r\5\16\5Y\3\5\6\5]\n\5\r\5\16\5^\3\5\3\5"+
		"\3\5\3\5\3\5\5\5f\n\5\3\6\3\6\7\6j\n\6\f\6\16\6m\13\6\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0083"+
		"\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00e9\n\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0103\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\5\13\u0111\n\13\3\f\3\f\6\f\u0115\n\f\r\f"+
		"\16\f\u0116\3\f\3\f\3\f\6\f\u011c\n\f\r\f\16\f\u011d\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0154\n\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u017a\n\16\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\25\7\25\u019e\n\25\f\25\16\25\u01a1\13\25\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\5\26\u01e1\n\26\3\27\6\27\u01e4\n\27\r\27\16\27\u01e5\3\30"+
		"\6\30\u01e9\n\30\r\30\16\30\u01ea\3\30\3\30\3\31\5\31\u01f0\n\31\3\31"+
		"\3\31\3\31\3\31\2\2\32\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\3\2"+
		"\n\5\2\62;C\\c|\4\2C\\c|\3\2\63;\3\2\62;\3\2C\\\3\2c|\4\2\f\f\17\17\4"+
		"\2\13\13\"\"\2\u021a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\3\63\3\2\2\2\59\3\2\2\2\7?\3\2\2\2"+
		"\tQ\3\2\2\2\13g\3\2\2\2\rn\3\2\2\2\17\u0082\3\2\2\2\21\u00e8\3\2\2\2\23"+
		"\u0102\3\2\2\2\25\u0110\3\2\2\2\27\u0112\3\2\2\2\31\u0153\3\2\2\2\33\u0179"+
		"\3\2\2\2\35\u017b\3\2\2\2\37\u017e\3\2\2\2!\u0183\3\2\2\2#\u0186\3\2\2"+
		"\2%\u018b\3\2\2\2\'\u0190\3\2\2\2)\u019f\3\2\2\2+\u01e0\3\2\2\2-\u01e3"+
		"\3\2\2\2/\u01e8\3\2\2\2\61\u01ef\3\2\2\2\63\64\5\37\20\2\64\65\5#\22\2"+
		"\65\66\5%\23\2\66\67\5\'\24\2\678\5!\21\28\4\3\2\2\29:\7E\2\2:;\7n\2\2"+
		";<\7k\2\2<=\3\2\2\2=>\5\13\6\2>\6\3\2\2\2?@\7R\2\2@A\7t\2\2AB\7q\2\2B"+
		"C\7f\2\2CD\3\2\2\2DE\5\13\6\2E\b\3\2\2\2FH\t\2\2\2GF\3\2\2\2HI\3\2\2\2"+
		"IG\3\2\2\2IJ\3\2\2\2JN\3\2\2\2KM\7a\2\2LK\3\2\2\2MP\3\2\2\2NL\3\2\2\2"+
		"NO\3\2\2\2OR\3\2\2\2PN\3\2\2\2QG\3\2\2\2RS\3\2\2\2SQ\3\2\2\2ST\3\2\2\2"+
		"TU\3\2\2\2U\\\7B\2\2VX\t\3\2\2WV\3\2\2\2XY\3\2\2\2YW\3\2\2\2YZ\3\2\2\2"+
		"Z[\3\2\2\2[]\7\60\2\2\\W\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_e\3\2"+
		"\2\2`a\7e\2\2ab\7q\2\2bf\7o\2\2cd\7r\2\2df\7v\2\2e`\3\2\2\2ec\3\2\2\2"+
		"f\n\3\2\2\2gk\t\4\2\2hj\t\5\2\2ih\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2"+
		"\2l\f\3\2\2\2mk\3\2\2\2no\t\5\2\2o\16\3\2\2\2pq\7P\2\2qr\7W\2\2rs\7O\2"+
		"\2st\7G\2\2tu\7T\2\2uv\7C\2\2vw\7T\2\2wx\7K\2\2x\u0083\7Q\2\2yz\7p\2\2"+
		"z{\7w\2\2{|\7o\2\2|}\7g\2\2}~\7t\2\2~\177\7c\2\2\177\u0080\7t\2\2\u0080"+
		"\u0081\7k\2\2\u0081\u0083\7q\2\2\u0082p\3\2\2\2\u0082y\3\2\2\2\u0083\20"+
		"\3\2\2\2\u0084\u0085\7R\2\2\u0085\u0086\7T\2\2\u0086\u0087\7Q\2\2\u0087"+
		"\u0088\7P\2\2\u0088\u0089\7V\2\2\u0089\u008a\7Q\2\2\u008a\u008b\7\"\2"+
		"\2\u008b\u008c\7R\2\2\u008c\u008d\7C\2\2\u008d\u008e\7I\2\2\u008e\u008f"+
		"\7C\2\2\u008f\u0090\7O\2\2\u0090\u0091\7G\2\2\u0091\u0092\7P\2\2\u0092"+
		"\u0093\7V\2\2\u0093\u00e9\7Q\2\2\u0094\u0095\7r\2\2\u0095\u0096\7t\2\2"+
		"\u0096\u0097\7q\2\2\u0097\u0098\7p\2\2\u0098\u0099\7v\2\2\u0099\u009a"+
		"\7q\2\2\u009a\u009b\7\"\2\2\u009b\u009c\7r\2\2\u009c\u009d\7c\2\2\u009d"+
		"\u009e\7i\2\2\u009e\u009f\7c\2\2\u009f\u00a0\7o\2\2\u00a0\u00a1\7g\2\2"+
		"\u00a1\u00a2\7p\2\2\u00a2\u00a3\7v\2\2\u00a3\u00e9\7q\2\2\u00a4\u00a5"+
		"\7R\2\2\u00a5\u00a6\7C\2\2\u00a6\u00a7\7I\2\2\u00a7\u00a8\7C\2\2\u00a8"+
		"\u00a9\7O\2\2\u00a9\u00aa\7G\2\2\u00aa\u00ab\7P\2\2\u00ab\u00ac\7V\2\2"+
		"\u00ac\u00ad\7Q\2\2\u00ad\u00ae\7\"\2\2\u00ae\u00af\7C\2\2\u00af\u00b0"+
		"\7\"\2\2\u00b0\u00b1\7\65\2\2\u00b1\u00b2\7\62\2\2\u00b2\u00b3\7\"\2\2"+
		"\u00b3\u00b4\7F\2\2\u00b4\u00b5\7K\2\2\u00b5\u00b6\7C\2\2\u00b6\u00e9"+
		"\7U\2\2\u00b7\u00b8\7r\2\2\u00b8\u00b9\7c\2\2\u00b9\u00ba\7i\2\2\u00ba"+
		"\u00bb\7c\2\2\u00bb\u00bc\7o\2\2\u00bc\u00bd\7g\2\2\u00bd\u00be\7p\2\2"+
		"\u00be\u00bf\7v\2\2\u00bf\u00c0\7q\2\2\u00c0\u00c1\7\"\2\2\u00c1\u00c2"+
		"\7c\2\2\u00c2\u00c3\7\"\2\2\u00c3\u00c4\7\65\2\2\u00c4\u00c5\7\62\2\2"+
		"\u00c5\u00c6\7\"\2\2\u00c6\u00c7\7f\2\2\u00c7\u00c8\7k\2\2\u00c8\u00c9"+
		"\7c\2\2\u00c9\u00e9\7u\2\2\u00ca\u00cb\7R\2\2\u00cb\u00cc\7C\2\2\u00cc"+
		"\u00cd\7I\2\2\u00cd\u00ce\7C\2\2\u00ce\u00cf\7O\2\2\u00cf\u00d0\7G\2\2"+
		"\u00d0\u00d1\7P\2\2\u00d1\u00d2\7V\2\2\u00d2\u00d3\7Q\2\2\u00d3\u00d4"+
		"\7\"\2\2\u00d4\u00d5\7C\2\2\u00d5\u00d6\7P\2\2\u00d6\u00d7\7W\2\2\u00d7"+
		"\u00d8\7C\2\2\u00d8\u00e9\7N\2\2\u00d9\u00da\7r\2\2\u00da\u00db\7c\2\2"+
		"\u00db\u00dc\7i\2\2\u00dc\u00dd\7c\2\2\u00dd\u00de\7o\2\2\u00de\u00df"+
		"\7g\2\2\u00df\u00e0\7p\2\2\u00e0\u00e1\7v\2\2\u00e1\u00e2\7q\2\2\u00e2"+
		"\u00e3\7\"\2\2\u00e3\u00e4\7c\2\2\u00e4\u00e5\7p\2\2\u00e5\u00e6\7w\2"+
		"\2\u00e6\u00e7\7c\2\2\u00e7\u00e9\7n\2\2\u00e8\u0084\3\2\2\2\u00e8\u0094"+
		"\3\2\2\2\u00e8\u00a4\3\2\2\2\u00e8\u00b7\3\2\2\2\u00e8\u00ca\3\2\2\2\u00e8"+
		"\u00d9\3\2\2\2\u00e9\22\3\2\2\2\u00ea\u00eb\7O\2\2\u00eb\u00ec\7W\2\2"+
		"\u00ec\u00ed\7N\2\2\u00ed\u00ee\7V\2\2\u00ee\u00ef\7K\2\2\u00ef\u00f0"+
		"\7D\2\2\u00f0\u00f1\7C\2\2\u00f1\u00f2\7P\2\2\u00f2\u00f3\7E\2\2\u00f3"+
		"\u0103\7Q\2\2\u00f4\u00f5\7o\2\2\u00f5\u00f6\7w\2\2\u00f6\u00f7\7n\2\2"+
		"\u00f7\u00f8\7v\2\2\u00f8\u00f9\7k\2\2\u00f9\u00fa\7d\2\2\u00fa\u00fb"+
		"\7c\2\2\u00fb\u00fc\7p\2\2\u00fc\u00fd\7e\2\2\u00fd\u0103\7q\2\2\u00fe"+
		"\u00ff\7O\2\2\u00ff\u0103\7D\2\2\u0100\u0101\7o\2\2\u0101\u0103\7d\2\2"+
		"\u0102\u00ea\3\2\2\2\u0102\u00f4\3\2\2\2\u0102\u00fe\3\2\2\2\u0102\u0100"+
		"\3\2\2\2\u0103\24\3\2\2\2\u0104\u0105\7E\2\2\u0105\u0106\7J\2\2\u0106"+
		"\u0107\7G\2\2\u0107\u0108\7S\2\2\u0108\u0109\7W\2\2\u0109\u0111\7G\2\2"+
		"\u010a\u010b\7e\2\2\u010b\u010c\7j\2\2\u010c\u010d\7g\2\2\u010d\u010e"+
		"\7s\2\2\u010e\u010f\7w\2\2\u010f\u0111\7g\2\2\u0110\u0104\3\2\2\2\u0110"+
		"\u010a\3\2\2\2\u0111\26\3\2\2\2\u0112\u0114\t\6\2\2\u0113\u0115\t\7\2"+
		"\2\u0114\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0117"+
		"\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0119\7\"\2\2\u0119\u011b\t\6\2\2\u011a"+
		"\u011c\t\7\2\2\u011b\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011b\3\2"+
		"\2\2\u011d\u011e\3\2\2\2\u011e\30\3\2\2\2\u011f\u0120\7U\2\2\u0120\u0121"+
		"\7C\2\2\u0121\u0122\7\\\2\2\u0122\u0123\7Q\2\2\u0123\u0124\7P\2\2\u0124"+
		"\u0125\7C\2\2\u0125\u0154\7N\2\2\u0126\u0127\7u\2\2\u0127\u0128\7c\2\2"+
		"\u0128\u0129\7|\2\2\u0129\u012a\7q\2\2\u012a\u012b\7p\2\2\u012b\u012c"+
		"\7c\2\2\u012c\u0154\7n\2\2\u012d\u012e\7t\2\2\u012e\u012f\7g\2\2\u012f"+
		"\u0130\7n\2\2\u0130\u0131\7c\2\2\u0131\u0132\7o\2\2\u0132\u0133\7r\2\2"+
		"\u0133\u0134\7c\2\2\u0134\u0135\7i\2\2\u0135\u0154\7q\2\2\u0136\u0137"+
		"\7T\2\2\u0137\u0138\7G\2\2\u0138\u0139\7N\2\2\u0139\u013a\7C\2\2\u013a"+
		"\u013b\7O\2\2\u013b\u013c\7R\2\2\u013c\u013d\7C\2\2\u013d\u013e\7I\2\2"+
		"\u013e\u0154\7Q\2\2\u013f\u0140\7S\2\2\u0140\u0141\7W\2\2\u0141\u0142"+
		"\7C\2\2\u0142\u0143\7P\2\2\u0143\u0144\7V\2\2\u0144\u0145\7K\2\2\u0145"+
		"\u0146\7F\2\2\u0146\u0147\7C\2\2\u0147\u0148\7F\2\2\u0148\u0154\7G\2\2"+
		"\u0149\u014a\7s\2\2\u014a\u014b\7w\2\2\u014b\u014c\7c\2\2\u014c\u014d"+
		"\7p\2\2\u014d\u014e\7v\2\2\u014e\u014f\7k\2\2\u014f\u0150\7f\2\2\u0150"+
		"\u0151\7c\2\2\u0151\u0152\7f\2\2\u0152\u0154\7g\2\2\u0153\u011f\3\2\2"+
		"\2\u0153\u0126\3\2\2\2\u0153\u012d\3\2\2\2\u0153\u0136\3\2\2\2\u0153\u013f"+
		"\3\2\2\2\u0153\u0149\3\2\2\2\u0154\32\3\2\2\2\u0155\u0156\7U\2\2\u0156"+
		"\u0157\7G\2\2\u0157\u0158\7O\2\2\u0158\u0159\7C\2\2\u0159\u015a\7P\2\2"+
		"\u015a\u015b\7C\2\2\u015b\u017a\7N\2\2\u015c\u015d\7u\2\2\u015d\u015e"+
		"\7g\2\2\u015e\u015f\7o\2\2\u015f\u0160\7c\2\2\u0160\u0161\7p\2\2\u0161"+
		"\u0162\7c\2\2\u0162\u017a\7n\2\2\u0163\u0164\7C\2\2\u0164\u0165\7P\2\2"+
		"\u0165\u0166\7W\2\2\u0166\u0167\7C\2\2\u0167\u017a\7N\2\2\u0168\u0169"+
		"\7c\2\2\u0169\u016a\7p\2\2\u016a\u016b\7w\2\2\u016b\u016c\7c\2\2\u016c"+
		"\u017a\7n\2\2\u016d\u016e\7O\2\2\u016e\u016f\7G\2\2\u016f\u0170\7P\2\2"+
		"\u0170\u0171\7U\2\2\u0171\u0172\7C\2\2\u0172\u017a\7N\2\2\u0173\u0174"+
		"\7o\2\2\u0174\u0175\7g\2\2\u0175\u0176\7p\2\2\u0176\u0177\7u\2\2\u0177"+
		"\u0178\7c\2\2\u0178\u017a\7n\2\2\u0179\u0155\3\2\2\2\u0179\u015c\3\2\2"+
		"\2\u0179\u0163\3\2\2\2\u0179\u0168\3\2\2\2\u0179\u016d\3\2\2\2\u0179\u0173"+
		"\3\2\2\2\u017a\34\3\2\2\2\u017b\u017c\t\5\2\2\u017c\u017d\7\'\2\2\u017d"+
		"\36\3\2\2\2\u017e\u017f\t\6\2\2\u017f\u0180\t\6\2\2\u0180\u0181\t\5\2"+
		"\2\u0181\u0182\t\5\2\2\u0182 \3\2\2\2\u0183\u0184\t\5\2\2\u0184\u0185"+
		"\t\5\2\2\u0185\"\3\2\2\2\u0186\u0187\t\5\2\2\u0187\u0188\t\5\2\2\u0188"+
		"\u0189\t\5\2\2\u0189\u018a\t\5\2\2\u018a$\3\2\2\2\u018b\u018c\t\5\2\2"+
		"\u018c\u018d\t\5\2\2\u018d\u018e\t\5\2\2\u018e\u018f\t\5\2\2\u018f&\3"+
		"\2\2\2\u0190\u0191\t\5\2\2\u0191\u0192\t\5\2\2\u0192\u0193\t\5\2\2\u0193"+
		"\u0194\t\5\2\2\u0194\u0195\t\5\2\2\u0195\u0196\t\5\2\2\u0196\u0197\t\5"+
		"\2\2\u0197\u0198\t\5\2\2\u0198\u0199\t\5\2\2\u0199\u019a\t\5\2\2\u019a"+
		"\u019b\t\5\2\2\u019b(\3\2\2\2\u019c\u019e\t\5\2\2\u019d\u019c\3\2\2\2"+
		"\u019e\u01a1\3\2\2\2\u019f\u019d\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u01a2"+
		"\3\2\2\2\u01a1\u019f\3\2\2\2\u01a2\u01a3\7\60\2\2\u01a3\u01a4\t\5\2\2"+
		"\u01a4\u01a5\t\5\2\2\u01a5*\3\2\2\2\u01a6\u01a7\7p\2\2\u01a7\u01a8\7c"+
		"\2\2\u01a8\u01a9\7e\2\2\u01a9\u01aa\7k\2\2\u01aa\u01ab\7q\2\2\u01ab\u01ac"+
		"\7p\2\2\u01ac\u01ad\7c\2\2\u01ad\u01e1\7n\2\2\u01ae\u01af\7g\2\2\u01af"+
		"\u01b0\7w\2\2\u01b0\u01b1\7t\2\2\u01b1\u01b2\7q\2\2\u01b2\u01b3\7r\2\2"+
		"\u01b3\u01b4\7g\2\2\u01b4\u01e1\7w\2\2\u01b5\u01b6\7t\2\2\u01b6\u01b7"+
		"\7g\2\2\u01b7\u01b8\7u\2\2\u01b8\u01b9\7v\2\2\u01b9\u01ba\7q\2\2\u01ba"+
		"\u01bb\7\"\2\2\u01bb\u01bc\7f\2\2\u01bc\u01bd\7q\2\2\u01bd\u01be\7\"\2"+
		"\2\u01be\u01bf\7o\2\2\u01bf\u01c0\7w\2\2\u01c0\u01c1\7p\2\2\u01c1\u01c2"+
		"\7f\2\2\u01c2\u01e1\7q\2\2\u01c3\u01c4\7P\2\2\u01c4\u01c5\7C\2\2\u01c5"+
		"\u01c6\7E\2\2\u01c6\u01c7\7K\2\2\u01c7\u01c8\7Q\2\2\u01c8\u01c9\7P\2\2"+
		"\u01c9\u01ca\7C\2\2\u01ca\u01e1\7N\2\2\u01cb\u01cc\7G\2\2\u01cc\u01cd"+
		"\7W\2\2\u01cd\u01ce\7T\2\2\u01ce\u01cf\7Q\2\2\u01cf\u01d0\7R\2\2\u01d0"+
		"\u01d1\7G\2\2\u01d1\u01e1\7W\2\2\u01d2\u01d3\7T\2\2\u01d3\u01d4\7G\2\2"+
		"\u01d4\u01d5\7U\2\2\u01d5\u01d6\7V\2\2\u01d6\u01d7\7Q\2\2\u01d7\u01d8"+
		"\7\"\2\2\u01d8\u01d9\7F\2\2\u01d9\u01da\7Q\2\2\u01da\u01db\7\"\2\2\u01db"+
		"\u01dc\7O\2\2\u01dc\u01dd\7W\2\2\u01dd\u01de\7P\2\2\u01de\u01df\7F\2\2"+
		"\u01df\u01e1\7Q\2\2\u01e0\u01a6\3\2\2\2\u01e0\u01ae\3\2\2\2\u01e0\u01b5"+
		"\3\2\2\2\u01e0\u01c3\3\2\2\2\u01e0\u01cb\3\2\2\2\u01e0\u01d2\3\2\2\2\u01e1"+
		",\3\2\2\2\u01e2\u01e4\t\b\2\2\u01e3\u01e2\3\2\2\2\u01e4\u01e5\3\2\2\2"+
		"\u01e5\u01e3\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6.\3\2\2\2\u01e7\u01e9\t"+
		"\t\2\2\u01e8\u01e7\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01e8\3\2\2\2\u01ea"+
		"\u01eb\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01ed\b\30\2\2\u01ed\60\3\2\2"+
		"\2\u01ee\u01f0\7\17\2\2\u01ef\u01ee\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0"+
		"\u01f1\3\2\2\2\u01f1\u01f2\7\f\2\2\u01f2\u01f3\3\2\2\2\u01f3\u01f4\b\31"+
		"\2\2\u01f4\62\3\2\2\2\27\2INSY^ek\u0082\u00e8\u0102\u0110\u0116\u011d"+
		"\u0153\u0179\u019f\u01e0\u01e5\u01ea\u01ef\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}