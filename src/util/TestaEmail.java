/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import control.PostMasterControl;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Mail;
import model.PostMaster;

/**
 *
 * @author Felipe
 */
public class TestaEmail {
    
    private static String emailMsgTxt = "Teste de envio de mensagem automatico pelo Sigepi";
    private static String emailSubjectTxt = "Teste de mensagem automatica - SIGEPI";
    
    /*
    // Add List of Email address to who email needs to be sent to
    private static final String[] emailList = {
        "felipe@grupoja.net", "felipe.antonio.maria@gmail.com"
    };
    */
        public static void main(String args[]) throws Exception {
            PostMasterControl controller = new PostMasterControl();
            PostMaster postmaster = controller.getPostMasterEJB();
            
            Mail mail = new Mail();
            mail.setDestinatarios(new ArrayList<String>());
                     
            mail.setTitulo(JOptionPane.showInputDialog(null,"Digite o Assunto"));
            mail.setMensagem(JOptionPane.showInputDialog(null,"Digite a mensagem"));
            boolean flag = true;
            
            while (flag == true) {
                int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Deseja adicionar mais um destinatario?");
                if (showConfirmDialog == JOptionPane.YES_OPTION) {
                    mail.getDestinatarios().add(JOptionPane.showInputDialog(null,"Entre com o destinatario"));
                } else {
                    flag = false;
                }
            }
            
            postmaster.enviarEmail(mail);
            System.out.println("Sucessfully Sent mail to All Users");
        }    
    
}
