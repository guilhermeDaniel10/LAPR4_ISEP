/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.catalogos;

import eapli.base.equipamanagement.domain.Equipa;
import eapli.framework.io.util.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author lucas
 */
@SuppressWarnings({ "squid:S106" })
public class EquipasEmCatalogoSettings {
    
    private final Set<Equipa> todasEquipasSet;
    private final List<Equipa> list;
    private int option = -1;

    public EquipasEmCatalogoSettings(final Iterable<Equipa> all) {
        todasEquipasSet = new HashSet<>();
        list = makeList(all);
    }

    private List<Equipa> makeList(final Iterable<Equipa> equipas) {
        final List<Equipa> result = new ArrayList<>();
        for (final Equipa item : equipas) {
            result.add(item);
        }
        return result;
    }

    private void showEquipas() {
        int cont = 0;
        System.out.println(" Escolha a equipa com acesso");
        System.out.println("0.  Sem mais equipas com acesso");
        for (final Equipa equipas : list) {
            cont++;
            System.out.printf("\n%d. ID Equipa: %-10s Acronimo da Equipa: %-10s", cont, equipas.identity(), equipas.acronimoEquipa());
        }
        System.out.println("");
    }

    public Set<Equipa> setEquipasEmCatalogo() {
        showEquipas();
        
        while (option != 0) { 
            option = Console.readOption(1, list.size(), 0);
            if (option != 0) {
                final Equipa elem = list.get(option - 1);
                System.out.println("Selecionou a equipa: " + elem.designacaoEquipa());
                todasEquipasSet.add(elem);
            }
        }
        return todasEquipasSet;
    }
}
