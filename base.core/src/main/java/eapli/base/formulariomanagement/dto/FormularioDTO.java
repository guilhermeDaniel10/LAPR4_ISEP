/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.formulariomanagement.dto;

import eapli.base.formulariomanagement.domain.Atributo;
import eapli.framework.representations.dto.DTO;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Guilherme
 */
@SuppressWarnings("squid:ClassVariableVisibilityCheck")
@DTO
public class FormularioDTO {

    public FormularioDTO(final String nomeFormulario, final Set<Atributo> atributos) {
        this.nomeFormulario = nomeFormulario;
        this.atributos = atributos;
    }

    public FormularioDTO() {

    }

    public String nomeFormulario;
    public Set<Atributo> atributos;

}
