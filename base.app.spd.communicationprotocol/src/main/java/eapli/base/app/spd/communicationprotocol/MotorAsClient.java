/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.spd.communicationprotocol;

import eapli.base.tarefamanagement.application.ListTarefasController;
import eapli.base.tarefamanagement.application.TarefasAutomaticasController;
import eapli.base.tarefamanagement.domain.Tarefa;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/**
 *
 * @author Guilherme
 */
public class MotorAsClient implements Runnable {

    private boolean localmente;
    // @TODO alterar a porta para a execucao no putty
    static final int SERVER_PORT = 32510;

    static final String KEYSTORE_PASS = "forgotten";
    static InetAddress serverIP;

    //TODO: Alternar de testagem local para servidor
    private String host = "10.8.0.82";
    private String host2 = "10.8.0.83";
    private String host3 = "10.8.0.84";
    private String host4 = "10.8.0.85";
    //private int portNumber = 32507;

    //TESTAGEM LOCAL
    private int portNumberForTest = 32509;
    private SSLSocket sock = null;
    private static final int numeroServidores = 4;
    private SSLSocket[] sockets = new SSLSocket[numeroServidores];
    private DataOutputStream[] outputStreams = new DataOutputStream[2];
    private Socket sock2 = null;
    AtomicInteger atomic = new AtomicInteger();
    private ListTarefasController tarefasController;
    private TarefasAutomaticasController tarefasAutoController = new TarefasAutomaticasController();
    private Semaphore sem1 = new Semaphore(1);
    private Semaphore sem2 = new Semaphore(1);
    private Semaphore sem3 = new Semaphore(1);
    private Semaphore sem4 = new Semaphore(1);
    
    
    //----------------------------------------------
    private Semaphore semLeitura;
    private Semaphore semEscrita;

    private Semaphore currentSem;

    private ConcurrentHashMap<Integer, Queue<Long>> safeMap;

    //ALGO VERSION
    private String version;
    private InputStream inputStream;
    private static final String versionOne = "First_Come_First_Served";
    private static final String versionTwo = "Algoritmo_Inteligente";

    MotorAsClient(ListTarefasController tarefasController, boolean localmente) {
        this.tarefasController = tarefasController;
        this.safeMap = new ConcurrentHashMap<>();
        this.localmente = localmente;
        getPropValues();
        semLeitura = new Semaphore(1);
        semEscrita = new Semaphore(1);
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

            version = prop.getProperty("versionAlgo");
            System.out.println("The algorithm being used is " + version);

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

    @Override
    public void run() {
        byte[] data = new byte[300];

        String frase2 = null;
        Integer len = null;
        byte lenAsByte = 0;

        
        try {
            serverIP = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            System.out.println("Invalid server specified");
            System.exit(1);
        }

        runClient(sockets, frase2, len, lenAsByte, data);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream sOut = null;

    }

    public void runClient(Socket[] socksToRun, String frase2, Integer len, byte lenAsByte, byte[] data) {

        for (int i = 0; i < 4; i++) {
            safeMap.put(i, new ConcurrentLinkedQueue<>());
        }

        int k = 0;
        AtomicInteger atomicInt = new AtomicInteger();
        Semaphore sem = new Semaphore(1);
        while (true) {
            try {
                // read messages from the console and send them to the server
                semLeitura.acquire();
                Iterable<Tarefa> t = tarefasController.tarefasAutomaticasAvailableForExcecution();
                semLeitura.release();
                int counter = 0;

                for (Tarefa i : t) {
                    counter++;
                }
                int c2 = 0;
                for (Tarefa tt : t) {
                    if (c2 == counter) {
                        break;
                    }
          
                    
                    semEscrita.acquire();
                    tarefasAutoController.changeEstadoTarefaAutomatica("Submetido", String.valueOf(tt.identity()));
                    semEscrita.release();
                    
                    String scriptExecucao = tt.pedido().scriptResolucao();
                    frase2 = scriptExecucao + "#" + tt.identity();
                    System.out.println("Executar tarefa " + tt.identity() + " do servico " + tt.pedido().servicoDoPedido().identificadorServico());

                    byte[] data2 = frase2.getBytes();
                    len = data2.length;
                    lenAsByte = len.byteValue();
                    data = new byte[300];
                    data[0] = '0';
                    data[1] = '0';
                    data[2] = lenAsByte;

                    for (int j = 0; j < len; j++) {
                        data[j + 3] = (byte) frase2.charAt(j);
                        k++;
                    }
                    if (frase2 != null) {


                        if(version.equals(versionOne)){

                        }

                        switch (version) {
                            case versionOne:

                                if (atomicInt.get() == 4) {
                                    atomicInt = new AtomicInteger(0);
                                }

                                boolean connection = createConnection(atomicInt.get(), frase2, lenAsByte, data);
                                if (connection) {
                                    atomicInt.getAndIncrement();
                                }
                                break;
                            case versionTwo:

                                int posicao = posicaoComMenosCarga();
                                safeMap.get(posicao).add(tt.identity());
                                boolean connection2 = createConnection(posicao, frase2, lenAsByte, data);

                                break;
                        }

                    }

                    c2++;
                    TimeUnit.SECONDS.sleep(4);
      
                }
                TimeUnit.SECONDS.sleep(5);


            } catch (InterruptedException ex) {
                Logger.getLogger(MotorAsClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch(ConcurrentModificationException e){

            }
        }
    }

    public int posicaoComMenosCarga() {
        int position = 0;
        int tamanhoAtual;
        int menor = Integer.MAX_VALUE;
        for (Integer i : safeMap.keySet()) {
            tamanhoAtual = safeMap.get(i).size();
            if (tamanhoAtual < menor) {
                position = i;
                menor = tamanhoAtual;
            }
        }

        return position;
    }

    public boolean createConnection(int serverToConnect, String scriptParaExecucao, byte lenAsByte, byte[] data) {
        boolean rightConnection = true;

        SSLSocket socket = null;
        DataOutputStream sOut = null;

        try {

            socket = choseRightSocket(serverToConnect);
            System.out.println("SOCKET IP : " + socket.getInetAddress().getHostAddress());

            try {
                sOut = new DataOutputStream(socket.getOutputStream());

            } catch (IOException ex) {
                rightConnection = false;
                Logger.getLogger(MotorAsClient.class.getName()).log(Level.SEVERE, null, ex);
            }

            currentSem = whichSemToUse(socket);
            
            Thread serverThreads = new Thread(new RececaoServidor(socket, tarefasAutoController, sOut, safeMap, version, semEscrita, semLeitura, currentSem));
            serverThreads.start();
            
            
            sOut.write((byte) scriptParaExecucao.length() + 3);
            sOut.write(data, 0, (byte) scriptParaExecucao.length() + 3);
            

//            sock = (SSLSocket) sf.createSocket(serverIP, SERVER_PORT);
        } catch (IOException ex) {
            rightConnection = false;
            Logger.getLogger(MotorAsClient.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Failed to connect to server.");
        }
        return rightConnection;

    }

    public Semaphore whichSemToUse(SSLSocket sock) {

        if (localmente == true) {
            switch (sock.getPort()) {
                case 32509:

                    return sem1;

                case 32512:
                    return sem2;

                case 32513:
                    return sem3;
                case 32514:
                    return sem4;
                default:
                    break;
            }

        } else {
            if (sock.getInetAddress().getHostAddress().equals("10.8.0.82") && sock.getPort() == 32510) {
                return sem1;
            } else if (sock.getInetAddress().getHostAddress().equals("10.8.0.82") && sock.getPort() == 32511) {
            return sem3;
            } else if (sock.getInetAddress().getHostAddress().equals("10.8.0.83") && sock.getPort() == 32510) {
            return sem2;
            } else if (sock.getInetAddress().getHostAddress().equals("10.8.0.83") && sock.getPort() == 32511) {
            return sem4;
            }
        }
        return null;
    }

    public SSLSocket choseRightSocket(int serverToConnect) {
        try {
            SSLSocket socket = null;
            
           

            // Trust these certificates provided by servers
            System.setProperty("javax.net.ssl.trustStore", "client4_J.jks");
            System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

            // Use this certificate and private key for client certificate when requested by the server
            System.setProperty("javax.net.ssl.keyStore", "client4_J.jks");
            System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

            SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();

            switch (serverToConnect) {
                case 0:
                    
                    sem1.acquire();
                    if (localmente == true) {
                        
                        socket = (SSLSocket) sf.createSocket(serverIP, 32509);
                       
                    } else {
                        socket = (SSLSocket) sf.createSocket(host, SERVER_PORT);
                    }
                    break;
                case 1:
                    
                    sem2.acquire();
                    if (localmente == true) {
                        socket = (SSLSocket) sf.createSocket(serverIP, 32512);
                       
                    } else {
                        socket = (SSLSocket) sf.createSocket(host2, SERVER_PORT);
                    }
                    break;
                case 2:
                   
                    sem3.acquire();
                    if (localmente == true) {
                        socket = (SSLSocket) sf.createSocket(serverIP, 32513);
                        
                    } else {
                        socket = (SSLSocket) sf.createSocket(host, SERVER_PORT + 1);
                    }
                    break;
                case 3:
              
                    sem4.acquire();
                    if (localmente == true) {
                        socket = (SSLSocket) sf.createSocket(serverIP, 32514);
                       
                    } else {
                        socket = (SSLSocket) sf.createSocket(host2, SERVER_PORT + 1);
                    }
                    break;
            }

            checkCertificates(socket);
            socket.startHandshake();

            return socket;

        } catch (IOException ex) {
            Logger.getLogger(MotorAsClient.class
                    .getName()).log(Level.SEVERE, null, ex);

            return null;
        } catch (InterruptedException ex) {
            
        }
        return null;
    }

    public void checkCertificates(SSLSocket s) {
        try {
            SSLSession ssl = s.getSession();
//            @TODO Descomentar
            System.out.println("------------------------------------------------------");
            System.out.println("SSL/TLS version: " + ssl.getProtocol()
                    + "         Cypher suite: " + ssl.getCipherSuite());

            X509Certificate[] chain = (X509Certificate[]) ssl.getPeerCertificates();
            System.out.println("------------------------------------------------------");
            System.out.println("Certificate subject: " + chain[0].getSubjectDN());
            System.out.println("------------------------------------------------------");
            System.out.println("Certificate issuer: " + chain[0].getIssuerDN());
            System.out.println("------------------------------------------------------");
            System.out.println("Not before: " + chain[0].getNotBefore());
            System.out.println("------------------------------------------------------");
            System.out.println("Not after:  " + chain[0].getNotAfter());
            System.out.println("------------------------------------------------------");
        } catch (SSLException tlsE) {
            System.out.println(".................");
            System.out.println("SSL/TLS handshake has failed:\r\n");
            try {
                s.close();
            } catch (IOException ex2) {
                System.out.println("Error closing socket.");

            }
//            System.exit(1);
        }
    }

}

class RececaoServidor implements Runnable {

    private DataOutputStream outputStreams;
    private Socket s;
    private DataInputStream sIn;
    private TarefasAutomaticasController tarefasAutoController;
    private Semaphore sem;
    private ConcurrentHashMap<Integer, Queue<Long>> safeMap;
    private String version;
    private Semaphore currentSem;
    private Semaphore semLeitura;
    private Semaphore semEscrita;

    public RececaoServidor(Socket tcp_s, TarefasAutomaticasController automaticas, DataOutputStream outputStreams, ConcurrentHashMap<Integer, Queue<Long>> safeMap, 
            String version, Semaphore semEscrita, Semaphore semLeitura, Semaphore currentSem) {
        s = tcp_s;
        tarefasAutoController = automaticas;
        this.outputStreams = outputStreams;
        this.safeMap = safeMap;
        this.version = version;
        //this.currentSem = sem;
        this.semEscrita = semEscrita;
        this.semLeitura = semLeitura;
        this.currentSem = currentSem;
    }

    public void run() {
        int nChars;
        byte[] data = new byte[300];
        byte[] dataExit = new byte[300];
        dataExit[0] = '0';
        dataExit[1] = '1';
        String frase;
        String exit = "Bye Bye";
        AtomicInteger checkValue = new AtomicInteger(0);

        try {
            sIn = new DataInputStream(s.getInputStream());
            while (true) {
                nChars = sIn.read();

                int i = 0;

                if (nChars == 0) {
                    break;
                }
                sIn.read(data, 0, nChars);
                int lenString = data[2];

                String id = "";
                boolean cardinal = false;
                if (data[1] == '3') {
                    String s = "";
                    for (int k = 3; k < ((int) data[2]) + 3; k++) {
                        if (cardinal == true) {
                            id += (char) data[k];
                        }
                        if ((char) data[k] == '#') {
                            cardinal = true;
                        }
                        s += (char) data[k];
                    }
                
                    semLeitura.acquire();
                    semEscrita.acquire();
                    
                    tarefasAutoController.changeEstadoTarefaAutomatica("No_executor", id);
                    
                    System.out.println("A tarefa " + id + " foi executada com sucesso.\n");
                    if (version.equals("Algoritmo_Inteligente")) {
                        removeFromMapWithId(id);
                    }
                    semEscrita.release();
                    semLeitura.release();
                    //sem.release();
                    Integer len = dataExit.length;
                    dataExit[2] = len.byteValue();

                    for (int j = 0; j < exit.length(); j++) {

                        dataExit[j + 3] = (byte) exit.charAt(j);
                    }

                    this.outputStreams.write((byte) exit.length() + 3);
                    this.outputStreams.write(dataExit, 0, (byte) exit.length() + 3);

                    //this.s.close();
                    //Thread.sleep(1000);
                }
                if (data[1] == '2') {

                    this.s.close();
                    currentSem.release();
                    break;
                }

            }
        } catch (IOException ex) {
            System.out.println("Client disconnected.");
        } catch (InterruptedException ex) {
            Logger.getLogger(RececaoServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean removeFromMapWithId(String id) {
        Long idMap = Long.parseLong(id);
        int positionToRemove = -1;

        for (Integer i : safeMap.keySet()) {
            for (Long l : safeMap.get(i)) {
                if (l.equals(idMap)) {

                    positionToRemove = i;
                }
            }
        }

        if (positionToRemove != -1) {
            return safeMap.get(positionToRemove).remove(idMap);

        }
        return false;
    }
}
