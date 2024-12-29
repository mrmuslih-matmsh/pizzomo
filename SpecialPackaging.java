public class SpecialPackaging extends PizzaDecorator {

    public SpecialPackaging(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", with special packaging";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 2.00;  // Add packaging fee
    }
}

