
package br.edu.agenda.visao;

import br.edu.desktop.tela.Desktop;
import br.edu.util.FuncoesUteis;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class AgendaVisao extends javax.swing.JFrame {

    private Image origFundo;
    private Image fundo;
    
    //Construtor
    public AgendaVisao() {
        System.setProperty("flatlaf.menuBarEmbedded", "false");
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICON, false);
        
        initComponents();
        
        setIconImage(new ImageIcon(getClass().getResource("/br/edu/desktop/img/contatos.png")).getImage());
        
        // Substituindo o fundo do JDesktopPane
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int w = (int)screenSize.getWidth();
        int h = (int)screenSize.getHeight();
        
        try {
            origFundo = ImageIO.read(AgendaVisao.class.getResourceAsStream("/br/edu/agenda/img/agendafundo.jpg"));
            fundo = origFundo.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            // Tratando a exceção de leitura de arquivo.
            System.out.println("Não foi possível ler a imagem de fundo selecionada.");
        }
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    public void redimensionarFundo() {
        //System.out.println("Altura: " + getHeight());
        fundo = origFundo.getScaledInstance(getWidth(), getHeight(), Image.SCALE_FAST);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktop = new javax.swing.JDesktopPane() {
            @Override
            protected void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                graphics.drawImage(fundo, 0, 0, null);
            }
        };
        jmbBarraMenu = new javax.swing.JMenuBar();
        jmArquivo = new javax.swing.JMenu();
        jmiContatos = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmCadastros = new javax.swing.JMenu();
        jmiTipoContato = new javax.swing.JMenuItem();
        jmConsulta = new javax.swing.JMenu();
        jmSobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agenda de Contatos");
        setMinimumSize(new java.awt.Dimension(940, 650));
        setPreferredSize(new java.awt.Dimension(940, 650));
        setSize(new java.awt.Dimension(940, 650));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jDesktop.setBackground(new java.awt.Color(5, 5, 5));
        jDesktop.setForeground(new java.awt.Color(5, 5, 5));

        javax.swing.GroupLayout jDesktopLayout = new javax.swing.GroupLayout(jDesktop);
        jDesktop.setLayout(jDesktopLayout);
        jDesktopLayout.setHorizontalGroup(
            jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopLayout.setVerticalGroup(
            jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jmArquivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/agenda/img/arquivo.png"))); // NOI18N
        jmArquivo.setMnemonic('A');
        jmArquivo.setText("Arquivo");

        jmiContatos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiContatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/agenda/img/novocontato.png"))); // NOI18N
        jmiContatos.setText("Contatos");
        jmiContatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiContatosActionPerformed(evt);
            }
        });
        jmArquivo.add(jmiContatos);
        jmArquivo.add(jSeparator1);

        jmCadastros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/agenda/img/novo.png"))); // NOI18N
        jmCadastros.setMnemonic('C');
        jmCadastros.setText("Cadastros");

        jmiTipoContato.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiTipoContato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/agenda/img/tipo.png"))); // NOI18N
        jmiTipoContato.setText("Tipo de Contato");
        jmiTipoContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTipoContatoActionPerformed(evt);
            }
        });
        jmCadastros.add(jmiTipoContato);

        jmArquivo.add(jmCadastros);

        jmbBarraMenu.add(jmArquivo);

        jmConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/agenda/img/contato.png"))); // NOI18N
        jmConsulta.setText("Consultar");
        jmConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmConsultaMouseClicked(evt);
            }
        });
        jmbBarraMenu.add(jmConsulta);

        jmSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/agenda/img/me.png"))); // NOI18N
        jmSobre.setMnemonic('S');
        jmSobre.setText("Sobre");
        jmSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmSobreMouseClicked(evt);
            }
        });
        jmbBarraMenu.add(jmSobre);

        setJMenuBar(jmbBarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktop)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmiContatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiContatosActionPerformed
        //Instanciando um novo objeto do tipo FormPadrao.
        ContatoVisao tela = new ContatoVisao();
        //Adicionando a tela ao Desktop.
        jDesktop.add(tela);
        
        FuncoesUteis.centralizarTela(tela, jDesktop);
        
        //Setando a visibilidade da tela como verdadeira.
        tela.setVisible(true);
    }//GEN-LAST:event_jmiContatosActionPerformed

    private void jmiTipoContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTipoContatoActionPerformed
        //Instanciando um novo objeto do tipo FormPadrao.
        TipoContatoVisao tela = new TipoContatoVisao();
        //Adicionando a tela ao Desktop.
        jDesktop.add(tela);

        FuncoesUteis.centralizarTela(tela, jDesktop);

        //Setando a visibilidade da tela como verdadeira.
        tela.setVisible(true);
    }//GEN-LAST:event_jmiTipoContatoActionPerformed

    // Redimensiona o fundo automaticamente em caso de qualquer redimensionamento na janela.
    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        redimensionarFundo();
    }//GEN-LAST:event_formComponentResized

    private void jmSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmSobreMouseClicked
        SobreVisao sobre = new SobreVisao(this, true);
        
        sobre.setVisible(true);
    }//GEN-LAST:event_jmSobreMouseClicked

    private void jmConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmConsultaMouseClicked
        ConsultaVisao consulta = new ConsultaVisao();
        jDesktop.add(consulta);
        FuncoesUteis.centralizarTela(consulta, jDesktop);
        
        consulta.setVisible(true);
    }//GEN-LAST:event_jmConsultaMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new Desktop().setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgendaVisao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgendaVisao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgendaVisao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgendaVisao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        // Descomentar para ativar o flatlaf
        FlatMacDarkLaf.setup();
        
        // Ainda em flatlaf, se quiser separar o título do programa com as opções de menu
        System.setProperty("flatlaf.menuBarEmbedded", "false");
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AgendaVisao p = new AgendaVisao();
                p.setVisible(true);
                p.redimensionarFundo();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktop;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu jmArquivo;
    private javax.swing.JMenu jmCadastros;
    private javax.swing.JMenu jmConsulta;
    private javax.swing.JMenu jmSobre;
    private javax.swing.JMenuBar jmbBarraMenu;
    private javax.swing.JMenuItem jmiContatos;
    private javax.swing.JMenuItem jmiTipoContato;
    // End of variables declaration//GEN-END:variables
}
