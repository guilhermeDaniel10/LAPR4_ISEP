/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.scriptmanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.scriptmanagement.domain.Script;
import eapli.base.scriptmanagement.repositories.ScriptRepository;

/**
 *
 * @author Guilherme
 */
public class RegistarScriptController {

    private ScriptRepository scriptRepo = PersistenceContext.repositories().script();

    public Script registarScript(String scriptName, String scriptExtension) {
        Script script = new Script(scriptName, scriptExtension);
        return scriptRepo.save(script);
    }

}
