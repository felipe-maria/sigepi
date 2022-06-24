/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fantonio.sigepi.view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;


/**
 *
 * @author Felipe
 */
public final class JIFSimpleFactory {
    
    public static JInternalFrame getJIF(Class<JInternalFrame> classe) {
        
        JInternalFrame iFrame = null;
        try {
            iFrame = classe.newInstance();            
        } catch (InstantiationException ex) {
            Logger.getLogger(JIFSimpleFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JIFSimpleFactory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return iFrame;
        }        
        
        
        
        /*
         *  Deixei este pedaço aqui para ilustrar aos colegas as vantagens do
         *  polimorfismo
         * 
        if (classe == JIFPessoa.class){
            return new JIFPessoa();
        } 
        else { 
            if (classe == JIFChamadoAdmin.class ) {
                return new JIFChamadoAdmin();       
            } 
            else {
                if (classe == JIFCertificado.class) {
                    return new JIFCertificado();
                } 
                else {
                    if (classe == JIFEmail.class) {
                        return new JIFEmail();
                    } 
                    else {
                        if (classe == JIFToner.class) {
                            return new JIFToner();
                        }
                        else {
                            if (classe == JIFTonerMov.class) {
                                return new JIFTonerMov();
                            }
                        }
                    }
                }
            }
        }
        */
        
    }    
}