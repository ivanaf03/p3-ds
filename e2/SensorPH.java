package e2;

public class SensorPH extends Sensor{
    public SensorPH(int level, Tank tank) {
        super(level, tank);
    }
    @Override
    public String getParam() {
        return "Acidez";
    }
}
