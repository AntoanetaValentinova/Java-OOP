package WildFarm;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;

    public Animal(String animalName, String animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    public abstract void makeSound();
    public abstract void eat (Food food);

    public void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }

    public String getAnimalName() {
        return animalName;
    }

    public Double getAnimalWeight() {
        return animalWeight;
    }

    public String getAnimalType() {
        return animalType;
    }
}
