package Shapes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Shape circle=new Circle(13.0);
        Shape rectangle=new Rectangle(4.0,6.0);

        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());

        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());

    }
}
