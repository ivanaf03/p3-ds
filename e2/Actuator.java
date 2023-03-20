package e2;

public class Actuator implements Observer{
    @Override
    public void update(Subject s) {
        Alert alert=(Alert) s;
        if(alert.getLight()==Alert.Light.Red || alert.getLight()==Alert.Light.Orange){
            alert.getSensor().setlevel(alert.midValue());
        }
    }
}
