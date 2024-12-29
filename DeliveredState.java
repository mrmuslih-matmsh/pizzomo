public class DeliveredState implements OrderState {

    X x = new X();

    @Override
    public void handleOrder(Order order) {
        x.println("Your order has been delivered!");
    }

    @Override
    public String getStatus() {
        return "Delivered";
    }

    @Override
    public int getEstimatedDeliveryTime() {
        return 0;
    }
}

