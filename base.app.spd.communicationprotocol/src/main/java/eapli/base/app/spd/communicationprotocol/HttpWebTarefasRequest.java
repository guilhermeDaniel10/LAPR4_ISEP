/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.spd.communicationprotocol;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;

/**
 *
 * @author Guilherme
 */
public class HttpWebTarefasRequest extends Thread{
    	
        String baseFolder;
        Socket sock;
	DataInputStream inS;
	DataOutputStream outS;
        AtomicInteger atomic = new AtomicInteger();
    
	public HttpWebTarefasRequest(Socket s, String f) {
            baseFolder=f; 
            sock=s;
	}	
    
        @Override
	public void run() {
                
		try {
                    outS = new DataOutputStream(sock.getOutputStream());
                    inS = new DataInputStream(sock.getInputStream());
		} catch(IOException ex) { 
                    System.out.println("Thread error on data streams creation"); 
                }
                
        	try {
        		HTTPmessage request = new HTTPmessage(inS);
        		HTTPmessage response = new HTTPmessage();
                    
        		if(request.getMethod().equals("GET")) {
        			if(request.getURI().equals("/votes")) {
					response.setContentFromString( HttpServerAjaxWebHost.getTarefasStandingInHTML(), "text/html");
					response.setResponseStatus("200 Ok");
                                } else {
                                        
                            		String fullname = baseFolder + "/";
                            		if(request.getURI().equals("/")){
                                            fullname = fullname + "index.html";
                                        } else {
                                            fullname = fullname + request.getURI();
                                        }
                                        
                            		if(response.setContentFromFile(fullname)) {
                                            response.setResponseStatus("200 Ok");
                                	} else {
                                            response.setContentFromString( "<html><body><h1>407 File not found</h1></body></html>", "text/html");
                                            response.setResponseStatus("404 Not Found"); 
                                	}
                            	}
                            response.send(outS);                        
                        }
                        
                } catch(IOException ex) { 
                     Logger.getLogger(AplicacaoPortalUtilizadores.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Thread error when reading request"); 
                }
                
		try { 
                    sock.close(); 
                } catch(IOException ex) { 
                    System.out.println("CLOSE IOException"); }
		}
	}