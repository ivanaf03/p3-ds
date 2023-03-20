package e1;

public class CheckOut implements State {
    private CheckOut(){}
    private static final CheckOut instance=new CheckOut();
    public static CheckOut getInstance(){
        return instance;
    }
    @Override
    public void addItems(Order order, Product p, int i) {
        if(order.getCart().containsKey(p)){
            if(order.getProductList().get(order.getProductList().indexOf(p)).getStock()>=i){
                order.getCart().put(p,order.getCart().get(p)==null?i: i+order.getCart().get(p));
                order.getProductList().get(order.getProductList().indexOf(p)).takeProduct(i);
                order.getLog().append("\n-Modify(adding...): Item: ").append(p.getName()).append(" - Quantity: ").append(i).append(" -> Shopping Cart -- Products: ").append(order.getCart().size());
            } else{
                throw new IllegalArgumentException("No hay stock de " +p.getName()+".");
            }
        } else{
            throw new IllegalArgumentException("Solo puedes anadir objetos que ya tuvieras en el carrito.");
        }
    }

    @Override
    public void removeItems(Order order, Product p, int i) {
        if(order.getCart().containsKey(p)){
            order.getCart().put(p, order.getCart().get(p)-i);
            order.getProductList().get(order.getProductList().indexOf(p)).restoreProduct(i);
            order.getLog().append("\n-Modify(removing...): Item: ").append(p.getName()).append(" - Quantity: ").append(i).append(" -> Shopping Cart -- Products: ").append(order.getCart().size());
        } else{
            throw new IllegalArgumentException("No hay "+p.getName()+" en el carrito.");
        }
    }

    @Override
    public void pay(Order order) {
    }

    @Override
    public void nextStep(Order order) {
        if(order.getCart().size()>0) {
            order.setState(Payment.getInstance());
        }
    }

    @Override
    public void shop(Order order) {
        order.setState(ShoppingCart.getInstance());
    }

    @Override
    public void timeLapse24h(Order order) {
    }

    @Override
    public String screenInfo(Order order) {
        return "Order number: "+order.getTag()+"\n"+"Phase: "+order.printState()+" -- "+order.getCart().size()+" products.";
    }

    @Override
    public String printState(Order order) {
        return "CheckOut";
    }
}