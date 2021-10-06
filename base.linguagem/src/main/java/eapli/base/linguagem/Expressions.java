/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.linguagem;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.*;

/**
 *
 * @author Guilherme
 */
public class Expressions {

    public static String parseWithVisitor(List<String> text) {
        
        String transformado = convertListToReadableString(text);
        CharStream stream = new ANTLRInputStream(transformado);

        ValidateFormularioLexer lexer = new ValidateFormularioLexer(stream);
        
        lexer.removeErrorListeners(); 
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ValidateFormularioParser parser = new ValidateFormularioParser(tokens);
        
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);

        try {
            ParseTree tree = parser.inicio(); // parse
            EvalVisitor eval = new EvalVisitor();
            eval.visit(tree);
            return "OK";
        } catch (Exception ex) {
            return "NOT OK";
        }

    }

    public static String convertListToReadableString(List<String> list) {
        String text = "";

        for (String s : list) {
            text += s + "\n";
        }

        return text;
    }
}
