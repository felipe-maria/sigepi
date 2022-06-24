/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fantonio.sigepi.model.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import br.com.fantonio.sigepi.model.Email;

/**
 *
 * @author Felipe
 */

public class EmailDAO extends GenericDAO<Email> {
    
    protected Pattern pattern; 
    protected Matcher matcher;
        
    public EmailDAO(){
        super(Email.class);        
    }               
    
    public List<Email> findEntitiesByEndereco(String endereco) {        
        pattern = Pattern.compile(endereco, Pattern.CASE_INSENSITIVE);
        List<Email> emails = new ArrayList<Email>();
        List<Email> emailsAux = getList();      

        for (int k=0; k < emailsAux.size(); k++) {
                matcher = pattern.matcher(emailsAux.get(k).getEndereco());              
                if (matcher.find()) {
                    emails.add(emailsAux.get(k));                   
                }
        }
        emailsAux.clear();
        return emails;
    }
}
