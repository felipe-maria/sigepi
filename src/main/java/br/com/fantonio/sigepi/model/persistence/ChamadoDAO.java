/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fantonio.sigepi.model.persistence;

import br.com.fantonio.sigepi.model.Chamado;

/**
 *
 * @author Felipe
 */
public class ChamadoDAO extends GenericDAO<Chamado> {
    
    public ChamadoDAO(){
        super(Chamado.class);        
    }
       
}
