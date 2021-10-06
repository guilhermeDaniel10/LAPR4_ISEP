/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.formulariomanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author Guilherme
 */
@Embeddable
public class NomeFormulario implements ValueObject{
    
    private String nomeFormulario;
    
    protected NomeFormulario(){
        
    }
    
    public NomeFormulario(String nomeFormulario){
        if(StringPredicates.isNullOrEmpty(nomeFormulario)){
            throw new IllegalArgumentException();
        }
        this.nomeFormulario = nomeFormulario;
    }
    
     @Override
    public int hashCode() {
        return Objects.hash(this.nomeFormulario);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NomeFormulario other = (NomeFormulario) obj;
        if (!Objects.equals(this.nomeFormulario, other.nomeFormulario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nome do formulário: " + nomeFormulario;
    }
    
    public String nomeFormulario(){
        return this.nomeFormulario;
    }
    
}
