/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.inmemory;

import eapli.base.respostaformularios.domain.RespostaFormulario;
import eapli.base.respostaformularios.repositories.RespostaFormularioRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

/**
 *
 * @author Guilherme
 */
public class InMemoryRespostaFormularioRepository extends InMemoryDomainRepository<RespostaFormulario, Long> implements RespostaFormularioRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public RespostaFormulario findRespostaFormularioById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RespostaFormulario findRespostaFormularioByNomeForm(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
