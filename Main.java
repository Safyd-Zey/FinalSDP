package Other;

import Adapter.Barcode;
import Adapter.IBarcode;
import Adapter.OldBarcodeAdapter;
import Decorator.DiscountBenefit;
import Decorator.DiscountHoliday;
import Decorator.DiscountLoyalty;
import Factory_method.ProductFactory;
import Observer.ConcreteObserver;
import Observer.ConcreteSubject;
import Observer.Observer;
import Other.CPU;
import Singlton.Inventory;
import Strategy.DeliveryExpress;
import Strategy.DeliveryPickup;
import Strategy.DeliveryStandard;
import Strategy.Order;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        //Factory method
        ProductFactory productFactory = new ProductFactory();
        Product product1 = productFactory.getProduct("laptop","Lenovo",200,2,"818161");

        //Observer.Observer
        ConcreteSubject subject = new ConcreteSubject();
        Product laptop1 = new Laptop("Lenovo", 200, 2, "818161");
        Product phone1 = new Phone("Xiaomi 11T", 100, 10, "212131");
        subject.addProduct(laptop1);
        Observer observer1 = new ConcreteObserver("Sayat");
        subject.addObserver(observer1);
        subject.addProduct(phone1);
        subject.addProduct(phone1);

        //Adapter
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write barcode");
        String barcode = scanner.nextLine();
        System.out.println("Your product: " + productName(barcode,subject.getProducts()));


        //Singleton

        Inventory inventory1 = Inventory.getInstance();
        inventory1.displayInventory();
        inventory1.changeQuantity("Intel i9", 8);
        inventory1.displayInventory();
        Inventory inventory2 = Inventory.getInstance();
        inventory2.displayInventory();
        inventory1.changeQuantity("Intel i9", 9);
        inventory2.displayInventory();
        //разные админы могут управлять одним складом

        //Decorator
        Product2 loyalCpu = new DiscountLoyalty(new CPU("Intel i9", 10, 1100), 15);

        //скидка в праздничные дни со скидкой лояльности
        Product2 loyalholiday = new DiscountHoliday(loyalCpu, 20);
        Product2 finalProduct = new DiscountBenefit(loyalholiday, 10);
        System.out.println(finalProduct.getName() + "\nЦена: " + finalProduct.getPrice());

        //Strategy
        Product2 cpu = new CPU("Intel i3", 12, 500);
        int cost = cpu.getPrice();
        Order order = new Order();
        order.setDelivery(new DeliveryStandard(cpu.getPrice())); //стандартная доставка
        cost = order.performDelivery();
        System.out.println("Доставка обошлась в " + cost + " долларов");
        order.setDelivery(new DeliveryExpress(cpu.getPrice())); //экспресс доставка
        cost = order.performDelivery();
        System.out.println("Доставка обошлась в " + cost + " долларов");
        order.setDelivery(new DeliveryPickup(cpu.getPrice())); //самовывоз
        cost = order.performDelivery();
        System.out.println("Доставка обошлась в " + cost + " долларов");
    }
    private static Product productName(String barcode, List<Product> list){
        boolean isOnlyDigits = true;
        for(int i = 0; i < barcode.length() && isOnlyDigits; i++) {
            if(!Character.isDigit(barcode.charAt(i))) {
                isOnlyDigits = false;
            }
        }
        if(isOnlyDigits) {
            IBarcode newBar = new Barcode();
            return newBar.getByBarcode(barcode,  list);
        }
        else {
            IBarcode oldBar = new OldBarcodeAdapter();
            return oldBar.getByBarcode(barcode, list);
        }
    }





}

