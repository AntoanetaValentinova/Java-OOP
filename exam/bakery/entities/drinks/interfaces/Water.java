package bakery.entities.drinks.interfaces;

public class Water extends BaseDrink{
    public static final double waterPrice=1.50;
    public Water(String name, int portion,  String brand) {
        super(name, portion, waterPrice, brand);
    }
}
