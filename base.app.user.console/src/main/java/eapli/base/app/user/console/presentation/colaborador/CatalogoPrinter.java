/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.user.console.presentation.colaborador;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.framework.visitor.Visitor;

/**
 *
 * @author Guilherme
 */
public class CatalogoPrinter implements Visitor<Catalogo>  {

    @Override
    public void visit(Catalogo visitee) {
        System.out.printf("%-10s %-30s", visitee.identiticadorCatalogo().toString(), visitee.name().toString());
    }
    
}
