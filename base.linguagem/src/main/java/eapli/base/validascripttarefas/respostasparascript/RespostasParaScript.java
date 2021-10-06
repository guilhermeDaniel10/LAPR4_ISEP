/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.validascripttarefas.respostasparascript;

import static eapli.base.linguagem.Expressions.convertListToReadableString;
import eapli.base.linguagem.ThrowingErrorListener;
import eapli.base.linguagem.ValidateFormularioLexer;
import eapli.base.linguagem.ValidateFormularioParser;
import java.io.IOException;
import java.util.List;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 *
 * @author Guilherme
 */
public class RespostasParaScript {

    public static void main(String[] args) throws IOException {
        
    }

    public static String parseWithVisitor() throws IOException {

        RespostasParaScriptLexer lexer = new RespostasParaScriptLexer(CharStreams.fromFileName("C:\\Users\\Guilherme\\Desktop\\LAPR4_GIT\\lei20_21_s4_2dm_02\\base.linguagem\\src\\main\\java\\eapli\\base\\validascripttarefas\\respostasparascript\\teste.txt"));
        lexer.removeErrorListeners();
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RespostasParaScriptParser parser = new RespostasParaScriptParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);

//        try {
        ParseTree tree = parser.inicio(); // parse
        EvalVisitorRespostasParaScript eval = new EvalVisitorRespostasParaScript();
        eval.visit(tree);

        return eval.getNewScript();
//        } catch (Exception ex) {
//            return "NOT OK";
//        }

    }

    public String parseToScriptComResposta(String text) {
        String transformado = text;
        CharStream stream = new ANTLRInputStream(transformado);

        RespostasParaScriptLexer lexer = new RespostasParaScriptLexer(stream);
        lexer.removeErrorListeners();
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RespostasParaScriptParser parser = new RespostasParaScriptParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);

        try {
            ParseTree tree = parser.inicio(); // parse
            EvalVisitorRespostasParaScript eval = new EvalVisitorRespostasParaScript();
            eval.visit(tree);
            return eval.getNewScript();
        } catch (Exception ex) {
            return null;
        }

    }

}
