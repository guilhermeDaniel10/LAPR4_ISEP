/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.catalogos;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.framework.visitor.Visitor;

/**
 *
 * @author lucas
 */
public class CatalogoPrinter implements Visitor<Catalogo>{
    
    public void visit(final Catalogo visitee) {
         System.out.printf("ID Catalogo: %-10s Titulo catalogo: %-30s", visitee.identiticadorCatalogo().toString(), visitee.name().toString());
    }
    
}
