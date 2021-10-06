/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.inmemory;

import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.repositories.FormularioRepository;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

/**
 *
 * @author lucas
 */
public class InMemoryFormularioRepository extends InMemoryDomainRepository<Formulario, Long> implements FormularioRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Formulario findFormularioByNome(String strFomularioServico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
