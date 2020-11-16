package HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] reservationInfo = scan.nextLine().split("\\s+");

        printPrice(reservationInfo);
    }

    private static void printPrice(String[] reservationInfo) {
        double pricePerDay= Double.parseDouble(reservationInfo[0]);
        int numberOfDays= Integer.parseInt(reservationInfo[1]);
        Season season=Season.valueOf(reservationInfo[2].toUpperCase());
        DiscountType discount=DiscountType.valueOf(reservationInfo[3].toUpperCase());

        PriceCalculator priceCalculator=new PriceCalculator(pricePerDay,numberOfDays,season,discount);
        System.out.printf("%.2f",priceCalculator.getPrice());
    }
}
