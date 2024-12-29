
public class Menu {

    public static void displayMainMenu() {

        X x = new X();

        x.println("=======================================");
        x.println("          Welcome to Pizzomo           ");
        x.println("=======================================");
        x.println("Please choose an option from the menu:");
        x.println("1. Customize a Pizza");
        x.println("2. Place an Order");
        x.println("3. Track Your Order");
        x.println("4. View Your Favorites");
        x.println("5. Payment & Loyalty Program");
        x.println("6 Provide Feedback");
        x.println("7 Seasonal Specials & Promotions");
        x.println("8 Exit");
        x.println("=======================================");
        int choice = x.inputInt("Enter the number corresponding to your choice: ");
        x.println("=======================================");

        switch (choice) {
            case 1:
                CustomizePizza.displayCustomize();
                break;
            case 2:
                PlaceOrder.displayPlaceOrder();
                break;
            case 3:
                PlaceOrder.trackOrder();
                break;
            case 4:
                FavoritesManager.displayFavorites();
                break;
            case 5:
                PaymentAndLoyaltyTest.displayPaymentandLoyalty();
                break;
            case 6:
                ProvideFeedback.displayProvideFeedback();
                break;
            case 7:
                Promotions.displayPromotions();
                break;
            case 8:
                x.println("Thank you for visiting Pizzomo!");
                x.println("=======================================");
                System.exit(0);
                break;
            default:
                x.println("Invalid choice. Please select a valid option.");
                displayMainMenu();
        }
    }
}
