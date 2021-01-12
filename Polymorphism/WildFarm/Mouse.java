package WildFarm;

public class Mouse extends Mammal{
    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Vegetable")) {
            super.setFoodEaten(super.getFoodEaten()+food.getQuantity());
        } else {
            System.out.printf("Mice are not eating that type of food!%n",super.getAnimalType());
        }
    }
}
