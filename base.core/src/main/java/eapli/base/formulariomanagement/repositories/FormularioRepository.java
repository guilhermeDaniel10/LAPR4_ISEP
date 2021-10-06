/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.formulariomanagement.repositories;

import eapli.base.formulariomanagement.domain.Formulario;
import eapli.framework.domain.repositories.DomainRepository;

/**
 *
 * @author lucas
 */
public interface FormularioRepository  extends DomainRepository<Long,Formulario> {
    
    public Formulario findFormularioByNome(String strFomularioServico);

}
