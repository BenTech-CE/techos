/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.biblia.tela;

import br.edu.biblia.dao.BibliaDao;
import br.edu.biblia.dao.ConexaoBanco;
import br.edu.desktop.tela.Desktop;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author gabri
 */
public class TelaEscolherLivro extends JFrame {

    String[] livros = new String[] {"Gn", "Ex", "Lv", "Nm", "Dt", "Js", "Jz", "Rt", "1Sm", "2Sm", "1Rs", "2Rs", "1Cr", "2Cr", "Ed", "Ne", "Et", "Jó", "Sl", "Pv", "Ec", "Ct", "Is", "Jr", "Lm", "Ez", "Dn", "Os", "Jl", "Am", "Ob", "Jn", "Mq", "Na", "Hc", "Sf", "Ag", "Zc", "Ml", "Mt", "Mc", "Lc", "Jo", "At", "Rm", "1Co", "2Co", "Gl", "Ef", "Fp", "Cl", "1Ts", "2Ts", "1Tm", "2Tm", "Tt", "Fm", "Hb", "Tg", "1Pe", "2Pe", "1Jo", "2Jo", "3Jo", "Jd", "Ap"};
    
    /**
     * Creates new form BibliaSagrada
     */
    public TelaEscolherLivro(){
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/br/edu/biblia/imagens/biblia.png")).getImage());
        
        ConexaoBanco.gerarBancoDeDados();
        
        // Adjust the scroll speed
        JScrollBar verticalScrollBar = jScrollPane1.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(16); // Set unit increment (for small scrolls)
        verticalScrollBar.setBlockIncrement(50); // Set block increment (for page scrolls)
        
        int contador = 0;
        for (String livro : livros) {
            JButton botao = new JButton(livro);
            botao.setFont(new Font("Segoe UI", Font.PLAIN, 80));
            
            switch (contador) {
                //Velho Testamento!

                //Gn, Ex, Lv, Nm, Dt

                case 0, 1, 2, 3, 4:  
                    botao.setBackground(new Color(15, 186, 169));
                    break;

                //Js, Jz, Rt, 1Sm, 2Sm, 1Rs, 2Rs, 1Cr, 2Cr, Ed, Ne, Et

                case 5,6,7,8,9,10,11,12,13,14,15,16:  
                    botao.setBackground(new Color(56, 181, 62));
                    break;

                //Jó, Sl, Pv, Ec, Ct

                case 17,18,19,20,21: 
                    botao.setBackground(new Color(219, 118, 206));
                    break;

                //Is, Jr, Lm, Ez, Dn

                case 22,23,24,25,26: 
                    botao.setBackground(new Color(240, 36, 29));
                    break;

                //Os, Jl, Am, Ob, Jn, Mq, Na, Hc, Sf, Ag, Zc, Ml

                case 27,28,29,30,31,32,33,34,35,36,37,38: 
                    botao.setBackground(new Color(176, 173, 25));
                    break;

                //Novo Testamento!

                //Mt, Mc, Lc, Jo

                case 39, 40, 41, 42: 
                    botao.setBackground(new Color(39, 105, 143));
                    break;

                //At

                case 43: 
                    botao.setBackground(new Color(174, 50, 179));
                    break;

                //Rm, 1Co, 2Co, Gl, Ef, Fp, Cl, 1Ts, 2Ts, 1Tm, 2Tm, Tt, Fm

                case 44,45,46,47,48,49,50,51,52,53,54,55,56: 
                    botao.setBackground(new Color(194, 37, 53));
                    break;

                //Hb, Tg, 1Pe, 2Pe, 1Jo, 2Jo, 3Jo, Jd


                case 57,58,59,60,61,62,63,64:  
                    botao.setBackground(new Color(92, 152, 204));
                    break;
                //Ap

                case 65: 
                    botao.setBackground(new Color(204, 209, 33));
                    break;

                default: 
                    System.out.println("Mês inválido");
                    break;
            }
            
            final int indice = contador; // pog
            
            botao.addActionListener((ActionEvent e) -> {
                TelaEscolherCapitulo tela = new TelaEscolherCapitulo(indice);
                tela.setVisible(true);
                tela.setLocationRelativeTo(this);
                dispose();
            });
            
            botao.setPreferredSize(new Dimension(200, 200));
            
            //int x = ((contador % 2) == 0) ? 20 : 240;
            int y = (contador / 2) * 220;
            
            jPanel2.add(botao);
            jPanel2.setPreferredSize(new Dimension(440, y +220));
            
            contador++;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiComoUsar = new javax.swing.JMenuItem();
        jmiSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bíblia Sagrada");
        setMaximumSize(new java.awt.Dimension(32767, 32767));
        setMinimumSize(new java.awt.Dimension(490, 670));
        setPreferredSize(new java.awt.Dimension(490, 670));
        setResizable(false);
        setSize(new java.awt.Dimension(490, 670));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel2.setPreferredSize(new java.awt.Dimension(458, 668));
        jPanel2.setLayout(new java.awt.GridLayout(33, 1));
        jScrollPane1.setViewportView(jPanel2);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Ajuda");

        jmiComoUsar.setText("Como usar?");
        jmiComoUsar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiComoUsarActionPerformed(evt);
            }
        });
        jMenu1.add(jmiComoUsar);

        jmiSobre.setText("Sobre");
        jmiSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSobreActionPerformed(evt);
            }
        });
        jMenu1.add(jmiSobre);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiComoUsarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiComoUsarActionPerformed
        JOptionPane.showMessageDialog(this, "Escolha o livro e capítulo que deseja ler e deleite-se nas Sagradas Escrituras! Aperte nas setas na área de leitura para alterar o capítulo que está lendo.");
    }//GEN-LAST:event_jmiComoUsarActionPerformed

    private void jmiSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSobreActionPerformed
        new TelaSobre(this, true).setVisible(true);
    }//GEN-LAST:event_jmiSobreActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new Desktop().setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem jmiComoUsar;
    private javax.swing.JMenuItem jmiSobre;
    // End of variables declaration//GEN-END:variables
}
