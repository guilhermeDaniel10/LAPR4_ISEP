/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.spd.communicationprotocol;

import static eapli.base.app.spd.communicationprotocol.AplicacaoPortalUtilizadores.KEYSTORE_PASS;
import static eapli.base.app.spd.communicationprotocol.AplicacaoServicosRH.sendFirstMessageAppServ;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/**
 *
 * @author Guilherme
 */
public class AplicacaoServicosRH extends Thread {

    String baseFolder;
    static SSLSocket sock;
    //static Socket sock;
    DataInputStream inS;
    DataOutputStream outS;
    static final String KEYSTORE_PASS = "forgotten";
    static List<Thread> threads = new ArrayList<>();
    private static volatile int atomic = 0;
    private static volatile int validateProtocol = 0;

    public AplicacaoServicosRH() {

    }

    public AplicacaoServicosRH(SSLSocket s/*Socket s*/, String f) {
        baseFolder = f;
        sock = s;
    }

    public void cleanThreads() {

    }

    public void stopConnection() {

        for (Thread t : threads) {
            t.interrupt();
        }

    }

    public static void sendFirstMessageAppServ() {

        System.setProperty("javax.net.ssl.trustStore", "client2_J.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

        // Use this certificate and private key for client certificate when requested by the server
        System.setProperty("javax.net.ssl.keyStore", "client2_J.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

        SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();

        try {
            // Correr Localmente para testagem
            //@TODO porta alterada
            //sock = (SSLSocket) sf.createSocket(InetAddress.getByName("10.8.0.81"), 32507);
            sock = (SSLSocket) sf.createSocket(InetAddress.getByName("10.8.0.81"), 32510);
            //sock = (SSLSocket) sf.createSocket(InetAddress.getLocalHost(), 32508);
        } catch (IOException ex) {
            //System.out.println("Failed to connect to server.");
            //System.exit(1);
        }

        try {
            if (validateProtocol == 0) {
            checkCertificates(sock);
            sock.startHandshake();
            validateProtocol++;
            }
            

        } catch (IOException ex) {
            Logger.getLogger(AplicacaoPortalUtilizadores.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro no handshake");
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream sOut = null;
        try {
            sOut = new DataOutputStream(sock.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(MotorAsClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        byte[] data = new byte[2000];

        Thread serverConn = new Thread(new RececaoMotorServidor(sock));
        serverConn.start();

        while (true) {
            threads.add(serverConn);

            data[0] = '0';
            data[1] = '6';

            try {
                sOut.write((byte) 2);
                sOut.write(data, 0, (byte) 2);
            } catch (IOException ex) {
                Logger.getLogger(AplicacaoServicosRH.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

        }

    }

    static class RececaoMotorServidor implements Runnable {

        private Socket s;
        private DataInputStream sIn;

        public RececaoMotorServidor(Socket tcp_s) {
            s = tcp_s;
            atomic++;
        }

        public void run() {
            int nChars;
            byte[] data = new byte[2000];
            String frase;

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(AplicacaoServicosRH.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                sIn = new DataInputStream(s.getInputStream());
                while (true) {

                    nChars = sIn.read();

                    int i = 0;

                    if (nChars == 0) {
                        break;
                    }
                    sIn.read(data, 0, nChars);
                    String sent = "";
                    for (int k = 3; k < data.length; k++) {

                        sent += Character.toString((char) data[k]);
                    }

                    if (data[1] == '4' && atomic == 1) {

                        HttpServerMotor.main(sent);

                        break;
                    }
                    if (data[1] == '4' && atomic > 1) {

                        HttpServerMotor.atualizarInformacaoTarefas(sent);

                        break;
                    }

                }
            } catch (IOException ex) {
                System.out.println("Client disconnected.");
            } catch (Exception ex) {
                Logger.getLogger(AplicacaoServicosRH.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void checkCertificates(SSLSocket sock) {
        try {
            SSLSession ssl = sock.getSession();
            System.out.println("=============================================================================");
            System.out.println("SSL/TLS version: " + ssl.getProtocol()
                    + "         Cypher suite: " + ssl.getCipherSuite());

            X509Certificate[] chain = (X509Certificate[]) ssl.getPeerCertificates();
            System.out.println("============================================================================");
            System.out.println("Certificate subject: " + chain[0].getSubjectDN());
            System.out.println("============================================================================");
            System.out.println("Certificate issuer: " + chain[0].getIssuerDN());
            System.out.println("============================================================================");
            System.out.println("Not before: " + chain[0].getNotBefore());
            System.out.println("============================================================================");
            System.out.println("Not after:  " + chain[0].getNotAfter());
            System.out.println("============================================================================\n");
        } catch (SSLException tlsE) {
            System.out.println("SSL/TLS handshake has failed:\r\n" + tlsE.getCause());
            try {
                sock.close();
            } catch (IOException ex2) {
                System.out.println("Error closing socket.");
            }
            System.exit(1);
        }
    }

}

class HttpServerMotor {

    static private final String BASE_FOLDER = "www";
    static private ServerSocket sock;
    static private int port = 32507;
    static AtomicInteger atomic = new AtomicInteger();
    static String argumento;

    public static void main(String arg) throws Exception {
        Socket cliSock;
        argumento = arg;
        try {
            sock = new ServerSocket(port);
        } catch (IOException ex) {
            System.out.println("Server failed to open local port " + port);
            System.exit(1);
        }
        while (true) {

            cliSock = sock.accept();
            HttpServicosRHRequest req = new HttpServicosRHRequest(cliSock, BASE_FOLDER);
            req.start();
            askForUpdateServ();

        }
    }

    // DATA ACCESSED BY THREADS - LOCKING REQUIRED
    private static final int candidatesNumber = 4;
    private static final String[] candidateName = new String[candidatesNumber];
    private static final int[] candidateVotes = new int[candidatesNumber];
    private static int accessesCounter;

    private static synchronized void incAccessesCounter() {
        accessesCounter++;
    }

    public static synchronized void atualizarInformacaoTarefas(String args) {

        argumento = args;
    }

    public static void askForUpdateServ() {
        sendFirstMessageAppServ();
    }

    public static synchronized String getVotesStandingInHTML2() {

        return argumento;
    }

    public static synchronized void castVote(String i) {
        int cN;
        try {
            cN = Integer.parseInt(i);
        } catch (NumberFormatException ne) {
            return;
        }
        cN--;
        if (cN >= 0 && cN < candidatesNumber) {
            candidateVotes[cN]++;
        }
    }

}
