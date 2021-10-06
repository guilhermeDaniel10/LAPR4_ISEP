/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.linguagem;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

/**
 *
 * @author Guilherme
 */
public class Expressions {

    public static void main(String[] args) {
        System.out.println("ResultWithVisitor: ");
        parseWithVisitor();

    }

    private static void parseWithVisitor() {
        try {
            ValidateFormularioLexer lexer = new ValidateFormularioLexer(CharStreams.fromFileName("C:\\Users\\Guilherme\\Desktop\\LAPR4_GIT\\lei20_21_s4_2dm_02\\base.linguagem\\src\\main\\java\\eapli\\base\\linguagem\\teste.txt"));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ValidateFormularioParser parser = new ValidateFormularioParser(tokens);
            ParseTree tree = parser.inicio(); // parse
           
            EvalVisitor eval = new EvalVisitor();
            
            String value = eval.visit(tree);

        } catch (IOException ex) {
            Logger.getLogger(Expressions.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
