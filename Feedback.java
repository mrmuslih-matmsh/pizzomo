public class Feedback {
    private String orderId;
    private int rating;
    private String additionalFeedback;

    public Feedback(String orderId, int rating, String additionalFeedback) {
        this.orderId = orderId;
        this.rating = rating;
        this.additionalFeedback = additionalFeedback;
    }

    public void submitFeedback() {

        X x = new X();
        
        x.println("Feedback for Order ID " + orderId + ":");
        x.println("Rating: " + rating);
        x.println("Additional Feedback: " + additionalFeedback);
    }
}

