/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.equipamanagement.DTO;

import eapli.framework.representations.dto.DTO;

/**
 *
 * @author lucas
 */
@SuppressWarnings("squid:ClassVariableVisibilityCheck")
@DTO
public class EquipaDto {
    
    public EquipaDto(final String acrEquipa, final String designacaoEquipa) {
        this.acrEquipa = acrEquipa;
        this.designacaoEquipa = designacaoEquipa;
    }

    public EquipaDto() {

    }

    public String acrEquipa;
    public String designacaoEquipa;
    
}
