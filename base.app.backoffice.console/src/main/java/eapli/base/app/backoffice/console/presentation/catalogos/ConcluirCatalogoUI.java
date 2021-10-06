/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.catalogos;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.repositories.CatalogoRepository;
import eapli.base.catalogomanagemente.application.RegistarCatalogoController;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.presentation.console.SelectWidget;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author lucas
 */
public class ConcluirCatalogoUI {
    
    private final RegistarCatalogoController catalogoController = new RegistarCatalogoController();
   
    protected boolean doShow() throws IOException {

        final Iterable<Catalogo> catalogosPorConcluir = this.catalogoController.catalogosPorConcluir();
        
        if (catalogosPorConcluir.iterator().hasNext() == false) {
            System.out.println("Nao existem mais catalogos por concluir!");
            return false;
        }
        
        final SelectWidget<Catalogo> selectorCatalogo = new SelectWidget<>("Escolha que catalogo deseja finalizar:", catalogosPorConcluir,
                new CatalogoPrinter());
        selectorCatalogo.show();
        
        Catalogo catalogoPorConcluir = selectorCatalogo.selectedElement();
        
        if (catalogoPorConcluir == null) {
            return true;
        }
        
        Catalogo catalogoConcluido = new DadosCatalogoSettings(catalogoPorConcluir).concluirCatalogo();
        
        try {
            catalogoController.registerCatalogo(catalogoConcluido);
        } catch (ParseException ex) {
            Logger.getLogger(ConcluirCatalogoUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }

    public String headline() {
        return "Concluir Catalogo";
    }
    
}
