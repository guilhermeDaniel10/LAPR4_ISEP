/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.spd.communicationprotocol;

import static eapli.base.app.spd.communicationprotocol.AplicacaoPortalUtilizadores.sendFirstMessage;
import static eapli.base.app.spd.communicationprotocol.MotorAsClient.KEYSTORE_PASS;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/**
 *
 * @author lucas
 */
public class AplicacaoPortalUtilizadores extends Thread {

    String baseFolder;
    static SSLSocket sock;
    DataInputStream inS;
    DataOutputStream outS;
    static String idColab;
    static final String KEYSTORE_PASS = "forgotten";
    static List<Thread> threads = new ArrayList<>();
    private static volatile int atomic = 0;
    private static volatile int validateProtocol = 0;

    public AplicacaoPortalUtilizadores(String idColab) {
        this.idColab = idColab;
    }

    public AplicacaoPortalUtilizadores(SSLSocket s/*Socket s*/, String f) {
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

    /**
     * Envia a primeira mensagem de pedido para o Servidor
     */
    public static void sendFirstMessage() {

        System.setProperty("javax.net.ssl.trustStore", "client2_J.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

        // Use this certificate and private key for client certificate when requested by the server
        System.setProperty("javax.net.ssl.keyStore", "client2_J.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

        SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();

        try {
            //TESTAGEM LOCAL
            //@TODO porta alterada
            //sock = (SSLSocket) sf.createSocket(InetAddress.getByName("10.8.0.81"), 32507);
            sock = (SSLSocket) sf.createSocket(InetAddress.getByName("10.8.0.81"), 32510);
            //sock = (SSLSocket) sf.createSocket(InetAddress.getLocalHost(), 32508);

            // Correr Localmente para Testagem
        } catch (IOException ex) {
            System.out.println("Failed to connect to server.");
        }

        try {
            if (validateProtocol == 0) {
                checkCertificatesForDashBoard(sock);
                sock.startHandshake();
                validateProtocol++;
            }

        } catch (IOException ex) {
            Logger.getLogger(AplicacaoPortalUtilizadores.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erro no handshake");
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream sOut = null;
        try {
            sOut = new DataOutputStream(sock.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(AplicacaoPortalUtilizadores.class.getName()).log(Level.SEVERE, null, ex);
        }

        int k = 0;
        byte[] data = new byte[2000];
        Integer len;
        byte lenAsByte = 0;
        Thread serverConn = new Thread(new RececaoMotorServidor(sock));
        serverConn.start();

        while (true) {
            threads.add(serverConn);

            byte[] data2 = idColab.getBytes();
            len = data2.length;
            lenAsByte = len.byteValue();

            data[0] = '0';
            data[1] = '3';
            data[2] = lenAsByte;

            for (int j = 0; j < len; j++) {
                data[j + 3] = (byte) idColab.charAt(j);
                k++;
            }

            if (idColab != null) {
                try {
                    sOut.write((byte) idColab.length() + 3);
                    sOut.write(data, 0, (byte) idColab.length() + 3);
                } catch (IOException ex) {
                    Logger.getLogger(AplicacaoPortalUtilizadores.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
        }

    }

    public static void checkCertificatesForDashBoard(SSLSocket sock) {
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

    /**
     * Encarregue de ler a informacao chegada do servidor para proceder a
     * criacao de uma pagina web
     */
    static class RececaoMotorServidor implements Runnable {

        private Socket s;
        private DataInputStream sIn;

        public RececaoMotorServidor(/*SSLSocket tcp_s*/Socket tcp_s) {
            s = tcp_s;
            atomic++;
        }

        @Override
        public void run() {
            int nChars;
            byte[] data = new byte[255];

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(AplicacaoPortalUtilizadores.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {

                sIn = new DataInputStream(s.getInputStream());

                while (true) {
                    nChars = sIn.read();
                    if (nChars == -1 || nChars == 0) {
                        break;
                    }

                    boolean done = false;
                    String ss = "";

                    while (!done) {

                        data = new byte[255];
                        sIn.read(data, 0, nChars);

                        for (int j = 3; j < data.length; j++) {
                            ss += Character.toString((char) data[j]);
                        }

                        if (data[1] == '4') {
                            done = true;
                            break;
                        } else {
                            nChars = sIn.read();
                        }
                    }

                    if (atomic == 1) {
                        HttpServerAjaxWebHost.main(ss);
                        break;
                    }
                    if (atomic > 1) {
                        HttpServerAjaxWebHost.atualizarInformacao(ss);
                        break;
                    }
                }

            } catch (IOException ex) {
                System.out.println("Client disconnected.");
            } catch (Exception ex) {
                Logger.getLogger(AplicacaoPortalUtilizadores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

/**
 * Encarregue de hostear o web site em localhost
 *
 * @author Guilherme
 */
class HttpServerAjaxWebHost {

    static private final String BASE_FOLDER = "www";
    static final String TRUSTED_STORE = "server_J.jks";
    static final String KEYSTORE_PASS = "forgotten";
    static private ServerSocket sock;
    static private int port = 32507;
    static AtomicInteger atomic = new AtomicInteger();
    static String argumento;

    public static void main(String arg) throws Exception {

        Socket cliSock;
        argumento = arg;
        SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try {
            sock = new ServerSocket(port);
        } catch (IOException ex) {
            System.out.println("Server failed to open local port " + port);
            System.exit(1);
        }
        while (true) {
            cliSock = sock.accept();

            HttpWebTarefasRequest req = new HttpWebTarefasRequest(cliSock, BASE_FOLDER);
            req.start();
            askForUpdate();
        }
    }

    private static int accessesCounter;

    private static synchronized void incAccessesCounter() {
        accessesCounter++;
    }

    public static synchronized void atualizarInformacao(String args) {
        argumento = args;
    }

    public static void askForUpdate() {
        sendFirstMessage();
    }

    public static synchronized String getTarefasStandingInHTML() {
        return argumento;
    }

}
