public class PreparingState implements OrderState {
    @Override
    public void handleOrder(Order order) {

        X x = new X();

        x.println("Your order is being prepared.");
        order.setState(new OutForDeliveryState());
    }

    @Override
    public String getStatus() {
        return "Preparing";
    }

    @Override
    public int getEstimatedDeliveryTime() {
        return 10;
    }
}

