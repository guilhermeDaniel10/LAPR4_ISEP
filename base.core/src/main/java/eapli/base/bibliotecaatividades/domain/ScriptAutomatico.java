/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.bibliotecaatividades.domain;

import eapli.base.servicomanagement.domain.*;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;
import java.util.Scanner;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import javax.persistence.Transient;

/**
 *
 * @author lucas
 */
@Embeddable
public class ScriptAutomatico implements ValueObject {

    private String scriptContent;


    public ScriptAutomatico() {
        //ORM
    }

    public ScriptAutomatico(String content) {

//        converterScriptDeFicheiro();
        this.scriptContent = content;
    }



    public String conteudoFicheiro() {
        return this.scriptContent;
    }

}
