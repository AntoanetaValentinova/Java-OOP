package VehiclesExtension;

import java.math.BigDecimal;

public class Truck extends Vehicle {

    public Truck(BigDecimal fuelQuantity, BigDecimal fuelConsumption,BigDecimal tankCapacity) {
        super(fuelQuantity, fuelConsumption.add(BigDecimal.valueOf(1.6)),tankCapacity);
    }


    @Override
    public void refuel(BigDecimal litters) {
        if (litters.compareTo(BigDecimal.valueOf(0))==1) {
            BigDecimal correctRefuel = litters.multiply(BigDecimal.valueOf(0.95));
            super.setFuelQuantity(super.getFuelQuantity().add(correctRefuel));
        } else {
            System.out.println("Fuel must be a positive number");
        }
    }
}
