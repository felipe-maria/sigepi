/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JFPrincipalUsuario.java
 *
 * Created on 10/02/2012, 20:34:30
 */
package view.usuario;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import model.Pessoa;
import util.Versao;
import view.JIFSimpleFactory;
import control.Sessao;
import util.StatusBar;
import view.admin.*;


/**
 *
 * @author Henrique
 */
public class JFPrincipalUsuario extends JFrame {
    
    private Pessoa usuarioLogado;
    private StatusBar statusBar;
    
    /** Creates new form JFPrincipalUsuario */
    public JFPrincipalUsuario() {
        this.usuarioLogado = Sessao.getInstance().getUsuarioLogado();
        initComponents();
        statusBar = new StatusBar();
        this.status.add(statusBar);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCentro = new javax.swing.JPanel();
        jtpCentroOeste = new javax.swing.JPanel();
        jtpCentroNorte = new javax.swing.JPanel();
        jtbCentroSul = new javax.swing.JPanel();
        status = new javax.swing.JPanel();
        jtpCentroLeste = new javax.swing.JPanel();
        jDesktopPane = new javax.swing.JDesktopPane();
        jtbSuperior = new javax.swing.JToolBar();
        btnChamado = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jmbPrincipalUsuario = new javax.swing.JMenuBar();
        jmSistema = new javax.swing.JMenu();
        jmiSair = new javax.swing.JMenuItem();
        jmChamado = new javax.swing.JMenu();
        jmiAbertura = new javax.swing.JMenuItem();
        jmiControle = new javax.swing.JMenuItem();
        jmAjuda = new javax.swing.JMenu();
        jmiSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(Versao.TITULO);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new java.awt.Dimension(343, 87));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlCentro.setBackground(new java.awt.Color(204, 204, 204));
        pnlCentro.setLayout(new java.awt.BorderLayout());
        pnlCentro.add(jtpCentroOeste, java.awt.BorderLayout.LINE_START);
        pnlCentro.add(jtpCentroNorte, java.awt.BorderLayout.PAGE_START);

        jtbCentroSul.setLayout(new java.awt.BorderLayout());

        status.setLayout(new java.awt.BorderLayout());
        jtbCentroSul.add(status, java.awt.BorderLayout.EAST);

        pnlCentro.add(jtbCentroSul, java.awt.BorderLayout.PAGE_END);
        pnlCentro.add(jtpCentroLeste, java.awt.BorderLayout.EAST);

        jDesktopPane.setBackground(new java.awt.Color(153, 153, 153));
        pnlCentro.add(jDesktopPane, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlCentro, java.awt.BorderLayout.CENTER);
        pnlCentro.getAccessibleContext().setAccessibleParent(pnlCentro);

        jtbSuperior.setRollover(true);

        btnChamado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/i48x48/atendente3.png"))); // NOI18N
        btnChamado.setFocusable(false);
        btnChamado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChamado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChamado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChamadoActionPerformed(evt);
            }
        });
        jtbSuperior.add(btnChamado);

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/i48x48/sair.png"))); // NOI18N
        btnSair.setFocusable(false);
        btnSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jtbSuperior.add(btnSair);

        getContentPane().add(jtbSuperior, java.awt.BorderLayout.PAGE_START);

        jmSistema.setText("Sistema");

        jmiSair.setText("Sair");
        jmiSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSairActionPerformed(evt);
            }
        });
        jmSistema.add(jmiSair);

        jmbPrincipalUsuario.add(jmSistema);

        jmChamado.setText("Chamado");
        jmChamado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmChamadoActionPerformed(evt);
            }
        });

        jmiAbertura.setText("Abertura");
        jmiAbertura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAberturaActionPerformed(evt);
            }
        });
        jmChamado.add(jmiAbertura);

        jmiControle.setText("Controle");
        jmiControle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiControleActionPerformed(evt);
            }
        });
        jmChamado.add(jmiControle);

        jmbPrincipalUsuario.add(jmChamado);

        jmAjuda.setText("Ajuda");

        jmiSobre.setText("Sobre");
        jmiSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSobreActionPerformed(evt);
            }
        });
        jmAjuda.add(jmiSobre);

        jmbPrincipalUsuario.add(jmAjuda);

        setJMenuBar(jmbPrincipalUsuario);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-900)/2, (screenSize.height-597)/2, 900, 597);
    }// </editor-fold>//GEN-END:initComponents

    // Botão referente a abertura de Chamado
private void btnChamadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChamadoActionPerformed
    abrirJIFChamado();
}//GEN-LAST:event_btnChamadoActionPerformed

private void jmChamadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmChamadoActionPerformed
    
}//GEN-LAST:event_jmChamadoActionPerformed

private void jmiAberturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAberturaActionPerformed
    JDAbrirChamado jdAbrirChamado = new JDAbrirChamado(this, true,
                this.usuarioLogado);
}//GEN-LAST:event_jmiAberturaActionPerformed

private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    fecharAplicacao();
}//GEN-LAST:event_formWindowClosing

    private void jmiSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSairActionPerformed
        fecharAplicacao();
    }//GEN-LAST:event_jmiSairActionPerformed

    private void jmiSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSobreActionPerformed
        JOptionPane.showMessageDialog(null,
                Versao.SOBRE,                
                Versao.SOBRE_VER,
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jmiSobreActionPerformed

    private void jmiControleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiControleActionPerformed
        abrirJIFChamado();
    }//GEN-LAST:event_jmiControleActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        fecharAplicacao();
    }//GEN-LAST:event_btnSairActionPerformed

    /**
     * Feito por Felipe Antonio em 03/03/2012
     */
    private void fecharAplicacao() {
        int n = JOptionPane.showConfirmDialog(rootPane,
                "Deseja sair do sistema? ",
                "Sair do sistema",
                JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
/*
    end - felipe antonio - 03/03/2012
*/
    private void addJIF(JInternalFrame jif) {
        jDesktopPane.add(jif);
        try {
            jif.setMaximum(rootPaneCheckingEnabled);
            jif.setVisible(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(JFPrincipalUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
   
    private void addFrame(Class classe) {
        boolean isCriado = true;

        // Se não houver nenhum JIF aberto ele cria um JIF
        if (jDesktopPane.getSelectedFrame() == null) {
            /* Através do simple factory eu reduzo o acoplamento do código
             *  melhorando a performance e manutenção */
            addJIF(JIFSimpleFactory.getJIF(classe));
            // Caso contrário..
        } else {
            JOptionPane.showMessageDialog(null, "Feche o controle atual e tente novamente.");
        }
        System.gc();
    }

    private void abrirJIFChamado() {
        addFrame(JIFChamadoUsuario.class);
    }     
    
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChamado;
    private javax.swing.JButton btnSair;
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JMenu jmAjuda;
    private javax.swing.JMenu jmChamado;
    private javax.swing.JMenu jmSistema;
    private javax.swing.JMenuBar jmbPrincipalUsuario;
    private javax.swing.JMenuItem jmiAbertura;
    private javax.swing.JMenuItem jmiControle;
    private javax.swing.JMenuItem jmiSair;
    private javax.swing.JMenuItem jmiSobre;
    private javax.swing.JPanel jtbCentroSul;
    private javax.swing.JToolBar jtbSuperior;
    private javax.swing.JPanel jtpCentroLeste;
    private javax.swing.JPanel jtpCentroNorte;
    private javax.swing.JPanel jtpCentroOeste;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel status;
    // End of variables declaration//GEN-END:variables



}