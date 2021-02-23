package bakery.entities.drinks.interfaces;

public class Tea extends BaseDrink{
    public static final double teaPrice=2.50;
    public Tea(String name, int portion, String brand) {
        super(name, portion, teaPrice, brand);
    }
}
