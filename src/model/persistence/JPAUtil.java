/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Felipe
 */
class JPAUtil {

    private static EntityManagerFactory factory;

    // bloco static
    static {
        JPAUtil.factory = Persistence.createEntityManagerFactory("sigepi");
    }

    public static EntityManagerFactory getFactory(){
        return JPAUtil.factory;
    }
}

