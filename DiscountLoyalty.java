package Decorator;

import Decorator.Discount;

class DiscountLoyalty extends Discount {
    private final double discount;

    public DiscountLoyalty(Product2 product, double discount) {
        super(product);
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return (int) (super.getPrice() - (super.getPrice() * (discount/100)));
    }
}
