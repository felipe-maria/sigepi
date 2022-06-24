/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fantonio.sigepi.model;

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
@Table (name="certificado_digital")
public class Certificado implements Serializable, Entidade {
    
    @Id
    @SequenceGenerator(name="certificado_digital")
    @GeneratedValue(generator="certificado_digital")
    @Column(name="cd_certificado_digital", nullable=false)
    private int id;
    
    @Column(name="cd_segmento", length=20, nullable=false)
    private String segmento;
    
    @Column(name="cd_categoria", length=2, nullable=false)
    private String categoria;
    
    @Column(name="cd_midia", length=15, nullable=false)
    private String midia;
    
    @Column(name="nm_certificadora", length=30, nullable=false)
    private String certificadora;
    
    @Temporal(TemporalType.DATE)
    @Column(name="dt_expedicao", nullable=false)
    private Calendar expedicao;
    
    @Temporal(TemporalType.DATE)
    @Column(name="dt_vencimento")
    private Calendar vencimento;
    
    @Column(name="ic_vencido", nullable=false)
    private boolean vencido;
    
    @ManyToOne
    @JoinColumn(name="cd_pessoa")
    private Pessoa titular;

    public Certificado() { }
    
    public Certificado(String segmento, String categoria, String midia,
                       String certificadora, Calendar expedicao, Calendar vencimento,
                       boolean vencido) {
        
        this.segmento = segmento;
        this.categoria = categoria;
        this.midia = midia;
        this.certificadora = certificadora;
        this.expedicao = expedicao;
        this.vencimento = vencimento;       
    }
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getSegmento() { return segmento; }
    public void setSegmento(String segmento) { this.segmento = segmento; }
    
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    
    public String getMidia() { return midia; }
    public void setMidia(String midia) { this.midia = midia; }
    
    public String getCertificadora() { return certificadora; }
    public void setCertificadora(String certificadora) { this.certificadora = certificadora; }
    
    public Calendar getExpedicao() { return expedicao; }
    public void setExpedicao(Calendar expedicao) { this.expedicao = expedicao; }
        
    public Calendar getVencimento() { return vencimento; }
    public void setVencimento(Calendar vencimento) { this.vencimento = vencimento; }
        
    public boolean isVencido() { return vencido ; }
    public void setVencido(boolean vencido) { this.vencido = vencido; }   
 
    public Pessoa getTitular() { return titular; }
    public void setTitular(Pessoa titular) { this.titular = titular; }    
}