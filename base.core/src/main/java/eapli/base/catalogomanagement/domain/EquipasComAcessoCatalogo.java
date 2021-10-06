/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.catalogomanagement.domain;

import eapli.base.equipamanagement.domain.Equipa;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 *
 * @author lucas
 */
@Embeddable
public class EquipasComAcessoCatalogo implements ValueObject {
    
    @ManyToOne(optional = true)
    private final Equipa equipaComAcesso;
    
    @Column(nullable = true)
    private final String description;

    protected EquipasComAcessoCatalogo() {
        // for ORM only
        equipaComAcesso = null;
        description = null;
    }
    
    public EquipasComAcessoCatalogo(final Equipa equipaComAcesso) {
        Preconditions.nonNull(equipaComAcesso);
        this.equipaComAcesso = equipaComAcesso;
        this.description = equipaComAcesso.acronimoEquipa().toString();
    }

    public Equipa equipa() {
        return equipaComAcesso;
    }

    public Optional<String> description() {
        return Optional.ofNullable(description);
    }
    
}
