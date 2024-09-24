package br.edu.login.tela;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.FlatClientProperties;
import br.edu.login.util.Usuario;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author GABRIEL
 */
public class TelaLogin extends javax.swing.JFrame {

    Usuario adm = new Usuario("bentech.ce@gmail.com", "Ben090824@");
    boolean b = false;
    ImageIcon eye = new ImageIcon(getClass().getResource("/br/edu/login/imagens/eye.png"));
    ImageIcon noeye = new ImageIcon(getClass().getResource("/br/edu/login/imagens/noeye.png"));

    public TelaLogin() {
        initComponents();
        setLocationRelativeTo(null);
        
        setIconImage(new ImageIcon(getClass().getResource("/br/edu/desktop/img/chmaior.png")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        sobre = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ajuda = new javax.swing.JLabel();
        eyepass = new javax.swing.JLabel();
        del = new javax.swing.JButton();
        emailLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        Email = new javax.swing.JTextField();
        downpass1 = new javax.swing.JLabel();
        downpass = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela de login - TechOS");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/login/imagens/techos.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 290, 50));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/login/imagens/bentech.png"))); // NOI18N
        sobre.setText("jLabel1");
        sobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sobreMouseClicked(evt);
            }
        });
        jPanel1.add(sobre, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 10, 89, 28));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/login/imagens/user.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 49, 131, 119));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ben");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 149, -1, 80));

        ajuda.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ajuda.setForeground(new java.awt.Color(255, 255, 255));
        ajuda.setText("Ajuda");
        ajuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ajudaMouseClicked(evt);
            }
        });
        jPanel1.add(ajuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 12, -1, -1));

        eyepass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/login/imagens/eye.png"))); // NOI18N
        eyepass.setToolTipText("");
        eyepass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eyepassMouseClicked(evt);
            }
        });
        jPanel1.add(eyepass, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 30, 40));

        del.setBackground(new java.awt.Color(51, 51, 51));
        del.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        del.setForeground(new java.awt.Color(255, 255, 255));
        del.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/login/imagens/trash.png"))); // NOI18N
        del.setBorder(null);
        del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delActionPerformed(evt);
            }
        });
        jPanel1.add(del, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 30, 30));

        emailLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(255, 255, 255));
        emailLabel.setText("E-mail:");
        jPanel1.add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 239, 60, 20));

        passLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        passLabel.setForeground(new java.awt.Color(255, 255, 255));
        passLabel.setText("Senha:");
        jPanel1.add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 269, -1, 32));

        password.setBackground(new java.awt.Color(51, 51, 51));
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setToolTipText("Insira a senha aqui.");
        password.setBorder(null);
        password.setCaretColor(new java.awt.Color(255, 255, 255));
        password.setEchoChar((char)8226);
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordKeyTyped(evt);
            }
        });
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 269, 140, 20));

        Email.setBackground(new java.awt.Color(51, 51, 51));
        Email.setForeground(new java.awt.Color(255, 255, 255));
        Email.setToolTipText("Insira o e-mail aqui.");
        Email.setBorder(null);
        Email.setCaretColor(new java.awt.Color(255, 255, 255));
        Email.setInheritsPopupMenu(true);
        jPanel1.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 239, 200, 20));

        downpass1.setForeground(new java.awt.Color(255, 255, 255));
        downpass1.setText("___________________________");
        jPanel1.add(downpass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 279, -1, -1));

        downpass.setForeground(new java.awt.Color(255, 255, 255));
        downpass.setText("_______________________________________");
        jPanel1.add(downpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 249, 200, -1));

        login.setBackground(new java.awt.Color(102, 102, 102));
        login.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("Login");
        login.setBorder(null);
        login.setBorderPainted(false);
        login.putClientProperty(FlatClientProperties.STYLE, "arc: 12");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel1.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 260, 40));

        jPanel1.putClientProperty(FlatClientProperties.STYLE, "arc: 12");
        jPanel1.setOpaque(false);

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 280, 370));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/login/imagens/bgq2.jpg"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 900, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 916, 608);
    }// </editor-fold>//GEN-END:initComponents

    private void login() {
        String email = Email.getText();
        String senha = String.copyValueOf(password.getPassword());

        if (email.equals(adm.getEmail()) && senha.equals(adm.getSenha())) {
            Verify v =new Verify(this, true);
            v.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "E-mail ou senha incorretos, por favor, tente novamente.");
        }
    }
                                      
    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        login();
    }
//GEN-LAST:event_loginActionPerformed

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
        int limitDisplay = 10;
        if (password.getText().length() > limitDisplay) {
            password.setText(password.getText().substring(0, limitDisplay));
        }
    }//GEN-LAST:event_passwordKeyPressed

    private void delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delActionPerformed
        Email.setText("");
        password.setText("");
    }//GEN-LAST:event_delActionPerformed

    private void eyepassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eyepassMouseClicked
        b = !b;
        if (b == true) {
            password.setEchoChar((char) 0);
            eyepass.setIcon(noeye);
        } else {
            password.setEchoChar((char) 8226);
            eyepass.setIcon(eye);
        }
    }//GEN-LAST:event_eyepassMouseClicked

    private void ajudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajudaMouseClicked
        JOptionPane.showMessageDialog(this, "Por favor, insira o e-mail e senha (limite de 10 caracteres) cadastrados na sua conta BenTech em seus respectivos campos. Você pode revelar a senha ao clicar no ícone do olho, logo ao lado de seu campo de texto, e deletar ambos os campos de e-mail e senha no ícone de lixo, também ao lado da senha. Ao terminar, clique no botão escrito Login abaixo de todos os outros para prosseguir com a verificação.");
    }//GEN-LAST:event_ajudaMouseClicked

//SOBRE
    private void sobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sobreMouseClicked

        SobreFrame dialog2 = new SobreFrame(this, true);
        dialog2.setVisible(true);
    }//GEN-LAST:event_sobreMouseClicked

    private void passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyTyped
        int code = evt.getKeyChar();
        if(code==KeyEvent.VK_ENTER) {
            login();
        }
    }//GEN-LAST:event_passwordKeyTyped

    public static void main(String args[]) {
        FlatMacDarkLaf.setup();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Email;
    private javax.swing.JLabel ajuda;
    private javax.swing.JButton del;
    private javax.swing.JLabel downpass;
    private javax.swing.JLabel downpass1;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel eyepass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton login;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel sobre;
    // End of variables declaration//GEN-END:variables
}