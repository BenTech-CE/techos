
package br.edu.agenda.visao;

import br.edu.agenda.util.Tabela;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;

//Como essa classe FormPadrão só foi feita para servir de base para outras, ela é abstrata, ou seja, não pode ser instanciada, somente herdada!
public abstract class FormPadrao extends javax.swing.JInternalFrame {

    //Métodos abstratos que serão implementados pela classe filha.
    //Toda classe que herdar, fará a implementação desse método, mas ele não pode ser usado pelo FormPadrão.
    public abstract void inicializarComponentes();
    public abstract void salvarVisao();
    public abstract void criarTabela();
    public abstract void excluirVisao();
    public abstract void consultaVisao();
    public abstract void atualizarFormulario();
    
    //Criando as variávesi para os componentes do painel de consulta.
    
    // Para a tabela
    DefaultTableModel modelo;
    
    //Construtor
    public FormPadrao() {
        super("", true, true, true);
        
        initComponents();
        habilitaBotoes(true);
        inicializarComponentes();
        habilitaCampos(false);
        
        modelo = new DefaultTableModel();
        criarTabela();
        
        //jLabel para consulta.

        
        //jTextField para consulta.
        
        jtfConsulta.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                consultaVisao();
            }
        });
        
        tabela.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                atualizarFormulario();
                
                jbExcluir.setEnabled(true);
                jbAlterar.setEnabled(true);
            }
        });
        
        tabela.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                atualizarFormulario();
                
                jbExcluir.setEnabled(true);
                jbAlterar.setEnabled(true);
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnBotoes = new javax.swing.JPanel();
        jbNovo = new javax.swing.JButton();
        jbAlterar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbFechar = new javax.swing.JButton();
        jpnFormulario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfID = new javax.swing.JTextField();
        jtfDescricao = new javax.swing.JTextField();
        jpnConsulta = new javax.swing.JPanel();
        jlConsulta = new javax.swing.JLabel();
        jtfConsulta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/agenda/img/tipo.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(864, 548));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jpnBotoes.setBackground(new java.awt.Color(36, 37, 38));
        jpnBotoes.setPreferredSize(new java.awt.Dimension(862, 53));

        jbNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/agenda/img/novo.png"))); // NOI18N
        jbNovo.setMnemonic('N');
        jbNovo.setText("Novo");
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        jbAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/agenda/img/edit.png"))); // NOI18N
        jbAlterar.setMnemonic('A');
        jbAlterar.setText("Alterar");
        jbAlterar.setEnabled(false);
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });

        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/agenda/img/remove.png"))); // NOI18N
        jbExcluir.setMnemonic('E');
        jbExcluir.setText("Excluir");
        jbExcluir.setEnabled(false);
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/agenda/img/salvar.png"))); // NOI18N
        jbSalvar.setMnemonic('S');
        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/agenda/img/cancel.png"))); // NOI18N
        jbCancelar.setMnemonic('C');
        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/agenda/img/Fechar.png"))); // NOI18N
        jbFechar.setMnemonic('F');
        jbFechar.setText("Fechar");
        jbFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnBotoesLayout = new javax.swing.GroupLayout(jpnBotoes);
        jpnBotoes.setLayout(jpnBotoesLayout);
        jpnBotoesLayout.setHorizontalGroup(
            jpnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBotoesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jbNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbExcluir)
                .addGap(132, 132, 132)
                .addComponent(jbSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
                .addComponent(jbFechar)
                .addGap(10, 10, 10))
        );
        jpnBotoesLayout.setVerticalGroup(
            jpnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNovo)
                    .addComponent(jbAlterar)
                    .addComponent(jbExcluir)
                    .addComponent(jbSalvar)
                    .addComponent(jbCancelar)
                    .addComponent(jbFechar))
                .addGap(15, 15, 15))
        );

        getContentPane().add(jpnBotoes);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/agenda/img/id.png"))); // NOI18N
        jLabel1.setText("ID");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/agenda/img/descricao.png"))); // NOI18N
        jLabel2.setText("Descrição");

        jtfID.setEnabled(false);
        jtfID.putClientProperty(FlatClientProperties.STYLE, "arc: 12");
        jtfID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfIDActionPerformed(evt);
            }
        });

        jtfDescricao.setEnabled(false);
        jtfDescricao.putClientProperty(FlatClientProperties.STYLE, "arc: 12");

        javax.swing.GroupLayout jpnFormularioLayout = new javax.swing.GroupLayout(jpnFormulario);
        jpnFormulario.setLayout(jpnFormularioLayout);
        jpnFormularioLayout.setHorizontalGroup(
            jpnFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFormularioLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jpnFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jtfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(383, 383, 383))
        );
        jpnFormularioLayout.setVerticalGroup(
            jpnFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFormularioLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jpnFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(154, Short.MAX_VALUE))
        );

        getContentPane().add(jpnFormulario);

        jpnConsulta.setBackground(new java.awt.Color(0, 93, 146));

        jlConsulta.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jlConsulta.setText("Consulta:");

        jtfConsulta.setToolTipText("Digite a(s) palavra-chave(s) a ser consultada.");

        tabela.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tabela.setModel(new DefaultTableModel());
        tabela.setRowHeight(25);
        tabela.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabela);

        javax.swing.GroupLayout jpnConsultaLayout = new javax.swing.GroupLayout(jpnConsulta);
        jpnConsulta.setLayout(jpnConsultaLayout);
        jpnConsultaLayout.setHorizontalGroup(
            jpnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnConsultaLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jpnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
                    .addGroup(jpnConsultaLayout.createSequentialGroup()
                        .addComponent(jlConsulta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfConsulta)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jpnConsultaLayout.setVerticalGroup(
            jpnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnConsultaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jpnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlConsulta)
                    .addComponent(jtfConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jpnConsulta);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        habilitaBotoes(false);
        habilitaCampos(true);
        limpaCampo();
        jtfDescricao.requestFocus();
        
        jbExcluir.setEnabled(false);
        jbAlterar.setEnabled(false);
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        //Ação de fechar.
        dispose();
    }//GEN-LAST:event_jbFecharActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed
        habilitaBotoes(false);
        habilitaCampos(true);
        jtfDescricao.requestFocus();
    }//GEN-LAST:event_jbAlterarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        int resultado = JOptionPane.showConfirmDialog(null, "Confirmar exclusão?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (resultado == JOptionPane.YES_OPTION) {
            excluirVisao();
            consultaVisao();
            limpaCampo();

            jbExcluir.setEnabled(false);
            jbAlterar.setEnabled(false);

        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        if (validaCampos()) {
            habilitaBotoes(true);
            habilitaCampos(false);

            salvarVisao();

            if (jtfID.getText().equals("")) {
                jbExcluir.setEnabled(false);
                jbAlterar.setEnabled(false);
                limpaCampo();
            }
            consultaVisao();
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        habilitaBotoes(true);
        habilitaCampos(false);
        
        if (jtfID.getText().equals("")) {
            jbExcluir.setEnabled(false);
            jbAlterar.setEnabled(false);
            limpaCampo();
        }
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jtfIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfIDActionPerformed
    //Método para habilitar e desabilitar botões no formulário.
    public void habilitaBotoes(boolean estado){
        jbNovo.setEnabled(estado);
        //jbExcluir.setEnabled(estado);
        //jbAlterar.setEnabled(estado);
        //Negando o estado!
        jbSalvar.setEnabled(!estado);
        jbCancelar.setEnabled(!estado);
    }
     
    //Método para habilitar e desabilitar acesso aos campos de edição.
    public abstract void habilitaCampos(boolean estado);
     
    //Método para limpar os campos do formulário.
    public abstract void limpaCampo();
    
    //Método para verificar se os campos foram preenchidos corretamente.
    public abstract boolean validaCampos();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbCancelar;
    public javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JLabel jlConsulta;
    private javax.swing.JPanel jpnBotoes;
    public javax.swing.JPanel jpnConsulta;
    public javax.swing.JPanel jpnFormulario;
    public javax.swing.JTextField jtfConsulta;
    public javax.swing.JTextField jtfDescricao;
    public javax.swing.JTextField jtfID;
    public javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
