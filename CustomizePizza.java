public class CustomizePizza {

    public static void displayCustomize() {
        X x = new X();

        FavoritesManager favoritesManager = new FavoritesManager();

        // Start pizza customization
        Pizza.Builder pizzaBuilder = new Pizza.Builder();
        double totalPrice = 0;

        // Create handlers for each customization step
        CustomizationHandler sizeHandler = new SizeHandler();
        CustomizationHandler crustHandler = new CrustHandler();
        CustomizationHandler sauceHandler = new SauceHandler();
        CustomizationHandler toppingHandler = new ToppingHandler();
        CustomizationHandler cheeseHandler = new CheeseHandler();

        // Set up the chain: size -> crust -> sauce -> toppings -> cheese
        sizeHandler.setNextHandler(crustHandler);
        crustHandler.setNextHandler(sauceHandler);
        sauceHandler.setNextHandler(toppingHandler);
        toppingHandler.setNextHandler(cheeseHandler);

        // Start the chain of customizations
        sizeHandler.handleCustomization(pizzaBuilder, x);

        // Build the pizza and display it
        Pizza customPizza = pizzaBuilder.build(); 

        x.println("Your custom pizza: " + customPizza);

        // Apply seasonal promotion and get the final price
        double finalPrice = customPizza.applySeasonalPromotion(0.75); // Apply seasonal discount

        // Display the discount information
        x.println("\n--- Seasonal Promotion Details ---");
        if (customPizza.getPrice() > finalPrice) {
            x.println("Seasonal Discount Applied!");
            x.println("Discounted Price: $" + finalPrice);
        } else {
            x.println("No seasonal discounts applied.");
        }

        // Print the final price after discount
        x.println("\nFinal price of your pizza: $" + finalPrice);

        // Option to save as favorite
        x.println("Do you want to save this pizza as a favorite? (yes/no)");
        if (x.inputString("").equalsIgnoreCase("yes")) {
            String pizzaName = x.inputString("Enter a name for your favorite pizza: ");
            favoritesManager.saveFavorite(pizzaName, customPizza);
        }

        // Display saved favorites
        x.println("\nWould you like to view your favorite pizzas? (yes/no)");
        if (x.inputString("").equalsIgnoreCase("yes")) {
            FavoritesManager.displayFavorites();
        }

        // Return to main menu
        Menu.displayMainMenu();
    }
}
