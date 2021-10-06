/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.tarefasautomaticas;

import eapli.base.linguagem.ThrowingErrorListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 *
 * @author Guilherme
 */
public class TarefasAutomaticasExecutor {

    public static void main(String[] args) throws IOException {
        parseWithListener();
    }

    public static void parseWithListener() throws IOException {
        TarefasAutomaticasLexer lexer = new TarefasAutomaticasLexer(CharStreams.fromFileName("C:\\Users\\Guilherme\\Desktop\\LAPR4_GIT\\lei20_21_s4_2dm_02\\base.linguagem\\src\\main\\java\\eapli\\base\\tarefasautomaticas\\teste.txt"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TarefasAutomaticasParser parser = new TarefasAutomaticasParser(tokens);
        ParseTree tree = parser.inicio(); // parse
        ParseTreeWalker walker = new ParseTreeWalker();
        EvalListener eListener = new EvalListener();
        walker.walk(eListener, tree);
        List<String> listStack = eListener.getStack();

        
    }
    
    public void executarScriptAutomatico(String text){
        String transformado = text;
        CharStream stream = new ANTLRInputStream(transformado);

        TarefasAutomaticasLexer lexer = new TarefasAutomaticasLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TarefasAutomaticasParser parser = new TarefasAutomaticasParser(tokens);
        ParseTree tree = parser.inicio(); // parse
        ParseTreeWalker walker = new ParseTreeWalker();
        EvalListener eListener = new EvalListener();
        walker.walk(eListener, tree);
        List<String> listStack = eListener.getStack();

    
    }

}
