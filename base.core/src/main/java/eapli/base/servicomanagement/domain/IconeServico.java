/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.servicomanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import javax.persistence.Transient;

/**
 *
 * @author lucas
 */
@Embeddable
public class IconeServico implements ValueObject {
    
    @Lob
    @Column(name="ICONE")
    private byte[] imageServico;
    
    @Transient
    private String iconeName;
    
    @Transient
    private String extensaoIcone;
    
    @Transient
    private final String locationPorDefault = "image_demo/default.png";
     
    @Transient
    private final String preLocation = "image_demo/";
    
    @Transient
    private boolean imageByDefault = false;
    
    public IconeServico(String iconeName, String extensaoIcone) throws IOException{
        this.extensaoIcone = extensaoIcone;
        this.iconeName = iconeName;
        
        this.imageServico = fileConverter();
    }
    
    public IconeServico() {
        //ORM
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IconeServico)) {
            return false;
        }

        final IconeServico that = (IconeServico) o;
        return this.extensaoIcone.equals(that.extensaoIcone)
                && this.iconeName.equals(that.iconeName);
    }
    
    public void correcaoIcone(String iconeName, String extensaoIcone) throws IOException{
       this.extensaoIcone = extensaoIcone;
       this.iconeName = iconeName;

       this.imageServico = fileConverter();
    }

    public boolean iconeValido() {
       return this.imageByDefault;
    }
    
    public void resetIconeEstado(){
        this.imageByDefault = false;
    }
    
    @Override
    public String toString() {
        return "\nIcone ->" + Arrays.toString(this.imageServico);
    }
    
    private byte[] fileConverter() throws FileNotFoundException, IOException {

        FileInputStream fileInputStream = null;
        
        String path = this.preLocation + this.iconeName + "." + this.extensaoIcone;          
        
        try {
            
            File file = new File(path);
            byte[] picInBytes = new byte[(int) file.length()];
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(picInBytes);
            fileInputStream.close();
        
            return picInBytes;
        
        } catch (IOException ex) {
            
            File fileDefault = new File(locationPorDefault);
            byte[] picInBytesDefault = new byte[(int) fileDefault.length()];
            fileInputStream = new FileInputStream(fileDefault);
            fileInputStream.read(picInBytesDefault);
            fileInputStream.close();
            this.imageByDefault = true;
            
            return picInBytesDefault;
        }    
    }
    
}
