public class CreditCardPayment implements PaymentMethod {

    X x = new X();

    private String cardNumber;
    private String expiryDate;
    private String cvv;

    public CreditCardPayment(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public void processPayment(double amount) {
        x.println("Processing Credit Card payment for amount: $" + amount);
    }
}

 