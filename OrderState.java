public interface OrderState {
    void handleOrder(Order order);
    String getStatus(); 
    int getEstimatedDeliveryTime();
}

