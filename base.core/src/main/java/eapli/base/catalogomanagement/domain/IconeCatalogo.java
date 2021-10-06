/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.catalogomanagement.domain;

import eapli.framework.domain.model.ValueObject;
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
public class IconeCatalogo  implements ValueObject {
    
    @Lob
    @Column(name="ICONE")
    private byte[] image;
    
    @Transient
    private String iconeNameCatalogo;
    
    @Transient
    private String extensaoIconeCatalogo;
    
    @Transient
    private final String locationPorDefaultCatalogo = "image_demo/default.png";
     
    @Transient
    private final String preLocationCatalogo = "image_demo/";
    
    @Transient
    private boolean imageByDefaultCatalogo = false;
    
    public IconeCatalogo(String iconeNameCatalogo, String extensaoIconeCatalogo) throws IOException{
        this.extensaoIconeCatalogo =extensaoIconeCatalogo;
        this.iconeNameCatalogo = iconeNameCatalogo;
        
        this.image = fileConverter();
    }
    
    public IconeCatalogo() {
        //ORM
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this);
    }
    
    public boolean sameImage(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IconeCatalogo)) {
            return false;
        }

        final IconeCatalogo that = (IconeCatalogo) o;
        return  this.extensaoIconeCatalogo.equals(that.extensaoIconeCatalogo)
                && this.iconeNameCatalogo.equals(that.iconeNameCatalogo);
    }
    
    public void correcaoIcone(String iconeNameCatalogo, String extensaoIconeCatalogo) throws IOException{
        this.extensaoIconeCatalogo =extensaoIconeCatalogo;
        this.iconeNameCatalogo = iconeNameCatalogo;
        
        this.image = fileConverter();
    }
    
    public boolean iconeValido() {
       return this.imageByDefaultCatalogo;
    }
    
    public void resetIconeEstado(){
        this.imageByDefaultCatalogo = false;
    }

    @Override
    public String toString() {
        return "\nIcone ->" + Arrays.toString(image);
    }
    
    private byte[] fileConverter() throws FileNotFoundException, IOException {

        FileInputStream fileInputStream = null;
        
        String path = this.preLocationCatalogo + this.iconeNameCatalogo + "." + this.extensaoIconeCatalogo;          
        
        try {
            
            File file = new File(path);
            byte[] picInBytes = new byte[(int) file.length()];
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(picInBytes);
            fileInputStream.close();
        
            return picInBytes;
        
        } catch (IOException ex) {
            
            File fileDefault = new File(this.locationPorDefaultCatalogo);
            byte[] picInBytesDefault = new byte[(int) fileDefault.length()];
            fileInputStream = new FileInputStream(fileDefault);
            fileInputStream.read(picInBytesDefault);
            fileInputStream.close();
            this.imageByDefaultCatalogo = true;
            
            return picInBytesDefault;
        }    
    }
 
}
