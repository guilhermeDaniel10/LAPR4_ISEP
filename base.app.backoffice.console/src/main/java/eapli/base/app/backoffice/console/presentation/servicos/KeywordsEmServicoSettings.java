/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.base.servicomanagement.application.RegistarServicoController;
import eapli.base.servicomanagement.domain.Keyword;
import eapli.base.servicomanagement.domain.KeywordsEmServico;
import eapli.framework.io.util.Console;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
@SuppressWarnings({ "squid:S106" })
public class KeywordsEmServicoSettings {
    
    private final RegistarServicoController servicoController = new RegistarServicoController();
    private final Set<Keyword> allKeywordsSet = new HashSet<>();
    private final List<String> list;
    private int option = -1;

    public  KeywordsEmServicoSettings() {
        list = makeList();
    }

    private List<String> makeList() {
        final List<String> result = new ArrayList<>();
        
        result.add("Adicionar Keyword");
        
        return result;
    }

    private void showOpcoes() {
        int cont = 0;
        System.out.println(" Escolha o dado que quer introduzir");
        System.out.println("0.  Sem mais dados em falta");
        for (final String dados : list) {
            cont++;
            System.out.println(cont + ".  " + dados);
        }
    }

    public Set<Keyword> criarKeywordsEmServico() {
        while (option != 0) { 
            showOpcoes();
            option = Console.readOption(1, list.size(), 0);
            if (option != 0) {
                String strKeyword = Console.readLine("Keyword do Servico:");             
                boolean sucesso = true;
                Keyword key = null;
                try{
                    key = servicoController.registerKeyword(strKeyword);
                }catch (IllegalArgumentException e){
                    System.out.println("Erro na Keyword introduzida!");
                    sucesso = false;
                } catch (ParseException ex) {
                    sucesso = false;
                    Logger.getLogger(KeywordsEmServicoSettings.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if (sucesso) {
                    this.allKeywordsSet.add(key);
                }
            }
        }
        return this.allKeywordsSet;
    }
    
}
