/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fantonio.sigepi.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Felipe
 */

@Entity
@Table (name="pessoa")
public class Pessoa implements Serializable, Entidade  {

    // Atributos
    @Id
    @SequenceGenerator(name="cd_pessoa")
    @GeneratedValue(generator="cd_pessoa")
    @Column(name="cd_pessoa", nullable=false)
    private int id;
        
    @Column(name="nm_pessoa", length=50, nullable=false)
    private String nome;
    
    @Column(name="nm_login", unique=true, length=20, nullable=false)
    private String login;
    
    @Column(name="nm_senha", length=15, nullable=false)
    private String senha;
    
    @Column(name="nm_usuario_tipo", length=15, nullable=false)
    private String tipo;
    
    @Column(name="cd_cpf", unique=true, length=14, nullable=false)
    private String cpf;
    
    @Column(name="cd_rg", length=20, nullable=false)
    private String rg;
    
    @Column(name="cd_emissor", length=10, nullable=false)
    private String emissor;
    
    @Column(name="cd_uf", length=5, nullable=false)
    private String uf;
        
    @Column(name="ds_observacao", length=255, nullable=true)
    private String observacao;

    @Temporal(TemporalType.DATE)
    @Column(name="dt_nascimento", nullable=false)
    private Calendar dataNascimento;
    
    @Column(name="ic_ativo", nullable=false)
    private boolean ativo;
    
    @Column(name="qt_chamados_em_aberto", nullable=false)
    private int chamadosEmAberto;
    
    @Lob
    @Column(name="bl_foto", nullable=true)
    private byte[] foto;
    
    @ManyToMany(fetch=FetchType.EAGER)  
    @JoinTable(name="pessoa_email",joinColumns = @JoinColumn(name="cd_pessoa"),
    inverseJoinColumns = @JoinColumn(name="cd_email"))  
    private List<Email> emails;
    
    //@OneToMany(mappedBy="titular", fetch= FetchType.EAGER, cascade= CascadeType.ALL)
    //private Set<Certificado> certificados;
    
    // Construtor sobrecarregado sem passar id, que é gerada pelo próprio hibernate
    public Pessoa(String nome, String login, String senha, String tipo,
                     String cpf, String rg, String emissor, String uf, 
                     String observacao, Calendar dataNascimento, boolean ativo,
                     byte[] foto ){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
        this.cpf = cpf;
        this.rg = rg;
        this.emissor = emissor;
        this.uf = uf;
        this.observacao = observacao;
        this.dataNascimento = dataNascimento;        
        this.ativo = ativo;
        this.foto = foto;
    }
       
    // Default constructor
    public Pessoa() { }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    
    public String getRg() { return rg; }
    public void setRg(String rg) { this.rg = rg; }   

    public String getEmissor() { return emissor; }
    public void setEmissor(String emissor) { this.emissor = emissor; }

    public String getUf() { return uf; }
    public void setUf(String uf) { this.uf = uf; }    

    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }
    
    public Calendar getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(Calendar dataNascimento) { this.dataNascimento = dataNascimento; }
    
    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
    
    public int getChamadosEmAberto() { return chamadosEmAberto; }
    public void setChamadosEmAberto(int chamadosEmAberto) { this.chamadosEmAberto = chamadosEmAberto; }
        
    public byte[] getFoto() { return foto; }
    public void setFoto(byte[] foto) { this.foto = foto; }
    
    //public Set<Certificado> getCertificados() { return this.certificados; }
    //public void setCertificados(Set<Certificado> certificados) { this.certificados = certificados; }
    
    public List<Email> getEmails() {
        return this.emails;
    }
    
    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }
    
    @Override
    public String toString() {
        return this.nome;
    }    
    
    @Override
    public boolean equals(Object obj) {
        Pessoa pessoa = (Pessoa) obj;
        boolean ret = false;  
  
        if (pessoa != null) { 
            if (this.id == pessoa.id) {  
                ret = true;  
            }
        }
        return ret;         
    }
}
