package Strategy;

import Strategy.Delivery;

public class DeliveryExpress extends Delivery {
    private final int price;
    private double deliveryPrice = 0;
    public DeliveryExpress(int price){
        this.price = price;
    }
    @Override
    public int delivery() {
        System.out.println("Товар будет доставлен в течение 7 дней");
        deliveryPrice = price*0.1 + price;
        return (int) deliveryPrice;
    }
}
