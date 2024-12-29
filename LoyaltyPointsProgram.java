public class LoyaltyPointsProgram {

    X x = new X();

    private User user;

    public LoyaltyPointsProgram(User user) {
        this.user = user;
    }

    // Method to add loyalty points after an order
    public void earnLoyaltyPoints(int points) {
        user.getLoyaltyPoints().addPoints(points);
        x.println("You have earned " + points + " loyalty points.");
    }

    // Method to redeem loyalty points
    public void redeemLoyaltyPoints(int points) {
        if (user.getLoyaltyPoints().redeemPoints(points)) {
            x.println("Successfully redeemed " + points + " loyalty points.");
        } else {
            x.println("Insufficient loyalty points to redeem.");
        }
    }
}
