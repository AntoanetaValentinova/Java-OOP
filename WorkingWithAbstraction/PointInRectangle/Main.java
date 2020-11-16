package PointInRectangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] coordinatesInfo=scan.nextLine().split("\\s+");
        Point bottomLeft=new Point(Integer.parseInt(coordinatesInfo[0]), Integer.parseInt(coordinatesInfo[1]));
        Point topRight=new Point(Integer.parseInt(coordinatesInfo[2]), Integer.parseInt(coordinatesInfo[3]));

        int numberOfPointsToCheck= Integer.parseInt(scan.nextLine());

        Rectangle rectangle=new Rectangle(bottomLeft,topRight);
        checkCurrentPoint(scan, numberOfPointsToCheck, rectangle);
    }

    private static void checkCurrentPoint(Scanner scan, int numberOfPointsToCheck, Rectangle rectangle) {
        for (int i = 0; i <numberOfPointsToCheck ; i++) {
            String [] currentPointCoordinates=scan.nextLine().split("\\s+");
            Point point=new Point(Integer.parseInt(currentPointCoordinates[0]), Integer.parseInt(currentPointCoordinates[1]));
            System.out.println(rectangle.contains(point));
        }
    }
}
