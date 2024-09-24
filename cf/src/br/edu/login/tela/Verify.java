/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.login.tela;

import br.edu.desktop.tela.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author GABRIEL
 */
public class Verify extends javax.swing.JDialog {
    byte counter = 4;
    byte counter2 = 3;
    boolean ver = false;
    Timer tenteNovamenteTimer;
    JFrame parent;
  
    public Verify(JFrame parent, boolean modal) {
        super(parent,modal);
        this.parent = parent;
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parent);
        setTitle("Verificação");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ir = new javax.swing.JButton();
        downpass = new javax.swing.JLabel();
        cod = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        captcha = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ir.setBackground(new java.awt.Color(30, 30, 30));
        ir.setForeground(new java.awt.Color(255, 255, 255));
        ir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/login/imagens/ir.png"))); // NOI18N
        ir.setBorder(null);
        ir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irActionPerformed(evt);
            }
        });
        getContentPane().add(ir, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 30, -1));

        downpass.setForeground(new java.awt.Color(255, 255, 255));
        downpass.setText("______________________________");
        getContentPane().add(downpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 150, -1));

        cod.setBackground(new java.awt.Color(30, 30, 30));
        cod.setForeground(new java.awt.Color(255, 255, 255));
        cod.setToolTipText("Insira o código aqui.");
        cod.setBorder(null);
        cod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codKeyPressed(evt);
            }
        });
        getContentPane().add(cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 140, 20));

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Desabilitado");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 90, 40));

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Para prosseguirmos, por favor, digite as letras ordenadas em código na caixa acima para que saibamos que você é um humano.");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 690, 40));

        captcha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/login/imagens/captcha.png"))); // NOI18N
        captcha.setText("jLabel3");
        getContentPane().add(captcha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 450, 160));

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ao terminar, clique na seta ao lado da caixa de texto.");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 310, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void irActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irActionPerformed
        
        String codigo = cod.getText();
        
        if(codigo.equals("Td4eva")) {
            JOptionPane.showMessageDialog(this, "Seja Ben-vindo!");
            new Desktop().setVisible(true);
            this.dispose();
            parent.dispose();            
        } else{ 
            if(counter2==0) {
                ver = !ver;
                if(ver) {                        
                    JOptionPane.showMessageDialog(this, "Muitas tentativas fracassadas. Acesso negado.");
                    System.exit(0);
                } 
            } else {
               JOptionPane.showMessageDialog(this, "Código inválido. "+(counter-1)+" tentativas restantes.");
               counter--;
               if(counter==0){
                    
                    cod.setEnabled(false);
                    cod.setVisible(false);
                    downpass.setVisible(false);
                    ir.setVisible(false);
                    ir.setEnabled(false);
                    JOptionPane.showMessageDialog(this, "Sem tentativas restantes. Tente novamente em 5 segundos.");
                    
                    tenteNovamenteTimer = new Timer(5000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            tenteNovamenteTimer.stop();
                            
                            cod.setVisible(true);
                            ir.setVisible(true);
                            downpass.setVisible(true);
                            cod.setEnabled(true);
                            ir.setEnabled(true);
                            counter2--;
                            counter = 4;
                        }
                    });
                    
                    tenteNovamenteTimer.start();
               }
            } 
        }
    }//GEN-LAST:event_irActionPerformed

    private void codKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codKeyPressed
        int limitDisplay = 6;
        if (cod.getText().length() > limitDisplay) {
            cod.setText(cod.getText().substring(0, limitDisplay));
        }
    }//GEN-LAST:event_codKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel captcha;
    private javax.swing.JTextField cod;
    private javax.swing.JLabel downpass;
    private javax.swing.JButton ir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}