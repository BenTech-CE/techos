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
public class ClimaDiario {
    private String[] time;
    @SerializedName("temperature_2m_max")
    private double[] temperature2mMax;
    @SerializedName("temperature_2m_min")
    private double[] temperature2mMin;
    private double[] apparentTemperatureMax;
    private double[] apparentTemperatureMin;

    public String[] getTime() {
        return time;
    }

    public void setTime(String[] time) {
        this.time = time;
    }

    public double[] getTemperature2mMax() {
        return temperature2mMax;
    }

    public void setTemperature2mMax(double[] temperature2mMax) {
        this.temperature2mMax = temperature2mMax;
    }

    public double[] getTemperature2mMin() {
        return temperature2mMin;
    }

    public void setTemperature2mMin(double[] temperature2mMin) {
        this.temperature2mMin = temperature2mMin;
    }

    public double[] getApparentTemperatureMax() {
        return apparentTemperatureMax;
    }

    public void setApparentTemperatureMax(double[] apparentTemperatureMax) {
        this.apparentTemperatureMax = apparentTemperatureMax;
    }

    public double[] getApparentTemperatureMin() {
        return apparentTemperatureMin;
    }

    public void setApparentTemperatureMin(double[] apparentTemperatureMin) {
        this.apparentTemperatureMin = apparentTemperatureMin;
    }
    
    
}
