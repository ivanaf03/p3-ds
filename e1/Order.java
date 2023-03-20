package e1;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Order {
    private final int tag;

    public Order(ArrayList<Product> productList, int tag) {
        this.productList = productList;
        this.tag = tag;
        initHour=LocalTime.now();
    }
    private final List<Product> productList;
    private Map<Product, Integer> cart = new HashMap<>();
    private LocalTime initHour;
    private LocalTime nextHour;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    private StringBuilder log = new StringBuilder();
    private State state = ShoppingCart.getInstance();
    private int paid = 0;
    private int canceled = 0;
    private int completed = 0;

    //CÓDIGO DEL PEDIDO
    public void addItems(Product p, int i) {
        state.addItems(this, p, i);
    }

    public void removeItems(Product p, int i) {
        state.removeItems(this, p, i);
    }

    public void pay() {
        state.pay(this);
    }

    public void nextStep() {
        state.nextStep(this);
        log.append("\nOrder ").append(this.tag).append(": ").append(this.printState());
    }

    public void shop() {
        state.shop(this);
        log.append("\nOrder ").append(this.tag).append(": ").append(this.printState());
    }
    public String printState(){
        return state.printState(this);
    }

    public void setState(State state) {
        this.state=state;
    }

    public void timeLapse24h() {
        state.timeLapse24h(this);
    }

    public String screenInfo() {
        return state.screenInfo(this);
    }

    public int getTag() {
        return tag;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }
    
    public StringBuilder getLog(){
        return log;
    }

    public int isCompleted() {
        return completed;
    }

    public int isCanceled() {
        return canceled;
    }
    public int isPaid() {
        return paid;
    }

    public void setCompleted(int completed) {
        this.completed=completed;
    }
    public void setCanceled(int canceled){
        this.canceled=canceled;
    }
    public void setPaid(int paid) {
        this.paid = paid;
    }
    public DateTimeFormatter getDtf(){
        return dtf;
    }
    
    public LocalTime getInitHour(){
        return initHour;
    }
    public LocalTime getNextHour(){
        return nextHour;
    }

    public void setInitHour(LocalTime hour) {
        this.initHour=hour;
    }
    public void setNextHour() {
        this.nextHour=initHour.plusHours(24);
    }
}
