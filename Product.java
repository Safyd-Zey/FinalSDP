package Other;

public class Product {
    String name;
    double price;
    int count;
    String barcode;

    public Product(String name,double price,int count,String barcode){
        this.name = name;
        this.price = price;
        this.count =count;
        this.barcode = barcode;
    }
    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @Override
    public String toString() {
        return "Other.Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", count='" + count + '\'' +
                ", barcode='" + barcode + '\'' +
                '}';
    }
}



// Конкретная реализация продукта
class Laptop extends Product {

    public Laptop(String name, double price, int count, String barcode) {
        super(name, price, count, barcode);
    }
}


class Phone extends Product{

    public Phone(String name, double price, int count, String barcode) {
        super(name, price, count, barcode);
    }
}
