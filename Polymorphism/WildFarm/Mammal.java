package WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal{
    private String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat=new DecimalFormat("####.##");
        return String.format("%s[%s, %s, %s, %d]",getClass().getSimpleName(),super.getAnimalName(),decimalFormat.format(super.getAnimalWeight()),this.livingRegion,super.getFoodEaten());
    }
}
