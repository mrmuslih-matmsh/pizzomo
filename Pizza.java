import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String crust;
    private String sauce;
    private String cheese;
    private List<String> toppings;
    private String size;
    private double price;
    private String description;

    public Pizza() {
    }

    private Pizza(Builder builder) {
        this.crust = builder.crust;
        this.sauce = builder.sauce;
        this.cheese = builder.cheese;
        this.toppings = builder.toppings;
        this.size = builder.size;
        this.price = builder.price;
    }

    public static class Builder {
        private String crust;
        private String sauce;
        private String cheese;
        private List<String> toppings = new ArrayList<>();
        private String size;
        private double price;

        private final double BASE_PRICE_SMALL = 5.0;
        private final double BASE_PRICE_MEDIUM = 8.0;
        private final double BASE_PRICE_LARGE = 12.0;
        private final double CRUST_EXTRA_COST = 1.0;
        private final double SAUCE_EXTRA_COST = 0.5;
        private final double CHEESE_EXTRA_COST = 1.5;
        private final double TOPPING_COST = 0.75;

        public Builder setSize(String size) {
            this.size = size;
            switch (size.toLowerCase()) {
                case "small":
                    this.price = BASE_PRICE_SMALL;
                    break;
                case "medium":
                    this.price = BASE_PRICE_MEDIUM;
                    break;
                case "large":
                    this.price = BASE_PRICE_LARGE;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid size");
            }
            return this;
        }

        public Builder setCrust(String crust) {
            this.crust = crust;
            this.price += CRUST_EXTRA_COST;
            return this;
        }

        public Builder setSauce(String sauce) {
            this.sauce = sauce;
            this.price += SAUCE_EXTRA_COST;
            return this;
        }

        public Builder setCheese(String cheese) {
            this.cheese = cheese;
            this.price += CHEESE_EXTRA_COST;
            return this;
        }

        public Builder addTopping(String topping) {
            this.toppings.add(topping);
            this.price += TOPPING_COST;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    public double getPrice() {
        return price;
    }

    public String getSize() {
        return size;
    }

    public String getDescription() {
        return description;
    }

    public String getCheese() {
        return cheese;
    }

    public String getCrust() {
        return crust;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getToppings() {
        return toppings;
    }
    

    @Override
    public String toString() {
        return "Pizza [size=" + size + ", crust=" + crust + ", sauce=" + sauce + ", cheese=" + cheese + ", toppings=" + toppings + "]";
    }

    public double applySeasonalPromotion(double toppingCost) {

        X x = new X();

        double finalPrice = this.price;

        if (size.equalsIgnoreCase("large")) {
            finalPrice *= 0.8;
            x.println("Seasonal Discount Applied! 20% off on Large Pizza.");
        }
        if (cheese.equalsIgnoreCase("Mozzarella") && !toppings.isEmpty()) {

            boolean hasVeggieTopping = toppings.stream().anyMatch(topping -> topping.equalsIgnoreCase("Peppers") 
            || topping.equalsIgnoreCase("Mushrooms") || topping.equalsIgnoreCase("Olives"));
            if (hasVeggieTopping) {
                x.println("Free extra topping for your Veggie Pizza!");
                finalPrice -= toppingCost;
            }
        }

        return finalPrice;
    }
}
