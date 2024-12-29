public class User implements Observer {
    private String username;
    private LoyaltyPoints loyaltyPoints;

    X x = new X();

    public User(String username, int initialPoints) {
        this.username = username;
        this.loyaltyPoints = new LoyaltyPoints(initialPoints);
    }

    public String getUsername() {
        return username;
    }

    public LoyaltyPoints getLoyaltyPoints() {
        return loyaltyPoints;
    }

    @Override
    public void update(String orderStatus) {
        x.println(username + ", your order status is: " + orderStatus);
    }
}
