package VehiclesExtension;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public abstract class Vehicle {
    private BigDecimal fuelQuantity;
    private BigDecimal fuelConsumption;
    private BigDecimal tankCapacity;

    public Vehicle(BigDecimal fuelQuantity, BigDecimal fuelConsumption, BigDecimal tankCapacity) {
        this.fuelQuantity=fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    protected BigDecimal getFuelConsumption() {
        return fuelConsumption;
    }

    protected void setFuelConsumption(BigDecimal fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public BigDecimal getFuelQuantity() {
        return fuelQuantity;
    }

    protected void setFuelQuantity(BigDecimal fuelQuantity) {
       if (fuelQuantity.compareTo(this.tankCapacity) == 1) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            this.fuelQuantity = fuelQuantity;
        }
    }

    public void drive(BigDecimal distance) {
        BigDecimal neededFuel = distance.multiply(this.getFuelConsumption());
        if (this.fuelQuantity.compareTo(neededFuel) == 1) {
            BigDecimal newFuelQuantity = this.getFuelQuantity().subtract(neededFuel);
            this.fuelQuantity = newFuelQuantity;
            DecimalFormat decimalFormat = new DecimalFormat("####.##");
            System.out.printf("%s travelled %s km%n", this.getClass().getSimpleName(), decimalFormat.format(distance));
        } else {
            System.out.printf("%s needs refueling%n", this.getClass().getSimpleName());
        }
    }

    public abstract void refuel(BigDecimal litters);

}
