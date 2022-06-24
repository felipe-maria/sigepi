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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.IndexColumn;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name="chamado")
public class Chamado implements Serializable, Entidade {
    
    @Id
    @SequenceGenerator(name="cd_chamado")
    @GeneratedValue(generator="cd_chamado")
    @Column(name="cd_chamado", nullable=false)
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dt_abertura", nullable=false)
    private Calendar dtAbertura;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dt_encerramento")
    private Calendar dtEncerramento;
    
    @Column(name="ds_chamado_titulo", length=255, nullable=false)
    private String titulo;
    
    @Column(name="ds_chamado", length=1024, nullable=false)
    private String descricao;
        
    @Column(name="ic_encerrado", nullable=true)
    private boolean encerrado;
    
    @ManyToOne
    @JoinColumn(name="cd_solicitante")
    private Pessoa solicitante;
    
    @ManyToOne
    @JoinColumn(name="cd_responsavel")
    private Pessoa responsavel;
    
    @ManyToOne
    @JoinColumn(name="cd_ultimo_atribuido")
    private Pessoa ultimoAtribuido;             
    
    /* 
    @OneToMany
    @JoinTable(name="chamado_resposta",joinColumns = @JoinColumn(name="cd_chamado"),
    inverseJoinColumns = @JoinColumn(name="cd_resposta"))  
    private List<RespostaEJB> respostas; 
    */

    @OneToMany(fetch=FetchType.EAGER)
    @IndexColumn(name="cd_resposta") 
    private List<Resposta> respostas;     
    
    public Chamado() { }
    
    /**
     * Cria a entidade chamado pronta para ser incluida no dao através do control.
     */
    public Chamado(String titulo, String descricao, Pessoa solicitante) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dtAbertura = Calendar.getInstance();
        this.solicitante = solicitante;
        this.responsavel = solicitante;
    }
    
    public Chamado(Calendar dtAbertura, Calendar dtEncerramento, String titulo, String descricao,
            Pessoa solicitante, Pessoa responsavel) {
        
        this.dtAbertura = dtAbertura;
        this.dtEncerramento = dtEncerramento;
        this.titulo = titulo;
        this.descricao = descricao;
        this.solicitante = solicitante;
        this.responsavel = responsavel;        
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Calendar getDtAbertura() { return dtAbertura; }
    public void setDtAbertura(Calendar dtAbertura) { this.dtAbertura = dtAbertura; }
        
    public Calendar getDtEncerramento() { return dtEncerramento; }
    public void setDtEncerramento(Calendar dtEncerramento) { this.dtEncerramento = dtEncerramento; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
           
    public boolean isEncerrado() { return encerrado; }
    public void setEncerrado(boolean encerrado) { this.encerrado = encerrado; }
    
    public Pessoa getSolicitante() { return solicitante; }
    public void setSolicitante(Pessoa solicitante) { this.solicitante = solicitante; }

    public Pessoa getResponsavel() { return responsavel; }
    public void setResponsavel(Pessoa responsavel) { this.responsavel = responsavel; }
    
    public Pessoa getUltimoAtribuido() { return ultimoAtribuido; }
    public void setUltimoAtribuido(Pessoa ultimoAtribuido) { this.ultimoAtribuido = ultimoAtribuido ; }
   
    public List<Resposta> getRespostas() { return respostas; }
    public void setRespostas(List<Resposta> respostas) { this.respostas = respostas; }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Chamado other = (Chamado) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
    
       
    
}