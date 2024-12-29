public class PlacedState implements OrderState {

    X x = new X();

    @Override
    public void handleOrder(Order order) {
        x.println("Order has been placed successfully! Order ID: " + order.getOrderId());
        order.setState(new PreparingState());
    }

    @Override
    public String getStatus() {
        return "Order Placed";
    }

    @Override
    public int getEstimatedDeliveryTime() {
        return 15;
    }
}

