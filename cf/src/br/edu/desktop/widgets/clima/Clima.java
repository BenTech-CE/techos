/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.desktop.widgets.clima;

/**
 *
 * @author Kaua Sousa
 */
public class Clima {
    private double latitude;
    private double longitude;
    private double generationtimeMs;
    private int utcOffsetSeconds;
    private String timezone;
    private String timezoneAbbreviation;
    private int elevation;
    private Object currentUnits;
    private Object dailyUnits;
    private ClimaAtual current;
    private ClimaDiario daily;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getGenerationtimeMs() {
        return generationtimeMs;
    }

    public void setGenerationtimeMs(double generationtimeMs) {
        this.generationtimeMs = generationtimeMs;
    }

    public int getUtcOffsetSeconds() {
        return utcOffsetSeconds;
    }

    public void setUtcOffsetSeconds(int utcOffsetSeconds) {
        this.utcOffsetSeconds = utcOffsetSeconds;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getTimezoneAbbreviation() {
        return timezoneAbbreviation;
    }

    public void setTimezoneAbbreviation(String timezoneAbbreviation) {
        this.timezoneAbbreviation = timezoneAbbreviation;
    }

    public int getElevation() {
        return elevation;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    public Object getCurrentUnits() {
        return currentUnits;
    }

    public void setCurrentUnits(Object currentUnits) {
        this.currentUnits = currentUnits;
    }

    public Object getDailyUnits() {
        return dailyUnits;
    }

    public void setDailyUnits(Object dailyUnits) {
        this.dailyUnits = dailyUnits;
    }

    public ClimaAtual getCurrent() {
        return current;
    }

    public void setCurrent(ClimaAtual current) {
        this.current = current;
    }

    public ClimaDiario getDaily() {
        return daily;
    }

    public void setDaily(ClimaDiario daily) {
        this.daily = daily;
    }
    
    
    
}
