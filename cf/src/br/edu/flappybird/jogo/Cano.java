package br.edu.flappybird.jogo;

import br.edu.util.FuncoesUteis;
import java.awt.Point;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Kaua Sousa
 */
public class Cano {
    private double velocidade;
    private int posiçãoX;
    private int offset;
    
    private int alturaMáxima;
    private int alturaMínima;
    private int posiçãoParaDeletar;
    
    private boolean passouPeloCano;
    
    Jogo jogo;
    JPanel painel;
    
    JLabel canoBaixo;
    JLabel canoCima;
    
    //int id;
    
    public Cano(Jogo j, int o) {
        painel = j.getJanelaJogo().jogoPainel;
        jogo = j;
        offset = o;
        
        velocidade = 3.;
        posiçãoX = 380 + offset;
        
        alturaMáxima = 210;
        alturaMínima = 270;
        
        posiçãoParaDeletar = -100;
    
        //id = i;
    }
    
    public void instanciar() {
        //System.out.println("Instanciando um cano...");
        
        canoBaixo = new JLabel();
        canoBaixo.setIcon(new ImageIcon(getClass().getResource("/br/edu/flappybird/imagens/cano.png")));
        painel.add(canoBaixo, 2);
        canoBaixo.setBounds(posiçãoX, 270, 112, 247);
        
        canoCima = new JLabel();
        canoCima.setIcon(new ImageIcon(getClass().getResource("/br/edu/flappybird/imagens/canoaocontrario.png")));
        painel.add(canoCima, 2);
        canoCima.setBounds(posiçãoX, -100, 112, 247);
        
        painel.repaint();
    }
    
    public void movimentar() {
        if (canoBaixo != null && canoCima != null) {
            posiçãoX -= velocidade;
            
            canoBaixo.setBounds(posiçãoX, canoBaixo.getLocation().y, canoBaixo.getWidth(), canoBaixo.getHeight());
            canoCima.setBounds(posiçãoX, canoCima.getLocation().y, canoCima.getWidth(), canoCima.getHeight());

            if (posiçãoX < posiçãoParaDeletar) {
                Random random = new Random();
                int altura = random.nextInt(alturaMínima - alturaMáxima) + alturaMínima;

                posiçãoX = jogo.getÚltimoCano().canoBaixo.getLocation().x + jogo.getEspaçamentoEntreCanos();
                jogo.setÚltimoCano(this);
                
                //System.out.println("Reposicionando cano " + id + " para " + posiçãoX);
                canoBaixo.setLocation(posiçãoX, altura);
                canoCima.setLocation(posiçãoX, altura-350);
            }
        }

    }
    
    public void verificarColisão() {
        Point cano = canoBaixo.getLocation();
        Point cano2 = canoCima.getLocation();
        Point pos = jogo.getPassaro().getImagem().getLocation();
                
        if ((pos.x > cano.x - 60 && pos.x < cano.x + 60) && (pos.y > cano.y - 30 || pos.y < (cano2.y + 220))) {
            // ^ Verificação se a posição do pássaro está dentro do cano e se está acima ou abaixo da altura dos dois canos (cano de cima e cano de baixo).
            jogo.gameOver(true);
        } else if ((pos.x > cano.x - 60 && pos.x < cano.x + 60) && passouPeloCano == false) {
            // ^ Verificando se a posição do pássaro está dentro do cano para +1 ponto.
            jogo.atribuirPonto();
            FuncoesUteis.tocarSom("/br/edu/flappybird/sounds/sfx_point.wav");
            passouPeloCano = true;
        } else if (pos.x > cano.x + 60 && passouPeloCano == true) {
            // ^ Passou completamente pelo cano.
            passouPeloCano = false;
        }
    }
    
    /*public void aumentarVelocidade(double vel) {
        velocidade = vel;
    }*/
}
