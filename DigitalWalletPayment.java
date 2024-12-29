public class DigitalWalletPayment implements PaymentMethod {

    X x = new X();

    private String walletId;

    public DigitalWalletPayment(String walletId) {
        this.walletId = walletId;
    }

    @Override
    public void processPayment(double amount) {
        x.println("Processing Digital Wallet payment for amount: $" + amount);
    }
}
 
