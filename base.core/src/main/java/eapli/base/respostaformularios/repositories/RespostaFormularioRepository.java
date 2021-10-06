/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.respostaformularios.repositories;

import eapli.base.respostaformularios.domain.RespostaFormulario;
import eapli.framework.domain.repositories.DomainRepository;

/**
 *
 * @author Guilherme
 */
public interface RespostaFormularioRepository extends DomainRepository<Long, RespostaFormulario> {
    
    public RespostaFormulario findRespostaFormularioById(Long id);
    
    public RespostaFormulario findRespostaFormularioByNomeForm(String nome);

}
