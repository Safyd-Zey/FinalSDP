package Strategy;

import Strategy.Delivery;

public class Order { //заказ товара
    private Delivery delivery;
    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
    public int performDelivery() {
        return delivery.delivery();
    }
}