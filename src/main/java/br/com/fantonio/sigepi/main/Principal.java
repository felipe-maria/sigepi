/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fantonio.sigepi.main;

import br.com.fantonio.sigepi.mensageria.AsyncSubscriber;
import br.com.fantonio.sigepi.view.usuario.JFLogin;

/**
 *
 * @author Felipe
 */

// TODO Desacoplar o envio de email, tratar caso não tenha internet a abertura 
public class Principal {
     
    public static void main(String[] args) {
        JFLogin login = new JFLogin();
        AsyncSubscriber consumer = new AsyncSubscriber();
        consumer.run();
    }    
}
