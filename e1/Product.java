package e1;

public class Product {
    private final String name;
    private int stock;

    public Product(String name, int stock){
        this.name=name;
        this.stock=stock;
    }

    public void takeProduct(int i){
        if(stock>=i){
            stock-=i;
        } else{
            System.out.println("No queda "+this.name);
        }
    }

    public void restoreProduct(int i){
        stock+=i;
    }

    public int getStock(){
        return stock;
    }

    public String getName(){
        return name;
    }
}
