package Observer;

import Observer.Observer;
import Observer.Subject;
import Other.Product;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    private List<String> hasProducts = new ArrayList<>();
    public void addProduct (Product product){
        boolean check = checkProductAdd( products, product);
        if(check == false){
            this.products.add(product);
            this.hasProducts.add(product.getName());
            notifyObservers("Market has "+ product.getName());}
    }
    public boolean checkProductAdd(List<Product> products, Product product){
        for (Product check : products) {
            if (check.getName().equals(product.getName())) {
                check.setCount(check.getCount()+product.getCount());
                return true;
            }
        }
        return false;
    }
    public  List<Product> getProducts(){
        return products;
    }
    public void removeProduct(Product product){
        boolean check = checkProductRemove( products, product);
        if(check == true){
            this.products.remove(product);
            this.hasProducts.remove(product.getName());
            notifyObservers("Market doesn't have "+ product.getName());
        }
    }
    public boolean checkProductRemove(List<Product> products, Product product){
        for (Product check : products) {
            if (check.getName().equals(product.getName())) {
                if(check.getCount()-1==0){
                    return true;
                }
                check.setCount(check.getCount()-1);
                return false;
            }
        }
        return false;
    }


    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers  ) {
            observer.update(this.hasProducts, message);
        }
    }
}
