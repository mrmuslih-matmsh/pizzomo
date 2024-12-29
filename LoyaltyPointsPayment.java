public class LoyaltyPointsPayment implements PaymentMethod {
    private LoyaltyPoints loyaltyPoints;
    private int pointsToRedeem;

    public LoyaltyPointsPayment(LoyaltyPoints loyaltyPoints, int pointsToRedeem) {
        this.loyaltyPoints = loyaltyPoints;
        this.pointsToRedeem = pointsToRedeem;
    }

    @Override
    public void processPayment(double amount) {

        X x = new X();

        double equivalentAmount = loyaltyPoints.convertToDollar();
        if (equivalentAmount >= amount) {
            x.println("Processing payment with Loyalty Points for amount: $" + amount);
            loyaltyPoints.redeemPoints(pointsToRedeem);
        } else {
            x.println("Insufficient loyalty points. You need " + (amount / 0.05) + " points.");
        }
    }
}
 
