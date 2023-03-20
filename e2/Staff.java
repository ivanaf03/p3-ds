package e2;

import java.util.ArrayList;

public class Staff implements Observer{
    public Staff(){}
    private ArrayList<String> orangeList=new ArrayList<>();
    private ArrayList<String> redList=new ArrayList<>();
    @Override
    public void update(Subject s) {
        Alert alert=(Alert) s;
        if(alert.getLight()==Alert.Light.Red){
            orangeList.add("Alerta Roja:\n"+alert.getSensor().getTank().getName()+" "+alert.getSensor().getTank().getLocation() +"\nControl de "+alert.getSensor().getParam()+": nivel "+alert.getSensor().getLevel()+"\n" +alert.getHour()+"\n");
        } else if(alert.getLight()==Alert.Light.Orange){
            orangeList.add("Alerta Naranja:\n"+alert.getSensor().getTank().getName()+" "+alert.getSensor().getTank().getLocation() +"\nControl de "+alert.getSensor().getParam()+": nivel "+alert.getSensor().getLevel()+"\n"+ alert.getHour()+"\n");
        }
    }
    public String info(){
        StringBuilder sb=new StringBuilder();
        for(String string: orangeList){
            sb.append(string);
        }
        for(String string: redList){
            sb.append(string);
        }
        return sb.toString();
    }
}
