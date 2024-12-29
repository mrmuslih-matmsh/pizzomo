public class SizeHandler extends CustomizationHandler {
    @Override
    public void handleCustomization(Pizza.Builder pizzaBuilder, X x) {
        x.println("Choose your pizza size: 1. Small ($5) | 2. Medium ($8) | 3. Large ($12)");
        int sizeChoice = x.inputInt("Enter your choice: ");
        String size = "";
        double price = 0;
        
        switch (sizeChoice) {
            case 1 -> {
                size = "Small";
                price = 5;
            }
            case 2 -> {
                size = "Medium";
                price = 8;
            }
            case 3 -> {
                size = "Large";
                price = 12;
            }
            default -> {
                x.println("Invalid choice. Please choose again.");
                return;
            }
        }
        pizzaBuilder.setSize(size);
        x.println("Size chosen: " + size);
        pizzaBuilder.setPrice(pizzaBuilder.getPrice() + price);
        
        if (nextHandler != null) {
            nextHandler.handleCustomization(pizzaBuilder, x);
        }
    }
}
