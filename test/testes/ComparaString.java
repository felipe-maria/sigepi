/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import javax.swing.JOptionPane;

/**
 *
 * @author Felipe
 */
public class ComparaString {

    public ComparaString() {
        
    }
    
    public static void main(String[] args) {
        String entrada1 = "";
        String entrada2 = "";
        String resultado = "";
        
        entrada1 = JOptionPane.showInputDialog("Digite uma frase");
        entrada2 = JOptionPane.showInputDialog("Digite uma palavra");
                
        if (entrada1.equalsIgnoreCase(entrada2)) {
            JOptionPane.showMessageDialog(null, "Oi! Teu pai tem boi?");
        }      
        
    }      
    
}
