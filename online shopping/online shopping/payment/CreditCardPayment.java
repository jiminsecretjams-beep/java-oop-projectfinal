package payment;

public class CreditCardPayment implements PaymentStrategy {
    private String card;

    public CreditCardPayment(String card) {
        this.card = card;
    }

    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via Credit Card");
    }

    public String getPaymentMethod() {
        return "Credit Card";
    }
}
