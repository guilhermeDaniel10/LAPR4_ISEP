/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.utils;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Guilherme
 */
public class EmailSender {
    
    public static void sendEmail(String recetor, String mensagem) {

        try {
            Properties props = new Properties();
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");//it’s optional in Mailtrap
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");// use one of the options in the SMTP settings tab in your Mailtrap Inbox
            
            String myAcountEmail = "lapr4projeto2dmg02@gmail.com";
            String password = "abc123__";
            
            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(myAcountEmail, password);
                        }
                    });
            
            Message message = prepareMessage(session, myAcountEmail, recetor, mensagem);
            
            Transport.send(message);
        } catch (MessagingException ex) {
            Logger.getLogger(EmailSender.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static Message prepareMessage(Session session, String myAcountEmail, String recetor, String mensagem) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAcountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recetor));
            message.setText("Mensagem de LAPR4- 2DMG02");
            message.setText(mensagem);
            return message;
        } catch (Exception ex) {
        }
        return null;
    }
}
