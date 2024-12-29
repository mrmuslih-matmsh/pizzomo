public class OrderTrackerView {

    static OrderTracker orderTracker = new OrderTracker();

    public static void trackOrder() {

        X x = new X();

        String orderId = x.inputString("Enter your Order ID to track your order: ");


        Order order = orderTracker.getOrder(orderId);

        if (order == null) {
            x.println("Order not found. Please check your Order ID.");
            trackOrder();
            return;
        }

        x.println("Order ID: " + order.getOrderId());
        x.println("Status: " + order.getStatus());
        x.println("Estimated delivery time: " + order.getEstimatedDeliveryTime() + " minutes.");

        String choice = x.inputString("Do you want to advance the order state? (yes/no): ");
        if (choice.equalsIgnoreCase("yes")) {
            order.handleOrder();
        }
    }
}
