/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import control.Sessao;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Felipe
 */
public class StatusBar extends JPanel{
    
    private JLabel lblUsuarioDado;
    private JLabel lblDataLogada;
    private JLabel lblDataLogadaDado;
    private JLabel lblTipoUsuarioDado;
    private SimpleDateFormat sdf;
    
    private Sessao sessao;
    
    public StatusBar() {
        initComponents();
    }

    private void initComponents() {
        sessao = Sessao.getInstance();
        sdf = new SimpleDateFormat("HH:mm");
        lblDataLogada = new JLabel("Hora do Login: ");
        lblDataLogadaDado = new JLabel(sdf.format(sessao.getHoraLogada().getTime()));
        lblUsuarioDado = new JLabel(sessao.getUsuarioLogado().getLogin());
        lblTipoUsuarioDado = new JLabel(sessao.getUsuarioLogado().getTipo());
               
        this.add(lblDataLogada);
        this.add(lblDataLogadaDado);
        this.add(lblUsuarioDado);
        this.add(lblTipoUsuarioDado);
    }
    
}