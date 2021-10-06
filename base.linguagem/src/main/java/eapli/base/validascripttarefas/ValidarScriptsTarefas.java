/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.validascripttarefas;


import eapli.base.linguagem.ThrowingErrorListener;
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
public class ValidarScriptsTarefas {


    public boolean parseWithVisitor(String text) {
        String transformado = text;
        CharStream stream = new ANTLRInputStream(transformado);

        ValidaScriptTarefasLexer lexer = new ValidaScriptTarefasLexer(stream);
        lexer.removeErrorListeners();
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ValidaScriptTarefasParser parser = new ValidaScriptTarefasParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);

        try {
            ParseTree tree = parser.inicio(); // parse
            EvalValidarScriptsVisitor eval = new EvalValidarScriptsVisitor();
            eval.visit(tree);
            return true;
        } catch (Exception ex) {
            System.out.println(":::::::::::::::::::::::::::::::::::::\n"+ex.getMessage()+"\n:::::::::::::::::::::::::::::::::::::\n");
            return false;
        }

    }

}
