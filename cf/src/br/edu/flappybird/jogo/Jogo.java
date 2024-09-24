package br.edu.flappybird.jogo;

import br.edu.util.FuncoesUteis;
import br.edu.flappybird.views.JanelaJogo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;

/**
 *
 * @author Kaua Sousa
 */
public class Jogo implements ActionListener {
    private int númeroMaximoDeCanos;
    private int espaçamentoEntreCanos;
    
    private Timer tempo;
    
    private int tiques;
    private int pontos;
    
    private boolean jogoAtivo;
    
    private JanelaJogo janela;
    private Passaro passaro;
    private Cano[] canos;
    
    private Cano últimoCano;
    
    public Jogo(JanelaJogo j) {
        númeroMaximoDeCanos = 4;
        espaçamentoEntreCanos = 220;
        janela = j;
        jogoAtivo = false;
        pontos = 0;
    }
    
    public void iniciarJogo() {
        if (jogoAtivo == true)
            gameOver(false);
        
        janela.setMenuVisivel(false);
        janela.tecladoTF.requestFocus();
        
        limparJogo();
        
        passaro = new Passaro(this);
        
        instanciarCanos();
        
        tempo = new Timer(20, this);
        tempo.start();
        
        janela.ativarParallax();
        
        jogoAtivo = true;
        System.out.println("Jogo iniciado.");
        
    }
    
    public void limparJogo() {
        pontos = 0;
        
        if (canos != null)
            for (int i = 0; i < canos.length; i++) {
                janela.jogoPainel.remove(canos[i].canoCima);
                janela.jogoPainel.remove(canos[i].canoBaixo);
            }
        
        janela.desativarParallax(true);
        janela.pontuacaolbl.setText("" + pontos);
        janela.jogoPainel.repaint();
    }
    
    public void gameOver(boolean animação) {
        tempo.stop();
        janela.desativarParallax(false);
        jogoAtivo = false;
        
        if (animação) {
            passaro.setGravidade(25);
            
            FuncoesUteis.tocarSom("/br/edu/flappybird/sounds/sfx_hit.wav");
            janela.tremerTela(300, 700);
        } else {    
            janela.setMenuVisivel(true);
            janela.setTextoGameOverVisivel(true, pontos);
            janela.jpnMenu.requestFocus();
            System.out.println("Fim de jogo. Pontuação: " + pontos);            
        }
        

    }
    
    public void instanciarCanos() {
        canos = new Cano[númeroMaximoDeCanos];
        
        for (int i = 0; i < númeroMaximoDeCanos; i++) {
            canos[i] = new Cano(this, espaçamentoEntreCanos * i);
            canos[i].instanciar();
            
            if (i == (númeroMaximoDeCanos - 1)) {
                últimoCano = canos[i];
            }
        }
    }
    
    public void açãoDosCanos() {
        for (int i = 0; i < canos.length; i++) {
            canos[i].movimentar();
            canos[i].verificarColisão();
        }
    }
    
    public void atribuirPonto() {
        pontos++;
        janela.pontuacaolbl.setText("" + pontos);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {      
        tiques++;
        
        passaro.açãoDaGravidade();
        açãoDosCanos();
        
        //aumentarDificuldade();
    }
    
    public boolean getJogoAtivo() {
        return jogoAtivo;
    }
    
    public Passaro getPassaro() {
        return passaro;
    }
    
    public int getNúmeroMáximoDeCanos() {
        return númeroMaximoDeCanos;
    }
    
    public int getEspaçamentoEntreCanos() {
        return espaçamentoEntreCanos;
    }
    
    public JanelaJogo getJanelaJogo() {
        return janela;
    }
    
    public Cano getÚltimoCano() {
        return últimoCano;
    }
    
    public void setÚltimoCano(Cano novoCano) {
        últimoCano = novoCano;
    }
}
