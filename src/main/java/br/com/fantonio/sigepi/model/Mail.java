/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fantonio.sigepi.model;

import java.util.List;

/**
 *
 * @author Felipe
 */
public class Mail {

    private String titulo;
    private String mensagem;
    private List<String> destinatarios;
    
    public Mail() { }
    
    public Mail(String titulo, String mensagem, List<String> destinatarios) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.destinatarios = destinatarios;
    }
 
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }
    
    public List<String> getDestinatarios() { return destinatarios; }
    public void setDestinatarios(List<String> destinatarios) { this.destinatarios = destinatarios; }
    
}
