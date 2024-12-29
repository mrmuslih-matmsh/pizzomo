public class OutForDeliveryState implements OrderState {
    @Override
    public void handleOrder(Order order) {
        X x = new X();

        x.println("Your order is out for delivery to: " + order.getDeliveryAddress());
        order.setState(new DeliveredState());
    }

    @Override
    public String getStatus() {
        return "Out for Delivery";
    }

    @Override
    public int getEstimatedDeliveryTime() {
        return 5; // Delivery time
    }
    
}
