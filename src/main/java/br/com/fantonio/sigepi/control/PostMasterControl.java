/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fantonio.sigepi.control;

import br.com.fantonio.sigepi.model.PostMaster;
import br.com.fantonio.sigepi.model.persistence.PostMasterDAO;

/**
 *
 * @author Felipe
 */
public class PostMasterControl{
    
    private PostMasterDAO dao;
    
    public PostMasterControl() {
        dao = new PostMasterDAO();
    }
    
    public PostMaster getPostMasterEJB() throws Exception {
        return dao.recuperar();
    }
    
    public void setPostMasterEJB(PostMaster ejb) throws Exception {
        dao.gravar(ejb);
    }    
    
}
