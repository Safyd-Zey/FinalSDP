package Strategy;

import Strategy.Delivery;

public class DeliveryStandard extends Delivery {
    private final int price;
    private double deliveryPrice = 0;
    public DeliveryStandard(int price){
        this.price = price;
    }
    @Override
    public int delivery() {
        System.out.println("Товар будет доставлен в течение 14 дней");
        deliveryPrice = price*0.05 + price;
        return (int) deliveryPrice;
    }
}
