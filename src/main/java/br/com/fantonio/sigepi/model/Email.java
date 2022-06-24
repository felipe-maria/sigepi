/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fantonio.sigepi.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Felipe
 */

@Entity
@Table (name="email")
public class Email implements Serializable, Entidade {
    
    @Id
    @SequenceGenerator(name="cd_email")
    @GeneratedValue(generator="cd_email")
    @Column(name="cd_email", nullable=false)
    private int id;
    
    @Column(name="nm_email", length=50, nullable=false, unique=true)
    private String endereco;
    
    @Column(name="nm_senha", length=15, nullable=false)
    private String senha;
        
    @Column(name="ds_email", length=100, nullable=false)
    private String descricao;
    
    @ManyToMany(fetch=FetchType.EAGER)  
    @JoinTable(name="pessoa_email",joinColumns = @JoinColumn(name="cd_email"),
    inverseJoinColumns = @JoinColumn(name="cd_pessoa"))  
    private List<Pessoa> pessoas;
            
    public Email() { }
    
    public Email(String endereco, String descricao) {
        this.endereco = endereco;
        this.descricao = descricao;
    }   
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    
    public List<Pessoa> getPessoas() { return pessoas; }
    public void setPessoas(List<Pessoa> pessoas) { this.pessoas = pessoas; }
    
     @Override
    public String toString() {
        return this.endereco;
    }    
    
    @Override
    public boolean equals(Object obj) {
        Email email = (Email) obj;
        boolean ret = false;  
  
        if (email != null) { 
            if (this.id == email.id) {  
                ret = true;  
            }
        }
        return ret;         
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
        return hash;
    }
    
    
}
