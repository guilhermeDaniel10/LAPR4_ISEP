/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.spd.communicationprotocol;

import eapli.base.app.spd.communicationprotocol.AplicacaoServicosRH.RececaoMotorServidor;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Guilherme
 */
public class HttpServicosRHRequest extends Thread{
    String baseFolder;
	Socket sock;
	DataInputStream inS;
	DataOutputStream outS;
        AtomicInteger atomic = new AtomicInteger();
    
	public HttpServicosRHRequest(Socket s, String f) {
            baseFolder=f; sock=s;
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
                            response.setContentFromString( HttpServerMotor.getVotesStandingInHTML2(), "text/html");
                            response.setResponseStatus("200 Ok");
			} else {
                            String fullname=baseFolder + "/";
                            	if(request.getURI().equals("/")) { 
                                    fullname=fullname+"index2.html";
                                } else { 
                                    fullname=fullname+request.getURI();
                                }
                            	if(response.setContentFromFile(fullname)) {
                                    response.setResponseStatus("200 Ok");
                                } else {
                                    response.setContentFromString( "<html><body><h1>404 File not found</h1></body></html>", "text/html");
                                    response.setResponseStatus("404 Not Found"); 
                                }
                        }
                        response.send(outS);                        
                    } else { 
                        if(request.getMethod().equals("PUT") && request.getURI().startsWith("/votes/")) {
                            HttpServerMotor.castVote(request.getURI().substring(7));
                            response.setResponseStatus("200 Ok");
                        } else {
                            response.setContentFromString( "<html><body><h1>ERROR: 405 Method Not Allowed</h1></body></html>", "text/html");
                            response.setResponseStatus("405 Method Not Allowed");
                        }
                        response.send(outS); 
                    }
                } catch(IOException ex) { 
                    System.out.println("Thread error when reading request"); 
                }
		try { 
                    sock.close();
                } catch(IOException ex) { 
                    System.out.println("CLOSE IOException"); }
	}
    }
