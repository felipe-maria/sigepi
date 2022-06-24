/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JDResponderEAAdmin.java
 *
 * Created on 07/02/2012, 15:36:51
 */
package br.com.fantonio.sigepi.view.admin;

import br.com.fantonio.sigepi.control.ChamadoControl;
import java.awt.Frame;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import br.com.fantonio.sigepi.model.Chamado;
import br.com.fantonio.sigepi.model.Pessoa;
import br.com.fantonio.sigepi.model.Resposta;

/**
 *
 * @author Felipe
 */
public class JDResponderEAAdmin extends javax.swing.JDialog {
    
    private ChamadoControl control;
    private Chamado chamado;
    private Pessoa usuarioLogado;
    private boolean intervencao;
    private Resposta resposta;
    private int linha;
    
    public JDResponderEAAdmin(Frame parent, boolean modal, boolean intervencao,
                    Chamado chamado, Pessoa usuarioLogado) {
        super(parent, modal);
        control = ChamadoControl.getControl();
        this.chamado = chamado;
        this.usuarioLogado = usuarioLogado;
        this.intervencao = intervencao;
        initComponents();          
        this.setVisible(true);
    }
    
    public JDResponderEAAdmin(Frame parent, boolean modal, boolean intervencao,
            Chamado chamado, Pessoa usuarioLogado, Resposta resposta, int linha) {
        this(parent, modal, intervencao, chamado, usuarioLogado);
        this.resposta = resposta;
        this.linha = linha;
    }
    
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        pnlCentro = new javax.swing.JPanel();
        lblResposta = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaResposta = new javax.swing.JTextArea();
        pnlBotoes = new javax.swing.JPanel();
        btnResponder = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Responder chamado em andamento");

        pnlPrincipal.setLayout(new java.awt.BorderLayout());

        lblResposta.setText("Resposta");

        txaResposta.setColumns(20);
        txaResposta.setLineWrap(true);
        txaResposta.setRows(5);
        jScrollPane1.setViewportView(txaResposta);

        javax.swing.GroupLayout pnlCentroLayout = new javax.swing.GroupLayout(pnlCentro);
        pnlCentro.setLayout(pnlCentroLayout);
        pnlCentroLayout.setHorizontalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentroLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblResposta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        pnlCentroLayout.setVerticalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentroLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblResposta)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pnlPrincipal.add(pnlCentro, java.awt.BorderLayout.CENTER);

        pnlBotoes.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlBotoes.setPreferredSize(new java.awt.Dimension(30, 60));

        btnResponder.setText("Responder");
        btnResponder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResponderActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotoesLayout = new javax.swing.GroupLayout(pnlBotoes);
        pnlBotoes.setLayout(pnlBotoesLayout);
        pnlBotoesLayout.setHorizontalGroup(
            pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBotoesLayout.createSequentialGroup()
                .addContainerGap(301, Short.MAX_VALUE)
                .addComponent(btnResponder, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        pnlBotoesLayout.setVerticalGroup(
            pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBotoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResponder)
                    .addComponent(btnCancelar))
                .addGap(29, 29, 29))
        );

        pnlPrincipal.add(pnlBotoes, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(pnlPrincipal, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-595)/2, (screenSize.height-367)/2, 595, 367);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnResponderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResponderActionPerformed
        if (intervencao == true) {
            fecharIntervencao();
        } else {
            responder();
        }
    }//GEN-LAST:event_btnResponderActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnResponder;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblResposta;
    private javax.swing.JPanel pnlBotoes;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JTextArea txaResposta;
    // End of variables declaration//GEN-END:variables

    private void responder() {
        String strResposta = txaResposta.getText();
        Calendar inicio = Calendar.getInstance();
        Calendar termino = Calendar.getInstance();       
        
        resposta = new Resposta(inicio, termino, strResposta, usuarioLogado);
        
        try {
            control.responder(chamado, resposta);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(JDVisualizarChamAtr.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    private void fecharIntervencao() {
        String strResposta = txaResposta.getText();
        Calendar termino = Calendar.getInstance();
        
        resposta.setDescricao(strResposta);
        resposta.setTermino(termino);
            
        try {
            control.fecharIntervencao(chamado, resposta, linha);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(JDVisualizarChamAtr.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }        
}
