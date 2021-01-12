package Vehicles;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Truck extends Vehicle{

    public Truck(BigDecimal fuelQuantity, BigDecimal fuelConsumption) {
        super(fuelQuantity, fuelConsumption.add(BigDecimal.valueOf(1.6)));
    }


    @Override
    public void refuel(BigDecimal litters) {
        BigDecimal correctRefuel = litters.multiply(BigDecimal.valueOf(0.95));
        super.setFuelQuantity(super.getFuelQuantity().add(correctRefuel));
    }
}
