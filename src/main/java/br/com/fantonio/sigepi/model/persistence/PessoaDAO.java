/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fantonio.sigepi.model.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import br.com.fantonio.sigepi.model.Pessoa;


/**
 *
 * @author Felipe
 */

public class PessoaDAO extends GenericDAO<Pessoa> {
    
    protected Pattern pattern; 
    protected Matcher matcher;
        
    public PessoaDAO(){
        super(Pessoa.class);        
    }            
      
    public boolean temCertificado(Pessoa pessoa) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT c FROM Certificado c WHERE c.titular = :pessoa";
        Query query = em.createQuery(jpql);
        query.setParameter("pessoa", pessoa);
        if (query.getResultList().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    
    
    public boolean addColecao(Vector<Pessoa> vector){                        
        EntityManager em = getEntityManager();
        try {
            for (int k = 0; k < vector.size(); k++) {
                em.getTransaction().begin();
                em.persist(vector.get(k));
            }
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException pe){
            pe.printStackTrace();
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }             
    }  
    
    public List<Pessoa> findEntitiesByNome(String nome) {        
        pattern = Pattern.compile(nome, Pattern.CASE_INSENSITIVE);
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        List<Pessoa> pessoasAux = getList();      

        for (int k=0; k < pessoasAux.size(); k++) {
                matcher = pattern.matcher(pessoasAux.get(k).getNome());              
                if (matcher.find()) {
                    pessoas.add(pessoasAux.get(k));                   
                }
        }
        pessoasAux.clear();
        return pessoas;
    }
        
    public List<Pessoa> findEntitiesByLogin(String login) {
        pattern = Pattern.compile(login, Pattern.CASE_INSENSITIVE);
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        List<Pessoa> pessoasAux = getList();      

        for (int k=0; k < pessoasAux.size(); k++) {
                matcher = pattern.matcher(pessoasAux.get(k).getLogin());              
                if (matcher.find()) {
                    pessoas.add(pessoasAux.get(k));                   
                }
        }
        pessoasAux.clear();
        return pessoas;    
    }

    public List<Pessoa> findEntitiesByTipo(String tipo) {
        pattern = Pattern.compile(tipo, Pattern.CASE_INSENSITIVE);
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        List<Pessoa> pessoasAux = getList();      

        for (int k=0; k < pessoasAux.size(); k++) {
                matcher = pattern.matcher(pessoasAux.get(k).getTipo());              
                if (matcher.find()) {
                    pessoas.add(pessoasAux.get(k));                   
                }
        }
        pessoasAux.clear();
        return pessoas;    
    }
    
    public boolean isLoginExistente(String login) {
        List<Pessoa> lista = getList();      
        boolean retorno = true;
        for (int k=0; k < lista.size(); k++) {
            if (login.equalsIgnoreCase(lista.get(k).getLogin())) {
                retorno = true;
                break;
            }else {
                retorno = false;
            }  
        }
        System.gc();
        return retorno;
    }
    
    public boolean isCpfExistente(String cpf) {
        List<Pessoa> lista = getList();      
        boolean retorno = true;
        for (int k=0; k < lista.size(); k++) {
            if (cpf.equalsIgnoreCase(lista.get(k).getCpf())) {
                retorno = true;
                break;
            }else {
                retorno = false;
            }  
        }
        System.gc();
        return retorno;
    }
    
}
