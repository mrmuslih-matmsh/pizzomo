public class LoyaltyPoints {
    private int points;
    private static final double POINTS_CONVERSION_RATE = 0.05;

    public LoyaltyPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public boolean redeemPoints(int pointsToRedeem) {
        if (pointsToRedeem <= points) {
            points -= pointsToRedeem;
            return true;
        }
        return false;
    }

    public double convertToDollar() {
        return points * POINTS_CONVERSION_RATE;
    }
}
