/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.catalogomanagemente.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Guilherme
 */
public class ImageController {

    public byte[] fileConverter(String fileName, String extensionFile) throws FileNotFoundException, IOException {

        FileInputStream fileInputStream = null;
        String locationPorDefault = "image_demo/default.png";
       
            String preLocation = "image_demo/";
            String path = preLocation + fileName + "." + "extensionFile";          
        
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
            
            return picInBytesDefault;
        }
            
        
    }

}
