package br.edu.jogodavelha.tela;

import br.edu.desktop.tela.Desktop;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class JogoDaVelha extends JFrame {

    JButton[] bt = new JButton[9];
    JLabel placar = new JLabel("Placar");
    JLabel pontosx = new JLabel(":   0");
    JLabel pontoso = new JLabel(":   0");
    JButton novo = new JButton("Recomeçar jogo");
    JButton zerar = new JButton("Zerar placar");
    JMenuBar menuBar = new JMenuBar();
    JMenu menuAjuda = new JMenu("Ajuda");
    JMenuItem comoJogar = new JMenuItem("Como jogar?");
    JMenuItem sobre = new JMenuItem("Sobre");
    JMenu menuJogar = new JMenu("Jogo");
    JMenuItem zerarPlacar = new JMenuItem("Zerar placar");
    JMenuItem novoJogo = new JMenuItem("Recomeçar jogo");
    JMenuItem sair = new JMenuItem("Sair");
    int pontuacaox = 0;
    int pontuacaoo = 0;
    boolean xo = false;
    boolean[] click = new boolean[9];
    ImageIcon iconx = new ImageIcon(getClass().getResource("/br/edu/jogodavelha/img/x.png"));
    ImageIcon icono = new ImageIcon(getClass().getResource("/br/edu/jogodavelha/img/o.png"));
    ImageIcon iconjogo = new ImageIcon(getClass().getResource("/br/edu/desktop/img/jogodavelha.png"));
    
    public JogoDaVelha() {
        setVisible(true);
        setResizable(false);
        setTitle("Jogo da Velha");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        setBounds(0, 0, 700, 450);
        setLocationRelativeTo(null);
        setIconImage(iconjogo.getImage());
        add (placar);
        pontosx.setFont(new Font("Arial", Font.BOLD, 25));
        pontoso.setFont(new Font("Arial", Font.BOLD, 25));
        placar.setFont(new Font("Arial", Font.BOLD, 25));
        add(pontosx);
        add(pontoso);
        add(novo);
        add(zerar);
        placar.setBounds(475, 50, 100, 30);
        pontosx.setBounds(400, 75, 120, 77);
        pontoso.setBounds(550, 75, 120, 77);
        
        pontosx.setIcon(iconx);
        pontoso.setIcon(icono);
        
        menuBar.add(menuJogar);
        menuBar.add(menuAjuda);
        
        menuJogar.add(novoJogo);
        menuJogar.add(zerarPlacar);
        menuJogar.add(sair);
        
        menuAjuda.add(comoJogar);
        menuAjuda.add(sobre);
        
        sobre.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirSobre();
            }
        });
        
        comoJogar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirComoJogar();
            }
        });
        
        // ESSES SÃO DO JMENUBAR
        novoJogo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               limpar();
            }
        });
        
        zerarPlacar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pontuacaox=0;
                pontuacaoo=0;
                atualizar();
            }
        });
        
        sair.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Desktop().setVisible(true);
        
                dispose();
            }
        });
        
        setJMenuBar(menuBar);
        
        novo.setBounds(380, 200, 150, 30);
        zerar.setBounds(380, 250, 150, 30);
        novo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpar();
            }
        });
        zerar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pontuacaox=0;
                pontuacaoo=0;
                atualizar();
            }
        });
        
        int cont = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                bt[cont] = new JButton();
                add(bt[cont]);
                bt[cont].setBounds((100 * i) + 50, (100 * j) + 50, 95, 95);
                bt[cont].setFont(new Font("Arial", Font.BOLD, 0));
                cont++; 
            }
        }
        for (int i = 0; i < 9; i++) {
            click[i] = false;
        }

        bt[0].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (click[0] == false) {
                    click[0] = true;
                    mudar(bt[0]);
                }
            }
        });
        bt[1].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (click[1] == false) {
                    click[1] = true;
                    mudar(bt[1]);
                }
            }
        });
        bt[2].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (click[2] == false) {
                    click[2] = true;
                    mudar(bt[2]);
                }
            }
        });
        bt[3].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (click[3] == false) {
                    click[3] = true;
                    mudar(bt[3]);
                }
            }
        });
        bt[4].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (click[4] == false) {
                    click[4] = true;
                    mudar(bt[4]);
                }
            }
        });
        bt[5].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (click[5] == false) {
                    click[5] = true;
                    mudar(bt[5]);
                }
            }
        });
        bt[6].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (click[6] == false) {
                    click[6] = true;
                    mudar(bt[6]);
                }
            }
        });
        bt[7].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (click[7] == false) {
                    click[7] = true;
                    mudar(bt[7]);
                }
            }
        });
        bt[8].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (click[8] == false) {
                    click[8] = true;
                    mudar(bt[8]);
                }
            }
        });
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                new Desktop().setVisible(true);
            }
        });
    }

    public void mudar(JButton btn) {
        if (xo) {
            btn.setText("O");
            btn.setIcon(icono);
            xo = false;
        } else {
            btn.setText("X");
            btn.setIcon(iconx);
            xo = true;
        }
        ganhou();
    }
    public void atualizar(){
        pontosx.setText(":   "+pontuacaox);
        pontoso.setText(":   "+pontuacaoo);
    }

    public void ganhou() {
        int cont=0;
            for (int i = 0; i < 9; i++) {
                if(click[i]==true){
                    cont++;
                }
            }
        if ((bt[0].getText() == "X" && bt[1].getText() == "X" && bt[2].getText() == "X")
                || (bt[3].getText() == "X" && bt[4].getText() == "X" && bt[5].getText() == "X")
                || (bt[6].getText() == "X" && bt[7].getText() == "X" && bt[8].getText() == "X")
                || (bt[0].getText() == "X" && bt[3].getText() == "X" && bt[6].getText() == "X")
                || (bt[1].getText() == "X" && bt[4].getText() == "X" && bt[7].getText() == "X")
                || (bt[2].getText() == "X" && bt[5].getText() == "X" && bt[8].getText() == "X")
                || (bt[0].getText() == "X" && bt[4].getText() == "X" && bt[8].getText() == "X")
                || (bt[6].getText() == "X" && bt[4].getText() == "X" && bt[2].getText() == "X")) {
            JOptionPane.showMessageDialog(null, "X ganhou!");
            pontuacaox++;
            atualizar();
            limpar();
        }else if ((bt[0].getText() == "O" && bt[1].getText() == "O" && bt[2].getText() == "O")
                || (bt[3].getText() == "O" && bt[4].getText() == "O" && bt[5].getText() == "O")
                || (bt[6].getText() == "O" && bt[7].getText() == "O" && bt[8].getText() == "O")
                || (bt[0].getText() == "O" && bt[3].getText() == "O" && bt[6].getText() == "O")
                || (bt[1].getText() == "O" && bt[4].getText() == "O" && bt[7].getText() == "O")
                || (bt[2].getText() == "O" && bt[5].getText() == "O" && bt[8].getText() == "O")
                || (bt[0].getText() == "O" && bt[4].getText() == "O" && bt[8].getText() == "O")
                || (bt[6].getText() == "O" && bt[4].getText() == "O" && bt[2].getText() == "O")) {
            JOptionPane.showMessageDialog(null, "O ganhou!");
            pontuacaoo++;
            atualizar();
            limpar();
        }else if(cont==9){
            JOptionPane.showMessageDialog(null, "Empate!");
            limpar();
        }
    }
    public void limpar(){
        for (int i = 0; i < 9; i++) {
            bt[i].setText("");
            bt[i].setIcon(null);
            click[i]=false;
            xo=false;
        }
    }

    public void abrirSobre() {
        Sobre s = new Sobre(this, true);
        s.setVisible(true);
    }
    
    public void abrirComoJogar() {
        ComoJogar cj = new ComoJogar(this, true);
        cj.setVisible(true);
    }
    
    public static void main(String[] args) {
        FlatMacDarkLaf.setup();
        new JogoDaVelha();
    }

}
