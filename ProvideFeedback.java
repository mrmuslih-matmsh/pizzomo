public class ProvideFeedback {

    private static Feedback feedback;

    public static void displayProvideFeedback() {

        X x = new X();

        String orderId = x.inputString("Enter your Order ID: ");

        int rating = x.inputInt("Rate your experience (1-5): ");
        while (rating < 1 || rating > 5) {
            x.println("Invalid rating. Please enter a number between 1 and 5.");
            rating = x.inputInt("Rate your experience (1-5): ");
        }

        String additionalFeedback = x.inputString("Leave additional feedback: ");

        feedback = new Feedback(orderId, rating, additionalFeedback);

        feedback.submitFeedback();

        x.println("Thank you for your feedback! Your rating has been saved.");

        Menu.displayMainMenu();
    }
}


