package e1;

public class Cancelled implements State {
    private Cancelled(){}
    private static final Cancelled instance=new Cancelled();
    public static Cancelled getInstance(){
        return instance;
    }
    @Override
    public void addItems(Order order, Product p, int i) {
    }

    @Override
    public void removeItems(Order order, Product p, int i) {

    }

    @Override
    public void pay(Order order) {
    }

    @Override
    public void nextStep(Order order) {
    }

    @Override
    public void shop(Order order) {
    }

    @Override
    public void timeLapse24h(Order order) {
    }

    @Override
    public String screenInfo(Order order) {
        return "Order number: "+order.getTag()+"\n"+"Phase: "+order.printState();
    }

    @Override
    public String printState(Order order) {
        return "Cancelled";
    }
}
