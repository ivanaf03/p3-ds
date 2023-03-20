package e1;

public interface State {
    void addItems(Order order, Product p, int i);
    void removeItems(Order order, Product p, int i);
    void pay(Order order);
    void nextStep(Order order);
    void shop(Order order);
    void timeLapse24h(Order order);
    String screenInfo(Order order);
    String printState(Order order);
}
