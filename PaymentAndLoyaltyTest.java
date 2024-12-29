public class PaymentAndLoyaltyTest {

    public static void displayPaymentandLoyalty() {

        X x = new X();

        User user = new User("Muslih", 1200);

        LoyaltyPointsProgram loyaltyProgram = new LoyaltyPointsProgram(user);

        x.println("Username: " + user.getUsername());
        x.println("Loyalty Points Earned: " + user.getLoyaltyPoints().getPoints());
        x.println("Redeemable Points: " + user.getLoyaltyPoints().getPoints() + " (1 point = $0.05)");

        double orderAmount = 5.00;

        loyaltyProgram.earnLoyaltyPoints(10);

        PaymentMethod paymentMethod = new LoyaltyPointsPayment(user.getLoyaltyPoints(), 100);
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.processPayment(paymentMethod, orderAmount);

        loyaltyProgram.redeemLoyaltyPoints(50);

        Menu.displayMainMenu();
    }
}
 
