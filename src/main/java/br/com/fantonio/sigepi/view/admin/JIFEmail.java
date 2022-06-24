/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JIFEmail.java
 *
 * Created on 07/10/2011, 09:06:18
 */
package br.com.fantonio.sigepi.view.admin;

import br.com.fantonio.sigepi.control.EmailControl;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import br.com.fantonio.sigepi.model.EntidadeSimpleFactory;
import br.com.fantonio.sigepi.model.Email;


/**
 *
 * @author Felipe
 */
public class JIFEmail extends JInternalFrame {
    
    private EmailControl controller;
    private boolean alterar, alterado;
    private int id;
    
        
    /** Creates new form JIFEmail */
    public JIFEmail() {
        id =0;        
        controller = EmailControl.getInstance();
        alterar = false;
        initComponents();        
        txtBusca.setFocusable(true);
        selecionarAba(0);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlLista = new javax.swing.JPanel();
        pnlLeste = new javax.swing.JPanel();
        pnlOeste = new javax.swing.JPanel();
        pnlSuperior = new javax.swing.JPanel();
        pnlBusca = new javax.swing.JPanel();
        cbbBusca = new javax.swing.JComboBox();
        btnBuscar = new javax.swing.JButton();
        txtBusca = new javax.swing.JTextField();
        pnlJtb = new javax.swing.JPanel();
        jtbSuperior = new javax.swing.JToolBar();
        btnInserir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnAssociar = new javax.swing.JButton();
        pnlSuperiorCentro = new javax.swing.JPanel();
        pnlSuperiorCentroDivisor = new javax.swing.JPanel();
        pnlSul = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pnlCadBasico = new javax.swing.JPanel();
        pnlCadastroCampos = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        ptxtSenha = new javax.swing.JPasswordField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaDescricao = new javax.swing.JTextArea();
        lblDescricao = new javax.swing.JLabel();
        btnMostrarSenha = new javax.swing.JButton();
        pnlEmailBotoes = new javax.swing.JPanel();
        btnVoltar = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconifiable(true);
        setTitle("Controle das contas de e-mail");
        setPreferredSize(new java.awt.Dimension(745, 586));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        pnlLista.setLayout(new java.awt.BorderLayout());
        pnlLista.add(pnlLeste, java.awt.BorderLayout.EAST);
        pnlLista.add(pnlOeste, java.awt.BorderLayout.WEST);

        pnlSuperior.setMinimumSize(new java.awt.Dimension(364, 50));
        pnlSuperior.setPreferredSize(new java.awt.Dimension(613, 50));
        pnlSuperior.setLayout(new java.awt.BorderLayout());

        pnlBusca.setMaximumSize(new java.awt.Dimension(430, 20));
        pnlBusca.setMinimumSize(new java.awt.Dimension(430, 20));
        pnlBusca.setPreferredSize(new java.awt.Dimension(430, 20));
        pnlBusca.setLayout(new javax.swing.BoxLayout(pnlBusca, javax.swing.BoxLayout.LINE_AXIS));

        cbbBusca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Endereço" }));
        cbbBusca.setMaximumSize(new java.awt.Dimension(200, 20));
        cbbBusca.setMinimumSize(new java.awt.Dimension(200, 20));
        cbbBusca.setPreferredSize(new java.awt.Dimension(200, 20));
        pnlBusca.add(cbbBusca);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/i16x16/buscar2.png"))); // NOI18N
        btnBuscar.setToolTipText("Procurar");
        btnBuscar.setMaximumSize(new java.awt.Dimension(30, 20));
        btnBuscar.setMinimumSize(new java.awt.Dimension(30, 20));
        btnBuscar.setOpaque(false);
        btnBuscar.setPreferredSize(new java.awt.Dimension(30, 20));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        pnlBusca.add(btnBuscar);

        txtBusca.setMaximumSize(new java.awt.Dimension(200, 20));
        txtBusca.setMinimumSize(new java.awt.Dimension(200, 20));
        txtBusca.setPreferredSize(new java.awt.Dimension(200, 20));
        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscaKeyPressed(evt);
            }
        });
        pnlBusca.add(txtBusca);

        pnlSuperior.add(pnlBusca, java.awt.BorderLayout.EAST);

        pnlJtb.setLayout(new java.awt.BorderLayout());

        jtbSuperior.setBorder(null);
        jtbSuperior.setFloatable(false);
        jtbSuperior.setRollover(true);
        jtbSuperior.setOpaque(false);

        btnInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/i16x16/inserir.png"))); // NOI18N
        btnInserir.setToolTipText("Incluir registro");
        btnInserir.setFocusable(false);
        btnInserir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInserir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtbSuperior, org.jdesktop.beansbinding.ELProperty.create("false"), btnInserir, org.jdesktop.beansbinding.BeanProperty.create("borderPainted"));
        bindingGroup.addBinding(binding);

        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });
        jtbSuperior.add(btnInserir);

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/i16x16/alterar.png"))); // NOI18N
        btnAlterar.setToolTipText("Alterar registro");
        btnAlterar.setFocusable(false);
        btnAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtbSuperior, org.jdesktop.beansbinding.ELProperty.create("false"), btnAlterar, org.jdesktop.beansbinding.BeanProperty.create("borderPainted"));
        bindingGroup.addBinding(binding);

        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jtbSuperior.add(btnAlterar);

        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/i16x16/remover.png"))); // NOI18N
        btnRemover.setToolTipText("Remover registro");
        btnRemover.setFocusable(false);
        btnRemover.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRemover.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtbSuperior, org.jdesktop.beansbinding.ELProperty.create("false"), btnRemover, org.jdesktop.beansbinding.BeanProperty.create("borderPainted"));
        bindingGroup.addBinding(binding);

        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        jtbSuperior.add(btnRemover);

        btnAssociar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/i16x16/user3.png"))); // NOI18N
        btnAssociar.setToolTipText("Associar pessoa a um email");
        btnAssociar.setFocusable(false);
        btnAssociar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAssociar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtbSuperior, org.jdesktop.beansbinding.ELProperty.create("false"), btnAssociar, org.jdesktop.beansbinding.BeanProperty.create("borderPainted"));
        bindingGroup.addBinding(binding);

        btnAssociar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssociarActionPerformed(evt);
            }
        });
        jtbSuperior.add(btnAssociar);

        pnlJtb.add(jtbSuperior, java.awt.BorderLayout.CENTER);

        pnlSuperior.add(pnlJtb, java.awt.BorderLayout.WEST);

        pnlSuperiorCentro.setLayout(new javax.swing.BoxLayout(pnlSuperiorCentro, javax.swing.BoxLayout.LINE_AXIS));

        pnlSuperiorCentroDivisor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlSuperiorCentroDivisor.setMaximumSize(new java.awt.Dimension(1000, 20));
        pnlSuperiorCentroDivisor.setOpaque(false);
        pnlSuperiorCentroDivisor.setPreferredSize(new java.awt.Dimension(1000, 20));
        pnlSuperiorCentro.add(pnlSuperiorCentroDivisor);

        pnlSuperior.add(pnlSuperiorCentro, java.awt.BorderLayout.CENTER);

        pnlLista.add(pnlSuperior, java.awt.BorderLayout.PAGE_START);
        pnlLista.add(pnlSul, java.awt.BorderLayout.SOUTH);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(controller.getTableModel());
        jTable1.setRowHeight(20);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        pnlLista.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Lista", pnlLista);

        pnlCadBasico.setLayout(new java.awt.BorderLayout());

        lblEndereco.setText("Endereço");

        txtEndereco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtEnderecoMousePressed(evt);
            }
        });
        txtEndereco.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtEnderecoCaretUpdate(evt);
            }
        });
        txtEndereco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEnderecoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEnderecoFocusLost(evt);
            }
        });

        lblSenha.setText("Senha");

        ptxtSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ptxtSenhaMousePressed(evt);
            }
        });
        ptxtSenha.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                ptxtSenhaCaretUpdate(evt);
            }
        });
        ptxtSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ptxtSenhaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ptxtSenhaFocusLost(evt);
            }
        });

        txaDescricao.setColumns(20);
        txaDescricao.setLineWrap(true);
        txaDescricao.setRows(5);
        txaDescricao.setWrapStyleWord(true);
        txaDescricao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txaDescricaoMousePressed(evt);
            }
        });
        txaDescricao.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txaDescricaoCaretUpdate(evt);
            }
        });
        txaDescricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txaDescricaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txaDescricaoFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(txaDescricao);

        lblDescricao.setText("Descrição");

        btnMostrarSenha.setText("Mostrar");
        btnMostrarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEndereco)
                    .addComponent(lblSenha)
                    .addComponent(lblDescricao))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ptxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(btnMostrarSenha))
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ptxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSenha)
                            .addComponent(btnMostrarSenha)))
                    .addComponent(lblEndereco))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescricao))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlCadastroCamposLayout = new javax.swing.GroupLayout(pnlCadastroCampos);
        pnlCadastroCampos.setLayout(pnlCadastroCamposLayout);
        pnlCadastroCamposLayout.setHorizontalGroup(
            pnlCadastroCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastroCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(473, Short.MAX_VALUE))
        );
        pnlCadastroCamposLayout.setVerticalGroup(
            pnlCadastroCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastroCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(314, Short.MAX_VALUE))
        );

        pnlCadBasico.add(pnlCadastroCampos, java.awt.BorderLayout.CENTER);

        pnlEmailBotoes.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnGravar.setText("Gravar");
        btnGravar.setMaximumSize(new java.awt.Dimension(61, 23));
        btnGravar.setMinimumSize(new java.awt.Dimension(61, 23));
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlEmailBotoesLayout = new javax.swing.GroupLayout(pnlEmailBotoes);
        pnlEmailBotoes.setLayout(pnlEmailBotoesLayout);
        pnlEmailBotoesLayout.setHorizontalGroup(
            pnlEmailBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEmailBotoesLayout.createSequentialGroup()
                .addContainerGap(617, Short.MAX_VALUE)
                .addComponent(btnGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlEmailBotoesLayout.setVerticalGroup(
            pnlEmailBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmailBotoesLayout.createSequentialGroup()
                .addGroup(pnlEmailBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnGravar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCadBasico.add(pnlEmailBotoes, java.awt.BorderLayout.PAGE_END);

        jTabbedPane1.addTab("Informações básicas", pnlCadBasico);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        if (getAlterado()) {
            int n = JOptionPane.showConfirmDialog(null,
                    "Deseja gravar as alterações efetuadas!",
                    "Confirmação",
                    JOptionPane.YES_NO_CANCEL_OPTION);
        
            if (n != JOptionPane.CANCEL_OPTION) {
                if (n == JOptionPane.YES_OPTION) {
                    alterarEmail();
                    dispose();
                } else {
                    dispose();
                }
            }             
        } else {
            dispose();
        }       
    }//GEN-LAST:event_formInternalFrameClosing

    private void txtEnderecoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtEnderecoCaretUpdate
        liberarBtnGravar();
    }//GEN-LAST:event_txtEnderecoCaretUpdate

    private void ptxtSenhaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_ptxtSenhaCaretUpdate
        liberarBtnGravar();
    }//GEN-LAST:event_ptxtSenhaCaretUpdate

    private void txaDescricaoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txaDescricaoCaretUpdate
        liberarBtnGravar();
    }//GEN-LAST:event_txaDescricaoCaretUpdate

    private void txtEnderecoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEnderecoFocusGained
        txtEndereco.setBackground(new Color(255, 255, 220));
    }//GEN-LAST:event_txtEnderecoFocusGained

    private void txtEnderecoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEnderecoFocusLost
        txtEndereco.setBackground(Color.WHITE);
    }//GEN-LAST:event_txtEnderecoFocusLost

    private void ptxtSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ptxtSenhaFocusGained
        ptxtSenha.setBackground(new Color(255, 255, 220));
    }//GEN-LAST:event_ptxtSenhaFocusGained

    private void ptxtSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ptxtSenhaFocusLost
        ptxtSenha.setBackground(Color.WHITE);
    }//GEN-LAST:event_ptxtSenhaFocusLost

    private void txaDescricaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txaDescricaoFocusGained
        txaDescricao.setBackground(new Color(255, 255, 220));
    }//GEN-LAST:event_txaDescricaoFocusGained

    private void txaDescricaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txaDescricaoFocusLost
        txaDescricao.setBackground(Color.WHITE);
    }//GEN-LAST:event_txaDescricaoFocusLost

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        if (!isAlterar()) {
            gravarEmail();
        } else {
            alterarEmail();
        }    
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        mudarFrame();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void txtEnderecoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEnderecoMousePressed
        setAlterado(true);
    }//GEN-LAST:event_txtEnderecoMousePressed

    private void ptxtSenhaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ptxtSenhaMousePressed
        setAlterado(true);
    }//GEN-LAST:event_ptxtSenhaMousePressed

    private void txaDescricaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txaDescricaoMousePressed
        setAlterado(true);
    }//GEN-LAST:event_txaDescricaoMousePressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            associarPessoasAEmail();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        selecionarAba(1);
        setAlterar(false);
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        popularCampos();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        removerEmail();
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnAssociarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssociarActionPerformed
        associarPessoasAEmail();
    }//GEN-LAST:event_btnAssociarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) { 
            buscar(); 
        }
    }//GEN-LAST:event_txtBuscaKeyPressed

    private void btnMostrarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarSenhaActionPerformed
        JOptionPane.showMessageDialog(null, ptxtSenha.getText());
    }//GEN-LAST:event_btnMostrarSenhaActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER  : popularCampos();
                                      break;
            case KeyEvent.VK_DELETE : removerEmail();
                                      break;        
        }  
    }//GEN-LAST:event_jTable1KeyPressed

    private void associarPessoasAEmail() {        
        Email email = null;
        int id = 0;
        id = controller.getTableModel().getIdAt(getLinha());
        try {
            email = controller.getEmail(id);
        } catch (Exception ex) {
            Logger.getLogger(JIFEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
        JDAssociarPessoaAEmail associar = new JDAssociarPessoaAEmail(null, true, email,
                                            controller.getListPessoa());    
    }    
    
    private void mudarFrame() {
        if (getAlterado()) {
            int n = JOptionPane.showConfirmDialog(null,
                    "Deseja gravar as alterações efetuadas!",
                    "Confirmação",
                    JOptionPane.YES_NO_CANCEL_OPTION);
        
            if (n != JOptionPane.CANCEL_OPTION) {
                if (n == JOptionPane.YES_OPTION) {
                    alterarEmail();
                    setAlterar(false);
                    setAlterado(false);
                } else {
                    selecionarAba(0);
                    setAlterado(false);
                    limparCampos();
                }
            }             
        } else {
            limparCampos();            
            selecionarAba(0);            
        }       
    }        
    
    private void buscar() {
        controller.buscar(txtBusca.getText(), cbbBusca.getSelectedIndex());
    }
    /**
     * Este método foi feito para facilitar a leitura do código.<br>
     * Ele retorna o índice da linha orientado a zero e em qualquer ordem de apresentação.
     * @return int linha selecionada  
     */
    private int getLinha() {
        return jTable1.convertRowIndexToModel(jTable1.getSelectedRow());
    }
    
    private void limparCampos() {
        txtEndereco.setText("");
        ptxtSenha.setText("");
        txaDescricao.setText("");
    }
    
    private void popularCampos() {
        Email email = controller.getTableModel().getEmail(getLinha());
        txtEndereco.setText(email.getEndereco());
        ptxtSenha.setText(email.getSenha());
        txaDescricao.setText(email.getDescricao());
                
        setId(email.getId());
        setAlterar(true);
        selecionarAba(1);
    }
    
        
    private void liberarBtnGravar() {
        if (
                (txtEndereco.getText().length() > 0 ) && 
                (ptxtSenha.getText().length() > 0) &&
                (txaDescricao.getText().length() > 0)                  
           ) 
        {
            btnGravar.setEnabled(true);
        } else
        {
            btnGravar.setEnabled(false);
        }       
    }
    
    private Email atualizarEmail(Email email) throws Exception  {
        // Atualiza o objeto
        email.setEndereco(txtEndereco.getText());
        email.setSenha(ptxtSenha.getText());
        email.setDescricao(txaDescricao.getText());
        
        setAlterado(false);
               
        return email;
        
    }
    private void gravarEmail() {
        Email email =(Email)EntidadeSimpleFactory.getEntity(Email.class);
        try {
            controller.addEmail(atualizarEmail(email));
            JOptionPane.showMessageDialog(null, "Registro gravado com sucesso!");
            limparCampos();
            selecionarAba(0);
            setAlterar(false);            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }    
    
    private void alterarEmail() {
        try {                        
            controller.alterarEmail(atualizarEmail(controller.getDAO().get(getId())));            
            setAlterar(false);            
            setId(0);
            JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");            
            selecionarAba(0);
            limparCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }                
                
    private void removerEmail() {
        int n = JOptionPane.showConfirmDialog(null,
                    "Esta operação não poderá ser desfeita!\nDeseja realmente excluir este registro?\n",
                    "Exclusão de registro",
                    JOptionPane.YES_NO_OPTION);
        
        if (n == JOptionPane.YES_OPTION) {
            try {
                controller.removerUsuario(getLinha());
            } catch (Exception ex) {
                Logger.getLogger(JIFEmail.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }    
    
    private void ajustarTamanhoColunas() {
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
    }
    
    private void selecionarAba(int aba) {
        switch (aba) {
            case 0 :    jTabbedPane1.setSelectedIndex(0);
                        jTabbedPane1.setEnabledAt(0, true);
                        jTabbedPane1.setEnabledAt(1, false);                        
                        break;
                
            case 1 :    jTabbedPane1.setSelectedIndex(1); 
                        txtEndereco.requestFocus();
                        jTabbedPane1.setEnabledAt(0, false);
                        jTabbedPane1.setEnabledAt(1, true);
                        break;
        }
    }       
    
    // Getters and setters
    private void setAlterar(boolean alterar) { this.alterar = alterar; }
    private boolean isAlterar() { return this.alterar; }
    private void setId(int id) { this.id = id; }
    private int getId() { return this.id; }
    private void setAlterado(boolean alterado) { this.alterado = alterado; }
    private boolean getAlterado() { return this.alterado; }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAssociar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnMostrarSenha;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox cbbBusca;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jtbSuperior;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPanel pnlBusca;
    private javax.swing.JPanel pnlCadBasico;
    private javax.swing.JPanel pnlCadastroCampos;
    private javax.swing.JPanel pnlEmailBotoes;
    private javax.swing.JPanel pnlJtb;
    private javax.swing.JPanel pnlLeste;
    private javax.swing.JPanel pnlLista;
    private javax.swing.JPanel pnlOeste;
    private javax.swing.JPanel pnlSul;
    private javax.swing.JPanel pnlSuperior;
    private javax.swing.JPanel pnlSuperiorCentro;
    private javax.swing.JPanel pnlSuperiorCentroDivisor;
    private javax.swing.JPasswordField ptxtSenha;
    private javax.swing.JTextArea txaDescricao;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextField txtEndereco;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
