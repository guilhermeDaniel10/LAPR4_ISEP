/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.spd.communicationprotocol.booter;

import eapli.base.app.spd.communicationprotocol.AplicacaoPortalUtilizadores;
import eapli.base.app.spd.communicationprotocol.AplicacaoServicosRH;
import eapli.base.colaboradormanagement.application.RegistarColaboradorController;

/**
 *
 * @author Guilherme
 */
public class AplicacaoServicosController {
    AplicacaoServicosRH apu = new AplicacaoServicosRH();
    
    public void startConnection(){
        try{
        apu.sendFirstMessageAppServ();
        }catch(NullPointerException e){
            System.out.println("Sem servidor de motor de fluxos.");
        }
    }
    
    public void stopConnection(){
        apu.stopConnection();
    }
}
