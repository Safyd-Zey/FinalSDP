package Factory_method;

public class ProductFactory {
    public static Product getProduct(String productType, String productName, double price, int count, String barcode){
        if(productType.equalsIgnoreCase("laptop")) {
            return new Laptop( productName, price, count, barcode);
        }
        else if(productType.equalsIgnoreCase("phone")){
            return new Phone(productName,price,count,barcode);
        }
        else return null;
    }
}
