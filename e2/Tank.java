package e2;

import java.util.ArrayList;

public class Tank{
   public enum Location{
        Exterior, Interior
    }
    private final Location location;
    private final String name;
    private ArrayList<Sensor> sensorList=new ArrayList<>();
    public Tank(String name, Location location){
        this.name=name;
        this.location=location;
    }
    public String getName() {
        return name;
    }
    public Location getLocation() {
        return location;
    }
    public void addSensors(Sensor sensor){
        sensorList.add(sensor);
    }
    public void removeSensors(Sensor sensor){
        sensorList.remove(sensor);
    }
}


