/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fantonio.sigepi.model;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
  * Créditos para: acmasters
  * A classe original pode ser encontrada através do link:
  * http://forum.locaweb.com.br/showthread.php?t=1209
  */

/**
 *
 * @author Felipe
 */
@Entity
@Table(name="postmaster")
public class PostMaster implements Serializable, Entidade {
        
    @Id
    @SequenceGenerator(name="cd_postmaster")
    @GeneratedValue(generator="cd_postmaster")
    @Column(name="cd_postmaster", nullable=false)
    private int id;
    
    @Column(name="nm_usuario", nullable=false)
    private String usuario;
    
    @Column(name="cd_senha", nullable=false)
    private String senha;
    
    @Column(name="nm_conta", nullable=false)
    private String conta;
    
    @Column(name="nm_smtp", nullable=false)
    private String smtp;
    
    public PostMaster() { }
    
    public PostMaster(String usuario, String senha, String conta, String smtp) {
        this.usuario = usuario;
        this.senha = senha;
        this.conta = conta;
        this.smtp = smtp;
    }
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    
    public String getConta() { return conta; }
    public void setConta(String conta) { this.conta = conta; }

    public String getSmtp() { return smtp; }
    public void setSmtp(String smtp) { this.smtp = smtp; }
        
    public void enviarEmail(Mail mail) throws MessagingException {
        
        boolean debug = false;
                      
        //Set the host smtp address
        Properties props = new Properties();
        props.put("mail.smtp.host", this.smtp);
        props.put("mail.smtp.auth", "true");
        
        Authenticator auth = new SMTPAuthenticator(this.usuario, this.senha);
        Session session = Session.getDefaultInstance(props, auth);

        session.setDebug(debug);

        // create a message
        Message msg = new MimeMessage(session);

        // set the from and to address
        InternetAddress addressFrom = new InternetAddress(this.conta);
        msg.setFrom(addressFrom);

        InternetAddress[] addressTo = new InternetAddress[mail.getDestinatarios().size()];
        
        for (int k =0; k < mail.getDestinatarios().size(); k++) {
            addressTo[k] = new InternetAddress(mail.getDestinatarios().get(k));
        }
      
        msg.setRecipients(Message.RecipientType.TO, addressTo);


        // Setting the Subject and Content Type
        msg.setSubject(mail.getTitulo());
        msg.setContent(mail.getMensagem(), "text/plain");
        Transport.send(msg);
    }


    /**
    * SimpleAuthenticator is used to do simple authentication
    * when the SMTP server requires it.
    */
    private class SMTPAuthenticator extends javax.mail.Authenticator {

        private String usuario;
        private String senha;
        
        public SMTPAuthenticator(String usuario, String senha) {
            this.usuario = usuario;
            this.senha = senha;
        }
        
        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(usuario, senha);
        }
    }
    
}
