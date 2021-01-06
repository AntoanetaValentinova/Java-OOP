package PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] pizzaInfo=scan.nextLine().split("\\s+");
        String name=pizzaInfo[1];
        int toppingsNumber= Integer.parseInt(pizzaInfo[2]);
        Pizza pizza=new Pizza(name,toppingsNumber);

        String [] doughInfo=scan.nextLine().split("\\s+");
        String flourType=doughInfo[1];
        String bakingTechnique=doughInfo[2];
        double weightInGrams=Double.parseDouble(doughInfo[3]);

        Dough dough=new Dough(flourType,bakingTechnique,weightInGrams);
        pizza.setDough(dough);

        String input=scan.nextLine();

        while (!input.equals("END")) {
            String [] toppingInfo=input.split("\\s+");
            String toppingType=toppingInfo[1];
            double weight=Double.parseDouble(toppingInfo[2]);
            Topping topping=new Topping(toppingType,weight);
            pizza.addTopping(topping);
            input=scan.nextLine();
        }

        System.out.printf("%s - %.2f",pizza.getName(),pizza.getOverallCalories());
    }
}
