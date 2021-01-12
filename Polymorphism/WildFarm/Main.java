package WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input=scan.nextLine();

        List<Animal> animals=new ArrayList<>();

        while (!input.equals("End")) {
            String [] animalInfo=input.split("\\s+");
            String animalType=animalInfo[0];
            String animalName=animalInfo[1];
            Double animalWeight=Double.parseDouble(animalInfo[2]);
            String livingRegion=animalInfo[3];
            Food food = getFood(scan);
            input = addAnimal(scan, animalInfo, animalType, animalName, animalWeight, livingRegion, food,animals);
        }

        printAnimals(animals);
    }

    private static void printAnimals(List<Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    private static String addAnimal(Scanner scan, String[] animalInfo, String animalType, String animalName, Double animalWeight, String livingRegion, Food food, List<Animal> animals) {
        String input;
        if (animalType.equals("Cat")) {
            addCat(animalInfo[4], animalType, animalName, animalWeight, livingRegion, food,animals);
        } else if (animalType.equals("Mouse")) {
            addMouse(animalType, animalName, animalWeight, livingRegion, food,animals);
        } else if (animalType.equals("Tiger")) {
            addTiger(animalType, animalName, animalWeight, livingRegion, food,animals);
        } else if (animalType.equals("Zebra")) {
            addZebra(animalType, animalName, animalWeight, livingRegion, food, animals);
        }
        input=scan.nextLine();
        return input;
    }

    private static void addZebra(String animalType, String animalName, Double animalWeight, String livingRegion, Food food,List<Animal>animals) {
        Animal zebra=new Zebra(animalName,animalType,animalWeight,livingRegion);
        zebra.makeSound();
        zebra.eat(food);
        animals.add(zebra);
    }

    private static void addTiger(String animalType, String animalName, Double animalWeight, String livingRegion, Food food,List<Animal> animals) {
        Animal tiger=new Tiger(animalName,animalType,animalWeight,livingRegion);
        tiger.makeSound();
        tiger.eat(food);
        animals.add(tiger);
    }

    private static void addMouse(String animalType, String animalName, Double animalWeight, String livingRegion, Food food,List<Animal> animals) {
        Animal mouse=new Mouse(animalName,animalType,animalWeight,livingRegion);
        mouse.makeSound();
        mouse.eat(food);
        animals.add(mouse);
    }

    private static void addCat(String catBreed1, String animalType, String animalName, Double animalWeight, String livingRegion, Food food,List<Animal> animals) {
        String catBreed= catBreed1;
        Animal cat=new Cat(animalName,animalType,animalWeight,livingRegion,catBreed);
        cat.makeSound();
        cat.eat(food);
        animals.add(cat);
    }

    private static Food getFood(Scanner scan) {
        String [] foodInfo=scan.nextLine().split("\\s+");
        String foodType=foodInfo[0];
        Integer quantity= Integer.parseInt(foodInfo[1]);
        Food food=null;
        if (foodType.equals("Meat")) {
            food=new Meat(quantity);
        } else if (foodType.equals("Vegetable")) {
            food=new Vegetable(quantity);
        }
        return food;
    }
}
