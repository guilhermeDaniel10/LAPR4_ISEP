/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.spd.communicationprotocol;

//import eapli.base.tarefamanagement.domain.Tarefa;
//import eapli.base.tarefamanagement.repositories.TarefaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefamanagement.application.ListTarefasController;
import eapli.base.tarefamanagement.application.TarefasAutomaticasController;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.repositories.TarefaRepository;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.io.util.Console;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
//import javax.persistence.PersistenceContext;

/**
 *
 * @author Guilherme
 */
public class MotorFluxoAtividades {

    static boolean localmente;

    public static void main(String[] args) {
        int porta = decidirExecucao();
        
        Semaphore whoCanAccess = new Semaphore(1);

        ListTarefasController tarefasController = new ListTarefasController();

        MotorAsClient motorC = new MotorAsClient(tarefasController, localmente);
   
        // ALTERAR AQUI!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        MotorAsServer motorS = new MotorAsServer(porta, tarefasController);
        //MotorAsServer motorS = new MotorAsServer(32507);

        Thread s = new Thread(motorS);
        s.start();

        Thread c = new Thread(motorC);
        c.start();
    }

    public static int decidirExecucao() {
        int op = -1;
        do {
            op = Console.readInteger("Correr nos servidores ou localmente:\n1: Servidores\n2: Localmente");
        } while (op != 1 && op != 2);
        System.out.println("SELECIONADO " + op);
        if (op == 2) {
            localmente = true;

            return 32508;
        } else {

            localmente = false;
            return 32510;
        }
    }
}
