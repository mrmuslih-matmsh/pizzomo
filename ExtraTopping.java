public class ExtraTopping extends PizzaDecorator {
    private String toppingName;
    private double toppingPrice;

    public ExtraTopping(Pizza pizza, String toppingName, double toppingPrice) {
        super(pizza);
        this.toppingName = toppingName;
        this.toppingPrice = toppingPrice;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", with extra " + toppingName;
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + toppingPrice;  // Increase price for the topping
    }
}

