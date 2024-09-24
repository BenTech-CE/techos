/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.desktop.widgets.clima;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Kaua Sousa
 */
public class ClimaAtual {
    private String time;
    private int interval;
    @SerializedName("temperature_2m")
    private double temperature2m;
    private byte isDay;
    private int weatherCode;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public double getTemperature2m() {
        return temperature2m;
    }

    public void setTemperature2m(double temperature2m) {
        this.temperature2m = temperature2m;
    }
    
    public int getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(int weatherCode) {
        this.weatherCode = weatherCode;
    }

    public byte getIsDay() {
        return isDay;
    }

    public void setIsDay(byte isDay) {
        this.isDay = isDay;
    }
    
    
}
