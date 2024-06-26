/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JDAbrirChamado.java
 *
 * Created on 01/12/2011, 14:04:51
 */
package br.com.fantonio.sigepi.view.admin;

import br.com.fantonio.sigepi.control.ChamadoControl;
import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import br.com.fantonio.sigepi.model.Pessoa;

/**
 *
 * @author Felipe
 */
public class JDAbrirChamado extends JDialog {

    private ChamadoControl control;
    private Pessoa usuarioLogado;
    
    /** Creates new form JDAbrirChamado */
    public JDAbrirChamado(Frame parent, boolean modal, Pessoa usuarioLogado) {
        super(parent, modal);
        initComponents();
        control = ChamadoControl.getControl();
        this.usuarioLogado = usuarioLogado;
        setVisible(true);
    }    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCentro = new javax.swing.JPanel();
        pnlForm = new javax.swing.JPanel();
        lblAssunto = new javax.swing.JLabel();
        txtAssunto = new javax.swing.JTextField();
        lblMensagem = new javax.swing.JLabel();
        slpMensagem = new javax.swing.JScrollPane();
        txaMensagem = new javax.swing.JTextArea();
        pnlBotoes = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Abertura de Chamados");
        setFocusTraversalPolicyProvider(true);

        lblAssunto.setText("Assunto");

        lblMensagem.setText("Mensagem");

        txaMensagem.setColumns(20);
        txaMensagem.setLineWrap(true);
        txaMensagem.setRows(5);
        txaMensagem.setWrapStyleWord(true);
        slpMensagem.setViewportView(txaMensagem);

        javax.swing.GroupLayout pnlFormLayout = new javax.swing.GroupLayout(pnlForm);
        pnlForm.setLayout(pnlFormLayout);
        pnlFormLayout.setHorizontalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAssunto)
                    .addComponent(lblMensagem))
                .addGap(18, 18, 18)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAssunto, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(slpMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );
        pnlFormLayout.setVerticalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAssunto)
                    .addComponent(txtAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(slpMensagem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMensagem))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlCentroLayout = new javax.swing.GroupLayout(pnlCentro);
        pnlCentro.setLayout(pnlCentroLayout);
        pnlCentroLayout.setHorizontalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        pnlCentroLayout.setVerticalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(pnlCentro, java.awt.BorderLayout.CENTER);

        pnlBotoes.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlBotoes.setPreferredSize(new java.awt.Dimension(558, 50));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAbrir.setText("Abrir chamado");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotoesLayout = new javax.swing.GroupLayout(pnlBotoes);
        pnlBotoes.setLayout(pnlBotoesLayout);
        pnlBotoesLayout.setHorizontalGroup(
            pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBotoesLayout.createSequentialGroup()
                .addContainerGap(260, Short.MAX_VALUE)
                .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlBotoesLayout.setVerticalGroup(
            pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotoesLayout.createSequentialGroup()
                .addGroup(pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbrir)
                    .addComponent(btnCancelar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(pnlBotoes, java.awt.BorderLayout.PAGE_END);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-566)/2, (screenSize.height-379)/2, 566, 379);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        String titulo = txtAssunto.getText();
        String descricao = txaMensagem.getText();
        Long id = null;
        try {
            id = control.abrirChamado(titulo, descricao, this.usuarioLogado);
            JOptionPane.showMessageDialog(null, "Chamado aberto com o Nº: " + id);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(JDAbrirChamado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel lblAssunto;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JPanel pnlBotoes;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JScrollPane slpMensagem;
    private javax.swing.JTextArea txaMensagem;
    private javax.swing.JTextField txtAssunto;
    // End of variables declaration//GEN-END:variables
}
