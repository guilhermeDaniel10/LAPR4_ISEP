/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.equipas;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.framework.io.util.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Guilherme
 */
@SuppressWarnings({ "squid:S106" })
public class ResponsaveisEquipaSettings {
    
    private final Set<Colaborador> todosColaboradoresSet;
    private final List<Colaborador> list;
    private int option = -1;
    
    public ResponsaveisEquipaSettings(final Iterable<Colaborador> all) {
        todosColaboradoresSet = new HashSet<>();
        list = makeList(all);
    }
    
    private List<Colaborador> makeList(final Iterable<Colaborador> colaboradores) {
        final List<Colaborador> result = new ArrayList<>();
        for (final Colaborador item : colaboradores) {
            result.add(item);
        }
        return result;
    }
    
    private void showColaboradores() {
        int cont = 0;
        System.out.println(" Escolha um colaborador");
        System.out.println("0.  Sem mais colaboradores responsáveis");
        for (final Colaborador colaborador : list) {
            cont++;
            System.out.println(cont + ".  " + colaborador.numeroMecanografico().toString() + " " + colaborador.nomeCurto());
        }
    }

    public Set<Colaborador> setColaboradoresEmCatalogo() {
        showColaboradores();
        
        while (option != 0) { 
            option = Console.readOption(1, list.size(), 0);
            if (option != 0) {
                final Colaborador elem = list.get(option - 1);
                System.out.println("Selecionou o colaborador: " + elem.nomeCompleto());
                todosColaboradoresSet.add(elem);
            }
        }
        return todosColaboradoresSet;
    }
    
}
