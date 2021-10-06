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
public class EtiquetaAtributo implements ValueObject{
    private final int NUMERO_MAXIMO_CARACTERES = 25;
    
    private String etiquetaFormulario;
    
    protected EtiquetaAtributo(){
        
    }
    
    public EtiquetaAtributo(String etiqueta){
        if(StringPredicates.isNullOrEmpty(etiqueta)){
            throw new IllegalArgumentException("Etiqueta do formulário não pode ser vazia ou null");
        }
        if(etiqueta.length() > NUMERO_MAXIMO_CARACTERES){
            throw new IllegalArgumentException("Excedeu o número permitido de caracteres da etiqueta.");
        }
        
        this.etiquetaFormulario = etiqueta;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.etiquetaFormulario);
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
        final EtiquetaAtributo other = (EtiquetaAtributo) obj;
        if (!Objects.equals(this.etiquetaFormulario, other.etiquetaFormulario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Etiqueta do formulário: " + etiquetaFormulario;
    }
    
    public String etiqueta(){
        return this.etiquetaFormulario;
    }
    
}
