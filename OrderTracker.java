import java.util.HashMap;
import java.util.Map;

public class OrderTracker {
    private Map<String, Order> orders = new HashMap<>();
    private Map<String, Feedback> feedbacks = new HashMap<>();

    public void addOrder(Order order) {
        orders.put(order.getOrderId(), order);
    }

    public Order getOrder(String orderId) {
        return orders.get(orderId);
    }

    public void addFeedback(String orderId, Feedback feedback) {
        feedbacks.put(orderId, feedback);
    }

    public Feedback getFeedback(String orderId) {
        return feedbacks.get(orderId);
    }
}

