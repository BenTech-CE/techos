/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.desktop.widgets.clima;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Kaua Sousa
 */
public class APIClima {
    private static ImageIcon iconLimpo = new ImageIcon(APIClima.class.getResource("/br/edu/desktop/widgets/clima/img/limpo.png"));
    private static ImageIcon iconLimpoNoite = new ImageIcon(APIClima.class.getResource("/br/edu/desktop/widgets/clima/img/limponoite.png"));
    private static ImageIcon iconChuva = new ImageIcon(APIClima.class.getResource("/br/edu/desktop/widgets/clima/img/chuva.png"));
    private static ImageIcon iconChuvaNoite = new ImageIcon(APIClima.class.getResource("/br/edu/desktop/widgets/clima/img/chuvanoite.png"));
    private static ImageIcon iconNublado = new ImageIcon(APIClima.class.getResource("/br/edu/desktop/widgets/clima/img/nublado.png"));
    private static ImageIcon iconTrovoada = new ImageIcon(APIClima.class.getResource("/br/edu/desktop/widgets/clima/img/trovoada.png"));
    private static ImageIcon iconParcNublado = new ImageIcon(APIClima.class.getResource("/br/edu/desktop/widgets/clima/img/parcnublado.png"));
    private static ImageIcon iconParcNubladoNoite = new ImageIcon(APIClima.class.getResource("/br/edu/desktop/widgets/clima/img/parcnubladonoite.png"));
    
    public static Clima carregarClima() throws MalformedURLException, IOException {
        URL api = new URL("https://api.open-meteo.com/v1/forecast?latitude=-3.744362&longitude=-38.536043&current=temperature_2m,is_day,weather_code&daily=temperature_2m_max,temperature_2m_min,apparent_temperature_max,apparent_temperature_min&timezone=auto&forecast_days=1");
        HttpURLConnection con = (HttpURLConnection) api.openConnection();
        con.setRequestProperty("accept", "application/json");

        InputStream is = con.getInputStream();
        Reader leitor = new InputStreamReader(is);
        
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        Clima clima = gson.fromJson(leitor, Clima.class);
        
        return clima;
    }
    
    public static String getNomeClimaCorrespondente(int wc, int isDay) {
        switch (wc) {
            case 51, 53, 55, 80, 81, 82, 61, 63, 65:
                return "Chuva";
            case 95, 96, 99:
                return "Trovoadas";
            case 2:
                return "Parcialmente Nublado";
            case 3, 45, 48:
                return "Nublado";
            case 1:
                return "Predomin. Ensolarado";
            case 0:
                return "Limpo";
        }
        
        return "";
    }
    
    public static ImageIcon getIconeClimaCorrespondente(int wc, int isDay) {       
        if (isDay == 1) {
            switch (wc) {
                case 51, 53, 55, 80, 81, 82, 61, 63, 65:
                    return iconChuva;
                case 95, 96, 99:
                    return iconTrovoada;
                case 2:
                    return iconParcNublado;
                case 3, 45, 48:
                    return iconNublado;
                case 0, 1:
                    return iconLimpo;
            }
        } else {
            switch (wc) {
                case 51, 53, 55, 80, 81, 82, 61, 63, 65:
                    return iconChuvaNoite;
                case 95, 96, 99:
                    return iconTrovoada;
                case 2:
                    return iconParcNubladoNoite;
                case 3, 45, 48:
                    return iconNublado;
                case 0, 1:
                    return iconLimpoNoite;
            }
        }
        
        return iconLimpo;
    }
}
