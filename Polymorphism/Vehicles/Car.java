package Vehicles;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Car extends Vehicle{

    public Car(BigDecimal fuelQuantity, BigDecimal fuelConsumption) {
        super(fuelQuantity, fuelConsumption.add(BigDecimal.valueOf(0.9)));
    }


    @Override
    public void refuel(BigDecimal litters) {
        super.setFuelQuantity(super.getFuelQuantity().add(litters));
    }
}
