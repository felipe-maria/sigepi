/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.io.*;

/*
 * Créditos para: acmasters
 * Esta classe pode ser encontrada através do link:
 * http://forum.locaweb.com.br/showthread.php?t=1209
 */

/*
To use this program, change values for the following three constants,

SMTP_HOST_NAME -- Has your SMTP Host Name
SMTP_AUTH_USER -- Has your SMTP Authentication UserName
SMTP_AUTH_PWD -- Has your SMTP Authentication Password

Next change values for fields

emailMsgTxt -- Message Text for the Email
emailSubjectTxt -- Subject for email
EMAIL_FROM_ADDRESS -- Email Address whose name will appears as "from" address

Next change value for "emailList".
This String array has List of all Email Addresses to Email Email needs to be sent to.


Next to run the program, execute it as follows,

SendMailUsingAuthentication authProg = new SendMailUsingAuthentication();

*/

public class SendMailUsingAuthentication {

    private static final String SMTP_HOST_NAME = "smtp.grupoja.net";
    private static final String SMTP_AUTH_USER = "sigepi-automatico@grupoja.net";
    private static final String SMTP_AUTH_PWD = "senhadeemail";
    private static final String EMAIL_FROM_ADDRESS = "sigepi-automatico@grupoja.net";

    private static String emailMsgTxt = "Teste de envio de mensagem automatico pelo Sigepi";
    private static String emailSubjectTxt = "Teste de mensagem automatica - SIGEPI";

    // Add List of Email address to who email needs to be sent to
    private static final String[] emailList = {
        "felipe@grupoja.net", "felipe.antonio.maria@gmail.com"
    };

    public static void main(String args[]) throws Exception {
        SendMailUsingAuthentication smtpMailSender = new SendMailUsingAuthentication();
        smtpMailSender.postMail( emailList, emailSubjectTxt, emailMsgTxt, EMAIL_FROM_ADDRESS);
        System.out.println("Sucessfully Sent mail to All Users");
    }

    public void postMail( String recipients[ ], String subject,
            String message , String from) throws MessagingException {
        
        boolean debug = false;

        //Set the host smtp address
        Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_HOST_NAME);
        props.put("mail.smtp.auth", "true");

        Authenticator auth = new SMTPAuthenticator();
        Session session = Session.getDefaultInstance(props, auth);

        session.setDebug(debug);

        // create a message
        Message msg = new MimeMessage(session);

        // set the from and to address
        InternetAddress addressFrom = new InternetAddress(from);
        msg.setFrom(addressFrom);

        InternetAddress[] addressTo = new InternetAddress[recipients.length];
        
        for (int i = 0; i < recipients.length; i++) {
            addressTo[i] = new InternetAddress(recipients[i]);
        }
        
        msg.setRecipients(Message.RecipientType.TO, addressTo);


        // Setting the Subject and Content Type
        msg.setSubject(subject);
        msg.setContent(message, "text/plain");
        Transport.send(msg);
    }


    /**
    * SimpleAuthenticator is used to do simple authentication
    * when the SMTP server requires it.
    */
    private class SMTPAuthenticator extends javax.mail.Authenticator {

        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            String username = SMTP_AUTH_USER;
            String password = SMTP_AUTH_PWD;
            return new PasswordAuthentication(username, password);
        }
    }

} 