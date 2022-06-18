/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name="resposta")
public class Resposta implements Serializable, Entidade {
    
    @Id
    @SequenceGenerator(name="cd_resposta")
    @GeneratedValue(generator="cd_resposta")
    @Column(name="cd_resposta", nullable=false)
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dt_inicio", nullable=false)
    private Calendar inicio;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dt_termino", nullable=true)
    private Calendar termino;
    
    @Column(name="ds_resposta", length=255, nullable=true)
    private String descricao;
    
    @Column(name="ic_agindo", nullable=true)
    private boolean agindo;
        
    @ManyToOne
    @JoinColumn(name="cd_respondente", nullable=false)
    private Pessoa respondente;
        
    /**
     * Construtor default
     */
    public Resposta() {
        
    }
    /**
     * Este construtor é para criar respostas sem intervenção
     * @param inicio
     * @param termino
     * @param descricao
     * @param respondente 
     */
    public Resposta(Calendar inicio, Calendar termino, String descricao, Pessoa respondente) {
        this.inicio = inicio;
        this.termino = termino;
        this.descricao = descricao;
        this.respondente = respondente;
        this.agindo = false;
    }
    /**
     * Este construtor é para iniciar uma intervenção
     * @param inicio
     * @param respondente 
     */     
     
    public Resposta(Calendar inicio, Pessoa respondente) {
        this.inicio = inicio;
        this.respondente = respondente;        
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Calendar getInicio() { return inicio; }
    public void setInicio(Calendar inicio) { this.inicio = inicio; }

    public Calendar getTermino() { return termino; }
    public void setTermino(Calendar termino) { this.termino = termino; }
        
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public boolean isAgindo() { return agindo; }
    public void setAgindo(boolean agindo) { this.agindo = agindo; }
    
    public Pessoa getRespondente() { return respondente; }
    public void setRespondente(Pessoa respondente) { this.respondente = respondente; }
        
}
