/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fantonio.sigepi.control;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.fantonio.sigepi.model.Email;
import br.com.fantonio.sigepi.model.tablemodel.EmailTableModel;
import br.com.fantonio.sigepi.model.Pessoa;
import br.com.fantonio.sigepi.model.persistence.EmailDAO;
import br.com.fantonio.sigepi.model.persistence.PessoaDAO;

/**
 * 
 * @author Felipe
 */

public final class EmailControl {
    
    private static final EmailControl emailController = new EmailControl();
    
    private EmailDAO emailDAO;
    private PessoaDAO pessoaDAO;
    private EmailTableModel emailTableModel;
        
    private EmailControl() {
        emailDAO = new EmailDAO();
        pessoaDAO = new PessoaDAO();
        emailTableModel = new EmailTableModel(emailDAO.getList());
    }
        
    public static EmailControl getInstance() {
        return emailController;
    }
    
    public EmailDAO getDAO(){
        return emailDAO;
    }
    
    public EmailTableModel getTableModel() {
        return emailTableModel;
    }   
    
    public void addEmail(Email email) throws Exception {                  
        try {
            emailDAO.add(email);
            emailTableModel.addEmail(email);            
        } catch (Exception ex) {
            Logger.getLogger(EmailControl.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }  
    
    public Email getEmail(int id) throws Exception {
        return emailDAO.get(id);
    }
    
    public void alterarEmail(Email email) throws Exception {
        try {
            emailDAO.update(email); 
            emailDAO = new EmailDAO();
            emailTableModel.atualizarModelo(emailDAO.getList());
        } catch (Exception ex) {
            emailDAO = new EmailDAO();
            emailTableModel.atualizarModelo(emailDAO.getList());
            Logger.getLogger(EmailControl.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Falha ao tentar atualizar o registro no banco de dados");                                
        }      
    }    
    
    public boolean buscar(String entrada, int flag) {
               
        if (!"".equals(entrada)) {
            switch (flag) {
                case 0: emailTableModel.atualizarModelo(emailDAO.findEntitiesByEndereco(entrada));
                        break;                
            }
        } else {
            emailTableModel.limpar();
            emailTableModel.addListaDeEmail(emailDAO.getList());
        }
        return true;
    }
    
    public boolean removerUsuario(int linha) throws Exception {
        try {
            emailDAO.remove(emailTableModel.removeEmail(linha));
            return true;
        }
        catch (Exception ex) {
            Logger.getLogger(EmailControl.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());                         
        }
    }   
    
    public List<Pessoa> getListPessoa() {
        return new PessoaDAO().getList();        
    }
    
    private void updateController() {
        emailDAO = new EmailDAO();
        pessoaDAO = new PessoaDAO();
        emailTableModel = new EmailTableModel(emailDAO.getList());
    }
    
}