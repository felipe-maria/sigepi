/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.persistence;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.PostMaster;
/**
 *
 * @author Felipe
 */
public class PostMasterDAO extends GenericDAO<PostMaster> {
    
    public PostMasterDAO() {
        super(PostMaster.class);
    }
    
    public PostMaster recuperar() throws Exception {
        if (isConfigurado()) {
            EntityManager em = getEntityManager();
            String jpql = "SELECT p FROM PostMaster p";
            Query query = em.createQuery(jpql);            
            return (PostMaster) query.getSingleResult();        
        } else {
            return new PostMaster();
        }
    }
    
    public void gravar(PostMaster postMaster) throws Exception {
        if (!isConfigurado()) {
            add(postMaster);
        } else {
            PostMaster ejb = recuperar();
            ejb.setUsuario(postMaster.getUsuario());
            ejb.setSenha(postMaster.getSenha());
            ejb.setConta(postMaster.getConta());
            ejb.setSmtp(postMaster.getSmtp());
            update(ejb);
        }
    }
                
    public boolean isConfigurado() {
        boolean flag = false;
        EntityManager em = getEntityManager();
        String jpql = "SELECT p FROM PostMaster p";
        Query query = em.createQuery(jpql);
        if (query.getResultList().isEmpty()) {
            flag = false;
        } else {
            flag = true;
        }
        em.close();
        return flag;
    }    
    /*
    public static void main(String[] args) throws Exception {
        PostMasterDAO dao = new PostMasterDAO();
        PostMaster ejb = dao.recuperar();
        System.out.println(ejb.getSenha());
        
    }
    */
}
