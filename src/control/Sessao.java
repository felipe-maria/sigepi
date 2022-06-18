/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Calendar;
import model.Pessoa;

/**
 *
 * @author Felipe
 */
public final class Sessao {
    
    private static Sessao instance;
    private final Pessoa usuarioLogado;
    private final Calendar horaLogada;
        
    private Sessao(final Pessoa usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
        this.horaLogada = Calendar.getInstance();
    }

    public static synchronized Sessao getInstance() {
        if (instance != null) {
            return instance;
        } else {
            return null;
        }
    }
    
    public static synchronized void iniciarSessao(final Pessoa usuarioLogado) {             
        if (instance == null) {
            instance = new Sessao(usuarioLogado);
        }                
    }
    
    public Pessoa getUsuarioLogado() {
        return this.usuarioLogado;
    }
    
    public Calendar getHoraLogada() {
        return this.horaLogada;
    }
}