/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mensageria.Publisher;
import model.Chamado;
import model.Pessoa;
import model.Resposta;
import model.persistence.ChamadoDAO;
import model.persistence.PessoaDAO;
import model.persistence.RespostaDAO;
import model.tablemodel.ChamadosEATableModel;
import model.tablemodel.ChamadosEncerradosTableModel;
import model.tablemodel.ChamadosNAtriTableModel;
import model.tablemodel.TecnicosTableModel;

/**
 *
 * @author Felipe
 */
public final class ChamadoControl {
    
    private static final ChamadoControl chamadoControl = new ChamadoControl();
    private Publisher publisher;
    
    private Pessoa usuarioLogado;
    
    private ChamadoDAO chamadoDAO;
    private PessoaDAO pessoaDAO;
    private RespostaDAO respostaDAO;
    
    private ChamadosNAtriTableModel chamadosNAtriTableModel;    
    private ChamadosEATableModel chamadosEATableModel;
    private ChamadosEncerradosTableModel chamadosEncerradosTableModel;
          
    private ChamadoControl() {       
        this.usuarioLogado = Sessao.getInstance().getUsuarioLogado();
        chamadoDAO = new ChamadoDAO();
        pessoaDAO = new PessoaDAO();
        respostaDAO = new RespostaDAO();
        chamadosNAtriTableModel = new ChamadosNAtriTableModel(getNaoAtribuidos());
                         
        chamadosEncerradosTableModel = new ChamadosEncerradosTableModel(getEncerrados());
        chamadosEATableModel = new ChamadosEATableModel(getEmAndamento());
        publisher = new Publisher();
    }    
    
    // TODO testar tudo!!! testa tuto ! testa tuto!
    public void atualizar() {        
        chamadoDAO = new ChamadoDAO();
        pessoaDAO = new PessoaDAO();
        respostaDAO = new RespostaDAO();
        chamadosNAtriTableModel.atualizarModelo(getNaoAtribuidos());
                         
        chamadosEncerradosTableModel.atualizarModelo(getEncerrados());
        chamadosEATableModel.atualizarModelo(getEmAndamento());
        System.gc();
    }
    
    public static ChamadoControl getControl() {
        return chamadoControl;
    }
    
    public ChamadoDAO getDAO(){
        return chamadoDAO;
    }
    
    public ChamadosEATableModel getChamadosEATableModel() {
        return chamadosEATableModel;
    }
    
    public ChamadosNAtriTableModel getChamadosNAtriTableModel() {
        return chamadosNAtriTableModel;
    }   
    
    public ChamadosEncerradosTableModel getChamadosEncerradosTableModel() {
        return chamadosEncerradosTableModel;
    }    
    
    public TecnicosTableModel getTecnicosTableModel() {
        return new TecnicosTableModel(pessoaDAO.findEntitiesByTipo("TECNICO"));
    }    
    
    //TODO ARRUMAR ESSE METODOS MALDITOS COLOCANDO A BUSCA NO BANCO!!!!!
    private List<Chamado> getNaoAtribuidos() {
        List<Chamado> chamados = chamadoDAO.getList();
        
        Iterator a = chamados.iterator();
                
        while(a.hasNext()){  
            Chamado chamado = (Chamado)a.next();
            if ((chamado.getUltimoAtribuido() != null) || (chamado.isEncerrado() == true)) {
                a.remove();
            }
        }          
        return chamados;
    } 
    
    private List<Chamado> getEmAndamento() {
        List<Chamado> chamados = chamadoDAO.getList();
        
        Iterator a = chamados.iterator();
       
        if (this.usuarioLogado.getTipo().equalsIgnoreCase("administrador")) {
            while(a.hasNext()){  
                Chamado chamado = (Chamado)a.next();
                if ((chamado.getUltimoAtribuido() == null) || (chamado.isEncerrado() == true)) {
                    a.remove();
                }
            } 
        } else if (this.usuarioLogado.getTipo().equalsIgnoreCase("tecnico")) {
            while(a.hasNext()){  
                Chamado chamado = (Chamado)a.next();
                if (
                        (chamado.getUltimoAtribuido() == null) || 
                        (!chamado.getUltimoAtribuido().equals(this.usuarioLogado)) ||
                        (chamado.isEncerrado() == true)
                    ) {
                    a.remove();
                }
            }
        } else if (this.usuarioLogado.getTipo().equalsIgnoreCase("usuario")) {
            while(a.hasNext()){  
                Chamado chamado = (Chamado)a.next();
                if (
                        (!chamado.getSolicitante().equals(usuarioLogado)) || 
                        (chamado.isEncerrado() == true)
                    ) {
                    a.remove();
                }
            }
        }        
        return chamados;
    }
        
    private List<Chamado> getEncerrados() {
        List<Chamado> chamados = chamadoDAO.getList();
        
        Iterator a = chamados.iterator();
        
        if (this.usuarioLogado.getTipo().equalsIgnoreCase("administrador")) {
            while(a.hasNext()){  
                Chamado chamado = (Chamado)a.next();
                if (!chamado.isEncerrado()) {
                    a.remove();
                }
            }           
        } else if (this.usuarioLogado.getTipo().equalsIgnoreCase("tecnico")) {
            while(a.hasNext()){  
                Chamado chamado = (Chamado)a.next();
                if (chamado.getUltimoAtribuido() != null) {                
                    if (
                            (!chamado.isEncerrado()) || 
                            (!chamado.getUltimoAtribuido().equals(this.usuarioLogado))
                        ){
                        a.remove();
                    }
                } else {
                    a.remove();
                }
            }
        } else if (this.usuarioLogado.getTipo().equalsIgnoreCase("usuario")) {
            while(a.hasNext()){  
                Chamado chamado = (Chamado)a.next();
                if (
                        (!chamado.isEncerrado()) || 
                        (!chamado.getSolicitante().equals(usuarioLogado))
                    ){
                    a.remove();
                }
            }
        }       
        return chamados;
    }
    
    public void autoAtribuirChamadoAdmin(int linha, Pessoa admin) throws Exception {
        Chamado chamado = chamadosNAtriTableModel.getChamadoEJB(linha);
        chamado.setRespostas(new ArrayList<Resposta>());
        admin.setChamadosEmAberto(admin.getChamadosEmAberto()+1);
        chamado.setUltimoAtribuido(admin);
        pessoaDAO.update(admin);
        chamado = chamadoDAO.update(chamado);
        chamadosNAtriTableModel.removeChamado(linha);
        chamadosEATableModel.addChamado(chamado);     
        publisher.enviarMensagem();
    }
   
    public void atribuirChamadoATecnico(Chamado chamado, Pessoa tecnico) 
            throws Exception {
        chamado.setUltimoAtribuido(tecnico);
        tecnico.setChamadosEmAberto(tecnico.getChamadosEmAberto()+1);
        pessoaDAO.update(tecnico);
        chamadoDAO.update(chamado);
        chamadosNAtriTableModel.removeChamado(chamado);
        chamadosEATableModel.addChamado(chamado);
        publisher.enviarMensagem();
    }
          
    public Long abrirChamado(String titulo, String descricao, Pessoa usuarioLogado)  
            throws Exception {
        Chamado chamado = new Chamado(titulo, descricao, usuarioLogado);
        Long id = null;
        try {            
            chamadoDAO.add(chamado);
            
            if (usuarioLogado.getTipo().equalsIgnoreCase("administrador")) {
                chamadosNAtriTableModel.addChamado(chamado);
            } else {
                chamadosEATableModel.addChamado(chamado);
            }
            
            chamado = chamadoDAO.refresh(chamado);

            id = chamado.getId();
            publisher.enviarMensagem();
        } catch (Exception ex) {
            Logger.getLogger(ChamadoControl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return id;
        }
    }    

    public void encerrarChamadoNAtri(Chamado chamado, Resposta resposta) throws Exception {
        if (chamado.getRespostas() == null) {
            ArrayList<Resposta> respostas = new ArrayList<Resposta>(); 
            chamado.setRespostas(respostas);
        }
            
        chamado.getRespostas().add(resposta);
        respostaDAO.add(resposta);
        
        try {
            chamado.setDtEncerramento(Calendar.getInstance());
            chamado.setEncerrado(true);
              
            chamadoDAO.update(chamado);
            chamadosNAtriTableModel.removeChamado(chamado);
            chamadosEncerradosTableModel.addChamado(chamado);
            publisher.enviarMensagem();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }                  
    }
    
    public void encerrarChamadoEA(Chamado chamado, Resposta resposta) throws Exception {
        if (chamado.getRespostas() == null) {
            ArrayList<Resposta> respostas = new ArrayList<Resposta>(); 
            chamado.setRespostas(respostas);
        }
         
        chamado.setUltimoAtribuido(pessoaDAO.get(chamado.getUltimoAtribuido().getId()));
        
        try {
            if (chamado.getUltimoAtribuido() != null) {
                chamado.getUltimoAtribuido().setChamadosEmAberto(chamado.
                        getUltimoAtribuido().getChamadosEmAberto() -1);
            }             
                        
            chamado.setDtEncerramento(Calendar.getInstance());
            chamado.setEncerrado(true);
            
            chamado.getRespostas().add(resposta);
            
            respostaDAO.add(resposta);
            pessoaDAO.update(chamado.getUltimoAtribuido());
            chamadoDAO.update(chamado);
            chamadosEATableModel.removeChamado(chamado);
            chamadosEncerradosTableModel.addChamado(chamado);
            publisher.enviarMensagem();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }             
    }
   
    public void responder(Chamado chamado, Resposta resposta) throws Exception {
        chamado.getRespostas().add(resposta);
        respostaDAO.add(resposta);
        chamadoDAO.update(chamado);
        chamadosEATableModel.fireTableDataChanged();
        publisher.enviarMensagem();
    }
        
    public void iniciarIntervencao(Chamado chamado, int linha, Pessoa usuarioLogado) 
            throws Exception {
        Resposta resposta = new Resposta(Calendar.getInstance(), usuarioLogado);
        resposta.setAgindo(true);
        chamado.getRespostas().add(resposta);
        respostaDAO.add(resposta);
        chamadoDAO.update(chamado);
        chamadosEATableModel.setValueAt(chamado, linha);      
        publisher.enviarMensagem();
    }

    public void fecharIntervencao(Chamado chamado, Resposta resposta, int linha) 
            throws Exception {
        resposta.setAgindo(false);
        respostaDAO.update(resposta);
        chamadoDAO.update(chamado);
        chamadosEATableModel.setValueAt(chamado, linha);
        publisher.enviarMensagem();
    }
   
}