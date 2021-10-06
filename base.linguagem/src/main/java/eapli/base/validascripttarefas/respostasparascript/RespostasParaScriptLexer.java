package eapli.base.validascripttarefas.respostasparascript;

// Generated from RespostasParaScript.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RespostasParaScriptLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"SCRIPT", "FATURA", "CLI", "PROD", "EMAIL", "INTEIRO_QUANTIDADE", "INTEIRO", 
			"NUMERARIO", "PLANO_PAGAMENTO", "MB", "CHEQUE", "NOME", "TIPO_DESCONTO", 
			"RECORRENCIA", "PERCENTAGEM_DESCONTO", "COUNTRY_CODE", "TWO_DIGITS", 
			"BANK", "AGENCY", "ACOUNT_NUMBER", "VALOR_DESCONTO", "TIPO_CLIENTE", 
			"NEWLINE", "WS", "NL"
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


	public RespostasParaScriptLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RespostasParaScript.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\33\u0209\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\6\28\n\2\r\2\16\29\3\2\6\2=\n\2\r\2\16\2>\3\2"+
		"\6\2B\n\2\r\2\16\2C\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\6\6\\\n\6\r\6\16\6]\3\6\7\6a\n"+
		"\6\f\6\16\6d\13\6\6\6f\n\6\r\6\16\6g\3\6\3\6\6\6l\n\6\r\6\16\6m\3\6\6"+
		"\6q\n\6\r\6\16\6r\3\6\3\6\3\6\3\6\3\6\5\6z\n\6\3\7\3\7\7\7~\n\7\f\7\16"+
		"\7\u0081\13\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0097\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\5\n\u00fd\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\5\13\u0117\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\5\f\u0125\n\f\3\r\3\r\6\r\u0129\n\r\r\r\16\r\u012a\3\r\3\r\3"+
		"\r\6\r\u0130\n\r\r\r\16\r\u0131\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\5\16\u0168\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u018e\n\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\7\26\u01b2\n\26\f\26\16\26\u01b5"+
		"\13\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u01f5\n\27\3\30\6\30\u01f8\n"+
		"\30\r\30\16\30\u01f9\3\31\6\31\u01fd\n\31\r\31\16\31\u01fe\3\31\3\31\3"+
		"\32\5\32\u0204\n\32\3\32\3\32\3\32\3\32\2\2\33\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\3\2\13\3\2\62;\4\2C\\c|\t\2\"\"\'\')-/\61"+
		"]_aa~~\5\2\62;C\\c|\3\2\63;\3\2C\\\3\2c|\4\2\f\f\17\17\4\2\13\13\"\"\2"+
		"\u0233\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\3\65\3\2\2\2\5G\3\2\2\2\7M\3\2\2\2"+
		"\tS\3\2\2\2\13e\3\2\2\2\r{\3\2\2\2\17\u0082\3\2\2\2\21\u0096\3\2\2\2\23"+
		"\u00fc\3\2\2\2\25\u0116\3\2\2\2\27\u0124\3\2\2\2\31\u0126\3\2\2\2\33\u0167"+
		"\3\2\2\2\35\u018d\3\2\2\2\37\u018f\3\2\2\2!\u0192\3\2\2\2#\u0197\3\2\2"+
		"\2%\u019a\3\2\2\2\'\u019f\3\2\2\2)\u01a4\3\2\2\2+\u01b3\3\2\2\2-\u01f4"+
		"\3\2\2\2/\u01f7\3\2\2\2\61\u01fc\3\2\2\2\63\u0203\3\2\2\2\65A\7$\2\2\66"+
		"8\t\2\2\2\67\66\3\2\2\289\3\2\2\29\67\3\2\2\29:\3\2\2\2:B\3\2\2\2;=\t"+
		"\3\2\2<;\3\2\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2\2?B\3\2\2\2@B\t\4\2\2A\67"+
		"\3\2\2\2A<\3\2\2\2A@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2DE\3\2\2\2E"+
		"F\7$\2\2F\4\3\2\2\2GH\5!\21\2HI\5%\23\2IJ\5\'\24\2JK\5)\25\2KL\5#\22\2"+
		"L\6\3\2\2\2MN\7E\2\2NO\7n\2\2OP\7k\2\2PQ\3\2\2\2QR\5\r\7\2R\b\3\2\2\2"+
		"ST\7R\2\2TU\7t\2\2UV\7q\2\2VW\7f\2\2WX\3\2\2\2XY\5\r\7\2Y\n\3\2\2\2Z\\"+
		"\t\5\2\2[Z\3\2\2\2\\]\3\2\2\2][\3\2\2\2]^\3\2\2\2^b\3\2\2\2_a\7a\2\2`"+
		"_\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2cf\3\2\2\2db\3\2\2\2e[\3\2\2\2"+
		"fg\3\2\2\2ge\3\2\2\2gh\3\2\2\2hi\3\2\2\2ip\7B\2\2jl\t\3\2\2kj\3\2\2\2"+
		"lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2no\3\2\2\2oq\7\60\2\2pk\3\2\2\2qr\3\2\2"+
		"\2rp\3\2\2\2rs\3\2\2\2sy\3\2\2\2tu\7e\2\2uv\7q\2\2vz\7o\2\2wx\7r\2\2x"+
		"z\7v\2\2yt\3\2\2\2yw\3\2\2\2z\f\3\2\2\2{\177\t\6\2\2|~\t\2\2\2}|\3\2\2"+
		"\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\16\3\2\2\2\u0081"+
		"\177\3\2\2\2\u0082\u0083\t\2\2\2\u0083\20\3\2\2\2\u0084\u0085\7P\2\2\u0085"+
		"\u0086\7W\2\2\u0086\u0087\7O\2\2\u0087\u0088\7G\2\2\u0088\u0089\7T\2\2"+
		"\u0089\u008a\7C\2\2\u008a\u008b\7T\2\2\u008b\u008c\7K\2\2\u008c\u0097"+
		"\7Q\2\2\u008d\u008e\7p\2\2\u008e\u008f\7w\2\2\u008f\u0090\7o\2\2\u0090"+
		"\u0091\7g\2\2\u0091\u0092\7t\2\2\u0092\u0093\7c\2\2\u0093\u0094\7t\2\2"+
		"\u0094\u0095\7k\2\2\u0095\u0097\7q\2\2\u0096\u0084\3\2\2\2\u0096\u008d"+
		"\3\2\2\2\u0097\22\3\2\2\2\u0098\u0099\7R\2\2\u0099\u009a\7T\2\2\u009a"+
		"\u009b\7Q\2\2\u009b\u009c\7P\2\2\u009c\u009d\7V\2\2\u009d\u009e\7Q\2\2"+
		"\u009e\u009f\7\"\2\2\u009f\u00a0\7R\2\2\u00a0\u00a1\7C\2\2\u00a1\u00a2"+
		"\7I\2\2\u00a2\u00a3\7C\2\2\u00a3\u00a4\7O\2\2\u00a4\u00a5\7G\2\2\u00a5"+
		"\u00a6\7P\2\2\u00a6\u00a7\7V\2\2\u00a7\u00fd\7Q\2\2\u00a8\u00a9\7r\2\2"+
		"\u00a9\u00aa\7t\2\2\u00aa\u00ab\7q\2\2\u00ab\u00ac\7p\2\2\u00ac\u00ad"+
		"\7v\2\2\u00ad\u00ae\7q\2\2\u00ae\u00af\7\"\2\2\u00af\u00b0\7r\2\2\u00b0"+
		"\u00b1\7c\2\2\u00b1\u00b2\7i\2\2\u00b2\u00b3\7c\2\2\u00b3\u00b4\7o\2\2"+
		"\u00b4\u00b5\7g\2\2\u00b5\u00b6\7p\2\2\u00b6\u00b7\7v\2\2\u00b7\u00fd"+
		"\7q\2\2\u00b8\u00b9\7R\2\2\u00b9\u00ba\7C\2\2\u00ba\u00bb\7I\2\2\u00bb"+
		"\u00bc\7C\2\2\u00bc\u00bd\7O\2\2\u00bd\u00be\7G\2\2\u00be\u00bf\7P\2\2"+
		"\u00bf\u00c0\7V\2\2\u00c0\u00c1\7Q\2\2\u00c1\u00c2\7\"\2\2\u00c2\u00c3"+
		"\7C\2\2\u00c3\u00c4\7\"\2\2\u00c4\u00c5\7\65\2\2\u00c5\u00c6\7\62\2\2"+
		"\u00c6\u00c7\7\"\2\2\u00c7\u00c8\7F\2\2\u00c8\u00c9\7K\2\2\u00c9\u00ca"+
		"\7C\2\2\u00ca\u00fd\7U\2\2\u00cb\u00cc\7r\2\2\u00cc\u00cd\7c\2\2\u00cd"+
		"\u00ce\7i\2\2\u00ce\u00cf\7c\2\2\u00cf\u00d0\7o\2\2\u00d0\u00d1\7g\2\2"+
		"\u00d1\u00d2\7p\2\2\u00d2\u00d3\7v\2\2\u00d3\u00d4\7q\2\2\u00d4\u00d5"+
		"\7\"\2\2\u00d5\u00d6\7c\2\2\u00d6\u00d7\7\"\2\2\u00d7\u00d8\7\65\2\2\u00d8"+
		"\u00d9\7\62\2\2\u00d9\u00da\7\"\2\2\u00da\u00db\7f\2\2\u00db\u00dc\7k"+
		"\2\2\u00dc\u00dd\7c\2\2\u00dd\u00fd\7u\2\2\u00de\u00df\7R\2\2\u00df\u00e0"+
		"\7C\2\2\u00e0\u00e1\7I\2\2\u00e1\u00e2\7C\2\2\u00e2\u00e3\7O\2\2\u00e3"+
		"\u00e4\7G\2\2\u00e4\u00e5\7P\2\2\u00e5\u00e6\7V\2\2\u00e6\u00e7\7Q\2\2"+
		"\u00e7\u00e8\7\"\2\2\u00e8\u00e9\7C\2\2\u00e9\u00ea\7P\2\2\u00ea\u00eb"+
		"\7W\2\2\u00eb\u00ec\7C\2\2\u00ec\u00fd\7N\2\2\u00ed\u00ee\7r\2\2\u00ee"+
		"\u00ef\7c\2\2\u00ef\u00f0\7i\2\2\u00f0\u00f1\7c\2\2\u00f1\u00f2\7o\2\2"+
		"\u00f2\u00f3\7g\2\2\u00f3\u00f4\7p\2\2\u00f4\u00f5\7v\2\2\u00f5\u00f6"+
		"\7q\2\2\u00f6\u00f7\7\"\2\2\u00f7\u00f8\7c\2\2\u00f8\u00f9\7p\2\2\u00f9"+
		"\u00fa\7w\2\2\u00fa\u00fb\7c\2\2\u00fb\u00fd\7n\2\2\u00fc\u0098\3\2\2"+
		"\2\u00fc\u00a8\3\2\2\2\u00fc\u00b8\3\2\2\2\u00fc\u00cb\3\2\2\2\u00fc\u00de"+
		"\3\2\2\2\u00fc\u00ed\3\2\2\2\u00fd\24\3\2\2\2\u00fe\u00ff\7O\2\2\u00ff"+
		"\u0100\7W\2\2\u0100\u0101\7N\2\2\u0101\u0102\7V\2\2\u0102\u0103\7K\2\2"+
		"\u0103\u0104\7D\2\2\u0104\u0105\7C\2\2\u0105\u0106\7P\2\2\u0106\u0107"+
		"\7E\2\2\u0107\u0117\7Q\2\2\u0108\u0109\7o\2\2\u0109\u010a\7w\2\2\u010a"+
		"\u010b\7n\2\2\u010b\u010c\7v\2\2\u010c\u010d\7k\2\2\u010d\u010e\7d\2\2"+
		"\u010e\u010f\7c\2\2\u010f\u0110\7p\2\2\u0110\u0111\7e\2\2\u0111\u0117"+
		"\7q\2\2\u0112\u0113\7O\2\2\u0113\u0117\7D\2\2\u0114\u0115\7o\2\2\u0115"+
		"\u0117\7d\2\2\u0116\u00fe\3\2\2\2\u0116\u0108\3\2\2\2\u0116\u0112\3\2"+
		"\2\2\u0116\u0114\3\2\2\2\u0117\26\3\2\2\2\u0118\u0119\7E\2\2\u0119\u011a"+
		"\7J\2\2\u011a\u011b\7G\2\2\u011b\u011c\7S\2\2\u011c\u011d\7W\2\2\u011d"+
		"\u0125\7G\2\2\u011e\u011f\7e\2\2\u011f\u0120\7j\2\2\u0120\u0121\7g\2\2"+
		"\u0121\u0122\7s\2\2\u0122\u0123\7w\2\2\u0123\u0125\7g\2\2\u0124\u0118"+
		"\3\2\2\2\u0124\u011e\3\2\2\2\u0125\30\3\2\2\2\u0126\u0128\t\7\2\2\u0127"+
		"\u0129\t\b\2\2\u0128\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u0128\3\2"+
		"\2\2\u012a\u012b\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012d\7\"\2\2\u012d"+
		"\u012f\t\7\2\2\u012e\u0130\t\b\2\2\u012f\u012e\3\2\2\2\u0130\u0131\3\2"+
		"\2\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\32\3\2\2\2\u0133\u0134"+
		"\7U\2\2\u0134\u0135\7C\2\2\u0135\u0136\7\\\2\2\u0136\u0137\7Q\2\2\u0137"+
		"\u0138\7P\2\2\u0138\u0139\7C\2\2\u0139\u0168\7N\2\2\u013a\u013b\7u\2\2"+
		"\u013b\u013c\7c\2\2\u013c\u013d\7|\2\2\u013d\u013e\7q\2\2\u013e\u013f"+
		"\7p\2\2\u013f\u0140\7c\2\2\u0140\u0168\7n\2\2\u0141\u0142\7t\2\2\u0142"+
		"\u0143\7g\2\2\u0143\u0144\7n\2\2\u0144\u0145\7c\2\2\u0145\u0146\7o\2\2"+
		"\u0146\u0147\7r\2\2\u0147\u0148\7c\2\2\u0148\u0149\7i\2\2\u0149\u0168"+
		"\7q\2\2\u014a\u014b\7T\2\2\u014b\u014c\7G\2\2\u014c\u014d\7N\2\2\u014d"+
		"\u014e\7C\2\2\u014e\u014f\7O\2\2\u014f\u0150\7R\2\2\u0150\u0151\7C\2\2"+
		"\u0151\u0152\7I\2\2\u0152\u0168\7Q\2\2\u0153\u0154\7S\2\2\u0154\u0155"+
		"\7W\2\2\u0155\u0156\7C\2\2\u0156\u0157\7P\2\2\u0157\u0158\7V\2\2\u0158"+
		"\u0159\7K\2\2\u0159\u015a\7F\2\2\u015a\u015b\7C\2\2\u015b\u015c\7F\2\2"+
		"\u015c\u0168\7G\2\2\u015d\u015e\7s\2\2\u015e\u015f\7w\2\2\u015f\u0160"+
		"\7c\2\2\u0160\u0161\7p\2\2\u0161\u0162\7v\2\2\u0162\u0163\7k\2\2\u0163"+
		"\u0164\7f\2\2\u0164\u0165\7c\2\2\u0165\u0166\7f\2\2\u0166\u0168\7g\2\2"+
		"\u0167\u0133\3\2\2\2\u0167\u013a\3\2\2\2\u0167\u0141\3\2\2\2\u0167\u014a"+
		"\3\2\2\2\u0167\u0153\3\2\2\2\u0167\u015d\3\2\2\2\u0168\34\3\2\2\2\u0169"+
		"\u016a\7U\2\2\u016a\u016b\7G\2\2\u016b\u016c\7O\2\2\u016c\u016d\7C\2\2"+
		"\u016d\u016e\7P\2\2\u016e\u016f\7C\2\2\u016f\u018e\7N\2\2\u0170\u0171"+
		"\7u\2\2\u0171\u0172\7g\2\2\u0172\u0173\7o\2\2\u0173\u0174\7c\2\2\u0174"+
		"\u0175\7p\2\2\u0175\u0176\7c\2\2\u0176\u018e\7n\2\2\u0177\u0178\7C\2\2"+
		"\u0178\u0179\7P\2\2\u0179\u017a\7W\2\2\u017a\u017b\7C\2\2\u017b\u018e"+
		"\7N\2\2\u017c\u017d\7c\2\2\u017d\u017e\7p\2\2\u017e\u017f\7w\2\2\u017f"+
		"\u0180\7c\2\2\u0180\u018e\7n\2\2\u0181\u0182\7O\2\2\u0182\u0183\7G\2\2"+
		"\u0183\u0184\7P\2\2\u0184\u0185\7U\2\2\u0185\u0186\7C\2\2\u0186\u018e"+
		"\7N\2\2\u0187\u0188\7o\2\2\u0188\u0189\7g\2\2\u0189\u018a\7p\2\2\u018a"+
		"\u018b\7u\2\2\u018b\u018c\7c\2\2\u018c\u018e\7n\2\2\u018d\u0169\3\2\2"+
		"\2\u018d\u0170\3\2\2\2\u018d\u0177\3\2\2\2\u018d\u017c\3\2\2\2\u018d\u0181"+
		"\3\2\2\2\u018d\u0187\3\2\2\2\u018e\36\3\2\2\2\u018f\u0190\t\2\2\2\u0190"+
		"\u0191\7\'\2\2\u0191 \3\2\2\2\u0192\u0193\t\7\2\2\u0193\u0194\t\7\2\2"+
		"\u0194\u0195\t\2\2\2\u0195\u0196\t\2\2\2\u0196\"\3\2\2\2\u0197\u0198\t"+
		"\2\2\2\u0198\u0199\t\2\2\2\u0199$\3\2\2\2\u019a\u019b\t\2\2\2\u019b\u019c"+
		"\t\2\2\2\u019c\u019d\t\2\2\2\u019d\u019e\t\2\2\2\u019e&\3\2\2\2\u019f"+
		"\u01a0\t\2\2\2\u01a0\u01a1\t\2\2\2\u01a1\u01a2\t\2\2\2\u01a2\u01a3\t\2"+
		"\2\2\u01a3(\3\2\2\2\u01a4\u01a5\t\2\2\2\u01a5\u01a6\t\2\2\2\u01a6\u01a7"+
		"\t\2\2\2\u01a7\u01a8\t\2\2\2\u01a8\u01a9\t\2\2\2\u01a9\u01aa\t\2\2\2\u01aa"+
		"\u01ab\t\2\2\2\u01ab\u01ac\t\2\2\2\u01ac\u01ad\t\2\2\2\u01ad\u01ae\t\2"+
		"\2\2\u01ae\u01af\t\2\2\2\u01af*\3\2\2\2\u01b0\u01b2\t\2\2\2\u01b1\u01b0"+
		"\3\2\2\2\u01b2\u01b5\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4"+
		"\u01b6\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b6\u01b7\7\60\2\2\u01b7\u01b8\t"+
		"\2\2\2\u01b8\u01b9\t\2\2\2\u01b9,\3\2\2\2\u01ba\u01bb\7p\2\2\u01bb\u01bc"+
		"\7c\2\2\u01bc\u01bd\7e\2\2\u01bd\u01be\7k\2\2\u01be\u01bf\7q\2\2\u01bf"+
		"\u01c0\7p\2\2\u01c0\u01c1\7c\2\2\u01c1\u01f5\7n\2\2\u01c2\u01c3\7g\2\2"+
		"\u01c3\u01c4\7w\2\2\u01c4\u01c5\7t\2\2\u01c5\u01c6\7q\2\2\u01c6\u01c7"+
		"\7r\2\2\u01c7\u01c8\7g\2\2\u01c8\u01f5\7w\2\2\u01c9\u01ca\7t\2\2\u01ca"+
		"\u01cb\7g\2\2\u01cb\u01cc\7u\2\2\u01cc\u01cd\7v\2\2\u01cd\u01ce\7q\2\2"+
		"\u01ce\u01cf\7\"\2\2\u01cf\u01d0\7f\2\2\u01d0\u01d1\7q\2\2\u01d1\u01d2"+
		"\7\"\2\2\u01d2\u01d3\7o\2\2\u01d3\u01d4\7w\2\2\u01d4\u01d5\7p\2\2\u01d5"+
		"\u01d6\7f\2\2\u01d6\u01f5\7q\2\2\u01d7\u01d8\7P\2\2\u01d8\u01d9\7C\2\2"+
		"\u01d9\u01da\7E\2\2\u01da\u01db\7K\2\2\u01db\u01dc\7Q\2\2\u01dc\u01dd"+
		"\7P\2\2\u01dd\u01de\7C\2\2\u01de\u01f5\7N\2\2\u01df\u01e0\7G\2\2\u01e0"+
		"\u01e1\7W\2\2\u01e1\u01e2\7T\2\2\u01e2\u01e3\7Q\2\2\u01e3\u01e4\7R\2\2"+
		"\u01e4\u01e5\7G\2\2\u01e5\u01f5\7W\2\2\u01e6\u01e7\7T\2\2\u01e7\u01e8"+
		"\7G\2\2\u01e8\u01e9\7U\2\2\u01e9\u01ea\7V\2\2\u01ea\u01eb\7Q\2\2\u01eb"+
		"\u01ec\7\"\2\2\u01ec\u01ed\7F\2\2\u01ed\u01ee\7Q\2\2\u01ee\u01ef\7\"\2"+
		"\2\u01ef\u01f0\7O\2\2\u01f0\u01f1\7W\2\2\u01f1\u01f2\7P\2\2\u01f2\u01f3"+
		"\7F\2\2\u01f3\u01f5\7Q\2\2\u01f4\u01ba\3\2\2\2\u01f4\u01c2\3\2\2\2\u01f4"+
		"\u01c9\3\2\2\2\u01f4\u01d7\3\2\2\2\u01f4\u01df\3\2\2\2\u01f4\u01e6\3\2"+
		"\2\2\u01f5.\3\2\2\2\u01f6\u01f8\t\t\2\2\u01f7\u01f6\3\2\2\2\u01f8\u01f9"+
		"\3\2\2\2\u01f9\u01f7\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa\60\3\2\2\2\u01fb"+
		"\u01fd\t\n\2\2\u01fc\u01fb\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe\u01fc\3\2"+
		"\2\2\u01fe\u01ff\3\2\2\2\u01ff\u0200\3\2\2\2\u0200\u0201\b\31\2\2\u0201"+
		"\62\3\2\2\2\u0202\u0204\7\17\2\2\u0203\u0202\3\2\2\2\u0203\u0204\3\2\2"+
		"\2\u0204\u0205\3\2\2\2\u0205\u0206\7\f\2\2\u0206\u0207\3\2\2\2\u0207\u0208"+
		"\b\32\2\2\u0208\64\3\2\2\2\33\29>AC]bgmry\177\u0096\u00fc\u0116\u0124"+
		"\u012a\u0131\u0167\u018d\u01b3\u01f4\u01f9\u01fe\u0203\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}