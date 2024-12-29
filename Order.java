import java.util.ArrayList;
import java.util.List;

public class Order implements Observable  {
    private Pizza pizza;
    private String deliveryAddress;
    private String orderId;
    private OrderState state;
    private Feedback feedback;
    private List<Observer> observers = new ArrayList<>();
    private String status;

    public Order(Pizza pizza, String deliveryAddress) {
        this.pizza = pizza;
        this.deliveryAddress = deliveryAddress;
        this.state = new PlacedState();
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void handleOrder() {
        state.handleOrder(this);
    }

    public void generateOrderId() {
        this.orderId = "#PZ" + (int)(Math.random() * 100000);
    }

    public String getOrderId() {
        return orderId;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getStatus() {
        return state.getStatus();
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getEstimatedDeliveryTime() {
        return state.getEstimatedDeliveryTime();
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(status);
        }
    }
}
