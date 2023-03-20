package e2;

public class SensorT extends Sensor{
    public SensorT(int level, Tank tank) {
        super(level, tank);
    }
    @Override
    public String getParam() {
        return "Temperatura";
    }
}
