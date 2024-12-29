public class ToppingHandler extends CustomizationHandler {
    @Override
    public void handleCustomization(Pizza.Builder pizzaBuilder, X x) {
        x.println("Choose your toppings (each topping costs $0.5). Type 'done' to finish:");
        String topping;
        while (!(topping = x.inputString("Enter topping (or type 'done'): ")).equalsIgnoreCase("done")) {
            pizzaBuilder.addTopping(topping);
            pizzaBuilder.setPrice(pizzaBuilder.getPrice() + 0.5);
        }

        if (nextHandler != null) {
            nextHandler.handleCustomization(pizzaBuilder, x);
        }
    }
}

