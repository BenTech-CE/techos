package br.edu.util;

import br.edu.agenda.util.Estado;
import br.edu.agenda.util.Estados;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class FuncoesUteis {
    public static Font carregarFonte(String nome) {
        try {
            InputStream is = FuncoesUteis.class.getResourceAsStream(nome);
            if (is == null) {
                System.out.println("Não foi possível achar a fonte " + nome);
            }
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            is.close();

            return font;
        } catch (IOException | FontFormatException e) {
            System.out.println("Não foi possível carregar a fonte " + nome);
            e.printStackTrace();
        }

        return null;
    }
    
    public static void centralizarTela(JInternalFrame j, JDesktopPane d) {
        int w = d.getWidth();
        int h = d.getHeight();

        j.setLocation(
            (w / 2) - (j.getWidth()  / 2),
            (h / 2) - (j.getHeight() / 2)
        );
    }

    public static void tocarSom(String arquivo) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(FuncoesUteis.class.getResource(arquivo));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println("Não foi possível tocar o som " + arquivo);
            e.printStackTrace();
        }
    }
    
    public static String[] getListaDeCidades(String estado) {
        InputStream is = FuncoesUteis.class.getResourceAsStream("/br/edu/agenda/util/estados-cidades.json");
        Reader leitor = new InputStreamReader(is);
        
        Gson gson = new GsonBuilder().create();
        Estados estadosObj = gson.fromJson(leitor, Estados.class);
        
        Estado[] estados = estadosObj.getEstados();
        
        String[] cidades = new String[] {};
        
        for (Estado e : estados) {
            if (e.getSigla().equals(estado)) {
                cidades = e.getCidades();
                break;
            }
        }
        
        return cidades;
    }
}