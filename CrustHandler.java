public class CrustHandler extends CustomizationHandler {
    @Override
    public void handleCustomization(Pizza.Builder pizzaBuilder, X x) {
        x.println("Choose your crust: 1. Thin Crust ($2) | 2. Stuffed Crust ($3) | 3. Pan Crust ($2.5)");
        int crustChoice = x.inputInt("Enter your choice: ");
        String crust = "";
        double price = 0;

        switch (crustChoice) {
            case 1 -> {
                crust = "Thin Crust";
                price = 2;
            }
            case 2 -> {
                crust = "Stuffed Crust";
                price = 3;
            }
            case 3 -> {
                crust = "Pan Crust";
                price = 2.5;
            }
            default -> {
                x.println("Invalid choice. Please try again.");
                return;
            }
        }
        pizzaBuilder.setCrust(crust);
        x.println("Crust chosen: " + crust);
        pizzaBuilder.setPrice(pizzaBuilder.getPrice() + price); // Modify price on builder

        if (nextHandler != null) {
            nextHandler.handleCustomization(pizzaBuilder, x); // Call the next handler
        }
    }
}

