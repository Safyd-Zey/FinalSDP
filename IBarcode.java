package Adapter;

import java.util.List;

public interface IBarcode {
    Product getByBarcode(String n, List<Product> list);
}
class Barcode implements IBarcode {
    @Override
    public Product getByBarcode(String n, List<Product> list) {
        return NameOfProduct(list,n);
    }
    private Product NameOfProduct(List<Product> products, String n) {

        for (Product check : products) {
            if (check.getBarcode().equals(n)) {
                return check;
            }
        }
        return null;
    }
}
class OldBarcodeAdapter implements IBarcode {
    private final OldBarcode oldApp;
    public OldBarcodeAdapter(){
        oldApp = new OldBarcode();
    }
    @Override
    public Product getByBarcode(String n, List<Product> list) {
        return oldApp.getByOldBarcode(list,n);
    }
}
class OldBarcode {
    public Product getByOldBarcode(List<Product> list, String n) {

        return NameOfProd(list,n);
    }
    private Product NameOfProd(List<Product> products, String n) {
        for (Product check : products) {
            if (check.getName().equals(n)) {
                return check;
            }
        }
        return null;
    }

}
