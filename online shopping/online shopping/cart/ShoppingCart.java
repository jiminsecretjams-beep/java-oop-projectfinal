package cart;

import java.util.*;
import product.Product;

public class ShoppingCart {
    private List<CartItem> items = new ArrayList<>();

    public void addProduct(Product product, int quantity) {
        items.add(new CartItem(product, quantity));
        System.out.println(product.getName() + " x" + quantity + " added.");
    }

    public double calculateTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    public List<CartItem> getItems() { return items; }

    public void showCart() {
        for (CartItem item : items) {
            System.out.println(item.getProduct() + " | Qty: " + item.getQuantity());
        }
        System.out.println("Total: $" + calculateTotal());
    }
}