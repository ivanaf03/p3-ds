package e2;

import java.util.ArrayList;

public abstract class Sensor{
    private Tank tank;
    private int level;
    private ArrayList<Alert> alertList=new ArrayList<>();
    public Sensor(int level, Tank tank){
        this.level=level;
        this.tank=tank;
    }
    public int getLevel(){
        return level;
    }
    public void setlevel(int level){
        this.level=level;
    }
    public void addAlerts(Alert alert){
        alertList.add(alert);
    }
    public void removeAlerts(Alert alert){
        alertList.remove(alert);
    }
    public ArrayList<Alert> getAlerts(){
        return alertList;
    }
    abstract String getParam();
    public void setTank(Tank tank){
        this.tank.removeSensors(this);
        this.tank=tank;
        tank.addSensors(this);
    }
    public Tank getTank(){
        return tank;
    }
}
