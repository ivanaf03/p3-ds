package e2;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Alert extends Subject{
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    private LocalTime hour;
    public enum Light{
        Off, Red, Orange
    }
    private Light light=Light.Off;
    private final int lowerRed;
    private final int lowerOrange;
    private final int upperOrange;
    private final int upperRed;
    private Sensor sensor;
    public Alert(int lowerRed, int lowerOrange, int upperOrange, int upperRed, Sensor sensor){
        this.lowerOrange=lowerOrange;
        this.lowerRed=lowerRed;
        this.upperOrange=upperOrange;
        this.upperRed=upperRed;
        this.sensor=sensor;
        sensor.addAlerts(this);
        if(lowerRed>=lowerOrange||lowerOrange>=upperOrange||upperOrange>=upperRed){
            throw new IllegalArgumentException("Alert");
        }
    }
    public Sensor getSensor(){
        return sensor;
    }
    public void setSensor(Sensor sensor){
        this.sensor.removeAlerts(this);
        this.sensor=sensor;
        sensor.addAlerts(this);
    }
    public Light getLight(){
        return light;
    }
    public void setLight(Light light) {
        this.light = light;
    }
    public void checkSensor(){
        if(sensor.getLevel()<lowerRed||sensor.getLevel()>upperRed){
            light=Light.Red;
            notifyObservers();
        } else if(sensor.getLevel()<lowerOrange || sensor.getLevel()>upperOrange){
            light=Light.Orange;
            notifyObservers();
        } else{
            light=Light.Off;
        }
    }
    public int midValue(){
        return ((upperOrange+lowerOrange)/2);
    }
    public String getHour(){
        hour=LocalTime.now();
        return hour.format(dtf);
    }
}
