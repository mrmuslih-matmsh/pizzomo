public class PlaceOrder {

    private static User user = new User("Muslih", 2000);
    private static OrderTracker orderTracker = new OrderTracker();

    public static void displayPlaceOrder() {
        X x = new X();
        FavoritesManager favoritesManager = new FavoritesManager();
        Pizza pizza = null;
        double totalAmount = 0;

        // Ask the user to choose between saved favorite pizza or create a new pizza
        int choice = Integer.parseInt(x
                .inputString("Do you want to order a saved favorite pizza or create a new one? (1. Saved | 2. New): "));

        if (choice == 1) {
            // Handle saved favorite pizza
            x.println("Choose your favorite pizza:");
            FavoritesManager.displayFavorites();
            String favoriteName = x.inputString("");
            pizza = favoritesManager.getFavorite(favoriteName);
            if (pizza == null) {
                x.println("Favorite pizza not found. Please try again.");
                return;
            }
        } else if (choice == 2) {
            // Handle new pizza creation using handlers (Chain of Responsibility)
            Pizza.Builder pizzaBuilder = new Pizza.Builder();
            double totalAmountBuilder = 0;

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

            // Start the customization chain
            sizeHandler.handleCustomization(pizzaBuilder, x); // User input for size, crust, sauce, etc.

            pizza = pizzaBuilder.build(); // Build the pizza with user choices
            totalAmount = pizza.getPrice(); // Get the price of the pizza based on customization

            // // Extra Topping Option
            // int extraToppingChoice = Integer
            //         .parseInt(x.inputString("Would you like extra toppings? (1. Yes | 2. No): "));
            // if (extraToppingChoice == 1) {
            //     String toppingName = x.inputString("Enter topping name (Additional $2.50): ");
            //     pizza = new ExtraTopping(pizza, toppingName, 2.50);
            // }

            // // Special Packaging Option
            // int packagingChoice = Integer
            //         .parseInt(x.inputString("Would you like special packaging? (1. Yes | 2. No): "));
            // if (packagingChoice == 1) {
            //     pizza = new SpecialPackaging(pizza);
            // }

            // Ask user if they want to save the pizza as a favorite
            int saveChoice = Integer
                    .parseInt(x.inputString("Would you like to save this pizza to your favorites? (1. Yes | 2. No): "));
            if (saveChoice == 1) {
                String pizzaName = x.inputString("Enter a name for this pizza: ");
                favoritesManager.saveFavorite(pizzaName, pizza);
            }
        }

        // Handle delivery options
        int deliveryChoice = Integer
                .parseInt(x.inputString("Choose delivery option: 1. Pickup (Free) | 2. Delivery ($5): "));
        String deliveryOption = deliveryChoice == 1 ? "Pickup" : "Delivery";
        String deliveryAddress = "";
        if (deliveryChoice == 2) {
            deliveryAddress = x.inputString("Enter delivery address: ");
            totalAmount += 5; // Delivery fee
        }

        // Apply seasonal promotion and update total amount
        double finalPrice = pizza.applySeasonalPromotion(0.75);
        x.println("\n--- Seasonal Promotion Details ---");
        if (pizza.getPrice() > finalPrice) {
            x.println("Seasonal Discount Applied!");
            if (pizza.getSize().equalsIgnoreCase("Large")) {
                x.println("Discount on Large Pizza: 20% off");
                x.println("Discounted Price: $" + finalPrice);
            }
            if (finalPrice < pizza.getPrice()) {
                x.println("Free extra topping applied!");
            }
        } else {
            x.println("No seasonal discounts applied.");
        }

        totalAmount = finalPrice;
        x.println("Total amount after discount: $" + totalAmount);

        // Handle payment options
        int paymentChoice = Integer
                .parseInt(x.inputString("Payment Options: 1. Credit Card | 2. Digital Wallet | 3. Loyalty Points: "));
        PaymentMethod paymentMethod = null;
        switch (paymentChoice) {
            case 1 -> {
                String cardNumber = x.inputString("Enter card number: ");
                String expiryDate = x.inputString("Enter expiry date (MM/YY): ");
                String cvv = x.inputString("Enter CVV: ");
                paymentMethod = new CreditCardPayment(cardNumber, expiryDate, cvv);
            }
            case 2 -> {
                String walletId = x.inputString("Enter wallet ID: ");
                paymentMethod = new DigitalWalletPayment(walletId);
            }
            case 3 -> {
                int points = Integer.parseInt(x.inputString("Enter loyalty points: "));
                paymentMethod = new LoyaltyPointsPayment(user.getLoyaltyPoints(), points);
            }
            default -> x.println("Invalid payment method.");
        }

        paymentMethod.processPayment(totalAmount); // Process the payment

        // Create an order and track it
        Order order = new Order(pizza, deliveryAddress);
        order.generateOrderId();
        orderTracker.addOrder(order);
        order.setStatus("Your order is being prepared.");

        x.println("Order placed successfully! Your Order ID is: " + order.getOrderId());
        x.println("Order details: " + pizza + "\nTotal Amount: $" + totalAmount);

        Menu.displayMainMenu();
    }

    public static void trackOrder() {
        X x = new X();

        // Prompt user for Order ID
        String orderId = x.inputString("Enter your Order ID to track your order:");

        // Retrieve the order using the provided Order ID
        Order order = orderTracker.getOrder(orderId);

        if (order == null) {
            x.print("Order not found. Please check your Order ID.");
            trackOrder(); // Recursively call trackOrder if the order is not found
            return;
        }

        // Display order details
        x.print("Order ID: " + order.getOrderId());
        x.print("Status: " + order.getStatus());
        x.print("Estimated delivery time: " + order.getEstimatedDeliveryTime() + " minutes.");

        // Prompt user to advance the order state
        String choice = x.inputString("Do you want to advance the order state? (yes/no)");
        if (choice.equalsIgnoreCase("yes")) {
            order.handleOrder();
            Menu.displayMainMenu(); // Navigate to the main menu
        }
    }
}
