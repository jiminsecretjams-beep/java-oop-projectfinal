package product;

public class Clothing extends Product {
    public Clothing(String name, double price) {
        super(name, price);
    }

    public String getCategory() {
        return "Clothing";
    }
}