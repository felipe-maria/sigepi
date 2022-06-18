/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.persistence;

import java.util.ArrayList;

/**
 * @deprecated 
 * Esta interface está obsoleta pois foi preciso lançar exceptions dos métodos<br>
 * que são implementados por ela e utilizando a superclasse, os problemas são resolvidos<br>
 * Não é possível lançar exception de método reescrito.
 */

public interface IGenericDAO<T> {
    
    public boolean add(T t);   
    
    public T getEntity(int id);
    
    public boolean update(T t);
    
    public boolean remove(T t);
    
    public boolean remove(int id);
   
    public ArrayList<T> getLista();
}  