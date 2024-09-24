/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.biblia.tela;

import br.edu.biblia.dao.BibliaDao;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author gabri
 */
public class TelaEscolherCapitulo extends JFrame {

    int[] qtdCap = {
        50,  // Gênesis
        40,  // Êxodo
        27,  // Levítico
        36,  // Números
        34,  // Deuteronômio
        24,  // Josué
        21,  // Juízes
        4,   // Rute
        31,  // 1 Samuel
        24,  // 2 Samuel
        22,  // 1 Reis
        25,  // 2 Reis
        29,  // 1 Crônicas
        36,  // 2 Crônicas
        10,  // Esdras
        13,  // Neemias
        10,  // Ester
        42,  // Jó
        150, // Salmos
        31,  // Provérbios
        12,  // Eclesiastes
        8,   // Cantares de Salomão
        66,  // Isaías
        52,  // Jeremias
        5,   // Lamentações
        48,  // Ezequiel
        12,  // Daniel
        14,  // Oséias
        3,   // Joel
        9,   // Amós
        1,   // Obadias
        4,   // Jonas
        7,   // Miqueias
        3,   // Naum
        3,   // Habacuque
        3,   // Sofonias
        2,   // Ageu
        14,  // Zacarias
        4,   // Malaquias
        28,  // Mateus
        16,  // Marcos
        24,  // Lucas
        21,  // João
        28,  // Atos
        16,  // Romanos
        16,  // 1 Coríntios
        13,  // 2 Coríntios
        6,   // Gálatas
        6,   // Efésios
        4,   // Filipenses
        4,   // Colossenses
        5,   // 1 Tessalonicenses
        3,   // 2 Tessalonicenses
        6,   // 1 Timóteo
        4,   // 2 Timóteo
        3,   // Tito
        1,   // Filemom
        13,  // Hebreus
        5,   // Tiago
        5,   // 1 Pedro
        3,   // 2 Pedro
        5,   // 1 João
        1,   // 2 João
        1,   // 3 João
        1,   // Judas
        22   // Apocalipse
    };

    
    /**
     * Creates new form BibliaSagrada
     */
    public TelaEscolherCapitulo(int livro) {
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/br/edu/biblia/imagens/biblia.png")).getImage());
        
        // Adjust the scroll speed
        JScrollBar verticalScrollBar = jScrollPane1.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(16); // Set unit increment (for small scrolls)
        verticalScrollBar.setBlockIncrement(50); // Set block increment (for page scrolls)
        
        //jPanel2.setLayout(new GridLayout(5, 150 /2));
        
        int tamanhoquadrado = 91;
        
        int contador = 0;
        for (int i = 1; i <= qtdCap[livro]; i++) {
            JButton botao = new JButton("" + i);
            botao.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            
            final int livr = livro +1;
            final int capitulo = i;
            
            botao.addActionListener((ActionEvent e) -> {
                TelaLer tela = new TelaLer(livr, capitulo);
                tela.setVisible(true);
                tela.setLocationRelativeTo(this);
                
                dispose();
                //Abrir texto.
            });
            
            //botao.setPreferredSize(new Dimension(40, 40));
            
            int x = (contador % 5) * tamanhoquadrado;
            int y = (contador / 5) * tamanhoquadrado;
            
            jPanel2.add(botao, new AbsoluteConstraints(x, y, tamanhoquadrado, tamanhoquadrado));
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bíblia Sagrada - Selecionar capítulo");
        setMinimumSize(new java.awt.Dimension(490, 670));
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
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane1.setViewportView(jPanel2);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        TelaEscolherLivro tela = new TelaEscolherLivro();
        tela.setVisible(true);
        tela.setLocationRelativeTo(this);
    }//GEN-LAST:event_formWindowClosing



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
