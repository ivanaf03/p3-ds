package e1;

public class Payment implements State {
    private Payment(){}
    private static final Payment instance=new Payment();
    public static Payment getInstance(){
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
        order.setPaid(1);
    }


    @Override
    public void nextStep(Order order) {
        if(order.isPaid()==0 || (order.getInitHour().getHour()==(order.getNextHour().getHour()))){
            order.setCanceled(1);
            order.setState(Cancelled.getInstance());
            order.setInitHour(order.getNextHour());
        } else if (order.isPaid()==1) {
            order.setCanceled(1);
            order.setState(Completed.getInstance());
        }
    }

    @Override
    public void shop(Order order) {
    }

    @Override
    public void timeLapse24h(Order order) {
        order.setNextHour();
        if(order.isPaid()==1) {
            order.setCompleted(1);
            order.setState(Completed.getInstance());
        }
    }

    @Override
    public String screenInfo(Order order) {
        return "Order number: "+order.getTag()+"\n"+"Phase: "+order.printState()+" -- "+order.getCart().size()+" products.";
    }

    @Override
    public String printState(Order order) {
        return "Payment";
    }
}
