/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JDVisualizarChamAdminNA.java
 *
 * Created on 11/01/2012, 08:57:34
 */
package view.admin;

import control.ChamadoControl;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import javax.swing.JDialog;
import model.Chamado;

/**
 *
 * @author Felipe
 */
public class JDVisualizarChamAdminNA extends JDialog {

    private ChamadoControl control;
    private Chamado chamado;
        
    /** Creates new form JDVisualizarChamAdminNA */
    public JDVisualizarChamAdminNA(Frame parent, boolean modal, Chamado chamado) {
        super(parent, modal);
        control = ChamadoControl.getControl();
        this.chamado = chamado;
        initComponents();
        preencherComponentes();
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
        lblMensagem = new javax.swing.JLabel();
        txtAssunto = new javax.swing.JTextField();
        slpMensagem = new javax.swing.JScrollPane();
        txaMensagem = new javax.swing.JTextArea();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtSolicitante = new javax.swing.JTextField();
        lblData = new javax.swing.JLabel();
        lblSolicitante = new javax.swing.JLabel();
        ftxtDtAbertura = new javax.swing.JFormattedTextField();
        ftxtHrAbertura = new javax.swing.JFormattedTextField();
        pnlBotoes = new javax.swing.JPanel();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Visualização de chamado");

        lblAssunto.setText("Assunto");

        lblMensagem.setText("Mensagem");

        txtAssunto.setEditable(false);
        txtAssunto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAssuntoKeyPressed(evt);
            }
        });

        txaMensagem.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        txaMensagem.setColumns(20);
        txaMensagem.setEditable(false);
        txaMensagem.setLineWrap(true);
        txaMensagem.setRows(5);
        txaMensagem.setWrapStyleWord(true);
        txaMensagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txaMensagemKeyPressed(evt);
            }
        });
        slpMensagem.setViewportView(txaMensagem);

        lblId.setText("Id");

        txtId.setEditable(false);

        txtSolicitante.setEditable(false);

        lblData.setText("Data de abertura");

        lblSolicitante.setText("Solicitante");

        ftxtDtAbertura.setEditable(false);

        ftxtHrAbertura.setEditable(false);

        javax.swing.GroupLayout pnlFormLayout = new javax.swing.GroupLayout(pnlForm);
        pnlForm.setLayout(pnlFormLayout);
        pnlFormLayout.setHorizontalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMensagem)
                    .addComponent(lblAssunto)
                    .addComponent(lblId)
                    .addComponent(lblSolicitante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(lblData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftxtDtAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(ftxtHrAbertura, 0, 0, Short.MAX_VALUE))
                    .addComponent(slpMensagem)
                    .addComponent(txtAssunto, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                    .addComponent(txtSolicitante))
                .addGap(31, 31, 31))
        );
        pnlFormLayout.setVerticalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblData)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftxtDtAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftxtHrAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSolicitante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAssunto)
                    .addComponent(txtAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMensagem)
                    .addComponent(slpMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout pnlCentroLayout = new javax.swing.GroupLayout(pnlCentro);
        pnlCentro.setLayout(pnlCentroLayout);
        pnlCentroLayout.setHorizontalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCentroLayout.setVerticalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pnlCentro, java.awt.BorderLayout.CENTER);

        pnlBotoes.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlBotoes.setPreferredSize(new java.awt.Dimension(558, 50));

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotoesLayout = new javax.swing.GroupLayout(pnlBotoes);
        pnlBotoes.setLayout(pnlBotoesLayout);
        pnlBotoesLayout.setHorizontalGroup(
            pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBotoesLayout.createSequentialGroup()
                .addContainerGap(396, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlBotoesLayout.setVerticalGroup(
            pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotoesLayout.createSequentialGroup()
                .addComponent(btnVoltar)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(pnlBotoes, java.awt.BorderLayout.PAGE_END);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-531)/2, (screenSize.height-457)/2, 531, 457);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void txtAssuntoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAssuntoKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER      : this.dispose();
                                          break;
            case KeyEvent.VK_ESCAPE     : this.dispose();
                                          break;     
            case KeyEvent.VK_BACK_SPACE : this.dispose();
                                          break;
        }
    }//GEN-LAST:event_txtAssuntoKeyPressed

    private void txaMensagemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaMensagemKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER      : this.dispose();
                                          break;
            case KeyEvent.VK_ESCAPE     : this.dispose();
                                          break;     
            case KeyEvent.VK_BACK_SPACE : this.dispose();
                                          break;
        }
    }//GEN-LAST:event_txaMensagemKeyPressed

    private void preencherComponentes() {
        SimpleDateFormat sds1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sds2 = new SimpleDateFormat("HH:mm");
       
        txtId.setText(Long.toString(chamado.getId()));
        ftxtDtAbertura.setText(sds1.format(chamado.getDtAbertura().getTime()));
        ftxtHrAbertura.setText(sds2.format(chamado.getDtAbertura().getTime()));
        txtSolicitante.setText(chamado.getSolicitante().getNome());
        txtAssunto.setText(this.chamado.getTitulo());
        txaMensagem.setText(chamado.getDescricao());
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVoltar;
    private javax.swing.JFormattedTextField ftxtDtAbertura;
    private javax.swing.JFormattedTextField ftxtHrAbertura;
    private javax.swing.JLabel lblAssunto;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JLabel lblSolicitante;
    private javax.swing.JPanel pnlBotoes;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JScrollPane slpMensagem;
    private javax.swing.JTextArea txaMensagem;
    private javax.swing.JTextField txtAssunto;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtSolicitante;
    // End of variables declaration//GEN-END:variables
}
