package Other;

public class CPU extends Product2 {
    private final String name;
    private int quantity;
    private int price;
    public CPU(String name, int quantity, int price) {
        super(name, quantity, price);
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    public String getName(){
        return name;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }
}
