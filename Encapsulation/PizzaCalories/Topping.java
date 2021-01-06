package PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setWeight(double weight) {
        if (weight<1||weight>50) {
            throw new IllegalArgumentException(this.toppingType+" weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    private void setToppingType(String toppingType) {
        if (!toppingType.equals("Meat")&&!toppingType.equals("Veggies")&&!toppingType.equals("Cheese")&&!toppingType.equals("Sauce")) {
          throw new IllegalArgumentException("Cannot place "+toppingType+" on top of your pizza.");
        }
        this.toppingType = toppingType;
    }

    public double calculateCalories () {
        double calories=2*this.weight;
        if (toppingType.equals("Meat")) {
            calories*=1.2;
        } else if (toppingType.equals("Veggies")) {
            calories*=0.8;
        } else if (toppingType.equals("Cheese")) {
            calories*=1.1;
        } else if (toppingType.equals("Sauce")) {
            calories*=0.9;
        }
        return calories;
    }
}
