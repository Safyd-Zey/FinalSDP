package Strategy;

import Strategy.Delivery;

public class DeliveryPickup extends Delivery {
    private final int price;
    private int deliveryPrice = 0;
    public DeliveryPickup(int price){
        this.price = price;
    }
    @Override
    public int delivery() {
        System.out.println("Товар доступен к самовывозу");
        deliveryPrice = price;
        return deliveryPrice;
    }
}
