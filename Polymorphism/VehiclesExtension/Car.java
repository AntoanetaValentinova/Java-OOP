package VehiclesExtension;

import java.math.BigDecimal;

public class Car extends Vehicle {

    public Car(BigDecimal fuelQuantity, BigDecimal fuelConsumption, BigDecimal tankCapacity) {
        super(fuelQuantity, fuelConsumption.add(BigDecimal.valueOf(0.9)), tankCapacity);
    }


    @Override
    public void refuel(BigDecimal litters) {
        if (litters.compareTo(BigDecimal.valueOf(0))==1) {
            super.setFuelQuantity(super.getFuelQuantity().add(litters));
        } else {
            System.out.println("Fuel must be a positive number");
        }
    }
}
