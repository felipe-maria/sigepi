/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fantonio.sigepi.model.persistence;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import br.com.fantonio.sigepi.model.Certificado;

/**
 *
 * @author Felipe
 */

public class CertificadoDAO extends GenericDAO<Certificado> {
    
    protected Pattern pattern; 
    protected Matcher matcher;
        
    public CertificadoDAO(){
        super(Certificado.class);        
    }   
    /*
    public ArrayList<CertificadoEJB> findEntitiesByEndereco(String endereco) {        
        pattern = Pattern.compile(endereco, Pattern.CASE_INSENSITIVE);
        ArrayList<CertificadoEJB> alEmail = new ArrayList<CertificadoEJB>();
        ArrayList<CertificadoEJB> alEmailAux = getEntityArrayList();      

        for (int k=0; k < alEmailAux.size(); k++) {
                matcher = pattern.matcher(alEmailAux.get(k).getEndereco());              
                if (matcher.find()) {
                    alEmail.add(alEmailAux.get(k));                   
                }
        }
        alEmailAux.clear();
        return alEmail;
    } 
    */
}
