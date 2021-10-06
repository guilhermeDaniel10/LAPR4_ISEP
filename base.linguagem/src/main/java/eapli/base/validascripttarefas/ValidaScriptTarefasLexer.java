package eapli.base.validascripttarefas;

// Generated from ValidaScriptTarefas.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ValidaScriptTarefasLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TIPO_CLIENTE=1, DATA_LIMITE=2, VALOR_DESCONTO=3, FATURA=4, PERCENTAGEM_DESCONTO=5, 
		RECORRENCIA=6, TIPO_DESCONTO=7, NOME=8, IDENTIFICADOR=9, EMAIL=10, QUANTIDADE=11, 
		PLANO_PAGAMENTO=12, METODO_PAGAMENTO=13, NEWLINE=14, WS=15, NL=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"TIPO_CLIENTE", "DATA_LIMITE", "VALOR_DESCONTO", "FATURA", "PERCENTAGEM_DESCONTO", 
			"RECORRENCIA", "TIPO_DESCONTO", "NOME", "IDENTIFICADOR", "EMAIL", "QUANTIDADE", 
			"PLANO_PAGAMENTO", "METODO_PAGAMENTO", "NEWLINE", "WS", "NL"
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


	public ValidaScriptTarefasLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ValidaScriptTarefas.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\22\u017c\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\5\2<\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3T\n\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4r\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\5\5\u0080\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00aa\n\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\5\7\u00c2\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00de"+
		"\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00e8\n\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\5\n\u0104\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\5\13\u0110\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0126\n\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0146\n\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0168"+
		"\n\16\3\17\6\17\u016b\n\17\r\17\16\17\u016c\3\20\6\20\u0170\n\20\r\20"+
		"\16\20\u0171\3\20\3\20\3\21\5\21\u0177\n\21\3\21\3\21\3\21\3\21\2\2\22"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22\3\2\4\4\2\f\f\17\17\4\2\13\13\"\"\2\u018b\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3;\3\2\2\2\5S\3\2\2\2\7q\3"+
		"\2\2\2\t\177\3\2\2\2\13\u00a9\3\2\2\2\r\u00c1\3\2\2\2\17\u00dd\3\2\2\2"+
		"\21\u00e7\3\2\2\2\23\u0103\3\2\2\2\25\u010f\3\2\2\2\27\u0125\3\2\2\2\31"+
		"\u0145\3\2\2\2\33\u0167\3\2\2\2\35\u016a\3\2\2\2\37\u016f\3\2\2\2!\u0176"+
		"\3\2\2\2#$\7V\2\2$%\7K\2\2%&\7R\2\2&\'\7Q\2\2\'(\7\"\2\2()\7E\2\2)*\7"+
		"N\2\2*+\7K\2\2+,\7G\2\2,-\7P\2\2-.\7V\2\2.<\7G\2\2/\60\7v\2\2\60\61\7"+
		"k\2\2\61\62\7r\2\2\62\63\7q\2\2\63\64\7\"\2\2\64\65\7e\2\2\65\66\7n\2"+
		"\2\66\67\7k\2\2\678\7g\2\289\7p\2\29:\7v\2\2:<\7g\2\2;#\3\2\2\2;/\3\2"+
		"\2\2<\4\3\2\2\2=>\7F\2\2>?\7C\2\2?@\7V\2\2@A\7C\2\2AB\7\"\2\2BC\7N\2\2"+
		"CD\7K\2\2DE\7O\2\2EF\7K\2\2FG\7V\2\2GT\7G\2\2HI\7f\2\2IJ\7c\2\2JK\7v\2"+
		"\2KL\7c\2\2LM\7\"\2\2MN\7n\2\2NO\7k\2\2OP\7o\2\2PQ\7k\2\2QR\7v\2\2RT\7"+
		"g\2\2S=\3\2\2\2SH\3\2\2\2T\6\3\2\2\2UV\7X\2\2VW\7C\2\2WX\7N\2\2XY\7Q\2"+
		"\2YZ\7T\2\2Z[\7\"\2\2[\\\7F\2\2\\]\7G\2\2]^\7U\2\2^_\7E\2\2_`\7Q\2\2`"+
		"a\7P\2\2ab\7V\2\2br\7Q\2\2cd\7x\2\2de\7c\2\2ef\7n\2\2fg\7q\2\2gh\7t\2"+
		"\2hi\7\"\2\2ij\7f\2\2jk\7g\2\2kl\7u\2\2lm\7e\2\2mn\7q\2\2no\7p\2\2op\7"+
		"v\2\2pr\7q\2\2qU\3\2\2\2qc\3\2\2\2r\b\3\2\2\2st\7H\2\2tu\7C\2\2uv\7V\2"+
		"\2vw\7W\2\2wx\7T\2\2x\u0080\7C\2\2yz\7h\2\2z{\7c\2\2{|\7v\2\2|}\7w\2\2"+
		"}~\7t\2\2~\u0080\7c\2\2\177s\3\2\2\2\177y\3\2\2\2\u0080\n\3\2\2\2\u0081"+
		"\u0082\7r\2\2\u0082\u0083\7g\2\2\u0083\u0084\7t\2\2\u0084\u0085\7e\2\2"+
		"\u0085\u0086\7g\2\2\u0086\u0087\7p\2\2\u0087\u0088\7v\2\2\u0088\u0089"+
		"\7c\2\2\u0089\u008a\7i\2\2\u008a\u008b\7g\2\2\u008b\u008c\7o\2\2\u008c"+
		"\u008d\7\"\2\2\u008d\u008e\7f\2\2\u008e\u008f\7g\2\2\u008f\u0090\7u\2"+
		"\2\u0090\u0091\7e\2\2\u0091\u0092\7q\2\2\u0092\u0093\7p\2\2\u0093\u0094"+
		"\7v\2\2\u0094\u00aa\7q\2\2\u0095\u0096\7R\2\2\u0096\u0097\7G\2\2\u0097"+
		"\u0098\7T\2\2\u0098\u0099\7E\2\2\u0099\u009a\7G\2\2\u009a\u009b\7P\2\2"+
		"\u009b\u009c\7V\2\2\u009c\u009d\7C\2\2\u009d\u009e\7I\2\2\u009e\u009f"+
		"\7G\2\2\u009f\u00a0\7O\2\2\u00a0\u00a1\7\"\2\2\u00a1\u00a2\7F\2\2\u00a2"+
		"\u00a3\7G\2\2\u00a3\u00a4\7U\2\2\u00a4\u00a5\7E\2\2\u00a5\u00a6\7Q\2\2"+
		"\u00a6\u00a7\7P\2\2\u00a7\u00a8\7V\2\2\u00a8\u00aa\7Q\2\2\u00a9\u0081"+
		"\3\2\2\2\u00a9\u0095\3\2\2\2\u00aa\f\3\2\2\2\u00ab\u00ac\7T\2\2\u00ac"+
		"\u00ad\7G\2\2\u00ad\u00ae\7E\2\2\u00ae\u00af\7Q\2\2\u00af\u00b0\7T\2\2"+
		"\u00b0\u00b1\7T\2\2\u00b1\u00b2\7G\2\2\u00b2\u00b3\7P\2\2\u00b3\u00b4"+
		"\7E\2\2\u00b4\u00b5\7K\2\2\u00b5\u00c2\7C\2\2\u00b6\u00b7\7t\2\2\u00b7"+
		"\u00b8\7g\2\2\u00b8\u00b9\7e\2\2\u00b9\u00ba\7q\2\2\u00ba\u00bb\7t\2\2"+
		"\u00bb\u00bc\7t\2\2\u00bc\u00bd\7g\2\2\u00bd\u00be\7p\2\2\u00be\u00bf"+
		"\7e\2\2\u00bf\u00c0\7k\2\2\u00c0\u00c2\7c\2\2\u00c1\u00ab\3\2\2\2\u00c1"+
		"\u00b6\3\2\2\2\u00c2\16\3\2\2\2\u00c3\u00c4\7v\2\2\u00c4\u00c5\7k\2\2"+
		"\u00c5\u00c6\7r\2\2\u00c6\u00c7\7q\2\2\u00c7\u00c8\7\"\2\2\u00c8\u00c9"+
		"\7f\2\2\u00c9\u00ca\7g\2\2\u00ca\u00cb\7u\2\2\u00cb\u00cc\7e\2\2\u00cc"+
		"\u00cd\7q\2\2\u00cd\u00ce\7p\2\2\u00ce\u00cf\7v\2\2\u00cf\u00de\7q\2\2"+
		"\u00d0\u00d1\7V\2\2\u00d1\u00d2\7K\2\2\u00d2\u00d3\7R\2\2\u00d3\u00d4"+
		"\7Q\2\2\u00d4\u00d5\7\"\2\2\u00d5\u00d6\7F\2\2\u00d6\u00d7\7G\2\2\u00d7"+
		"\u00d8\7U\2\2\u00d8\u00d9\7E\2\2\u00d9\u00da\7Q\2\2\u00da\u00db\7P\2\2"+
		"\u00db\u00dc\7V\2\2\u00dc\u00de\7Q\2\2\u00dd\u00c3\3\2\2\2\u00dd\u00d0"+
		"\3\2\2\2\u00de\20\3\2\2\2\u00df\u00e0\7p\2\2\u00e0\u00e1\7q\2\2\u00e1"+
		"\u00e2\7o\2\2\u00e2\u00e8\7g\2\2\u00e3\u00e4\7P\2\2\u00e4\u00e5\7Q\2\2"+
		"\u00e5\u00e6\7O\2\2\u00e6\u00e8\7G\2\2\u00e7\u00df\3\2\2\2\u00e7\u00e3"+
		"\3\2\2\2\u00e8\22\3\2\2\2\u00e9\u00ea\7K\2\2\u00ea\u00eb\7F\2\2\u00eb"+
		"\u00ec\7G\2\2\u00ec\u00ed\7P\2\2\u00ed\u00ee\7V\2\2\u00ee\u00ef\7K\2\2"+
		"\u00ef\u00f0\7H\2\2\u00f0\u00f1\7K\2\2\u00f1\u00f2\7E\2\2\u00f2\u00f3"+
		"\7C\2\2\u00f3\u00f4\7F\2\2\u00f4\u00f5\7Q\2\2\u00f5\u0104\7T\2\2\u00f6"+
		"\u00f7\7k\2\2\u00f7\u00f8\7f\2\2\u00f8\u00f9\7g\2\2\u00f9\u00fa\7p\2\2"+
		"\u00fa\u00fb\7v\2\2\u00fb\u00fc\7k\2\2\u00fc\u00fd\7h\2\2\u00fd\u00fe"+
		"\7k\2\2\u00fe\u00ff\7e\2\2\u00ff\u0100\7c\2\2\u0100\u0101\7f\2\2\u0101"+
		"\u0102\7q\2\2\u0102\u0104\7t\2\2\u0103\u00e9\3\2\2\2\u0103\u00f6\3\2\2"+
		"\2\u0104\24\3\2\2\2\u0105\u0106\7G\2\2\u0106\u0107\7O\2\2\u0107\u0108"+
		"\7C\2\2\u0108\u0109\7K\2\2\u0109\u0110\7N\2\2\u010a\u010b\7g\2\2\u010b"+
		"\u010c\7o\2\2\u010c\u010d\7c\2\2\u010d\u010e\7k\2\2\u010e\u0110\7n\2\2"+
		"\u010f\u0105\3\2\2\2\u010f\u010a\3\2\2\2\u0110\26\3\2\2\2\u0111\u0112"+
		"\7S\2\2\u0112\u0113\7W\2\2\u0113\u0114\7C\2\2\u0114\u0115\7P\2\2\u0115"+
		"\u0116\7V\2\2\u0116\u0117\7K\2\2\u0117\u0118\7F\2\2\u0118\u0119\7C\2\2"+
		"\u0119\u011a\7F\2\2\u011a\u0126\7G\2\2\u011b\u011c\7s\2\2\u011c\u011d"+
		"\7w\2\2\u011d\u011e\7c\2\2\u011e\u011f\7p\2\2\u011f\u0120\7v\2\2\u0120"+
		"\u0121\7k\2\2\u0121\u0122\7f\2\2\u0122\u0123\7c\2\2\u0123\u0124\7f\2\2"+
		"\u0124\u0126\7g\2\2\u0125\u0111\3\2\2\2\u0125\u011b\3\2\2\2\u0126\30\3"+
		"\2\2\2\u0127\u0128\7R\2\2\u0128\u0129\7N\2\2\u0129\u012a\7C\2\2\u012a"+
		"\u012b\7P\2\2\u012b\u012c\7Q\2\2\u012c\u012d\7\"\2\2\u012d\u012e\7R\2"+
		"\2\u012e\u012f\7C\2\2\u012f\u0130\7I\2\2\u0130\u0131\7C\2\2\u0131\u0132"+
		"\7O\2\2\u0132\u0133\7G\2\2\u0133\u0134\7P\2\2\u0134\u0135\7V\2\2\u0135"+
		"\u0146\7Q\2\2\u0136\u0137\7r\2\2\u0137\u0138\7n\2\2\u0138\u0139\7c\2\2"+
		"\u0139\u013a\7p\2\2\u013a\u013b\7q\2\2\u013b\u013c\7\"\2\2\u013c\u013d"+
		"\7r\2\2\u013d\u013e\7c\2\2\u013e\u013f\7i\2\2\u013f\u0140\7c\2\2\u0140"+
		"\u0141\7o\2\2\u0141\u0142\7g\2\2\u0142\u0143\7p\2\2\u0143\u0144\7v\2\2"+
		"\u0144\u0146\7q\2\2\u0145\u0127\3\2\2\2\u0145\u0136\3\2\2\2\u0146\32\3"+
		"\2\2\2\u0147\u0148\7O\2\2\u0148\u0149\7G\2\2\u0149\u014a\7V\2\2\u014a"+
		"\u014b\7Q\2\2\u014b\u014c\7F\2\2\u014c\u014d\7Q\2\2\u014d\u014e\7\"\2"+
		"\2\u014e\u014f\7R\2\2\u014f\u0150\7C\2\2\u0150\u0151\7I\2\2\u0151\u0152"+
		"\7C\2\2\u0152\u0153\7O\2\2\u0153\u0154\7G\2\2\u0154\u0155\7P\2\2\u0155"+
		"\u0156\7V\2\2\u0156\u0168\7Q\2\2\u0157\u0158\7o\2\2\u0158\u0159\7g\2\2"+
		"\u0159\u015a\7v\2\2\u015a\u015b\7q\2\2\u015b\u015c\7f\2\2\u015c\u015d"+
		"\7q\2\2\u015d\u015e\7\"\2\2\u015e\u015f\7r\2\2\u015f\u0160\7c\2\2\u0160"+
		"\u0161\7i\2\2\u0161\u0162\7c\2\2\u0162\u0163\7o\2\2\u0163\u0164\7g\2\2"+
		"\u0164\u0165\7p\2\2\u0165\u0166\7v\2\2\u0166\u0168\7q\2\2\u0167\u0147"+
		"\3\2\2\2\u0167\u0157\3\2\2\2\u0168\34\3\2\2\2\u0169\u016b\t\2\2\2\u016a"+
		"\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2"+
		"\2\2\u016d\36\3\2\2\2\u016e\u0170\t\3\2\2\u016f\u016e\3\2\2\2\u0170\u0171"+
		"\3\2\2\2\u0171\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0173\3\2\2\2\u0173"+
		"\u0174\b\20\2\2\u0174 \3\2\2\2\u0175\u0177\7\17\2\2\u0176\u0175\3\2\2"+
		"\2\u0176\u0177\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u0179\7\f\2\2\u0179\u017a"+
		"\3\2\2\2\u017a\u017b\b\21\2\2\u017b\"\3\2\2\2\23\2;Sq\177\u00a9\u00c1"+
		"\u00dd\u00e7\u0103\u010f\u0125\u0145\u0167\u016c\u0171\u0176\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}