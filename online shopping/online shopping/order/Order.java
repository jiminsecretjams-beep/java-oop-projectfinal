package order;

import java.util.ArrayList;
import java.util.List;

import cart.CartItem;
import observer.Observer;
import observer.Subject;
import payment.PaymentStrategy;

public class Order implements Subject {
    private static int counter = 1;
    private int orderId;

    private List<Observer> observers = new ArrayList<>();
    private List<CartItem> items;
    private PaymentStrategy payment;
    private String status;

    public Order(List<CartItem> items, PaymentStrategy payment) {
        this.orderId = counter++;
        this.items = items;
        this.payment = payment;
        this.status = "Created";
    }

    public void placeOrder() {
        double total = calculateTotal();
        payment.pay(total);
        setStatus("Paid");
    }

    public double calculateTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(status);
        }
    }
}