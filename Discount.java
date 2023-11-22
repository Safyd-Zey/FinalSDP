package Decorator;

abstract class Discount extends Product2 {
    protected Product2 product;

    public Discount(Product2 product) {
        super(product.getName(), product.getQuantity(), product.getPrice());
        this.product = product;
    }

    @Override
    public int getPrice() {
        return product.getPrice();
    }
}
