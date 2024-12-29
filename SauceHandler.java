public class SauceHandler extends CustomizationHandler {
    @Override
    public void handleCustomization(Pizza.Builder pizzaBuilder, X x) {
        x.println("Choose your sauce: 1. Tomato ($1) | 2. Alfredo ($1.5) | 3. Barbecue ($2)");
        int sauceChoice = x.inputInt("Enter your choice: ");
        String sauce = "";
        double price = 0;

        switch (sauceChoice) {
            case 1 -> {
                sauce = "Tomato";
                price = 1;
            }
            case 2 -> {
                sauce = "Alfredo";
                price = 1.5;
            }
            case 3 -> {
                sauce = "Barbecue";
                price = 2;
            }
            default -> {
                x.println("Invalid choice. Please try again.");
                return;
            }
        }
        pizzaBuilder.setSauce(sauce);
        x.println("Sauce chosen: " + sauce);
        pizzaBuilder.setPrice(pizzaBuilder.getPrice() + price); // Add price for the sauce

        if (nextHandler != null) {
            nextHandler.handleCustomization(pizzaBuilder, x);
        }
    }
}

