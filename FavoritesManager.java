import java.util.HashMap;
import java.util.Map;

public class FavoritesManager {

    X x = new X();

    private static Map<String, Pizza> favoritePizzas = new HashMap<>();

    public void saveFavorite(String name, Pizza pizza) {
        favoritePizzas.put(name, pizza);
        x.println("Your pizza has been customized and saved as '" + name + "'!");
    }

    public Pizza getFavorite(String name) {
        return favoritePizzas.get(name);
    }

    public static void displayFavorites() {

        X x = new X();

        User user = new User("Muslih", 1200);
        
        if (favoritePizzas.isEmpty()) {
            x.println("No favorite pizzas found.");
            Menu.displayMainMenu();
        } else {
            x.println("Username: " + user.getUsername());
            x.println("Your Favorite Pizzas:");
            favoritePizzas.forEach((name, pizza) -> {
                x.println(name + ": " + pizza.toString());
            });
        }
    }
}
