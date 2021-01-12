package VehiclesExtension;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] carInfo = scan.nextLine().split("\\s+");
        Vehicle car = new Car(BigDecimal.valueOf(Double.parseDouble(carInfo[1])), BigDecimal.valueOf(Double.parseDouble(carInfo[2])),BigDecimal.valueOf(Double.parseDouble(carInfo[3])));
        String[] truckInfo = scan.nextLine().split("\\s+");
        Vehicle truck = new Truck(BigDecimal.valueOf(Double.parseDouble(truckInfo[1])), BigDecimal.valueOf(Double.parseDouble(truckInfo[2])), BigDecimal.valueOf(Double.parseDouble(truckInfo[3])));
        String[] busInfo = scan.nextLine().split("\\s+");
        Bus bus = new Bus(BigDecimal.valueOf(Double.parseDouble(busInfo[1])), BigDecimal.valueOf(Double.parseDouble(busInfo[2])), BigDecimal.valueOf(Double.parseDouble(busInfo[3])));

        int n= Integer.parseInt(scan.nextLine());

        for (int i = 0; i <n ; i++) {
            String [] tokens=scan.nextLine().split("\\s+");
            String command=tokens[0];
            String vehicle=tokens[1];
            if (command.equals("Drive")) {
                if (vehicle.equals("Car")) {
                    BigDecimal distance=BigDecimal.valueOf(Double.parseDouble(tokens[2]));
                    car.drive(distance);
                } else if (vehicle.equals("Truck")) {
                    BigDecimal distance=BigDecimal.valueOf(Double.parseDouble(tokens[2]));
                    truck.drive(distance);
                } else if (vehicle.equals("Bus")) {
                    BigDecimal distance=BigDecimal.valueOf(Double.parseDouble(tokens[2]));
                    bus.drive(distance);
                }
            } else if (command.equals("Refuel")) {
                if (vehicle.equals("Car")) {
                    BigDecimal litters=BigDecimal.valueOf(Double.parseDouble(tokens[2]));
                    car.refuel(litters);
                } else if (vehicle.equals("Truck")) {
                    BigDecimal litters=BigDecimal.valueOf(Double.parseDouble(tokens[2]));
                    truck.refuel(litters);
                } else if (vehicle.equals("Bus")) {
                    BigDecimal litters=BigDecimal.valueOf(Double.parseDouble(tokens[2]));
                    bus.refuel(litters);
                }
            } else if (command.equals("DriveEmpty")) {
                BigDecimal litters=BigDecimal.valueOf(Double.parseDouble(tokens[2]));
                bus.driveEmpty(litters);
            }
        }

        System.out.printf("Car: %.2f%nTruck: %.2f%nBus: %.2f",car.getFuelQuantity(),truck.getFuelQuantity(),bus.getFuelQuantity());
    }
}
