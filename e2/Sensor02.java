package e2;

public class Sensor02 extends Sensor{
    public Sensor02(int level, Tank tank) {
        super(level, tank);
    }
    @Override
    public String getParam() {
        return "Oxígeno";
    }

}
