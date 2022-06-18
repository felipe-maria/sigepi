/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Email;
import model.Pessoa;
import model.tablemodel.PessoaTableModel;
import model.persistence.EmailDAO;
import model.persistence.PessoaDAO;

/**
 * 
 * @author Felipe
 */

public final class PessoaControl {
    
    private static final PessoaControl pessoaController = new PessoaControl();
    
    private PessoaDAO pessoaDAO;
    private EmailDAO emailDAO;
    private PessoaTableModel pessoaTableModel;
    
    
    private PessoaControl() {
        pessoaDAO = new PessoaDAO();
        emailDAO = new EmailDAO();
        pessoaTableModel = new PessoaTableModel(pessoaDAO.getList());
    }
    
    public static PessoaControl getInstance() {
        return pessoaController;
    }
    
    public PessoaDAO getDAO(){
        return pessoaDAO;
    }
    
    public PessoaTableModel getTableModel() {
        return pessoaTableModel;
    }   
    
    public void addPessoa(Pessoa pessoa) throws Exception {                  
        try {
            pessoaDAO.add(pessoa);
            pessoaTableModel.addPessoa(pessoa);            
        } catch (Exception ex) { 
            Logger.getLogger(PessoaControl.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());       
        }        
    }  
    
    public Pessoa getPessoa(int id) throws Exception {
        return pessoaDAO.get(id);
    }
    
    public void alterarPessoa(Pessoa pessoa) throws Exception {
        try {
            pessoaDAO.update(pessoa); 
            pessoaDAO = new PessoaDAO();
            pessoaTableModel.atualizarModelo(pessoaDAO.getList());
        } catch (Exception ex) {
            pessoaDAO = new PessoaDAO();
            pessoaTableModel.atualizarModelo(pessoaDAO.getList());
            Logger.getLogger(EmailControl.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());                                
        }            
    }    
    
    public boolean buscar(String entrada, int flag) {
               
        if (!"".equals(entrada)) {
            switch (flag) {
                case 0: pessoaTableModel.atualizarModelo(pessoaDAO.findEntitiesByNome(entrada));
                        break;
                case 1: pessoaTableModel.atualizarModelo(pessoaDAO.findEntitiesByLogin(entrada));
                        break;
                case 2: pessoaTableModel.atualizarModelo(pessoaDAO.findEntitiesByTipo(entrada));
                        break;
            }
        } else {
            pessoaTableModel.limpar();
            pessoaTableModel.addListaDePessoa(pessoaDAO.getList());
        }
        return true;
    }
    
    public void removerUsuario(int linha) throws Exception {
        Pessoa pessoa = pessoaTableModel.getPessoa(linha);
        
        //pessoaDAO.remove(pessoaTableModel.removePessoa(linha));
        
        if (!pessoaDAO.temCertificado(pessoa)) {
            try {
                pessoaDAO.remove(pessoaTableModel.removePessoa(linha));
            } catch (Exception ex) {
                Logger.getLogger(PessoaControl.class.getName()).log(Level.SEVERE, null, ex);
                throw new Exception(ex.getMessage());
            }
        } else {
            throw new Exception("Não foi possível excluir este registro!\n" +
                    "Só é possível excluir pessoas que não estejam associadas a outras entidades do sistema.");
        }
        
    }       
    
    public List<Email> getListEmail() {
        return new EmailDAO().getList();
    }
   
     
}