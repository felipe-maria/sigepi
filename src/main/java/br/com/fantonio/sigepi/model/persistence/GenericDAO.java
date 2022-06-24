/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor
 */
package br.com.fantonio.sigepi.model.persistence;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;


public abstract class GenericDAO<T> {
    
    protected Class persistentClass;
    
    /**
     * Construtor que recebe a classe que será persistida através de Generics.<br><br>   
     * Exemplo: super(Entidade.class)
     * @param persistentClass a referência de classe a extender a classe GenericDAO.<br>
     */
    
        
    protected EntityManager getEntityManager(){
        return JPAUtil.getFactory().createEntityManager();
    }    
    
    /*
    protected GenericDAO(Class persistentClass){
        emf = Persistence.createEntityManagerFactory("sigepi");
        this.persistentClass = persistentClass;        
    }    
    */
    
    protected GenericDAO(Class persistentClass){
        this.persistentClass = persistentClass;        
    }
    
    /**
     * Adiciona uma entidade(objeto) para a base de dados.<br><br>     
     * Exemplo: boolean b = genericDAO.add(entidade)
     * 
     * 
     * @param t a entidade(object) a ser persistida.
     * @return true se houver sucesso ou false se houver falha
     */
    
    public void add(T t) throws Exception{                        
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        } catch (PersistenceException pe){            
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, pe);
            em.getTransaction().rollback();
            throw new Exception("Erro ao tentar adicionar o objeto!\n" + 
                                pe.getMessage());
        } finally {
            em.close();
        }             
    }  
    
    /**
     * Retorna a entidade persistida de acordo com o seu identificador.<br><br>     
     * Exemplo: entidade = genericDAO.get(id)
     * 
     * @param id a chave primária/id da entidade a ser retornada
     * @return t a entidade a ser retornada
     */
    public T get(int id) throws Exception{
        EntityManager em = getEntityManager();
        try { 
            T t = (T)em.find(persistentClass, id);
            em.refresh(t);
            return t;
        } catch (PersistenceException pe) {
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, pe);
            em.getTransaction().rollback();
            throw new Exception("Erro ao tentar carregar o objeto!\n" + 
                                pe.getMessage());            
        } finally {
            em.close();
        }         
    }         
    
    /**
     * Atualiza a entidade persistida.<br><br>
     * Exemplo: boolean b = genericDAO.update(entidade)
     * @param t a entidade a ser atualizada
     * @return true se houver sucesso ou false se houver falha
     */
    public T update(T t) throws Exception {     
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();            
            t = em.merge(t);                
            em.getTransaction().commit();            
        } catch (PersistenceException pe){
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, pe);
            em.getTransaction().rollback();
            throw new Exception("Erro ao tentar alterar o objeto!\n" + 
                                pe.getMessage()); 
        } finally { 
            em.close();            
        }
        return t;
    }    
    
    /**
     * Remove a entidade persistida.<br><br>
     * Exemplo: boolean b = genericDAO.remove(entidade)
     * @param t a entidade a ser removida
     * @return true se houver sucesso ou false se houver falha
     */
    public void remove(T t) throws Exception {
        EntityManager em = getEntityManager();
        
        try {
            em.getTransaction().begin();
            t = em.merge(t);
            em.remove(t);
            em.getTransaction().commit();            
        } catch (PersistenceException pe){
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, pe);
            em.getTransaction().rollback();
            throw new Exception("Erro ao tentar remover o objeto!\n" + 
                                pe.getMessage());             
        } finally {
            em.close();
        }
    }
    
    /**
     * Remove a entidade persistida.<br><br>
     * Exemplo: boolean b = genericDAO.remove(id)
     * @param t a entidade a ser removida
     * @return true se houver sucesso ou false se houver falha
     */
    public void remove(int id) throws Exception {      
        remove(get(id));        
    }
          
    /**
     * Retorna uma lista de todas as entidades persistidas deste tipo.<br><br>
     * Exemplo: lista<t> = genericDAO.getLista()
     * @return List<t>   
     */ 
    
    public List<T> getList() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.flush();
        List <T> colecao = em.createQuery("from " + persistentClass.getSimpleName()).getResultList();
        em.close();
        return colecao; 
    }    
    
    public T refresh(T t) throws Exception{
        EntityManager em = getEntityManager();
        try { 
            t = (T)em.find(persistentClass, t);
            em.refresh(t);            
        } catch (PersistenceException pe) {
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, pe);
            em.getTransaction().rollback();
            throw new Exception("Erro ao tentar atualizar o objeto!\n" + 
                                pe.getMessage());            
        } finally {
            em.close();
            return t;
        }         
    }
    
    public void limparEstado() {
        EntityManager em = getEntityManager();
        em.clear();
        em.flush();
        em.close();
    }
        
}