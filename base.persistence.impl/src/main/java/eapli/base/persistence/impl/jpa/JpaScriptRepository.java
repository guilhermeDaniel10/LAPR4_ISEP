/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.scriptmanagement.domain.Script;
import eapli.base.scriptmanagement.repositories.ScriptRepository;

/**
 *
 * @author Guilherme
 */
public class JpaScriptRepository extends BasepaRepositoryBase<Script, Long, Long> implements ScriptRepository  {
    
      JpaScriptRepository() {
        super("idScript");
    }

}
