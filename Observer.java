package Observer;

import java.util.List;

// Интерфейс для наблюдателя
interface Observer {
    void update(List<String> hasProducts, String message);
}

// Конкретный класс, который реализует интерфейс наблюдателя
class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(List<String> hasProducts, String message) {
        System.out.println("Hello "+name+" We have some changes in our market.\n"+message+"\n"+ hasProducts);
    }
}

// Интерфейс для субъекта (наблюдаемого объекта)
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);

}

// Конкретный класс, который реализует интерфейс субъекта

