package br.edu.flappybird.jogo;

import br.edu.util.FuncoesUteis;
import javax.swing.JLabel;

/**
 *
 * @author Kaua Sousa
 */
public class Passaro {
    private int altura;
    private int gravidade;
    private int forçaDoPulo;
    private JLabel imagem;
    private Jogo jogo;
    
    public Passaro(Jogo j) {
        imagem = j.getJanelaJogo().passarinholbl;
        jogo = j;
        
        altura = 1;
        gravidade = 7;
        forçaDoPulo = 70;
    }
    
    public void açãoDaGravidade() {
        altura += gravidade;
        imagem.setBounds(120, altura, imagem.getWidth(), imagem.getHeight());
    }
    
    public void pular() {
        FuncoesUteis.tocarSom("/br/edu/flappybird/sounds/sfx_wing.wav");
        altura -= forçaDoPulo;
        imagem.setBounds(120, altura, imagem.getWidth(), imagem.getHeight());
    }
    
    public JLabel getImagem() {
        return imagem;
    }

    public int getGravidade() {
        return gravidade;
    }

    public void setGravidade(int gravidade) {
        this.gravidade = gravidade;
    }
    
    
}
