/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.spd.communicationprotocol;
 
 
 
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.pedidomanagement.application.ListPedidoManualController;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.servicomanagement.application.ListServicosRH;
import eapli.base.tarefamanagement.application.AtribuirTarefaAColaboradorController;
import eapli.base.tarefamanagement.application.ListTarefasController;
import eapli.base.tarefamanagement.domain.Tarefa;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
 
/**
 *
 * @author Guilherme
 */
public class MotorAsServer implements Runnable {
 
    static private final String BASE_FOLDER = "www";
    static final String TRUSTED_STORE="server_J.jks";   
    static final String KEYSTORE_PASS="forgotten";
    private static SSLServerSocket sock;
    private static HashMap<SSLSocket, DataOutputStream> cliList = new HashMap<>();
    private static List<SSLSocket> openedSockets = new ArrayList<>();
    private static ListTarefasController tarefasController;
    private static ListServicosRH servicoController = new ListServicosRH();
    private static ListPedidoManualController manualController = new ListPedidoManualController();
    private static AtribuirTarefaAColaboradorController atribuirController = new AtribuirTarefaAColaboradorController();
    private String version;
    private InputStream inputStream;
    private static final String versionOne = "First_Come_First_Served";
    private static final String versionTwo = "Algoritmo_Inteligente";
    private String tipoAssignacao;
    private ConcurrentHashMap<Equipa, ConcurrentLinkedQueue<Colaborador>> safeMap;
    
 
    public MotorAsServer(int port, ListTarefasController listT) {
        safeMap = new ConcurrentHashMap<>();
        this.tarefasController = listT;
        
        // Trust these certificates provided by authorized clients
        System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.trustStorePassword",KEYSTORE_PASS);
  

        // Use this certificate and private key as server certificate
        System.setProperty("javax.net.ssl.keyStore",TRUSTED_STORE);
        System.setProperty("javax.net.ssl.keyStorePassword",KEYSTORE_PASS);
        
        SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try {
            sock = (SSLServerSocket) sslF.createServerSocket(port);
            sock.setNeedClientAuth(true);
        } catch (IOException ex) {
            Logger.getLogger(MotorAsServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        getPropValues();
        
        if(tipoAssignacao.equals("Sim")){
            fillMapEquipaColaboradores();
            Thread t = new AssignarTarefasManuaisAColaboradores(version, safeMap);
            t.start();
        }
        
        
    }
    
    public void getPropValues() {
        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            
            tipoAssignacao = prop.getProperty("autoAssignacao");
            if(tipoAssignacao.equals("Sim")){
                version = prop.getProperty("algoAssignacao");
                System.out.println("The algorithm being used is " + version);
            }          

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(MotorAsClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 
 
 
     public static synchronized void sendToAll(int len, byte[] data, SSLSocket myS/*Socket myS*/, String read) throws Exception {
         String idColab = read;
        for (DataOutputStream cOut : cliList.values()) {
 
            byte[] dataB = data;
            int interpreter = interpretateCode(data);
            switch (interpreter) {
                case 0:
                    len = 2;
                    data[0] = '0';
                    data[1] = '2';
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
                    remCli(myS);
                    break;
 
                case 3:
                    byte[] toHtml = processTarefasInformation(idColab);
                    boolean done = false;
                    int index = 0;
                    int it = 0;
                    int dataLeft = toHtml.length;
                    int messageSize = 0;

                    while(!done){
                        if(dataLeft > 252){
                            messageSize = 255;
                        }else{
                            messageSize = dataLeft+3;
                        }
                        data = new byte[messageSize];
                        data[0] = '0';
                        if(dataLeft > 252){
                            data[1] = '5';  //Avisar o cliente do envio de uma mensagem superior a 255 bytes
                        
                        } else {
                        data[1] = '4';
                        }
                        
                        data[2] = (byte) messageSize;
                
                        for(int k = index; k < (messageSize-3 + index); k++){
                            data[k + 3 - index] = toHtml[k];
                        }
                        
                        index += + (messageSize-3);
                        dataLeft -= (messageSize-3);
                        len = data.length;
                        
                        cOut.write(len);
                        cOut.write(data, 0, len);
 
                        it++;

                        if(dataLeft == 0){
                            done = true;
                        }
                    }
                    remCli(myS);
                    break;
 
                case 6:
                    byte[] toHtml2 = processarTarefasForGestorInformation();
                    data = new byte[toHtml2.length + 3] ;
                    data[0] = '0';
                    data[1] = '4';
 
                    data[2] = (byte) toHtml2.length;
 
                    for(int k = 0; k < toHtml2.length; k++){
                        data[k + 3] = toHtml2[k];
 
                    }
 
                    len = data.length;
 
                    cOut.write(len);
                    cOut.write(data, 0, len);
 
                    remCli(myS);
 
                    break;

                default:

                    break;
            }
        }
    }
 
     public static byte[] processarTarefasForGestorInformation(){
         int numAutomaticas = tarefasController.allTarefasAutomaticas();
         int numPendentes = tarefasController.allTarefasPendentes();
         int numTarefas = tarefasController.allTarefas();
         int numServicos = servicoController.allNumeroServicos();
 
         String ret = String.format("<h2>\n Tarefas Automaticas: %d\n </h2>\n <h2>\n Tarefas Pendentes: %d\n </h2>\n <h2>\n Total de Tarefas: %d\n </h2>\n <h2>\n Total de Servicos: %d\n </h2>", numAutomaticas, numPendentes, numTarefas, numServicos);
         String prologo = "", epilogo = "", center = "";
         String allHtml = ret + prologo + center + epilogo;
         byte[] retByte = new byte[allHtml.length()];
 
         for (int i = 0; i < allHtml.length(); i++) {
             retByte[i] = (byte) allHtml.charAt(i);
         }
 
         return retByte;
     }
 
      public static byte[] processTarefasInformation(String colabId){
 
        int numPendentes = tarefasController.numeroTarefasPendentesColaborador(colabId);
 
        int numNaoConluidas = tarefasController.numeroTarefasNaoConcluidas(colabId);
        int numBreve = tarefasController.numeroTarefasTerminamEmBreve(colabId);
        Iterable<Tarefa> tarefas = tarefasController.tarefasDoColaboradorPorPrioridadeECriticadade(colabId);
 
        String ret = String.format("<h2>\n Tarefas Pendentes: %d\n </h2>\n <h2>\n Tarefas que Terminam em Breve: %d\n </h2>\n <h2>\n Tarefa Expiradas: %d\n </h2>", numPendentes, numBreve, numNaoConluidas);
        String prologo = "", epilogo = "", center = "";
        
        
        if(numPendentes != 0){
   
                prologo = "<table class='table'>\n" +
                    "<thead>\n" +
                        "<tr style = \"text-align:center;font-family:georgia,garamond,serif;font-size:30px;\" bgcolor='#A9D4F0'>\n" +
                            "<th>\n" +
                                "#\n" +
                            "</th>\n" +
                            "<th>\n" +
                                "ID Tarefa\n" +
                            "</th>\n" + 
                            "<th>\n" +
                                "Criticidade\n" +
                            "</th>\n" +
                            "<th>\n"+
                                "Urgencia\n" +
                            "</th>\n" +
                            "<th>\n"+
                                "Data limite de resolucao\n" +
                            "</th>\n" +
                        "</tr>\n" +
                    "</thead>\n" +
                        "<tbody style = \"text-align:center;font-family:georgia,garamond,serif;font-size:30px;\">";
                
                Date now = new Date();
        
                int index =0;
                for(Tarefa t : tarefas){
                    String idTarefa = t.identity().toString();
                    int criticidade = t.pedido().criticidadePedido().simpleCriticidadeInt();
                    int prioridade = t.pedido().urgenciaDoPedido();
                    Date dataLimite = t.pedido().dataLimitePedido().dataLimiteAsData();
                    long sub = (t.pedido().dataLimitePedido().dataLimiteAsData().getTime() - now.getTime())/1000;
                    String dataLimiteStr = dataLimite.toString();
                    
                    index++;
                    if(t.pedido().dataLimitePedido().dataLimiteAsData().before(now)){
                    center += String.format("<tr bgcolor='#FF0000'>\n<td>\n%d\n</td>\n<td>%s\n</td>\n<td>\n%d\n</td>\n<td>\n%d\n</td>\n<td>\n%s\n</td>\n</tr>", index, idTarefa, criticidade, prioridade, dataLimiteStr);
                    }
                    else if(sub <= 3600 && sub > 0){
                        center += String.format("<tr bgcolor='#FFFF00'>\n<td>\n%d\n</td>\n<td>%s\n</td>\n<td>\n%d\n</td>\n<td>\n%d\n</td>\n<td>\n%s\n</td>\n</tr>", index, idTarefa, criticidade, prioridade, dataLimiteStr);
                    } else {
                        center += String.format("<tr bgcolor='#008000'>\n<td>\n%d\n</td>\n<td>%s\n</td>\n<td>\n%d\n</td>\n<td>\n%d\n</td>\n<td>\n%s\n</td>\n</tr>", index, idTarefa, criticidade, prioridade, dataLimiteStr);
                    }
                }
            epilogo = "</tbody>\n</table>";
        }                                 
            String allHtml = ret + prologo + center + epilogo;
            byte[] retByte = new byte[allHtml.length()];

        for(int i = 0; i < allHtml.length(); i++){
            retByte[i] = (byte) allHtml.charAt(i);
        }

        return retByte;
    }
 
 
    public static int interpretateCode(byte[] data) throws Exception {
        if (data[1] == '0') {
            return 0;
        }
        if (data[1] == '1') {
            return 1;
        }
 
        if (data[1] == '3') {
            return 3;
        }
 
        if(data[1] == '6'){
            return 6;
        }
 
        return 2;
    }
 
    public static synchronized void addCli(SSLSocket s /*Socket s*/) throws Exception {
        cliList.put(s, new DataOutputStream(s.getOutputStream()));
    }
 
    public static synchronized void remCli(SSLSocket s/*Socket s*/) throws Exception {
        cliList.get(s).write(0);
        cliList.remove(s);
        s.close();
    }
 
    public static void receiveFirstMessageForBrowser() {
        InetAddress ip;
        String hostname;
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            System.out.println("Current IP address : " + ip);
            System.out.println("Current Hostname : " + hostname);
        } catch (UnknownHostException e) {
 
        }
 
 
        while (true) {
            System.setProperty("javax.net.ssl.trustStore", "client3_J.jks");
            System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

            //Use this certificate and private key for client certificate when requested by the server
            System.setProperty("javax.net.ssl.keyStore", "client1_3.jks");
            System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

            SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket s;
            try { 
                s = (SSLSocket) sock.accept();
                addCli(s);
                Thread cli = new ExecutorMensagensCliente(s);
                cli.start();
            } catch (IOException ex) {
                Logger.getLogger(MotorAsServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(MotorAsServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 
    @Override
    public void run() {
        receiveFirstMessageForBrowser();
    }
 
 
    public static void closeOpenedSocketsOfApplication(){
        for(SSLSocket s : openedSockets){
            try{
            s.close();
            }catch(IOException e){
                System.out.println("Nao conseguiu fechar!");
            }
        }
    }
    
    public void fillMapEquipaColaboradores(){
        atribuirController.allEquipasColab(safeMap);
    }
 
 
 
static class ExecutorMensagensCliente extends Thread {

    private SSLSocket myS;
    private DataInputStream sIn;
    private byte currentVersion = '0';
 
    public ExecutorMensagensCliente(SSLSocket s) {
        myS = s;
    }
 
    public void run() {
        int nChars;
        byte[] data = new byte[300];
 
        try {
            sIn = new DataInputStream(myS.getInputStream());
            while (true) {
                nChars = sIn.read();
                sIn.read(data, 0, nChars);
 
 
                int ll = data[2];
                String read = "";
 
                for(int i = 3; i < ll + 3; i++){
                    read += (char)data[i];
 
                }
 
                if(data[1] == '1' || data[1] == '2' || data[1] == '3' || data[1] == '6'){
                    for(int l = 0; l < data.length; l++){
 
                    }
                MotorAsServer.sendToAll(nChars, data, myS, read);
                }
 
                TimeUnit.SECONDS.sleep(5);
                MotorAsServer.remCli(myS);
            }
 
 
        } 
        catch (SocketException ex) {
            System.out.println("Socket closed");
        } catch (Exception ex) {
 
        }
    }
 
    public boolean isVersionCorrect(byte read) {
        if (read != currentVersion) {
            return false;
        }
        return true;
    }
}

static class AssignarTarefasManuaisAColaboradores extends Thread{
    
    private String tipoAlgoritmo;
    private ConcurrentHashMap<Equipa, ConcurrentLinkedQueue<Colaborador>> safeMap;
    
    public AssignarTarefasManuaisAColaboradores(String tipoAlgoritmo, ConcurrentHashMap<Equipa, ConcurrentLinkedQueue<Colaborador>> safeMap){
        this.tipoAlgoritmo = tipoAlgoritmo;
        this.safeMap = safeMap;
    }
    public void run() {
        
        
            while (true) {
                
                try {
                    Iterable<Pedido> pedidos = manualController.pedidosParaExecucaoManual();
                    if(tipoAlgoritmo.equals("First_Come_First_Served")){
                    for(Pedido p : pedidos){

                        try{
                            Equipa equipa = p.servicoDoPedido().workflowServico().atividadeRealizacaoWorkflow().responsaveis();
                            
                            
                            if(equipa != null){
                                if(!safeMap.containsKey(equipa)){
                                atribuirController.addEquipaToMap(safeMap, equipa);
                            } else {
                                Iterable<Colaborador> colaboradoresDaEquipa = atribuirController.colaboradoresDeEquipa(equipa);
                                List<Colaborador> colabForSize = new ArrayList<>((Collection<? extends Colaborador>) colaboradoresDaEquipa);
                                if(safeMap.get(equipa).size() != colabForSize.size()){
                                    atribuirController.addUncommonColaborador(safeMap.get(equipa), colaboradoresDaEquipa);
                                }
                            }
                                
                                
                                Colaborador colab = safeMap.get(equipa).poll();
                                System.out.println("Tarefa atribuida a " + colab.numeroMecanografico().numeroAsUsername());
                                atribuirController.atribuirPedidoAColaborador(p, colab);
                                safeMap.get(equipa).add(colab);
                            }
                        } catch(NullPointerException ex){
                            Logger.getLogger(MotorAsServer.class.getName()).log(Level.SEVERE, null, ex);
                        }


                        }
                    } else if(tipoAlgoritmo.equals("Algoritmo_Inteligente")){
                        for(Pedido p : pedidos){
                            try{
                                
                                Colaborador colab = atribuirController.colaboradorComMenorTempoTotalExecucaoDeEquipa(p);
                                System.out.println("Tarefa atribuida a " + colab.numeroMecanografico().numeroAsUsername());
                                atribuirController.atribuirPedidoAColaborador(p, colab);
                                
                            } catch(NullPointerException ex){
                            Logger.getLogger(MotorAsServer.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MotorAsServer.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
          }
    
    
       
    }


}