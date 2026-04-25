import product.*;
import cart.*;
import payment.*;
import observer.*;
import order.*;

public class Main {
    public static void main(String[] args) {

        Product p1 = ProductFactory.createProduct("electronics", "Laptop", 1000);
        Product p2 = ProductFactory.createProduct("clothing", "Shirt", 50);

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(p1, 1);
        cart.addProduct(p2, 2);

        cart.showCart();

        Customer customer = new Customer("Alice");

        PaymentStrategy payment = new PayPalPayment("alice@email.com");

        Order order = new Order(cart.getItems(), payment);
        order.addObserver(customer);

        order.placeOrder();
        order.setStatus("Shipped");
        order.setStatus("Delivered");
    }
}