package Decorator;

import Decorator.Discount;

class DiscountHoliday extends Discount {
    private final double discount;

    public DiscountHoliday(Product2 product, double discount) {
        super(product);
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return (int) (super.getPrice() - (super.getPrice() * (discount/100)));
    }
}
