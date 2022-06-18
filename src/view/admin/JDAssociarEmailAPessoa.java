/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JDAssociarEmailAPessoa.java
 *
 * Created on 14/10/2011, 23:49:24
 */
package view.admin;

import control.PessoaControl;
import java.awt.Color;
import java.awt.Frame;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Email;
import model.Pessoa;


public class JDAssociarEmailAPessoa extends javax.swing.JDialog {

    private PessoaControl controller;
    private Vector<Email> aAssociar, disponiveis;
    private Pessoa pessoa;   
    private List<Email> todosEmails;
    
    
    /** Creates new form JDAssociarEmailAPessoa */
    public JDAssociarEmailAPessoa(Frame parent, boolean modal, Pessoa pessoa,
                                  List<Email> todosEmails) {
        super(parent, modal);
        initComponents();
        getContentPane().setBackground(Color.LIGHT_GRAY);
        controller = PessoaControl.getInstance();
        this.pessoa = pessoa;       
        this.todosEmails = todosEmails;
        iniciar();
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
        lblEmailsAAssociar = new javax.swing.JLabel();
        lblEmailsDisponiveis = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstDisponiveis = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstAAssociar = new javax.swing.JList();
        pnlRodape = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Associar e-mails à pessoa selecionada");
        setFocusTraversalPolicyProvider(true);

        lblEmailsAAssociar.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblEmailsAAssociar.setText("E-mails à associar");

        lblEmailsDisponiveis.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblEmailsDisponiveis.setText("E-mails disponíveis");

        lstDisponiveis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstDisponiveisMouseClicked(evt);
            }
        });
        lstDisponiveis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lstDisponiveisKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(lstDisponiveis);

        lstAAssociar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstAAssociarMouseClicked(evt);
            }
        });
        lstAAssociar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lstAAssociarKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(lstAAssociar);

        javax.swing.GroupLayout pnlCentroLayout = new javax.swing.GroupLayout(pnlCentro);
        pnlCentro.setLayout(pnlCentroLayout);
        pnlCentroLayout.setHorizontalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentroLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmailsDisponiveis)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmailsAAssociar)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        pnlCentroLayout.setVerticalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentroLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmailsDisponiveis)
                    .addComponent(lblEmailsAAssociar))
                .addGap(18, 18, 18)
                .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        getContentPane().add(pnlCentro, java.awt.BorderLayout.CENTER);

        pnlRodape.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlRodape.setPreferredSize(new java.awt.Dimension(365, 50));

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRodapeLayout = new javax.swing.GroupLayout(pnlRodape);
        pnlRodape.setLayout(pnlRodapeLayout);
        pnlRodapeLayout.setHorizontalGroup(
            pnlRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRodapeLayout.createSequentialGroup()
                .addGap(370, 370, 370)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        pnlRodapeLayout.setVerticalGroup(
            pnlRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRodapeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlRodape, java.awt.BorderLayout.PAGE_END);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-596)/2, (screenSize.height-406)/2, 596, 406);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void lstDisponiveisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstDisponiveisMouseClicked
        if (evt.getClickCount() == 2) {
           addEmailParaListAssociados();
        }
    }//GEN-LAST:event_lstDisponiveisMouseClicked

    private void lstAAssociarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstAAssociarMouseClicked
        if (evt.getClickCount() == 2) {
           rmEmailDeListAssociados();
       }
    }//GEN-LAST:event_lstAAssociarMouseClicked

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        pessoa.setEmails(aAssociar);
        try {
            controller.alterarPessoa(pessoa);
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");
        } catch (Exception ex) {
            Logger.getLogger(JDAssociarPessoaAEmail.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar salvar o email!\n" +
                                            ex.getMessage());
        }
        finally {
            dispose();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void lstDisponiveisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lstDisponiveisKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {                      
             addEmailParaListAssociados();
        }
    }//GEN-LAST:event_lstDisponiveisKeyPressed

    private void lstAAssociarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lstAAssociarKeyPressed
        if (evt.getKeyCode() == evt.VK_DELETE) {                      
             rmEmailDeListAssociados();
        }
    }//GEN-LAST:event_lstAAssociarKeyPressed

    private void iniciar() {
        
        // Cria um vector de pessoas. Ele será usado para demonstrar quais pessoas
        // estão disponíveis para serem associadas
        disponiveis = new Vector<Email>();
        disponiveis.addAll(todosEmails);
        
        // Cria um vetor de pessoas. Ele será usado para demonstrar as pessoas que
        // serão associadas. Para isso é preciso verificar as pessoas que já estão associadas.
        aAssociar = new Vector<Email>();
        for (int k = 0; k < pessoa.getEmails().size(); k++) {
            aAssociar.add(pessoa.getEmails().get(k));
        }
        lstAAssociar.setListData(aAssociar);
        
        // Nesse ponto precisamos remover do vector disponiveis aquelas pessoas
        // que já estão associadas
        Iterator iterador = disponiveis.iterator();
        while (iterador.hasNext()) {
            Email email = (Email) iterador.next();
            for (int k = 0; k < aAssociar.size(); k++) {
                if (aAssociar.get(k).equals(email)) {
                    iterador.remove();
                }
            }
        }
        
        lstDisponiveis.setListData(disponiveis);
        setVisible(true);        
    }    
    
    private void addEmailParaListAssociados() {
        Email email = (Email)lstDisponiveis.getSelectedValue();
        disponiveis.remove(email);
        aAssociar.add(email);
        lstAAssociar.removeAll();
        lstAAssociar.setListData(aAssociar);
        lstDisponiveis.removeAll();
        lstDisponiveis.setListData(disponiveis);
    }
    
    private void rmEmailDeListAssociados() {
        Email email = (Email)lstAAssociar.getSelectedValue();
        aAssociar.remove(email);
        disponiveis.add(email);
        lstAAssociar.removeAll();
        lstAAssociar.setListData(aAssociar);
        lstDisponiveis.removeAll();
        lstDisponiveis.setListData(disponiveis);
    }      
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEmailsAAssociar;
    private javax.swing.JLabel lblEmailsDisponiveis;
    private javax.swing.JList lstAAssociar;
    private javax.swing.JList lstDisponiveis;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlRodape;
    // End of variables declaration//GEN-END:variables
}
