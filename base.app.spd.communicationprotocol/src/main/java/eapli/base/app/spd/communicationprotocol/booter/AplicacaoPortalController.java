/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.spd.communicationprotocol.booter;

import eapli.base.app.spd.communicationprotocol.AplicacaoPortalUtilizadores;
import eapli.base.colaboradormanagement.application.RegistarColaboradorController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guilherme
 */
public class AplicacaoPortalController {
    
    private RegistarColaboradorController colabController = new RegistarColaboradorController();
    AplicacaoPortalUtilizadores apu = new AplicacaoPortalUtilizadores(colabController.currentColaborador().numeroMecanografico().numeroAsUsername());
    
    public void startConnection(){
        try{
        apu.sendFirstMessage();
        }catch(NullPointerException e){
            System.out.println("Sem servidor de motor de fluxos.");
        }
    }
    
    public void stopConnection(){
        apu.stopConnection();
    }
    
    
    
}
