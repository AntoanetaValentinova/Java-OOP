package VehiclesExtension;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Bus extends Vehicle{

    public Bus(BigDecimal fuelQuantity, BigDecimal fuelConsumption, BigDecimal tankCapacity) {
        super(fuelQuantity, fuelConsumption.add(BigDecimal.valueOf(1.4)), tankCapacity);
    }

    @Override
    public void refuel(BigDecimal litters) {
        if (litters.compareTo(BigDecimal.valueOf(0))==1) {
            super.setFuelQuantity(super.getFuelQuantity().add(litters));
        } else {
            System.out.println("Fuel must be a positive number");
        }
    }

    public void driveEmpty (BigDecimal distance){
        BigDecimal neededFuel = distance.multiply(this.getFuelConsumption().subtract(BigDecimal.valueOf(1.4)));
        if (super.getFuelQuantity().compareTo(neededFuel) == 1) {
            BigDecimal newFuelQuantity = this.getFuelQuantity().subtract(neededFuel);
            super.setFuelQuantity(newFuelQuantity);
            DecimalFormat decimalFormat = new DecimalFormat("####.##");
            System.out.printf("%s travelled %s km%n", this.getClass().getSimpleName(), decimalFormat.format(distance));
        } else {
            System.out.printf("%s needs refueling%n", this.getClass().getSimpleName());
        }
    }
}
