/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.tipoequipa;

import eapli.base.tipoequipamanagement.domain.TipoEquipa;
import eapli.framework.visitor.Visitor;

/**
 *
 * @author Guilherme
 */
public class TipoEquipaPrinter implements Visitor<TipoEquipa>{

    @Override
    public void visit(TipoEquipa visitee) {
        System.out.printf("ID tipo equipa: %-10s Descricao Equipa:%-30s", visitee.identity(), visitee.descricaoTpEquipa());
    }
    
}
