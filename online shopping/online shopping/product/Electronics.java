package product;

public class Electronics extends Product {
    public Electronics(String name, double price) {
        super(name, price);
    }

    public String getCategory() {
        return "Electronics";
    }
}