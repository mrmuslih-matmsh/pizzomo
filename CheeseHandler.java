public class CheeseHandler extends CustomizationHandler {
    @Override
    public void handleCustomization(Pizza.Builder pizzaBuilder, X x) {
        x.println("Choose your cheese: 1. Mozzarella ($1) | 2. Parmesan ($1.5) | 3. Cheddar ($1)");
        int cheeseChoice = x.inputInt("Enter your choice: ");
        String cheese = "";
        double price = 0;

        switch (cheeseChoice) {
            case 1 -> {
                cheese = "Mozzarella";
                price = 1;
            }
            case 2 -> {
                cheese = "Parmesan";
                price = 1.5;
            }
            case 3 -> {
                cheese = "Cheddar";
                price = 1;
            }
            default -> {
                x.println("Invalid choice. Please try again.");
                return;
            }
        }
        pizzaBuilder.setCheese(cheese);
        x.println("Cheese chosen: " + cheese);
        pizzaBuilder.setPrice(pizzaBuilder.getPrice() + price); // Add price for the cheese

        if (nextHandler != null) {
            nextHandler.handleCustomization(pizzaBuilder, x);
        }
    }
}

