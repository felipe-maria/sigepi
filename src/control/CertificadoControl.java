/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Certificado;
import model.tablemodel.CertificadoTableModel;
import model.Pessoa;
import model.persistence.CertificadoDAO;
import model.persistence.PessoaDAO;

/**
 * 
 * @author Felipe
 */

public final class CertificadoControl {
    
    private static final CertificadoControl certificadoController = new CertificadoControl();
    
    private CertificadoDAO certificadoDao;
    private CertificadoTableModel model;
    private PessoaDAO pessoaDAO;
    
    private CertificadoControl() {
        certificadoDao = new CertificadoDAO();
        pessoaDAO = new PessoaDAO();
        atualizarCertificados();
        model = new CertificadoTableModel(certificadoDao.getList());        
    }
        
    public static CertificadoControl getInstance() {
        return certificadoController;
    }
    
    public CertificadoDAO getDAO(){
        return certificadoDao;
    }
    
    public CertificadoTableModel getTableModel() {
        return model;
    }   
    
    private void atualizarCertificados() {
        boolean valido = false;        
        List<Certificado> lista = getListCertificado();
        Calendar vencimento = Calendar.getInstance();
        Calendar atual = Calendar.getInstance();
        
        for (int k =0; k < lista.size(); k++) {
            if (!lista.get(k).isVencido()) {
                vencimento.setTimeInMillis(lista.get(k).getVencimento().getTimeInMillis());
                switch (vencimento.compareTo(atual)) {
                    case -1:
                        lista.get(k).setVencido(true);
                        break;
                    case 0 :
                        lista.get(k).setVencido(true);
                        break;
                    case 1: 
                        lista.get(k).setVencido(false);
                        break;
                    }
            }
        }
    }        
    
    
    public void addCertificado(Certificado certificado) throws Exception {                  
        boolean jaHaUmValido = false;
        Pessoa titular = certificado.getTitular();
        List<Certificado> listaDeCertificado = getListCertificado();
            
        for (int k =0; k < listaDeCertificado.size(); k++) {
            if (listaDeCertificado.get(k).getTitular().getId() == titular.getId()) {
                if (!listaDeCertificado.get(k).isVencido()) {
                    jaHaUmValido = true;
                    throw new Exception("Já existe um certificado válido para esta pessoa!\n"); 
                }
            }
        }        
            
        if (jaHaUmValido == false) {
                    
            Calendar vencimento = Calendar.getInstance();
            vencimento.setTimeInMillis(certificado.getVencimento().getTimeInMillis());
            Calendar atual = Calendar.getInstance();            
            
            int ret = vencimento.compareTo(atual);
            switch (ret) {
                case -1:
                    certificado.setVencido(true);
                    break;
                case 0 :
                    certificado.setVencido(true);
                    break;
                case 1: 
                    certificado.setVencido(false);
                    break;
            }
            
            try {
                certificadoDao.add(certificado);
                model.addCertificado(certificado);            
            } catch (Exception ex) {
                Logger.getLogger(CertificadoControl.class.getName()).log(Level.SEVERE, null, ex);
                throw new Exception(ex.getMessage());
            }
        }        
    }  
    
    public Certificado getCertificado(int id) throws Exception {
        return certificadoDao.get(id);
    }
    
    public void alterarModoTableModel(int index) {
        switch (index) {
            case 0:
                model.todosRegistros(certificadoDao.getList());
                break;
            case 1:
                model.somenteValidos(certificadoDao.getList());
                break;
            case 2:
                model.somenteVencidos(certificadoDao.getList());
                break;
        }
        
    }

    public boolean removerCertificado(int linha) throws Exception {
        try {
            certificadoDao.remove(model.removeCertificado(linha));
            return true;
        }
        catch (Exception ex) {
            Logger.getLogger(CertificadoControl.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());                         
        }
    }   
    
    public List<Pessoa> getListPessoa() {
        return new PessoaDAO().getList();        
    }
    
    public List<Certificado> getListCertificado() {
        return new CertificadoDAO().getList();        
    }
      
}