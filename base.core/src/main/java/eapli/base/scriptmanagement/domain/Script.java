/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.scriptmanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.strings.util.StringPredicates;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author Guilherme
 */
@Entity
public class Script implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idScript;

    private String scriptName;

    private String scriptExtension;

    private String scriptContent;

    @Transient
    private final String preLocation = "scripts/";

    public Script() {
        //ORM
    }

    public Script(String scriptName, String scriptExtension) {
        if (StringPredicates.isNullOrEmpty(scriptExtension)) {
            throw new IllegalArgumentException("A extensao do script nao pode ser null ou vazios!");
        }
        if (StringPredicates.isNullOrEmpty(scriptName)) {
            throw new IllegalArgumentException("O script nao pode ser null ou vazios!");
        }
        if (!StringPredicates.isSingleWord(scriptName)) {
            throw new IllegalArgumentException("O script tem de ser uma palavra unica!");
        }
        this.scriptName = scriptName;
        this.scriptExtension = scriptExtension;
        converterScriptDeFicheiro();
    }

    public String scriptForExecution() {
        return scriptName + "." + scriptExtension;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Script)) {
            return false;
        }

        final Script that = (Script) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity())
                && this.scriptName.equals(that.scriptName)
                && this.scriptExtension.equals(that.scriptExtension);
    }

    @Override
    public Long identity() {
        return this.idScript;
    }

    public String scriptName() {
        return this.scriptName;
    }

    public String scriptExtension() {
        return this.scriptExtension;
    }

    public final void converterScriptDeFicheiro() {

        String path = this.preLocation + this.scriptName + "." + this.scriptExtension;

        try {

            File file = new File(path);

            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                scriptContent += "\n" + data;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Script nao encontrado.");

        }

    }

    public String conteudoFicheiro() {
        return this.scriptContent;
    }

}
