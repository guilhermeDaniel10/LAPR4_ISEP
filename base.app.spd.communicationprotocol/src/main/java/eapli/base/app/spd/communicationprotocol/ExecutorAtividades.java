/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.spd.communicationprotocol;

import eapli.base.tarefasautomaticas.TarefasAutomaticasExecutor;
import eapli.framework.io.util.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

/**
 *
 * @author Guilherme
 */
public class ExecutorAtividades {

    private static HashMap<Socket, DataOutputStream> cliList = new HashMap<>();
    
    static final String TRUSTED_STORE="server_J.jks";   
    static final String KEYSTORE_PASS="forgotten";
    static final int SERVER_PORT =32511;

    public static synchronized void enviarParaCliente(int len, byte[] data, Socket myS) throws Exception {
        for (DataOutputStream cOut : cliList.values()) {
            byte[] dataB = data;
            int interpreter = interpretarCodigo(data);
            switch (interpreter) {
                case 0:
                    len = 2;
                    data[0] = '0';
                    data[1] = '3';
                    int a = (int) dataB[2];
                    len = 3;
                    data[2] = (byte)(char) a;
                    for(int k = 3; k < (int)dataB[2] + 3; k++){
                        data[k] = dataB[k];
                        len++;
                    }
                    
                    
                    cOut.write(len);
                    cOut.write(data, 0, len);
                    System.out.println("Tarefa bem executada.");
                    break;
                case 1:
                    System.out.println("A quebrar ligacao TCP.");
                    len = 2;
                    data[0] = '0';
                    data[1] = '2';
                    cOut.write(len);
                    cOut.write(data, 0, len);
                    removerCliente(myS);
                    break;
                default:
                    cOut.write(len);
                    cOut.write(data, 0, len);
                    break;
            }
        }
    }

    public static int interpretarCodigo(byte[] data) throws Exception {
        if (data[1] == '0') {
            return 0;
        }
        if (data[1] == '1') {
            return 1;
        }

        return 2;

    }

    public static synchronized void adicionarCliente(Socket s) throws Exception {
        cliList.put(s, new DataOutputStream(s.getOutputStream()));
    }

    public static synchronized void removerCliente(Socket s) throws Exception {
        cliList.get(s).write(0);
        cliList.remove(s);
        s.close();
    }

    private static SSLServerSocket sock=null;
    
    

    public static void main(String args[]) throws Exception {
        int i, porta;
        
        porta = decidirExecucao();
        InetAddress ip;
        String hostname;
        
        // Trust these certificates provided by authorized clients
        System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.trustStorePassword",KEYSTORE_PASS);
  

        // Use this certificate and private key as server certificate
        System.setProperty("javax.net.ssl.keyStore",TRUSTED_STORE);
        System.setProperty("javax.net.ssl.keyStorePassword",KEYSTORE_PASS);

        SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
                
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            System.out.println("Current IP address : " + ip);
            System.out.println("Current Hostname : " + hostname);
            System.out.println("Current Port : " + porta);
 
        } catch (UnknownHostException e) {
 
        }

        try {            
            sock = (SSLServerSocket) sslF.createServerSocket(porta);
            
            sock.setNeedClientAuth(true);

        } catch (IOException ex) {
            Logger.getLogger(ExecutorAtividades.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Local port number not available.");
            System.exit(1);
        }

        while (true) {
            Socket s = sock.accept();
            adicionarCliente(s);
            Thread cli = new ExecutorAtividadesTcpSrvCli(s);
            cli.start();
        }
    }
    
      public static int decidirExecucao(){
        int portToExecute = 0;
        int op = -1;
        Scanner ler = new Scanner(System.in);
        do{       
        op = Console.readInteger("Correr nos servidores ou localmente:\n1: Servidores\n2: Localmente");
        } while(op != 1 && op != 2);
        
        if(op == 2){
            portToExecute = Console.readInteger("Porta para executar:");
            return portToExecute;
        } else if (op == 1){
            portToExecute = Console.readInteger("Porta para executar:");
            return portToExecute;
        } 
        return 0;
        
    }

}

 class ExecutorAtividadesTcpSrvCli extends Thread {

    private Socket myS;
    private DataInputStream sIn;
    private byte currentVersion = '0';

    public ExecutorAtividadesTcpSrvCli(Socket s) {
        myS = s;
    }

    public void run() {
        int nChars;
        byte[] data = new byte[300];
        


        try {
            sIn = new DataInputStream(myS.getInputStream());
            while (true) {
                long startTime = System.currentTimeMillis();
                data = new byte[300];
                nChars = sIn.read();
                if (nChars == 0) {
                    break; 
                }
                sIn.read(data, 0, nChars);

                int ll = data[2];
                String read = "";
                 int countResposta = 3;
                String identificador = "";
                boolean flagId = false;
                
                if(data[1] == '1'){
                    ExecutorAtividades.enviarParaCliente(nChars, data, myS);
                    break;
                }
                
                for(int i = 3; i < ll + 3; i++){
                    if(flagId == true){
                        
                        identificador += (char)data[i];
                        countResposta++;
                    }
                    if((char)data[i] == '#'){
                        flagId = true;
                    }
                    
                    if(flagId == false){
                        read += (char)data[i];
                    }
                    
                    
                }
                System.out.println("Tarefa " + identificador + " a ser executada.");
                
                if (!verificarVersao(data[0])) {
                    System.out.println("\nVersao do cliente incorreta. Por favor alterar e voltar a correr.");
                    ExecutorAtividades.removerCliente(myS);
                }
                int randomNum = ThreadLocalRandom.current().nextInt(3, 9 + 1);
                TimeUnit.SECONDS.sleep(randomNum);
                TarefasAutomaticasExecutor executor = new TarefasAutomaticasExecutor();
                executor.executarScriptAutomatico(read);
                
                
                ExecutorAtividades.enviarParaCliente(nChars, data, myS);
                
                long stopTime = System.currentTimeMillis();
                float dif = (stopTime - startTime)/1000F;
                
                System.out.println("A tarefa demorou " + dif + " segundos a ser concluida.");
               
 
            }

            
        } catch (Exception ex) {
            //Logger.getLogger(ExecutorAtividades.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Execucao mal executada. Tarefa retornou para a fila de execucao.");
        }
    }

  
    public boolean verificarVersao(byte read) {
        if (read != currentVersion) {
            return false;
        }
        return true;
    }
}