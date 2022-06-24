/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fantonio.sigepi.model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe
 */
public final class EntidadeSimpleFactory {
    
    
    public static Entidade getEntity(Class classe) {
        Entidade iejb = null;
        try {
            iejb = (Entidade)classe.newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(EntidadeSimpleFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(EntidadeSimpleFactory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return iejb;
        }
    }    
}
